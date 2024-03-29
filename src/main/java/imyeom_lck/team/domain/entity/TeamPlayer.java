package imyeom_lck.team.domain.entity;


import imyeom_lck.player.domain.entity.Player;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Table(name = "team_player")
@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class TeamPlayer {

	//팀선수키
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_player_id")
	private Long teamPlayerId;
	
	//팀
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;
	
	//선수
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id")
    private Player player;
	
}
