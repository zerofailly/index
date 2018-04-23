function getXMLHttpRequest() {
		var xmlHttp;

		try {
			// Firefox, Opera 8.0+, Safari
			xmlHttp = new XMLHttpRequest();
		} catch (e) {

			// Internet Explorer
			try {
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {

				try {
					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {
					alert("您的浏览器不支持AJAX！");
					return false;
				}
			}
		}
		return xmlHttp;
}

function judgeCode(){
	var flag = 0;
	var description = document.getElementById("code_main");
	var compileType = document.getElementById("compileType");
	var fileName = document.getElementById("fileName");
	var content = myCodeMirror.getValue();
	var result = document.getElementById("run_result");
	var is_public = document.getElementById("power");
	/*for(var i = 0;i<myCodeMirror.lineCount();i++){
		content += myCodeMirror.getLine(i)+"。";
	}*/
	if(description.value == ""){
		document.getElementById("code_description").innerHTML = "描述不能为空";
		flag = 1;
	}
	//获取文件扩展名
	if(fileName.value == ""){
		document.getElementById("fileName_msg").innerHTML="文件名不能为空";
		flag = 1;
	}else{
		var fileExtend=fileName.value.substring(fileName.value.lastIndexOf('.')).toLowerCase();
		if(compileType.value == "java"){
			if(fileExtend != ".java"){
				document.getElementById("fileName_msg").innerHTML="文件名以.java结尾";
				flag = 1;
			}
		}else if(compileType.value == "c"){
			if(fileExtend != ".c"){
				document.getElementById("fileName_msg").innerHTML="文件名以.c结尾";
				flag = 1;
			}
		}else if(compileType.value == "c++"){
			if(fileExtend != ".cpp"){
				document.getElementById("fileName_msg").innerHTML="文件名以.cpp结尾";
				flag = 1;
			}
		}
	}
	if(content == ""){
		document.getElementById("run_msg").innerHTML="请输入运行代码";
		flag = 1;
	}
	if(flag == 1){
		return;
	}
}

function compile(){
	//判断输入是否合法
	judgeCode();
	
	var flag = 0;
	var description = document.getElementById("code_main");
	var compileType = document.getElementById("compileType");
	var fileName = document.getElementById("fileName");
	var content = myCodeMirror.getValue();
	var result = document.getElementById("run_result");
	var is_public = document.getElementById("power");
	var xmlHttp = getXMLHttpRequest();
	var send_msg = "fileName="+fileName.value+"&description="+description.value+"&compileType="
			+compileType.value+"&is_public="+is_public.value+"&content="+content;
	var str = "";
	str+=send_msg;
	xmlHttp.open("POST", "./compileServlet",true);
	xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlHttp.send(str);
	//处理结果
	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4) {
			if (xmlHttp.status == 200) {
					result.innerHTML = xmlHttp.responseText;
			}
		}
	}
	
}

function saveCode(){
	judgeCode();
	var flag = 0;
	var description = document.getElementById("code_main");
	var compileType = document.getElementById("compileType");
	var fileName = document.getElementById("fileName");
	var content = myCodeMirror.getValue();
	var result = document.getElementById("run_result");
	var is_public = document.getElementById("power");
	var xmlHttp = getXMLHttpRequest();
	var send_msg = "fileName="+fileName.value+"&description="+description.value+"&compileType="
			+compileType.value+"&is_public="+is_public.value+"&content="+content;
	var str = "";
	str+=send_msg;
	xmlHttp.open("POST", "./saveCodeServlet",true);
	xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlHttp.send(str);
	//处理结果
	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4) {
			if (xmlHttp.status == 200) {
				if(xmlHttp.responseText == "true"){
					alert("保存成功！");
				}else{
					alert("保存失败！");
				}
			}
		}
	}
}

