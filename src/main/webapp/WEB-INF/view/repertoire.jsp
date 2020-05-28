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
        <form style="margin: 0px">
            <div class="form-group">
                <label for="datetimes-input">Wybierz date:</label>
                <input id="datetimes-input" type="text" name="datetimes" class="form-control"/>
            </div>
        </form>
    </div>

    <div id="table-container">
        <table id="showingTable" class="table">
            <thead class="basic-thead text-center">
            <tr>
                <th class="interactional-theader" onclick="sortTableByName(0)">Nazwa</th>
                <th class="interactional-theader" onclick="sortTableByDate(1)">Data</th>
                <th>Operacje</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
    <div class="alert alert-warning hidden" id="noShowingsError">Nie znaleziono seansów</div>
    <div class="notifications top-right"></div>
</div>
