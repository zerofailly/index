package cn.ucwork.service;

import cn.ucwork.bean.User;

public interface UserService {
	/**
	 * 注册新用户
	 * 
	 * 邮箱验证码功能的实现：
	 * 点击发送验证码，用beanutils.populate封装用户输入信息'user',分发到VerifyEmailServlet生成verifyCode并发送验证邮件,
	 * 将user和verifyCode存入request，分发回registServlet,并进行回显数据
	 * 
	 * 注册：
	 * 提交数据，将用户输入验证码和request钟的验证码进行比较
	 * @return
	 */
	public void registUserAndVerifyEmail(User user,String verifyCode);
	
	
	/**
	 * 用户登录,防机器图片验证码验证
	 * @param user_email
	 * @param passwd
	 * @return
	 */
	public User login(String user_email,String passwd,String imgVerifyCode);
	
	/**
	 * 修改用户信息
	 * @param user
	 */
	public void updateUserInfo(User user);
	
	/**
	 * 判断是否存在邮箱
	 * @param user_email
	 * @return
	 */
	public boolean checkEmail(String user_email); 
	
}
