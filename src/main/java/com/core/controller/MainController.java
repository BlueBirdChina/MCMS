package com.core.controller;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.core.service.CoreManager;

@Controller
public class MainController {

	@Autowired
	private CoreManager coreManager;

	@RequestMapping(value = "/Init", method = RequestMethod.GET)
	public String init(HttpServletRequest request, ModelMap model) {
		coreManager.initSystem();
		return "pages/login";

	}

	@RequestMapping(value = { "/", "/Welcome" }, method = RequestMethod.GET)
	public String defaultPage(HttpServletRequest request, ModelMap model) {
		return "pages/hello";

	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(HttpServletRequest request, ModelMap model) {

		model.addAttribute("title",
				"Spring Security Login Form - Database Authentication");
		model.addAttribute("message", "This page is for ROLE_ADMIN only!");
		return "user/admin";

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,
			HttpServletRequest request, ModelMap model) {
		Boolean loginSuccess = true;
		if (error != null) {
			loginSuccess = false;
			model.addAttribute("error", "Invalid username and password!");
		}

		if (logout != null) {
			loginSuccess = false;
			model.addAttribute("msg", "You've been logged out successfully.");
		}
		if (loginSuccess) {
		}
		return "pages/login";

	}

	// for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accesssDenied(HttpServletRequest request, ModelMap model) {

		// check if user is login
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);

			model.addAttribute("username", userDetail.getUsername());

		}

		return "pages/403";

	}

}