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
        <div class="close"  id="friend_close">X</div>
        <div id ="friend">
	        <div class="friend" v-for = "friend in friends">
	          <input type="hidden"  :value="friend.user_id">
	          <div class="head_icon"><img alt="" :src="friend.icon"></div>
	          <div class="net_name">{{friend.name}}</div>
	        </div>
        </div>
        <div class="page_index" id="page_index">
          <div class="pro_page" id= "pro_page"><</div>
          <div class="current_page" id="current_page">{{page.currentPage}}</div>
          <div class="nex_page" id="nex_page">></div>
          <div class="total_page" id= "total_page">共{{page.totalPage}}页</div>
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
        <div class="mar_code">代码描述:<span id="code_description"></span></div>
        <textarea id="code_main" name="" cols="30" rows="10"></textarea>
        <div class="mar_class">
         	 选择语言：
          <select id="compileType">
				<option value ="java">java</option>
		        <option value ="c">c</option>
		        <option value="c++">c++</option>
		  </select>
	    		<span>文件名:</span>
          <input id="fileName"/><span id="fileName_msg"></span>
        </div>
        <div class="code_area">
          <textarea id="code_msg1" name="" cols="30" rows="10"></textarea>
          <div class="run_over"> 
            <h4>运行结果:</h4>
            <p id="run_result"></p>
          </div>
        </div>
        <div class="commit">
          <div class="power">
            <select id="power" name="">
              <option value="public">公开</option>
              <option value="private">私有</option>
            </select>
          </div><span id="cancel_new_code">取消</span><span onclick=saveCode()>保存</span><span onclick=compile()>运行代码</span><a id="run_msg"></a>
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
  <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/js/bootstrap.min.js'></script>
<script src='https://cdn.bootcss.com/codemirror/5.36.0/codemirror.min.js'></script>
<script src='https://cdn.bootcss.com/codemirror/5.36.0/mode/clike/clike.min.js'></script>
<script src='https://cdn.bootcss.com/codemirror/5.36.0/keymap/sublime.min.js'></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
  

    <script  src="js/index_2.js"></script>
	<script  src="js/ajaxFunction.js"></script>



</body>

</html>