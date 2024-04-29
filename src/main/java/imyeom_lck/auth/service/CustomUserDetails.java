package imyeom_lck.auth.service;

import imyeom_lck.member.domain.entity.MemberRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import imyeom_lck.member.domain.entity.Member;

public class CustomUserDetails implements UserDetails {
	private final Long memberId;
	private final String loginId;
	private final String password;
	private boolean isDeleted;
	private Collection<SimpleGrantedAuthority> authorities =new ArrayList<>();

	public CustomUserDetails(Member member, List<MemberRole> roles) {
		this.memberId = member.getMemberId();
		this.loginId = member.getLoginId();
		this.password = member.getPassword();
		this.isDeleted = member.isDeleted();
		this.authorities=toGrantedAuthority(roles);
	}

	public static CustomUserDetails createUser(Member member, List<MemberRole> roles){
		return new CustomUserDetails(member, roles);
	}

	 private Collection<SimpleGrantedAuthority> toGrantedAuthority(List<MemberRole> roles) {
		List<SimpleGrantedAuthority> collections = new ArrayList<>();

	 	for (MemberRole dto : roles) {
			String roleName = dto.getRole().getName();
	 		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(roleName);
			collections.add(simpleGrantedAuthority);
	 	}
	 	return collections;
	 }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.loginId;
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.isDeleted;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.isDeleted;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.isDeleted;
	}

	@Override
	public boolean isEnabled() {
		return this.isDeleted;
	}
}