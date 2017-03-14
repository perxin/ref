jQuery(function($) {
	function regist() {
		var name = $("#name").val();
		var password = $("#password").val();
		var passwordConfirm = $("#passwordConfirm").val();
		$.ajax({
			type: "POST",
			url: contextPath + "/user/register",
			dataType : "json",
			data : {
				'name' : name,
				'password' : password,
				'passwordConfirm' : passwordConfirm,
			},
			success : function(data) {
				if (data.success == true) {
					location.href = contextPath + "/ring/index";
				}
			}
		});
	}
	$("form#regist-form").submit(regist);
});

jQuery(function($) {
	function login() {
		var name = $("#name").val();
		var password = $("#password").val();
		$.ajax({
			type: "POST",
			url: contextPath + "/user/login",
			dataType : "json",
			data : {
				'name' : name,
				'password' : password,
			},
			success : function(data) {
				if (data.success == true) {
					location.href = contextPath + "/ring/index";
				}
			}
		});
	}
	$("form#login-form").submit(login);
});

jQuery(function($) {
	function signOut() {
		$.ajax({
			type: "GET",
			url: contextPath + "/user/signOut",
			dataType : "json",
			success : function(data) {
				if (data.success == true) {
					location.href = contextPath + "/ring/index";
				}
			}
		});
	}
	$("#signOut").click(signOut);
});