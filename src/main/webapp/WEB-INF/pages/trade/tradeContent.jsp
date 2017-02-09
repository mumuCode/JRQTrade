<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<table class="table table-bordered table-striped" id="dataTable1">
<thead>
	<!-- <th class="check-header hidden-xs"><label><input
			id="checkAll" name="checkAll" type="checkbox"><span></span></label>
	</th> -->
	<th>操盘手</th>
	<th>币种</th>
	<th>操作</th>
	<th>开仓价</th>
	<th class="hidden-xs">状态</th>
	<th class="hidden-xs">平仓价</th>
	<th class="hidden-xs">止盈价</th>
	<th class="hidden-xs">止损价</th>
	<th class="hidden-xs">收益</th>
	<th class="hidden-xs">操作时间</th>
	<!-- <th></th> -->
</thead>
<tbody>
<c:forEach items="${tradeList}" var="trade">
	<tr>
		<!-- <td class="check hidden-xs"><label><input
					name="optionsRadios1" type="checkbox" value="option1"><span></span></label>
		</td> -->
		<td>${trade.traderName}</td>
		<td>${trade.symbol}</td>
		<td>
		<c:if test="${trade.orderStatus2=='买入'}">
		  <span class="label label-danger">${trade.orderStatus2}</span>
		</c:if>
		<c:if test="${trade.orderStatus2=='卖出'}">
		  <span class="label label-success">${trade.orderStatus2}</span>
		</c:if>
		<c:if test="${trade.orderStatus2=='挂单买入'}">
		  <span class="label label-warning">${trade.orderStatus2}</span>
		</c:if>
		<c:if test="${trade.orderStatus2=='挂单卖出'}">
		  <span class="label label-primary">${trade.orderStatus2}</span>
		</c:if>
		</td>
		<td>${trade.openPrice}</td>
		<td><span class="label label-default">${trade.orderStatus}</span></td>
		<td>${trade.closePrice}</td>
		<td>${trade.tp}</td>
		<td>${trade.sl}</td>
		<td>${trade.profit}</td>
		<td>${trade.openTime}</td>
		<!-- <td class="actions">
			<div class="action-buttons">
				<a class="table-actions" href="#"><i
					class="icon-eye-open"></i></a><a class="table-actions" href="#"><i
					class="icon-pencil"></i></a><a class="table-actions" href="#"><i
					class="icon-trash"></i></a>
			</div>
		</td> -->
		</tr>
</c:forEach>
</tbody>
</table>