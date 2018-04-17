package cn.ucwork.service;

import java.util.List;

import cn.ucwork.bean.Code;

public interface ShareService {
	/**
	 * 根据user_id和user_email找到我给别人分享的代码
	 * @param user_id 我的id
	 * @param user_email 别人的email
	 * @return
	 */
	public List<Code> queryTo_CodeByUser_idAndUser_email(String user_id,String user_email);
	
	/**
	 * 根据user_id和user_email找到别人给我分享的代码
	 * @param user_id 别人的user_id
	 * @param user_email 我的email
	 * @return
	 */
	public List<Code> queryGet_CodeByUser_idAndUser_email(String user_id,String user_email);
}
