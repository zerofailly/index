package cn.ucwork.dao;

import java.sql.SQLException;
import java.util.List;

import cn.ucwork.bean.Code;

public interface CodeDao {
	/**
	 * ���ݿⱣ�������Ϣ
	 * @param c
	 * @throws SQLException 
	 */
	public void addCode(Code c) throws SQLException;
	
	/**
	 * ����user_id��ѯ����
	 * @return
	 */
	public List<Code> queryCodeByUser_id(String user_id);
	
	/**
	 * ����user_id��ѯ��������
	 * @param user_id
	 * @return
	 */
	public List<Code> queryPublicCodeByUser_id(String user_id);
	
}
