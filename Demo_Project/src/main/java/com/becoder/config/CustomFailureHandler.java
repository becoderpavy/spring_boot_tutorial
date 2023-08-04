package com.becoder.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

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
		System.out.println("failure handler");
		String email = request.getParameter("username");
		User user = userRepo.findByEmail(email);

		if (user != null) {
			if (user.isEnable()) {

				if (user.isAccountNonLocked()) {
					if (user.getFailedAttempt() < UserServiceImpl.MAX_FAILED_ATTEMPTS - 1) {
						userService.increaseFailedAttempt(user);
					} else {
						userService.lock(user);
						exception = new LockedException(
								"Account locked 3 failed attempt ! it will be unlocked after 1 minutes");
					}
				} else if (!user.isAccountNonLocked()) {
					if (userService.unlockWhenTimeExpired(user)) {
						exception = new LockedException("your account is unlocked ,Again login");
					} else {
						exception = new LockedException("your account is locked ,please try again somethimes");
					}
				}
			} else {
				exception = new LockedException("your account is inactive ,please verify");
			}
		}
		super.setDefaultFailureUrl("/signin?error");
		super.onAuthenticationFailure(request, response, exception);
	}

}
