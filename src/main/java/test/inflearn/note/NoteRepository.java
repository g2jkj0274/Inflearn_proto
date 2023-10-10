package test.inflearn.note;

import org.springframework.data.jpa.repository.JpaRepository;
import test.inflearn.note.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {
    // 여기에 필요한 추가적인 쿼리 메소드를 선언할 수 있습니다.
}
