package imyeom_lck.league.domain.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "ranks")
@Getter
@Entity
public class Rank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rankId;
    private String logo;
    private String TeamName;
    private int win;
    private int lose;
    private String difference;
    private String winrate;
    private Long kda;
    private int killcount;
    private int deathcount;
    private int assistcount;
}
