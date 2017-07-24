<%@ page contentType="text/html; charset=utf-8" language="java"
         import="java.sql.*,java.util.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script language="javascript">  
    function page(href) { 
        $.ajax({
            type: "GET",
            url: encodeURI(encodeURI(href)),
            dataType: 'html',
            success: function (msg) {
                $('#main').html(msg);
            }
        });
    } 
</script>

<div class="row">
    <div class="col-sm-4 text-right text-center-xs" style="float: right">
        <ul class="pagination pagination-sm m-t-none m-b-none">
            <li>
                <c:if test="${page.pagenow+1 == 1}">
                  <a class="adefault"><i class="fa fa-chevron-left"></i></a>
                </c:if>
                <c:if test="${page.pagenow+1 > 1}">
                  <a href="javascript:page('${page.prevpage.href}')">
                    <i class="fa fa-chevron-left"></i>
                  </a>
                </c:if>               
            </li>
            <li>
                <a>${page.pagenow+1}/${page.pageall}</a>
            </li>
            <li>
                <c:if test="${page.pagenow+1 == page.pageall}">
                  <a class="adefault"><i class="fa fa-chevron-right"></i></a>
                </c:if>
                <c:if test="${page.pagenow+1 < page.pageall}">
                  <a href="javascript:page('${page.nextpage.href}')">
                  <i class="fa fa-chevron-right"></i>
                  </a>
                </c:if>
            </li>
        </ul>
    </div>
    <span>共${page.rsall}条</span>
</div>
<div id="dataTable1_info" class="dataTables_info">显示 1 到 1 共 1 条数据</div>
<div class="dataTables_paginate paging_full_numbers"
	id="dataTable1_paginate">
	<a tabindex="0" class="首页 paginate_button paginate_button_disabled"
		id="dataTable1_first">首页</a><a tabindex="0"
		class="上一页 paginate_button paginate_button_disabled"
		id="dataTable1_previous">上一页</a><span><a tabindex="0"
		class="paginate_active">1</a></span><a tabindex="0"
		class="下一页 paginate_button paginate_button_disabled"
		id="dataTable1_next">下一页</a><a tabindex="0"
		class="最后一页 paginate_button paginate_button_disabled"
		id="dataTable1_last">尾页</a>
</div>
