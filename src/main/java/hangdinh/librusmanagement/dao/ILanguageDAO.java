package hangdinh.librusmanagement.dao;

import hangdinh.librusmanagement.model.Language;

import java.util.List;

public interface ILanguageDAO {
    public Language selectLanguage(int id);
    public List<Language> selectAllLanguage();

}
