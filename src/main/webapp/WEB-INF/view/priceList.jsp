<%--
  Created by IntelliJ IDEA.
  User: Dawid
  Date: 11.04.2020
  Time: 02:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<%@include file="navbar.jsp" %>
<div class="container">
    <div class="panel panel-price-list">
        <ul class="list-group">
            <c:forEach items="${tickets}" var="ticket">
                <li class=list-group-item>${ticket.type}   ${ticket.price}zł</li>
            </c:forEach>
        </ul>
    </div>
</div>
<%@include file="footer.jsp" %>
</html>
