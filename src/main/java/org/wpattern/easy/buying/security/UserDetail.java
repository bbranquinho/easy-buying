package org.wpattern.easy.buying.security;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.wpattern.easy.buying.permission.Permission;
import org.wpattern.easy.buying.user.User;
import org.wpattern.easy.buying.user.UserRepository;


@Component
public class UserDetail implements UserDetailsService {

	private static final Logger LOGGER = LogManager.getLogger(UserDetail.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		LOGGER.info("TESTEEEEEE " + encoder.encode("admin"));

		User user = this.userRepository.findByEmail(email);

		LOGGER.info("TESTEEEEEE " + user);

		if (user == null) {
			throw new UsernameNotFoundException("User with email \"" + email + "\" was not found");
		}

		LoginDetailBean login = new LoginDetailBean(user.getName(), user.getEmail(), user.getPassword());

		for (Permission permission : user.getPermissions()) {
			login.addRole(permission.getRole());
		}

		return login;
	}

}
