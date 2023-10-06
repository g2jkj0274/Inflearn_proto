package test.inflearn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import test.inflearn.lecture.Lecture;
import test.inflearn.lecture.LectureRepository;
import test.inflearn.lecture.Lecture_Video;
import test.inflearn.lecture.Lecture_VideoRepository;

@Component
public class SetDummyData implements CommandLineRunner {

    private final LectureRepository lectureRepository;
    private final Lecture_VideoRepository lecture_VideoRepository;

    @Autowired
    public SetDummyData(LectureRepository lectureRepository, Lecture_VideoRepository lecture_VideoRepository) {
        this.lectureRepository = lectureRepository;
        this.lecture_VideoRepository = lecture_VideoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Dummy 1
        Lecture lecture1 = new Lecture();
        lecture1.setTitle("Lecture 1 Title");
        lecture1.setBody("Lecture 1 Body Content");
        lectureRepository.save(lecture1); // 먼저 저장

        // Dummy 2
        Lecture lecture2 = new Lecture();
        lecture2.setTitle("Lecture 2 Title");
        lecture2.setBody("Lecture 2 Body Content");
        lectureRepository.save(lecture2); // 먼저 저장

        // Dummy 3
        Lecture lecture3 = new Lecture();
        lecture3.setTitle("Lecture 3 Title");
        lecture3.setBody("Lecture 3 Body Content");
        lectureRepository.save(lecture3); // 먼저 저장

        // 이제 강의별로 3개의 영상 더미 데이터를 추가
        addVideoForLecture(lecture1);
        addVideoForLecture(lecture2);
        addVideoForLecture(lecture3);
    }

    // 강의마다 3개의 더미 영상 생성
    private void addVideoForLecture(Lecture lecture) {
        for (int i = 1; i <= 3; i++) {
            Lecture_Video lecture_Video = new Lecture_Video();
            lecture_Video.setLecture(lecture);
            lecture_Video.setTitle("Video " + i + " for " + lecture.getTitle());
            lecture_Video.setVideo_url("url_for_video_" + i + "_of_" + lecture.getTitle());

            lecture_VideoRepository.save(lecture_Video);
        }
    }
}
