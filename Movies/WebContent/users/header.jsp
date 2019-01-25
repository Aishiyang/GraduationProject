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
				<ul class="top_bav_l">
					<li class="top_sc">
						&nbsp;|&nbsp;
						<a href="Change.action?request_locale=en_US">English</a>
					</li>
					<li>
						&nbsp;|&nbsp;&nbsp;<a href="Change.action?request_locale=zh_CN">中文</a>
					</li>
				</ul>

				<div class="header_r">

					<script type="text/javascript" src="js/transport.js"></script>
					<script type="text/javascript" src="js/utils.js"></script>
					<font id="ECS_MEMBERZONE"> 欢迎光临新影随我来商城！<s:if test="#session.login == null">
					<a href="index/preLogin.action"><s:text name="html.login"></s:text> </a>
					|<a href="index/preRegist.action"><s:text name="html.regist"></s:text> </a>
				</s:if> <s:if test="#session.userid != null">
					<a href="index/UserCenter.action">用户信息</a>
					|<a href="index/prePwd.action">修改密码</a>
					|<a href="index/showcart.action">购物车</a>
					|<a href="index/exit.action"><s:text name="html.exit"></s:text> </a>
				</s:if> </font>
				</div>
			</div>
		</div>

		<div class="clearfix"></div>
		
		<div class="header_top logo_wrap clearfix">
		
			<tr>
			 <td height="350" colspan="3"><img id="tp" src="images/a.jpg" width="1200" height="270" onmouseover="stopchange()" onmouseout="autochange()"/>
				</td>
			</tr>
			
		</div>
	</div>
</div>
<div style="clear: both"></div>

<div class="menu_box clearfix">
	<div class="block">
		<div class="menu">
			<a href="index.jsp"><s:text name="html.home"></s:text><span></span> </a>
			<s:iterator value="map.cateList">
				<a href="index/cate.action?id=${cateid }">${catename}<span></span> </a>
			</s:iterator>
		
		</div>
	</div>
</div>