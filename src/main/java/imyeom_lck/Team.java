package imyeom_lck;

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
@Table(name = "team")
public class Team {

	//팀키
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "team_id")
	private Long team;
	
	//팀명
	private String teamName;
	
	//로고
	private String logo;
	
	//팀순위
	private int teamRank;
	
	//승점
	private int winPoint;
	
	//승수
	private int winGame;
	
}
