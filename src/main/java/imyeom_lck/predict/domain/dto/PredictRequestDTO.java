package imyeom_lck.predict.domain.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PredictRequestDTO {
    private Long memberId;
    private Long predictId;
    private boolean flag;
}
