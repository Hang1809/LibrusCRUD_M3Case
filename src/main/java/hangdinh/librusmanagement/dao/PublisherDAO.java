package hangdinh.librusmanagement.dao;

import hangdinh.librusmanagement.model.Publisher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static hangdinh.librusmanagement.connection.Connection.getConnection;

public class PublisherDAO implements IPublisherDAO{

    private static final String SELECT_PUBLISHER_BY_ID = "SELECT * FROM publisher WHERE  id =?";
    private static final String SELECT_ALL_PUBLISHER = "SELECT * FROM publisher";

    @Override
    public Publisher selectPublisher(int id) {
        Publisher publisher = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PUBLISHER_BY_ID);) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String publisherName = rs.getString("publisher");

                publisher = new Publisher(id, publisherName);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return publisher;

    }

    @Override
    public List<Publisher> selectAllPublisher() {
        List<Publisher> listPublisher = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PUBLISHER);) {
            System.out.println(this.getClass() + "selectAllPublisher :" + preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("publisher");
                listPublisher.add(new Publisher(id, name));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return listPublisher;

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
