package cn.ucwork.dao;

import java.sql.SQLException;
import java.util.List;

import cn.ucwork.bean.Code;

public interface CodeDao {
	/**
	 * 数据库保存代码信息
	 * @param c
	 * @throws SQLException 
	 */
	public void addCode(Code c) throws SQLException;
	
	/**
	 * 根据user_id查询代码
	 * @return
	 */
	public List<Code> queryCodeByUser_id(String user_id);
	
	/**
	 * 根据user_id查询公开代码
	 * @param user_id
	 * @return
	 */
	public List<Code> queryPublicCodeByUser_id(String user_id);
	
}
