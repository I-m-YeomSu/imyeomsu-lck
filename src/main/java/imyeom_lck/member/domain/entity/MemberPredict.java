package imyeom_lck.member.domain.entity;

import imyeom_lck.member.domain.entity.Member;
import imyeom_lck.predict.domain.entity.Predict;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Table(name = "members_predict")
@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class MemberPredict {

    @Schema(description = "유저 승부예측 아이디", example = "1")
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_predict_id")
	private Long memberPredictId;

    @Schema(description = "유저 아이디", example = "loginId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "predict_id")
	private Predict predict;

    @Schema(description = "유저 아이디", example = "loginId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
	
}
