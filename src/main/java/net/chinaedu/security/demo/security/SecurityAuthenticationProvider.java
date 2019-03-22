package net.chinaedu.security.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class SecurityAuthenticationProvider implements AuthenticationProvider {
	@Autowired
	SecurityUserDetailService securityUserDetailService;
 
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName().trim();
        String password = authentication.getCredentials().toString();
        SecurityUser securityUser = (SecurityUser) securityUserDetailService.loadUserByUsername(username);
        if (securityUser == null) {
        	throw new DisabledException("账号不存在！");
        }
        if (!securityUser.getPassword().equals(password)) {
        	throw new BadCredentialsException("密码不正确！");
        }
        if (securityUser.getStatus() != 0) {
        	throw new LockedException("已锁定的账号！");
        }
		return new UsernamePasswordAuthenticationToken(username, password, securityUser.getAuthorities());
	}
 
	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}
}
