$("#btn_new_more").click(function () {
    window.location.href = "/information/zuixin/1.html";
});
$("#btn_hot_more").click(function () {
    window.location.href = "/information/remen/1.html";
});
$("#btn_recommend_more").click(function () {
    window.location.href = "/information/recommend.html";
});
$("#btn_liulang_more").click(function () {
    var pathname = window.location.pathname;
    var value_arr = pathname.split("/");/*,information,zuixin,1.html*/
    if ('zuixin' == value_arr[2]) {
        liulangMore('zuixin');
    } else if ('remen' == value_arr[2]) {
        //进入热门页面
        liulangMore('remen');
    } else {
        //进入推荐页面
        window.location.href = "/information/recommend.html";
    }
});

function liulangMore(param) {
    var item = '';
    var pathname = window.location.pathname;
    var value_arr = pathname.split("/");
    var value_arr2 = value_arr[3].split(".");/*,1,html*/
    var page1 = value_arr2[0];
    page1 = parseInt(page1, 10) + 1;/*转换+1，进入下页面*/
    param1 = $.uuid;
    $.get("/information/"+param+"/" + param1 + "/" + page1 + ".html",
        function (data) { //获取参数 拼接+
            var dataitem = data.list;
            if (dataitem.length > 0) {
                window.history.pushState({}, 0, 'http://localhost:32226/information/'+param+'/' + page1 + '.html');
                for (var i = 0; i < dataitem.length; i++) {
                    var returnparam = dataitem[i];
                    var item_list = '<div class="notice-items">\n' +
                        '\t<img class="image" src="https://img.bosszhipin.com/beijin/article/cover/20190131/5b35710c800420cab9086d2471805712c6407cb7c39ed9df81ce65de750288b8_s.jpg" alt="...">\n' +
                        '\t<div class="notice-bottom">\n' +
                        '\t\t<h3>' + returnparam.table + '</h3>\n' +
                        '\t\t<p class="text-info">' + returnparam.content + '</p>\n' +
                        '\t\t<p class="btn-detail"><span>' + returnparam.author + '</span>·<span>' + returnparam.date + '</span>\n' +
                        '\t</p>\n' +
                        '\t</div>\n' +
                        '</div>';
                    item = item + item_list;
                }
            } else {
                $("#btn_liulang_more").attr("disabled",true).removeClass("btn-info");
                var alert_box = '<div class="alert alert-danger" role="alert">' +
                    '<strong>提示信息!</strong> 已经到底了.</div>';
                item = item + alert_box;
            }
            $("#notice-body").append(item);
        }
    );
}
