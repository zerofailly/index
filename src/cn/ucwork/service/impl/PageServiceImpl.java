package cn.ucwork.service.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import cn.ucwork.bean.Code;
import cn.ucwork.bean.Page;
import cn.ucwork.bean.Share;
import cn.ucwork.bean.User;
import cn.ucwork.dao.PageDao;
import cn.ucwork.dao.impl.PageDaoImpl;
import cn.ucwork.service.PageService;

public class PageServiceImpl implements PageService {

	private PageDao dao= new PageDaoImpl();
	public PageServiceImpl() {
	}

	@Override
	public Page<User> getFriendtPage(Page<User> p, String user_id) {
		// TODO Auto-generated method stub
		
		p = dao.getFriendtPage(p, user_id);
		return p;
	}

	@Override
	public Page<Code> getCodePage(Page<Code> p, String user_id) {
		p = dao.getCodePage(p, user_id);
		return p;
	}

	@Override
	public Page<Share> getSharePage(Page<Share> p, String user_id) {
		// TODO Auto-generated method stub
		return null;
	}


}
