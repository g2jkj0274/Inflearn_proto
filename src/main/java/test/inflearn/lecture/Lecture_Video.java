package test.inflearn.lecture;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Lecture_Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer videoId; // video_id -> videoId

    private Integer lectureVideoId; // lecture_video_id -> lectureVideoId

    @ManyToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;

    @Column(length = 200)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String videoUrl; // video_url -> videoUrl
}
