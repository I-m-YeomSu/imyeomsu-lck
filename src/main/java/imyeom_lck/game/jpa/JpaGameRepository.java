package imyeom_lck.game.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import imyeom_lck.game.domain.Game;

public interface JpaGameRepository extends JpaRepository<Game, Long> {


}
