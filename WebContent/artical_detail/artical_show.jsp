<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.bean.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>心之馨家</title>
<meta name="description" content="">

<!-- core CSS -->
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/prettyPhoto.css" rel="stylesheet">
<link href="../css/main.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="../css/artical_show.css">
<link href="../css/responsive.css" rel="stylesheet">

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
        <a class="navbar-brand" href="../index.jsp"><i class="fa fa-bolt">心之馨家</i> </a></div>
      <div class="collapse navbar-collapse navbar-left">
        <ul class="nav navbar-nav">
          <li><a href="../index.jsp">首页</a></li>
          <li class="active"><a href="../artical.jsp?number=1">精品文章</a></li>
          <li><a href="../voice.jsp?number=1">倾心之音</a></li>
          <li><a href="../test.jsp?number=1">心理测试</a></li>
          <li><a href="../pour.jsp">心之港湾</a></li>
        </ul>
      <form class="navbar-form navbar-left" role="search">
            <div class="inp-wrap">
              <input type="text" class="form-control inp-text" placeholder="Search">
              <span class="ser-logo"></span>  
            </div>
        </form>
      </div>
          <div class="collapse navbar-collapse navbar-right">
      	<ul class="nav navbar-nav">
      		 <%
            		if(session.getAttribute("name")!=null ){
      		%>
      		<li>
      			账号：
      			<%
      				out.println(session.getAttribute("name"));
      			%>
      			
      		</li>
      		<%
      			}else{
      		%>
      		<li><a data-toggle="modal" href="#LoginModal">登录</a></li>
      		<li><a data-toggle="modal" href="#SubmitModal">注册</a></li>
      		<%
      			}
      		%>
      	</ul>
      </div>
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
<!--/header-->
<%
	String article_title=request.getParameter("actile_name");
     ArticleBeam abean =(ArticleBeam)session.getAttribute(article_title);
%>
<div class="color-border"> </div>
<section id="inner-page">
  <div class="container">
    <div class="center">
      <h2>精品文章</h2>
      <p class="lead">平静后是舒畅的快乐。给你带来温暖文字、净化心灵的治愈系心理学。生活本美好，本是艳阳高照，<br>愿你从容一点，坦然一点......</p>
    </div>
    <div class="novel">
      <div class="novel_header">
        <div class="row">
          <div class="col-xs-12">
            <div class="curr">
              <a href="../index.jsp">首页</a>
              <span>></span>
              <% 
              String artcle;
              if(request.getParameter("number")!=null){
            			  artcle="../artical.jsp?number="+request.getParameter("number");
            	}else{
            		artcle="../artical.jsp?number=1";
            	}
              %>
              
              <a href=<%=artcle %> class="selected">精品文章</a>
              <span>></span>
              <span>文章详情</span>
            </div>
          </div>
        </div>       
        <div class="row">
          <div class="col-xs-12">
            <div class="title">
              <h1><%=abean.getArticle_tite() %></h1>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-xs-12">
            <div class="zan">
              <span class="span_h">
                <span class="thumb_h"></span> 132
              </span>
              <span class="span_h">
                <span class="eye_h"></span> 1368
              </span>
              <span class="deliver">发表于2016-10-23 10:40:44</span>
            </div>          
          </div>
        </div>
      </div>
      <div class="novel_body">  
        <div class="row">
          <div class="col-xs-12">
          	<%String image_path="../"+abean.getImage(); %>
            <p class="img_txt"><img src=<%=image_path %> class="img-responsive center-block" alt="novel_img"></p>     
              <%
                                int length= abean.getArticle_title().length();
              						String pev_title=abean.getArticle_title().substring(0,length/2 );
              						String last_title=abean.getArticle_title().substring(length/2+1,length );
              %>
              	<%=pev_title %>
             	 <p class="img_txt"><img src="art_show_1a.jpg" class="img-responsive center-block" alt="novel_img"></p>
          
            	<p class="p_txt"><span>
       					<%=last_title %>	
          			</span></p>
          </div>
        </div> 
        <div class="row">
          <div class="col-xs-12 foot_txt">
            <span class="left_line"></span>
            <span class="line_text">心之馨家</span>
            <span class="right_line"></span>
          </div>
        </div>  
      </div>
    </div>
  </div>
  <!--/.container--> 
</section>

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

<script src="../js/jquery.js"></script> 
<script src="../js/bootstrap.min.js"></script> 
<script src="../js/jquery.prettyPhoto.js"></script> 
<script src="../js/jquery.isotope.min.js"></script> 
<script src="../js/main.js"></script>


</body>
</html>