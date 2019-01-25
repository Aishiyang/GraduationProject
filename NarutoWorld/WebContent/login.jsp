<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<script src="${pageContext.request.contextPath}/js/tx01.js"></script>
<link href="${pageContext.request.contextPath}/css/txz.css" type="text/css" rel="stylesheet" />
<script type="text/javascript">
//	window.onload = function(){
//		alert("注册成功，请去登录！！！");
//	}
</script>
<script type="text/javascript">
	function checkForm() {
		//校验用户名
		var username = document.getElementById("usernameID").value;
		if (username == null || username == '') {
			alert("用户名不能为空!");
			return false;
		}

		// 校验密码
		var password = document.getElementById("passwordID").value;
		if (password == null || password == '') {
			alert("密码不能为空!");
			return false;
		}

	}
</script>
</head>
<body>
	<embed src="${pageContext.request.contextPath}/music/高梨康治 - 動天.mp3" width="0" height="0"></embed>
	<br></br>
	<br></br>
	<br></br>
	<br></br>
	<br></br>
	<fieldset>
		<legend align="left">火影世界登录</legend>
		<form action="${ pageContext.request.contextPath }/user_login.action" method="post" onsubmit="return checkForm();">
			<div class="formField">
				<label for="君の名は">君の名は:</label>
				<input type="text" name="username" class="formText" id="usernameID" placeholder="请填写用户名" onfocus="clearText()" /> 
				<font color="#EA7500">*</font>
				<font style="color:red"><s:property value="fieldErrors['user.login'][0]" /></font>
			</div>

			<div class="formField">
				<label for="通行证の番号">通行证の番号:</label> 
				<input type="password" name="password" class="formText" id="passwordID" onfocus="clearText()" onblur="testText()" /> 
				<font color="#EA7500">*</font>
			</div>

			<div class="button">
				<input onclick="testText()" type="submit" value="   登录    " class="anniu" />
			</div>
			<div class="button">
				<input type="reset" value="    重置    " class="anniu" />
			</div>
		</form>
	</fieldset>
</body>
</html>