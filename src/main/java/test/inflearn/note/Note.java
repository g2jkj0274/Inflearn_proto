package test.inflearn.note;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import test.inflearn.lecture.Lecture;
import test.inflearn.lecture.Lecture_Video;
import test.inflearn.user.User;

@Getter
@Setter
@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String content;

    // Getters, setters, and other methods...
}
