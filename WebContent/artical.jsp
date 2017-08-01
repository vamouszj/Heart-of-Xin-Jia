<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.bean.*,com.tita.*"%>
<script type="text/javascript">
	window.onload = function() {
		setPageNumClass();
		audioPlay();
	}
</script>

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

<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
</head>
<!--/head-->

<body >
<header id="header">
  <nav class="navbar navbar-inverse" role="banner">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
        <a class="navbar-brand" href="index.html"><i class="fa fa-bolt">心之馨家</i> </a></div>
      <div class="collapse navbar-collapse navbar-left">
        <ul class="nav navbar-nav">
          <li><a href="index.jsp">首页</a></li>
          <li class="active"><a href="artical.jsp?number=1">精品文章</a></li>
          <li><a href="voice.jsp?number=1">倾心之音</a></li>
          <li><a href="test.jsp?number=1">心理测试</a></li>
          <li><a href="pour.jsp" target="_blank">心之港湾</a></li>
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
<%
    int pages=Integer.parseInt(request.getParameter("number").toString());
	SearchArticle article=new SearchArticle(pages);
  	List<ArticleBeam> list=article.getList();
  	int Conut=article.getConut();
%>
<div class="color-border"> </div>
<section id="inner-page">
  <div class="container">
    <div class="center">
      <h2>精品文章</h2>
      <p class="lead">平静后是舒畅的快乐。给你带来温暖文字、净化心灵的治愈系心理学。生活本美好，本是艳阳高照，<br>愿你从容一点，坦然一点......</p>
    </div>
    <div class="artical">
      <div class="row">
      	<%
      		if(list!=null){
      		for(int i=0;i<list.size();i++){
      			ArticleBeam abean=(ArticleBeam)list.get(i);
      	%>
      	<div class="col-xs-12 col-sm-6 artline">
        	<div class="col-xs-5">
        		<a href="artical_detail/artical_show.jsp" class="img-a"><img src=<%=abean.getImage()%> class="img-responsive center-block" alt="anx"></a>	
        	</div> 
        	<div class="col-xs-7">
        		<%
        			String actile_name=abean.getArticle_tite();
        			session.setAttribute(actile_name, abean);
        			String url="artical_detail/artical_show.jsp?actile_name="+abean.getArticle_tite();
        		%>
        		<p><a href=<%=url %>  class="pstyle">
													<%  
        													out.print(abean.getArticle_tite());
        												%>
																</a></p>
        	 	<div class="clearfix cler">
        	 		<div class="thumb r-icon">86</div>
        	 		<div class="eye r-icon">1368</div>
        	 	</div>	
        	</div>
        </div>
         <%
      		}
      		}
        %>
        <!--/.col-xs-12 col-sm-6 artline-->
        
       
        <!--/.col-xs-12 col-sm-6 artline-->
      </div>
      <!--/.row--> 
    </div>
    <div class="paging">
    	<div class="row">
    		<div class="col-sm-12 center">
    			<ul>
    			<li><a href="artical.jsp?number=1">Prev</a></li>
    			
    			<%
    				for(int j=1;j<=Conut;j++){
    					String ArticleHref="artical.jsp?number="+j;
    			%>
    			
       				<li><a href=<%=ArticleHref %>><%=j %></a></li>

    			<%
    				}
    				String Next="artical.jsp?number="+Conut;
    			%>
    				<li><a href=<%=Next %>>Next</a></li>
    			</ul>
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
      <div class="footer-text col-sm-12">Copyright &copy; 2016 心之馨家 版权所有</div>
    </div>
  </div>
</footer>
<!--/#footer--> 

<script src="js/jquery.js"></script> 
<script src="js/bootstrap.min.js"></script> 
<script src="js/jquery.prettyPhoto.js"></script> 
<script src="js/jquery.isotope.min.js"></script> 
<script src="js/main.js"></script>
</body>
</html>