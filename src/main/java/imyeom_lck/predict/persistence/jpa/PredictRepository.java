package imyeom_lck.predict.persistence.jpa;

import imyeom_lck.member.domain.entity.Member;
import imyeom_lck.predict.domain.entity.Predict;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PredictRepository extends JpaRepository<Predict, Long> {


    Optional<Predict> findByPredictIndex(Long predictIndex);
}
