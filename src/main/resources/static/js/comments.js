// 页面初始化：填充数据
window.onload = function() {
    showComments();
};
var js;
// 获取文章评论
function showComments() {
    $.ajax({
        type: "get",
        url: "http://localhost:8080/api/article/getAllComment",
        async: false,
        dataType: "json",
        success: function(json) {
            $.each(json, function(i, item) {
                // 判断该评论是否有效
                if (item.isEffective == false) {
                    return true;
                }
                // 填充文章信息
                var comment = document.querySelector("#articleComment");

                $.ajax({
                    type: "get",
                    url: "http://localhost:8080/api/article/getArticleInfo/" + item.articleInfoId,
                    async: false,
                    dataType: "json",
                    success: function(json2) {
                        comment.content.querySelector("#articleTitle").innerHTML = json2.title;
                        comment.content.querySelector("#articleId").innerHTML = json2.id;
                    }
                });
                comment.content.querySelector("#commentName").innerHTML = item.name;
                comment.content.querySelector("#commentCreatTime").innerHTML = item.createTime;
                comment.content.querySelector("#commentContent").innerHTML = item.content;

                document.getElementById("articleComments").appendChild(articleComment.content.cloneNode(true));
            });
        }
    });
}

function getArticleInfo(id) {
    var jsonstr;
    $.ajax({
        type: "get",
        url: "http://localhost:8080/api/article/getArticleInfo/" + id,
        dataType: "json",
        success: function(json) {
            jsonstr = JSON.stringify(json); // 将post请求获取到的json数据转成字符串
            f(jsonstr);
        }
    });
    return jsonstr;
}

function f(json) {
    js = json;
}

function showArticle(_this) {
    var id = $(_this).siblings("#articleId").text();
    var url = "article.html?articleId=" + id;
    window.location.href = url;
}