package test.inflearn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import test.inflearn.lecture.Lecture;
import test.inflearn.lecture.LectureRepository;
import test.inflearn.lecture.Lecture_Video;
import test.inflearn.lecture.Lecture_VideoRepository;
import test.inflearn.user.User;
import test.inflearn.user.UserRepository;

@Component
public class SetDummyData implements CommandLineRunner {

    private final LectureRepository lectureRepository;
    private final Lecture_VideoRepository lecture_VideoRepository;
    private final UserRepository userRepository;

    @Autowired
    public SetDummyData(LectureRepository lectureRepository, Lecture_VideoRepository lecture_VideoRepository, UserRepository userRepository) {
        this.lectureRepository = lectureRepository;
        this.lecture_VideoRepository = lecture_VideoRepository;
        this.userRepository = userRepository;
    }

    // 강의 생성
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

        // 유저 더미 데이터 생성
        createUser("u1");
        createUser("u2");
        createUser("u3");
    }

    // 강의마다 3개의 더미 영상 생성
    private void addVideoForLecture(Lecture lecture) {
        for (int i = 1; i <= 3; i++) {
            Lecture_Video lecture_Video = new Lecture_Video();

            // Lecture_Video_id 값을 설정
            lecture_Video.setLecture_video_id(i);

            lecture_Video.setLecture(lecture);
            lecture_Video.setTitle("Video " + i + " for " + lecture.getTitle());
            lecture_Video.setVideo_url("url_for_video_" + i + "_of_" + lecture.getTitle());

            lecture_VideoRepository.save(lecture_Video);
        }
    }

    // 더미 유저 생성 로직
    private void createUser(String userId) {
        User user = new User();
        user.setUserLoginId(userId);
        user.setUserLoginPw(userId); // 로그인 ID와 PW는 동일하게 설정
        user.setUserEmail(userId + "@example.com"); // 간단한 이메일 주소 설정

        userRepository.save(user);
    }
}
