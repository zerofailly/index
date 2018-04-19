package cn.ucwork.service;

import cn.ucwork.bean.User;
import cn.ucwork.exception.UserException;

public interface UserService {
	/**
	 * 注册新用户
	 * 
	 * 邮箱验证码功能的实现：
	 * 注册：
	 * 
	 * @return
	 * @throws UserException 
	 */
	public void registUserAndVerifyEmail(User user) throws UserException;
	
	
	/**
	 * 用户登录,防机器图片验证码验证
	 * @param user_email
	 * @param passwd
	 * @return
	 * @throws UserException 
	 */
	public User login(String user_email,String passwd) throws UserException;
	
	/**
	 * 修改用户信息
	 * @param user
	 */
	public void updateUserInfo(User user);
	
	/**
	 * 判断是否存在邮箱
	 * @param user_email
	 * @return user
	 * @throws UserException 
	 */
	public User checkEmail(String user_email); 
	
}
