package imyeom_lck;

import java.time.LocalDateTime;

import org.hibernate.annotations.DialectOverride.SQLDelete;
import org.hibernate.annotations.DialectOverride.SQLRestriction;
import org.hibernate.annotations.DialectOverride.Where;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@Getter
@Builder
@Entity
public class PointUsage {
	
	//포인트내역키
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "point_usage_id")
	private Long pointUsageId;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="member_id")
	private Member member;
	
	//포인트분류군
	private Long usageClassification;
	
	//포인트날짜
	private LocalDateTime usageDate;
	
	//포인트사용내역
	private String pointHistory;
	
}
