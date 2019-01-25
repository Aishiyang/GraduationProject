<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="description" content="iDea a Bootstrap-based, Responsive HTML5 Template">
		<meta name="author" content="htmlcoder.me">
		<!-- Mobile Meta -->
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<!-- Favicon -->
		<link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.ico">
		<!-- Bootstrap core CSS -->
	  	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/bootstrap.css">
	  	<!--external css-->
	  	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/font-awesome/css/font-awesome.css" />
	 	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/js/gritter/css/jquery.gritter.css" />
	  	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/lineicons/style.css">
	  	<!-- Custom styles for this template -->
	  	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/style.css">
	  	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/style-responsive.css">
	  	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	  	<!--[if lt IE 9]>
	        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	    <![endif]-->
	</head>
	<body>
		<section id="container">
    		<!--header start-->
    		<header class="header black-bg">
      			<div class="sidebar-toggle-box">
        			<div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
      			</div>
		      	<!--logo start-->
		      	<a href="index" class="logo"><b>NarutoWorld</b></a>
		      	<!--logo end-->
		      	<div class="nav notify-row" id="top_menu">
		        	<!--  notification start -->
		        	<ul class="nav top-menu"></ul>
		        	<!--  notification end -->
		      	</div>
		      	<div class="top-menu">
		        	<ul class="nav pull-right top-menu">
		          		<li><a class="logout" href="#">注销</a></li>
		        	</ul>
		      	</div>
		    </header>
		    <!--header end-->
		    <!--sidebar start-->
		    <aside>
		      	<div id="sidebar" class="nav-collapse ">
		        	<!-- sidebar menu start-->
		        	<ul class="sidebar-menu" id="nav-accordion">
		          		<p class="centered">
		            		<a href="${pageContext.request.contextPath}/admin_index">
		              			<img src="${pageContext.request.contextPath}/assets/img/ui-sam.jpg" class="img-circle" width="60">
		            		</a>
		          		</p>
		          		<h5 class="centered">shaohan.wang</h5>
		          		<li class="mt">
		            		<a class="index" href="${pageContext.request.contextPath}/admin_index"> 
			              		<!-- <i class="fa fa-dashboard"></i>  -->
			              		<span class="glyphicon glyphicon-home" aria-hidden="true"></span>
			              		<span>&nbsp;&nbsp;首页</span>
		            		</a>
		          		</li>
		          		<li class="sub-menu">
		            		<a class="UserInformationManagement" href="${pageContext.request.contextPath}/admin_userInformationManagement"> 
		              			<i class="fa fa-check"></i> 
		              			<span>用户管理</span>
		            		</a>
		          		</li>
		          		<li class="sub-menu">
		            		<a class="CharacterInfoManagement" href="${pageContext.request.contextPath}/admin_characterInfoManagement"> 
		              			<i class="fa fa-book"></i> 
		              			<span>角色信息管理</span>
		            		</a>
		          		</li>
		          		<li class="sub-menu">
		            		<a class="NewsManagement" href="${pageContext.request.contextPath}/admin_newsManagement"> 
		              			<i class="fa fa-th"></i> 
		              			<span>新闻管理</span>
		            		</a>
		          		</li>
		          		<li class="sub-menu">
		            		<a class="LinksManagement" href="${pageContext.request.contextPath}/admin_linksManagement"> 
		              			<i class="fa fa-tasks "></i> 
		              			<span>相关链接管理</span>
		            		</a>
		          		</li>
		          		<li class="sub-menu">
		            		<a class="HomePhotoManagement" href="${pageContext.request.contextPath}/admin_homePhotoManagement"> 
		              			<i class="fa fa-dashboard"></i> 
		              			<span>首页图片管理</span>
		            		</a>
		          		</li>
		          		<li class="sub-menu">
		            		<a class="SystemNotification" href="${pageContext.request.contextPath}/admin_systemNotification"> 
			              		<i class="fa fa-cogs"></i> 
			              		<span>系统公告</span>
		            		</a>
		          		</li>
		        	</ul>
		        	<!-- sidebar menu end-->
		      	</div>
		    </aside>
		    <!--sidebar end-->
		</section>
	</body>
</html>