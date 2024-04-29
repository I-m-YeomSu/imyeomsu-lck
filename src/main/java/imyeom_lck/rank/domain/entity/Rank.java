package imyeom_lck.rank.domain.entity;


import jakarta.persistence.*;
import lombok.*;


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
    private String teamName;
    private int win;
    private int lose;
    private String difference;
    private String winrate;
    private Long kda;
    private int killCount;
    private int deathCount;
    private int assistCount;
}
