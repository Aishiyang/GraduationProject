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
		<link href="themes/xecmoban_shunfeng/style.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
		<jsp:include page="header.jsp"></jsp:include>
		<div class="block box">
			<div class="blank"></div>
			<div id="ur_here">
				<s:text name="html.position"></s:text>
				:
				<a href="."><s:text name="html.home"></s:text> </a>
				<code>
					&gt;
				</code>
				<s:text name="html.goods"></s:text>
			</div>
		</div>
		<div class="blank"></div>
		<div class="block clearfix">
			<div class="box">
				<div class="box_1">
					<h3>
						<span>商品列表</span>
					</h3>
					<div class="clearfix goodsBox" style="border: none;">
						<s:iterator value="map.goodsList">
							<div class="goodsItem" style="padding: 10px 3px 15px 2px;">
								<a href="index/detail.action?id=${goodsid }"><img src="${image }" alt="${goodsname }" class="goodsimg" /> </a>
								<br />
								<p class="f1">
									<a href="index/detail.action?id=${goodsid }" title="${goodsname }">${goodsname }</a>
								</p>
								<s:text name="html.price"></s:text>
								：
								<font class="f1"> ￥${price }元 </font>
							</div>
						</s:iterator>
					</div>
				</div>
				<div class="blank5"></div>
			</div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>
