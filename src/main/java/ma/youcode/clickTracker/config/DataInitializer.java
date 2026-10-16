package ma.youcode.clickTracker.config;

import ma.youcode.clickTracker.model.Publisher;
import ma.youcode.clickTracker.model.Category;
import ma.youcode.clickTracker.repository.PublisherRepository;

public class DataInitializer {

    private final PublisherRepository publisherRepository;

    public DataInitializer(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public void init() {

        Publisher p1 = new Publisher(
                "Sekkah",
                "Ismail",
                "ismail@gmail.com",
                Category.INFLUENCEUR
        );

        Publisher p2 = new Publisher(
                "Sekkah",
                "Outmane",
                "outmane@gmail.com",
                Category.BLOGUEUR
        );

        Publisher p3 = new Publisher(
                "Sekkah",
                "Aissam",
                "aissam@gmail.com",
                Category.YOUTUBEUR
        );

        publisherRepository.save(p1);
        publisherRepository.save(p2);
        publisherRepository.save(p3);
    }
}