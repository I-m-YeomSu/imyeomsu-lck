package imyeom_lck.match_schedule.domain.entity;

import java.time.LocalDateTime;

import imyeom_lck.game.domain.entity.Game;
import imyeom_lck.predict.domain.entity.Predict;
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
@Table(name = "match schedules")
public class MatchSchedule {

	//경기일정키
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_schedule_id")
	private Long matchScheduleId;
	
	//경기키
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "game_id")
	private Game game;

	
	//경기날짜및시간
	private LocalDateTime matchDate;
	
	//홈팀
	private int homeTeam;
	
	//원정팀
	private int awayTeam;
	
	//홈팀승점
	private int homePoint;
	
	//원정팀승점
	private int awayPoint;
	
	//경기결과
	private boolean matchResult;
	
	//showdown 여부
	private boolean isShowdown;
	
}
