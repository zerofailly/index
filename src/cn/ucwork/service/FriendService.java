package cn.ucwork.service;

import java.util.List;

import cn.ucwork.bean.User;

public interface FriendService {
	/**
	 * ¸ù¾İuser_idÕÒµ½ÅóÓÑ
	 * @param user_id
	 * @return 
	 */
	public List<User> queryFriendByUser_id(String user_id);
}
