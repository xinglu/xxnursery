var Script = function () {
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
}();