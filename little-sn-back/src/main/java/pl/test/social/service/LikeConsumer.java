package pl.test.social.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class LikeConsumer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private LikeService likeService;

    @KafkaListener(topics = "likes-topic", groupId = "group1")
    public void processLike(String message) {
        System.out.println("Received like: " + message);
    }
}
