// 页面初始化：填充数据
window.onload = function() {
    showAllArticleInfo();
};

// 显示全部文章信息
function showAllArticleInfo() {
    $.ajax({
        type: "get",
        url: "http://localhost:8080/api/article/getAllArticleInfo",
        dataType: "json",
        success: function(json) {
            $.each(json, function(i, item) {
                // 填充文章信息
                var articleInfo = document.querySelector("#articleInfo");
                articleInfo.content.querySelector("#articleId").innerHTML = item.id;
                articleInfo.content.querySelector("#articleTitle").innerHTML = item.title;
                if (item.isTop == true) {
                    articleInfo.content.querySelector("#articleTitle").innerHTML = "<span id=\"top\">[置顶]</span>" + item.title;
                }
                articleInfo.content.querySelector("#articleCreateTime").innerHTML = item.createTime;
                articleInfo.content.querySelector("#articleSummary").innerHTML = item.summary;

                document.getElementById("articleInfos").appendChild(articleInfo.content.cloneNode(true));
            });
        }
    });
}

// 跳转到指定文章
function showArticle(_this) {
    var id = $(_this).children("#articleId").text();
    var url = "article.html?articleId=" + id;
    window.location.href = url;
}