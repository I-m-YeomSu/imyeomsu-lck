package imyeom_lck;

import imyeom_lck.member.domain.entity.Member;
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
	
	//승부예측키
	@MapsId("predictId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "predict_id")
	private Predict predict;

	//회원키
	@MapsId("memberId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
	
}
