package cn.ucwork.util;

import java.sql.Connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utill {
	static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	
	public static Connection getConnection() throws Exception{
		return  dataSource.getConnection();
	}

	public static ComboPooledDataSource getDataSource() {
		return dataSource;
	}
	

}
