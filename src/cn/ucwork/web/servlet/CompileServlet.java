package cn.ucwork.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.ucwork.bean.Code;
import cn.ucwork.service.CompileService;
import cn.ucwork.service.impl.CompileServiceImpl;



@WebServlet("/compileServlet")
public class CompileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//获取代码内容
//		String content = request.getParameter("content");
		//获取编译类型
//		String compileType = request.getParameter("compileType");
		System.out.println(request.getParameter("content"));
		Code code = new Code();
		try {
			BeanUtils.populate(code, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*String temp = code.getContent();
		code.setContent(temp.replace("。", "\n"));*/
		System.out.println(code.getCompileType());
		System.out.println("content:" + code.getContent());
		String path = "E:\\compileTest\\test\\";
		String fileName = code.getFileName();
		//添加路径
		code.setPath(path);
		
		CompileService cs = new CompileServiceImpl();
		
		//在指定目录创建文件
		cs.creatFile(code.getContent(),fileName,path);
		
		//编译文件
		String result = cs.compileFile(path,fileName,code.getCompileType());
		System.out.println(result);
		
		//编译完删除临时文件
		cs.deleteFile(path, fileName, code.getCompileType());
		System.out.println("文件已删除！");
		ServletOutputStream out = response.getOutputStream();
		//返回结果
		out.print(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
