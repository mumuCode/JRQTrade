<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<table class="table table-bordered table-striped" id="dataTable1">
<thead>
	<!-- <th class="check-header hidden-xs"><label><input
			id="checkAll" name="checkAll" type="checkbox"><span></span></label>
	</th> -->
	<th>牛人名称</th>
	<th>牛人编号</th>
	<th>牛人状态</th>
	<th>操作</th>
</thead>
<tbody>
<c:forEach items="${traderList}" var="trader">
	<tr>
		<!-- <td class="check hidden-xs"><label><input
					name="optionsRadios1" type="checkbox" value="option1"><span></span></label>
		</td> -->
		<td>${trader.traderName}</td>
		<td>${trader.traderId}</td>
		<td>
		<c:if test="${trader.traderStatus=='1'}">
		  <span class="label label-success">有效</span>
		</c:if>
		<c:if test="${trader.traderStatus=='0'}">
		  <span class="label label-default">无效</span>
		</c:if>
		</td>
		<td class="actions">
			<div class="action-buttons">
				<a class="table-actions" href="#"><i
					class="icon-eye-open"></i></a><a class="table-actions" href="#"><i
					class="icon-pencil"></i></a><a class="table-actions" href="#"><i
					class="icon-trash"></i></a>
			</div>
		</td>
		</tr>
</c:forEach>
</tbody>
</table>