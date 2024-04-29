package imyeom_lck.auth.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return null;
	}
	//
	// private final QueryAccountRoleRepository queryAccountRoleRepository;
	// private final AccountRepository accountRepository;
	//
	// @Override
	// public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	//
	// 	List<RoleNameDTO> roles = queryAccountRoleRepository.findAccountRoleByLoginId(username);
	// 	Optional<Account> optionalAccount = accountRepository.findAccountByLoginId(username);
	//
	// 	if (optionalAccount.isEmpty()) {
	// 		throw new BadCredentialsException("해당 로그인 아이디를 가진 회원이 존재하지 않습니다.");
	// 	}
	// 	Account account = optionalAccount.get();
	// 	return new CustomUserDetails(account, roles);
	// }
}
