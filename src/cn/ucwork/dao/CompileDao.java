package cn.ucwork.dao;

public interface CompileDao {
	/**
	 * �����ļ�
	 * @param content
	 * @param fileName
	 * @param path
	 */
	public void creatFile(String content, String fileName, String path);
	
	/**
	 * �����ļ�
	 * @param path
	 * @param fileName
	 * @param compileType
	 * @return ִ�н��
	 */
	public String compileJavaFileByOrder(String path, String fileName, String compileType);
}
