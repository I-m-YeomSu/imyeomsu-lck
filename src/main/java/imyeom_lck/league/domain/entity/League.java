package imyeom_lck.league.domain.entity;

import java.time.LocalDateTime;

import imyeom_lck.team.domain.entity.Team;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import imyeom_lck.match_schedule.domain.entity.MatchSchedule;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "leagues")
public class League {

	//리그키
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "league_id")
	private Long leagueId;
	
	//팀
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "team_id")
    private Team team;
	
	//경기일정
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "match_schedule_id")
    private MatchSchedule matchSchedule;
	
	//리그시작일
	private LocalDateTime startDate;
	
	//리그종료일
	@Column(name = "end_date", nullable = true)
	private LocalDateTime endDate;
	
}
