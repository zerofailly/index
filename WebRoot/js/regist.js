

var countdown = 60;
var flag1 = 0;
var flag2 = 0;
var flag3 = 0;
var flag4 = 0;

function send_veryfy(val) {
	if (flag1 == 0) {
		if (countdown == 60) {
			send_veryfy_code();
		}
		if (countdown == 0) {
			val.removeAttribute("disabled");
			val.value = "发送验证码";
			countdown = 60;
			return;
		} else {
			val.setAttribute("disabled", true);
			val.value = "重新发送(" + countdown + ")";
			countdown--;
		}
		setTimeout(function() {
			send_veryfy(val)
		}, 1000)
	} else {
		alert("发送失败，请检查信息！");
	}
}

function send_veryfy_code() {
	var user_email = document.getElementById("user_email");
	var xmlHttp = getXMLHttpRequest();
	xmlHttp.open("get", "./sendEmailServlet?user_email=" + user_email.value);
	xmlHttp.send(null);
	//处理结果
	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4) {
			if (xmlHttp.status == 200) {
				if (xmlHttp.responseText == "false") {
					alert("发送失败！");
				}

			}
		}
	}
}

function check_user_email(val) {
	var user_emali = val.value;
	var regex = /^([0-9A-Za-z\-_\.]+)@([0-9a-z]+\.[a-z]{2,3}(\.[a-z]{2})?)$/g;
	if (!regex.test(user_emali)) {
		document.getElementById("user_email_msg").innerHTML = "邮箱不合法";
		flag1 = 1;
	} else {
		flag1 = 0;
		veryfyEmail();
	}

}

function check_user_passwd(val) {
	var passwd = val.value;
	var regex = /^(?![^a-zA-Z]+$)(?!\D+$).{6,18}/;
	if (!regex.test(passwd)) {
		document.getElementById("user_passwd_msg").innerHTML = "密码不合法";
		//alert("密码要求同时包含字母和数字，且长度大于6位小于18位！");
		flag2 = 1;
	} else {
		flag2 = 0;
	}
}
function check_second_passwd(val) {
	var passwd = document.getElementById("passwd");
	if (passwd.value != val.value) {
		document.getElementById("check_passwd_msg").innerHTML = "密码不一致";
		flag3 = 1;
	} else {
		flag3 = 0;
	}
}

function clear_msg(val) {
	document.getElementById(val).innerHTML = "";
}

function veryfyEmail() {
	var user_email = document.getElementById("user_email");
	var xmlHttp = getXMLHttpRequest();
	//处理结果
	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4) {
			if (xmlHttp.status == 200) {
				if (xmlHttp.responseText == "true") {
					document.getElementById("user_email_msg").innerHTML = "已被注册";
					flag1 = 1;
				} else {
					document.getElementById("user_email_msg").innerHTML = "可以使用";
					flag1 = 0;
				}

			}
		}
	}
	var send_str = "user_email=" + user_email.value;
	xmlHttp.open("POST", "./checkEmailServlet");
	xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xmlHttp.send(send_str);
}

function registUser() {
	var user_email = document.getElementById("user_email");
	var passwd = document.getElementById("passwd");
	var veryfyCode = document.getElementById("veryfyCode");
	var name = document.getElementById("user_name");

	var xmlHttp = getXMLHttpRequest();
	//处理结果
	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4) {
			if (xmlHttp.status == 200) {
				if (xmlHttp.responseText == "not_sendVeryfy" || xmlHttp.responseText == "error_veryFy") {
					document.getElementById("user_email_msg").innerHTML = "验证码错误！";
				} else if (xmlHttp.responseText == "regist_success") {
					window.location.href = "loginServlet";
				}

			}
		}
	}
	var send_str = "user_email=" + user_email.value + "&passwd=" + passwd.value + "&veryfyCode=" + veryfyCode.value + "&name=" + name.value;
	xmlHttp.open("POST", "./registServlet");
	xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xmlHttp.send(send_str);
}
function regist_clear_input(val) {
	document.getElementById(val).value = "";
}
function regist_clear_msg(val) {
	document.getElementById(val).innerHTML = "";
}
function regist_click() {
	regist_clear_input("user_email");
	regist_clear_input("passwd");
	regist_clear_input("check_passwd");
	regist_clear_input("veryfyCode");
	regist_clear_input("user_name");
	regist_clear_msg("user_email_msg");
	regist_clear_msg("user_passwd_msg");
	regist_clear_msg("check_passwd_msg");
	regist_clear_msg("user_name_msg");
	regist_clear_msg("regist_user");
}