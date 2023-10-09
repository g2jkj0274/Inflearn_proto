package test.inflearn.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import test.inflearn.lecture.Lecture;

@Getter
@Setter
@Entity
public class User_Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer comment_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "Lecture_id")
    private Lecture lecture;

    @Column(columnDefinition = "TEXT")
    private String comment_body;

    private Integer star_rating;
}