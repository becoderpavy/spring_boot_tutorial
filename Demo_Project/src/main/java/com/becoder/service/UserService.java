package com.becoder.service;

import com.becoder.entity.User;

public interface UserService {

	public User saveUser(User user, String url);

	public void removeSessionMessage();

	public void sendEmail(User user, String path);

	public boolean verifyAccount(String verificationCode);

	public void increaseFailedAttempt(User user);

	public void resetFailedAttempt(String email);

	public void lock(User user);

	public boolean unlockWhenTimeExpired(User user);

}
