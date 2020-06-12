$(document).ready(() => {
    initializeTable();
})

function initializeTable() {
    $("#usersManageTable").DataTable({
        language: {
            url: "//cdn.datatables.net/plug-ins/1.10.21/i18n/Polish.json"
        },
        ajax: '/user',
        info: false,
        pageLength: 50,
        serverSide: true,
        columns: [
            {
                data: 'id'
            },
            {
                data: 'username'
            },
            {
                data: 'email'
            },
            {
                data: 'roles',
                render: "[, ].roleName"
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
        order: [[3, "desc"]]
    });
}