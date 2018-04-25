package cn.ucwork.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cn.ucwork.bean.Code;
import cn.ucwork.bean.Page;
import cn.ucwork.bean.User;
import cn.ucwork.service.PageService;
import cn.ucwork.service.impl.PageServiceImpl;

/**
 * Servlet implementation class CodeServlet
 */
@WebServlet("/codeServlet")
public class CodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		PageService p =new PageServiceImpl();
		Page<Code> page = new Page<Code>();
		User user = (User)request.getSession().getAttribute("user");
		String cuttentPageStr = request.getParameter("currentPage");
		String currentCountStr = request.getParameter("currentCount");
		Integer currentPage =0;
		Integer currentCount =0;
		if(cuttentPageStr == null || cuttentPageStr.equals(""))currentPage=1;
		else currentPage= Integer.parseInt(cuttentPageStr);
		if(currentCountStr == null || currentCountStr.equals(""))currentCount =3;
		else currentCount= Integer.parseInt(currentCountStr);
		page.setCurrentPage(currentPage);
		page.setCurrentCount(currentCount);
//		Page<Code> codePage = p.getCodePage(page, "1");
		Page<Code> codePage = p.getCodePage(page, null);
		Gson gson= new Gson();
		String json = gson.toJson(codePage);
		ServletOutputStream outputStream = response.getOutputStream();
		System.out.println(json);
		outputStream.write(json.getBytes());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
