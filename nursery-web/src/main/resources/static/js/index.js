function newJob() {
    $.get("/index/newJob", function (data) {
        $("#new_job").html(data);
    });
}

function hotJob(hotId, hotname) {
    $.get("/index/hotJob/" + hotId + "/" + hotname, function (data) {
        var RecruitmentDO_lis = '<div class="row">';
        for (var i = 0; i < data.length; i++) {
            var RecruitmentDO = data[i];
            var li = '<div class="col-sm-6 col-md-4">\n' +
                '\t<div class="position-thumbnail">\n' +
                '\t\t<div class="row">\n' +
                '\t\t\t<div class="col-md-5">\n' +
                '\t\t\t\t<p>' + RecruitmentDO.recruittablename + '</p>\n' +
                '\t\t\t\t<span>' + RecruitmentDO.requireEduDB + '</span>\n' +
                '\t\t\t</div>\n' +
                '\t\t\t<div class="col-md-4 col-md-offset-2">\n' +
                '\t\t\t\t<p>' + RecruitmentDO.pay + '</p>\n' +
                '\t\t\t</div>\n' +
                '\t\t</div>\n' +
                '\t\t<hr/>\n' +
                '\t\t<p>' + RecruitmentDO.place + '</p>\n' +
                '\t</div>\n' +
                '</div>';

            RecruitmentDO_lis += li;
        }
        RecruitmentDO_lis +='</div>';
        $("#" + hotId).html(RecruitmentDO_lis);
    });
}