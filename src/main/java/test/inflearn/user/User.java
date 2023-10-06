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
    private String user_login_id;

    private String user_login_pw;
    private String user_email;
}
