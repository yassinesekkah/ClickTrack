package ma.youcode.clickTracker.repository.impl;

import ma.youcode.clickTracker.model.Publisher;
import ma.youcode.clickTracker.repository.PublisherRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryPublisherRepository implements PublisherRepository {

    private final List<Publisher> publishers = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public synchronized List<Publisher> findAll() {
        return new ArrayList<>(publishers);
    }

    @Override
    public synchronized Optional<Publisher> findById(Long id) {

        return publishers.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    @Override
    public synchronized void save(Publisher publisher) {

        publisher.setId(nextId++);

        publishers.add(publisher);
    }
}
