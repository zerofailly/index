package cn.ucwork.service;

public interface CompileService {
	/**
	 * �����ļ�
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
}
