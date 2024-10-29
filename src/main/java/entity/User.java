package entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table (name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    @OneToOne(cascade = CascadeType.ALL)
    private Profile profile;

    public User(String username, Profile profile) {
        this.username = username;
        this.profile = profile;
    }
}
