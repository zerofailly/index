$("#regist").click(function(){
  $(".regist").css({"height":"auto", "opacity":"1","padding":"20px 20px"});
  $(".divBg").css({"top":"0"});
});
$("#exit_regist").click(function(){
  $(".regist").css({"height":"0", "opacity":"0","padding":"0"});
  $(".divBg").css({"top":"-100%"});
  
  
});
$("#loggin").click(function(){
  $(".loggin").css({"height":"auto", "opacity":"1","padding":"20px 20px"});
  $(".divBg").css({"top":"0"});
});
$("#exit_loggin").click(function(){
  $(".loggin").css({"height":"0", "opacity":"0", "padding":"0"});
  $(".divBg").css({"top":"-100%"});
});

var myCodeMirror = CodeMirror.fromTextArea($("#code_msg")[0], {
    
    autoMatchParens: true,
    indentUnit: 1,
    matchBrackets: true,
    lineNumbers: true,
    mode: "text/x-java",
    matchBrackets: true,
    theme: "dracula",	
    keyMap: "sublime",
    readOnly: true,
    
});
myCodeMirror.setSize('100%');
var flag=0;
var codeApp = new Vue({
	el: '#code_row',
	data: {
		codeMager : []
	},
	 methods:{
		 pageOpenOrClose:function(cat){
			  
			  var id= "#"+cat;
			  if(flag==0){
			    $(id).css({"height":"auto", "opacity":"1"});
			    flag=1;
			  }
			  else if(flag==1){
			    $(id).css({"height":"0", "opacity":"0"});
			    flag=0;
			  }
         }
     },
});
var codePageApp = new Vue({
	el: '#codePage',
	data: {
		codePages : []
	},
});
var codeData;
function getCode(current_page){
	var totalPage=3;
//	alert(codeApp.code_page);
	$.post("./codeServlet",{
		"currentPage": current_page,
		"totalPage": totalPage,
	},function(data){
		codeData = data;
		codeApp.codeMager =codeData.obj;
		codePageApp.codePages= codeData;
	},"json");
}

var current_page= $("#code_current_page").text();
getCode(current_page);
$("#code_pro_page").click(function(){
	var current_page = $("#code_current_page").text();
	if(--current_page < 1) return;
	getCode(current_page);
});
$("#code_nex_page").click(function(){
	var current_page = $("#code_current_page").text();
	if(++current_page > codeData.totalPage) return;
//	alert(friendData.totalPage);
	getCode(current_page);
});
