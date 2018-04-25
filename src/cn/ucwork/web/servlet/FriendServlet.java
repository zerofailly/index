package cn.ucwork.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cn.ucwork.bean.Page;
import cn.ucwork.bean.User;
import cn.ucwork.service.PageService;
import cn.ucwork.service.impl.PageServiceImpl;

/**
 * Servlet implementation class FriendServlet
 */
@WebServlet("/FriendServlet")
public class FriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FriendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PageService p= new PageServiceImpl();
		User user = (User)request.getSession().getAttribute("user");
		Page<User> page = new Page<User>();
		String cuttentPageStr = request.getParameter("cuttentPage");
		String currentCountStr = request.getParameter("currentCount");
		Integer currentPage =0;
		Integer currentCount =0;
		if(cuttentPageStr == null || cuttentPageStr.equals(""))currentPage=1;
		else currentPage= Integer.parseInt(cuttentPageStr);
		if(currentCountStr == null || currentCountStr.equals(""))currentCount =3;
		else currentCount= Integer.parseInt(currentCountStr);
		page.setCurrentPage(currentPage);
		page.setCurrentCount(currentCount);
//		Page<User> friendtPage = p.getFriendtPage(page, user.getUser_id());
		Page<User> friendtPage = p.getFriendtPage(page, "1");
//		request.setAttribute("friendPage", friendtPage);
		ServletOutputStream out = response.getOutputStream();
		Gson gson= new Gson();
		String json = gson.toJson(friendtPage);
		System.out.println(json);
		out.write(json.getBytes());
		return ;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
