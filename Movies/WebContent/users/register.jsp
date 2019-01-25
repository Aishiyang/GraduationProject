<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%=basePath%>" />
		<title>新影随我来商城</title>
		<link href="themes/xecmoban_shunfeng/style.css" rel="stylesheet" type="text/css" />
		<script language="javascript" type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js" charset="utf-8"></script>
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
				用户注册
			</div>
		</div>
		<div class="blank"></div>
		<div class="block">
			<div class="box">
				<div class="box_1">
					<h3>
						<span>用户注册</span>
					</h3>
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr valign="top">
							<td bgcolor="#FFFFFF" align="center">
								<form action="index/regist.action" method="post" name="myform">
									<table width="60%" border="0" cellpadding="5" cellspacing="1" bgcolor="#dddddd">
										<tr>
											<td width="28%" align="right" bgcolor="#FFFFFF">
												用户名：
											</td>
											<td width="76%" align="left" bgcolor="#FFFFFF">
												<input type="text" name="users.username" size="25" class="inputBg" id="username" />
											</td>
										</tr>
										<tr>
											<td width="28%" align="right" bgcolor="#FFFFFF">
												密码：
											</td>
											<td width="76%" align="left" bgcolor="#FFFFFF">
												<input name="users.password" type="password" size="25" class="inputBg" id="password" />
											</td>
										</tr>
										<tr>
											<td width="28%" align="right" bgcolor="#FFFFFF">
												姓名：
											</td>
											<td width="76%" align="left" bgcolor="#FFFFFF">
												<input name="users.realname" type="text" size="25" class="inputBg" id="realname" />
											</td>
										</tr>
										<tr>
											<td width="28%" align="right" bgcolor="#FFFFFF">
												性别：
											</td>
											<td width="76%" align="left" bgcolor="#FFFFFF">
												<select name="users.sex" id="sex" style="width: 160px" >
													<option value="女">女</option>
													<option value="男">男</option>
												</select>
											</td>
										</tr>
										<tr>
											<td width="28%" align="right" bgcolor="#FFFFFF">
												出生日期：
											</td>
											<td width="76%" align="left" bgcolor="#FFFFFF">
												<input name="users.birthday" type="text" size="25" class="inputBg" id="birthday" onclick="WdatePicker()" />
											</td>
										</tr>
										<tr>
											<td width="28%" align="right" bgcolor="#FFFFFF">
												联系方式：
											</td>
											<td width="76%" align="left" bgcolor="#FFFFFF">
												<input name="users.contact" type="text" size="25" class="inputBg" id="contact" />
											</td>
										</tr>
										<tr>
											<td width="28%" align="right" bgcolor="#FFFFFF">
												电子邮件：
											</td>
											<td width="76%" align="left" bgcolor="#FFFFFF">
												<input name="users.email" type="text" size="25" class="inputBg" id="email" />
											</td>
										</tr>
										<tr>
											<td width="28%" align="right" bgcolor="#FFFFFF">
												联系地址：
											</td>
											<td width="76%" align="left" bgcolor="#FFFFFF">
												<input name="users.address" type="text" size="25" class="inputBg" id="address" />
											</td>
										</tr>
										<tr>
											<td colspan="2" align="center" bgcolor="#FFFFFF">
												${msg }
											</td>
										</tr>
										<tr>
											<td colspan="2" align="center" bgcolor="#FFFFFF">
												<input type="submit" class="bnt_blue_1" style="border: none;" value="确认注册" />
											</td>
										</tr>
									</table>
								</form>
							</td>
						</tr>
					</table>
				</div>
			</div>
			<div class="blank5"></div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>
