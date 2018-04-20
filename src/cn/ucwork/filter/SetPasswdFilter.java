package cn.ucwork.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import cn.ucwork.util.MD5Utils;

/**
 * Servlet Filter implementation class SetPasswdFilter
 */
@WebFilter("/SetPasswdFilter")
public class SetPasswdFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SetPasswdFilter() {
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
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		//获取passwd的值，如果为空放行，不为空将密码进行加密后放行
		/*
		System.out.println("SetPasswdFilter"+passwd);
			
			System.out.println("SetPasswdFilter"+req.getParameter("passwd"));
			System.out.println("SetPasswdFilter"+passwd);
			chain.doFilter(req, res);
		}
		
	}*/
		chain.doFilter(req, res);
		}
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}

class MyReq extends HttpServletRequestWrapper{
	HttpServletRequest req = null;
	public MyReq(HttpServletRequest request) {
		super(request);
		this.req = request;
	}
	
	public String getParameter(String name) {
		String passwd = req.getParameter("passwd");
		if(passwd == null)
			return req.getParameter(name);
		else{
			char[] passwdArray = passwd.toCharArray();
			//将密码先进行异或处理
			for (int i = 0; i < passwdArray.length; i++) {
				passwdArray[i] ^= 1314520;
			}
			passwd = String.valueOf(passwdArray);
			//处理后MD5进行加密
			passwd = MD5Utils.md5(passwd);
			return passwd;
		}
	}
	
}


