package imyeom_lck.member.domain.entity;

import java.util.List;

import imyeom_lck.member.domain.dto.MemberUpdateDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;

import imyeom_lck.pointusage.domain.entity.PointUsage;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.springframework.web.bind.annotation.RequestMapping;

/*
CREATE TABLE members(
member_id bigint primary key auto_increment,
point_usage_id bigint,
finance_id bigint,
login_id varchar(255) unique not null, password varchar(255) not null,
name varchar(255),
phone_number varchar(255),
cheering_team varchar(255),
connection_status bit(1),
point int,
is_deleted bit(1),
alert varchar(255),
connection_date datetime
)
 */

@Getter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SQLRestriction("IS_DELETED = false")
@Table(name = "members")
public class Member {

    @Schema(description = "유저 번호", example = "1")// 스웨거 설정
    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memberId;

    @Schema(description = "금융상픔번호", example = "1")
    @Column(nullable = true)
    private Long financeId;

    @Schema(description = "유저 아이디", example = "loginId")
    @Column(nullable = false)
    private String loginId;

    @Schema(description = "유저 비밀번호", example = "password")
    private String password;

    @Schema(description = "유저 이름", example = "name")
    private String name;

    @Schema(description = "핸드폰 번호", example = "phoneNumber")
    private String phoneNumber;

    @Schema(description = "응원팀", example = "cheeringTeam")
    private String cheeringTeam;

    @Schema(description = "유저 접속정보", example = "connectionStatus")
    private boolean connectionStatus;

    @Schema(description = "보유 포인트", example = "point")
    private int point;

    @Schema(description = "알람", example = "true")
    private boolean alert;

    @Schema(description = "유저 삭제상태", example = "false")
    private boolean isDeleted;


    public Member deletedMember(String loginId) {
        this.loginId = "deleted" + loginId;
        this.isDeleted = true;
        return this;

    }

    public void updateMember(MemberUpdateDTO dto){
        this.loginId = dto.getLoginId();
        this.password = dto.getPassword();
        this.name = dto.getName();
        this.phoneNumber = dto.getPhoneNumber();
        this.cheeringTeam = dto.getCheeringTeam();
    }



}