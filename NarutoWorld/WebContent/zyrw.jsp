<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主要人物</title>
<link href="${pageContext.request.contextPath }/css/zyrw.css" type="text/css" rel="stylesheet" />
<script src="${pageContext.request.contextPath }/js/zsg.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
	<div class="top"></div>
<div id="wrap"><!--整体-->
	<div class="index-nav">
    	<div class="logo"><img src="${pageContext.request.contextPath }/img/logo.png" width="200"/></div>
        <div class="nav">
        	<ul>
            	<li><a href="${pageContext.request.contextPath }/index.action">首 页</a></li>
                <li><a href="${pageContext.request.contextPath }/txz.jsp">通行证</a></li>
                <li><a href="${pageContext.request.contextPath }/hyrzdlsj.jsp">火影忍者地理世界</a></li>
                <li><a href="${pageContext.request.contextPath }/character_characterInfoManagementCondition.action">主要人物</a></li>
                <li><a href="${pageContext.request.contextPath }/zxmh.jsp">最新漫画</a></li>
                <li><a href="${pageContext.request.contextPath }/wdrd.jsp">我の忍道【初衷】</a></li>
            </ul>
        </div>
</div>
	<div style=" clear:both;"></div>
	<div class="banner"><img src="${pageContext.request.contextPath }/img/001.jpeg" width="100%"/></div>
    <div style=" clear:both;"></div>
    <div class="index-box-up">
    <p></p>
    <div class="pic-left">
    <p>功能（可操作！）</p>
    	<div class="rzzz">
                <ul>
                    <li class="on"><a href="javascript:showAddInput();">增加人物信息</a></li>
                    <li class="on"><a href="javascript:showAddInput();">查找人物信息</a></ li>
                    <li class="on"><a href='#'>删除人物信息 （表内操作）</a></li>
                    <li class="on"><a href='#'>修改人物信息 （表内操作）</a></li>                
                </ul>
            <div class="hover"></div>
        </div>
        <div style="display:none" id="addinfo">
      
<form>
 <br>
 编号：<br><input type="text" id="number" /><br></br>
 姓名:（只能是汉字）<br><input type="text" id="name"/><br></br>
 人物简介:<br><input type="text" id="text"/><br></br>
 <input type="button" value="提交" onclick="addInfo()" id="btn_add">
 <input type="button" value="提交" onclick="updateInfo()" style="display:none" id="btn_update">
 <input type="button" value="取消" onclick="hideAddInput()"><br><br/>
 请输入查找姓名：<br><input type="text" id="name" /><br></br>
 <input type="button" value="查找" >
</form>
</div>
    </div>
    <div class="pic-right">
        <div class="box-nav">
            <div class="box-nav-left"><img src="${pageContext.request.contextPath }/img/zyrw.png" width="149"/></div>
            <div class="box-nav-right"><strong>首页 > 主要人物</strong></div>
        </div>
        <img src="${pageContext.request.contextPath }/img/01.png" width="740"/>
        <p><strong>人物信息表</strong></p>
        <div class="picmain">
        <div class="table" >
 <div class="table" >
 <table border="1" style="text-align:center" id="table">
 <tr>
  <th>编号</th>
  <th>姓名</th>
  <th>个人简介</th>
  <th>操作</th>
 </tr>
 
 <s:iterator value="characterinfos" id="c" status="st">
	<tr>
	  <td><s:property value="#c.characterinfoNum"/></td>
	  <td><s:property value="#c.characterinfoName"/></td>
	  <td><s:property value='#c.characterinfoDesc'/></td> 
	  <td><a style="color:blue;cursor:pointer;" onclick="updateRow(this);" >修改<a> <a style="color:blue;cursor:pointer;" onclick="delRow(this);">删除</a></td>
	 </tr>   
	   
	   
	      
 </s:iterator>
 </table>

</div>
</div>

        
        <pr></pr>       
    </div>
    <img src="${pageContext.request.contextPath }/img/01.png" width="740"/>
    </div>
</div> 
</div>
</div>
<div style=" clear:both;"></div>
<div class="foot">
	<div class="footer">
        <div class="foot-text">
            <p>班级：09班 | 姓名：王少涵 | 学号：150450903
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                   班级：09班 | 姓名：刘晓彤 | 学号：150450934</p>
	<div id="jnkc">

	</div>
	<p>
		<script>setInterval("jnkc.innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());",1000);

		</script>
	</p>
		             
</div>
</body>
</html>