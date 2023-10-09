package test.inflearn.user;

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

    // 댓글 추가
    @PostMapping("/lectures/{lectureId}/comments")
    public String addComment(@PathVariable Integer lectureId, User_Comment comment) {
        Lecture lecture = lectureService.getLectureById(lectureId);
        comment.setLecture(lecture); // 이 부분을 추가
        commentService.saveComment(comment);
        return "redirect:/lectures/" + lectureId;
    }
}
