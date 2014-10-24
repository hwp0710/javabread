package com.shengsiyuan.service.impl;

import com.shengsiyuan.service.LoginService;

public class LoginServiceImpl implements LoginService {
	@Override
	public boolean isLogin(String username, String password) {
		if ("hello".equals(username) && "world".equals(password)) {
			return true;
		}

		return false;
	}

}
