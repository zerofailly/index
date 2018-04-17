package cn.ucwork.dao;

import java.util.List;

import cn.ucwork.bean.Code;

public interface ShareDao {
	/**
	 * ����user_id��user_email�ҵ�����
	 * @param user_id user_id
	 * @param user_email user_email
	 * @return
	 */
	public List<Code> queryByUser_idAndUser_email(String user_id,String user_email);
	
	
}
