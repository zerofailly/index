package cn.ucwork.dao;

import java.util.List;

import cn.ucwork.bean.User;

public interface FriendDao {
	/**
	 * ����user_id�ҵ�����
	 * @param user_id
	 * @return 
	 */
	public List<User> queryFriendByUser_id(String user_id);
}
