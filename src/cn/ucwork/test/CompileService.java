package cn.ucwork.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

import cn.ucwork.dao.CompileDao;

public class CompileService {
	
	@Test
	public void creatFile1() {
		String path = "E:\\compileTest\\123";
		File file = new File(path,"test.java");
		if(!file.exists()){
			file.getParentFile().mkdirs();
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
			try {
				FileOutputStream fOutputStream=new FileOutputStream(file);
				OutputStreamWriter writer=new OutputStreamWriter(fOutputStream, "utf-8");
				writer.append("中文输入+English");
				writer.close();
				fOutputStream.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
	}

	/**
	 * 在服务器进行创建文件
	 * @param content
	 * @param fileName
	 * @param path
	 * @throws IOException
	 */
	public void creatFile(String content, String fileName,String path) {
		cn.ucwork.test.CompileDao cd = new cn.ucwork.test.CompileDao();
		try {
			cd.creatFile(content,fileName,path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	/**
	 * 根据不同类型的语言按要求进行编译
	 * @param path
	 * @param fileName
	 * @param compileType
	 * @return
	 * @throws Exception
	 */
	public String compileJavaFile(String path, String fileName, String compileType) {
		cn.ucwork.test.CompileDao cd = new cn.ucwork.test.CompileDao();
		try {
			return cd.compileJavaFileByOrder(path,fileName,compileType);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
