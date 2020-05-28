const showingsErrorAlert = $("#noShowingsError");
const plusButton = $("button.inc-button");
const minusButton = $("button.dec-button");
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

function increaseCounter(counterId) {
    let value = $(`#counter-${counterId}`).val();
    $(`#counter-${counterId}`).val(parseInt(value) + 1);
}

function decreaseCounter(counterId) {
    let value = $(`#counter-${counterId}`).val();
    value -= 1;
    $(`#counter-${counterId}`).val((parseInt(value) < 0) ? 0 : parseInt(value));
}

function getShowingsByDate(startDate, endDate) {
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
                                            <button class='count down_count btn btn-info' title='Down' onclick="decreaseCounter(${ticketId})"><span class="glyphicon glyphicon-minus"/></button>
                                            <input id="counter-${ticketId}" class="counter" data-ticketId="${ticketId}" type="text" placeholder="value..." value='0' />    
                                            <button class='count up_count btn btn-info'  title='Up' onclick="increaseCounter(${ticketId})"><span class="glyphicon glyphicon-plus"/></button>
                                        </div>
                                    </div>
                                </div>
                            </li>`
                })
                $(".ticket-type-list").append(trHTML);
                initializeModalButtons();
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

function saveReservation() {
    let ticketToAdd = [];
    let counters = $(".counter");
    for (let i = 0; i < counters.length; i++) {
        ticketToAdd.push(
            {
                ticketId: counters[i].dataset.ticketid,
                ticketQuantity: counters[i].value
            }
        )
    }
    console.log(ticketToAdd);

    let addReservationRequest = {
        movieId: this.movieId,
        showingId: this.showingId,
        ticketList: ticketToAdd
    }

    $.ajax({
        type: "POST",
        url: '/showing/reservation',
        dateType: "json",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(addReservationRequest),
        success: (response) => {
            console.log(response);
            $('.top-right').notify({message: {text: 'Rezerwacja dodana pomyślnie!'}}).show();
            $("#reservationModal").modal('hide');
        },
        error: (xhr, status, error) => {
            console.log(xhr);
        }
    })
}

function initializeDateTimePicker() {
    $(function () {
        $('input[name="datetimes"]').daterangepicker({
            timePicker: true,
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

function sortTableByName(n) {
    let table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
    table = document.getElementById("showingTable");
    switching = true;
    dir = "asc";
    while (switching) {
        // Start by saying: no switching is done:
        switching = false;
        rows = table.rows;
        /* Loop through all table rows (except the
        first, which contains table headers): */
        for (i = 1; i < (rows.length - 1); i++) {
            // Start by saying there should be no switching:
            shouldSwitch = false;
            /* Get the two elements you want to compare,
            one from current row and one from the next: */
            x = rows[i].getElementsByTagName("TD")[n];
            y = rows[i + 1].getElementsByTagName("TD")[n];
            /* Check if the two rows should switch place,
            based on the direction, asc or desc: */
            console.log("tutej");
            console.log(x.innerHTML);
            console.log(typeof x.innerHTML);
            if (dir == "asc") {
                if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                    // If so, mark as a switch and break the loop:
                    shouldSwitch = true;
                    break;
                }
            } else if (dir == "desc") {
                if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
                    // If so, mark as a switch and break the loop:
                    shouldSwitch = true;
                    break;
                }
            }
        }
        if (shouldSwitch) {
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
            switchcount++;
        } else {
            if (switchcount == 0 && dir == "asc") {
                dir = "desc";
                switching = true;
            }
        }
    }
}

function sortTableByDate(n) {
    let table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
    table = document.getElementById("showingTable");
    switching = true;
    console.log(table);
    // Set the sorting direction to ascending:
    dir = "asc";
    /* Make a loop that will continue until
    no switching has been done: */
    while (switching) {
        // Start by saying: no switching is done:
        switching = false;
        rows = table.rows;
        /* Loop through all table rows (except the
        first, which contains table headers): */
        for (i = 1; i < (rows.length - 1); i++) {
            // Start by saying there should be no switching:
            shouldSwitch = false;
            /* Get the two elements you want to compare,
            one from current row and one from the next: */
            x = rows[i].getElementsByTagName("TD")[n];
            y = rows[i + 1].getElementsByTagName("TD")[n];
            /* Check if the two rows should switch place,
            based on the direction, asc or desc: */
            console.log(typeof x.innerHTML);
            if (dir == "asc") {
                if (new Date(x.innerHTML) > new Date(y.innerHTML)) {
                    // If so, mark as a switch and break the loop:
                    shouldSwitch = true;
                    break;
                }
            } else if (dir == "desc") {
                if (new Date(x.innerHTML) < new Date(y.innerHTML)) {
                    // If so, mark as a switch and break the loop:
                    shouldSwitch = true;
                    break;
                }
            }
        }
        if (shouldSwitch) {
            /* If a switch has been marked, make the switch
            and mark that a switch has been done: */
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
            // Each time a switch is done, increase this count by 1:
            switchcount++;
        } else {
            /* If no switching has been done AND the direction is "asc",
            set the direction to "desc" and run the while loop again. */
            if (switchcount == 0 && dir == "asc") {
                dir = "desc";
                switching = true;
            }
        }
    }
}

