package test.inflearn.lecture;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

// 강의 엔티티
@Getter
@Setter
@Entity
public class Lecture {
    @Id // Primary key 열임을 나타냅니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 생성되는(primary key) 값임을 나타냅니다.
    private Integer lecture_id;

    @Column(length = 200) // VARCHAR(200) 형식의 열을 나타냅니다.
    private String title;

    @Column(columnDefinition = "TEXT") // TEXT 형식의 열을 나타냅니다.
    private String body;

    // 강의와 관련된 비디오들의 리스트
    @OneToMany(mappedBy = "lecture")
    private List<Lecture_Video> lecture_Video;
}
