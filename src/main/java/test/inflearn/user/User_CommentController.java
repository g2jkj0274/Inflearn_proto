package test.inflearn.user;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import test.inflearn.lecture.Lecture;
import test.inflearn.lecture.LectureService;
import test.inflearn.user.User_Comment;
import test.inflearn.user.User_CommentService;

@Controller
public class User_CommentController {

    @Autowired
    private User_CommentService commentService;
    @Autowired
    private LectureService lectureService;
    @Autowired
    private HttpSession session;  // HttpSession 주입받기

    // 댓글 추가
    @PostMapping("/lectures/{lectureId}/comments")
    public String addComment(@PathVariable Integer lectureId, User_Comment comment) {
        User currentUser = (User) session.getAttribute("user");
        if (currentUser == null) {
            // 유저가 로그인되어 있지 않으면 로그인 페이지로 리다이렉트
            return "redirect:/user/login";
        }
        comment.setUser(currentUser);
        Lecture lecture = lectureService.getLectureById(lectureId);
        comment.setLecture(lecture);
        commentService.saveComment(comment);
        return "redirect:/lectures/" + lectureId;
    }
}