$(function() {
	"use strict";

	function sbmt() {
		"use strict";

		var $out = $("#oouutt");
		var $in = $("#iinn");
		if ($in.val()) {
			$.ajax({
				type : "POST",
				url : "Chat",
				data : "in=" + $in.val(),
				success : function(msg) {
					$in.val("");
				},
				error : function() {
					console.log("error");
				}
			})
		}
	}

	$("[type=button]").click(sbmt);

	$("body").keydown(function(e) {
		if (e.keyCode === 13) {
			sbmt();
		}
	});

	var lunxun = function() {
		var $out = $("#oouutt");
		$.ajax({
			type : "POST",
			url : "Lunxun",
			success : function(msg) {
				msg.trim();
				console.log(msg);
				var obj = eval("(" + msg + ")");
				$out.val($out.val() + obj.out + "\n");
				$("#onlineUsersSize").html(obj.onlineUsersSize);
				lunxun();
			},
			error : function() {
				lunxun();
			}
		})
	};
	lunxun();
});