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
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Sergey Pozhilov (GetTemplate.com)">

    <title>Cinema City</title>

    <link rel="shortcut icon" href="/images/gt_favicon.png">

    <link rel="stylesheet" media="screen" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/font-awesome.min.css">

    <!-- Custom styles for our template -->
    <link rel="stylesheet" href="/css/bootstrap-theme.css" media="screen">
    <link rel="stylesheet" href="/css/main.css">

    <!-- JQuerry for datapicker -->
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="/js/html5shiv.js"></script>
    <script src="/js/respond.min.js"></script>
    <![endif]-->
</head>
<body class="home">
<div class="navbar navbar-inverse navbar-fixed-top headroom">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"><span
                    class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span></button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/"><i class="fas fa-video"></i>  CINEMA CITY</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav pull-right">
                <li class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
                <li><a href="${pageContext.request.contextPath}/movie/info/movies">Baza filmów</a></li>
                <li><a href="${pageContext.request.contextPath}/movie/repertoire">Repertuar</a></li>
                <security:authorize access="hasAuthority('USER')">
                    <li><a href="${pageContext.request.contextPath}/booking">Moje rezerwacje</a></li>
                </security:authorize>
                <security:authorize access="hasAuthority('ADMIN')">
                    <li><a href="${pageContext.request.contextPath}/admin/userManage"></a></li>
                </security:authorize>
                <li><a href="${pageContext.request.contextPath}/priceList/showPriceList">Cennik</a></li>
                <sec:authorize access="!isAuthenticated()">
                    <li>
                        <a class="btn" href="${pageContext.request.contextPath}/login/login">
                            Zaloguj
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