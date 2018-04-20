package cn.ucwork.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

import javax.servlet.ServletException;
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
		User user = new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
			System.out.println("user_passwd"+user.getPasswd());
			String veryfyCode = request.getParameter("veryfyCode");
			String emailVeryfyCode = (String) request.getSession().getAttribute("email_varyCode");
			
			System.out.println(request.getSession().getAttribute("email_varyCode"));
			//�û�û�з���������֤
			if(emailVeryfyCode == null){
				request.setAttribute("user", user);
				request.setAttribute("emailVeryfy_empty", "�뷢����֤��");
				request.getRequestDispatcher("/register.jsp").forward(request, response);
				return;
			}
			//�û�������֤����
			if(!emailVeryfyCode.equals(veryfyCode)){
				request.setAttribute("user", user);
				request.setAttribute("emailVeryfy_empty", "��֤�����");
				request.getRequestDispatcher("/register.jsp").forward(request, response);
				return;
			}else{
				String user_id = UUID.randomUUID().toString();
				user.setUser_id(user_id);
				System.out.println("user_id:"+user.getUser_id());
				UserServiceImpl us = new UserServiceImpl();
				try {
					us.registUserAndVerifyEmail(user);
					//ע��ɹ�����е�¼
					request.getSession().invalidate();
					//�����е�С����
					request.setAttribute("user", user);
					request.getRequestDispatcher("/login.jsp").forward(request, response);
					return;
				} catch (UserException e) {
					request.setAttribute("user", user);
					request.setAttribute("emailVeryfy_empty", e.getMessage());
					request.getRequestDispatcher("/register.jsp").forward(request, response);
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
