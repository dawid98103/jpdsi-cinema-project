<%--
  Created by IntelliJ IDEA.
  User: Dawid
  Date: 11.04.2020
  Time: 02:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="html" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="modals/confirmModal.jsp" %>
<div class="container top-margin">
    <table id="reservationTable" class="table" cellspacing="5" cellpadding="5">
        <thead>
        <th>Nazwa Filmu</th>
        <th>Początek rezerwacji</th>
        <th>Koniec rezerwacji</th>
        <th>Bilety</th>
        <th>Do zapłaty</th>
        <th>Operacje</th>
        </thead>
        <tbody>
        <c:forEach items="${reservations}" var="reservation">
            <tr>
                <td>
                        ${reservation.movie.movieName}
                </td>
                <td>
                        ${reservation.reservationDateStart}
                </td>
                <td>
                        ${reservation.reservationDateEnd}
                </td>
                <td>
                    <c:forEach items="${reservation.ticketQuantities}" var="ticket">
                        <c:if test="${ticket.quantity > 0}">
                            ${ticket.quantity} x ${ticket.ticket.type}
                        </c:if>
                    </c:forEach>
                </td>
                <td>
                    <c:set var="total" value="${0}"/>
                    <c:forEach items="${reservation.ticketQuantities}" var="ticket">
                        <c:if test="${ticket.quantity > 0}">
                            <c:set var="total" value="${total + ticket.quantity * ticket.ticket.price}"/>
                        </c:if>
                    </c:forEach>
                        ${total} zł
                </td>
                <td>
                    <button class="btn btn-success" data-id="${reservation.reservationId}" data-toggle="modal"
                            data-target="#confirmModal">
                        Anuluj
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="notifications top-right"></div>
