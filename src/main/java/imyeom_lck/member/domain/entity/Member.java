package imyeom_lck.member.domain.entity;


import imyeom_lck.pointusage.domain.entity.PointUsage;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDateTime;
import java.util.List;

@Table
@Entity
public class Member {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

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
    public static class Member {

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
}
