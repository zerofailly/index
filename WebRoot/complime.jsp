<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/compileServlet" method="post">
		<select name="compileType">
			<option value ="java">java</option>
	        <option value ="c">c</option>
	        <option value="c++">c++</option>
    	</select>
    	<br/><br/>
    	保存文件名：<input type="text" name ="filename"/> ${error }
    	<br/><br/>
        <textarea name="compile" style="height:500px; width:500px;">${content } </textarea><br/>
        <input type="submit" value="提交" />
    </form>
    <label>编译结果:${result }</label>
</body>
</html>