package imyeom_lck.rank.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import imyeom_lck.rank.domain.entity.Rank;

public interface JpaRankRepository extends JpaRepository<Rank, Long> {

}
