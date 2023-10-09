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

    // User와의 관계를 설정하려면 이 부분도 수정해야 하지만 지금은 간단히 구현
    private Integer user_id;

    @ManyToOne
    @JoinColumn(name = "Lecture_id")
    private Lecture lecture;

    @Column(columnDefinition = "TEXT")
    private String comment_body;

    private Integer star_rating;
}
