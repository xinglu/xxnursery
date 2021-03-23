var Script = function () {
    var todayDate = new Date();
    var year = todayDate.getFullYear();
    var date = todayDate.getDate() + "";
    if (date.length == 1) {
        date = "0" + date;
    }
    var month = todayDate.getMonth() + 1 + "";
    if (month.length == 1) {
        month = "0" + month;
    }
    var hour = todayDate.getHours() + "";
    if (hour.length == 1) {
        hour = "0" + hour;
    }
    var mininutes = todayDate.getMinutes() + "";
    if (mininutes.length == 1) {
        mininutes = "0" + mininutes;
    }
    var seconds = todayDate.getSeconds() + "";
    if (seconds.length == 1) {
        seconds = "0" + seconds;
    }
    var ran = Math.round((Math.random()) * 10000);
    var liushui = "" + year + "" + month + "" + date + "" + hour + "" + mininutes + "" + seconds +""+ ran;
    $("input[name='liushui']").val(liushui);
    //校验密码
    function checkPassword() {
        //1.获取密码值
        var password = $("#password").val();
        //2.定义正则
        var reg_password = /^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]).{8,20}$/;
        var flag = reg_password.test(password);
        if (flag) {
            $("#password").css("border", "");
        } else {
            alert("填写正确的密码信息!!");
            $("#password").css("border", "1px solid red");
        }
        return flag;
    }

    function checkVerifyPass() {
        var password = $("#password").val();
        var verifyPass = $("#verifyPass").val();
        var flag = false;
        if (password == verifyPass) {
            flag = true;
        }
        if (flag) {
            $("#verifyPass").css("border", "");
        } else {
            alert("请和输入的密码一致！！")
            $("#verifyPass").css("border", "1px solid red");
        }
        return flag;
    }

    $("#registForm").submit(function () {
        if (checkPassword() && checkVerifyPass()) {
            $.post("/consumer/register", $("#registForm").serialize(), function (data) {
                if (data.success) {
                    //注册成功
                    if (confirm(data.message + "!" +
                        "是否，直接登录")) {
                        //获取当前页面的URL
                        // var url = window.location.pathname
                        window.history.go(-1);
                    }
                } else {
                    //更新失败
                    alert(data.message + "")
                }
            });
        }
        return false;
    });
    $("#password").blur(checkPassword);
    $("#verifyPass").blur(checkVerifyPass);


    //登录
    $("#loginForm").submit(function () {
        var liushui = $("input[name='liushui']").val();
        $.post("/consumer/login", $("#loginForm").serialize(), function (data) {
            var message =  data.message;
            var code = data.code;
            var success = data.success;
            if (message=="操作成功！" || code == 10000 || success == true) {
                location.href = '/index?number='+liushui;
            } else {
                alert(data.message);
            }
        });
    });
}();