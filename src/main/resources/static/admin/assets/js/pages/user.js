$(document).ready(function() {

    // 填充博文列表信息
    $.ajax({
        type: "get",
        url: "http://localhost:8080/api/admin/getAllUser",
        dataType: "json",
        success: function(json) {
            var id = 1;
            $.each(json, function(i, item) {
                $('#tbody-users').append(
                    '<tr>' +
                    '<td>' + (id++) + '</td>' +
                    '<td>' + item.name + '</td>' +
                    '<td>' + item.account + '</td>' +
                    '<td>' + item.lastLoginTime + '</td>' +
                    '<td>' + (item.role == 3 ? "游客" : "管理员") + '</td>' +
                    '<td>' +
                    '<button class="btn btn-success" onclick="updateUser(' + item.id + ')">' +
                    '<i class="fa fa-edit"></i> 编辑</button> ' +
                    '<button class="btn btn-danger" onclick="deleteUser(' + item.id + ')">' +
                    '<i class="fa fa-trash-o"> 删除</i></button></td>' +
                    '</tr>'
                );
            });
            $('#dataTables-users').dataTable();

        }
    });

});

// 删除按钮点击
function deleteUser(id) {
    $('#confirmBtn').attr("userId", id);
    $('#myModal').modal();
};

// 确认删除按钮点击
$('#confirmBtn').click(function() {
    var id = $(this).attr("userId");
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/admin/deleteUser/" + id,
        success: function() {
            location.reload();
        }
    });
});

// 编辑按钮点击
function updateUser(id) {
    // 往模态框填充数据
    $('#updateBtn').attr("userId", id);
    $.ajax({
        type: "get",
        url: "http://localhost:8080/api/admin/getUser/" + id,
        dataType: "json",
        success: function(json) {
            if (json.role == 3) {
                document.getElementById("role3").checked = true;
            } else {
                document.getElementById("role2").checked = true;
            }
        }
    });

    // 显示模态框
    $('#updateModal').modal();
};

// 更新按钮点击事件
$('#updateBtn').click(function() {
    var userId = $('#updateBtn').attr("userId");
    var role;
    if (document.getElementById("role3").checked == true) {
        role = 3;
    } else if (document.getElementById("role2").checked == true) {
        role = 2;
    }
    var user = {
        role: role
    }
    $.ajax({
        type: "PUT",
        url: "http://localhost:8080/api/admin/updateUser/" + userId,
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        data: JSON.stringify(user),
        success: function() {
            location.reload();
        },
        error: function() {
            location.reload();
        }
    });
});

// 增加文章按钮点击事件
$('#addArticleBtn').click(function() {
    var articleTitle = $('#addArticleTitle').val();
    var articleSummary = $("#addArticleSummary").val();
    var articleTop = document.getElementById("addArticleTop").checked;
    var articleCategoryId = $("#addCategories option:selected").attr("categoryId");
    var articlePicture = $('#addArticlePicture').val();
    var articleContent = $('#addArticleContent').val();
    var article = {
        articleInfo: {
            title: articleTitle,
            summary: articleSummary,
            isTop: articleTop
        },
        articleContent: {
            content: articleContent
        }
    }
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/admin/addArticle",
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        data: JSON.stringify(article),
        success: function() {
            location.reload();
        },
        error: function() {
            location.reload();
        }
    });
});