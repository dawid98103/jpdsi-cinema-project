let showingsErrorAlert = $("#noShowingsError");

$(document).ready(() => {
    initializeDatePicker();
})

function getShowingsByDate() {
    let dateFrom = new Date($("#from").val()).getTime();
    let dateTo = new Date($("#to").val()).getTime();
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
                    console.log(movieId);
                    console.log(showingId);
                    trHTML += `
                        <tr><td class="align-middle"><h4>${movie.movieName}</h4></td>
                        <td><h4>${showing.showingDate}</h4></td>
                        <td><a type="button" 
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

            $("#reservationModal").on('show.bs.modal', (e) => {
                let movieId = $(e.relatedTarget).data('movie-id');
                let showingId = $(e.relatedTarget).data('showing-id');
                let movieName = $(e.relatedTarget).data('movie-name');
                let showingDate = $(e.relatedTarget).data('movie-date');
                let moviePhoto = $(e.relatedTarget).data('movie-photo')

                $(e.currentTarget).find('span.movie-name').text(movieName);
                $(e.currentTarget).find('span.movie-date').text(showingDate);
                $(e.currentTarget).find('#modal-img').attr('src', moviePhoto);
            });

            (data.length === 0) ? showingsErrorAlert.removeClass("hidden") : showingsErrorAlert.addClass("hidden");
        },
        error: (request, ajaxOptions, error) => {
            console.log(request.responseJSON.message);
            alert(request.responseText);
        }
    })
}

function initializeDatePicker(){
    $(function () {
        let dateFormat = "mm/dd/yy",
            from = $("#from").datepicker({
                defaultDate: new Date(),
                changeMonth: true,
                value: "03/05/2020",
                numberOfMonths: 1,
            })
                .on("change", function () {
                    to.datepicker("option", "minDate", getDate(this));
                }),
            to = $("#to").datepicker({
                defaultDate: 7,
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

// function sendReservationRequest(movieId, showingId) {
//     console.log(movieId);
//     console.log(showingId);
//     $.ajax({
//         type: "GET",
//         url: "/showing/reservationPage",
//         contentType: "application/json",
//         // data: JSON.stringify({
//         //     "movieId": movieId,
//         //     "showingId": showingId
//         // }),
//         success: (data) => {
//             $(".container").html(data);
//         }
//     });
// }

