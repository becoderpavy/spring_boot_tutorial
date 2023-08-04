package com.becoder.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.becoder.entity.User;
import com.becoder.repository.UserRepo;
import com.becoder.service.UserService;
import com.becoder.service.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepo userRepo;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {

		String email = request.getParameter("username");
		User user = userRepo.findByEmail(email);

		if (user != null) {
			if (user.isEnable()) {

				if (user.isAccountNonLocked()) {
					if (user.getFailedAttempt() < UserServiceImpl.ATTEMPT_TIME - 1) {
						userService.increaseFailedAttempt(user);
					} else {
						userService.lock(user);
						exception = new LockedException("Your account is locked !! failed attempt 3");
					}
				} else if (!user.isAccountNonLocked()) {
					if (userService.unlockAccountTimeExpired(user)) {
						exception = new LockedException("Account is unlocked! Please try to login");
					} else {
						exception = new LockedException("Account is locked! Please try after 24hours");
					}
				}
			} else {
				exception = new LockedException("Account is inactive..verify account");
			}
		}
		super.setDefaultFailureUrl("/signin?error");
		super.onAuthenticationFailure(request, response, exception);
	}

}
