package imyeom_lck.team.domain.entity;

import imyeom_lck.rank.domain.entity.Rank;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


/**
 * 다대다 관계를 연결 해주는 단순 연결 엔티티 입니다.
 * */
@Table
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TeamRank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teamRankId;


    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;


    @ManyToOne
    @JoinColumn(name = "rank_id")
    private Rank rank;

}
