package cn.ucwork.dao;

import java.io.IOException;

public interface CompileDao {
	/**
	 * 创建文件
	 * @param content
	 * @param fileName
	 * @param path
	 * @throws IOException 
	 */
	public void creatFile(String content, String fileName, String path) throws IOException;
	
	/**
	 * 编译文件
	 * @param path
	 * @param fileName
	 * @param compileType
	 * @return 执行结果
	 * @throws Exception 
	 */
	public String compileJavaFileByOrder(String path, String fileName, String compileType) throws Exception;
	
}
