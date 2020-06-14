<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: Dawid
  Date: 11.06.2020
  Time: 02:02
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="../modals/createMovieModal.jsp" %>
<%@ include file="../modals/confirmModal.jsp" %>
<%@ include file="../modals/createShowingModal.jsp"%>
<nav class="navbar navbar-default">
    <ul class="nav navbar-nav">
        <li>
            <button class="btn btn-success btn-sm open-create-dialog" href="#createMovieModal" data-toggle="modal"><i class="fas fa-plus"></i>Dodaj
            </button>
        </li>
    </ul>
</nav>
<table id="moviesManageTable" class="table" cellspacing="5" cellpadding="5" border="1px solid black">
    <thead>
    <tr>
        <th>ID</th>
        <th>Nazwa Filmu</th>
        <th>Gatunek</th>
        <th>Ocena</th>
        <th></th>
    </tr>
    </thead>
</table>
<div class="notifications top-right"></div>




