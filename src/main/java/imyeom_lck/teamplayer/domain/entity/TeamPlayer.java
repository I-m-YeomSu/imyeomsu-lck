package imyeom_lck.teamplayer.domain.entity;


import imyeom_lck.player.domain.entity.Player;
import imyeom_lck.team.domain.entity.Team;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "team_player_id")
	private Long teamPlayerId;
	
	//팀
	@MapsId("teamId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;
	
	//선수
	@MapsId("playerId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id")
    private Player player;
	
}
