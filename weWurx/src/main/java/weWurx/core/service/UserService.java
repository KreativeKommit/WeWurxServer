package weWurx.core.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import weWurx.core.domain.Role;
import weWurx.core.domain.User;
import weWurx.core.repository.UserRepo;

@Service
@Transactional
public class UserService  implements UserDetailsService {
	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private UserRepo userInfoRepo;

	public User register(User userInfo) {

		userInfo.getRoles().clear();
		userInfo.getRoles().add(Role.ROLE_USER);
		userInfo.setEnabled(true);
		userInfo.setAccountNonExpired(true);
		userInfo.setAccountNonLocked(true);
		userInfo.setCredentialsNonExpired(true);
		userInfo.setPassword(encoder.encode(userInfo.getPassword()));
		userInfoRepo.save(userInfo);
		

		return userInfo;

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User userInfo = userInfoRepo.findByUsernameIgnoreCase(username)
				.orElseThrow(() -> new UsernameNotFoundException(""));
		UserBuilder userBuilder = null;
		userBuilder = org.springframework.security.core.userdetails.User.withUsername(userInfo.getUsername());
		userBuilder.disabled(!userInfo.isEnabled());
		userBuilder.password(userInfo.getPassword());
		String[] authorities = userInfo.getRoles().stream().map(a -> a.getAuthority()).toArray(String[]::new);
		userBuilder.authorities(authorities);

		UserDetails userDetails = userBuilder.build();
		return userDetails;

	}
	
	public User findUser(String username) {
		return userInfoRepo.findByUsernameIgnoreCase(username).orElseThrow();
	}

}
