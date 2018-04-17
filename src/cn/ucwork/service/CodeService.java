package cn.ucwork.service;

import java.util.List;

import cn.ucwork.bean.Code;

public interface CodeService {
	/**
	 * ����������Ϣ
	 * @return Code����
	 */
	public Code createCodeInfo();
	
	/**
	 * ���������Ϣ
	 * @param c
	 */
	public void saveCode(Code c);
	
	/**
	 * ����user_id��ѯ����
	 * @param user_id
	 * @return
	 */
	public List<Code> queryCodeByUser_id(String user_id);
	
	/**
	 * ����user_id��ѯ��������
	 * @return
	 */
	public List<Code> queryPublicCodeByUser_id(String user_id);
	
	
	
	
	
	
}
