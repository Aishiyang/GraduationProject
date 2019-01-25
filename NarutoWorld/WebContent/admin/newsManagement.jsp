<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>UTutor - Background Management </title>
	</head>
	<body>
		<jsp:include page="common/header.jsp" />
		<!--main content start-->
    	<section id="main-content"  class="col-md-10">
      		<section class="wrapper">
        		<h3>
          			<i class="fa fa-angle-right"></i> 首页 / 新闻管理
        		</h3>
        		<div class="row">
              		<div class="row mt">
                  		<div class="col-md-12">
                      		<div class="content-panel">
                          		<table class="table table-striped table-advance table-hover">
                            		<hr>
                              		<thead>
                              			<tr>
		                                  	<th><i class="fa fa-bullhorn"></i> 新闻编号</th>
		                                  	<th><i class="fa fa-question-circle"></i> 新闻详细</th>
		                                  	<th><i class=" fa fa-edit"></i> 新闻时间</th>
		                                  	<th><i class="fa fa-bookmark"></i> 新闻状态</th>
		                                  	<th><i class=" fa fa-edit"></i> 操作</th>
		                              	</tr>
                              		</thead>
                              		<tbody>
                              			<s:iterator value="newss" id="n" status="st">
	                              			<tr>
	                                  			<td><a href="#" data-toggle="modal" data-target="#myModal<s:property value='#st.index'/>"><s:property value="#n.newsId"/></a></td>
												<div class="modal fade" id="myModal<s:property value='#st.index'/>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">  
													    <div class="modal-dialog" role="document">  
													        <div class="modal-content">  
													            <div class="modal-header">  
													                <button type="button" class="close" data-dismiss="modal" aria-label="Close">  
													                    <span aria-hidden="true">×</span>  
													                </button>  
													                <h4 class="modal-title" id="myModalLabel">修改新闻信息</h4>  
													            </div> 
													             <form action="${pageContext.request.contextPath}/admin_updateNews" method="post"> 
														            <div class="modal-body"> 
														            		新闻编号：<input type="text" name="newsId" value="<s:property value='#n.newsId'/>"/><br><br> 
														            		新闻链接：<input type="text" name="newsLink" value="<s:property value='#n.newsLink'/>"/><br><br>
															        		新闻详细：<textarea rows="8" name="newsDesc" cols="40" value=""><s:property value='#n.newsDesc'/></textarea>
															        		<input type="hidden" name="characterinfoId" value="<s:property value='#n.newsId'/>">
														            </div>  
														            <div class="modal-footer">  
														                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>  
														                <button type="submit" class="btn btn-primary">更新</button>  
														            </div> 
													            </form> 
													        </div>  
													    </div>  
												</div>  	                                  			
	                                  			<td class="hidden-phone"><s:property value="#n.newsDesc"/></td>
	                                  			<td class="hidden-phone"><s:property value="#n.newsDate"/></td>
	                                  			<s:if test="#n.newsUpdate == 1">
													<td><span class="label label-danger label-mini">已激活 </span></td>
												</s:if>
												<s:else>
													<td><span class="label label-danger label-mini">未激活 </span></td>
												</s:else>
	                                  			<td>
	                                  				<a href="${pageContext.request.contextPath}/admin_activeNews?newsid=<s:property value='#n.newsId'/>&newsupdate=<s:property value='#n.newsUpdate'/>"><button name="" type="button" class="deleteThisData" class="btn btn-danger btn-xs"><i class="fa fa-pencil"></i></button></a>
	                                  				<a href="${pageContext.request.contextPath}/admin_deleteNews?newsid=<s:property value='#n.newsId'/>"><button name="" type="button" class="deleteThisData" class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button></a>
	                                  			</td>
	                             	 		</tr>
                             	 		</s:iterator>
                              		</tbody>
                          		</table>
                      		</div><!-- /content-panel -->
                  		</div><!-- /col-md-12 -->
                  		<!-- pagination start -->
						<center>
							<nav aria-label="Page navigation">
								<ul class="pagination">
									<li>
										<a href="#" aria-label="Previous">
											<span aria-hidden="true">&laquo;</span>
										</a>
									 </li>
									<li><a href="#">1</a></li>
									<li><a href="#">2</a></li>
									<li><a href="#">3</a></li>
									<li><a href="#">4</a></li>
									<li><a href="#">...</a></li>
									<li><a href="#">28</a></li>
									<li><a href="#">29</a></li>
									<li>
										<a href="#" aria-label="Next">
									  		<span aria-hidden="true">&raquo;</span>
									    </a>
									</li>
								</ul>
							</nav>
						</center>
						<!-- pagination end -->
              		</div><!-- /row -->
    			</section><!-- /wrapper -->
      		</section>
  		</section>
		<jsp:include page="common/footer.jsp" />
	</body>
</html>