$('#logout').click(function() {
    alert("已退出");
    $.cookie('account', null, {
        path: '/'
    });
});

window.onload = function() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/admin/checkUser",
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        success: function(json) {
            if (json == true) {
                $('#user-manage').show();
            }
        }
    });
}