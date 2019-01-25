<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>通行证</title>
<script src="${pageContext.request.contextPath}/js/tx01.js"></script>
<link href="${pageContext.request.contextPath}/css/txz.css" type="text/css" rel="stylesheet" />
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
		<!--fieldset:对表单进行分组，把他们放到一个框框里-->
		<legend align="left">火影世界通行证</legend>
		<!--legend元素为fieldset元素定义标题-->
		<form action="${ pageContext.request.contextPath }/user_regist.action" method="post" onsubmit="return checkForm();">
			<!--form用来创建HTML表单-->
			<div class="formField">
				<label for="君の名は">君の名は:</label>
				<!--label标签为input定义一个像标头一样的东西-->
				<input type="text" name="username" class="formText" id="usernameID" placeholder="请填写用户名" onfocus="clearText()" /> 
				<font color="#EA7500">*</font>
				<font style="color:red"><s:property value="fieldErrors['user.username'][0]" /></font>
			</div>

			<div class="formField">
				<label for="通行证の番号">通行证の番号:</label> 
				<input type="password" name="password" class="formText" id="passwordID" onfocus="clearText()" onblur="testText()" /> 
				<font color="#EA7500">*</font>
			</div>
			<div class="formField">
				<label for="性别">性别:</label>
				<input type="radio" name="sex" id="MID" value="男" />男
				<input type="radio" name="sex" id="FID" value="女" />女 
				<font color="#EA7500"> *</font>
			</div>
			<div class="formField">
				<label for="等级">等级：</label> 
				<select id="level" runat="server" onchange="selectprovince(this);" name="level" class="formText">
					<option name="level1" value="dengji"></option>
					<option name="level1" value="见习下忍">见习下忍</option>
					<option name="level1" value="下忍">下忍</option>
					<option name="level1" value="中忍">中忍</option>
					<option name="level1" value="上忍">上忍</option>
					<option name="level1" value="影">影</option>
				</select>
			</div>
			<div class="formField">
				<label for="国家">国家：</label> 
				<select id="country" runat="server" name="country" class="formText">
					<option name="country1" value="guojia">---country---</option>
					<option name="country1" value="火之国">火之国</option>
					<option name="country1" value="风之国">风之国</option>
					<option name="country1" value="水之国">水之国</option>
					<option name="country1" value="雷之国">雷之国</option>
					<option name="country1" value="土之国">土之国</option>
					<option name="country1" value="其他">其他</option>
				</select>
			</div>
			<input type="checkbox" name="R1" />———是否同意火影忍者大世界的各项规定 <br></br>

			<div class="button">
				<input onclick="testText()" type="submit" value="   注册    " class="anniu" />
			</div>
			<div class="button">
				<input type="reset" value="    重置    " class="anniu" />
			</div>
		</form>
	</fieldset>
</body>
</html>