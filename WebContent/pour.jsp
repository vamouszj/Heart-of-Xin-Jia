<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.bean.*" %>
    <%
    if(session.getAttribute("name")==null ){
		out.println("请登录后进入心之港湾");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>心之馨家</title>
<meta name="description" content="">

<!-- core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/prettyPhoto.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
<link href="css/responsive.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/pour.css">


<script type="text/javascript">
	var time_date;
	window.onload=function(){
		doStart();
	}
	var req;
	
	function doStart(){
		time_date=document.getElementById('Date_time').value;
		if(time_date==""){
			var Date_time=new Date();
			var date1=Date_time.toTimeString();
			var date2=Date_time.toLocaleDateString();
			time_date=date1+" "+date2;
			
		}
		   if (window.XMLHttpRequest)
		    {
			   req = new XMLHttpRequest();
		    }
		    else if (window.ActiveXObject)
		    {
		    	req = new ActiveXObject("Microsoft.XMLHTTP");
		    }
		   if (req) {
			var url="http://localhost:8080/text馨/AcceptionArjx";
		
			req.open("POST",url,true);
			req.onreadystatechange = back;
			req.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
			req.send("date_time="+time_date);
			setTimeout("doStart()",5000);
		}
	}
	
	function back(){
		if (req.readyState == 4) {
			if (req.status == 200) {
			//	var result = req.responseText;
				var result =  eval("(" + req.responseText + ")");
				var oUl = document.getElementById("ulMesList");
				oUl.innerHTML = oUl.innerHTML +result.message;
				if(result.date_time==null){
					document.getElementById('Date_time').innerHTML=time_date;
				}else{
					document.getElementById('Date_time').innerHTML=result.date_time;
				//	alert(result.date_time+"从文本框的数值为"+	document.getElementById('Date_time').value);
				}
			}
		}
	}
	

</script>



<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
</head>
<!--/head-->

<body>
<header id="header">
  <nav class="navbar navbar-inverse" role="banner">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
        <a class="navbar-brand" href="index.html"><i class="fa fa-bolt">心之馨家</i> </a></div>
      <div class="collapse navbar-collapse navbar-left">
        <ul class="nav navbar-nav">
          <li><a href="index.jsp">首页</a></li>
          <li><a href="artical.jsp?number=1">精品文章</a></li>
          <li><a href="voice.jsp?number=1">倾心之音</a></li>
          <li><a href="test.jsp?number=1">心理测试</a></li>
          <li  class="active"><a href="pour.jsp">心之港湾</a></li>
        </ul>
      <form class="navbar-form navbar-left" role="search">
            <div class="inp-wrap">
                <!--   <input type="text" class="form-control inp-text" placeholder="Search">
	            <span class="ser-logo"></span>  --> 
            </div>
        </form>
      </div>
       <!-- ==========================从此处更改======================================= -->
      <div class="collapse navbar-collapse navbar-right" id="divBtn">
	      <ul class="nav navbar-nav">
      		<li>
      			<!-- img的src需要后台获取 -->
      			<img alt="logo" src="./images/userPic.jpg">
      			<form action="logout" method="post" class="form-horizontal">
      				<input class="btn btn-sm btn-default" type="submit" id="logout" value="注销">
      			</form>
      		</li>
      		 <%
            		if(session.getAttribute("name")==null ){
      		%>
      		<li><a data-toggle="modal" href="#LoginModal">登录</a></li>
      		<li><a data-toggle="modal" href="#SubmitModal">注册</a></li>
      		<% 
            		}else{
      		%>
      		<li>
      			<textarea rows="10" cols="0" style="height:25px;width:100px" disabled="disabled" id="land_text"><%=session.getAttribute("name") %></textarea>
      		<!-- 	<form action="logout" method="post" class="form-horizontal"><input type="submit" value="注销"></form>-->
      		</li>
      		<%
            		}
      		%>
	      </ul>
	  
	      <div class='userInfo'>
      		<h4 class="modal-title"><i class="user-icon"></i><span class="user-text">用户信息</span></h4>
      		<span id="spanUserPic">
      			<!-- img的src需要后台获取 -->
      			<img src="images/userPic.jpg">
      		</span>
      		<span id="spanUserPicChange">
      			<span>点击改变头像</span>
      			<img src="images/userLogo.png">
      			<!-- 用户重新更改图片需要后台 -->
      			<input type="file"/>
      		</span>
      		<!-- 下面三个span标签里面的内容需要后台读取数据库 -->
      	 	<%
	      			RegisterBean RB=(RegisterBean)session.getAttribute("Regist");
      	 			if(RB!=null){
	      	%>
      		<p><strong>用户名：</strong><span><%=RB.getUser_name() %></span></p>
      		<p><strong>手机号：</strong><span><%=RB.getRegister_phone_num() %></span></p>
      		<p><strong>邮&nbsp;&nbsp;&nbsp;箱：</strong><span><%=RB.getRegister_mailbox() %></span></p>
      		<%} %>
      	</div>
      </div>
      <!-- ==========================从此处更改结束======================================= -->
    </div>
    <!--/.container--> 
  </nav>
  <!--/nav--> 
</header>
<!--/header-->

<!-- 表单验证(form)  -->
<!-- 登录模态框（Modal） -->
<div class="modal fade" id="LoginModal" tabindex="-1" role="dialog" aria-labelledby="loginLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
        	<form action="Landservlet" method="post" class="form-horizontal">
        		<div class="modal-header">
        		    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        		    <h4 class="modal-title" id="loginLabel"><i class="user-icon"></i><span class="user-text">用户登录</span></h4>
        		</div>
        		<div class="modal-body">
        			<div class="form-group">
        			    <div class="col-sm-offset-1 col-sm-10">
        			      <input type="text" name="username" class="form-control" id="username" placeholder="用户名/邮箱/手机号" onblur="checkuser();">
        			      <span id="hintuser"></span>
        			    </div>
        			</div>
        			<div class="form-group">
        			    <div class="col-sm-offset-1 col-sm-10">
        			      <input type="password" name="userPassword" class="form-control" id="password" placeholder="密码" onblur="checkpass();">
        			      <span id="hintpass"></span>
        			    </div>
        			</div>
					<div class="form-group">
					    <div class="col-sm-offset-1 col-sm-10">
					      <div class="checkbox">
					        <label>
					          <input type="checkbox">下次自动登录
					        </label>
					      </div>
					    </div>
					  </div>
        		</div>
        		<div class="modal-footer">
        		    <button type="sumbit" id="log-btn" class="btn btn-primary">登录</button>
        		</div>
        	</form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>


<!-- 注册模态框（Modal） -->
<div class="modal fade" id="SubmitModal" tabindex="-1" role="dialog" aria-labelledby="submitLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
        	<form action="./RegisterServlet" method="get" class="form-horizontal">
        		<div class="modal-header">
        		    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        		    <h4 class="modal-title" id="submitLabel"><i class="user-icon"></i><span class="user-text">用户注册</span></h4>
        		</div>
        		<div class="modal-body">
        			<div class="form-group">
        			    <label for="usern" class="col-xs-4 control-label">用户名</label>
        			    <div class="col-xs-7">
        			      <input type="text" name="user_name" class="form-control" id="usern" placeholder="请输入用户名" onblur="identify1();">
        			      <label class="control-label"><div id="flag" style="color:red"></div></label>
                    <span id="ide-user"></span>
        			    </div>
        			</div>
        			<div class="form-group">
        			    <label for="passw" class="col-xs-4 control-label">密码</label>
        			    <div class="col-xs-7">
        			      <input type="password" name="user_passwd" class="form-control" id="passw" placeholder="请输入密码" onblur="identify2();">
                    <span id="ide-pass"></span>
        			    </div>
        			</div>
        			<div class="form-group">
        			    <label for="confirm-passw" class="col-xs-4 control-label">确认密码</label>
        			    <div class="col-xs-7">
        			      <input type="password" class="form-control" id="confirm-passw" placeholder="请确认密码" onblur="identify3();">
                    <span id="ide-cpass"></span>
        			    </div>
        			</div>
        			<div class="form-group">
        			    <label for="phone" class="col-xs-4 control-label">手机号</label>
        			    <div class="col-xs-7">
        			      <input type="text" name="register_phone_num" class="form-control" id="phone" placeholder="请输入电话号码" onblur="identify4();">
                    <span id="ide-phone"></span>
        			    </div>
        			</div>
        			<div class="form-group">
        			    <label for="email" class="col-xs-4 control-label">邮箱</label>
        			    <div class="col-xs-7">
        			      <input type="text" name="register_mailbox" class="form-control" id="email" placeholder="请输入正确的邮箱" onblur="identify5();">
                    <span id="ide-email"></span>
        			    </div>
        			</div>
        		</div>
        		<div class="modal-footer">
        		    <button type="Submit"  class="btn btn-primary">立即注册</button>
        		</div>
       	 	</form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<!-- /.form -->
<!-- /.form -->
  

</header>
<!--/header-->
<div class="color-border"> </div>
<section id="inner-page">
  <div class="container">
    <div class="center">
      <h2>心之港湾</h2>
      <p class="lead">当你脆弱的心灵受到伤害，家是抚平伤口的良药；当你正处在人生的低谷，家是重获力量的源泉；当你独自在外经历风霜雨打，家是你温馨的避风港。<br>
       这里，心之家，心灵之家——心之馨家</p>
  	</div>
  </div>

  <!--/container--> 
	<!-- <div class="main">
		<div class="header">
			<span class="title">Home of the mind —— Heart Home</span>
		</div>
		<div class="content">
			<ul id="ulMesList"></ul>
		</div>
		<div class="footer">
			<div id="icon" class="icon">
				<img src="./images/user.jpg">
			</div>
			<form  method="post" id="comp">
				<input type="text" class="form-control" id="mes" name="mess" placeholder="写下你的悄悄话">
				<input type="button" id="btn" value="发送" onclick="btnOnclick()">
			</form>
		</div>
	</div> -->

	<div class="main">
		<div class="row">
			<div class="col-xs-12">
				<div class="header">
					<span>Home of the mind —— Heart Home</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<div class="content">
					<ul id="ulMesList" class="clearfix"></ul>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<div class="footer">
					<div id="icon" class="icon">
						<img src="./images/user.jpg"  class="img-responsive center-block">
					</div>
					<form  method="post" id="comp">
						<input type="text" class="form-control" id="mes" name="mess" placeholder="写下你的悄悄话">
						<input type="button" id="btn" value="发送" onclick="btnOnclick()">
					</form>
				</div>
			</div>
		</div>
	</div>
	
 </section> 
<textarea rows="0" cols="0" style="height:0px;width:0px" id="Date_time"></textarea>
<!--/#get-started-->
<div class="color-border"> </div>
<footer id="footer">
  <div class="container">
    <div class="row">
      <div class="col-xs-12">
        <div class="footer-text">Copyright &copy; 2016 心之馨家 版权所有</div>
      </div>     
    </div>
  </div>
</footer>
<!--/#footer--> 

<script src="js/jquery.js"></script> 
<script src="js/bootstrap.min.js"></script> 
<script src="js/jquery.prettyPhoto.js"></script> 
<script src="js/jquery.isotope.min.js"></script> 
<script src="js/main.js"></script>
<script type="text/javascript" src="js/pour.js"></script>
</body>

</html>