package cn.ucwork.service.impl;

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
import cn.ucwork.daoImpl.CompileDaoImpl;
import cn.ucwork.service.CompileService;

public class CompileServiceImpl implements CompileService {
	
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
	public String compileFile(String path, String fileName, String compileType) {
		CompileDao cd = new CompileDaoImpl();
		try {
			return cd.compileJavaFileByOrder(path,fileName,compileType);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public void deleteFile(String path, String fileName,String compileType) {
		File file = new File(path+fileName);
		if(file.exists() && file.isFile()){
			file.delete();
		}
		String subFileName = fileName.substring(0,fileName.lastIndexOf("."));
		System.out.println("subFileName:"+subFileName);
		if("c".equals(compileType)){
			File cFile = new File(path+subFileName + ".exe");
			if(cFile.exists() && cFile.isFile()){
				cFile.delete();
			}
		}else if("java".equals(compileType)){
			File jFile = new File(path+subFileName + ".class");
			if(jFile.exists() && jFile.isFile()){
				jFile.delete();
			}
		}else if("c++".equals(compileType)){
			
		}
		
		
	}

}
