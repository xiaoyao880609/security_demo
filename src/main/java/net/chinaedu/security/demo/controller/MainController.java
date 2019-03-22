package net.chinaedu.security.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping("/main")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER', 'ROLE_OTHER')")
    public ModelAndView main(){
        return new ModelAndView("main");
    }

    @RequestMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView admin(){
        return new ModelAndView("admin");
    }
    
    @RequestMapping("/user")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ModelAndView user(){
    	return new ModelAndView("user");
    }
}
