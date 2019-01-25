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
          			<i class="fa fa-angle-right"></i> 首页 / 相关链接管理
        		</h3>
        		<div class="row">
              		<div class="row mt">
                  		<div class="col-md-12">
                      		<div class="content-panel">
                          		<table class="table table-striped table-advance table-hover">
                            		<hr>
                              		<thead>
                              			<tr>
                              				<th><i class="fa fa-bullhorn"></i> 编号</th>
		                                  	<th><i class="fa fa-question-circle"></i> 链接详细</th>
		                                  	<th><i class=" fa fa-edit"></i> 链接来源</th>
		                                  	<th><i class="fa fa-bookmark"></i> 链接状态</th>
		                                  	<th><i class=" fa fa-edit"></i> 操作</th>
		                              	</tr>
                              		</thead>
                              		<tbody>
                              			<s:iterator value="linkss" id="l" status="st">
	                              			<tr>
	                                  			<td><a href="#" data-toggle="modal" data-target="#myModal<s:property value='#st.index'/>"><s:property value="#l.linksId"/></a></td>
												<div class="modal fade" id="myModal<s:property value='#st.index'/>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">  
													    <div class="modal-dialog" role="document">  
													        <div class="modal-content">  
													            <div class="modal-header">  
													                <button type="button" class="close" data-dismiss="modal" aria-label="Close">  
													                    <span aria-hidden="true">×</span>  
													                </button>  
													                <h4 class="modal-title" id="myModalLabel">修改相关链接信息</h4>  
													            </div> 
													             <form action="${pageContext.request.contextPath}/admin_updateLinks" method="post"> 
														            <div class="modal-body">  
														            		链接编号：<input type="text" name="linksId" value="<s:property value='#l.linksId'/>"/><br><br>
														            		新闻链接：<input type="text" name="linksLink" value="<s:property value='#l.linksLink'/>"/><br><br>
															        		新闻详细：<textarea rows="4" name="linksDesc" cols="40" value=""><s:property value='#l.linksDesc'/></textarea>
														            </div>  
														            <div class="modal-footer">  
														                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>  
														                <button type="submit" class="btn btn-primary">更新</button>  
														            </div> 
													            </form> 
													        </div>  
													    </div>  
												</div>  	                                  			
	                                  			<td class="hidden-phone"><s:property value="#l.linksDesc"/></td>
	                                  			<td class="hidden-phone"><s:property value="#l.linksDate"/></td>
	                                  			<s:if test="#l.linksUpdate == 1">
													<td><span class="label label-danger label-mini">已激活 </span></td>
												</s:if>
												<s:else>
													<td><span class="label label-danger label-mini">未激活 </span></td>
												</s:else>
	                                  			<td>
	                                  				<a href="${pageContext.request.contextPath}/admin_activeLinks?linksid=<s:property value='#l.linksId'/>&linksUpdate=<s:property value='#l.linksUpdate'/>"><button name="" type="button" class="deleteThisData" class="btn btn-danger btn-xs"><i class="fa fa-pencil"></i></button></a>
	                                  				<a href="${pageContext.request.contextPath}/admin_deleteLinks?linksid=<s:property value='#l.linksId'/>"><button name="" type="button" class="deleteThisData" class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button></a>
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