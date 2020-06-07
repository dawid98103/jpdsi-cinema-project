$(document).ready(() => {
    initializeDataTable();
})

function initializeDataTable() {
    $("#rankingTable").DataTable({
        language: {
            url: "//cdn.datatables.net/plug-ins/1.10.21/i18n/Polish.json"
        },
        ajax: '/movie',
        serverSide: true,
        columns: [
            {
                data: 'movieId'
            },
            {
                data: 'movieSmallUrl',
                render: (data) => {
                    return `<img src=${data} width="100px">`;
                }
            },
            {
                data: 'movieName'
            },
            {
                data: 'averageRate',
            }
        ]
    })
}
