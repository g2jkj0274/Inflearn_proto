package test.inflearn;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Main {
    @GetMapping("/")
    public String root() {
        return "redirect:/lectures"; // 강의 목록 페이지로 리다이렉트
    }
}
