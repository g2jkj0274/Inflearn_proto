package test.inflearn.lecture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LectureService {

    private final LectureRepository lectureRepository;

    @Autowired
    public LectureService(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    // 강의 엔티티를 저장하고 반환합니다.
    @Transactional
    public Lecture saveLecture(Lecture lecture) {
        return lectureRepository.save(lecture);
    }

    // 강의 리스트, 모든 강의 목록을 반환합니다.
    public List<Lecture> getAllLectures() {
        return lectureRepository.findAll();
    }

    // 강의 디테일, 주어진 ID에 해당하는 강의 엔티티를 반환하거나, 없으면 null을 반환합니다.
    public Lecture getLectureById(Integer id) {
        return lectureRepository.findById(id).orElse(null);
    }
}
