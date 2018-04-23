package cn.ucwork.service;

public interface CompileService {
	/**
	 * �ڷ����������ļ����൱�ڱ����ļ�
	 * @param content ��������
	 * @param fileName �ļ���
	 * @param path �ļ�·��
	 */
	public void creatFile(String content, String fileName,String path);
	
	/**
	 * ����ִ���ļ�
	 * @param path
	 * @param fileName
	 * @param compileType
	 * @return �ļ�ִ�н��
	 */
	public String compileFile(String path, String fileName, String compileType);
	
	/**
	 * �������ɾ���ļ�
	 * @param path
	 * @param fileName
	 */
	public void deleteFile(String path, String fileName,String compileType);
}
