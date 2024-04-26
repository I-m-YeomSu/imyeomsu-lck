package imyeom_lck.predict.domain.entity;

import imyeom_lck.predict.domain.dto.PredictDTO;
import imyeom_lck.predict.domain.dto.VotedUserDTO;
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
@DynamicInsert
@DynamicUpdate
@Entity
public class VotedUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long votedUserId;
    private int year;
    private int month;
    private Long predictId;
    private Long memberId;
    private boolean flag;


}
