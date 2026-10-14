package ma.youcode.clickTracker.service.impl;

import ma.youcode.clickTracker.model.Publisher;
import ma.youcode.clickTracker.repository.PublisherRepository;
import ma.youcode.clickTracker.service.PublisherService;

import java.util.List;
import java.util.Optional;

public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository){
        this.publisherRepository = publisherRepository;
    }

    @Override
    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }

    @Override
    public Optional<Publisher> findById(Long id) {
        return publisherRepository.findById(id);
    }
}
