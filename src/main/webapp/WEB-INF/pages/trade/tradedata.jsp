<jsp:include page="../include/nav.jsp"></jsp:include>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<script type="text/javascript">
 $().ready(function(){
	 tradedata();
 });
 
 function tradedata(){
	 
	 var time = new Date().getTime();
	 
	 $.ajax({
		 type:"POST",
		 url:"/trade/tradedata",
		 data:{
			 "time":time
		 },
		 dataType:"html",
		 success:function(msg){
			 $("#main").html(msg);
		 }
	 });
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
							<i class="icon-bar-chart"></i>牛人交易数据
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