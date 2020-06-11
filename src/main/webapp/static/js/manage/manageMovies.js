$(document).ready(() => {
    initializeTable();
})

function initializeTable() {
    $("#moviesManageTable").DataTable({
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
                        `<button class="btn btn-danger btn-sm"  data-target="#reservationFormModal"> <i class="fas fa-minus"></i> </button>
                         <button class="btn btn-warning btn-sm"> <i class="far fa-edit"></i> </button>
                         <button class="btn btn-success btn-sm"> <i class="fas fa-plus"></i> </button>`
                    );
                },
            }
        ],
    });
}

