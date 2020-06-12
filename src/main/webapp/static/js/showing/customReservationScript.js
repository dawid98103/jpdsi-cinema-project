$(document).ready(() => {
    initializeModal();
})

function initializeButtonWithId(reservationId) {
    $('#confirmButton').on('click', () => {
        deleteReservation(reservationId);
    })
}

function initializeModal() {
    $('#confirmModal').on('show.bs.modal', (e) => {
        let reservationId = $(e.relatedTarget).data('id');
        initializeButtonWithId(reservationId);
    })
}

function deleteReservation(reservationId) {
    $.ajax({
        type: "DELETE",
        url: `/showing/reservation/${reservationId}`,
        dateType: "json",
        contentType: "application/json; charset=utf-8",
        success: (data, status) => {
            $('#confirmModal').modal('hide');
            $('.top-right').notify({
                message: {
                    text: "Pomyślnie usunięto rezerwację!  "
                }
            }).show();
            setTimeout(() => {
                location.reload();
            }, 2000);
        },
        error: (xhr, status, error) => {
            console.log(xhr);
        }
    })
}
