package cn.ucwork.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import cn.ucwork.bean.Code;
import cn.ucwork.dao.CodeDao;
import cn.ucwork.daoImpl.CodeDaoImpl;
import cn.ucwork.exception.CodeException;
import cn.ucwork.service.CodeService;

public class CodeServiceImpl implements CodeService {

	@Override
	public Code createCodeInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCode(Code c) throws CodeException {
		CodeDao cd = new CodeDaoImpl();
		try {
			cd.addCode(c);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CodeException("代码存入数据库失败！");
		}
	}

	@Override
	public List<Code> queryCodeByUser_id(String user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Code> queryPublicCodeByUser_id(String user_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
