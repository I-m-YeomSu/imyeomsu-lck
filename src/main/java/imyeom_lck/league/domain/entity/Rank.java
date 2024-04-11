package imyeom_lck.league.domain.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "ranks")
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
    private int kill;
    private int death;
    private int assist;
}
