package test.inflearn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import test.inflearn.lecture.Lecture;
import test.inflearn.lecture.LectureRepository;

@Component
public class SetDummyData implements CommandLineRunner {

    private final LectureRepository lectureRepository;

    @Autowired
    public SetDummyData(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Dummy 1
        Lecture lecture1 = new Lecture();
        lecture1.setTitle("Lecture 1 Title");
        lecture1.setBody("Lecture 1 Body Content");
        // Dummy 2
        Lecture lecture2 = new Lecture();
        lecture2.setTitle("Lecture 2 Title");
        lecture2.setBody("Lecture 2 Body Content");
        // Dummy 3
        Lecture lecture3 = new Lecture();
        lecture3.setTitle("Lecture 3 Title");
        lecture3.setBody("Lecture 3 Body Content");

        // 레포지토리를 사용하여 더미 데이터 저장
        lectureRepository.save(lecture1);
        lectureRepository.save(lecture2);
        lectureRepository.save(lecture3);
    }
}
