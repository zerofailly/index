package cn.ucwork.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

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
		User sessionUser = (User) request.getSession().getAttribute("user");
		if(sessionUser != null){
			System.out.println("登录成功");
			request.getRequestDispatcher("/my_page.jsp").forward(request, response);
			return;
		}
		
		
		User loginUser = new User();
		try {
			BeanUtils.populate(loginUser, request.getParameterMap());
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		UserService us = new UserServiceImpl();
		try {
			System.out.println("login_passwd:"+loginUser.getPasswd());
			System.out.println("login_email:"+loginUser.getUser_email());
			User user = us.login(loginUser.getUser_email(), loginUser.getPasswd());
			if(user!=null){
				System.out.println("登录成功");
				request.getSession().setAttribute("user", user);
				response.getOutputStream().print("login_success");
				return;
			}else{
				System.out.println("用户名不存在或密码错误");
				response.getOutputStream().print("login_error");
				return;
			}
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.getOutputStream().print("login_error");
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
