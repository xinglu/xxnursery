var Script = function () {

    $(function () {
        // Tags Input
        $(".tagsinput").tagsInput();

        // Switch
        $("[data-toggle='switch']").wrap('<div class="switch" />').parent().bootstrapSwitch();

    });

    $("#btn_sub").click(function () {
        $.post("/manage/recruit/recruitInfo", $("#recruitForm").serialize(), function (data) {
            if (data.success) {
                //更新成功
                if (confirm(data.message + "!" +
                    "是否返回？")) {
                    //获取当前页面的URL
                    // var url = window.location.pathname
                    window.history.go(-1);
                }
            } else {
                //更新失败
                alert(data.message + "")
            }
        });
    });

    $("#btn_pro").click(function () {
        $.post("/manage/consumer/putConsumer", $("#proFrom").serialize(), function (data) {
            if (data.success) {
                //更新成功
                if (confirm(data.message + "!" +
                    "是否返回？")) {
                    //获取当前页面的URL
                    // var url = window.location.pathname
                    window.history.go(-1);
                }
            } else {
                //更新失败
                alert(data.message + "")
            }
        });
    });

    //根据传递过来的参数name获取对应的值
    function getParameter(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        var r = location.search.substr(1).match(reg);
        if (r != null) return (r[2]);
        return null;
    };
}();