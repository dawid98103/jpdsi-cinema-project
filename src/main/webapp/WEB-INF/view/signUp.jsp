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

<div class="signup-form top-margin">
    <form:form id="register-form" method="post"
               action="${pageContext.request.contextPath}/processRegistrationForm"
               modelAttribute="user" class="text-left" style="margin-top: 100px;">
        <h2>Rejestracja</h2>
        <p class="hint-text">Załóż swoje konto. Jest to całkowicie darmowe!</p>
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <div class="row">
                <spring:bind path="username">
                    <div class="col-xs-6">
                        <form:input type="text" path="username" class="form-control" placeholder="Login"
                                    autofocus="true" autocomplete="false" id="reg_username"/>
                        <form:errors path="username"></form:errors>
                    </div>
                </spring:bind>
                <spring:bind path="password">
                    <div class="col-xs-6">
                        <form:input type="password" path="password" class="form-control" placeholder="Hasło"
                                    autofocus="true" autocomplete="false" id="reg_password"/>
                        <form:errors path="password"></form:errors>
                    </div>
                </spring:bind>
            </div>
        </div>

        <spring:bind path="confirmPassword">
            <div class="form-group ${status.error ? 'has-error' : ''} ">
                <form:input type="password" path="confirmPassword" class="form-control"
                            placeholder="Potwierdź hasło"
                            autofocus="true" autocomplete="false" id="reg_password_confirm"/>
                <form:errors path="confirmPassword"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="email">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="email" class="form-control" placeholder="Email"
                            autofocus="true" autocomplete="false" id="reg_email"/>
            </div>
        </spring:bind>

        <spring:bind path="name">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="name" class="form-control" placeholder="Imie"
                            autofocus="true" autocomplete="false" id="reg_name"/>
                <form:errors path="name"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="lastName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="lastName" class="form-control" placeholder="Nazwisko"
                            autofocus="true" autocomplete="false" id="reg_surname"/>
                <form:errors path="lastName"></form:errors>
            </div>
        </spring:bind>

        <div class="form-group">
            <button type="submit" class="btn btn-success btn-lg btn-block">Zarejestruj</button>
        </div>
    </form:form>
</div>


<%--<div class="text-center top-margin">--%>
<%--    <div class="container">--%>
<%--        <div class="signup-form">--%>
<%--            <form:form id="register-form" method="post"--%>
<%--                       action="${pageContext.request.contextPath}/login/processRegistrationForm"--%>
<%--                       modelAttribute="user" class="text-left">--%>
<%--            <h2>Register</h2>--%>
<%--            <p class="hint-text">Załóż swoje konto. Jest to całkowicie darmowe!</p>--%>
<%--            <spring:bind path="username">--%>
<%--                <div class="form-group ${status.error ? 'has-error' : ''}">--%>
<%--                    <label for="reg_username" class="sr-only">Nazwa użytkownika</label>--%>
<%--                    <form:input type="text" path="username" class="form-control" placeholder="Login"--%>
<%--                                autofocus="true" autocomplete="false" id="reg_username"/>--%>
<%--                    <form:errors path="username"></form:errors>--%>
<%--                </div>--%>
<%--            </spring:bind>--%>

<%--            <spring:bind path="password">--%>
<%--                <div class="form-group ${status.error ? 'has-error' : ''}">--%>
<%--                    <label for="reg_password" class="sr-only">Hasło</label>--%>
<%--                    <form:input type="password" path="password" class="form-control" placeholder="Hasło"--%>
<%--                                autofocus="true" autocomplete="false" id="reg_password"/>--%>
<%--                    <form:errors path="password"></form:errors>--%>
<%--                </div>--%>
<%--            </spring:bind>--%>

<%--            <spring:bind path="confirmPassword">--%>
<%--                <div class="form-group ${status.error ? 'has-error' : ''}">--%>
<%--                    <label for="reg_password_confirm" class="sr-only">Potwierdź hasło</label>--%>
<%--                    <form:input type="password" path="confirmPassword" class="form-control"--%>
<%--                                placeholder="Potwierdź hasło"--%>
<%--                                autofocus="true" autocomplete="false" id="reg_password_confirm"/>--%>
<%--                    <form:errors path="confirmPassword"></form:errors>--%>
<%--                </div>--%>
<%--            </spring:bind>--%>

<%--            <spring:bind path="email">--%>
<%--                <div class="form-group  ${status.error ? 'has-error' : ''}">--%>
<%--                    <label for="reg_email" class="sr-only">Email</label>--%>
<%--                    <form:input type="text" path="email" class="form-control" placeholder="Email"--%>
<%--                                autofocus="true" autocomplete="false" id="reg_email"/>--%>
<%--                </div>--%>
<%--            </spring:bind>--%>

<%--            <spring:bind path="name">--%>
<%--                <div class="form-group ${status.error ? 'has-error' : ''}">--%>
<%--                    <label for="reg_name" class="sr-only">Imie</label>--%>
<%--                    <form:input type="text" path="name" class="form-control" placeholder="Imie"--%>
<%--                                autofocus="true" autocomplete="false" id="reg_name"/>--%>
<%--                    <form:errors path="name"></form:errors>--%>
<%--                </div>--%>
<%--            </spring:bind>--%>

<%--            <spring:bind path="lastName">--%>
<%--                <div class="form-group ${status.error ? 'has-error' : ''}">--%>
<%--                    <label for="reg_surname" class="sr-only">Nazwisko</label>--%>
<%--                    <form:input type="text" path="lastName" class="form-control" placeholder="Nazwisko"--%>
<%--                                autofocus="true" autocomplete="false" id="reg_surname"/>--%>
<%--                    <form:errors path="lastName"></form:errors>--%>
<%--                </div>--%>
<%--            </spring:bind>--%>

<%--        </div>--%>
<%--        <button type="submit" class="login-button"><i class="fa fa-chevron-right"></i></button>--%>
<%--    </div>--%>
<%--    <div class="etc-login-form">--%>
<%--        <p>Masz już konto? <a href="#">zaloguj się tutaj</a></p>--%>
<%--    </div>--%>
<%--    </form:form>--%>
<%--</div>--%>
<%--</div>--%>

<%--</div>--%>

