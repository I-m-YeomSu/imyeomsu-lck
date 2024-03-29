package imyeom_lck;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
public class MemberRole {
	
	 @EmbeddedId
	 private Pk pk;
	 
	 @MapsId("memberId")
     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "member_id")
     private Member member;
	 
	 @MapsId("roleId")
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "role_id")
	 private Role role;
	 
	 @Embeddable
     @EqualsAndHashCode
     @Getter
     @Builder
     @AllArgsConstructor
     @NoArgsConstructor
     public static class Pk implements Serializable {

         @Column(name = "account_id")
         private Long memberId;

         @Column(name = "role_id")
         private Long roleId;
 
     }
	 
	 public static MemberRole createAccountRole(Member member, Role role){
	        return MemberRole.builder()
	                .pk(Pk.builder()
	                        .roleId(role.getRoleId())
	                        .memberId(member.getMemberId())
	                        .build())
	                .member(member)
	                .role(role)
	                .build();
	 }
	 
}