package imyeom_lck.member.domain.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLRestriction;

import imyeom_lck.PointUsage;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
login_id varchar(255) unique not null, password varchar(255) not null, 
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
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@DynamicInsert
@DynamicUpdate
@SQLRestriction("IS_DELETED = false")
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private Long memberId;

    @OneToMany(mappedBy = "members", fetch = FetchType.LAZY)
    private List<PointUsage> pointUsages;

    private Long financeId;

    @Column(nullable = false, unique = true)
    private String loginId;

    @Column(nullable = false)
    private String password;

    private String name;

    private String phoneNumber;

    private String cheeringTeam;

    private boolean connectionStatus;

    private int point;

    private String alert;

    @Column(name = "connection_date")
    private List<LocalDateTime> connectionDate;

    private boolean isDeleted;

    public Member deletedMember(String loginId) {
        this.loginId = "deleted" + loginId;
        this.isDeleted = true;
        return this;
    }
}

