package imyeom_lck.game.domain.entity;

import imyeom_lck.player.domain.entity.Player;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "game")
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "game_id")
	private Long gameId;

	//승패
	private boolean winner;

	//pog 해당부분은 따로 테이블로 뺄수도 있음 ~~~_~_~_~_~ㄴ
	private String pog;

}
