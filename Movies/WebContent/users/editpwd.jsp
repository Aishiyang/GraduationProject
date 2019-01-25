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
				当前位置:
				<a href="<%=basePath%>">首页</a>
				<code>
					&gt;
				</code>
				修改密码
			</div>
		</div>
		<div class="blank"></div>

		<div class="blank"></div>
		<div class="block clearfix">

			<div class="box">
				<div class="box_1">
					<div class="userCenterBox boxCenterList clearfix" style="_height: 1%;">
						<h5>
							<span>修改密码</span>
						</h5>
						<div class="blank"></div>
						<form action="index/editPwd.action" name="myform">
							<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#dddddd">
								<tr>
									<td width="28%" align="right" bgcolor="#FFFFFF">
										用户名：
									</td>
									<td width="76%" align="left" bgcolor="#FFFFFF">
										${sessionScope.users.username }
										<input type="hidden" name="users.username" style="width: 160px" id="username"
											value="${sessionScope.users.username }" />
										<input type="hidden" name="users.usersid" style="width: 160px" id="usersid"
											value="${sessionScope.users.usersid }" />
									</td>
								</tr>
								<tr>
									<td width="28%" align="right" bgcolor="#FFFFFF">
										原密码：
									</td>
									<td width="76%" align="left" bgcolor="#FFFFFF">
										<input name="users.password" type="password" size="25" class="inputBg" />
									</td>
								</tr>
								<tr>
									<td width="28%" align="right" bgcolor="#FFFFFF">
										新密码：
									</td>
									<td align="left" bgcolor="#FFFFFF">
										<input name="newpassword" type="password" size="25" class="inputBg" />
									</td>
								</tr>
								<tr>
									<td width="28%" align="right" bgcolor="#FFFFFF">
										确认密码：
									</td>
									<td align="left" bgcolor="#FFFFFF">
										<input name="repassword" type="password" size="25" class="inputBg" />
									</td>
								</tr>
								<tr>
									<td colspan="2" align="center" bgcolor="#FFFFFF">
										${msg }
									</td>
								</tr>
								<tr>
									<td colspan="2" align="center" bgcolor="#FFFFFF">
										<input type="submit" class="bnt_blue_1" style="border: none;" value="确认修改" />
									</td>
								</tr>
							</table>
						</form>

					</div>
				</div>
			</div>
		</div>

		<div class="blank"></div>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>
