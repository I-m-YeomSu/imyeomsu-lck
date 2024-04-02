package imyeom_lck.member.domain.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memberId;

    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name = "point_usage_id")
    private List<PointUsage> pointUsages;

    @Column(nullable = false)
    private Long financeId;

    @Column(nullable = false)
    private String loginId;

    private String password;

    private String name;

    private String phoneNumber;

    private String cheeringTeam;

    private boolean connectionStatus;

    private int point;

    private boolean isAlert;

    private boolean isDeleted;


    public Member deletedMember(String loginId) {
        this.loginId = "deleted" + loginId;
        this.isDeleted = true;
        return this;

    }



}