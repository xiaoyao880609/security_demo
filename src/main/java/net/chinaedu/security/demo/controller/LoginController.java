package net.chinaedu.security.demo.controller;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public ModelAndView hello(Model model, HttpServletRequest request){
    	
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null && !authentication.getName().equalsIgnoreCase("anonymousUser")) {
			Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
			if (roles.contains("ROLE_ADMIN")) {//根据登录用户权限跳转默认页面
				return new ModelAndView("redirect:admin");
			} else if (roles.contains("ROLE_USER")) {
				return new ModelAndView("redirect:user");
			} else if (roles.contains("ROLE_OHTER")) {
				return new ModelAndView("redirect:main");
			}
		}
		HttpSession session = request.getSession(false);
		if (session != null) {
			Object errMsg = session.getAttribute("errMsg");
			if (errMsg != null) {
				model.addAttribute("errMsg", errMsg);
				session.removeAttribute("errMsg");
			}
		}
		return new ModelAndView("login");
    }
}
