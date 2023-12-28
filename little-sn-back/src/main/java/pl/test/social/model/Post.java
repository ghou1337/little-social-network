package pl.test.social.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "posts")
@Entity
public class Post {

    @Id
    private int id;

    private String image_path;

    private int likes;

    public Post() {
    }
}
