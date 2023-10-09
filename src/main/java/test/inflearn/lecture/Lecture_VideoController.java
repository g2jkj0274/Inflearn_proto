package test.inflearn.lecture;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class Lecture_VideoController {
    @Autowired
    private Lecture_VideoService  lectureVideoService;

    // 영상 디테일 페이지 메서드 추가
    @GetMapping("/lectures/{lectureId}/videos/{videoId}")
    public String getVideoDetail(
            @PathVariable Integer lectureId, // 추가된 파라미터
            @PathVariable Integer videoId,
            Model model) {
        Lecture_Video video = lectureVideoService.getVideoById(videoId);
        model.addAttribute("video", video);
        // 필요하다면 lectureId를 사용하여 추가 로직을 수행할 수 있습니다.
        return "video_detail";  // video_detail.html 파일을 찾아서 반환
    }
}
