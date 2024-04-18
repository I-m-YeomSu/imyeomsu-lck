package imyeom_lck.predict.service.inter;

import imyeom_lck.predict.domain.dto.PredictDTO;
import imyeom_lck.predict.domain.dto.PredictRequestDTO;
import imyeom_lck.predict.domain.entity.Predict;

public interface PredictService {

    public PredictDTO vote(PredictRequestDTO predictRequestDTO) throws InterruptedException;


}
