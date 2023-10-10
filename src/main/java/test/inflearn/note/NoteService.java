package test.inflearn.note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.inflearn.note.Note;
import test.inflearn.note.NoteRepository;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public Note save(String content) {
        Note note = new Note();
        note.setContent(content);
        return noteRepository.save(note);
    }

    // 여기에 다른 서비스 메소드를 추가할 수 있습니다.
}
