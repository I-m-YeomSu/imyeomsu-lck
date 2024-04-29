package imyeom_lck.auth.service;

import imyeom_lck.member.domain.entity.Member;
import imyeom_lck.member.domain.entity.MemberRole;
import imyeom_lck.member.persistence.jpa.JpaMemberRepository;
import imyeom_lck.member.persistence.querydsl.inter.QueryMemberRoleRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

	private final JpaMemberRepository memberRepository;
	private final QueryMemberRoleRepository memberRoleRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<MemberRole> roles = memberRoleRepository.findByMemberLoginId(username);
		Member member = memberRepository.findByLoginId(username)
				.orElseThrow(() -> new UsernameNotFoundException(username));


		return CustomUserDetails.createUser(member, roles);
	}



}
