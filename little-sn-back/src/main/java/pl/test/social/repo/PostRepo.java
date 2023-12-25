package pl.test.social.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import pl.test.social.model.Post;
import reactor.core.publisher.Flux;

@Repository
public interface PostRepo extends ReactiveCrudRepository<Post, Integer> {
}
