package test.inflearn.lecture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import test.inflearn.user.User_Comment;
import test.inflearn.user.User_CommentService;

import java.util.List;

@Controller // @RestController 대신 @Controller를 사용
public class LectureController {

    private final LectureService lectureService;
    @Autowired
    private Lecture_VideoService  lectureVideoService;
    @Autowired
    private User_CommentService commentService;

    @Autowired
    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    // 강의 더미 데이터 생성
    @PostMapping("/lectures")
    public Lecture createLecture(@RequestBody Lecture lecture) {
        return lectureService.saveLecture(lecture);
    }

    // 강의 리스트
    @GetMapping("/lectures")
    public String getLectures(Model model) {
        model.addAttribute("lectures", lectureService.getAllLectures());
        return "main"; // main.html 파일을 찾아서 반환
    }

    // 강의 디테일
    @GetMapping("/lectures/{id}")
    public String getLectureDetail(@PathVariable Integer id, Model model) {
        Lecture lecture = lectureService.getLectureById(id);
        List<User_Comment> comments = commentService.getCommentsByLecture(lecture);
        model.addAttribute("lecture", lecture);
        model.addAttribute("comments", comments); // 이 부분을 추가
        return "lecture_detail";
    }

    // 영상 디테일 페이지 메서드 추가
    @GetMapping("/lectures/{lectureId}/videos/{videoId}")
    public String getVideoDetail(
            @PathVariable Integer lectureId, // 추가된 파라미터
            @PathVariable Integer videoId,
            Model model) {
        Lecture_Video video = lectureVideoService.getVideoById(videoId);
        model.addAttribute("video", video);
        // 필요하다면 lectureId를 사용하여 추가 로직을 수행할 수 있습니다.
        return "video_detail";  // video_detail.html 파일을 찾아서 반환
    }
}
