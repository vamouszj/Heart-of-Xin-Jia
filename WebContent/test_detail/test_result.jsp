<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.bean.*,com.tita.*,java.util.*,java.util.Map.Entry" %>
<%
			if(session.getAttribute("name")==null ){
				out.println("请登录后进入心理测试");
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
<link rel="stylesheet" type="text/css" href="css/test_result.css">
<link href="css/responsive.css" rel="stylesheet">
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
        <a class="navbar-brand" href="../index.html"><i class="fa fa-bolt">心之馨家</i> </a></div>
      <div class="collapse navbar-collapse navbar-left">
        <ul class="nav navbar-nav">
          <li><a href="index.jsp">首页</a></li>
          <li><a href="artical.jsp?number=1">精品文章</a></li>
          <li><a href="voice.jsp?number=1">倾心之音</a></li>
          <li  class="active"><a href="test.jsp?number=1">心理测试</a></li>
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
      			<img alt="logo" src="../images/userPic.jpg">
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
      			<img src="../images/userLogo.png">
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
        	<form action="RegisterServlet" method="get" class="form-horizontal">
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
</header>
<!--/header-->

<%
	TextBean textq=(TextBean)request.getSession().getAttribute(request.getSession().getAttribute("textstring").toString());
	int sum=Integer.parseInt(request.getSession().getAttribute("sum").toString());
	 String Resb=request.getSession().getAttribute("results").toString();
%>

<div class="color-border"> </div>
<section id="inner-page">
  	<div class="container">
	    <div class="center">
	      <h2>心理测试</h2>
	      <p class="lead">在这里，可以找到自己的缩影，探测你内心的世界，打开你的新世界.</p>
	    </div>
	    <div class="main_frame">
	        <div class="frame_header">
	          <div class="row">
	            <div class="col-xs-12">
	              <div class="frame_label">
	                <a href="../index.jsp">首页</a>
	                <span>></span>
	                <a href="../test.jsp?number=1" class="select">心理测试</a>
	                <span>></span>
	                <span>测试内容</span>
	              </div>
	            </div>
	          </div>       
	          <div class="row">
	          	<div class="col-xs-12">
	          		<div class="frame_tit">
	          			<span><%=textq.getTest_title() %></span>
	          		</div>
	          	</div>
	          </div>
	          <div class="row">
	          	<div class="col-xs-12">
		          	<div class="rword">
		          		<div class="row">
			          		<div class="col-xs-12">
			          			<span class="rs">我的结果：忧伤指数<%=sum%50*2 %>%</span>
			          		</div>		          			
		          		</div>
		          		<div class="row">
			          		<div class="col-xs-12">
			          			<span class="desc">
				          			<p><%=Resb %></p>
		          				</span>
			          		</div>		
		          		</div>
		          	</div>  		
	          	</div>
	          </div>
	          <div class="row">
	          	<div class="col-xs-12">
	          		<span class="rtit">大家都爱的专业测评</span>
	          	</div>
	          </div>
              <div class="row">
	              	<div class="col-xs-12">
	              	<%
	              		TestsSearch test=new TestsSearch();
	        			List<TextBean> testlist=test.getlist();
	        			TextBean TB=new TextBean();
	        			Map<Integer,Integer> map=new HashMap<Integer,Integer>(); 
	        			for(int i=0;i<testlist.size();i++){
	        				map.put(i, testlist.get(i).getTest_pop_sum());
	        			}
	        			List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());  
	        		     Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {  
	        		          //降序排序  
	        		          public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {  
	        		              return o2.getValue().compareTo(o1.getValue());  
	        		          }  
	        		      });  
	        		     for(int i=0;i<3;i++){
	        		    	  String string=list.get(i).toString();
	        		    	  string=string.substring(0, 1);
	        		    	  TB=testlist.get(Integer.parseInt(string));
	        		      
	              	%>
	          		    <div class="recomend">
	          		        <div class="col-md-4 col-sm-6">
	          		          	<div class="recomend-wrap">
	          		          	<%
										
										String TestHref="test_detail/test_show.jsp?textid="+TB.getTest_id()+"&textpop="+TB.getTest_pop_sum();
										String string_text="text"+TB.getTest_id();
										session.setAttribute(string_text, TB);    //封装text对象
										int j=i+1;
										String img_src="test_detail/test"+j+".jpg";
										
									%>
	          			          	<a href=<%=TestHref %>>
	          			          		<img src=<%=img_src %> class="img-responsive" alt="art">
	          			          		<a href=<%=TestHref %> class="recomend-a" ><%=TB.getTest_title() %></a>
	          			          		<span class="tpeople"><%=TB.getTest_pop_sum() %>人测试过</span>
	          			          	</a>
	          		          	</div>
	          		        </div>
	          		        <!--/.col-md-4-->
	          			</div>
						<%
	        		     }
						%>
                	</div>
                <!--/.services--> 
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
</section>

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

<script src="../js/jquery.js"></script> 
<script src="../js/bootstrap.min.js"></script> 
<script src="../js/jquery.prettyPhoto.js"></script> 
<script src="../js/jquery.isotope.min.js"></script> 
<script src="../js/main.js"></script>
</body>
</html>
