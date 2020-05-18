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
    getShowingsByDate(new Date(), new Date().addDays(7));
    initializeDatePicker();
})

(function setDatePickerDates(){
    let datePickerFrom = $('#from');
    datePickerFrom.datepicker();
    datePickerFrom.datepicker('setDate', new Date());

    let datePickerTo = $('#to');
    datePickerTo.datepicker();
    datePickerTo.datepicker('setDate', new Date().addDays(7));
}());

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
    let dateFrom = (startDate != null) ? startDate.getTime() : new Date($("#from").val()).getTime();
    let dateTo = (endDate != null) ? endDate.getTime() : new Date($("#to").val()).getTime();

    console.log(dateFrom);
    console.log(dateTo);

    $.ajax({
        type: "GET",
        url: `/showing/repertoire/${dateFrom}/${dateTo}`,
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
                    console.log(ticket);
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

function initializeDatePicker() {
    $(function () {
        let dateFormat = "dd/mm/yy",
            from = $("#from").datepicker({
                defaultDate: new Date(),
                dateFormat: 'yy-mm-dd',
                changeMonth: true,
                numberOfMonths: 1,
            })
                .on("change", function () {
                    to.datepicker("option", "minDate", getDate(this));
                }),
            to = $("#to").datepicker({
                defaultDate: 7,
                dateFormat: 'yy-mm-dd',
                changeMonth: true,
                numberOfMonths: 1,
            })
                .on("change", function () {
                    from.datepicker("option", "maxDate", getDate(this));
                });

        function getDate(element) {
            let date;
            try {
                date = $.datepicker.parseDate(dateFormat, element.value);
            } catch (error) {
                date = null;
            }
            return date;
        }
    });
}

