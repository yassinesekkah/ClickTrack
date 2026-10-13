package ma.youcode.clickTracker.service;

import ma.youcode.clickTracker.model.Publisher;

import java.util.List;
import java.util.Optional;

public interface PublisherService {

    List<Publisher> findAll();

    Optional<Publisher> findById(Long id);
}
