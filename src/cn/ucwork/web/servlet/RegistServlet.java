package cn.ucwork.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.ucwork.bean.User;
import cn.ucwork.exception.UserException;
import cn.ucwork.service.impl.UserServiceImpl;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/registServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*Map<String, String[]> map = request.getParameterMap();
		for (String key : map.keySet()) {
			System.out.println(key+"|"+map.get(key)[0]);
		}*/
		ServletOutputStream out = response.getOutputStream();
		User user = new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
			System.out.println("user_passwd"+user.getPasswd());
			String veryfyCode = request.getParameter("veryfyCode");
			String emailVeryfyCode = (String) request.getSession().getAttribute("email_varyCode");
			
			System.out.println(request.getSession().getAttribute("email_varyCode"));
			//用户没有发送邮箱验证
			System.out.println("veryfyCode:"+veryfyCode);
			System.out.println("emailVeryfyCode:"+emailVeryfyCode);
			if(emailVeryfyCode == null){
				out.print("not_sendVeryfy");
				return;
			}
			//用户邮箱验证错误
			if(!emailVeryfyCode.equals(veryfyCode)){
				out.print("error_veryFy");
				return;
			}else{
				String user_id = UUID.randomUUID().toString();
				user.setUser_id(user_id);
				System.out.println("user_id:"+user.getUser_id());
				UserServiceImpl us = new UserServiceImpl();
				try {
					us.registUserAndVerifyEmail(user);
					//注册成功后进行登录
					System.out.println("注册成功");
					request.getSession().invalidate();
					//这里有点小问题
					request.getSession().setAttribute("user", user);
					out.print("regist_success");
					//request.getRequestDispatcher("/loginServlet").forward(request, response);
					return;
				} catch (UserException e) {
					request.getSession().invalidate();
					response.sendRedirect("/index.jsp");
					e.printStackTrace();
					return;
				}
				
			}
			
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
