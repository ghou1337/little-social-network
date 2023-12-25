package pl.test.social.conroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.test.social.model.Post;
import pl.test.social.service.PostService;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestSocialMediaController {

    @Autowired
    private PostService postService;


    @GetMapping("/get-posts")
    public Flux<Post> getAllPosts() {
        return postService.getAll();
    }
}
