<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="com.xin.*,com.bean.*,com.tita.*,java.util.*" %>
 <%
	//文章查询
 		SearchArticle article=new SearchArticle();
		List<ArticleBeam> list=article.getList();
	//音乐查询
		VoiceServlet voice=new VoiceServlet();
		List<MusicInfo> musiclist=voice.getList();
	//测试查询
		TestsSearch test=new TestsSearch();
		List<TextBean> testlist=test.getlist();
	
	    request.setCharacterEncoding("utf-8");
	    int random[]={-1,-1,-1,-1,-1,-1};
		int j;
		//文章
		for(int i=0;i<3;){
			int number=new Random().nextInt(list.size())+1;
			for(j=0;j<3;j++){
				if(number==random[j]){
					break;
				}
			}
			if(j<3){
				continue;
			}
			random[i]=number;
			String str=Integer.toString(i);
			ArticleBeam bean=(ArticleBeam)list.get(random[i]-1);
			request.setAttribute(str, bean);
			i++;
		} 
		//音乐
			for(int i=0;i<6;){
				int number=new Random().nextInt(musiclist.size())+1;
				for(j=0;j<6;j++){
					if(number==random[j]){
						break;
					}
				}
				if(j<6){
					continue;
				}
				random[i]=number;
				String str="music"+Integer.toString(i);
				MusicInfo music=(MusicInfo)musiclist.get(random[i]-1);
				request.setAttribute(str, music);
				i++;
			} 
		//测试
		for(int i=0;i<3;){
			String str="test"+Integer.toString(i);
			TextBean text=(TextBean)testlist.get(i);
			request.setAttribute(str, text);
			i++;
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
<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
</head>
<!--/head-->

<body class="homepage">
<header id="header">
  <nav class="navbar navbar-inverse" role="banner">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
        <a class="navbar-brand" href="index.html"><i class="fa fa-bolt">心之馨家</i> </a></div>
      <div class="collapse navbar-collapse navbar-left">
        <ul class="nav navbar-nav">
          <li class="active"><a href="index.jsp">首页</a></li>
          <li><a href="artical.jsp?number=1">精品文章</a></li>
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

<div id="main-slide" class="carousel slide">
    <ol class="carousel-indicators">
        <li data-target="#main-slide" data-slide-to="0" class="active"></li>
        <li data-target="#main-slide" data-slide-to="1"></li>
        <li data-target="#main-slide" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner">
        <div class="item active">
        	<img class="img-responsive center-block" src="images/home/slider/bg1.jpg" alt="slider">
        </div>
        <div class="item">
        	<img class="img-responsive center-block" src="images/home/slider/bg2.jpg" alt="slider">
        </div>
        <div class="item">
        	<img class="img-responsive center-block" src="images/home/slider/bg3.jpg" alt="slider">
        </div>
    </div>
</div>
<!--/#main-slider-->
<section id="feature" >
  <div class="container">
    <div class="center">
      <h2>精品文章</h2>
      <p class="lead">平静后是舒畅的快乐。给你带来温暖文字、净化心灵的治愈系心理学。生活本美好，本是艳阳高照，<br>愿你从容一点，坦然一点......
        </p>
    </div>
    <div class="row">
      <div class="features">
      	 <%
          			
          	 		for(int i=0;i<3;i++){
          	 			
          	 			 ArticleBeam articlebean_1=(ArticleBeam)request.getAttribute(String.valueOf(i)); 
          	 			String actile_name=articlebean_1.getArticle_tite();
            			session.setAttribute(actile_name, articlebean_1);
            			String url="artical_detail/artical_show.jsp?actile_name="+articlebean_1.getArticle_tite();
          	 	
     	   %>
        <div class="col-md-4 col-sm-6">
          <div class="feature-wrap">
     
          	<a href=<%=url %>>
          		<img src=<%=articlebean_1.getImage()%> class="img-responsive center-block" alt="art">
          		<h2><%=articlebean_1.getArticle_tite() %></h2>
            	<h3><%=articlebean_1.getArticle_title().substring(0, 20) %></h3>
            	
          	</a>
          </div>
        </div>
        <!--/.col-md-4-->
		<%} %>
      </div>
      <!--/.services--> 
    </div>
    <div class="row">
    	<div class="col-sm-12 more-btn">
    		<a href="artical.jsp?number=1">更多文章 >></a>
    	</div>
    </div>
    <!--/.row--> 
  </div>
  <!--/.container--> 
</section>
<!--/#feature-->

<section id="recent-works">
  <div class="container">
    <div class="center">
      <h2>倾心之音</h2>
      <p class="lead">一段段清新、明朗的旋律，各种女人独特的情调，不庸俗，不烦躁，在独自安静的小角落，聆听微风拂脸的声音，<br/>清新的治愈系歌曲会给你累透了的心灵重新赋予生命……</p>
    </div>
    <div class="row">
    <%
    		for(int i=0;i<6;i++){
    			String Music_url="music"+i;
    			MusicInfo music=(MusicInfo)request.getAttribute(Music_url);
    			int conu=i+1;
    			String Image_usr="images/home/musicpic/mus"+conu+".jpg";
    			
    			String music_url="listen.jsp?music="+music.getId();
				String mu_=String.valueOf(music.getId());
				session.setAttribute(mu_, music);
    %>
      <div class="col-xs-12 col-sm-4 col-md-4">
  		<div class="recent-work-wrap"> 
  			<a href=<%=music_url %> target="_blank">
  				<img class="img-responsive center-block" src=<%=Image_usr %> alt="mus">
      			<div class="overlay">
	        		<div class="recent-work-inner">
			        	<h3><%=music.getMusic_name() %></h3>
			          	<p>嘻哈民谣式的曲风，温馨且励志的歌词，可爱又单纯的唱腔。让人仿佛回到童年，身处朴实的乡村，简单的，幸福的.</p>
			          	<span class="symbol"></span>
			        </div>
      			</div>
  			</a>	
    	</div>
      </div>
      <%} %>
    </div>
    <div class="row music-row">
    	<div class="col-sm-12 more-btn">
    		<a href="voice.jsp?number=1">更多音乐 >></a>
    	</div>
    </div>
    <!--/.row--> 
  </div>
  <!--/.container--> 
</section>
<!--/#recent-works-->

<!-- /.test -->
<section id="test" >
  <div class="container">
    <div class="center">
      <h2>心理测试</h2>
      <p class="lead">在这里，可以找到自己的缩影，探测你内心的世界，打开你的新世界</p>
    </div>
    <div class="row">
      <div class="test">
      <%
      		for(int i=0;i<3;i++){
      			String text_="test"+Integer.toString(i);
      			TextBean text=(TextBean)request.getAttribute(text_);
      			System.out.println(text);
				String TestHref="test_detail/test_show.jsp?textid="+text.getTest_id()+"&textpop="+text.getTest_pop_sum();
				String string="text"+text.getTest_id();
				session.setAttribute(string, text);    //封装text对象
		
      %>
        <div class="col-md-4 col-sm-6">
          	<div class="test-wrap">
	          	<a href="#">
	          		<img src="images/home/testpic/test1.jpg" class="img-responsive center-block" alt="art">
	          		<a href=<%=TestHref %> class="test-a"><%=text.getTest_title() %></a>
	          	</a>
          	</div>
        </div>
        <!--/.col-md-4-->
        <%} %>

       
      </div>
      <!--/.services--> 
    </div>
    <div class="row">
    	<div class="col-sm-12 more-btn">
    		<a href="test.jsp?number=1">更多测试 >></a>
    	</div>
    </div>
    <!--/.row--> 
  </div>
  <!--/.container--> 
</section>
<!--/#test-->

<section id="partner">
  <div class="container">
    <div class="center">
      <h2>心之港湾</h2>
      <p class="lead">心里有心事或者有秘密想要说，而又不敢说吗？有烦心事无法释怀或是想大声呐喊出自己心里的想法吗？或者想说说心里话吗？<br/>来这里就对了，大声倾诉吧，释放你心中的能量，抵达你心中的港湾.</p>
    </div>
    <div class="row">
    	<div class="col-sm-12">
    		<div class="partner">
    			<a href="pour.jsp">进入港湾</a>
    		</div>
    	</div>
    </div>
  </div>
  <!--/.container--> 
</section>
<!--/#partner-->

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
<script src="js/form.js" type="text/javascript"></script>
</body>

</html>