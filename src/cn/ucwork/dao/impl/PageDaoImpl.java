package cn.ucwork.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.sun.org.apache.bcel.internal.generic.NEW;

import cn.ucwork.bean.Code;
import cn.ucwork.bean.Page;
import cn.ucwork.bean.Share;
import cn.ucwork.bean.User;
import cn.ucwork.dao.PageDao;
import cn.ucwork.util.C3P0Utill;

public class PageDaoImpl implements PageDao {

	private int getTotlaCount(String type, String user_id) {
		 QueryRunner q= new QueryRunner(C3P0Utill.getDataSource());
		 String sql="select count(*) from "+type;
		 if(user_id!=null) {
			 sql+= " where user_id = "+ user_id;
		 }
		 Object query = null;
		 try {
			query = q.query(sql, new ScalarHandler());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Integer(query.toString());
	}
	private List<User> getFriend(String user_id, int index, int CurrentCount) {
		QueryRunner q= new QueryRunner(C3P0Utill.getDataSource());
		String sql= "select * from friend where user_id = ? limit ?,?";
		List<Object> query = null;
		 try {
			  query = q.query(sql, new ColumnListHandler("user_email"),user_id,index, CurrentCount);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 List<User> friend= new LinkedList<User>();
		 for(Object o : query) {
			 try {
				User query2 = q.query("select * from user where user_email=?", new BeanHandler<User>(User.class), (String)o.toString());
				friend.add(query2);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		return friend;
	}
	@Override
	public Page<User> getFriendtPage(Page<User> p, String user_id) {
		// TODO Auto-generated method stub
		int currentCount = p.getCurrentCount();
		int currentPage = p.getCurrentPage();
		int totalCount= getTotlaCount("friend", user_id);
		p.setTotalCount(totalCount);
		int totalPage= (totalCount+currentCount-1)/currentCount;
		p.setTotalPage(totalPage);
		int index= (currentPage-1)*currentCount;
		List<User> friend = getFriend(user_id, index, currentCount);
		p.setObj(friend);
		return p;
	}

	@Override
	public Page<Code> getCodePage(Page<Code> p, String user_id) {
		// TODO Auto-generated method stub
		int currentCount = p.getCurrentCount();
		int currentPage = p.getCurrentPage();
		int totalCount = getTotlaCount("code", user_id);
		p.setTotalCount(totalCount);
		int totalPage= (totalCount+currentCount-1)/currentCount;
		p.setTotalPage(totalPage);
		int index= (currentPage-1)*currentCount;
		List<Code> query;
		if(user_id == null) {
			query = getCode(index, currentCount);
		}
		else
			query = getCode(user_id, index, currentCount);
		p.setObj(query);
		return p;
	}
	private List<Code> getCode(int index, int currentCount){
		QueryRunner q= new QueryRunner(C3P0Utill.getDataSource());
		List<Code> query =null;
		List<Code> listCode = new LinkedList<Code>();
		try {
			query = q.query("select * from code limit ? , ? ", new BeanListHandler<Code>(Code.class),index,currentCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Code code : query) {
			String user_id= code.getUser_id();
			try {
				User user = q.query("select * from user where user_id = ?", new BeanHandler<User>(User.class), user_id);
				code.setUser(user);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			listCode.add(code);
		}
		return listCode;
	}
	private List<Code> getCode(String user_id, int index, int currentCount) {
		QueryRunner q= new QueryRunner(C3P0Utill.getDataSource());
		List<Code> query =null;
		List<Code> listCode = new LinkedList<Code>();
		User user =  null;
		try {
			query = q.query("select * from code where  user_id = ? limit ? , ? ", new BeanListHandler<Code>(Code.class),user_id,index,currentCount);
			user= q.query("select * from user where user_id= ?", new BeanHandler<User>(User.class), user_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Code code : query) {
			code.setUser(user);
			listCode.add(code);
		}
		
		return listCode;
	}
	@Override
	public Page<Share> getSharePage(Page<Share> p, String user_id) {
		
		return null;
	}

}
