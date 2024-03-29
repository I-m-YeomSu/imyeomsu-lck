package imyeom_lck;


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
import lombok.NoArgsConstructor;
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
@Table(name = "player")
public class Player {

	//선수키
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "player_id")
	private Long playerId;
	
	//이름
	private String playerName;
	
	//스탯 - 들어오는 포멧에 따라변경
	private String stat;
	
	//포지션
	private Long position;
	
	//닉네임
	private String nickname;
	
	//pog점수
	private Long pogPoint;
	
}
