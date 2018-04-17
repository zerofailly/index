package cn.ucwork.service;

import java.util.List;

import cn.ucwork.bean.Code;

public interface ShareService {
	/**
	 * ����user_id��user_email�ҵ��Ҹ����˷���Ĵ���
	 * @param user_id �ҵ�id
	 * @param user_email ���˵�email
	 * @return
	 */
	public List<Code> queryTo_CodeByUser_idAndUser_email(String user_id,String user_email);
	
	/**
	 * ����user_id��user_email�ҵ����˸��ҷ���Ĵ���
	 * @param user_id ���˵�user_id
	 * @param user_email �ҵ�email
	 * @return
	 */
	public List<Code> queryGet_CodeByUser_idAndUser_email(String user_id,String user_email);
}
