$(document).ready(() => {
    $.ajax({
        url: "/",
        type: "GET",
        dataType: "json",
        success: (result) => {
            showMap(result.latitude, result.longitude);
        },
        error: (error) => {

        }
    })
})

function showMap(latitude,longitude) {
    let googleLatandLong = new google.maps.LatLng(latitude, longitude);

    let mapOptions = {
        zoom: 5,
        center: googleLatandLong,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };

    let mapDiv = $("#map");
    map = new google.maps.map(mapDiv, mapOptions);

    let title = "Cinema Locations";
    addMarker(map, googleLatandLong, title, "");
}

function addMarker(map, latlong, title, content) {

    var markerOptions = {
        position: latlong,
        map: map,
        title: title,
        clickable: true
    };
    var marker = new google.maps.Marker(markerOptions);
}