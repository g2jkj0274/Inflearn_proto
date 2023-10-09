package test.inflearn.lecture;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface Lecture_VideoRepository extends JpaRepository<Lecture_Video, Integer> {
    Optional<Lecture_Video> findByLectureLectureIdAndLectureVideoId(Integer lectureId, Integer lectureVideoId); // 카멜케이스로 변경
}
