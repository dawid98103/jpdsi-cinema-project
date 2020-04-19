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
<html>
<%@include file="navbar.jsp" %>
<div class="container">
    <div class="row">
        <!-- Article main content -->
        <article class="col-xs-12 maincontent">
            <div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
                <div class="panel panel-default form-panel">
                    <div class="panel-body">
                        <h3 class="thin text-center">Zarejestruj się</h3>
                        <hr>
                        <form:form method="post"
                                   action="${pageContext.request.contextPath}/login/processRegistrationForm"
                                   modelAttribute="user" class="login-form">
                            <spring:bind path="userName">
                                <div class="${status.error ? 'has-error' : ''} top-margin">
                                    <label>Login: <span class="text-danger">*</span></label>
                                    <form:input type="text" path="userName" class="form-control" autofocus="true"/>
                                    <form:errors path="userName" cssClass="invalid-feedback"></form:errors>
                                </div>
                            </spring:bind>
                            <spring:bind path="password">
                                <div class="${status.error ? 'has-error' : ''}  top-margin">
                                    <label>Hasło: <span class="text-danger">*</span></label>
                                    <form:input type="password" path="password" class="form-control"/>
                                    <form:errors path="password" cssClass="invalid-feedback"></form:errors>
                                    <form:errors path="confirmPassword"></form:errors>
                                </div>
                            </spring:bind>
                            <spring:bind path="confirmPassword">
                                <div class="${status.error ? 'has-error' : ''} top-margin">
                                    <label>Powtórz hasło: <span class="text-danger">*</span></label>
                                    <form:input type="password" path="confirmPassword" class="form-control"/>
                                    <form:errors path="confirmPassword"></form:errors>
                                </div>
                            </spring:bind>
                            <spring:bind path="email">
                                <div class="${status.error ? 'has-error' : ''} top-margin">
                                    <label>Email: <span class="text-danger">*</span></label>
                                    <form:input type="text" path="email" class="form-control"/>
                                    <form:errors path="email"></form:errors>
                                </div>
                            </spring:bind>
                            <spring:bind path="name">
                                <div class="${status.error ? 'has-error' : ''} top-margin">
                                    <label>Imie:</label>
                                    <form:input type="text" path="name" class="form-control"/>
                                    <form:errors path="name"></form:errors>
                                </div>
                            </spring:bind>
                            <spring:bind path="lastName">
                                <div class="${status.error ? 'has-error' : ''} top-margin">
                                    <label>Nazwisko:</label>
                                    <form:input type="text" path="lastName" class="form-control"/>
                                    <form:errors path="lastName"></form:errors>
                                </div>
                            </spring:bind>
                            <hr>
                            <div class="login-bottom-row">
                                <div class="col-lg-8">
                                    <a href="/login/login"><< Wróć</a>
                                </div>
                                <div class="col-lg-4 text-right">
                                    <button class="btn btn-action" type="submit">Zarejestruj</button>
                                </div>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </article>
    </div>
</div>
<%@include file="footer.jsp" %>
</html>
