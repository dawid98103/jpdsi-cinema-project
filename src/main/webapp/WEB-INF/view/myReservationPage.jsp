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
<%@include file="modals/confirmModal.jsp"%>
<%@include file="navbar.jsp" %>
<div class="container top-margin">
    <table id="myReservationTable" class="table">
        <thead class="basic-thead text-center">
        <tr>
            <th onclick="sortTableByName(0)" class="interactional-theader">Nazwa</th>
            <th onclick="sortTableByDate(1)" class="interactional-theader">Początek rezerwacji</th>
            <th onclick="sortTableByDate(2)" class="interactional-theader">Koniec Rezerwacji</th>
            <th onclick="sortTableByNumber(3)" class="interactional-theader">Do zapłaty</th>
            <th>Operacje</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${reservations}" var="reservation">
                <tr class="basic-trows">
                    <td>${reservation.movie.movieName}</td>
                    <td>${reservation.reservationDateStart}</td>
                    <td>${reservation.reservationDateEnd}</td>
                    <td>${reservation.amountToPay} zł</td>
                    <td><button class="btn btn-danger" data-toggle="modal" href="#confirmModal">Anuluj rezerwację</button></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div class="alert alert-warning hidden" id="noShowingsError">Nie masz żadnej rezerwacji</div>
</div>
<script src="/js/showing/customReservationScript.js"/>
<%@include file="footer.jsp" %>
