package cn.ucwork.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.ucwork.bean.Code;
import cn.ucwork.bean.User;
import cn.ucwork.exception.CodeException;
import cn.ucwork.service.CodeService;
import cn.ucwork.service.CompileService;
import cn.ucwork.service.impl.CodeServiceImpl;
import cn.ucwork.service.impl.CompileServiceImpl;

/**
 * Servlet implementation class SaveCodeServlet
 */
@WebServlet("/saveCodeServlet")
public class SaveCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveCodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("执行保存文件！");
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
		String path = "E:\\compileTest\\test\\";
		String fileName = code.getFileName();
		
		//在指定目录创建文件
		
		//将用户信息添加到code对象中
		User user = (User) request.getSession().getAttribute("user");
		code.setUser_id(user.getUser_id());
		code.setCode_id(UUID.randomUUID().toString());
		code.setPath(path);
		//将文件信息写入数据库中
		ServletOutputStream out = response.getOutputStream();
		CodeService write = new CodeServiceImpl();
		try {
			write.addCode(code);
		} catch (CodeException e) {
			// TODO Auto-generated catch block
			out.print(false);
			e.printStackTrace();
		}
		CompileService cs = new CompileServiceImpl();
		cs.creatFile(code.getContent(),fileName,path);
		
		out.print(true);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
