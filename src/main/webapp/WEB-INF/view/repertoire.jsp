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
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@include file="navbar.jsp" %>
<%@include file="modals/reserveModal.jsp"%>
<security:authorize access="hasAuthority('USER')" var="isUser"/>
<div class="container">
    <div class="panel-heading panel-margin">
        <div>
            <label for="from">Od</label>
            <input type="text" id="from" name="from">
        </div>
        <div>
            <label for="to">Do</label>
            <input type="text" id="to" name="to">
        </div>
        <button class="btn btn-success" onclick="getShowingsByDate()">Szukaj</button>
    </div>

    <table id="showingTable" class="table">
        <thead>
        <tr>
            <th>Nazwa</th>
            <th>Data</th>
            <th>Operacje</th>
        </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
    <div class="alert alert-warning hidden" id="noShowingsError">Nie znaleziono seansów</div>
</div>
<script src="/js/repertoire/customRepertoireScript.js"/>
<%@include file="footer.jsp" %>
