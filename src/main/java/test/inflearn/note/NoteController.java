package test.inflearn.note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @PostMapping("/save")
    public ResponseEntity<String> saveNote(@RequestBody String markdownContent) {
        noteService.save(markdownContent);
        return ResponseEntity.ok("Note saved successfully");
    }
}
