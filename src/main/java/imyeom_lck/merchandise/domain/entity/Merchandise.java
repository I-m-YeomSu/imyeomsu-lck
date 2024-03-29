package imyeom_lck.merchandise.domain.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "merchandise")
public class Merchandise {
	
	//상품키
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "merchandise_id")
	private Long merchandiseId;
	
	//상품명
	private String merchandiseName;
	
	//상품이미지
	private String image;
	
	//상품분류
	private Long classification;
	
	//가격
	private Long price;
	
	//재고
	private Long stockQuantity;
	
}
