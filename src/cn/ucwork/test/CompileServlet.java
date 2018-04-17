package cn.ucwork.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



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
		//��ȡ��������
		String content = request.getParameter("compile");
		//��ȡ��������
		String compileType = request.getParameter("compileType");
		System.out.println(compileType);
		System.out.println(content);
		String path = "E:\\compileTest\\test\\";
		String fileName = request.getParameter("filename");
		if("java".equals(compileType)){
			System.out.println(fileName.substring(fileName.lastIndexOf(".")+1));
			if(!"java".equals(fileName.substring(fileName.lastIndexOf(".")+1))){
				request.setAttribute("error", "�ļ���Ҫ��.java��β!");
				request.setAttribute("content", content);
				request.getRequestDispatcher("/complime.jsp").forward(request, response);
				return;
			}
		}else if("c".equals(compileType)){
			if(!"c".equals(fileName.substring(fileName.lastIndexOf(".")+1))){
				request.setAttribute("error", "�ļ���Ҫ��.c��β!");
				request.setAttribute("content", content);
				request.getRequestDispatcher("/complime.jsp").forward(request, response);
				return;
			}
		}
		
		CompileService cs = new CompileService();
		
		//��ָ��Ŀ¼�����ļ�
		cs.creatFile(content,fileName,path);
		
		//�����ļ�
		String result = cs.compileJavaFile(path,fileName,compileType);
		request.setAttribute("result", result);
		request.setAttribute("content", content);
		request.getRequestDispatcher("/complime.jsp").forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
