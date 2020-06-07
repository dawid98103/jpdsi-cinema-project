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
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@include file="modals/reserveModal.jsp" %>

<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>

<div class="container top-margin datatable-container">
    <table id="showingTable" class="table" cellspacing="5" cellpadding="5">
        <thead>
        <th>ID</th>
        <th>Nazwa Filmu</th>
        <th>Długość senasu</th>
        <th>Data seansu</th>
        <th>Opcje</th>
        </thead>
    </table>
    <div class="notifications top-right"></div>
</div>
