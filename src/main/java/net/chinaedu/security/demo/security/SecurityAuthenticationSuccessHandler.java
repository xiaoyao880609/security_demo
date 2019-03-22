package net.chinaedu.security.demo.security;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class SecurityAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	@Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
		try {
			Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
			if (roles.contains("ROLE_ADMIN")) {
				response.sendRedirect("admin");
			} else if (roles.contains("ROLE_USER")) {
				response.sendRedirect("user");
			} else {
				response.sendRedirect("main");
			}
		} catch (Exception e) {
			response.sendRedirect("error");
		}
	}

}
