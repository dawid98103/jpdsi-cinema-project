<%--
  Created by IntelliJ IDEA.
  User: Dawid
  Date: 09.04.2020
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize var="loggedIn" access="isAuthenticated()"/>

<!-- Header -->
<header id="head">
    <div class="container">
        <div class="row">
            <h1 class="lead">Cinema City</h1>
            <p class="tagline">Największa sieć kin w Polsce</p>
        </div>
    </div>
</header>
<!-- /Header -->
<!-- Intro -->
<div class="container text-center photo-horizontal-container">
    <div class="row photos-row">
        <c:forEach items="${movieList}" var="movie" begin="0" end="5">
            <div class="home-photo col-lg-2 col-md-4 col-sm-6">
                <a href="${pageContext.request.contextPath}/movie/info/${movie.movieId}" class="thumbnail">
                    <img src="${movie.movieSmallUrl}" alt="${movie.movieDescription}">
                    <div class="middle">
                        <div class="home-photo-text">${movie.movieName}</div>
                    </div>
                </a>
            </div>
        </c:forEach>
    </div>
</div>
<!-- /Intro-->

<!-- Highlights - jumbotron -->
<div class="jumbotron top-space">
    <div class="container">

        <h3 class="text-center thin">Aktualności</h3>

        <div class="row">
            <div class="col-md-3 col-sm-6 highlight">
                <div class="panel panel-default home-panel">
                    <div class="panel-heading">
                        <h3 class="panel-title">Promocje</h3>
                    </div>
                    <div class="panel-body">
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum sapien ante, consequat ultrices justo ut, iaculis vulputate augue.</p>
                        <p>Donec feugiat felis scelerisque erat tristique, vitae luctus justo gravida. Aenean vel diam magna.</p>
                        <p>In sit amet luctus lorem, a pretium lectus. Nam facilisis orci quis tincidunt rhoncus.</p>
                        <p>Quisque eu massa arcu. Etiam congue commodo faucibus. Aenean id nulla et leo volutpat imperdiet non vel dui.</p>
                    </div>
                </div>
            </div>
            <div class="col-md-3 col-sm-6 highlight">
                <div class="panel panel-default home-panel">
                    <div class="panel-heading">
                        <h3 class="panel-title">Wydarzenia</h3>
                    </div>
                    <div class="panel-body">
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum sapien ante, consequat ultrices justo ut, iaculis vulputate augue.</p>
                        <p>Donec feugiat felis scelerisque erat tristique, vitae luctus justo gravida. Aenean vel diam magna.</p>
                        <p>In sit amet luctus lorem, a pretium lectus. Nam facilisis orci quis tincidunt rhoncus.</p>
                        <p>Quisque eu massa arcu. Etiam congue commodo faucibus. Aenean id nulla et leo volutpat imperdiet non vel dui.</p>
                    </div>
                </div>
            </div>
            <div class="col-md-3 col-sm-6 highlight">
                <div class="panel panel-default home-panel">
                    <div class="panel-heading">
                        <h3 class="panel-title">Firmy</h3>
                    </div>
                    <div class="panel-body">
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum sapien ante, consequat ultrices justo ut, iaculis vulputate augue.</p>
                        <p>Donec feugiat felis scelerisque erat tristique, vitae luctus justo gravida. Aenean vel diam magna.</p>
                        <p>In sit amet luctus lorem, a pretium lectus. Nam facilisis orci quis tincidunt rhoncus.</p>
                        <p>Quisque eu massa arcu. Etiam congue commodo faucibus. Aenean id nulla et leo volutpat imperdiet non vel dui.</p>
                    </div>
                </div>
            </div>
            <div class="col-md-3 col-sm-6 highlight">
                <div class="panel panel-default home-panel">
                    <div class="panel-heading">
                        <h3 class="panel-title">Szkoły</h3>
                    </div>
                    <div class="panel-body">
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum sapien ante, consequat ultrices justo ut, iaculis vulputate augue.</p>
                        <p>Donec feugiat felis scelerisque erat tristique, vitae luctus justo gravida. Aenean vel diam magna.</p>
                        <p>In sit amet luctus lorem, a pretium lectus. Nam facilisis orci quis tincidunt rhoncus.</p>
                        <p>Quisque eu massa arcu. Etiam congue commodo faucibus. Aenean id nulla et leo volutpat imperdiet non vel dui.</p>
                    </div>
                </div>
            </div>
        </div> <!-- /row  -->
    </div>
</div>