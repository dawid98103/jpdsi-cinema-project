<%--
  Created by IntelliJ IDEA.
  User: Dawid
  Date: 12.05.2020
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Projekt zaliczeniowy pwai">
    <meta name="author" content="Sergey Pozhilov (GetTemplate.com)">

    <title>Cinema City</title>

    <link rel="shortcut icon" href="resources/images/icons8-movie-64.png">

    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

    <link rel="stylesheet" media="screen" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/font-awesome.min.css">

    <!-- Custom styles for our template -->
    <link rel="stylesheet" href="/static/css/bootstrap-theme.css" media="screen">
    <link rel="stylesheet" href="/static/css/main.css">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="/static/js/html5shiv.js"></script>
    <script src="/static/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="navbar-collapse collapse">
    <tiles:insertAttribute name="navbar"/>
</div>
<tiles:insertAttribute name="body"/>
<footer id="footer">
    <tiles:insertAttribute name="footer"/>
</footer>
</body>
</html>
