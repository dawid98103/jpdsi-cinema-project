$(document).ready(() => {
    initializeDataTable();
    initializeModal();
})

$("#showingTable_filter").css("display", "none");

function initializeDataTable() {
    $("#showingTable").DataTable({
        language: {
            url: "//cdn.datatables.net/plug-ins/1.10.21/i18n/Polish.json"
        },
        ajax: '/showing',
        serverSide: true,
        columns: [
            {
                data: 'showingId'
            },
            {
                data: 'movieName'
            },
            {
                data: 'showingDuration',
                render: (data) => {
                    return data + ' min';
                }
            },
            {
                data: 'showingDate'
            },
            {
                data: null,
                render: (data, type, row) => {
                    return '<button class="btn btn-primary" data-toggle="modal" data-movie-id="' + row.movieId + '" data-movie-name="' + row.movieName + '" data-showing-id="' + row.showingId + '" data-showing-img="' + row.showingImgUrl + '" data-target="#reservationFormModal">' + "Rezerwuj" + '</button>'
                },
                orderable: false,
                searchable: false
            }
        ]
    });
}

function initializeModal() {
    $("#reservationFormModal").on('show.bs.modal', (e) => {
        $("#ticket-type-window").find("li.list-group-item").remove();
        let trHTML = '';
        $.ajax({
            type: "GET",
            url: "/ticket",
            dateType: "json",
            contentType: "application/json; charset=utf-8",
            success: (data, status) => {
                data.forEach(ticket => {
                    let ticketId = ticket.ticketId;
                    let ticketName = ticket.type;
                    trHTML += `<li class="list-group-item">
                                <div class="row">
                                    <div class="col-lg-4">
                                        ${ticketName}
                                    </div>
                                    <div class="col-lg-8">
                                        <div class='inc-dec-container'>
                                            <select class="form-control ticket-quantity" data-ticketId="${ticketId}">
                                                <option>0</option>
                                                <option>1</option>
                                                <option>2</option>
                                                <option>3</option>
                                                <option>4</option>
                                                <option>5</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </li>`
                })
                $(".ticket-type-list").append(trHTML);
            },
            error: (reqeust) => {
                alert(reqeust.responseJSON.message);
            }
        })

        let triggerLink = $(e.relatedTarget)
        let movieId = triggerLink.data("movie-id")
        let movieName = triggerLink.data("movie-name");
        let showingId = triggerLink.data("showing-id");
        let showingImg = triggerLink.data("showing-img");

        $(e.currentTarget).find('.movie-name').text(movieName);
        $(e.currentTarget).find('#modal-img').attr('src', showingImg);

        $("#reservationFormModal").on('submit', (e) => {
            e.preventDefault();
            saveReservation(movieId, showingId);
        })
    });
}

function saveReservation(movieId, showingId) {
    let ticketToAdd = [];
    let counters = $(".ticket-quantity");
    console.log(counters);
    for (let i = 0; i < counters.length; i++) {
        ticketToAdd.push(
            {
                ticketId: counters[i].dataset.ticketid,
                ticketQuantity: counters[i].value
            }
        )
    }

    $.ajax({
        type: "POST",
        url: '/showing/reservation',
        dateType: "json",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify({
            movieId: movieId,
            showingId: showingId,
            ticketList: ticketToAdd
        }),
        success: () => {
            $('.top-right').notify({message: {text: 'Rezerwacja dodana pomyślnie!'}}).show();
            $("#reservationFormModal").modal('hide');
        },
        error: (xhr, status, error) => {
            console.log(xhr);
            $('.top-right').notify({message: {text: "dsds"}}).show();
        }
    })
}