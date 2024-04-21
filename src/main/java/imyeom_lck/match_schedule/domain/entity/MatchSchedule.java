package imyeom_lck.match_schedule.domain.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import imyeom_lck.team.domain.entity.Team;


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

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "match_schedules")
public class MatchSchedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "match_schedule_id")
	private Long matchId;
	private String matchDate;
	private String matchTime;
	private String matchState;
	private String matchTitle;
	private String homeTeamScore;
	private String awayTeamScore;
	private String homeTeamName;
	private String homeTeamLogo;
	private String awayTeamName;
	private String awayTeamLogo;



}