<%--
  Created by IntelliJ IDEA.
  User: Dawid
  Date: 11.06.2020
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form class="modal fade" id="createMovieModal" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <div class="nav-info-header">
                    <h4 class="modal-title"><span>Dodaj nowy film</span></h4>
                </div>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label for="inputName">Nazwa</label>
                    <input type="text" class="form-control" id="inputName" placeholder="Nazwa filmu" required/>
                </div>
                <div class="form-group">
                    <label for="inputDescription">Opis</label>
                    <textarea id="inputDescription" class="form-control" name="description" rows="4"
                              cols="50" required></textarea>
                </div>
                <div class="form-group">
                    <label for="inputGenre">Rodzaj</label>
                    <select name="genre" class="form-control" id="inputGenre"></select>
                </div>
                <div class="form-group">
                    <label for="inputDuration">Długość</label>
                    <input type="text" class="form-control" id="inputDuration" required>
                </div>
                <div class="form-group">
                    <label for="inputUrl">Url obrazka</label>
                    <input type="text" class="form-control" id="inputUrl" required>
                </div>
                <div class="form-group">
                    <label for="inputDirector">Reżyser</label>
                    <input type="text" class="form-control" id="inputDirector" required>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Zamknij</button>
                <button type="submit" class="btn btn-success" id="saveMovieButton">Zapisz</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</form>
