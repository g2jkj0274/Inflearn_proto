package test.inflearn.note;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import test.inflearn.lecture.Lecture_Video;
import test.inflearn.user.User;

@Getter
@Setter
@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "lecture_video_id")
    private Lecture_Video lectureVideo;

    @Column(columnDefinition = "TEXT")
    private String content;

    // Getters, setters, and other methods...
}
