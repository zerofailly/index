package cn.ucwork.service.impl;

import cn.ucwork.bean.User;
import cn.ucwork.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public void registUserAndVerifyEmail(User user, String verifyCode) {
		// TODO Auto-generated method stub

	}

	@Override
	public User login(String user_email, String passwd, String imgVerifyCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUserInfo(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean checkEmail(String user_email) {
		// TODO Auto-generated method stub
		return false;
	}

}
