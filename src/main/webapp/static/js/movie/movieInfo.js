const movieId = $('#rate-input').data("movie-id");
const captions = {
    0.5: 'Zły',
    1: 'Słaby',
    1.5: 'Zły',
    2: 'Średni',
    2.5: 'Zły',
    3: 'Dobry',
    3.5: 'Zły',
    4: 'Bardzo Dobry',
    4.5: 'Four & Half Stars',
    5: 'Arcydzieło!'
}

$(document).ready(() => {
    initializeStarRating();
    loadInitRate();
    initializeRateInput();
})

function initializeStarRating() {
    console.log(sessionStorage.getItem('status'))
    $('#rate-input').rating({
        min: 0,
        max: 5,
        step: 1,
        showCaption: false,
        showClear: false,
        starCaptions: captions,
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