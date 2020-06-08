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
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div>
    <div class="row">
        <article class="col-xs-12 maincontent form-panel top-margin">
            <div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
                <div class="panel panel-default panel-movie">
                    <div class="row movie-info-row">
                        <div class="col-lg-7">
                            <ul class="list-group">
                                <li class="list-group-item dark">
                                    <div class="movie-title">
                                        <h3>${movie.movieName}</h3>
                                        <div>Czas trwania: ${movie.movieDuration} min <i class="far fa-clock"></i></div>
                                    </div>
                                </li>
                                <li class="list-group-item dark">
                                    <div class="movie-description">
                                        ${movie.movieDescription}
                                    </div>
                                </li>
                            </ul>
                        </div>
                        <div class="col-lg-5">
                            <a class="thumbnail">
                                <img src="${movie.movieSmallUrl}" alt="${movie.movieDescription}"/>
                            </a>
                            <div class="panel movie-info-panel">
                                <ul class="list-group dark">
                                    <li class="list-group-item dark">
                                        <div>Gatunek: ${movie.genre.genreName}</div>
                                    </li>
                                    <li class="list-group-item dark">
                                        <div>Reżyser: ${movie.movieDirector}</div>
                                    </li>

                                    <li class="list-group-item dark">
                                        <label for="rate-input" class="control-label">Oceń film:</label>
                                        <security:authorize access="!isAuthenticated()">
                                            <input id="rate-input" disabled="true" data-movie-id= ${movie.movieId}>
                                        </security:authorize>
                                        <security:authorize access="isAuthenticated()">
                                            <input id="rate-input" data-movie-id= ${movie.movieId}>
                                        </security:authorize>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </article>
    </div>
    <div class="notifications top-right"></div>
</div>