package imyeom_lck.league.domain.entity;

import java.time.LocalDateTime;

import imyeom_lck.GameTable;
import imyeom_lck.team.domain.entity.Team;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
@Table(name = "league")
public class League {

	//리그키
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "league_id")
	private Long leagueId;
	
	//팀
	@OneToMany(mappedBy = "league", fetch = FetchType.LAZY)
	@JoinColumn(name = "team_id")
    private Team team;
	
	//경기일정
	@OneToMany(mappedBy = "league", fetch = FetchType.LAZY)
	@JoinColumn(name = "game_table_id")
    private GameTable gameTable;
	
	//리그시작일
	private LocalDateTime startDate;
	
	//리그종료일
	private LocalDateTime endDate;
	
}
