package ma.youcode.clickTracker.controller;

import ma.youcode.clickTracker.model.Link;
import ma.youcode.clickTracker.model.Publisher;
import ma.youcode.clickTracker.service.LinkService;
import ma.youcode.clickTracker.service.PublisherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/publishers")
public class PublisherController{

    private final PublisherService publisherService;
    private final LinkService linkService;

    public PublisherController(PublisherService publisherService, LinkService linkService) {
        this.publisherService = publisherService;
        this.linkService = linkService;
    }

    @GetMapping
    public ResponseEntity<List<Publisher>> findAll() {

        return ResponseEntity.ok(publisherService.findAll());
    }

    @PostMapping("/{id}/liens")
    public ResponseEntity<Link> createLink(@PathVariable("id") Long id, @RequestBody Link link){

        Link createdLink = linkService.createLink(id, link);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdLink);
    }

    @GetMapping("/{id}/liens")
    public ResponseEntity<List<Link>> findLinksByPublisherId(@PathVariable("id") Long id){

        List<Link> publisherLinks = linkService.findByPublisherId(id);

        return ResponseEntity.ok(publisherLinks);
    }
}
