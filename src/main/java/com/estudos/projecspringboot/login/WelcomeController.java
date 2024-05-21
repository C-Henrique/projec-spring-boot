package com.estudos.projecspringboot.login;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {

	@GetMapping("/")
	public String gotoWelcomePage(ModelMap model) {
		model.put("name", this.getLoggedinUsername());
		return "welcome";
	}

	private String getLoggedinUsername() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
}
