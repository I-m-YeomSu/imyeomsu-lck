package imyeom_lck.member.domain.entity;


import jakarta.persistence.*;

@Table
@Entity
public class Member {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

}
