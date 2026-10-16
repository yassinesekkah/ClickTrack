package ma.youcode.clickTracker.service.impl;

import ma.youcode.clickTracker.dto.OffreStatsResponse;
import ma.youcode.clickTracker.dto.TrackingResponse;
import ma.youcode.clickTracker.model.Link;
import ma.youcode.clickTracker.model.Publisher;
import ma.youcode.clickTracker.repository.LinkRepository;
import ma.youcode.clickTracker.repository.PublisherRepository;
import ma.youcode.clickTracker.service.LinkService;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

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

    private Map<String, List<Link>> groupedOffersByPublisherId(Long publisherId){

        List<Link> publisherLinks = findByPublisherId(publisherId);

        return publisherLinks.stream()
                .collect(Collectors.groupingBy(l -> l.getOffre()));

    }

    private List<OffreStatsResponse> buildOffreStatsResponses (Map<String, List<Link>> grouped){

        return grouped.entrySet().stream()
                .map(g -> {

                    String offre = g.getKey();
                    List<Link> links = g.getValue();

                    int nombredeLinks = links.size();

                    int clicks = links.stream()
                            .mapToInt(l -> l.getClicks())
                            .sum();

                    return new OffreStatsResponse(nombredeLinks, offre, clicks);
                })
                .toList();
    }

    public List<OffreStatsResponse> findOffresByPublisherId (Long id){

        Map<String, List<Link>> groupped = groupedOffersByPublisherId(id);
        return buildOffreStatsResponses(groupped);
    }

    public TrackingResponse trackClick(Long id){

         Link link = linkRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Lien Introuvable"));

         Long publisherId = link.getPublisherId();

         Publisher publisher = publisherRepository.findById(publisherId)
                 .orElseThrow(() -> new NoSuchElementException("publisher Introuvable"));

         linkRepository.incrementClicks(id);

        String urlRedirection = link.getUrlDestination();
        String publisherName = publisher.getNom() + " " + publisher.getPrenom();

        String offre = link.getOffre();
        int clicks = link.getClicks();

        return new TrackingResponse(urlRedirection, publisherName, offre, clicks);

    }
}
