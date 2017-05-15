function getNotePage(page) {
    $.ajax({
        type: "GET",
        url: contextPath + "/note/" + page + "?pageNum=1&pageSize=10",
        dataType : "json",
        error : function(data) {
            alert(data.message);
        },
        success : function(data) {
            $("#page-data").empty();
            var list = data.list;
            for (var i = 0; i < list.length; i++) {
                $("#page-data").append("<a href='" + contextPath + "/note?id=" + list[i].id + "' class='list-group-item'>" + list[i].name + "</a>");
            }
        }
    });
}

function searchNote(pageNum) {
    location.href = contextPath + "/note/notePage?name=" + $("#note-title-search").val() + "&pageNum=" + pageNum;
}

function integralPage(pageNum) {
    location.href = contextPath + "/integral?pageSize=10&pageNum=" + pageNum;
}

$(document).ready(
    function() {
        $("#note-title-search").keydown(function(event) {
            if (event.keyCode == 13) {
                searchNote();
            }
        })
    }
);

function uploadFile() {
    var user = $("#isSignIn").val();
    if (user == null || user == "" || user == undefined) {
        location.href = contextPath + "/sign";
    }
    var fileForm = new FormData(document.getElementById("uploadFileForm"));
    // var name = $("input").val();
    // fileForm.append("file", $("#uploadFileForm").files[0]);
    // formData.append("name",name);
    $.ajax({
        url : contextPath + "/upload",
        type : 'POST',
        data : fileForm,
        // 告诉jQuery不要去处理发送的数据
        processData : false,
        // 告诉jQuery不要去设置Content-Type请求头
        contentType : false,
        beforeSend:function(){
            console.log("正在进行，请稍候");
        },
        error : function(data) {
            alert(data.message);
        },
        success : function(data) {
            alert("上传成功");
            location.href = contextPath + "/file";
            /*if (data.success == true) {
                alert("上传成功");
                location.href = contextPath + "/file";
            }*/
        }
    });
}

function filePage(pageNum) {
    location.href = contextPath + "/file?pageNum=" + pageNum;
}