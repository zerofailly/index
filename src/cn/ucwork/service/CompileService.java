package cn.ucwork.service;

public interface CompileService {
	/**
	 * 在服务器创建文件，相当于保存文件
	 * @param content 代码内容
	 * @param fileName 文件名
	 * @param path 文件路径
	 */
	public void creatFile(String content, String fileName,String path);
	
	/**
	 * 编译执行文件
	 * @param path
	 * @param fileName
	 * @param compileType
	 * @return 文件执行结果
	 */
	public String compileFile(String path, String fileName, String compileType);
	
	/**
	 * 编译完后删除文件
	 * @param path
	 * @param fileName
	 */
	public void deleteFile(String path, String fileName,String compileType);
}
