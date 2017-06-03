
function form2Json(fm) {
    var param = {};
    $.each(fm.serializeArray(), function (i, field) {
        param[field.name] = field.value;
    });

    return param;
}

function showAlert(message) {
    $.messager.alert(
        "提示", message
    );
}

function show(message) {
    $.messager.show(
    {
        title:'提示',
        msg: message,
        timeout:5000,
        showType:'slide'
    }
    );
}