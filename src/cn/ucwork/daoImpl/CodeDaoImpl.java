package cn.ucwork.daoImpl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import cn.ucwork.bean.Code;
import cn.ucwork.dao.CodeDao;
import cn.ucwork.util.C3P0Utill;

public class CodeDaoImpl implements CodeDao {

	@Override
	public void addCode(Code c) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utill.getDataSource());
		qr.update(
				"INSERT INTO CODE (code_id,path,user_id,is_public,is_copy,fileName,description) VALUES(?,?,?,?,?,?,?)",
				c.getCode_id(), c.getPath(), c.getUser_id(), "public".equals(c.getIs_public())?1:0, "copy".equals(c.getIs_copy())?1:0, c.getFileName(),
				c.getDescription());
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
