package cn.ucwork.daoImpl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.ucwork.bean.User;
import cn.ucwork.dao.UserDao;
import cn.ucwork.util.C3P0Utill;

public class UserDaoImpl implements UserDao {

	@Override
	public void addUser(User user) throws SQLException {
		System.out.println("UserDaoImpl:"+user.getPasswd());
		QueryRunner qr = new QueryRunner(C3P0Utill.getDataSource());
		qr.update("insert into user(user_id,user_email,passwd,NAME,person_name,icon,bg_icon)VALUES(?,?,?,?,?,?,?)",
				user.getUser_id(), user.getUser_email(), user.getPasswd(), user.getName(), user.getPerson_name(), user.getIcon(),
				user.getBg_icon());

	}

	@Override
	public User queryUser(String user_email) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utill.getDataSource());
		return qr.query("select *from user where user_email=?", new BeanHandler<User>(User.class), user_email);
	}

	@Override
	public void updateUser(User u) {
		// TODO Auto-generated method stub

	}

}
