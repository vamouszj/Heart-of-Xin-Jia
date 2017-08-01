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
    <script type="text/javascript" src="js/controlTab.js"></script>

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
                            <li><a tabindex="-1" href="sign-in.jsp">退出登录</a></li>
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

        <a href="userList.html" class="nav-header"><i class="icon-user"></i>用户管理</a>
    </div>
    

    
    <div class="content">      
        <div class="header">
            <h1 class="page-title">文章管理</h1>
        </div>
        
                <ul class="breadcrumb">
            <li><a href="Manange_index.jsp">主页</a> <span class="divider">/</span></li>
            <li class="active">文章列表</li>
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
	if(request.getParameter("page")==null){
    	pages=1;
    }else{
		 pages=Integer.parseInt(request.getParameter("page").toString());
	}
	SearchArticle article=new SearchArticle(pages);
	List<ArticleBeam> list=article.getList();
  	int Conut=article.getConut();
%>

<script type="text/javascript">
var req;

function doStart(int Article){
	   if (window.XMLHttpRequest)
	    {
		   req = new XMLHttpRequest();
	    }
	    else if (window.ActiveXObject)
	    {
	    	req = new ActiveXObject("Microsoft.XMLHTTP");
	    }
	   if (req) {
		var url="../Del_Article_Servlet";
	
		req.open("POST",url,true);
		req.onreadystatechange = back;
		req.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		req.send("title_id="+Article);
		//setTimeout("doStart()",10000);
	}
}

function back(){
	if (req.readyState == 4) {
		if (req.status == 200) {
			alert("run!!!");
		}
	}
}


</script>

<div class="row-fluid">
    <div class="block">
        <a href="#tablewidget" class="block-heading" data-toggle="collapse">Article</a>
        <div id="tablewidget" class="block-body collapse in">
            <table class="table">
              <thead>
                <tr>
                  <th>文章序号</th>
                  <th>文章标题</th>
                  <th>发表时间</th> 
                  <th>阅读人数</th>
                  <th>执行操作</th>
                </tr>
              </thead>
              <tbody>
              <%
      			if(list!=null){
      				int Artcle_page=(pages-1)*6;
      				for(int i=0;i<list.size();i++){
      					ArticleBeam abean=(ArticleBeam)list.get(i);
      			%>
                <tr>
                  <td><%=Artcle_page+i+1 %></td>
                  <td><%=abean.getArticle_tite() %></td>
                  <td><%=abean.getArticle_up_time() %></td>
                  <td><%=abean.getArticle_read_time() %></td>
                  <%
                  		
                  		String Obj_url="oneArticl.jsp?title_id="+abean.getArticle_id();
                  		String Mod_url="editArticle.jsp?title_id="+abean.getArticle_id();
                  		String Del_url="../Del_Article_Servlet?title_id="+abean.getArticle_id();
                  		//System.out.println(session.getAttribute(String.valueOf(abean.getArticle_id())));
                  		session.setAttribute(String.valueOf(abean.getArticle_id()), abean);
                  		String url="doStart("+abean.getArticle_id()+")";
                  %>
                  <td><a href=<%=Obj_url %>>查看|</a><a href=<%=Mod_url %>>修改|</a><a class="deleteBtn" href=<%=Del_url %> >删除</a></td>
                </tr>
                <%
      				}
      			}
                %>
              </tbody>
            </table>
            <ul class="list-inline pageSort pagination">
    			<li><a href="Manange_index.jsp?page=1">Prev</a></li>
    			
    			<%
    				for(int j=1;j<=Conut;j++){
    					String ArticleHref="Manange_index.jsp?page="+j;
    			%>
    			
       				<li><a href=<%=ArticleHref %>><%=j %></a></li>

    			<%
    				}
    				String Next="Manange_index.jsp?page="+Conut;
    			%>
    				<li><a href=<%=Next %>>Next</a></li>
    		</ul>
        </div>
      	      	
		</div>

    </div>
</div>


                    
     <footer>
        <hr>
			 <p class="pull-right">Prehistorical powers&nbsp;<a href="../index.jsp" title="心之馨家" target="_blank">心之馨家</a></p>
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