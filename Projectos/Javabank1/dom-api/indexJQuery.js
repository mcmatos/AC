var editedCustomer;

$(document).ready(function () {


    function successCallback(response) {
        populate(response)
    }

    function errorCallback(request, status, error) { }


    $.ajax({
        url: 'http://localhost:8080/javabank1/json/customer',
        async: true,
        success: successCallback,
        error: errorCallback
    });
});

function populate(response) {

    response.forEach(function (value) {
        add(value)
    });
}

function add(value) {
    $('#users-table').append('<tr id=customer' + value.id + '>' +
        columns([value.firstName, value.lastName, value.email, value.phone], value.id) + '</tr>')
}

function columns(arr, id) {

    return arr.map(function (value) {
        return '<td>' + value + '</td>';
    }).join('') + editButton(id) + deleteButton(id);
}

function createCustomer() {

    function successCallback(response) {
        add(response)
        $('#form')[0].reset();
    }

    function errorCallback(request, status, error) {
        console.log('error')
    }


    $.ajax({
        url: 'http://localhost:8080/javabank1/json/customer/newCustomer',
        type: 'POST',
        data: JSON.stringify({
            [$('#firstName').prop('id')]: $('#firstName').val(),
            [$('#lastName').prop('id')]: $('#lastName').val(),
            [$('#email').prop('id')]: $('#email').val(),
            [$('#phone').prop('id')]: $('#phone').val()
        }),
        async: true,
        contentType: 'application/json',
        success: successCallback,
        error: errorCallback
    });
}


function editButton(id) {
    return '<td><button onclick="editCustomer(' + id + ')" type="button" class="btn btn-success">Edit</button></td>';
}

function deleteButton(id) {
    return '<td><button onclick="deleteCustomer(' + id + ')" type="button" class="btn btn-danger">Delete</button></td>'
}

function reset() {
    $('#form')[0].reset();
    editedCustomer = null;
}

function deleteCustomer(id) {
    function successCallback(response) {
        $('#customer' + id).remove();
        $('#form')[0].reset();
        savedCustomer = null;
    }

    function errorCallback(request, status, error) {
        console.log('error')
    }

    $.ajax({
        url: 'http://localhost:8080/javabank1/json/customer/delete/' + id,
        async: true,
        success: successCallback,
        error: errorCallback
    });
}

function updateCustomer() {

    if (editedCustomer == null) {
        return;
    }

    function successCallback(response) {
        $('#customer' + response.id).html(
            columns([response.firstName, response.lastName, response.email, response.phone], response.id));
        $('#form')[0].reset();
        console.log(response);
    }

    function errorCallback(request, status, error) {
        console.log('error')
    }

    $.ajax({
        url: 'http://localhost:8080/javabank1/json/customer/edit',
        type: 'POST',
        data: JSON.stringify({
            id: editedCustomer.id,
            [$('#firstName').prop('id')]: $('#firstName').val(),
            [$('#lastName').prop('id')]: $('#lastName').val(),
            [$('#email').prop('id')]: $('#email').val(),
            [$('#phone').prop('id')]: $('#phone').val()
        }),
        async: true,
        contentType: 'application/json',
        success: successCallback,
        error: errorCallback
    });
    editedCustomer = null;
}


function editCustomer(id) {

    function successCallback(response) {

        $('#firstName').val(response.firstName);
        $('#lastName').val(response.lastName);
        $('#email').val(response.email);
        $('#phone').val(response.phone);
        editedCustomer = response;
    }

    function errorCallback(request, status, error) {
        console.log('error')
    }

    $.ajax({
        url: 'http://localhost:8080/javabank1/json/customer/' + id,
        async: true,
        success: successCallback,
        error: errorCallback
    });
}

$(document).ready(function () {

    showPage()
});

function showPage() {



    function successCallback(response) {
        $('.animalName').append('<p id="id"><img src="' + animal.photo + '"></p>')
        $('.photoLocation').append('<img src="' + animal.photoLocation + '">')
        $('.animalSpecies').append('<p id="specie">' + animal.species + '</p>')
        $('.family').append('<p id="family">' + animal.family + '</p>')
        $('.rarity').append('<p id=rarity">' + animal.rarity + '</p>')
    }

    function errorCallback(request, status, error) { }


    $.ajax({
        url: 'http://192.168.1.28:8080/instagranimal/api/user/username/animal/',
        async: true,
        success: successCallback,
        error: errorCallback
    });
}