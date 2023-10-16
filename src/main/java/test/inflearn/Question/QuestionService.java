package test.inflearn.Question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public Question saveQuestion(String content) {
        Question question = new Question();
        question.setContent(content);
        return questionRepository.save(question);
    }

    // 여기에 다른 서비스 메서드를 추가할 수 있습니다.
}
