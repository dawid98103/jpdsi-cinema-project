<%--
  Created by IntelliJ IDEA.
  User: Dawid
  Date: 29.04.2020
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="modal fade" id="reservationModal" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title"><span class="movie-name"></span><span class="movie-date"></span></h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-lg-8">
                        <div class="form-group">
                            <label for="ticket-type">Typ:</label>
                            <select class="form-control" id="ticket-type">
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="ticket-quantity">Ilość:</label>
                            <select class="form-control" id="ticket-quantity">
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <a href="#" class="thumbnail">
                            <img src="" id="modal-img">
                        </a>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Zamknij</button>
                <button type="button" class="btn btn-primary" id="reservationButton">Rezerwuj</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
<!-- /.modal -->
