package imyeom_lck.board.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import imyeom_lck.board.domain.entity.Board;

public interface JpaBoardRepository extends JpaRepository<Board, Long> {


}
