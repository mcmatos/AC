window.onload = function () {

    var ajax;

    if (window.XMLHttpRequest) {
        ajax = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        ajax = new ActiveXObject('Microsoft.XMLHTTP');
    }
    
    ajax.onreadystatechange = function () {
        
        if (ajax.readyState === 4 && ajax.status === 200) {
            customerData = JSON.parse(ajax.responseText);
            populate(customerData);
        }
    };

    ajax.open('GET', 'http://localhost:8080/javabank1/json/customer', true);
    ajax.send();
}


function populate(customerData) {
    
    var table = document.getElementById('users-table');
    console.log(table);
    var arr = customerData.map(function (value) {
        var newValue = value;
        delete newValue.id;
        delete newValue.version;
        delete newValue.creationTime;
        delete newValue.updateTime;
        return newValue;
    });

    for (let i = 0; i < arr.length; i++) {
        var entry = table.insertRow();
        func(entry, arr[i]);
    };
}

function func(entry, obj) {

    var arr = Object.values(obj);
    for (let j = 0; j < arr.length; j++) {

        var column = entry.insertCell();
        column.innerText = arr[j];
    }
}
