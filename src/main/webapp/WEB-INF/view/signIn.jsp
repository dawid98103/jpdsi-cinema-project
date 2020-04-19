<%--
  Created by IntelliJ IDEA.
  User: Dawid
  Date: 09.04.2020
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%@include file="navbar.jsp" %>
<!-- container -->
<div class="container">
    <div class="row">
        <!-- Article main content -->
        <article class="col-xs-12 maincontent">
            <div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
                <div class="panel panel-default form-panel">
                    <div class="panel-body">
                        <h3 class="thin text-center">Zaloguj się</h3>
                        <hr>
                        <c:url var="loginUrl" value="/login"/>
                        <form:form action="${loginUrl}" method="post">
                        <div class="${param.error ? 'has-error' : ''} top-margin">
                            <label>Nazwa użytkownika:</label>
                            <input type="text" name="user_name" class="form-control">
                        </div>
                        <div class="${param.error ? 'has-error' : ''} top-margin">
                            <label>Hasło:</label>
                            <input type="password" name="password" class="form-control">
                        </div>
                        <hr>
                        <c:if test="${param.error}">
                            <b><p class="text-danger text-center">Zła nazwa użytkownika lub hasło</p></b>
                        </c:if>
                        <div class="login-bottom-row">
                                <%--                                <div class="col-lg-8">--%>
                                <%--                                    <b><a href="">Zapomniałeś hasła?</a></b>--%>
                                <%--                                </div>--%>
                            <div>
                                <b><a href="${pageContext.request.contextPath}/login/registration">Utwórz konto</a></b>
                            </div>
                            <div>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                <button class="btn btn-action" type="submit">Zaloguj</button>
                            </div>
                        </div>
                    </div>
                    </form:form>
                </div>
            </div>
        </article>
        <!-- /Article -->
    </div>
</div>    <!-- /container -->
<%@include file="footer.jsp" %>
</html>
