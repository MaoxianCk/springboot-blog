// 根据ID填充评论列表的信息
$(document).ready(function() {
    $.ajax({
        type: "get",
        url: "http://localhost:8080/api/admin/getAllComment",
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        async: false,
        success: function(json) {
            var id = 1;
            $.each(json, function(i, item) {
                var title;
                $.ajax({
                    type: "get",
                    url: "http://localhost:8080/api/article/getArticleInfo/" + item.articleInfoId,
                    dataType: "json",
                    contentType: "application/json;charset=utf-8",
                    async: false,
                    success: function(json) {
                        title = json.title;
                    }
                })
                $('#tbody-comments').append(
                    '<tr>' +
                    '<td>' + (id++) + '</td>' +
                    '<td>' + title + '</td>' +
                    '<td>' + item.content + '</td>' +
                    '<td>' + item.name + '</td>' +
                    '<td>' + item.createTime + '</td>' +
                    '<td>' + item.isEffective + '</td>' +
                    '<td>' +
                    '<button class="btn btn-success" onclick="updateArticleComment(\'' + item.id + '\')">' +
                    '<i class="fa fa-edit"></i>' +
                    ' 编辑' +
                    '</button>' +
                    '<button class="btn btn-danger deleteBtn" style="margin-left:3px;" onclick="deleteArticleComment(\'' + item.id + '\')">' +
                    '<i class="fa fa-trash-o">' +
                    ' 删除' + '</i>' +
                    '</button>' +
                    '</td>' +
                    '</tr>');
            });
            $('#dataTables-comments').dataTable();
        }
    });
});

// 编辑按钮点击事件
function updateArticleComment(id) {
    $.ajax({
        type: "get",
        url: "http://localhost:8080/api/admin/getComment/" + id,
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        async: false,
        success: function(json) {
            if (json.isEffective == true) {
                document.getElementById("commentIsEffective").checked = true;
            }
        }
    });
    $('#updateBtn').attr("articleCommentId", id);
    $('#updateModal').modal();
};

// 确认编辑按钮点击事件
$('#updateBtn').click(function() {
    var id = $(this).attr("articleCommentId");
    var articleComment = {
        isEffective: document.getElementById("commentIsEffective").checked
    }
    $.ajax({
        type: "PUT",
        url: "http://localhost:8080/api/admin/updateComment/" + id,
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        data: JSON.stringify(articleComment),
        success: function() {
            // 刷新页面
            location.reload();
        },
        error: function() {
            location.reload();
        }
    });
});

// 删除按钮点击事件
function deleteArticleComment(id) {
    $('#confirmBtn').attr("articleCommentId", id);
    $('#myModal').modal();
};

// 确认删除按钮点击事件
$('#confirmBtn').click(function() {
    var id = $(this).attr("articleCommentId");
    //	alert(id);
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/admin/deleteComment/" + id,
        success: function() {
            // 刷新页面
            location.reload();
        },
        error: function() {
            location.reload();
        }
    });
});