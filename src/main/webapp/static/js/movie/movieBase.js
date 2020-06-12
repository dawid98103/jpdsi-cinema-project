function format(d) {
    // `d` is the original data object for the row
    return `
    <table cellpadding="10" cellspacing="10" border="0" style="padding-left:50px; border-collapse: separate; border-spacing:0 15px"> 
        <tr> 
            <td>Opis: </td> 
            <td> ${d.movieDescription} </td> 
        </tr>
        <tr> 
            <td></td> 
            <td>
                 <a href="#" class="thumbnail">
                    <img src="${d.movieSmallUrl}" width="15%" height="20%"/>
                </a>
            </td> 
        </tr> 
        <tr> 
            <td></td> 
            <td>
                <a href="/movie/info/${d.movieId}" class="btn btn-info">Więcej</a>
            </td> 
        </tr> 
    </table>
`
}

$(document).ready(() => {
    initializeDataTable();
});

function initializeDataTable() {
    let table = $("#movieTable").DataTable({
        language: {
            url: "//cdn.datatables.net/plug-ins/1.10.21/i18n/Polish.json"
        },
        ajax: '/movie',
        serverSide: true,
        columns: [
            {
                className: 'details-control',
                orderable: false,
                searchable: false,
                data: null,
                defaultContent: '',
                render: () => {
                    return '<i class="fa fa-plus-square" aria-hidden="true"></i>';
                },
            },
            {
                data: 'movieName'
            },
            {
                data: 'genre.genreName'
            },
            {
                data: 'averageRate',
            }
        ],
        order: [[3, "desc"]]
    });

    $('#movieTable tbody').on('click', 'td.details-control', event => {
        let tr = $(event.target).closest("tr");
        let tdi = tr.find("i.fa");
        let row = table.row(tr);

        if (row.child.isShown()) {
            row.child.hide();
            tr.removeClass('shown');
            tdi.first().removeClass('fa-minus-square');
            tdi.first().addClass('fa-plus-square');
        } else {
            row.child(format(row.data())).show();
            tr.addClass('shown');
            tdi.first().removeClass('fa-plus-square');
            tdi.first().addClass('fa-minus-square');
        }
    });
    //
    // table.on("user-select", function (e, dt, type, cell, originalEvent) {
    //     if ($(cell.node()).hasClass("details-control")) {
    //         e.preventDefault();
    //     }
    // });
}

