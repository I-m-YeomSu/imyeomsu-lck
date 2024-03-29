package imyeom_lck.member.domain.entity;

import imyeom_lck.member.domain.entity.Member;
import imyeom_lck.predict.domain.entity.Predict;
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

	//회원승부예측키
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_predict_id")
	private Long memberPredictId;
	

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "predict_id")
	private Predict predict;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
	
}
