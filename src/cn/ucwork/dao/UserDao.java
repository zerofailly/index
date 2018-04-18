package cn.ucwork.dao;

import java.sql.SQLException;

import cn.ucwork.bean.User;

public interface UserDao {
	
	/**
	 * 添加用户
	 * @param u
	 * @throws SQLException 
	 */
	public void addUser(User u) throws SQLException;
	
	/**
	 * 查询用户
	 * @param user_email
	 * @return
	 * @throws SQLException 
	 */
	public User queryUser(String user_email) throws SQLException;
	
	/**
	 * 修改用户信息
	 * @param u
	 */
	public void updateUser(User u);
}
