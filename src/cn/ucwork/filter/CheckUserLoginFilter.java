package cn.ucwork.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ucwork.bean.User;

/**
 * Servlet Filter implementation class CheckUserLoginFilter
 */
@WebFilter("/CheckUserLoginFilter")
public class CheckUserLoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CheckUserLoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse respon = (HttpServletResponse) response;
		//获取session中user的值
		User user = (User) req.getSession().getAttribute("user");
		//如果用户为空，ajax返回user_empty
		ServletOutputStream out = respon.getOutputStream();
		if(user == null){
			req.getSession().invalidate();
			out.print("user_empty");
			return;
		}
		
		chain.doFilter(req, respon);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
