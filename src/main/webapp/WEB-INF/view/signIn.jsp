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

<div class="container top-margin">
    <div class="my-login-form">
        <div class="text-center">
            <div class="header-title">
                <h1 class="wv-heading--title">
                    Zaloguj się
                </h1>
            </div>
        </div>
        <div class="mx-auto">
            <div class="myform form ">
                <c:url var="loginUrl" value="/login"/>
                <form:form action="${loginUrl}" method="post">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <input type="text" name="user_name" class="form-control my-input" placeholder="Login" autocomplete="false">
                    </div>

                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <input type="password" name="password" class="form-control my-input" placeholder="Hasło" autocomplete="false">
                    </div>

                    <div class="text-center ">
                        <button type="submit" class=" btn btn-block send-button tx-tfm">Zaloguj</button>
                    </div>
                    <c:if test="${param.error}">
                        <b><p class="text-danger text-center">Zła nazwa użytkownika lub hasło</p></b>
                    </c:if>
                    <p class="small mt-3">By signing up, you are indicating that you have read and agree to the <a
                            href="#" class="ps-hero__content__link">Terms of Use</a> and <a href="#">Privacy Policy</a>.
                    </p>
                </form:form>
            </div>
        </div>
    </div>
</div>
