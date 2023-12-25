package pl.test.social.conroller;

import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.test.social.service.CommentProducer;
import pl.test.social.service.LikeProducer;

@RestController
public class SocialMediaController {

    @Autowired
    private LikeProducer likeProducer;

    @Autowired
    private CommentProducer commentProducer;

    @PostMapping("/like")
    public ResponseEntity<String> likePost(@RequestParam String userId, @RequestParam String postId) {
        likeProducer.sendLike(userId, postId);
        return ResponseEntity.ok("Message have been sent");
    }

    @PostMapping("/comment")
    public ResponseEntity<String> leaveComment(@RequestParam String userId, @RequestParam String targetId, @RequestParam String comment) {
        commentProducer.sendComment(userId, targetId, comment);
        return ResponseEntity.ok("Comment have been sent");
    }

    @GetMapping("/get-likes")
    public String getAllPostLikes(@RequestParam String postId) {

        return "1000 likes";
    }
}
