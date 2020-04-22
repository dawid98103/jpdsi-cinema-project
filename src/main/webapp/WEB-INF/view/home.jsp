<%--
  Created by IntelliJ IDEA.
  User: Dawid
  Date: 09.04.2020
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="navbar.jsp" %>
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

        <h3 class="text-center thin">Znajdziesz nas tutaj</h3>

        <div class="row">
            <div class="col-md-3 col-sm-6 highlight">
                <div class="h-caption"><h4><i class="fa fa-cogs fa-5"></i>Bootstrap-powered</h4></div>
                <div class="h-body text-center">
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Atque aliquid adipisci aspernatur.
                        Soluta quisquam dignissimos earum quasi voluptate. Amet, dignissimos, tenetur vitae dolor quam
                        iusto assumenda hic reprehenderit?</p>
                </div>
            </div>
            <div class="col-md-3 col-sm-6 highlight">
                <div class="h-caption"><h4><i class="fa fa-flash fa-5"></i>Fat-free</h4></div>
                <div class="h-body text-center">
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Asperiores, commodi, sequi quis ad
                        fugit omnis cumque a libero error nesciunt molestiae repellat quos perferendis numquam quibusdam
                        rerum repellendus laboriosam reprehenderit! </p>
                </div>
            </div>
            <div class="col-md-3 col-sm-6 highlight">
                <div class="h-caption"><h4><i class="fa fa-heart fa-5"></i>Creative Commons</h4></div>
                <div class="h-body text-center">
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptatem, vitae, perferendis,
                        perspiciatis nobis voluptate quod illum soluta minima ipsam ratione quia numquam eveniet eum
                        reprehenderit dolorem dicta nesciunt corporis?</p>
                </div>
            </div>
            <div class="col-md-3 col-sm-6 highlight">
                <div class="h-caption"><h4><i class="fa fa-smile-o fa-5"></i>Author's support</h4></div>
                <div class="h-body text-center">
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Alias, excepturi, maiores, dolorem
                        quasi reprehenderit illo accusamus nulla minima repudiandae quas ducimus reiciendis odio sequi
                        atque temporibus facere corporis eos expedita? </p>
                </div>
            </div>
        </div> <!-- /row  -->
    </div>
</div>
<%@include file="footer.jsp" %>
</html>
