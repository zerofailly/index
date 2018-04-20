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
    <input/>
    <lable></lable>
  </div>
  <div class="user_pass"><span>密码:</span>
    <input/>
    <lable>已发送</lable>
  </div>
  <div class="user_repass"><span>确认密码:</span>
    <input/>
    <lable>已发送</lable>
  </div>
  <div class="yanzheng"><span>验证码:</span>
    <input/>
    <lable>已发送</lable>
  </div>
  <div class="submit"><span>注册</span><span id="exit_regist">取消</span></div>
</div>
<div class="loggin">
  <div class="user_name"><span>用户名:</span>
    <input/>
    <lable>用户名不存在</lable>
  </div>
  <div class="user_passwd"> <span>密码:</span>
    <input/>
    <lable>密码错误</lable>
  </div>
  <div class="imgCode">
  	<img src="${pageContext.request.contextPath}/checkImageServlet" id="img" />&nbsp;&nbsp;
		<a href="javascript:void(0);" style="font-size: small;margin-left: 20px;" onclick="changeImage()">看不清换一张</a><br/><br/>
		<span>验证码:</span><input type="text" name="veryfyCode" /><lable>验证码错误</lable>
  </div>
  <div class="submit"><span>确定</span><span id="exit_loggin">取消</span></div>
</div>
<header>
  <div class="container header1">
    <div class="row">
      <div class="col-md-10 offset-md-1">
        <div class="logo"></div>
        <div class="rl"><span id="regist">注册</span><span id="loggin">登录</span></div>
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
    <div class="message">
      <div class="row">
        <div class="col-md-10 offset-1 section1">
          <div class="head_icon">头像</div>
          <div class="net_name">网名</div>
          <div class="person_name">个性签名</div>
        </div>
      </div>
      <div class="row">
        <div class="col-md-10 offset-1">
          <div class="code_name"> <span>Eclispe 写C++程序</span></div>
        </div>
        <div class="col-md-10 offset-1">
          <div class="code_msg">首先安装C插件： 在eclipse里面点击Help->Install new Software, 在Work http://download.eclipse.org/releases/ganymede/ 会出现C插件，点击安装就可以了。 安装MinGW 下载MinGW后安装，然后在系统环境变量中添加%MinGW%\bin, MinGW为安装gcc的路径，例如： 个人…</div>
        </div>
        <div class="col-md-10 offset-1 code_main">
          <div class="code_majar">
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
            <div class="readAll" id="chick_all">查看全文</div>
          </div>
        </div>
      </div>
    </div>
    <div class="message">
      <div class="row">
        <div class="col-md-10 offset-1 section1">
          <div class="head_icon">头像</div>
          <div class="net_name">网名</div>
          <div class="person_name">个性签名</div>
        </div>
      </div>
      <div class="row">
        <div class="col-md-10 offset-1">
          <div class="code_name"> <span>Eclispe 写C++程序</span></div>
        </div>
        <div class="col-md-10 offset-1">
          <div class="code_msg">首先安装C插件： 在eclipse里面点击Help->Install new Software, 在Work http://download.eclipse.org/releases/ganymede/ 会出现C插件，点击安装就可以了。 安装MinGW 下载MinGW后安装，然后在系统环境变量中添加%MinGW%\bin, MinGW为安装gcc的路径，例如： 个人…</div>
        </div>
      </div>
      <div class="row">
        <div class="col-md-10 offset-1">
          <div class="comment">
            <div class="yes">点赞</div>
            <div class="no">鄙视</div>
            <div class="com">评论</div>
            <div class="coll">收藏</div>
            <div class="readAll">查看全文</div>
          </div>
        </div>
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

  

    <script  src="js/index.js"></script>




</body>

</html>
