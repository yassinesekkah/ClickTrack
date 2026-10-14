package ma.youcode.clickTracker.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.youcode.clickTracker.model.Publisher;
import ma.youcode.clickTracker.service.PublisherService;
import org.springframework.web.HttpRequestHandler;

import java.io.IOException;
import java.util.List;

public class PublisherController implements HttpRequestHandler {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(!request.getMethod().equals("GET")){
            response.setHeader("Allow", "GET");
            response.sendError(405, "Method Not Allowed");
            return;
        }

       List<Publisher> publishers = publisherService.findAll();

        ///ObjectMapper est une classe de la bibliothèque Jackson
        ///qui permet de convertir des objets Java en JSON, et inversement.
        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(publishers);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setStatus(200);

        response.getWriter().write(
                json
        );
    }
}
