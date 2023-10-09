package test.inflearn.user;

import org.springframework.data.jpa.repository.JpaRepository;
import test.inflearn.lecture.Lecture;
import test.inflearn.user.User_Comment;

import java.util.List;

public interface User_CommentRepository extends JpaRepository<User_Comment, Integer> {
    List<User_Comment> findByLecture(Lecture lecture);
}
