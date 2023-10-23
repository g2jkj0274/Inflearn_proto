package test.inflearn.Question;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import test.inflearn.lecture.Lecture_Video;

@Getter
@Setter
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer qnaId;  // qna_id -> qnaId

    @Column(length = 500)
    private String question;

    @Column(columnDefinition = "TEXT")
    private String answer;

    @ManyToOne
    @JoinColumn(name = "video_id")
    private Lecture_Video lectureVideo;

    // getters, setters, and other standard methods...
}
