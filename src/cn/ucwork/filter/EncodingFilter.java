package cn.ucwork.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * Servlet Filter implementation class EncodingFilter
 */
public class EncodingFilter implements Filter {

    /**
     * Default constructor. 
     */
    public EncodingFilter() {
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
		Myrequest myRequest = new Myrequest(req);
		//myRequest.setCharacterEncoding("UTF-8");
		chain.doFilter(myRequest, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}

class Myrequest extends HttpServletRequestWrapper{
	HttpServletRequest request = null;
	
	public Myrequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}

	@Override
	public String getParameter(String name) {
		Map<String, String[]> map = getParameterMap();
		return map.get(name)[0];
	}
	
	@Override
	public String[] getParameterValues(String name) {
		Map<String, String[]> map = getParameterMap();
		return map.get(name);
	}
	
	boolean flag = true;
	@Override
	public Map<String, String[]> getParameterMap() {
		Map<String, String[]> map = request.getParameterMap();
		
		if(flag == true){
			
			for (Map.Entry<String, String[]> m : map.entrySet()) {
				String values[] = m.getValue();
				for (int i = 0; i < values.length; i++) {
					try {
						values[i] = new String(values[i].getBytes("ISO-8859-1"),"UTF-8");
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			flag = false;
		}
		return map;
	}

	
	
	
	
}
