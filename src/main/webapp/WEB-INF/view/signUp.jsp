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
<div class="container top-margin">
    <div class="my-login-form">
        <div class="text-center">
            <div class="header-title">
                <h1 class="wv-heading--title">
                    Dołącz do nas!
                </h1>
            </div>
        </div>
        <div class="mx-auto">
            <div class="myform form ">
                <form:form method="post" action="${pageContext.request.contextPath}/login/processRegistrationForm"
                           modelAttribute="user" class="login-form">
                    <spring:bind path="userName">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <form:input type="text" path="userName" class="form-control my-input" placeholder="Login"
                                        autofocus="true"/>
                            <form:errors path="userName" cssClass="invalid-feedback"></form:errors>
                        </div>
                    </spring:bind>

                    <spring:bind path="password">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <form:input type="password" path="password" class="form-control my-input"
                                        placeholder="Hasło"/>
                            <form:errors path="password" cssClass="invalid-feedback"></form:errors>
                            <form:errors path="confirmPassword"></form:errors>
                        </div>
                    </spring:bind>

                    <spring:bind path="confirmPassword">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <form:input type="password" path="confirmPassword" class="form-control"
                                        placeholder="Powtórz hasło"/>
                            <form:errors path="confirmPassword"></form:errors>
                        </div>
                    </spring:bind>

                    <spring:bind path="email">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <form:input type="text" path="email" class="form-control" placeholder="Email"/>
                            <form:errors path="email"></form:errors>
                        </div>
                    </spring:bind>

                    <spring:bind path="name">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <form:input type="text" path="name" class="form-control" placeholder="Imie"/>
                            <form:errors path="name"></form:errors>
                        </div>
                    </spring:bind>

                    <spring:bind path="lastName">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <form:input type="text" path="lastName" class="form-control" placeholder="Nazwisko"/>
                            <form:errors path="lastName"></form:errors>
                        </div>
                    </spring:bind>

                    <div class="text-center ">
                        <button type="submit" class=" btn btn-block send-button tx-tfm">Zarejestruj się</button>
                    </div>
                    <div class="col-md-12 ">
                        <div class="login-or">
                            <hr class="hr-or">
                            <span class="span-or">lub</span>
                        </div>
                    </div>
                    <div class="form-group">
                        <button class="btn btn-primary btn-block" href="/login/login">
                            <i>Wróć</i>
                        </button>
                    </div>
                    <p class="small mt-3">By signing up, you are indicating that you have read and agree to the <a
                            href="#" class="ps-hero__content__link">Terms of Use</a> and <a href="#">Privacy Policy</a>.
                    </p>
                </form:form>
            </div>
        </div>
    </div>
</div>
