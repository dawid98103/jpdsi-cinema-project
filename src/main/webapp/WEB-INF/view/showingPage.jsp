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

    <div class="navigation-panel">
        <div class="panel panel-margin">
            <c:url value="/movie/reservation" var="reservation"></c:url>
            <form:form method="get" modelAttribute="showingDates" action="${reservation}">
                <div class="row">
                    <div class="col-lg-4">
                        <label>Data od:</label>
                        <form:input path="dateFrom" type="date" placeholder="${showingDates.dateFrom}"
                                    autocomplete="false" class="datepicker"/>
                    </div>
                    <div class="col-lg-4">
                        <label>Data do:</label>
                        <form:input path="dateTo" type="date" placeholder="${showingDates.dateTo}" autocomplete="false"
                                    class="datepicker"/>
                    </div>
                    <div class="col-lg-4">
                        <button type="submit" class="btn btn-primary">Szukaj</button>
                    </div>
                </div>
            </form:form>
        </div>
    </div>


    <c:if test="${showings.size() == 0}">
        <div class="alert alert-info panel-margin">Brak seansów</div>
    </c:if>
    <div class="panel">
        <c:forEach items="${showings}" var="showing">
            <div class="panel panel-default">
                <div class="panel-heading"><h4>${showing.showingDate}</h4></div>
                <c:forEach items="${showing.movies}" var="movies">
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-10">
                                <h3>${movies.movieName}</h3>
                                <hr>
                                <div>
                                        ${movies.movieDescription}
                                </div>
                                <a href="${pageContext.request.contextPath}/movie/info/${movies.movieId}">Więcej...</a>
                            </div>
                            <div class="col-lg-2">
                                <a class="thumbnail reservation-image">
                                    <img src="${movies.movieSmallUrl}"/>
                                </a>
                            </div>
                        </div>
                    </div>
                    <hr>
                </c:forEach>
            </div>
        </c:forEach>
    </div>
</div>
<%@include file="footer.jsp" %>
</html>
