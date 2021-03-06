<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.tita.*,com.bean.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>Bootstrap Admin</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
    
    <link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
    <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">

    <script src="lib/jquery-1.7.2.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="./js/controlTab.js"></script>

    <!-- Demo page code -->

    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .brand { font-family: georgia, serif; }
        .brand .first {
            color: #ccc;
            font-style: italic;
        }
        .brand .second {
            color: #fff;
            font-weight: bold;
        }
        .pageSort li{
        	list-style-type:none;
        	display: inline-block;
        }
        .pageSort li a{
        	display: inline-block;
        }
    </style>
    <script type="text/javascript">
    window.onload = function(){
      initTableId();
    	deleteOneRow();
    }
    </script>

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="../assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
  </head>

  <!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
  <!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
  <!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
  <!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
  <!--[if (gt IE 9)|!(IE)]><!--> 
  <body class=""> 
  <!--<![endif]-->
    
    <div class="navbar">
        <div class="navbar-inner">
                <ul class="nav pull-right">
                    
                    <!-- <li><a href="#" class="hidden-phone visible-tablet visible-desktop" role="button">Settings</a></li> -->
                    <li id="fat-menu" class="dropdown">
                        <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="icon-user"></i> 管理员名称
                        </a>

                        <ul class="dropdown-menu">
                            <li><a tabindex="-1" href="sign-in.html">退出登录</a></li>
                        </ul>
                    </li>
                    
                </ul>
                <a class="brand" href="Manange_index.jsp"><span class="first">心</span><span class="first">之</span><span class="second">馨
                </span><span class="second">家</span></a>
        </div>
    </div>
    


    
    <div class="sidebar-nav">
        <a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i class="icon-edit"></i>文章管理<i class="icon-chevron-up"></i></a>
        <ul id="dashboard-menu" class="nav nav-list collapse in">
            <li><a href="Manange_index.jsp">文章列表</a></li>
            <li ><a href="addArticle.jsp">添加文章</a></li>          
        </ul>

        <a href="#accounts-menu" class="nav-header" data-toggle="collapse"><i class="icon-music"></i>音乐管理<i class="icon-chevron-up"></i></a>
        <ul id="accounts-menu" class="nav nav-list collapse">
            <li ><a href="musicList.jsp">音乐列表</a></li>
            <li ><a href="addMusic.jsp">添加音乐</a></li>
        </ul>

        <a href="#error-menu" class="nav-header collapsed" data-toggle="collapse"><i class="icon-heart"></i>测试管理<i class="icon-chevron-up"></i></a>
        <ul id="error-menu" class="nav nav-list collapse">
            <li ><a href="testList.jsp">查看测试列表</a></li>
            <li ><a href="addTest.jsp">添加测试项目</a></li>
        </ul>

        <a href="#legal-menu" class="nav-header" data-toggle="collapse"><i class="icon-home"></i>倾诉管理<i class="icon-chevron-up"></i></a>
        <ul id="legal-menu" class="nav nav-list collapse">
            <li ><a href="pourList.jsp">查看消息列表</a></li>
        </ul>

        <a href="userList.jsp" class="nav-header"><i class="icon-user"></i>用户管理</a>
    </div>
    

    
    <div class="content">
        
        <div class="header">
            <h1 class="page-title">用户管理</h1>
        </div>
        
                <ul class="breadcrumb">
            <li><a href="Manange_index.jsp">主页</a> <span class="divider">/</span></li>
            <li class="active">用户列表</li>
        </ul>
        <div class="container-fluid">
            <div class="row-fluid">
                    

<div class="row-fluid">

    <div class="alert alert-info">
        <button type="button" class="close" data-dismiss="alert">×</button>
        <strong>tips: &nbsp;</strong>When you have a good mood, it is very beautiful today.
    </div>

</div>
<%
	int pages;
	if(request.getParameter("pages")==null){
		pages=1;
	}else pages=Integer.parseInt(request.getParameter("pages").toString());
	Register_Mod RegM=new Register_Mod(pages);
	int sum_page=RegM.getCount();
	List<RegisterBean> list=RegM.getList();
	RegisterBean RB=null;
%>
<div class="row-fluid">
    <div class="block">
        <a href="#tablewidget" class="block-heading" data-toggle="collapse">Article</a>
        <div id="tablewidget" class="block-body collapse in">
            <table class="table">
              <thead>
                <tr>
                  <th>#</th>
                  <th>用户名</th>
                  <th>手机号</th> 
                  <th>邮箱</th>
                  <td>操作</td>
                </tr>
              </thead>
              <tbody id="tbody">
              <%
              		for(int i=0;i<list.size();i++){
              			
              			RB=list.get(i);
              			int count=(sum_page-1)*10+i+1;
              			String del_user="../Del_user_Servlet?user_id="+RB.getR_id();
              %>
                <tr>
                  <td><%=count %></td>
                  <td><%=RB.getUser_name() %></td>
                  <td><%=RB.getRegister_phone_num() %></td>
                  <td><%=RB.getRegister_mailbox() %></td>
                  <td><a href=<%=del_user %> class="deleteBtn">删除</a></td>      <!-- 注意：id不可以少 -->
                </tr>
                <%
              		}
                %>
              </tbody>
            </table>
            <ul class="list-inline pageSort pagination">
	        	<li><a href="userList.jsp?pages=1">&laquo;</a></li>
	        	<%
	        		for(int i=1;i<=sum_page;i++){
	        			String page_url="userList.jsp?pages="+i;
	        	%>
	        	<li><a href=<%=page_url %>><%=i %></a></li>
	        	<%
	        		}
	        		String Last_page="userList.jsp?pages="+sum_page;
	        	%>
	        	<li><a href=<%=Last_page %>>&raquo;</a></li> 	
		    </ul> 
        </div>
      	      	
		</div>

    </div>
</div>


                    
     <footer>
        <hr>
			 <p class="pull-right">Prehistorical powers&nbsp;<a href="index.html" title="心之馨家" target="_blank">心之馨家</a></p>
			 <p>&copy; 2016 <a href="#" target="_blank">心之馨家</a></p>
    </footer>
                    
            </div>
    </div>
    


    <script src="lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>
    
  </body>
</html>


