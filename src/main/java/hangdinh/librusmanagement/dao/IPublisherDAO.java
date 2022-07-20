package hangdinh.librusmanagement.dao;

import hangdinh.librusmanagement.model.Language;
import hangdinh.librusmanagement.model.Publisher;

import java.util.List;

public interface IPublisherDAO {
    public Publisher selectPublisher(int id);
    public List<Publisher> selectAllPublisher();
}
