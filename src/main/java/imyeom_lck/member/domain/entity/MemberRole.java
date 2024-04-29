package imyeom_lck.member.domain.entity;

import java.io.Serializable;

import imyeom_lck.member.domain.entity.Member;
import imyeom_lck.role.domain.entity.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


/*
CREATE TABLE members_roles (
    account_id BIGINT,
    role_id BIGINT,
    PRIMARY KEY (account_id, role_id),
    FOREIGN KEY (account_id) REFERENCES members(member_id),
    FOREIGN KEY (role_id) REFERENCES roles(role_id)
);
 */

@Table(name = "members_roles")
@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
public class MemberRole {


	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long memberRoleId;


     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "member_id")
     private Member member;


	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "role_id")
	 private Role role;


	public static MemberRole createMemberRole(Member member, Role role){
		return MemberRole.builder()
				.member(member)
				.role(role)
				.build();
	}

}