package cn.ucwork.service;

public interface SendEmailService {
	/**
	 * �����ʼ�����
	 * @param getEmail ��������
	 * @param emailMsg ������Ϣ
	 * @return �Ƿ��ͳɹ�
	 */
	public boolean sendEmail(String getEmail, String emailMsg);
}
