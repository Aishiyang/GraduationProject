<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
          			<i class="fa fa-angle-right"></i> 首页 / 系统公告管理
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
		                                  	<th><i class="fa fa-question-circle"></i> 组</th>
		                                  	<th><i class="fa fa-bookmark"></i> 角色</th>
		                                  	<th><i class=" fa fa-edit"></i> 权限</th>
		                                  	<th><i class=" fa fa-edit"></i> 角色状态</th>
		                                  	<th><i class=" fa fa-edit"></i> 操作</th>
		                              	</tr>
                              		</thead>
                              		<tbody>
                              			<tr>
                                  			<td><a href="basic_table.html#">Company Ltd</a></td>
                                  			<td class="hidden-phone">学员</td>
                                  			<td>学员 </td>
                                  			<td><span class="label label-danger label-mini">普通权限</span></td>
                                  			<td><span class="label label-info label-mini">已激活</span></td>
                                  			<td>
		                                      	<button class="btn btn-success btn-xs"><i class="fa fa-check"></i></button>
		                                      	<button class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button>
		                                      	<button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button>
                                  			</td>
                             	 		</tr>
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