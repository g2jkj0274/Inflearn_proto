package test.inflearn.Question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.inflearn.lecture.Lecture_Video;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public Question saveQuestion(String content, Lecture_Video videoId) {
        Question question = new Question();
        question.setQuestion(content);
        question.setLectureVideo(videoId);
        return questionRepository.save(question);
    }

    // 여기에 다른 서비스 메서드를 추가할 수 있습니다.
}
