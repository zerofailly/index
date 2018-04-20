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
var flag=0;
$("#chick_all").click(function(){
  if(flag==0){
    $(".code_main").css({"height":"auto", "opacity":"1"});
    flag=1;
  }
  else if(flag==1){
    $(".code_main").css({"height":"0", "opacity":"0"});
    flag=0;
  }
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