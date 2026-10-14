package ma.youcode.clickTracker;

import ma.youcode.clickTracker.service.PublisherService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args){

        try(
            var context = new ClassPathXmlApplicationContext("applicationContext.xml")
        ){
            PublisherService p = context.getBean("publisherService", PublisherService.class);

            System.out.println(p != null);
        }
    }
}
