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
				当前位置:
				<a href="<%=basePath%>">首页</a>
				<code>
					&gt;
				</code>
				新增电影类别
			</div>
		</div>
		<div class="blank"></div>
		<div class="block">
			<div class="box">
				<div class="box_1">
					<h3>
						<span>新增电影类别</span>
					</h3>
					<s:form action="cate/addCate.action" name="myform" onsubmit="return check()">
						<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#dddddd">
							<tr>
								<td width="28%" align="right" bgcolor="#FFFFFF">
									类别名称：
								</td>
								<td width="76%" align="left" bgcolor="#FFFFFF">
									<input type="text" name="cate.catename" style="width: 160px" id="catename" />
								</td>
							</tr>
							<tr>
								<td colspan="2" align="center" bgcolor="#FFFFFF">
									<input type="submit" class="bnt_blue_1" style="border: none;" value="确定" />
								</td>
							</tr>
						</table>
					</s:form>
				</div>
			</div>
			<div class="blank5"></div>
		</div>
	</body>
</html>
