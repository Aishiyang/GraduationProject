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
		<title>新影随我来商城</title><meta name="viewport" content="width=device-width, initial-scale=1" />
		<link href="themes/xecmoban_shunfeng/style.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
		<jsp:include page="header.jsp"></jsp:include>
		<div class="block box">
			<div class="blank"></div>
			<div id="ur_here">
				当前位置:
				<a href="<%=basePath%>">首页</a>
				<code>
					&gt;
				</code>
				购物流程
			</div>
		</div>
		<div class="blank"></div>
		<div class="block table">
			<form action="index/checkOut.action" method="post" name="theForm" id="theForm" onsubmit="return checkConsignee(this)">
				<div class="flowBox">
					<h6>
						<span>收货人信息</span>
					</h6>
					<table width="99%" align="center" border="0" cellpadding="5" cellspacing="1" bgcolor="#dddddd">
						<tr>
							<td bgcolor="#ffffff">
								收货人姓名:
							</td>
							<td bgcolor="#ffffff" colspan="2">
								<input name="name" type="text" class="inputBg" id="name" value="<s:property value="#session.user.realname"/>" />
								(必填)
							</td>
						</tr>

						<tr>
							<td bgcolor="#ffffff">
								详细地址:
							</td>
							<td bgcolor="#ffffff" colspan="2">
								<input name="cond" type="text" class="inputBg" id="cond" value="<s:property value="#session.user.address"/>" />
								(必填)
							</td>
						</tr>

						<tr>
							<td bgcolor="#ffffff">
								联系方式:
							</td>
							<td bgcolor="#ffffff" colspan="2">
								<input name="msg" type="text" class="inputBg" id="cond" value="<s:property value="#session.user.address"/>" />
								(必填)
							</td>
						</tr>
						<tr>
							<td colspan="4" align="center" bgcolor="#ffffff">
								<input type="submit" class="bnt_blue_2" value="确定" />
							</td>
						</tr>
					</table>
				</div>
			</form>
		</div>


		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>
