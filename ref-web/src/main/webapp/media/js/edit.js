function noteSubmit() {
    if ($('#note_title').val() == "") {
        $('#note_title').focus().css({
            border: "1px solid red",
            boxShadow: "0 0 2px red"
        });
        alert("标题不能为空");
        // $('#message').html("<font color='red'><b>×标题不能为空</b></font>");
        return false;
    }
    if (getContent() == '') {
        $('#editor').focus();
        alert("文章内容不能为空");
        // $('#message').html("<font color='red'><b>×文章内容不能为空</b></font>");
        return false;
    }
    var params = {};
    params.name = $('#note_title').val();
    params.content = getContent()[0];
    params.description = $("#note_description").val();
    $.ajax({
        type: "POST",
        url: contextPath + "/note/add",
        dataType : "json",
        data : params,
        contentType : "application/x-www-form-urlencoded; charset=UTF-8",
        error : function(data) {
            alert(data.message);
        },
        success : function(data) {
            if (data.success == true) {
                location.href = contextPath + "/home";
            } else {
                alert(data.message);
            }
        }
    });
}

function noteEdit(id) {
    location.href = contextPath + "/edit";
    $.ajax({
        type: "GET",
        url: contextPath + "/note/add",
        dataType : "json",
        data : params,
        contentType : "application/x-www-form-urlencoded; charset=UTF-8",
        error : function(data) {
            alert(data.message);
        },
        success : function(data) {
            if (data.success == true) {
                location.href = contextPath + "/home";
            } else {
                alert(data.message);
            }
        }
    });
}

function commentSubmit() {
    if ($('#comment-content').val() == "") {
        $('#comment-content').focus().css({
            border: "1px solid red",
            boxShadow: "0 0 2px red"
        });
        alert("评论不能为空");
        return false;
    }
    // var params = {};
    // params.noteId = $('#note-id').val();
    // params.content = getContent()[0];
    // params.description = $("#note_description").val();
    $.ajax({
        type: "POST",
        url: contextPath + "/comment",
        dataType : "json",
        data : $("#comment-submit").serialize(),
        contentType : "application/x-www-form-urlencoded; charset=UTF-8",
        error : function(data) {
            alert("评论成功");
            location.reload();
        },
        success : function(data) {
            alert("评论成功");
            location.reload();
            /*if (data.success == true) {
                alert("评论成功");
                location.reload();
            } else {
                alert(data.message);
            }*/
        }
    });
}