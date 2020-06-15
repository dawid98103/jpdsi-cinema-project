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
                        <p>Dołącz już dziś do Unlimited i chodź z dzieckiem do kina za darmo!.</p>
                        <p>Tylko teraz do swojego członkostwa otrzymasz Kartę Family</p>
                        <p>a wraz z nią 6 biletów dziecięcych gratis do wykorzystania na wspólne, rodzinne wypady do kina.</p>
                        <p>Zobacz jakie to proste!.</p>
                    </div>
                </div>
            </div>
            <div class="col-md-3 col-sm-6 highlight">
                <div class="panel panel-default home-panel">
                    <div class="panel-heading">
                        <h3 class="panel-title">Wydarzenia</h3>
                    </div>
                    <div class="panel-body">
                        <p>Cinema City Bonarka i Wroclavia są jedynymi multipleksami w Polsce z odrębną strefą VIP z 3</p>
                        <p>salami kinowymi i ofertą all inclusive. Od teraz oferujemy dwa warianty wizyty w naszej strefie.</p>
                        <p>Strefa VIP gwarantuje również wyjątkową atmosferę w klimatycznym lobby i oglądanie filmów z perspektywy luksusowych, rozkładanych foteli.</p>
                        <p>VIP all inclusive to zimne i  gorące dania, przygotowywane na miejscu przez profesjonalnych szefów kuchni, wszystko bez ograniczeń i wszystko wliczone w cenę biletu</p>
                    </div>
                </div>
            </div>
            <div class="col-md-3 col-sm-6 highlight">
                <div class="panel panel-default home-panel">
                    <div class="panel-heading">
                        <h3 class="panel-title">Firmy</h3>
                    </div>
                    <div class="panel-body">
                        <p>Najlepsze konferencje, szkolenia, imprezy integracyjne, gale i inne wydarzenia organizowane specjalnie w celu budowania relacji biznesowych mogą</p>
                        <p>dostarczać uczestnikom solidnej dawki adrenaliny. W centrum rozrywki Spin City, </p>
                        <p>zlokalizowanym w warszawskiej dzielnicy Bemowo połączonym z kinem</p>
                        <p>Cinema City pomożemy Ci uczynić każde wydarzenie niezapomnianym.</p>
                    </div>
                </div>
            </div>
            <div class="col-md-3 col-sm-6 highlight">
                <div class="panel panel-default home-panel">
                    <div class="panel-heading">
                        <h3 class="panel-title">Szkoły</h3>
                    </div>
                    <div class="panel-body">
                        <p>Nasze propozycje filmowe to nie tylko rozrywka, ale również programy edukacyjne.</p>
                        <p>skierowane do uczniów i nauczycieli. W każdym kinie odbywają się cykliczne</p>
                        <p>spotkania edukacyjne z filmem „Kino na Temat” – dla młodzieży oraz „Kino na Temat</p>
                        <p>Junior” – dla dzieci.</p>
                    </div>
                </div>
            </div>
        </div> <!-- /row  -->
    </div>
</div>