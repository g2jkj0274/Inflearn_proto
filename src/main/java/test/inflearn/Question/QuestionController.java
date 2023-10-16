package test.inflearn.Question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @PostMapping("/save")
    public ResponseEntity<?> saveQuestion(@RequestBody Map<String, String> payload) {
        String content = payload.get("content");
        if (content == null) {
            return ResponseEntity.badRequest().body("Content cannot be null");
        }
        Question savedQuestion = questionService.saveQuestion(content);
        return ResponseEntity.ok().body("Question saved successfully");
    }

    // 여기에 다른 컨트롤러 메서드를 추가할 수 있습니다.
}
