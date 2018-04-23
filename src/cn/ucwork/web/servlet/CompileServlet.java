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
		//��ȡ��������
//		String content = request.getParameter("content");
		//��ȡ��������
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
		code.setContent(temp.replace("��", "\n"));*/
		System.out.println(code.getCompileType());
		System.out.println("content:" + code.getContent());
		String path = "E:\\compileTest\\test\\";
		String fileName = code.getFileName();
		//���·��
		code.setPath(path);
		
		CompileService cs = new CompileServiceImpl();
		
		//��ָ��Ŀ¼�����ļ�
		cs.creatFile(code.getContent(),fileName,path);
		
		//�����ļ�
		String result = cs.compileFile(path,fileName,code.getCompileType());
		System.out.println(result);
		
		//������ɾ����ʱ�ļ�
		cs.deleteFile(path, fileName, code.getCompileType());
		System.out.println("�ļ���ɾ����");
		ServletOutputStream out = response.getOutputStream();
		//���ؽ��
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
