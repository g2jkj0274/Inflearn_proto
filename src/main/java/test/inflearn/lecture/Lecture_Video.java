package test.inflearn.lecture;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import test.inflearn.Question.Question;

import java.util.List;

@Getter
@Setter
@Entity
public class Lecture_Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer videoId;

    private Integer lectureVideoId;

    @ManyToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;

    @Column(length = 200)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String videoUrl; // video_url -> videoUrl

    @OneToMany(mappedBy = "lectureVideo")
    private List<Question> qnaList;  // qnaList 필드 추가
}
