package cn.ucwork.service;

public interface SendEmailService {
	/**
	 * 发送邮件服务
	 * @param getEmail 接受信箱
	 * @param emailMsg 发送消息
	 * @return 是否发送成功
	 */
	public boolean sendEmail(String getEmail, String emailMsg);
}
