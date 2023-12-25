package pl.test.social.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.test.social.model.Post;
import pl.test.social.repo.PostRepo;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepo postRepo;

    public Flux<Post> getAll() {
        return postRepo.findAll();
    }
}
