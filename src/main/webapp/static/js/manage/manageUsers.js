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
            }
        ],
        order: [[3, "desc"]]
    });
}