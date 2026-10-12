package ma.youcode.clickTracker.repository.impl;

import ma.youcode.clickTracker.model.Link;
import ma.youcode.clickTracker.repository.LinkRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class InMemoryLinkRepository implements LinkRepository {

    private static final Log log = LogFactory.getLog(InMemoryLinkRepository.class);
    private final List<Link> links = new ArrayList<>();
    private long nextId = 1;

    @Override
    public synchronized List<Link> findAll() {
        return new ArrayList<>(links);
    }

    @Override
    public synchronized Optional<Link> findById(Long id) {

        return links.stream()
                .filter(l -> l.getId().equals(id))
                .findFirst();
    }

    public synchronized List<Link> findByPublisherId(Long publisherId){

        return links.stream()
                .filter(l -> l.getPublisherId().equals(publisherId))
                .toList();
    }

    @Override
    public synchronized void incrementClicks(Long id) {

        Optional<Link> linkOpt =  findById(id);

        if(linkOpt.isEmpty()){
            throw new NoSuchElementException("Lien introuvable");
        }
        Link link = linkOpt.get();

        link.incrementClicks();
    }

    @Override
    public synchronized void save(Link link){

        if(link == null){
            throw new IllegalArgumentException("Lien null");
        }

        if(link.getId() != null){
            throw new IllegalArgumentException("Lien deja enregistre");
        }

        link.setId(nextId++);

        links.add(link);
    }
}
