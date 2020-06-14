let dataTable;

$(document).ready(() => {
    initializeTable();
    initializeModals();
})

function initializeTable() {
    this.dataTable = $("#moviesManageTable").DataTable({
        language: {
            url: "//cdn.datatables.net/plug-ins/1.10.21/i18n/Polish.json"
        },
        ajax: '/movie',
        info: false,
        pageLength: 50,
        serverSide: true,
        columns: [
            {
                data: "movieId"
            },
            {
                data: 'movieName'
            },
            {
                data: 'genre.genreName'
            },
            {
                data: 'averageRate',
            },
            {
                orderable: false,
                searchable: false,
                render: (data, type, row) => {
                    return (
                        `<button class="btn btn-danger btn-sm" data-id="${row.movieId}" data-target="#confirmModal" data-toggle="modal"> <i class="fas fa-minus"></i> </button>
                         <button class="btn btn-warning btn-sm open-edit-dialog" data-id="${row.movieId}" data-target="#createMovieModal" data-toggle="modal"> <i class="far fa-edit"></i> </button>
                         <button class="btn btn-info btn-sm" data-id="${row.movieId}" data-name="${row.movieName}" data-img="${row.movieSmallUrl}" data-target="#createShowingModal" data-toggle="modal"><i class="far fa-calendar-plus"></i></button>`
                    );
                }
            }
        ],
    });
}

function initializeModals() {
    $(document).on("click", ".open-create-dialog", (event) => {
        $("#inputGenre").find('option').remove();
        $.ajax({
            type: "GET",
            url: "/genre",
            dataType: "JSON",
            contentType: "application/json; charset=utf-8",
            success: (data, status) => {
                $.each(data, function (key, value) {
                    $('#inputGenre')
                        .append($('<option>', {value: value.genreId})
                            .text(value.genreName));
                });
                initializeSubmit(0);
            },
            error: (response) => {
                console.log(response);
            }
        })
    })

    $(document).on("click", ".open-edit-dialog", (event) => {
        let movieId = $(event.target).data('id');
        $("#inputGenre").find('option').remove();
        $.ajax({
            type: "GET",
            url: "/genre",
            dataType: "JSON",
            contentType: "application/json; charset=utf-8",
            success: (data, status) => {
                $.each(data, function (key, value) {
                    $('#inputGenre')
                        .append($('<option>', {value: value.genreId})
                            .text(value.genreName));
                });
                $.ajax({
                    type: "GET",
                    url: `/movie/${movieId}`,
                    dataType: "JSON",
                    contentType: "application/json; charset=utf-8",
                    success: (data, status) => {
                        $("#inputName").val(data.movieName);
                        $("#inputDescription").val(data.movieDescription)
                        $("#inputDuration").val(data.movieDuration)
                        $("#inputUrl").val(data.movieSmallUrl)
                        $("#inputDirector").val(data.movieDirector)
                        $("#inputGenre").val(data.genre.genreId)
                    },
                    error: (response) => {
                        console.log(response);
                    }
                })
                initializeSubmit(movieId);
            },
            error: (response) => {
                console.log(response);
            }
        })
    })

    $("#confirmModal").on('show.bs.modal', (e) => {
        console.log("delete");
        let triggerLink = $(e.relatedTarget);
        let movieId = (triggerLink.data("id"));
        initializeDelete(movieId);
    })

    $("#createShowingModal").on('show.bs.modal', (e) => {
        let triggerLink = $(e.relatedTarget);
        let movieId = triggerLink.data("id");
        let movieName = triggerLink.data("name");
        let movieImg = triggerLink.data("img");

        $(e.currentTarget).find('#movie-name').text(movieName);
        $(e.currentTarget).find('#modal-img').attr('src', movieImg);

        initializeShowing(movieId);
    })
}

function initializeShowing(movieId) {

}

function initializeSubmit(movieId) {
    $("#saveMovieButton").on('click', (event) => {
        event.preventDefault();
        $.ajax({
            type: "POST",
            url: "/movie",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify({
                movieId: movieId,
                movieName: $("#inputName").val(),
                movieDescription: $("#inputDescription").val(),
                movieDuration: parseInt($("#inputDuration").val(), 10),
                movieSmallUrl: $("#inputUrl").val(),
                movieDirector: $("#inputDirector").val(),
                genreId: parseInt($("#inputGenre").val(), 10)
            }),
            success: (status) => {
                $("#createMovieModal").modal('hide');
                $('.top-right').notify({message: {text: 'Operacja wykonana pomyślnie!'}}).show();
                this.dataTable.ajax.reload();
            },
            error: (response) => {
                $('.top-right').notify({
                    message: {text: 'Wystąpił nieoczekiwany bład!'},
                    type: "danger"
                }).show();
                $("#confirmModal").modal('hide');
                this.dataTable.ajax.reload();
            }
        })
    })
}

function initializeDelete(movieId) {
    console.log(movieId);
    $("#confirmModal").on('submit', (event) => {
        event.preventDefault();
        $.ajax({
            type: "DELETE",
            url: `/movie/${movieId}`,
            success: () => {
                $('.top-right').notify({message: {text: 'Rezerwacja usunięta pomyślnie!'}}).show();
                $("#confirmModal").modal('hide');
                this.dataTable.ajax.reload();
            },
            error: (xhr, status, error) => {
                $('.top-right').notify({
                    message: {text: 'Wystąpił nieoczekiwany bład!'},
                    type: "danger"
                }).show();
                $("#confirmModal").modal('hide');
                this.dataTable.ajax.reload();
            }
        })
    })
}

