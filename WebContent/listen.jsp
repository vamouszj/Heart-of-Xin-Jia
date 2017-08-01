<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.tita.*,com.bean.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>心之馨家</title>
<meta name="description" content="">
<meta name="keywords" content="">

<link rel="stylesheet" type="text/css" href="css/listen.css">
<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
<!-- <script src="jquery-3.1.1.min.js" type="text/javascript" charset="utf-8"></script> -->
</head>

<%
	String music=request.getParameter("music");
	MusicInfo mu=(MusicInfo)session.getAttribute(music); 
	System.out.println(mu.getMusic_name()+"  "+mu.getMusic_route());
   // out.close();
%>
<body>
	<div id="bgImage" class="bgImage"></div>
	<div class="logo"></div>
  	<div class="content">
  		<h2 id="tit" class="c_title"><%=mu.getMusic_name() %></h2>
  		<div>
  			<span id="singer" class="singer">主唱：<%=mu.getMusic_song() %></span>
  			<p id="comment" class="jie">音乐类型：<%=mu.getMusic_type() %></p>
  		</div>
  		<div class="playWrap">
	  		<audio src=<%=mu.getMusic_route() %> id="music" autobuffer autoloop></audio>
  			<a href="#" id="prebtn" class="pre" ></a>
  			<a href="#" id="playbtn" class="pause"></a>
  			<a href="#" id="nextbtn" class="next"></a>
        <!-- 进度条 -->
  			<div id="process" class="process">   
                  <span id="ped" class="pr_played" style="width: 0%;"></span>
                  <a href="#" id="ptn" class="pr_btn" draggable="true" style="left: 0%;"></a>
                </div>
  			<span id="timeShow" class="time"></span>
  		</div>
  		<div class="btns">
  			<a href="#" class="comment">评论</a>
  			<a href="#" class="collect">收藏(435)</a>
  			<a href="#" class="share">分享</a>
  			<a href="" download="" id="down" class="download">下载</a>
  		</div>
  		<!--  <input type="text" id="Music_id" style="height:0px;width:0px" value="">-->
  		<textarea rows="0" cols="0" title=<%=mu.getId() %> style="height:0px;width:0px" id="Music_id"><%=mu.getId() %></textarea>
  	</div>
    <script src="js/play.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>