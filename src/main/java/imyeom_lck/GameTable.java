package imyeom_lck;

import java.time.LocalDateTime;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import imyeom_lck.game.domain.Game;
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
@Table(name = "game_tables")
public class GameTable {

	//경기일정키
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "game_table_id")
	private Long gameTableId;
	
	//경기키
	@OneToMany(mappedBy = "game_tables", fetch = FetchType.LAZY)
	@JoinColumn(name = "game_id")
	private Game game;
	
	@OneToMany(mappedBy = "predict", fetch = FetchType.LAZY)
	@JoinColumn(name = "predict_id")
    private Predict predict;
	
	//경기날짜및시간
	private LocalDateTime matchDate;
	
	//홈팀
	private int home;
	
	//원정팀
	private int away;
	
	//홈팀승점
	private int homePoint;
	
	//원정팀승점
	private int awayPoint;
	
	//경기결과
	private boolean matchResult;
	
	//showdown 여부
	private boolean showdown;
	
}
