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
		<title>新影随我来网站</title>
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
				添加商品
			</div>
		</div>
		<div class="blank"></div>
		<div class="block">
			<div class="box">
				<div class="box_1">
					<h3>
						<span>添加商品</span>
					</h3>
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr valign="top">
							<td bgcolor="#FFFFFF" align="center">
								<s:form action="goods/addGoods.action" name="myform" enctype="multipart/form-data">
									<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#dddddd">
										<tr>
											<td width="28%" align="right" bgcolor="#FFFFFF">
												商品名称：
											</td>
											<td width="76%" align="left" bgcolor="#FFFFFF">
												<input type="text" name="goods.goodsname" style="width: 160px" id="goodsname" />
											</td>
										</tr>
										<tr>
											<td width="28%" align="right" bgcolor="#FFFFFF">
												图片：
											</td>
											<td width="76%" align="left" bgcolor="#FFFFFF">
												<input type="file" name="image" id="image" />
											</td>
										</tr>
										<tr>
											<td width="28%" align="right" bgcolor="#FFFFFF">
												商品类型：
											</td>
											<td width="76%" align="left" bgcolor="#FFFFFF">
												<select name="goods.cateid" style="width: 160px" id="cateid">
													<s:iterator value="map.cateList">
														<option value="${cateid }">
															${catename }
														</option>
													</s:iterator>
												</select>
											</td>
										</tr>
									
										<tr>
											<td width="28%" align="right" bgcolor="#FFFFFF">
												电影产地：
											</td>
											<td width="76%" align="left" bgcolor="#FFFFFF">
												<input type="text" name="goods.countries" style="width: 160px" id="countries" />
											</td>
										</tr>
										
										<tr>
											<td width="28%" align="right" bgcolor="#FFFFFF">
												商品价格：
											</td>
											<td width="76%" align="left" bgcolor="#FFFFFF">
												<input type="text" name="goods.price" style="width: 160px" id="price" />
											</td>
										</tr>
										<tr>
											<td width="28%" align="right" bgcolor="#FFFFFF">
												是否推荐：
											</td>
											<td width="76%" align="left" bgcolor="#FFFFFF">
												<select name="goods.recommend" id="recommend" style="width: 160px">
													<option value="否">
														否
													</option>
													<option value="是">
														是
													</option>
												</select>
											</td>
										</tr>
										<tr>
											<td width="28%" align="right" bgcolor="#FFFFFF">
												是否特价：
											</td>
											<td width="76%" align="left" bgcolor="#FFFFFF">
												<select name="goods.special" id="special" style="width: 160px">
													<option value="否">
														否
													</option>
													<option value="是">
														是
													</option>
												</select>
											</td>
										</tr>
										<tr>
											<td width="28%" align="right" bgcolor="#FFFFFF">
												库存：
											</td>
											<td width="76%" align="left" bgcolor="#FFFFFF">
												<input type="text" name="goods.num" style="width: 160px" id="num" />
											</td>
										</tr>
										<tr>
											<td width="28%" align="right" bgcolor="#FFFFFF">
												商品介绍：
											</td>
											<td width="76%" align="left" bgcolor="#FFFFFF">
												<textarea cols="80" name="goods.contents" id="contents" rows="10">在此添加内容 </textarea>
											</td>
										</tr>
										<tr>
											<td colspan="2" align="center" bgcolor="#FFFFFF">
												<input type="submit" class="bnt_blue_1" style="border: none;" value="确定" />
											</td>
										</tr>
									</table>
								</s:form>
							</td>
						</tr>
					</table>
				</div>
			</div>
			<div class="blank5"></div>
		</div>
	</body>
</html>
