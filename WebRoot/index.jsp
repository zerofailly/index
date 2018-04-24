<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" >

<head>
  <!-- <meta charset="UTF-8"> -->
  <title>UCwork</title>
  <link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/css/bootstrap.css'>
<link rel='stylesheet prefetch' href='https://cdn.bootcss.com/codemirror/5.36.0/codemirror.min.css'>
<link rel='stylesheet prefetch' href='https://cdn.bootcss.com/codemirror/5.36.0/theme/eclipse.min.css'>
<link rel='stylesheet prefetch' href='https://cdn.bootcss.com/codemirror/5.36.0/theme/dracula.min.css'>

      <link rel="stylesheet" href="css/style.css">


</head>

<body>

<div class="divBg"></div>  
<div class="regist">
  <div class="user_name"><span>邮箱地址:</span>
    <input id="user_email" onblur="check_user_email(this)"onmousedown="clear_msg('user_email_msg')"/>
    <lable id="user_email_msg"></lable>
  </div>
  <div class="user_pass"><span>密码:</span>
    <input type="password" id="passwd" onblur="check_user_passwd(this)"onmousedown="clear_msg('user_passwd_msg')"/>
    <lable id="user_passwd_msg"></lable>
  </div>
  <div class="user_repass"><span>确认密码:</span>
    <input type="password" id="check_passwd" onblur="check_second_passwd(this)"onmousedown="clear_msg('check_passwd_msg')"/>
    <lable id="check_passwd_msg"></lable>
  </div>
  <div class="user_name"><span>用户昵称:</span>
    <input id="user_name"/>
    <lable id="user_name_msg"></lable>
  </div>
  <div class="yanzheng"><span>邮箱验证:</span>
    <input id="veryfyCode" style="width:40%;"/>
    <input class="send_button" type="button" value="发送验证码" 
    style="width:30%;font-size:15px;text-align:center;font-weight: bold;" onclick="send_veryfy(this)"/>
  </div>
  <div class="submit"><span onclick="registUser()">注册</span><span id="exit_regist">取消</span></div>
</div>
<div class="loggin">
  <div class="user_name"><span>邮箱:</span>
    <input id="login_user_name"/>
    <lable id="login_user_msg"></lable>
  </div>
  <div class="user_passwd"><span>密码:</span>
    <input type="password" id="login_passwd"/>
    <lable id="login_passwd_msg"></lable>
  </div>
  <div class="imgCode">
  <span >验证码:</span><img src="${pageContext.request.contextPath}/checkImageServlet" id="img_veryfy" />&nbsp;&nbsp;
		<a href="javascript:void(0);" style="font-size: small;" onclick="changeImage()">看不清楚换一张</a><br/><br/>
		<span>输入验证:</span><input type="text" name="veryfyCode" id="login_veryfy_code"/><lable id="login_veryfy_msg"></lable>
  </div>
  <div class="submit"><span id="login_user">登录</span><span id="exit_loggin">取消</span></div>
</div>
<header>
  <div class="container header1">
    <div class="row">
      <div class="col-md-10 offset-md-1">
        <div class="logo"></div>
        <div class="rl"><span id="regist" onclick="regist_click()">注册</span><span id="loggin">登录</span></div>
      </div>
    </div>
    <div class="row"> 
      <div class="col-md-5 offset-md-1"> 
        <h3>一个专注于学习的工作室.</h3><span><a href=""> 加入我们</a><span>,成就未来.</span></span>
      </div>
      <div class="col-md-4 offset-md-2"></div>
    </div>
  </div>
  <div class="container header2">
    <div class="row justify-content-center">
      <div class="col-md-7 uc">UC_WORK,更专注于对代码的设计</div>
      <div class="col-md-7 text">
        <div class="row">
          <div class="col-md-7 offset-md-3">在线编辑, 我们在努力.</div>
          <div class="col-md-7 offset-md-3">在线做笔记,我们更勇敢.</div>
          <div class="col-md-7 offset-md-3">问题探讨,大家来帮你,学习从现在开始.</div>
        </div>
      </div>
    </div>
  </div>
</header>
<section>
  <div class="container">
  <div id="code_row" >
    <div class="message" v-for="code in codeMager" >
    
	      <div class="row">
	        <div class="col-md-10 offset-1 section1">
	          <div class="head_icon"></div>
	          <div class="net_name">{{code.user.name}}</div>
	          <div class="person_name">{{code.user.person_name}}</div>
	        </div>
	      </div>
     
	      <div class="row" >
	        <div class="col-md-10 offset-1">
	          <div class="code_name"> <span>{{code.fileName}}</span></div>
	        </div>
	        <div class="col-md-10 offset-1">
	          <div class="code_msg">{{code.description}}</div>
	        </div>
	        <div class="col-md-10 offset-1 code_main" :id="code.code_id">
	          <div class="code_majar" >
	            <textarea id="code_msg" name="" cols="30" rows="10"> </textarea>
	            <div class="comment">
	              <div class="head_icon">头像</div>
	              <div class="net_name">网名</div>
	              <div class="comment_value">写的真是太好了,写的真是太好了,写的真是太好了,写的真是太好了.写的真是太好了,写的真是太好了,写的真是太好了,写的真是太好了. </div>
	            </div>
	            <div class="comment">
	              <div class="head_icon">头像</div>
	              <div class="net_name">网名</div>
	              <div class="comment_value">写的真是太好了,写的真是太好了,写的真是太好了,写的真是太好了.写的真是太好了,写的真是太好了,写的真是太好了,写的真是太好了. </div>
	            </div>
	          </div>
	        </div>
	        
	      </div>
	      
	      <div class="row">
	        <div class="col-md-10 offset-1">
	          <div class="comment">
	            <div class="yes">点赞</div>
	            <div class="no">鄙视</div>
	            <div class="com">评论</div>
	            <div class="coll">收藏</div>
	            <div class="readAll" id="chick_all" @click="pageOpenOrClose(code.code_id)">查看全文</div>
	          </div>
	        </div>
	      </div>
      </div>
      
    </div>
    <div class="col-md-10 offset-1" id="codePage">
	        <div class="page_index" id="code_page_index">
	          <div class="pro_page" id= "code_pro_page"><</div>
	          <div class="current_page" id="code_current_page">{{codePages.currentPage}}</div>
	          <div class="nex_page" id="code_nex_page">></div>
	          <div class="total_page" id= "code_total_page">共{{codePages.totalPage}}页</div>
	        </div>
    </div>
  </div>
</section>
<footer>
  <div class="container">
    <div class="row">
      <div class="col-md-5 offset-1">
        <h3>联系我们</h3>
        <div class="comment_our"> 
          <div class="qq">QQ群:1234456678</div>
          <div class="email">Email:222222222222@qq.com</div>
        </div>
      </div>
      <div class="col-md-5 footer1"> 
        <div class="complaint"> 
          <h3>投诉建议</h3>
          <textarea> </textarea>
          <div class="email t text_input">邮箱:</div>
          <input class="text_input" type="text"/>
          <div class="phone t text_input">电话:</div>
          <input class="text_input" type="text"/>
          <div class="qq t text_input">QQ:</div>
          <input class="text_input" type="text"/>
          <div class="submit">提交</div>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-md-12">
        <div class="recommand">学习频道推荐:<span>知乎</span><span>菜鸟教程</span><span>百度贴吧</span></div>
      </div>
    </div>
  </div>
</footer>
  <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/js/bootstrap.min.js'></script>
<script src='https://cdn.bootcss.com/codemirror/5.36.0/codemirror.min.js'></script>
<script src='https://cdn.bootcss.com/codemirror/5.36.0/mode/clike/clike.min.js'></script>
<script src='https://cdn.bootcss.com/codemirror/5.36.0/keymap/sublime.min.js'></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
  
<script  src="js/index.js"></script>
<script type="text/javascript" src="js/AjaxGetXMLHttpRequest.js"></script>
<script src="js/regist.js"></script>

<script type="text/javascript" src="js/login.js"></script>

</body>

</html>
