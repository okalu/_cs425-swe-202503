package edu.miu.cs.cs425.citylibraryapp.service.impl;

import edu.miu.cs.cs425.citylibraryapp.model.Publisher;
import edu.miu.cs.cs425.citylibraryapp.repository.PublisherRepository;
import edu.miu.cs.cs425.citylibraryapp.service.PublisherService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PublisherServiceImpl implements PublisherService {

//    @Autowired
    private final PublisherRepository publisherRepository;

//    @Autowired
    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Publisher registerNewPublisher(@Valid Publisher newPublisher) throws Exception {
        return publisherRepository.save(newPublisher);
    }

    @Override
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher getPublisherById(Integer id) {
        return publisherRepository.findById(id)
                .orElse(null);
    }

    @Override
    public Publisher updatePublisher(Publisher editedPublisher) {
        return publisherRepository.save(editedPublisher);
    }

    @Override
    public void deletePublisherById(Integer id) {
        publisherRepository.deleteById(id);
    }
}
