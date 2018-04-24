$("#span_friend ").click(function(){
  $(".friend_list").css({"height":"auto","width":"280px", "padding":"20px"});
});
$("#friend_close").click(function(){
   $(".friend_list").css({"height":"0","width":"0", "padding":"0"});
});
$("#span_share").click(function(){
  $(".share_list").css({"height":"auto","width":"auto", "padding":"20px"});
});
$("#share_close").click(function(){
  $(".share_list").css({"height":"0","width":"0", "padding":"0"});
});
$("#span_new_code").click(function(){
  $(".new_code").css({"height":"auto","width":"100%", "padding":"10px"});
});
$("#new_code_close").click(function(){
  $(".new_code").css({"height":"0","width":"0", "padding":"0px"});
});
$("#cancel_new_code").click(function(){
  $(".new_code").css({"height":"0","width":"0", "padding":"0px"});
});
var myCodeMirror = CodeMirror.fromTextArea($("#code_msg")[0], {
    
    autoMatchParens: true,
    indentUnit: 1,
    matchBrackets: true,
    lineNumbers: true,
    mode: "text/x-java",
    matchBrackets: true,
    theme: "dracula",	
    keyMap: "sublime"
});
myCodeMirror.setSize('60%');

var friendData;
var app = new Vue({
	  el: '#friend',
	  data: {
		friends:[]
	  },
	});
var app2 = new Vue({
	  el: '#page_index',
	  data: {
		  page: []
	  },
	});
function getFriend(current_page){
	var current_count=3;
	$.post("./frientServlet",{
		"cuttentPage" : current_page,
		"currentCount" : current_count
	},function(data){
		friendData =data;
		app.friends=friendData.obj;
		app2.page =friendData;
	},"json");
}
$("#span_friend").click(function(){
//	alert(friendData.obj);
	var current_page = $("#current_page").text();
	getFriend(current_page);
	
});
$("#pro_page").click(function(){
	var current_page = $("#current_page").text();
	if(--current_page < 1) return;
	getFriend(current_page);
});
$("#nex_page").click(function(){
	var current_page = $("#current_page").text();
	if(++current_page > friendData.totalPage) return;
//	alert(friendData.totalPage);
	getFriend(current_page);
});

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

var myCodeMirror2 = CodeMirror.fromTextArea($("#code_msg1")[0], {
    
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
