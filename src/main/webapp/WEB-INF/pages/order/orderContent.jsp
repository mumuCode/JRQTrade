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
	<th>开仓状态</th>
	<th>开仓价</th>
	<th>开仓时间</th>
	<th class="hidden-xs">平仓状态</th>
	<th class="hidden-xs">平仓价</th>
	<th class="hidden-xs">平仓时间</th>
	<th class="hidden-xs">止盈价</th>
	<th class="hidden-xs">止损价</th>
	<th class="hidden-xs">收益</th>
	<th class="hidden-xs">手数</th>	
	<!-- <th class="hidden-xs"></th> -->
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
		<c:if test="${trade.openStatus=='0' || trade.openStatus=='2'}">
		  <span class="label label-primary">${trade.openDescribe}</span>
		</c:if>
		<c:if test="${trade.openStatus=='1' || trade.openStatus=='3'}">
		  <span class="label label-danger">${trade.openDescribe}</span>
		</c:if>
		</td>
		<td>${trade.openPrice}</td>
		<td>${trade.openTime}</td>
		<td>
		<c:choose>
		  <c:when test="${trade.closeStatus == '0'}">
		     <span class="label label-success">持有中</span>
		  </c:when>
		  <c:otherwise>
		     <span class="label label-default">${trade.closeDescribe}</span>
		  </c:otherwise>
		</c:choose>
		</td>
		<td>
		<c:choose>
		  <c:when test="${trade.closeStatus == '0'}">
		     
		  </c:when>
		  <c:otherwise>
		     ${trade.closePrice}
		  </c:otherwise>
		</c:choose>
		</td>
		<td>
		<c:choose>
		  <c:when test="${trade.closeTime=='1970-01-01 08:00:00'}">
		     
		  </c:when>
		  <c:otherwise>
		     ${trade.closeTime}
		  </c:otherwise>
		</c:choose>
		</td>
		<td>${trade.tp}</td>
		<td>${trade.sl}</td>
		<td>${trade.profit}</td>
		<td>${trade.volume}</td>
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