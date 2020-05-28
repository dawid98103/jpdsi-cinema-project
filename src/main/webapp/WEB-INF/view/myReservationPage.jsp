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
<%@ taglib prefix="html" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="modals/confirmModal.jsp" %>
<div class="container top-margin">
    <c:choose>
        <c:when test="${reservations.size() > 0}">
            <table id="myReservationTable" class="table">
                <thead class="basic-thead text-center">
                <tr>
                    <th onclick="sortTableByName(0)" class="interactional-theader">Nazwa</th>
                    <th onclick="sortTableByDate(1)" class="interactional-theader">Początek rezerwacji</th>
                    <th onclick="sortTableByDate(2)" class="interactional-theader">Koniec Rezerwacji</th>
                    <th class="interactional-theader">Bilety</th>
                    <th>Operacje</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${reservations}" var="reservation">
                    <tr class="basic-trows">
                        <td>${reservation.movie.movieName}</td>
                        <td>${reservation.reservationDateStart}</td>
                        <td>${reservation.reservationDateEnd}</td>
                        <td>
                            <c:forEach items="${reservation.ticketQuantities}" var="ticketQuantity">
                                ${ticketQuantity.quantity} x ${ticketQuantity.ticket.type}
                            </c:forEach>
                        </td>
                        <td><a class="btn btn-danger modal-opener" data-toggle="modal"
                               data-id="${reservation.reservationId}"
                               href="#confirmModal">Anuluj rezerwację</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <div class="alert alert-warning" id="noShowingsError">Nie masz żadnej rezerwacji</div>
        </c:otherwise>
    </c:choose>
</div>
<div class="notifications top-right"></div>
