package test.inflearn.lecture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Lecture_VideoService {
    private final Lecture_VideoRepository lectureVideoRepository;

    @Autowired
    public Lecture_VideoService(Lecture_VideoRepository lectureVideoRepository) {
        this.lectureVideoRepository = lectureVideoRepository;
    }

    public Lecture_Video getVideoByLectureIdAndVideoId(Integer lectureId, Integer videoId) {
        return lectureVideoRepository.findByLectureLectureIdAndLectureVideoId(lectureId, videoId).orElse(null);
    }
}
