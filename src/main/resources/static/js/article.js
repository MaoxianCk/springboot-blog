// 页面初始化：填充数据
window.onload = function() {
    var articleId = getQueryVariable();
    showArticle(articleId);
    showComment(articleId);
};

// 显示文章信息
function showArticle(articleId) {
    $.ajax({
        type: "get",
        url: "http://localhost:8080/api/article/getArticle/" + articleId,
        dataType: "json",
        success: function(json) {
            $("#articleTitle").html(json.articleInfo.title);
            $("#articleCreateTime").html(json.articleInfo.createTime);
            $("#articleContent").html(json.articleContent.content);
        }
    });
}
// 显示文章评论
function showComment(articleId) {
    $.ajax({
        type: "get",
        url: "http://localhost:8080/api/article/getComment/" + articleId,
        dataType: "json",
        success: function(json) {
            $.each(json, function(i, item) {
                // 判断该评论是否有效
                if (item.isEffective == false) {
                    return true;
                }
                // 填充文章信息
                var articleInfo = document.querySelector("#articleComment");
                articleInfo.content.querySelector("#commentName").innerHTML = item.name;
                articleInfo.content.querySelector("#commentCreatTime").innerHTML = item.createTime;
                articleInfo.content.querySelector("#commentContent").innerHTML = item.content;

                document.getElementById("articleComments").appendChild(articleComment.content.cloneNode(true));
            });
        }
    });
}

// 解析url获取当前id
function getQueryVariable() {
    var query = window.location.search.substring(1);
    var pair = query.split("=");
    for (var i = 0; i < pair.length; i++) {
        var ans = parseInt(pair[i]); //如果变量val是字符类型的数则转换为int类型 如果不是则ival为NaN
        if (!isNaN(ans)) {
            return ans;
        }
    }
    return (false);
}


// 增加评论
$('#addComment').click(function() {
    var articleId = getQueryVariable();
    var name = $("#newCommentName").val();
    var content = $('#newCommentContent').val();

    // 判断是否为空
    if (name == "" || content == "") {
        $('#modal').modal();
        return;
    }

    // 不为空才能增加
    var comment = {
            name: name,
            content: content
        }
        // 提交AJAX请求
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/article/postComment/" + articleId,
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        data: JSON.stringify(comment),
        success: function() {
            // 显示成功提示信息
            $('#addModal').modal();
        },
        error: function() {
            $('#addModal').modal();
        }
    })
});

// 模态框确认按钮点击事件
$('#addConfirmBtn').click(function() {
    // 刷新页面
    location.reload();
});