package cn.ucwork.dao;

import java.util.List;

import cn.ucwork.bean.User;

public interface FriendDao {
	/**
	 * ¸ù¾İuser_idÕÒµ½ÅóÓÑ
	 * @param user_id
	 * @return 
	 */
	public List<User> queryFriendByUser_id(String user_id);
}
