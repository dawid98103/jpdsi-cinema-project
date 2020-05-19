let showingsErrorAlert = $("#noShowingsError");
let movieId = 0;
let showingId = 0;

Date.prototype.addDays = function (days) {
    var date = new Date(this.valueOf());
    date.setDate(date.getDate() + days);
    return date;
}

$("#success-alert").hide();

$(document).ready(() => {
    initializeModal();
    initializeButtons();
    getShowingsByDate(new Date().getTime(), new Date().addDays(7).getTime());
    initializeDateTimePicker();
})

function initializeButtons() {
    let test = $(".reservationButton");
    console.log(test);
    $("#reservationButton").click(() => {
        console.log("tutaj");
        let ticketQuantity = parseInt($("#ticket-quantity").val());
        let ticketId = parseInt($("#ticket-type").val());
        saveReservation({
            "movieId": this.movieId,
            "ticketId": ticketId,
            "showingId": this.showingId,
            "ticketQuantity": ticketQuantity
        });
    });
}

function getShowingsByDate(startDate, endDate) {
    console.log(startDate);
    console.log(endDate);
    $.ajax({
        type: "GET",
        url: `/showing/repertoire/${startDate}/${endDate}`,
        dateType: "json",
        contentType: "application/json; charset=utf-8",
        success: (data, status) => {
            $("#showingTable").find("tr:not(:first)").remove();
            let trHTML = '';
            data.forEach(showing => {
                showing.movies.forEach(movie => {
                    let movieId = movie.movieId;
                    let showingId = showing.showingId;
                    trHTML += `
                        <tr class="basic-trows"><td class="align-middle">${movie.movieName}</td>
                        <td class="basic-tdata">${showing.showingDate}</td>
                        <td class="class="basic-tdata""><a type="button" 
                        class="btn btn-success" 
                        id="showModal" 
                        data-toggle="modal" 
                        href="#reservationModal" 
                        data-movie-id="${movieId}" 
                        data-showing-id="${showingId}" 
                        data-movie-date="${showing.showingDate}"
                        data-movie-name="${movie.movieName}"
                        data-movie-photo="${movie.movieSmallUrl}">Rezerwuj</a></td>
                        </tr>`
                })
            })
            $("#showingTable tbody").append(trHTML);

            (data.length === 0) ? showingsErrorAlert.removeClass("hidden") : showingsErrorAlert.addClass("hidden");
        },
        error: (request, ajaxOptions, error) => {
            console.log(request.responseJSON.message);
            alert(request.responseText);
        }
    })
}

function initializeModal() {
    $("#reservationModal").on('show.bs.modal', (e) => {
        console.log("blabal")
        $('#ticket-type').find("option").remove();
        $.ajax({
            type: "GET",
            url: "/ticket",
            dateType: "json",
            contentType: "application/json; charset=utf-8",
            success: (data, status) => {
                console.log("success");
                console.log(data);
                data.forEach(ticket => {
                    let option = new Option(ticket.type, ticket.ticketId)
                    $(option).html(ticket.type);
                    $('#ticket-type').append(option);
                })
                console.log($("#ticket-type").val());
            },
            error: (reqeust) => {
                alert(reqeust.responseJSON.message);
            }
        })

        this.movieId = $(e.relatedTarget).data('movie-id');
        this.showingId = $(e.relatedTarget).data('showing-id');
        let movieName = $(e.relatedTarget).data('movie-name');
        let showingDate = $(e.relatedTarget).data('movie-date');
        let moviePhoto = $(e.relatedTarget).data('movie-photo');

        $(e.currentTarget).find('span.movie-name').text(movieName);
        $(e.currentTarget).find('span.movie-date').text(showingDate);
        $(e.currentTarget).find('#modal-img').attr('src', moviePhoto);
    });
}

function saveReservation(reservationModel) {
    console.log("tutej");
    $.ajax({
        type: "POST",
        url: '/showing/reservation',
        dateType: "json",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(reservationModel),
        success: (response) => {
            $('.top-right').notify({message: {text: 'Rezerwacja dodana pomyślnie!'}}).show();
            $("#reservationModal").modal('hide');
        },
        error: (xhr, status, error) => {
            alert(xhr.responseJSON.message);
        }
    })
}

function initializeDateTimePicker() {
    $(function() {
        $('input[name="datetimes"]').daterangepicker({
            timePicker:true,
            timePicker24Hour: true,
            startDate: new Date(),
            endDate: new Date().addDays(7),
            locale: {
                format: 'DD-MM-YYYY HH:mm',
                separator: " - ",
                applyLabel: "Wybierz",
                cancelLabel: "Anuluj",
                fromLabel: "Od",
                toLabel: "Do",
                daysOfWeek: [
                    "Pon",
                    "Wt",
                    "Sr",
                    "Czw",
                    "Pn",
                    "Sb",
                    "Nd"
                ],
                monthNames: [
                    "Styczen",
                    "Luty",
                    "Marzec",
                    "Kwiecien",
                    "Maj",
                    "Czerwiec",
                    "Lipiec",
                    "Sierpien",
                    "Wrzesien",
                    "Pazdziernik",
                    "Listopad",
                    "Grudzien"
                ]
            }
        });
    });

    $('input[name="datetimes"]').on('apply.daterangepicker', (ev, picker) => {
        let parsedStartDate = Date.parse(picker.startDate._d);
        let parsedStartEnd = Date.parse(picker.endDate._d);
        getShowingsByDate(parsedStartDate, parsedStartEnd);
    })
}

