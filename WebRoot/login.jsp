<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function changeImage() {

		document.getElementById("img").src = "${pageContext.request.contextPath}/checkImageServlet?time="
				+ new Date().getTime();
	}
</script>

</head>
<body>
<form action="${pageContext.request.contextPath}/loginServlet" method="post">
	邮箱：
	<input type="email" name="user_email" />
	<br /> 密码：
	<input type="password" name="passwd" /><span>${login_msg }</span>
	<br />
	<img src="${pageContext.request.contextPath}/checkImageServlet" width="180"
		height="30" class="textinput" style="height:30px;" id="img" />&nbsp;&nbsp;
	<a href="javascript:void(0);" onclick="changeImage()">看不清换一张</a><br/> 输入验证码：
	<input type="text" name="veryfyCode" /><span>${error }</span>
	<br />
	<input type="submit" value="登录" />
</form>
</body>
</html>