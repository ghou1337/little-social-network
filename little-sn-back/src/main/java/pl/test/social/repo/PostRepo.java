package pl.test.social.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.test.social.model.Post;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {

}
