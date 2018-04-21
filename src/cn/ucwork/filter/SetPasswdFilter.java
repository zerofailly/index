package cn.ucwork.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
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
		HttpServletRequest myrequest = new MyReq(req);
		//System.out.println("SetPasswd:"+myrequest.getParameter("passwd"));
		chain.doFilter(myrequest, response);
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
		Map<String, String[]> map = getParameterMap();
		if(map.isEmpty()){
			/*System.out.println("map:"+map);*/
			return null;
		}else{
			return map.get(name)[0];
		}
	}
	
	public String[] getParameterValues(String name) {
		Map<String, String[]> map = getParameterMap();
		if(map.isEmpty()){
			return null;
		}else{
			return map.get(name);
		}
	}
	@Override
	public Map<String, String[]> getParameterMap() {
		int flag = 0;
		Map<String, String[]> reqMp = req.getParameterMap();
		Map<String, String[]> map = null;
		map = new HashMap<String, String[]>();  
		map.putAll(reqMp);
		String[] passwd =null;
		for (String key : map.keySet()) {
			if("passwd".equals(key)){
				flag = 1;
				passwd = map.get(key);
				break;
			}
		}
		if(flag == 1){
			char[] passwdArray = passwd[0].toCharArray();
			//将密码先进行异或处理
			for (int i = 0; i < passwdArray.length; i++) {
				passwdArray[i] ^= 1314520;
			}
			passwd[0] = String.valueOf(passwdArray);
			//处理后MD5进行加密
			passwd[0] = MD5Utils.md5(passwd[0]);
			map.put("passwd", passwd);
			System.out.println("passwd:"+map.get("passwd")[0]);
		}
		return map;
	}
	
}


