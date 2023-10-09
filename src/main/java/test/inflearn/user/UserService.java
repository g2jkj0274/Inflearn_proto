package test.inflearn.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    // 데이터베이스 연동을 위한 UserRepository를 주입받습니다.
    // UserRepository는 JPA를 사용하는 경우에 생성합니다.
    @Autowired
    private UserRepository userRepository;

    public void register(User user) {
        // 비밀번호 암호화, 검증 등의 로직을 추가할 수 있습니다.
        userRepository.save(user);
    }

    // 변경된 부분: 로그인 검증 메서드가 User 객체를 반환합니다.
    public User validateAndReturnUser(String userLoginId, String userLoginPw) {
        User user = userRepository.findByUserLoginId(userLoginId);
        if (user != null && user.getUserLoginPw().equals(userLoginPw)) {
            return user;  // 로그인 성공
        }
        return null;  // 로그인 실패
    }
}
