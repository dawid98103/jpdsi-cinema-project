const movieId = $('#rate-input').data("movie-id");

$(document).ready(() => {
    initializeStarRating();
    loadInitRate();
    initializeRateInput();
})

function initializeStarRating() {
    $('#rate-input').rating({
        language: "PLpl",
        min: 0,
        max: 5,
        step: 0.5,
        showCaption: false,
        showClear: false
    });
}

function loadInitRate() {
    $.ajax({
        type: "GET",
        url: `/rate/getRate/${movieId}`,
        dateType: "json",
        contentType: "application/json; charset=utf-8",
        success: (response) => {
            $('#rate-input').rating('update', response);
        },
        error: (xhr) => {
            console.log(xhr);
        }
    })
}

function initializeRateInput() {
    $('#rate-input').on('rating:change', (event, value) => {
        console.log(value);
        $.ajax({
            type: "POST",
            url: "/rate/addRate",
            dateType: "json",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify({"movieId": movieId, "rate": value}),
            success: (response) => {
                $('.top-right').notify({message: {text: response}}).show();
            },
            error: (xhr) => {
                console.log(xhr);
            }
        })
    })
}