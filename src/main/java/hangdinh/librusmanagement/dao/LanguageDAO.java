package hangdinh.librusmanagement.dao;

import hangdinh.librusmanagement.model.Language;
import hangdinh.librusmanagement.model.Publisher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static hangdinh.librusmanagement.connection.Connection.getConnection;

public class LanguageDAO implements ILanguageDAO {
    private static final String SELECT_LANGUAGE_BY_ID = "SELECT * FROM language WHERE  id =?";
    private static final String SELECT_ALL_LANGUAGE = "SELECT * FROM language";

    @Override
    public Language selectLanguage(int id) {
        Language language = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LANGUAGE_BY_ID);) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                language = getLanguage(rs);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return language;
    }


    private Language getLanguage(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String languageName = rs.getString("language");
        return new Language(id, languageName);
    }

    @Override
    public List<Language> selectAllLanguage() {
        List<Language> listLanguage = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_LANGUAGE);) {
            System.out.println(this.getClass() + "SELECT_ALL_LANGUAGE :" + preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Language language = getLanguage(rs);
                listLanguage.add(language);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return listLanguage;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
