function changeImage() {
	document.getElementById("img_veryfy").src = "./checkImageServlet?time="
	+ new Date().getTime();
}

window.onload = function() {
	var flag1 = 1;
	var flag2 = 1;
	var flag3 = 1;

	var login_user_email = document.getElementById("login_user_name");
	var login_passwd = document.getElementById("login_passwd");
	var login_veryfy_code = document.getElementById("login_veryfy_code");
	var login_user = document.getElementById("login_user");

	function loginVeryfy() {
		var xmlHttp = getXMLHttpRequest();
		//处理结果
		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4) {
				if (xmlHttp.status == 200) {
					if (xmlHttp.responseText == "false") {
						document.getElementById("login_veryfy_msg").innerHTML = "验证码错误";
						flag3 = 1;
					} else {
						document.getElementById("login_veryfy_msg").innerHTML = "验证码正确";
						flag3 = 0;
					}

				}
			}
		}
		xmlHttp.open("get", "./loginVeryfyServlet?veryfyCode=" + login_veryfy_code.value);
		xmlHttp.send(null);
	}

	function login() {
		var xmlHttp = getXMLHttpRequest();
		//处理结果
		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4) {
				if (xmlHttp.status == 200) {
					if (xmlHttp.responseText == "login_msg") {
						alert("邮箱不存在或密码错误!");
					}else if(xmlHttp.responseText == "login_success"){
						window.location.href = "my_page.jsp";
					}
				}
			}
		}
		var send_str = "passwd="+login_passwd.value+"&user_email="+login_user_email.value;
		xmlHttp.open("POST", "./loginServlet");
		xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xmlHttp.send(send_str);

	}


	function check_login_email() {
		var user_emali = login_user_email.value;
		var regex = /^([0-9A-Za-z\-_\.]+)@([0-9a-z]+\.[a-z]{2,3}(\.[a-z]{2})?)$/g;
		if (!regex.test(user_emali)) {
			document.getElementById("login_user_msg").innerHTML = "邮箱不合法";
			flag1 = 1;
		} else {
			flag1 = 0;
		}

	}

	function login_clear_msg(val) {
		document.getElementById(val).innerHTML = "";
	}
	function check_login_passwd() {
		var regex = /^(?![^a-zA-Z]+$)(?!\D+$).{6,18}/;
		if (!regex.test(login_passwd.value)) {
			document.getElementById("login_passwd_msg").innerHTML = "密码不合法";
			//alert("密码要求同时包含字母和数字，且长度大于6位小于18位！");
			flag2 = 1;
		} else {
			flag2 = 0;
		}
	}

	login_user_email.onblur = check_login_email;
	login_user_email.onmousedown = function() {
		login_clear_msg("login_user_msg");
	}

	login_passwd.onblur = check_login_passwd;
	login_passwd.onmousedown = function() {
		login_clear_msg("login_passwd_msg");
	}

	login_veryfy_code.onblur = loginVeryfy;
	login_veryfy_code.onmousedown = function() {
		login_clear_msg("login_veryfy_msg");
	}

	login_user.onclick = function() {
		if (flag1 == 0 && flag1 == 0 && flag2 == 0) {
			login();
		} else {
			check_login_email();
			check_login_passwd();
			loginVeryfy();
			alert("请检查输入信息");
		}
	}

	function clear_input(val) {
		document.getElementById(val).value = "";
	}
	var clear_login = document.getElementById("loggin");
	clear_login.onclick = function() {
		login_clear_msg("login_user_msg");
		login_clear_msg("login_veryfy_msg");
		login_clear_msg("login_passwd_msg");
		clear_input("login_user_name");
		clear_input("login_passwd");
		clear_input("login_veryfy_code");
	}
}