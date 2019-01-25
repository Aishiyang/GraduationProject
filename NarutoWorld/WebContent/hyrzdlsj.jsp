<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>火影忍者地理世界</title>
<link href="${pageContext.request.contextPath }/css/dlsj.css" type="text/css" rel="stylesheet" />
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
                <li><a href="${pageContext.request.contextPath }/character_characterInfoManagementCondition">主要人物</a></li>
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
    <p>相关资料</p>
    	<div class="rzzz">
                <ul>
                    <li class="on"><a href='${pageContext.request.contextPath }/guojiafenbutu1.jsp'>国家分布图一</a></li>
                    <li class="on"><a href='${pageContext.request.contextPath }/guojiafenbutu2.jsp'>国家分布图二</a></li>
                    <li class="on"><a href='${pageContext.request.contextPath }/guojiafenbutu3.jsp'>国家分布图三</a></li>
                    <li class="on"><a href='${pageContext.request.contextPath }/gerenzhecunbiaozhi.jsp'>各大忍村标志</a></ li>
                </ul>
            <div class="hover"></div>
        </div>
    </div>
    <div class="pic-right">
        <div class="box-nav">
            <div class="box-nav-left"><img src="${pageContext.request.contextPath }/img/dlsj.png" width="149"/></div>
            <div class="box-nav-right"><strong>首页 > 火影地理世界</strong></div>
        </div>
        <img src="${pageContext.request.contextPath }/img/01.png" width="740"/>
        <p><strong>忍者五大国与忍者村</strong></p>
        <div class="picmain">
                <div class="picmain_up">
                    <div class="picmain_pic"><a href="${pageContext.request.contextPath }/huozhiguo.jsp"><img src="${pageContext.request.contextPath }/img/hzg.jpg" width="90%"/><p>火之国</p></a></div>
                    <div class="picmain_pic"><a href="${pageContext.request.contextPath }/fengzhiguo.jsp"><img src="${pageContext.request.contextPath }/img/fzg.jpg" width="90%"/><p>风之国</p></a></div>
                    <div class="picmain_pic"><a href="${pageContext.request.contextPath }/shuizhiguo.jsp"><img src="${pageContext.request.contextPath }/img/szg.jpg" width="90%"/><p>水之国</p></a></div>         
                </div>
                <div class="picmain_down">
                    <div class="picmain_pic"><a href="${pageContext.request.contextPath }/leizhiguo.jsp"><img src="${pageContext.request.contextPath }/img/lzg.jpg" width="90%"/><p>雷之国</p></a></div>
                    <div class="picmain_pic"><a href="${pageContext.request.contextPath }/tuzhiguo.jsp"><img src="${pageContext.request.contextPath }/img/tzg.jpg" width="90%"/><p>土之国</p></a></div>
                    <div class="picmain_pic"><a href="${pageContext.request.contextPath }/renzhecun.jsp"><img src="${pageContext.request.contextPath }/img/rzc.jpg" width="90%"/><p>忍者村</p></a></div>          
                </div>
            </div>
        <img src="${pageContext.request.contextPath }/img/01.png" width="740"/>
       
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