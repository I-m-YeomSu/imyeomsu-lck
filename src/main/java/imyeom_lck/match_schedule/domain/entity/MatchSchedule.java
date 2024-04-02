package imyeom_lck.match_schedule.domain.entity;

import java.time.LocalDateTime;

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
@Table(name = "match schedules")
public class MatchSchedule {

	//경기일정키
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_schedule_id")
	private Long matchScheduleId;

	private Long homeTeam;

//	private Long awayTeam;

	//경기날짜및시간
	private LocalDateTime matchDate;

	//경기결과
	private boolean matchResult;
	
	//Saturday Showdown 여부
	private boolean isShowdown;


	//setter 대신 Builder 패턴 쓰기
//	public static void createMatchSchedule()



	
}