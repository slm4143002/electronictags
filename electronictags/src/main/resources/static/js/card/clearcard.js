$(function() {
	$("#cardInfo1").focus();
	$(document).on("keypress", "input:not(.allow_submit)", function(event) {
		return event.which !== 13;
	});
	document.addEventListener('keyup', function() {
		$("#cardInfo1").keyup(function(event) {
			if (event.which == 13) {
				$("#cardInfo2").focus();
			}
		});
		$("#cardInfo2").keyup(function(event) {
			if (event.which == 13) {
				$("#cardInfo3").focus();
			}
		});
		$("#cardInfo3").keyup(function(event) {
			if (event.which == 13) {
				$("#cardInfo4").focus();
			}
		});
		$("#cardInfo4").keyup(function(event) {
			if (event.which == 13) {
				$("#cardInfo5").focus();
			}
		});
		$("#cardInfo5").keyup(function(event) {
			if (event.which == 13) {
				$("#cardInfo6").focus();
			}
		});
		$("#cardInfo6").keyup(function(event) {
			if (event.which == 13) {
				$("#cardInfo7").focus();
			}
		});
		$("#cardInfo7").keyup(function(event) {
			if (event.which == 13) {
				$("#cardInfo8").focus();
			}
		});
		$("#cardInfo8").keyup(function(event) {
			if (event.which == 13) {
				$("#cardInfo9").focus();
			}
		});
		$("#cardInfo9").keyup(function(event) {
			if (event.which == 13) {
				$("#cardInfo10").focus();
			}
		});
		$("#cardInfo10").keyup(function(event) {
			if (event.which == 13) {
				$("#cardInfo1").focus();
			}
		});
	});

});

function clearValue(num) {
	$("#cardInfo" + num).val("")
}

function checkItem() {

	const letters = new Set();
	const cardInfo = new Array();
	for (var i = 1; i <= 10; i++) {
		if ($("#cardInfo" + i).val() != "") {
			letters.add($("#cardInfo" + i).val());
			cardInfo.push($("#cardInfo" + i).val());
		}
	}
	if (letters.size != cardInfo.length) {
		event.preventDefault();
		$("#errorInfo").removeClass("d-none")
		$("#errorInfo").text("电子卡片有重复的信息,请确认!");
		return;
	} else if (letters.size == 0) {
		event.preventDefault();
		$("#errorInfo").removeClass("d-none");
		$("#errorInfo").text("请输入要清除的卡片的信息!");
		return;
	}
	
	$('#loadingModal').modal('show');
}


