package imyeom_lck.player.persistence.jpa;


import org.springframework.data.jpa.repository.JpaRepository;

import imyeom_lck.player.domain.entity.PlayerGame;

public interface PlayerGameRepository extends JpaRepository<PlayerGame, Long> {


}
