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
<html>
<%@include file="navbar.jsp" %>
<script>
    $(function () {
        $('[data-toggle="tooltip"]').tooltip()
    })
</script>

<security:authorize access="hasAuthority('USER')" var="isUser"/>
<div class="container">
    <div class="panel repertoire-panel panel-margin">
        <div class="panel-heading">
            <c:url value="/movie/repertoire" var="reservation"></c:url>
            <form:form method="get" modelAttribute="showingDates" action="${reservation}" class="filter-form">
                <div class="col-lg-4">
                    <label>Data od: </label>
                    <form:input path="dateFrom" type="datetime-local" placeholder="${showingDates.dateFrom}"
                                autocomplete="false" class="datepicker"/>
                </div>
                <div class="col-lg-4">
                    <label>Data do: </label>
                    <form:input path="dateTo" type="datetime-local" placeholder="${showingDates.dateTo}"
                                autocomplete="false"
                                class="datepicker"/>
                </div>
                <div class="col-lg-4">
                    <button type="submit" class="btn btn-primary">Szukaj</button>
                </div>
            </form:form>
        </div>
        <div class="panel-body">
            <c:if test="${showings.size() == 0}">
                <div class="alert alert-info">Brak seansów</div>
            </c:if>
            <ul class="list-group">
                <c:forEach items="${showings}" var="showing">
                    <c:forEach items="${showing.movies}" var="movies">
                        <li class="list-group-item">
                            <div class="row repertoire-row">
                                <div class="col-lg-6">
                                    <span>${movies.movieName}</span>
                                </div>
                                <div class="col-lg-4">
                                    <span>${showing.showingDate}</span>
                                </div>
                                <div class="co-lg-2">
                                    <c:choose>
                                        <c:when test="${isUser}">
                                            <button class="btn btn-success">Rezerwuj</button>
                                        </c:when>
                                        <c:otherwise>
                                            <span data-placement="right" data-toggle="tooltip"
                                                  title="Musisz się zalogować!">
                                                <button class="btn btn-success" disabled>Rezerwuj</button>
                                            </span>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                        </li>
                    </c:forEach>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>
</html>
