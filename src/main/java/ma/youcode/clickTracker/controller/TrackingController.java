package ma.youcode.clickTracker.controller;

import ma.youcode.clickTracker.dto.TrackingResponse;
import ma.youcode.clickTracker.model.Link;
import ma.youcode.clickTracker.repository.LinkRepository;
import ma.youcode.clickTracker.service.LinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/t")
public class TrackingController {

    private final LinkService linkService;

    public TrackingController(LinkService linkService){
        this.linkService = linkService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrackingResponse> trackingClicks(@PathVariable("id") Long id){

        TrackingResponse link = linkService.trackClick(id);

        return ResponseEntity.ok(link);
    }
}
