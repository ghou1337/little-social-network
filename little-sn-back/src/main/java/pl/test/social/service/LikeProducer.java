package pl.test.social.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class LikeProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "likes-topic";

    public void sendLike(String userId, String postId) {
        String message = userId + "|" + postId;
        kafkaTemplate.send(TOPIC, message);
    }
}
