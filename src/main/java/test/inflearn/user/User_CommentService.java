package test.inflearn.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.inflearn.lecture.Lecture;
import test.inflearn.user.User_Comment;
import test.inflearn.user.User_CommentRepository;

import java.util.List;

@Service
public class User_CommentService {

    @Autowired
    private User_CommentRepository commentRepository;

    public User_Comment saveComment(User_Comment comment) {
        return commentRepository.save(comment);
    }

    public List<User_Comment> getCommentsByLecture(Lecture lecture) {
        return commentRepository.findByLecture(lecture);
    }
}
