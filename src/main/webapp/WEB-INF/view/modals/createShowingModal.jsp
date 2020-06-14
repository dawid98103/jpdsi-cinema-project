<%--
  Created by IntelliJ IDEA.
  User: Dawid
  Date: 11.06.2020
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form class="modal fade" id="createShowingModal" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <div class="nav-info-header">
                    <h4 class="modal-title"><span>Dodaj nowy seans:</span><span id="movie-name"></span></h4>
                </div>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-lg-8">
                        <label for="datepicker">Data seansu: </label>
                        <input type="datetime-local" id="datepicker">
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
                <button type="submit" class="btn btn-success" id="saveShowingButton">Zapisz</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</form>
