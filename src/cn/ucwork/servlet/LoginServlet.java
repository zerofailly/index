package cn.ucwork.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ucwork.bean.User;
import cn.ucwork.exception.UserException;
import cn.ucwork.service.UserService;
import cn.ucwork.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String ck = request.getParameter("veryfyCode");
		System.out.println(ck);
		String checkcode_session = (String) request.getSession().getAttribute("checkcode_session");
		if(!ck.equals(checkcode_session)){
			request.setAttribute("error", "验证码错误!");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		
		String user_email = request.getParameter("user_email");
		String passwd = request.getParameter("passwd");
		
		UserService us = new UserServiceImpl();
		try {
			User user = us.login(user_email, passwd);
			if(user!=null){
				request.getSession().setAttribute("user", user);
				response.sendRedirect(request.getContextPath()+"/index.html");
			}else{
				System.out.println("用户名或密码错误");
				request.setAttribute("login_msg", "用户名或密码错误");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				return;
			}
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("用户不存在");
			request.setAttribute("login_msg", e.getMessage());
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
