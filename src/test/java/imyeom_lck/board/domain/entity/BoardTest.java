package imyeom_lck.board.domain.entity;

import imyeom_lck.member.domain.entity.Member;
import imyeom_lck.member.dummy.DummyMember;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {


    Member member;
    Board board;

    private String CONTENT = "test content";
    private LocalDateTime now = LocalDateTime.now();

    @BeforeEach
    void setUp() {
        member = DummyMember.dummy();
        //뗴힝 실제 엔티티 save등으 할때 객체 생성할 땐 pk 넣음 안 된다~
        //이건 테스트 코드 안 돌아가서 넣은거야~
        board = Board.builder()
                .boardId(1L)
                .member(member)
                .content(CONTENT)
                .date(now)
                .build();
    }

    @Test
    void getBoardId() {

        Assertions.assertThat(board.getBoardId()).isEqualTo(1L);
    }

    @Test
    void getMember() {
        Assertions.assertThat(board.getMember().getName()).isEqualTo("test");


    }

    @Test
    void getContent() {
        Assertions.assertThat(board.getContent()).isEqualTo(CONTENT);

    }

    @Test
    void getDate() {
        Assertions.assertThat(board.getDate()).isEqualTo(now);

    }

    @Test
    void builder() {
        Assertions.assertThat(board.getBoardId()).isEqualTo(1L);

    }
}