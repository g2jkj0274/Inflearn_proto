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
            @PathVariable Integer lectureId,
            @PathVariable Integer videoId,
            Model model) {
        Lecture_Video video = lectureVideoService.getVideoByLectureIdAndVideoId(lectureId, videoId);
        model.addAttribute("video", video);
        return "video_detail";
    }
}
