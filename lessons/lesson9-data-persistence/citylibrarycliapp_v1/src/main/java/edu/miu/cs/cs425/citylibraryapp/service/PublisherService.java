package edu.miu.cs.cs425.citylibraryapp.service;

import edu.miu.cs.cs425.citylibraryapp.model.Publisher;

import java.util.List;

public interface PublisherService {

    Publisher registerNewPublisher(Publisher publisher) throws Exception;
    List<Publisher> getAllPublishers();
    Publisher getPublisherById(Integer id);
    Publisher updatePublisher(Publisher editedPublisher);
    void deletePublisherById(Integer id);

}
