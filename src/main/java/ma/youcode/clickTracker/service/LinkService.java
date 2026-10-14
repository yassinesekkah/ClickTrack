package ma.youcode.clickTracker.service;

import ma.youcode.clickTracker.model.Link;

import java.util.List;

public interface LinkService {

    Link createLink(Long id,Link link);
    List<Link> findByPublisherId(Long id);
}
