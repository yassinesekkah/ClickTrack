package ma.youcode.clickTracker.repository;

import ma.youcode.clickTracker.model.Publisher;

import java.util.List;
import java.util.Optional;

public interface PublisherRepository {

    List<Publisher> findAll();
    Optional<Publisher> findById(Long id);
    void save(Publisher publisher);
}
