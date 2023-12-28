package pl.social.frontend.demo.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class LikeConsumer {

    @KafkaListener(topics = "like-topic", groupId = "1")
    public String processComment() {
        System.out.println("Like was added");
        return "Like was added";
    }

}
