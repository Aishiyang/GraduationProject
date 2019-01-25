<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<script type="text/javascript" src="js/js_go.js">
</script>
<div id="Top">
	<div class=" block header_bg">
		<div class="top_nav">
			<div class="block">
				
				<div class="header_r">
				
					<font id="ECS_MEMBERZONE"> 欢迎进入新影随我来商城后台 </font>
					&nbsp;<div class="header_r">

					
				
					
				</div>
						<tr>
			 <td height="350" colspan="3"><img id="tp" src="images/a.jpg" width="1200" height="270" onmouseover="stopchange()" onmouseout="autochange()"/>
				</td>
			</tr>
				</div>
			</div>
		</div>

		
	</div>
</div>
<div style="clear: both"></div>

<div class="menu_box clearfix">
	<div class="block">
		<div class="menu">
			<s:if test="#session.adminid != null">
				<a href="users/getAllUsers.action">用户信息<span></span> </a>
				<a href="cate/createCate.action">新增类型<span></span> </a>
				<a href="cate/getAllCate.action">类型管理<span></span> </a>
				<a href="goods/createGoods.action">新增电影<span></span> </a>
				<a href="goods/getAllGoods.action">电影管理 <span></span></a>
				<a href="orders/getAllOrders.action">订单管理<span></span> </a>
				<a href="index/exit.action">注销退出<span></span></a>
			</s:if>
		</div>
	</div>
</div>
