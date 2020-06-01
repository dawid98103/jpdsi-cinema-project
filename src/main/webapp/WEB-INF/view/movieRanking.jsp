<%--
  Created by IntelliJ IDEA.
  User: Dawid
  Date: 11.04.2020
  Time: 02:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container top-margin">
    <ul class="list-group">
        <c:forEach items="${movie}" var="movie" varStatus="loop">
            <li class="list-group-item " data-rate = ${movie.averageRate}>
                <div class="row flex-row ranking-text">
                    <div class="col-md-2 flex-row">
                            ${loop.index + 1}.
                    </div>
                    <div class="col-md-3 flex-row">
                        <img src="${movie.movieSmallUrl}" class="img-rounded img-responsive" style="width: 70px;">
                    </div>
                    <div class="col-md-4 flex-row">
                            ${movie.movieName}
                    </div>
                    <div class="col-md-3 flex-row rate-col">
                        <input type="number" class="rating" value="${movie.averageRate}" readonly="true" data-show-clear="false" data-show-caption="false">
                    </div>
                </div>
            </li>
        </c:forEach>
    </ul>
</div>