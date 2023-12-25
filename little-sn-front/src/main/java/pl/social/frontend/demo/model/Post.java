package pl.social.frontend.demo.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Post {

    private int id;

    private String image_path;

    private int likes;

    private int user_id;

    public Post() {
    }
}
