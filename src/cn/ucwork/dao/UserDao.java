package cn.ucwork.dao;

import java.sql.SQLException;

import cn.ucwork.bean.User;

public interface UserDao {
	
	/**
	 * ����û�
	 * @param u
	 * @throws SQLException 
	 */
	public void addUser(User u) throws SQLException;
	
	/**
	 * ��ѯ�û�
	 * @param user_email
	 * @return
	 * @throws SQLException 
	 */
	public User queryUser(String user_email) throws SQLException;
	
	/**
	 * �޸��û���Ϣ
	 * @param u
	 */
	public void updateUser(User u);
}
