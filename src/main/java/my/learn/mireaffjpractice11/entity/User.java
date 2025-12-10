package my.learn.mireaffjpractice11.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import my.learn.mireaffjpractice11.model.UserRole;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@Entity
@Data
@Table(name = "users")
@NoArgsConstructor @AllArgsConstructor @Builder
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    @Column
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Note> notes;

    @Column
    @Enumerated(EnumType.STRING)
    private List<UserRole> authorities;

}
