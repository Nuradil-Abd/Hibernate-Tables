package entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "profiles")
@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor

public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bio;
    @OneToOne(mappedBy = "profile")
    private User user;

    public Profile(String bio, User user) {
        this.bio = bio;
        this.user = user;
    }
}
