package cn.ucwork.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ucwork.service.impl.SendEmailServiceImpl;
import cn.ucwork.util.SendJMail;

/**
 * Servlet implementation class SendEmailServlet
 */
@WebServlet("/sendEmailServlet")
public class SendEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendEmailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SendEmailServlet");
		String user_email = request.getParameter("user_email");
		System.out.println("user_email:"+user_email);
		String veryCode = Integer.toString((int) ((Math.random()*9+1)*100000));
		String emailMsg = "感谢您加入uc_work网站，您的验证码是"+veryCode;
		ServletOutputStream out = response.getOutputStream();
		SendEmailServiceImpl sm = new SendEmailServiceImpl();
		if(sm.sendEmail(user_email, emailMsg)){
			
			//将验证码存入session中
			request.getSession().setAttribute("email_varyCode", veryCode);
			System.out.println(request.getSession().getAttribute("email_varyCode"));
			out.print(true);
		}else{
			out.print(false);
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
