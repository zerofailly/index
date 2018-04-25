package cn.ucwork.dao;

import cn.ucwork.bean.Code;
import cn.ucwork.bean.Page;
import cn.ucwork.bean.Share;
import cn.ucwork.bean.User;

public interface PageDao {

	public Page<User> getFriendtPage(Page<User> p, String user_id);
	public Page<Code> getCodePage(Page<Code> p, String user_id);
	public Page<Share> getSharePage(Page<Share> p, String user_id);
}
