package com.becoder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.becoder.repository.UserDao;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public String saveUser() {
		boolean f = userDao.save();
		if (f) {
			return "Register success";
		} else {
			return "Server Error";
		}
	}

}
