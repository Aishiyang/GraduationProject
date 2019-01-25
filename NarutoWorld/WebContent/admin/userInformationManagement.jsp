<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
          			<i class="fa fa-angle-right"></i> 首页 / 用户管理
        		</h3>
        		<div class="row">
              		<div class="row mt">
                  		<div class="col-md-12">
                      		<div class="content-panel">
                          		<table class="table table-striped table-advance table-hover">
                            		<hr>
                              		<thead>
                              			<tr>
		                                  	<th><i class="fa fa-bullhorn"></i> 用户名</th>
		                                  	<th><i class="fa fa-question-circle"></i> 性别</th>
		                                  	<th><i class="fa fa-bookmark"></i> 等级</th>
		                                  	<th><i class=" fa fa-edit"></i> 国家</th>
		                                  	<th><i class=" fa fa-edit"></i> 操作</th>
		                              	</tr>
                              		</thead>
                              		<tbody>
                              			<s:iterator value="users" id="u">
	                              			<tr>
	                                  			<td><a href="basic_table.html#"><s:property value="#u.username"/></a></td>
	                                  			<td class="hidden-phone"><s:property value="#u.sex"/></td>
	                                  			<td><span class="label label-danger label-mini"><s:property value="#u.level"/> </span></td>
	                                  			<td><span class="label label-info label-mini"><s:property value="#u.country"/> </span></td>
	                                  			<td>
			                                      	<a href="${pageContext.request.contextPath}/admin_deleteUser?userid=<s:property value='#u.userid'/>"><button name="" type="button" class="deleteThisData" class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button>
	                                  				</a>
	                                  			</td>
	                             	 		</tr>
                             	 		</s:iterator>
                              		</tbody>
                          		</table>
                      		</div><!-- /content-panel -->
                  		</div><!-- /col-md-12 -->
                  		<center><nav aria-label="...">
						  	<ul class="pagination">
						    	<li class="disabled">
						    		<a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
						    	</li>
						    	<li class="active">
						    		<a href="#">1 <span class="sr-only">(current)</span></a>
						    	</li>
						    	<li class="">
						    		<a href="#">2 <span class="sr-only">(current)</span></a>
						    	</li>
						    	<li class="">
						    		<a href="#">3<span class="sr-only">(current)</span></a>
						    	</li>
						    	<li class="">
						    		<a href="#">4 <span class="sr-only">(current)</span></a>
						    	</li>
						    	<li class="">
						    		<a href="#">... <span class="sr-only">(current)</span></a>
						    	</li>
						    	<li class="">
						    		<a href="#">7 <span class="sr-only">(current)</span></a>
						    	</li>
						    	<li class="">
						    		<a href="#">8 <span class="sr-only">(current)</span></a>
						    	</li>
						    	<li class="">
						    		<a href="#">9 <span class="sr-only">(current)</span></a>
						    	</li>
						    	<li>
							      	<a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>
							    </li>
						  	</ul>
						</nav></center>
              		</div><!-- /row -->
    			</section><!-- /wrapper -->
      		</section>
  		</section>
		<jsp:include page="common/footer.jsp" />
	</body>
</html>