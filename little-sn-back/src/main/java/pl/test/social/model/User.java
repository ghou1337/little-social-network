package pl.test.social.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    private int id;
    private String username;

    public User() {
    }
}
