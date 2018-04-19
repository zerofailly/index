package cn.ucwork.service.impl;

import java.sql.SQLException;

import cn.ucwork.bean.User;
import cn.ucwork.dao.UserDao;
import cn.ucwork.daoImpl.UserDaoImpl;
import cn.ucwork.exception.UserException;
import cn.ucwork.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public void registUserAndVerifyEmail(User user) throws UserException {
		UserDaoImpl ud = new UserDaoImpl();
		try {
			ud.addUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException("注册失败");
		}
		
	}

	@Override
	public User login(String user_email, String passwd) throws UserException {
		UserDao ud = new UserDaoImpl();
		
		try {
			User user = ud.queryUser(user_email);
			if(user!=null && passwd.equals(user.getPasswd())){
				return user;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException("用户不存在");
		}
		return null;
	}

	@Override
	public void updateUserInfo(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public User checkEmail(String user_email) {
		UserDaoImpl ud = new UserDaoImpl();
		try {
			return ud.queryUser(user_email);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
