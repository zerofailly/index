package cn.ucwork.daoImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import cn.ucwork.dao.CompileDao;

public class CompileDaoImpl implements CompileDao{

	/**
	 * �ڷ��������д����ļ�
	 * @param content
	 * @param fileName
	 * @param path
	 * @throws IOException
	 */
	public void creatFile(String content, String fileName, String path) throws IOException {
		File file = new File(path,fileName);
		if(!file.exists()){
			file.getParentFile().mkdirs();
			file.createNewFile();
		}
		FileOutputStream fOutputStream=new FileOutputStream(file);
		OutputStreamWriter writer=new OutputStreamWriter(fOutputStream, "GBK");
		writer.append(content);
		writer.close();
		fOutputStream.close();
	}

	/**
	 * ���ݲ�ͬ���͵����԰�Ҫ����б���
	 * @param path
	 * @param fileName
	 * @param compileType
	 * @return
	 * @throws Exception
	 */
	public String compileJavaFileByOrder(String path, String fileName, String compileType) throws Exception {
		Runtime runtime = Runtime.getRuntime();
		Process process = null;
		File file = new File(path);
		String cpType = "javac ";
		Process pro = null;
		
		if(!file.exists()){
			throw new Exception("�������");
		}
		try {
			String strError = null;
			String resultError = "";
			
			//����c�����ļ�
			if("c".equals(compileType)){
				//�����exe�ļ�
				pro = runtime.exec("gcc -o "+fileName.substring(0, fileName.lastIndexOf("."))+" "+fileName,null,file);
				//�ж��Ƿ�������
				InputStream inputErrorStream = pro.getErrorStream();
				BufferedReader br1 = new BufferedReader(new InputStreamReader(inputErrorStream));
				while((strError=br1.readLine()) != null){
					resultError+=strError;
				}
				pro.waitFor();
				System.out.println("pro"+resultError+"pro");
				if(resultError == ""){
					process = runtime.exec(path+fileName.substring(0, fileName.lastIndexOf("."))+".exe");
					process.waitFor();
				}
			}else if("java".equals(compileType)){//����java�ļ�
				pro = runtime.exec("javac "+fileName,null,file);
				InputStream inputErrorStream = pro.getErrorStream();
				BufferedReader br1 = new BufferedReader(new InputStreamReader(inputErrorStream));
				while((strError=br1.readLine()) != null){
					resultError+=strError;
				}
				pro.waitFor();
				System.out.println("pro"+resultError+"pro");
				if(resultError == ""){
					process = runtime.exec("java "+fileName.substring(0,fileName.lastIndexOf(".")),null,file);
					process.waitFor();
				}
			}
			InputStream inputStream = null;
			if(resultError==""){//�����������ؽ��
				inputStream = process.getInputStream();
			}else{//���������з�����Ϣ
				return resultError;
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
			
			String str = null;
			String result = "";
			while((str=br.readLine()) != null){
				result+=str;
			}
			return result;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
