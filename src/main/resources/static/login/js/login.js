$('.form').find('input, textarea').on('keyup blur focus', function(e) {

    var $this = $(this),
        label = $this.prev('label');

    if (e.type === 'keyup') {
        if ($this.val() === '') {
            label.removeClass('active highlight');
        } else {
            label.addClass('active highlight');
        }
    } else if (e.type === 'blur') {
        if ($this.val() === '') {
            label.removeClass('active highlight');
        } else {
            label.removeClass('highlight');
        }
    } else if (e.type === 'focus') {

        if ($this.val() === '') {
            label.removeClass('highlight');
        } else if ($this.val() !== '') {
            label.addClass('highlight');
        }
    }

});

$('.tab a').on('click', function(e) {

    e.preventDefault();

    $(this).parent().addClass('active');
    $(this).parent().siblings().removeClass('active');

    target = $(this).attr('href');

    $('.tab-content > div').not(target).hide();

    $(target).fadeIn(600);

});

// 登录
$('#sign-in').click(function() {
    var account = $("#account").val();
    var password = $('#password').val();

    // 判断是否为空
    if (account == "" || password == "") {
        return;
    }

    // 不为空才能增加
    var user = {
            account: account,
            password: password
        }
        // 提交AJAX请求
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/login/signIn",
        dataType: "json",
        async: false,
        contentType: "application/json;charset=utf-8",
        data: JSON.stringify(user),
        success: function(json) {
            if (json.msg == "登录成功") {
                if (json.role == "3") {
                    window.location.replace("../../index.html");
                } else if (json.role == "2" || json.role == "1") {
                    window.location.replace("../../admin/index.html");
                }
            } else {
                window.location.replace("login.html");
            }
            return;
        },
        error: function() {
            window.location.replace("login.html");
        }
    })
});

// 注册
$('#sign-up').click(function() {
    var name = $("#newName").val();
    var account = $("#newAccount").val();
    var password = $('#newPassword').val();

    // 判断是否为空
    if (name == "" || account == "" || password == "") {
        return;
    }

    // 不为空才能增加
    var user = {
            name: name,
            account: account,
            password: password
        }
        // 提交AJAX请求
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/login/signUp",
        dataType: "json",
        async: false,
        contentType: "application/json;charset=utf-8",
        data: JSON.stringify(user),
        success: function(json) {
            alert(json.msg);
            if (json.msg == "注册成功") {
                if (json.role == "3") {
                    window.location.replace("../../index.html");
                } else if (json.role == "2" || json.role == "1") {
                    window.location.replace("../../admin/index.html");
                }
            } else {
                window.location.replace("login.html");
            }
            return;
        },
        error: function() {
            window.location.replace("login.html");
        }
    })
});