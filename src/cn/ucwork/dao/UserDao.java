package cn.ucwork.dao;

import cn.ucwork.bean.User;

public interface UserDao {
	
	/**
	 * ����û�
	 * @param u
	 */
	public void addUser(User u);
	
	/**
	 * ��ѯ�û�
	 * @param user_email
	 * @return
	 */
	public User queryUser(String user_email);
	
	/**
	 * �޸��û���Ϣ
	 * @param u
	 */
	public void updateUser(User u);
}
