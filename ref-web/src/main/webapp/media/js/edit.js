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
    $.ajax({
        type: "POST",
        url: contextPath + "/sign_in",
        dataType : "json",
        data : $("#login_form").serialize(),
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