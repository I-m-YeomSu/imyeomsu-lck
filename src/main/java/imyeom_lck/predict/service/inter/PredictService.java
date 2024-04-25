package imyeom_lck.predict.service.inter;

import imyeom_lck.predict.domain.dto.PredictDTO;
import imyeom_lck.predict.domain.dto.PredictRequestDTO;
import imyeom_lck.predict.domain.dto.VotedUserDTO;
import imyeom_lck.predict.domain.entity.Predict;
import imyeom_lck.predict.domain.entity.VotedUser;

import java.util.List;

public interface PredictService {

    public PredictDTO vote(PredictRequestDTO predictRequestDTO) throws InterruptedException;

    public List<VotedUserDTO> getVotedUserList(Long memberId);


}
