function doSubmit() {
	var info = $('#info').val();
	$('#info').val("");
	info = info.replace(/\n/g, '');
	if(info == null || info == ''){
		return;
	}
	var url = contextPath + '/ring/chat';

	$.ajax({
		type : "GET",
		url : url,
		data : {
			info : info,
		},
		dataType : "json",
		success : function(data) {
			var json = JSON.parse(data);
			for ( var key in json) {
				if (key == 'text') {
					var result = json[key];
					document.getElementById("res").innerHTML = document
							.getElementById("res").innerHTML
							+ "<li>"
							+ info
							+ "</li>"
							+ "<li>"
							+ result
							+ "</li>";
					scrollEnd();
					$('#info').val("");
				}
			}
		}
	});
}

$(document).on('keydown', '.chat-textarea', function(e) {
	if (e.keyCode == 13 ) {
		doSubmit();
	}
})

function scrollEnd() {
	var div = document.getElementById('chatList');
	div.scrollTop = div.scrollHeight;
//	res.scrollIntoView();
}
//&& (e.metaKey || e.ctrlKey)
jQuery(function($) {
	function resetSubmit() {
		var id = $("#reset-id").val();
		var loginName = $("#reset-loginName").val();
		var newPassword = $("#reset-pass").val();
		$.ajax({
			type : "POST",
			url : "${ctx}/sys/user/resetPwd",
			dataType : "json",
			data : {
				'id' : id,
				'loginName' : loginName,
				'newPassword' : newPassword,
			},
			success : function(data) {
				top.jQuery.jBox.confirm(data.message, "系统提示");
				$("#reset-save").attr("disabled", true);
				$("#reset-password-modal").modal("hide");
			}
		});
		return false;
	}
	$("form#reset-form").submit(resetSubmit);
});

function pasValidate() {
	var patrn = /^[0-9a-zA-Z]{6,20}$/;
	var inputPass = $("#reset-pass").val();
	if (patrn.exec(inputPass)) {
		$("#error-Msg").css("display", "none");
		$("#reset-save").attr("disabled", false);
		return true;
	} else {
		$("#error-Msg").css("display", "block");
		$("#reset-save").attr("disabled", true);
		return false;
	}
}
