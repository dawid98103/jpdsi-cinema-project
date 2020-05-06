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
<%@include file="navbar.jsp" %>
<div>
    <div class="row">
        <article class="col-xs-12 maincontent form-panel top-margin">
            <div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
                <div class="panel panel-default panel-movie">
                    <div class="row movie-info-row">
                        <div class="col-lg-8">
                            <div class="movie-title">
                                <h3>${movie.movieName}</h3> <div>Czas trwania: ${movie.movieDuration} min <i class="far fa-clock"></i></div>
                            </div>
                            <hr>
                            <div class="movie-description">
                                ${movie.movieDescription}
                            </div>
                        </div>
                        <div class="col-lg-4">
                            <a class="thumbnail">
                                <img src="${movie.movieSmallUrl}" alt="${movie.movieDescription}"/>
                            </a>
                            <div class="panel movie-info-panel">
                                <div>Gatunek: Familijny</div>
                                <hr style="margin:10px">
                                <div>Reżyser: Anthony Russo/Joe Russo</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </article>
    </div>
</div>
<%@include file="footer.jsp" %>