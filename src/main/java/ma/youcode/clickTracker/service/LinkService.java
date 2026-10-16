package ma.youcode.clickTracker.service;

import ma.youcode.clickTracker.dto.OffreStatsResponse;
import ma.youcode.clickTracker.dto.TrackingResponse;
import ma.youcode.clickTracker.model.Link;

import java.util.List;
import java.util.Map;

public interface LinkService {

    Link createLink(Long id,Link link);
    List<Link> findByPublisherId(Long id);
    List<OffreStatsResponse> findOffresByPublisherId (Long id);
    TrackingResponse trackClick(Long id);
}
