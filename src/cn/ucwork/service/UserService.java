package cn.ucwork.service;

import cn.ucwork.bean.User;

public interface UserService {
	/**
	 * ע�����û�
	 * 
	 * ������֤�빦�ܵ�ʵ�֣�
	 * ���������֤�룬��beanutils.populate��װ�û�������Ϣ'user',�ַ���VerifyEmailServlet����verifyCode��������֤�ʼ�,
	 * ��user��verifyCode����request���ַ���registServlet,�����л�������
	 * 
	 * ע�᣺
	 * �ύ���ݣ����û�������֤���request�ӵ���֤����бȽ�
	 * @return
	 */
	public void registUserAndVerifyEmail(User user,String verifyCode);
	
	
	/**
	 * �û���¼,������ͼƬ��֤����֤
	 * @param user_email
	 * @param passwd
	 * @return
	 */
	public User login(String user_email,String passwd,String imgVerifyCode);
	
	/**
	 * �޸��û���Ϣ
	 * @param user
	 */
	public void updateUserInfo(User user);
	
	/**
	 * �ж��Ƿ��������
	 * @param user_email
	 * @return
	 */
	public boolean checkEmail(String user_email); 
	
}
