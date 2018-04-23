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






