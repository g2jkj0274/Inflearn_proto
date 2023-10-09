package test.inflearn.user;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private HttpSession session; // HttpSession을 주입받습니다.

    @GetMapping("/signup")
    public String signupForm() {
        return "signup";
    }
    @PostMapping("/signup")
    public String signup(User user) {
        userService.register(user);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }
    @PostMapping("/login")
    public String login(User user) {
        User validUser = userService.validateAndReturnUser(user.getUserLoginId(), user.getUserLoginPw());
        if (validUser != null) {
            session.setAttribute("user", validUser); // 로그인 성공 시 사용자 정보를 세션에 저장
            return "redirect:/";
        } else {
            return "redirect:/user/login";
        }
    }
    @GetMapping("/logout")
    public String logout() {
        session.removeAttribute("user"); // 로그아웃 시 세션의 사용자 정보를 제거
        return "redirect:/";
    }
}
