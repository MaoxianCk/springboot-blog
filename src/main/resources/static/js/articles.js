// 页面初始化：填充数据
window.onload = function() {
    showAllArticleInfo();
};

// 显示全部文章信息
function showAllArticleInfo() {
    $.ajax({
        type: "get",
        url: "http://localhost:8080/api/article/showAllArticleInfo",
        dataType: "json",
        success: function(json) {
            $.each(json, function(i, item) {
                // 填充文章信息
                var articleInfo = document.querySelector("#articleInfo");
                articleInfo.content.querySelector("#id").innerHTML = item.id;
                articleInfo.content.querySelector("#articleTitle").innerHTML = item.title;
                articleInfo.content.querySelector("#articleCreateTime").innerHTML = item.createTime;
                articleInfo.content.querySelector("#articleSummary").innerHTML = item.summary;

                document.getElementById("articleInfos").appendChild(articleInfo.content.cloneNode(true));
            });
        }
    });
}

// 跳转到指定文章
function showArticle(_this) {
    var articleId = $(_this).children("h6").text();
    var url = "article.html?articleId=" + articleId;
    window.location.href = url;
}