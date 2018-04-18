function send() {
	var user_email = document.getElementsByTagName("input")[0];
	var xmlHttp = getXMLHttpRequest();
	//处理结果
	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4) {
			if (xmlHttp.status == 200) {
				var send_msg = document.getElementById("send_msg");
				if (xmlHttp.responseText == "true") {
					send_msg.innerHTML = "发送成功";
				} else {
					send_msg.innerHTML = "发送失败";
				}

			}
		}
	}
	xmlHttp.open("get", "./sendEmailServlet?user_email=" + user_email.value);
	xmlHttp.send(null);

}

function veryfyEmail(){
	var user_email = document.getElementsByTagName("input")[0];
	var xmlHttp = getXMLHttpRequest();
	//处理结果
	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4) {
			if (xmlHttp.status == 200) {
				var checkEmail_msg = document.getElementById("checkEmail_msg");
				if (xmlHttp.responseText == "true") {
					checkEmail_msg.innerHTML = "邮箱已被注册";
				} else {
					checkEmail_msg.innerHTML = "可以使用";
				}

			}
		}
	}
	xmlHttp.open("get", "./checkEmailServlet?user_email=" + user_email.value);
	xmlHttp.send(null);
}