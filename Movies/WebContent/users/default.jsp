<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%=basePath%>" />
		<title>新影随我来商城</title>
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link href="themes/xecmoban_shunfeng/style.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
		<jsp:include page="header.jsp"></jsp:include>
		<div class="blank" style="height: 30px;"></div>
		<div class="block clearfix Main">
			<div class="goodsBox_1">
				<div class="xm-box">
					<h4 class="title">
						<span>最新电影</span>
						<a class="more" href="index/all.action">更多</a>
					</h4>
					<div id="show_new_area" class="clearfix">
						<s:iterator value="map.newsList">
							<div class="goodsItem">
								<a href="index/detail.action?id=${goodsid }"><img src="${pageContext.request.contextPath }${image }" alt="${goodsname }" class="goodsimg" /> </a>
								<br />
								<p class="f1">
									<a href="index/detail.action?id=${goodsid }" title="${goodsname }">${goodsname }</a>
								</p>
								价格 ：
								<font class="f1"> ￥${price }元 </font>
							</div>
						</s:iterator>
					</div>
				</div>
				<div class="blank"></div>
				<div class="xm-box">
					<h4 class="title">
						<span>热映电影</span>
						<a class="more" href="index/special.action">更多</a>
					</h4>
					<div id="show_hot_area" class="clearfix">
						<s:iterator value="map.hotList">
							<div class="goodsItem">
								<a href="index/detail.action?id=${goodsid }"><img src="${pageContext.request.contextPath }${image }" alt="${goodsname }" class="goodsimg" /> </a>
								<br />
								<p class="f1">
									<a href="index/detail.action?id=${goodsid }" title="${goodsname }">${goodsname }</a>
								</p>
								价格 ：
								<font class="f1"> ￥${price }元 </font>
							</div>
						</s:iterator>
					</div>
				</div>
				<div class="blank"></div>
				<div class="xm-box">
					<h4 class="title">
						<span>精品推荐</span>
						<a class="more" href="index/recommend.action">更多</a>
					</h4>
					<div id="show_best_area" class="clearfix">
						<s:iterator value="map.newsList">
							<div class="goodsItem">
								<a href="index/detail.action?id=${goodsid }"><img src="${pageContext.request.contextPath }${image }" alt="${goodsname }" class="goodsimg" /> </a>
								<br />
								<p class="f1">
									<a href="index/detail.action?id=${goodsid }" title="${goodsname }">${goodsname }</a>
								</p>
								价格 ：
								<font class="f1"> ￥${price }元 </font>
							</div>
						</s:iterator>
					</div>
				</div>
				<div class="blank"></div>
			</div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>
