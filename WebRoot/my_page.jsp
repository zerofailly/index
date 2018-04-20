<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" >

<head>
  <!-- <meta charset="UTF-8"> -->
  <title>${sessionScope.user.name }的主页</title>
  
  
  <link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/css/bootstrap.css'>
<link rel='stylesheet prefetch' href='https://cdn.bootcss.com/codemirror/5.36.0/codemirror.min.css'>
<link rel='stylesheet prefetch' href='https://cdn.bootcss.com/codemirror/5.36.0/theme/eclipse.min.css'>
<link rel='stylesheet prefetch' href='https://cdn.bootcss.com/codemirror/5.36.0/theme/dracula.min.css'>

      <link rel="stylesheet" href="css/style_2.css">

  
</head>

<body>

  
<header>
  <div class="container">
    <div class="row row1">
      <div class="col-md-4">Welcome to UC_WORK</div>
      <div class="col-md-6 offset-2">
        <div class="logo">图标</div>
        <div class="rl"><span id="span_new_code">新建代码</span><span id="span_friend">好友列表</span><span id="span_share">分享列表</span></div>
      </div>
    </div>
    <div class="row header2">
      <div class="share_list">
        <div class="close" id="share_close">X</div>
        <div class="share_btn"> <span>我的分享</span><span>给我分享</span></div>
        <div class="info_list">
          <div class="head_icon"></div>
          <div class="code_name">Java Sysytem</div>
          <div class="state"> <span>已接受</span></div>
        </div>
        <div class="info_list">
          <div class="head_icon"></div>
          <div class="code_name">Java Sysytem</div>
          <div class="state"> <span>已接受</span></div>
        </div>
      </div>
      <div class="friend_list">
        <div class="close" id="friend_close">X</div>
        <div class="friend">
          <div class="head_icon">头</div>
          <div class="net_name">网名</div>
        </div>
        <div class="friend">
          <div class="head_icon">头</div>
          <div class="net_name">网名</div>
        </div>
        <div class="friend">
          <div class="head_icon">头</div>
          <div class="net_name">网名</div>
        </div>
      </div>
      <div class="col-md-10 offset-md-1">
        <div class="row">
          <div class="col-md-6">
            <div class="head_icon">头像</div>
            <div class="net_name">网名</div>
            <div class="person_name">个性签名</div>
          </div>
          <div class="col-md-5 offset-1">
            <div class="info">编辑资料(添加好友/删除好友)</div>
            <div class="search">搜索好友:<span>搜索</span></div>
            <input/>
          </div>
        </div>
      </div>
    </div>
    <div class="row header3">
      <div class="my_msg"><span>我的动态</span><span>收藏列表</span><span>我的评论</span></div>
    </div>
    <div class="row">
      <div class="new_code">
        <div class="close" id="new_code_close">X</div>
        <div class="title">主题:
          <input/>
        </div>
        <div class="mar_code">代码描述:</div>
        <textarea id="code_main" name="" cols="30" rows="10"></textarea>
        <div class="mar_class">主类:
          <input/>
        </div>
        <div class="code_area">
          <textarea id="code_msg" name="" cols="30" rows="10"></textarea>
          <div class="run_over"> 
            <h4>运行结果:</h4>
            <p></p>
          </div>
        </div>
        <div class="commit">
          <div class="power">
            <select id="power" name="">
              <option value="">公开</option>
              <option value="">私有</option>
            </select>
          </div><span>取消</span><span>保存</span><span>运行代码</span>
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
  <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/js/bootstrap.min.js'></script>
<script src='https://cdn.bootcss.com/codemirror/5.36.0/codemirror.min.js'></script>
<script src='https://cdn.bootcss.com/codemirror/5.36.0/mode/clike/clike.min.js'></script>
<script src='https://cdn.bootcss.com/codemirror/5.36.0/keymap/sublime.min.js'></script>

  

    <script  src="js/index_2.js"></script>




</body>

</html>