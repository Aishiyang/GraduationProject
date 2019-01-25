<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
          			<i class="fa fa-angle-right"></i> 首页 / 角色信息管理
        		</h3>
        		<div class="row">
              		<div class="row mt">
                  		<div class="col-md-12">
                      		<div class="content-panel">
                          		<table class="table table-striped table-advance table-hover">
                            		<hr>
                              		<thead>
                              			<tr>
		                                  	<th><i class="fa fa-bullhorn"></i> 角色编号</th>
		                                  	<th><i class="fa fa-question-circle"></i> 角色名字</th>
		                                  	<th><i class=" fa fa-edit"></i> 角色状态</th>
		                                  	<th><i class=" fa fa-edit"></i> 操作</th>
		                              	</tr>
                              		</thead>
                              		<tbody>
                             	 		<s:iterator value="characterinfos" id="c" status="st">
	                              			<tr>
	                                  			<td><a href="#" data-toggle="modal" data-target="#myModal<s:property value='#st.index'/>"><s:property value="#c.characterinfoNum"/></a></td>
												<div class="modal fade" id="myModal<s:property value='#st.index'/>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">  
												    
													    <div class="modal-dialog" role="document">  
													        <div class="modal-content">  
													            <div class="modal-header">  
													                <button type="button" class="close" data-dismiss="modal" aria-label="Close">  
													                    <span aria-hidden="true">×</span>  
													                </button>  
													                <h4 class="modal-title" id="myModalLabel">修改角色信息</h4>  
													            </div> 
													             <form action="${pageContext.request.contextPath}/admin_updateCharacterInfo" method="post"> 
														            <div class="modal-body">  
															        		角色编号：<input type="text" name="characterinfoNum" value="<s:property value='#c.characterinfoNum'/>"/><br><br>
															        		角色姓名：<input type="text" name="characterinfoName" value="<s:property value='#c.characterinfoName'/>"/><br><br>
															        		角色简介：<textarea rows="8" name="characterinfoDesc" cols="40" value=""><s:property value='#c.characterinfoDesc'/></textarea>
															        		<input type="hidden" name="characterinfoId" value="<s:property value='#c.characterinfoId'/>">
														            </div>  
														            <div class="modal-footer">  
														                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>  
														                <button type="submit" class="btn btn-primary">更新</button>  
														            </div> 
													            </form> 
													        </div>  
													    </div>  
												</div>  	                                  			
	                                  			<td class="hidden-phone"><s:property value="#c.characterinfoName"/></td>
	                                  			<s:if test="#c.characterinfoActivated == 1">
													<td><span class="label label-danger label-mini">已激活 </span></td>
												</s:if>
												<s:else>
													<td><span class="label label-danger label-mini">未激活 </span></td>
												</s:else>
	                                  			<td>
	                                  				<a href="${pageContext.request.contextPath}/admin_activeCharacterInfo?characterinfoid=<s:property value='#c.characterinfoId'/>&characterinfoActivated=<s:property value='#c.characterinfoActivated'/>"><button name="" type="button" class="deleteThisData" class="btn btn-danger btn-xs"><i class="fa fa-pencil"></i></button></a>
	                                  				<a href="${pageContext.request.contextPath}/admin_deleteCharacterInfo?characterinfoid=<s:property value='#c.characterinfoId'/>"><button name="" type="button" class="deleteThisData" class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button></a>
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
	<script>
		$(function(){
			var url = window.location.href;
			var arr = url.split("/");
			$(".yeshu").html(arr[6]);
		})
		$(function(){
			$(".deleteThisData").click(function(){
				var url = $(this).attr("name");
				$.ajax({
					url:url,
					type:"POST",
					dataType:"json",
					async:false,
					success:function(result){
						if(result == "1"){
							alert("删除用户成功！");
							location = location;
						}else {
							alert("删除用户失败！");
						}
					}
				});
			})
		})
	</script> 
</html>