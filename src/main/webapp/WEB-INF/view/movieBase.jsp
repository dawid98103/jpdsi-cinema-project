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
<div class="picture-grid">
    <c:forEach items="${movies}" var="movie">
        <div class="home-photo">
            <a href="${pageContext.request.contextPath}/movie/info/${movie.movieId}" class="thumbnail">
                <img src="${movie.movieSmallUrl}" alt="${movie.movieDescription}">
            </a>
        </div>
    </c:forEach>
</div>
<%@include file="footer.jsp" %>
</html>
