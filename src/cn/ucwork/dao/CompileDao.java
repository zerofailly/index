package cn.ucwork.dao;

public interface CompileDao {
	/**
	 * 创建文件
	 * @param content
	 * @param fileName
	 * @param path
	 */
	public void creatFile(String content, String fileName, String path);
	
	/**
	 * 编译文件
	 * @param path
	 * @param fileName
	 * @param compileType
	 * @return 执行结果
	 */
	public String compileJavaFileByOrder(String path, String fileName, String compileType);
}
