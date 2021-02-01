$(document).ready(function () {
    $('#dynamic-table').dataTable({
        "aaSorting": [[4, "desc"]]
    });
    var manageID = "1";
    var adressId = "1.1.1.1";
    var param = manageID+"|"+adressId+"|"+"http://localhost:32227/manage/recruit#";
    $.ajax({
        type: "GET",
        url: "/manage/recruit/getRecruitManage",
        dataType: "json",
        async: true,
        data: {param},
    })
});