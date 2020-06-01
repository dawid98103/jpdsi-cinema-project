<%--
  Created by IntelliJ IDEA.
  User: Dawid
  Date: 09.04.2020
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="pagina" value="${requestScope['javax.servlet.forward.request_uri']}"/>
<div class="navbar navbar-inverse navbar-fixed-top headroom animated slideDown">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"><span
                    class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span></button>
            <a class="navbar-brand" href="${ctx}/"><i class="fas fa-video"></i> CINEMA CITY</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav pull-right">
                <li class="${pagina.endsWith('/') ? 'active' : ''}"><a
                        href="${ctx}/">Home</a></li>
                <li class="${pagina.endsWith('/movies') ? 'active' : ''}"><a
                        href="${ctx}/movie/info/movies">Baza filmów</a></li>
                <li class="${pagina.endsWith('/movie/ranking') ? 'active' : ''}"><a href="${ctx}/movie/ranking">Ranking
                    filmów</a></li>
                <security:authorize access="hasAnyAuthority('USER','ADMIN')">
                    <li class="${pagina.endsWith('/repertoireOverview') ? 'active' : ''}"><a
                            href="${ctx}/showing/repertoireOverview">Repertuar</a></li>
                </security:authorize>
                <security:authorize access="hasAnyAuthority('USER','ADMIN')">
                    <li class="nav-button"><a class="${pagina.endsWith('/myReservationPage') ? 'active' : ''}"
                                              href="${ctx}/showing/myReservation">Moje rezerwacje</a></li>
                </security:authorize>
                <security:authorize access="hasAuthority('ADMIN')">
                    <li class="nav-button"><a href="${ctx}/admin/userManage">Zarządzaj</a></li>
                </security:authorize>
                <li class="${pagina.endsWith('/showPriceList') ? 'active' : ''}"><a
                        href="${ctx}/priceList/showPriceList">Cennik</a>
                </li>
                <sec:authorize access="!isAuthenticated()">
                    <li class="nav-button">
                        <a class="${pagina.endsWith('/showLogin') ? 'active' : ''}" href="${ctx}/login/loginForm">
                            Zaloguj
                        </a>
                    </li>
                </sec:authorize>
                <sec:authorize access="!isAuthenticated()">
                    <li class="nav-button">
                        <a class="${pagina.endsWith('/registration') ? 'active' : ''}" href="${ctx}/login/registration">
                            Zarejestruj
                        </a>
                    </li>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <%--                    <li>--%>
                    <%--                        <a href="/">--%>
                    <%--                            Witaj ${pageContext.request.userPrincipal.name}--%>
                    <%--                            <span class="glyphicon glyphicon-user"></span>--%>
                    <%--                        </a>--%>
                    <%--                    </li>--%>
                    <%--                    <li>--%>
                    <%--                        <a class="btn" href="/logout">--%>
                    <%--                            Wyloguj--%>
                    <%--                        </a>--%>
                    <%--                    </li>--%>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i
                                class="fas fa-user-circle fa-2x"></i></a>
                        <ul class="dropdown-menu">
                            <li class="nav-list-item list-user-name"><span>${pageContext.request.remoteUser}</span></li>
                            <li class="nav-list-item"><a href="sidebar-left.html">Ustawienia</a></li>
                            <li class="active nav-list-item"><a href="/logout">Wyloguj</a></li>
                        </ul>
                    </li>
                </sec:authorize>
                </li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>