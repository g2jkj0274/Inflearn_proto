package test.inflearn.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;

    @Column(unique = true)
    private String userLoginId;

    private String userLoginPw;
    private String userEmail;
}
