package test.inflearn.lecture;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Lecture_Video {
    // 모든 강의 영상에 대한 id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer video_id;

    // 해당 되는 강의 영상의 id
    private Integer Lecture_Video_id;

    // 강의와의 관계 설정. 각각의 영상은 하나의 강의에 속한다.
    @ManyToOne
    @JoinColumn(name = "lecture_id") // FK column 이름 설정
    private Lecture lecture;

    @Column(length = 200)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String video_url;
}