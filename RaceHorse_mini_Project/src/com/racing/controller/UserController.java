package com.racing.controller;

import com.racing.model.service.UserService;
import com.racing.model.vo.User;

public class UserController {
	private UserService userService = new UserService();
	public static User loginUser = null;

	public boolean login(String id, String pw) {
		User user = userService.selectByID(id);
		if (user == null) {
			return false;
		}

		if (user.getPassword().equals(pw) == true) {
			loginUser = user;
			return true;
		} else {
			return false;
		}
	}

	public static void logout() {
		loginUser = null;
	}

	public static User getLoginUser() {
		return loginUser;
	}

}
