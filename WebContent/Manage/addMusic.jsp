<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>Heart Home</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
    
    <link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
    <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">

    <script src="lib/jquery-1.7.2.min.js" type="text/javascript"></script>

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
        input[type="file"]{
            margin:10px 10px;
        }
        .block-body div{
            margin:10px 79.6% 10px 10px;
            text-align: center;
        }   

    </style>

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
  <body> 
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
            <h1 class="page-title">音乐管理</h1>
        </div>
        
        <ul class="breadcrumb">
            <li><a href="Manange_index.jsp">主页</a> <span class="divider">/</span></li>
            <li class="active">添加音乐</li>
        </ul>
        <div class="container-fluid">
            <div class="row-fluid">
            
                <div class="row-fluid">

                    <div class="alert alert-info">
                        <button type="button" class="close" data-dismiss="alert">×</button>
                        <strong>tips: &nbsp;</strong>When you have a good mood, it is very beautiful today.
                    </div>

                </div>
  				<div class="row-fluid">
                    <div class="block">
                        <a href="#tablewidget" class="block-heading" data-toggle="collapse">Music</a>
                        <div id="tablewidget" class="block-body collapse in">
                            <form enctype="multipart/form-data" method="post" action="../Add_music_Servlet" class="formMusic">
                                <input type="text" name="Music_name" placeholder="歌曲名称"><br>
                                <input type="text" name="Music_song" placeholder="歌手"><br>
                                <input type="text" name="Music_type" placeholder="歌曲类型"><br>
                                <input type="submit" value="提交" class="btn">
                                <input type="file" id="oneMusic" name="oneMusic" blur="addFile"><br>                                
                            </form>
                            <div class="alert alert-success" id="sendSuccess">
                                音乐已添加成功
                            </div>
                            <div class="alert alert-warning" id="sendWarning">
                                很遗憾，请重新尝试
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
    <script type="text/javascript" src="js/oneMusic.js"></script>
    
  </body>
</html>


