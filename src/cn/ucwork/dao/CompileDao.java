package cn.ucwork.dao;

import java.io.IOException;

public interface CompileDao {
	/**
	 * �����ļ�
	 * @param content
	 * @param fileName
	 * @param path
	 * @throws IOException 
	 */
	public void creatFile(String content, String fileName, String path) throws IOException;
	
	/**
	 * �����ļ�
	 * @param path
	 * @param fileName
	 * @param compileType
	 * @return ִ�н��
	 * @throws Exception 
	 */
	public String compileJavaFileByOrder(String path, String fileName, String compileType) throws Exception;
	
}
