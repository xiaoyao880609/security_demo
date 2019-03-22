package net.chinaedu.security.demo.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import net.chinaedu.security.demo.datasource.UserDataSource;

@Service
public class SecurityUserDetailService implements UserDetailsService {
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return UserDataSource.getSecurityUser(username);
	}
}
