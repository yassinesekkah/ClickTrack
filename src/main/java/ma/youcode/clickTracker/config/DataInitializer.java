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
                "Ali",
                "Alami",
                "ali@gmail.com",
                Category.INFLUENCEUR
        );

        Publisher p2 = new Publisher(
                "Sara",
                "Bennani",
                "sara@gmail.com",
                Category.BLOGUEUR
        );

        Publisher p3 = new Publisher(
                "Ismail",
                "Sekkah",
                "ismail@gmail.com",
                Category.YOUTUBEUR
        );

        publisherRepository.save(p1);
        publisherRepository.save(p2);
        publisherRepository.save(p3);
    }
}