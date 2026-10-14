package ma.youcode.clickTracker.service.impl;

import ma.youcode.clickTracker.model.Link;
import ma.youcode.clickTracker.repository.LinkRepository;
import ma.youcode.clickTracker.repository.PublisherRepository;
import ma.youcode.clickTracker.service.LinkService;

import java.util.List;
import java.util.NoSuchElementException;

public class LinkServiceImpl implements LinkService {

    private final LinkRepository linkRepository;
    private final PublisherRepository publisherRepository;

    public LinkServiceImpl(LinkRepository linkRepository, PublisherRepository publisherRepository){
        this.linkRepository = linkRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Link createLink(Long publisherId, Link link) {

        if(link == null){
            throw new IllegalArgumentException("lien obligatoire");
        }

        //check if publisher exists
        if(publisherRepository.findById(publisherId).isEmpty()){

            throw new NoSuchElementException("Publisher introuvable");
        }

        Link newLink = new Link(
                link.getUrlDestination(),
                link.getOffre(),
                publisherId
        );

        linkRepository.save(newLink);

        return newLink;
    }

    public List<Link> findByPublisherId(Long id){

        if(publisherRepository.findById(id).isEmpty()){
            throw new NoSuchElementException("Publisher introuvable");
        }

        return linkRepository.findByPublisherId(id);
    }
}
