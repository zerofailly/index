<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/registServlet" method="post">
		邮箱：<input type="email" name="user_email" onblur=veryfyEmail() value="${user.user_email }"/><span id="checkEmail_msg"></span><br />
		密码：<input type="password" name="passwd" /><br /> 昵称：<input
			type="text" name="name" value="${user.name }"/><br /> 邮箱验证码：<input type="text"
			name="veryfyCode" /><input type="button" value="获取验证码" id="btn"
			onclick=send() /><span id="send_msg"></span><br /> ${emailVeryfy_empty }<br /> <input type="submit" value="注册" />
	</form>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/AjaxGetXMLHttpRequest.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/registVeryfy.js"></script>
</body>
</html>