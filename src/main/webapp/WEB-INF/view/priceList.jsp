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
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<div class="container">
    <div class="panel panel-price-list">
        <table class="table" id="price-list-table">
            <thead class="text-center">
            <tr>
                <th>Typ biletu</th>
                <th>Cena</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${tickets}" var="ticket">
                <tr>
                    <td>
                            ${ticket.type}
                    </td>
                    <td>
                            ${ticket.price} zł
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

