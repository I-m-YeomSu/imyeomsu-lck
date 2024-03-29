package imyeom_lck;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "game")
public class Game {
	
	//경기
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "game_id")
	private Long gameId;
	
	//선수
	@OneToMany(mappedBy = "game", fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id")
    private Player player;
	
	//승패
	private boolean winner;
	
	//pog
	private String pog;
	
}
