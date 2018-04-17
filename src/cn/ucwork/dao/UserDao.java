package cn.ucwork.dao;

import cn.ucwork.bean.User;

public interface UserDao {
	
	/**
	 * 添加用户
	 * @param u
	 */
	public void addUser(User u);
	
	/**
	 * 查询用户
	 * @param user_email
	 * @return
	 */
	public User queryUser(String user_email);
	
	/**
	 * 修改用户信息
	 * @param u
	 */
	public void updateUser(User u);
}
