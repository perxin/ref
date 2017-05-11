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

$(document).ready(
    function() {
        $("#note-title-search").keydown(function(event) {
            if (event.keyCode == 13) {
                searchNote();
            }
        })
    }
);