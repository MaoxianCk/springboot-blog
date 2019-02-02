$(document).ready(function() {

    // 填充浏览数据
    $.ajax({
        url: "http://localhost:8080/api/admin/getAllUser",
        type: "GET",
        dataType: "json",
        success: function(json) {
            $('#count-visits').append(json.length)
            var id = 1;
            $.each(json, function(i, item) {
                $('#tbody-visits').append(
                    '<tr>' +
                    '<td>' + (id++) + '</td>' +
                    '<td>' + item.name + '</td>' +
                    '<td>' + item.lastLoginTime + '</td>' +
                    '</tr>');
            });
            $('#dataTables-visits').dataTable();
        }
    });

    // 填充评论数据
    $.ajax({
        url: "http://localhost:8080/api/admin/getAllComment",
        type: "GET",
        dataType: "json",
        success: function(json) {
            $('#count-comments').append(json.length)
            var id = 1;
            $.each(json, function(i, item) {
                $('#tbody-comments').append(
                    '<tr>' +
                    '<td>' + (id++) + '</td>' +
                    '<td>' + item.content + '</td>' +
                    '<td>' + item.createTime + '</td>' +
                    '<td>' + item.name + '</td>' +
                    '<td>' + item.isEffective + '</td>' +
                    '<td>' +
                    '<button class="btn btn-danger deleteBtn" onclick="deleteComment(\'' + item.id + '\')">' +
                    '<i class="fa fa-trash-o"></i>' +
                    '删除' +
                    '</button>' +
                    '</td>' +
                    '</tr>');

            });
            $('#dataTables-comments').dataTable();
        }
    });

});

// 删除评论
function deleteComment(id) {
    $('#confirmBtn').attr("commentId", id);
    $('#myModal').modal();
};

// 确认删除留言点击事件
$('#confirmBtn').click(function() {
    var id = $(this).attr("commentId");
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/admin/deleteComment/" + id,
        success: function() {
            // 刷新页面
            location.reload();
        }
    });
});