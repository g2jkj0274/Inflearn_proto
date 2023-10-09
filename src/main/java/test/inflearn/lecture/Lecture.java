package test.inflearn.lecture;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer lectureId; // lecture_id -> lectureId

    @Column(length = 200)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String body;

    @OneToMany(mappedBy = "lecture")
    private List<Lecture_Video> lectureVideoList; // lecture_videoList -> lectureVideoList
}
