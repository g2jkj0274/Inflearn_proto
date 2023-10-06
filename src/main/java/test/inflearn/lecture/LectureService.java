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

    @Transactional
    public Lecture saveLecture(Lecture lecture) {
        return lectureRepository.save(lecture);
    }

    // 강의 리스트
    public List<Lecture> getAllLectures() {
        return lectureRepository.findAll();
    }

    // 강의 디테일
    public Lecture getLectureById(Integer id) {
        return lectureRepository.findById(id).orElse(null);
    }

}
