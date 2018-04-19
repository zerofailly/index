package cn.ucwork.service;

import cn.ucwork.bean.User;
import cn.ucwork.exception.UserException;

public interface UserService {
	/**
	 * ע�����û�
	 * 
	 * ������֤�빦�ܵ�ʵ�֣�
	 * ע�᣺
	 * 
	 * @return
	 * @throws UserException 
	 */
	public void registUserAndVerifyEmail(User user) throws UserException;
	
	
	/**
	 * �û���¼,������ͼƬ��֤����֤
	 * @param user_email
	 * @param passwd
	 * @return
	 * @throws UserException 
	 */
	public User login(String user_email,String passwd) throws UserException;
	
	/**
	 * �޸��û���Ϣ
	 * @param user
	 */
	public void updateUserInfo(User user);
	
	/**
	 * �ж��Ƿ��������
	 * @param user_email
	 * @return user
	 * @throws UserException 
	 */
	public User checkEmail(String user_email); 
	
}
