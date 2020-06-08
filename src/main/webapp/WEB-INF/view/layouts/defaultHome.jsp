<%--
  Created by IntelliJ IDEA.
  User: Dawid
  Date: 12.05.2020
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<tiles:importAttribute name="javascripts"/>
<tiles:importAttribute name="stylesheets"/>

<html lang="pl-PL">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Projekt zaliczeniowy pwai">
    <meta name="author" content="Dawid Kobylarz (GetTemplate.com)">

    <title><tiles:insertAttribute name="title"/></title>

    <c:forEach var="css" items="${stylesheets}">
        <link rel="stylesheet" type="text/css" href="<c:url value="${css}"/>">
    </c:forEach>
    <link rel="shortcut icon" href="/static/images/icons8-movie-64.png">
</head>
<body>
<tiles:insertAttribute name="navbar"/>
<tiles:insertAttribute name="body"/>
<footer id="footer">
    <tiles:insertAttribute name="footer"/>
</footer>
<c:forEach var="script" items="${javascripts}">
    <script src="<c:url value="${script}"/>"></script>
</c:forEach>
</body>
</html>
