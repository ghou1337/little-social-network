package pl.test.social.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table(name = "posts")
public class Post {

    private int id;

    private String image_path;

    private int likes;

    public Post() {
    }
}
