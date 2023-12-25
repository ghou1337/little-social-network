package pl.test.social.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CommentProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "comment-topic";

    public void sendComment(String userId, String targetId, String comment) {
        String message = userId + "|" + targetId + "|" + comment;
        kafkaTemplate.send(TOPIC, message);
    }
}
