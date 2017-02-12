<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../include/nav.jsp"></jsp:include>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<script type="text/javascript">
 $().ready(function(){
	 traderdata();
 });
 
 function traderdata(){
	 
	 var time = new Date().getTime();
	 var traderStatus = $("#traderStatus").val();
	 
	 $.ajax({
		 type:"POST",
		 url:"/traderManager/traderdata",
		 data:{
			 "time":time,
			 "traderStatus":traderStatus
			 },
		 dataType:"html",
		 success:function(msg){
			 $("#main").html(msg);
			 /*分页*/
			 dataTablesOpreation();
		 }
	 });
 }
 
 //根据牛人状态查询
 function onChangeStatus(val) {   	
    $("#traderStatus").val(val);
    //traderdata();	
 }

</script>
<body>
	<div class="modal-shiftfix">
	    <!-- 引入菜单页 -->
		<jsp:include page="../include/menu.jsp"></jsp:include>
		<div class="container-fluid main-content">
			<div class="page-title">
				<h1></h1>
			</div>
			<!-- DataTables Example -->
			<div class="row">
				<div class="col-lg-12">
					<div class="widget-container fluid-height clearfix">
						<div class="heading">
							<i class="icon-user" ></i>牛人管理
						</div>
						<input id="rs" type="hidden" /><!-- 当前列表页数 -->
						<div class="row">
							<div class="col-lg-12">
								<div class="widget-container fluid-height clearfix">
									<div class="heading">
										<i class="icon-collapse"></i>查询条件
									</div>
									<div class="widget-content padded">
										<div class="form-horizontal">
											<div class="form-group">
												<label class="control-label col-md-1">牛人状态</label>
												<div class="col-md-2">
													<select class="form-control" id="traderStatus" onchange="onChangeStatus(this.value)">
													    <option value="">所有状态</option>
													    <option value="1">有效</option>
													    <option value="0">无效</option>
													</select>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="widget-content padded clearfix" id="main">
							
						</div>
					</div>
				</div>
			</div>
			<!-- end DataTables Example -->
		</div>
	</div>
	<script type="text/javascript"
		src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
</body>
</html>