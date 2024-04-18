package imyeom_lck.league.persistence.jpa;

import imyeom_lck.league.domain.entity.League;
import imyeom_lck.member.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeagueRepository extends JpaRepository<League, Long> {


}
