package ma.youcode.clickTracker.repository;

import ma.youcode.clickTracker.model.Link;

import java.util.List;
import java.util.Optional;

public interface LinkRepository {

    List<Link> findAll();
    Optional<Link> findById(Long id);
    List<Link> findByPublisherId(Long publisherId);
    void incrementClicks(Long id);
    void save(Link link);
}
