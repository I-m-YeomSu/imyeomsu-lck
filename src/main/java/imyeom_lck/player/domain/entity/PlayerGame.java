package imyeom_lck.player.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/*
* N : M 관계에서 진행하는 중간 연결 역할 테이블입니다.
* 해당 테이블은 복합키를 사용해서 PK로 만들어 사용할 수도 있지만
* 이를 대신해서 의미 없는 PK 값을 둬서 진행합니다.
* */
@Entity
@Table(name = "player_games")
public class PlayerGame {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long playerGameId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "player_id")
	private Player player;




}
