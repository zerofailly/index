package cn.ucwork.service;

import java.util.List;

import cn.ucwork.bean.User;

public interface FriendService {
	/**
	 * ����user_id�ҵ�����
	 * @param user_id
	 * @return 
	 */
	public List<User> queryFriendByUser_id(String user_id);
}
