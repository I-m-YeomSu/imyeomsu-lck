package imyeom_lck.member.domain.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLRestriction;

import imyeom_lck.pointusage.domain.entity.PointUsage;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SQLRestriction("IS_DELETED = false")
@Table(name = "members")
public class Member {

    @Schema(description = "유저 번호", example = "1")
    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memberId;

    @Schema(description = "포인트 사용내역", example = "pointUsages")
    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name = "point_usage_id")
    private List<PointUsage> pointUsages;

    @Schema(description = "금융상픔번호", example = "1")
    @Column(nullable = false)
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
    private boolean isAlert;

    @Schema(description = "유저 삭제상태", example = "false")
    private boolean isDeleted;


    public Member deletedMember(String loginId) {
        this.loginId = "deleted" + loginId;
        this.isDeleted = true;
        return this;

    }



}