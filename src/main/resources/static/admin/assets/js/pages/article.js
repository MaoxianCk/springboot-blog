$(document).ready(function() {

    // 填充博文列表信息
    $.ajax({
        type: "get",
        url: "http://localhost:8080/api/article/getAllArticleInfo",
        dataType: "json",
        success: function(json) {
            var id = 1;
            $.each(json, function(i, item) {
                $('#tbody-articles').append(
                    '<tr>' +
                    '<td>' + (id++) + '</td>' +
                    '<td>' + item.title + '</td>' +
                    '<td>' + item.createTime + '</td>' +
                    '<td>' + item.modifiedTime + '</td>' +
                    '<td>' + item.isTop + '</td>' +
                    '<td>' +
                    '<button class="btn btn-success" onclick="updateArticle(' + item.id + ')">' +
                    '<i class="fa fa-edit"></i> 编辑</button> ' +
                    '<button class="btn btn-danger" onclick="deleteArticle(' + item.id + ')">' +
                    '<i class="fa fa-trash-o"> 删除</i></button></td>' +
                    '</tr>'
                );
            });
            $('#dataTables-articles').dataTable();

        }
    });

});

// 删除按钮点击
function deleteArticle(id) {
    $('#confirmBtn').attr("articleId", id);
    $('#myModal').modal();
};

// 确认删除按钮点击
$('#confirmBtn').click(function() {
    var id = $(this).attr("articleId");
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/admin/deleteArticle/" + id,
        success: function() {
            // 刷新页面
            location.reload();
        }
    });
});

// 编辑文章按钮点击
function updateArticle(id) {
    // 往模态框填充数据
    $('#updateBtn').attr("articleId", id);
    $.ajax({
        type: "get",
        url: "http://localhost:8080/api/article/getArticle/" + id,
        dataType: "json",
        async: false,
        success: function(json) {
            $('#articleTitle').val(json.articleInfo.title);
            $('#articleSummary').val(json.articleInfo.summary);
            if (json.articleInfo.isTop == true) {
                document.getElementById("articleTop").checked = true;
            }
            $('#articleContent').val(json.articleContent.content);
        }
    });

    // 显示模态框
    $('#updateModal').modal();
};

// 更新文章按钮点击事件
$('#updateBtn').click(function() {
    var articleId = $('#updateBtn').attr("articleId");
    var articleTitle = $('#articleTitle').val();
    var articleSummary = $("#articleSummary").val();
    var articleTop = document.getElementById("articleTop").checked;
    var articleContent = $('#articleContent').val();
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
        type: "PUT",
        url: "http://localhost:8080/api/admin/updateArticle/" + articleId,
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