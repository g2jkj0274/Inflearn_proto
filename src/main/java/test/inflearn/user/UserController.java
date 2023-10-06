package test.inflearn.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

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
        boolean isValid = userService.validateUser(user.getUserLoginId(), user.getUserLoginPw());
        if (isValid) {
            // 여기서 세션에 사용자 정보를 저장하거나 토큰을 생성할 수 있습니다.
            return "redirect:/";
        } else {
            return "redirect:/user/login";
        }
    }
}
