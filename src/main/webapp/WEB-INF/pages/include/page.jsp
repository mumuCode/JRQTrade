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

