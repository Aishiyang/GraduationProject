<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>火影【NARUTO】</title>
<link href="${pageContext.request.contextPath}/css/wsh.css" type="text/css" rel="stylesheet" />
<%
	Map session2 = ActionContext.getContext().getSession();
%>
<script type="text/javascript">
	window.onload = function(){
		//var currUsername = session2.get("username");
		//alert(currUsername);
	}
</script>
<style type="text/css">
	.topNav ul {
		float: right;
	}
	.topNav li {
		line-height: 30px;
		float: left;
	}
	.topNav li a {
		margin: 0px 6px;
	}
		.clearfix {
		*zoom: 1;
	}
	.clearfix:after {
		height: 0px;
		display: block;
		clear: both;
		visibility: hidden;
		overflow: hidden;
		content: "\0020";
	}
</style>

</head>
<body>
<input type="hidden" id="<s:property value='#session2.username' />"/>
	<embed src="${pageContext.request.contextPath}/music/123.mp3" width="0" height="0"></embed>
<div class="top topNav clearfix">	
	<div>
		<ul style="padding-right:25px;">
			<li id="headerLogin" class="headerLogin" style="display: list-item;">
				<a href="globalChange.action?request_locale=zh_CN">中文</a>|
			</li>
			<li id="headerLogin" class="headerLogin" style="display: list-item;">
				<a href="globalChange.action?request_locale=en_US">English</a>
			</li>
			<li id="headerLogin" class="headerLogin" style="display: list-item;">
				<a href="globalChange.action?request_locale=ja_JA">日本語</a>
			</li>
		</ul>
	</div>
	<div>
		<ul style="padding-right:30px;">
			<s:if test="#session.existUser == null">
				<li id="headerLogin" class="headerLogin" style="display: list-item;">
					<a href="${pageContext.request.contextPath }/user_login.action">登录</a>|
				</li>
				<li id="headerRegister" class="headerRegister" style="display: list-item;">
					<a href="${ pageContext.request.contextPath }/txz.jsp">注册</a>
				</li>
			</s:if>
			<s:else>
				<li id="headerLogin" class="headerLogin" style="display: list-item;">
					<span style="color:red"><s:property value="#session.existUser.username"/></span>&nbsp;&nbsp;&nbsp;|
				</li>
				<li id="headerLogin" class="headerLogin" style="display: list-item;">
					<a href="${pageContext.request.contextPath }/order_findByUid.action?page=1">我的消息</a>&nbsp;&nbsp;&nbsp;|
				</li>
				<li id="headerRegister" class="headerRegister"
					style="display: list-item;"><a href="${ pageContext.request.contextPath }/user_quit.action">退出</a>
				</li>
			</s:else>
		</ul>
	</div>
</div>
<div id="wrap"><!--整体-->
	<div class="index-nav">
    	<div class="logo"><img src="${pageContext.request.contextPath}/img/logo.png" width="200"/></div>
        <div class="nav">
        	<ul>
            	<li><a href="${pageContext.request.contextPath }/index.action"><s:text name="home.home"/></a></li>
                <li><a href="${pageContext.request.contextPath }/txz.jsp"><s:text name="home.regist"/></a></li>
                <li><a href="${pageContext.request.contextPath }/hyrzdlsj.jsp"><s:text name="home.hyrzdlsj"/></a></li>
                <li><a href="${pageContext.request.contextPath }/character_characterInfoManagementCondition"><s:text name="home.zyrw"/></a></li>
                <li><a href="${pageContext.request.contextPath }/zxmh.jsp"><s:text name="home.zxmh"/></a></li>
                <li><a href="${pageContext.request.contextPath }/wdrd.jsp"><s:text name="home.wdrd"/></a></li>
            </ul>
        </div>
</div>
	<div style=" clear:both;"></div>
	<div class="banner"><img src="${pageContext.request.contextPath }/img/001.jpeg" width="100%"/></div>
    <div style=" clear:both;"></div>
    <div class="index-box">
    	<div class="index-box-up">
        	<div class="index-box-left">
            	<div class="box-nav">
                    <div class="box-nav-left"><img src="${pageContext.request.contextPath }/img/111.png" width="149"/></div>
                    <div class="box-nav-right"><a href="https://baike.baidu.com/item/%E7%81%AB%E5%BD%B1%E5%BF%8D%E8%80%85/8702?fr=aladdin#4_6">+MORE</a></div>
                </div>
                <img src="${pageContext.request.contextPath }/img/01.png" width="470"/>
                <div class="box-img">
                	<img src="${pageContext.request.contextPath }/img/naruto-10.png" width="156"/>
                	<p><s:text name="home.hyjj"/></p>
                </div>
                <img src="${pageContext.request.contextPath }/img/01.png" width="470"/>
                </div>
            <div class="index-box-right">
            <div class="box-nav">
                    <div class="box-nav-left"><img src="${pageContext.request.contextPath }/img/222.png" width="149"/></div>
                    <div class="box-nav-right"><a href="https://baike.baidu.com/item/%E5%B2%B8%E6%9C%AC%E9%BD%90%E5%8F%B2/805104?fr=aladdin">+MORE</a></div>
                </div>
                <img src="${pageContext.request.contextPath }/img/01.png" width="470"/>
                <div class="box-img">
                    <img src="${pageContext.request.contextPath }/img/naruto-09.png" width="156"/>
                	<p><s:text name="home.abqs"/></p>
                </div>
                <img src="${pageContext.request.contextPath }/img/01.png" width="470"/>
            </div>
        </div>
        <div style=" clear:both;"></div>
    	<div class="index-box-up">
        	<div class="index-box-left">
            	<div class="box-nav">
                    <div class="box-nav-left"><img src="${pageContext.request.contextPath }/img/333.png" width="149"/></div>
                    <div class="box-nav-right"><a href="news.html">+MORE</a></div>
                </div>
                <img src="${pageContext.request.contextPath }/img/01.png" width="470"/>
                <ul class="news_list_c">
                	<s:iterator var="n" value="#newsList">
	                  	<li><span><s:property value="#n.newsDate"/></span> <a href="<s:property value="#n.newsLink"/>" title="<s:property value="#n.newsDesc"/> "><s:property value="#n.newsDesc"/></a></li>
	                </s:iterator>
                </ul>
                <img src="${pageContext.request.contextPath }/img/01.png" width="470"/>
                </div>
            <div class="index-box-right">
            <div class="box-nav">
                    <div class="box-nav-left"><img src="${pageContext.request.contextPath }/img/444.png" width="149"/></div>
                    <div class="box-nav-right"><a href="news.html">+MORE</a></div>
                </div>
                <img src="${pageContext.request.contextPath }/img/01.png" width="470"/>
                <ul class="news_list_c">
                	<s:iterator var="l" value="#linksList">
                		<li><span><s:property value="#l.linksDate"/></span><a href="<s:property value="#l.linksLink"/>"><s:property value="#l.linksDesc"/></a></li>
	                </s:iterator>
                </ul>
                <img src="${pageContext.request.contextPath}/img/01.png" width=470"/>
            </div>
        </div>
    </div>
    <div style=" clear:both;"></div>
    
    <div class="pic">
        <div class="pic-pic">
            <a href="${pageContext.request.contextPath }/txz.jsp"><img src="${pageContext.request.contextPath}/img/a.jpg" width="159"/></a>
            <a href="${pageContext.request.contextPath }/zxmh.jsp"><img src="${pageContext.request.contextPath}/img/d.jpg" width="159"/></a>
            <a href="${pageContext.request.contextPath }/zyrw.jsp"><img src="${pageContext.request.contextPath}/img/c.jpg" width="159"/></a>
            <a href="${pageContext.request.contextPath }/hyrzdlsj.jsp"><img src="${pageContext.request.contextPath}/img/b.jpg" width="159"/></a>
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
