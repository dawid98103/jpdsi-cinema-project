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
<%@include file="modals/reserveModal.jsp" %>
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
        <thead class="basic-thead text-center">
        <tr>
            <th class="interactional-theader">Nazwa</th>
            <th class="interactional-theader">Data</th>
            <th>Operacje</th>
        </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
    <div class="alert alert-warning hidden" id="noShowingsError">Nie znaleziono seansów</div>

    <div class="alert alert-success" id="success-alert">
        <button type="button" class="close" data-dismiss="alert">x</button>
        Rezerwacja przebiegła pomyślnie!
    </div>
</div>
