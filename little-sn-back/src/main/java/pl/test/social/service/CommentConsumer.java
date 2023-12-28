package pl.test.social.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CommentConsumer {
   @KafkaListener(topics = "comment-topic", groupId = "1")
   public void processComment(String message) {
       System.out.println("Received comment: " + message);
   }
}
