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
		<div class="block box">
			<div class="blank"></div>
			<div id="ur_here">
				<s:text name="html.position"></s:text>
				:
				<a href="."><s:text name="html.home"></s:text> </a>
				<code>
					&gt;
				</code>
				<s:text name="html.detail"></s:text>
			</div>
		</div>
		<div class="blank"></div>
		<div class="block clearfix">
				<div id="goodsInfo" class="clearfix">
					<div class="imgInfo">
						<img src="${map.goods.image }" alt="${map.goods.goodsname }" width="360px;" height="360px" />
						<div class="blank5"></div>
						<div class="blank"></div>
					</div>
					<div class="textInfo">
						<form action="index/addcart.action" method="post" name="ECS_FORMBUY" id="ECS_FORMBUY">
							<h1 class="clearfix">
								${map.goods.goodsname }
							</h1>
							<ul class="ul2 clearfix">
								<li class="clearfix" style="width: 100%">
									<dd>
										<strong>本店售价：</strong><font class="shop" id="ECS_SHOPPRICE">￥${map.goods.price }元</font>
									</dd>
								</li>
								<li class="clearfix">
									<dd>
										<strong>商品货号：</strong>${map.goods.goodsid }
									</dd>
								</li>
								<li class="clearfix">
									<dd>
										<strong>商品库存：</strong> ${map.goods.num }
									</dd>
								</li>
								<li class="clearfix">
									<dd>
										<strong>商品类型：</strong><a href="index/cate.action?id=${map.goods.cateid }">${map.goods.catename }</a>
									</dd>
								</li>
								
								<li class="clearfix">
									<dd>
										<strong>电影产地：</strong>${map.goods.countries }
									</dd>
								</li>
								
								<li class="clearfix">
									<dd>
										<strong>商品销量：</strong>${map.goods.sellnum }
									</dd>
								</li>

							</ul>
							<ul class="bnt_ul">
								<li class="clearfix">
									<dd>
										<strong>购买数量：</strong>
										<input name="msg" type="text" id="number" value="1" size="4" style="border: 1px solid #ccc;" />
										<input type="hidden" name="id" value="${map.goods.goodsid }" />
									</dd>
								</li>
								<li class="padd">
									<input type="image" src="themes/xecmoban_shunfeng/images/goumai2.gif" />
								</li>
							</ul>
						</form>
					</div>
				</div>
				<div class="blank"></div>
				<div class="box">
					<div style="padding: 0 0px;">
						<div id="com_b" class="history clearfix">
							<h2>
								商品描述
							</h2>
						</div>
					</div>
					<div class="box_1">
						<div id="com_v" class="  " style="padding: 6px;"></div>
						<div id="com_h">
							<blockquote>
								${map.goods.contents }
							</blockquote>
						</div>
					</div>
				</div>
				<div class="blank"></div>

			</div>



		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>
