package com.becoder.config;

import java.io.IOException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.becoder.entity.User;
import com.becoder.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomAuthSucessHandler implements AuthenticationSuccessHandler {

	@Autowired
	private UserService userService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

		CustomUser customUser = (CustomUser) authentication.getPrincipal();
		User user = customUser.getUser();

		if (user != null) {
			userService.resetAttempt(user.getEmail());
		}

		if (roles.contains("ROLE_ADMIN")) {
			response.sendRedirect("/admin/profile");
		} else {
			response.sendRedirect("/user/profile");
		}

	}

}
