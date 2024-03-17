$(function() {
	//var nIntervId;
	$("#batchNumber").focus();
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
	/*document.addEventListener('keyup', function() {
		$("#cardInfo1").on("input", function() {

			if (!nIntervId) {
				scanList = ""
				// 启动定时器
				nIntervId = setInterval(checkScan1, 500);
			}
		});
		$("#cardInfo2").on("input", function() {
			if (!nIntervId) {
				scanList = ""
				// 启动定时器
				nIntervId = setInterval(checkScan2, 500);
			}
		});
		$("#cardInfo3").on("input", function() {
			if (!nIntervId) {
				scanList = ""
				// 启动定时器
				nIntervId = setInterval(checkScan3, 500);
			}
		});
		$("#cardInfo4").on("input", function() {
			if (!nIntervId) {
				scanList = ""
				// 启动定时器
				nIntervId = setInterval(checkScan4, 500);
			}
		});
		$("#cardInfo5").on("input", function() {
			if (!nIntervId) {
				scanList = ""
				// 启动定时器
				nIntervId = setInterval(checkScan5, 500);
			}
		});
		$("#cardInfo6").on("input", function() {
			if (!nIntervId) {
				scanList = ""
				// 启动定时器
				nIntervId = setInterval(checkScan6, 500);
			}
		});
		$("#cardInfo7").on("input", function() {
			if (!nIntervId) {
				scanList = ""
				// 启动定时器
				nIntervId = setInterval(checkScan7, 500);
			}
		});
		$("#cardInfo8").on("input", function() {
			if (!nIntervId) {
				scanList = ""
				// 启动定时器
				nIntervId = setInterval(checkScan8, 500);
			}
		});
		$("#cardInfo9").on("input", function() {
			if (!nIntervId) {
				scanList = ""
				// 启动定时器
				nIntervId = setInterval(checkScan9, 500);
			}
		});
		$("#cardInfo10").on("input", function() {
			if (!nIntervId) {
				scanList = ""
				// 启动定时器
				nIntervId = setInterval(checkScan10, 500);
			}
		});
	});

	function checkScan1() {// 0.5秒结束

		// 清除定时器
		clearInterval(nIntervId);
		nIntervId = null
		$("#cardInfo1").unbind();
		$("#cardInfo2").focus();

	}
	function checkScan2() {// 0.5秒结束

		// 清除定时器
		clearInterval(nIntervId);
		nIntervId = null
		$("#cardInfo2").unbind();
		$("#cardInfo3").focus();

	}
	function checkScan3() {// 0.5秒结束

		// 清除定时器
		clearInterval(nIntervId);
		nIntervId = null
		$("#cardInfo3").unbind();
		$("#cardInfo4").focus();

	}
	function checkScan4() {// 0.5秒结束

		// 清除定时器
		clearInterval(nIntervId);
		nIntervId = null
		$("#cardInfo4").unbind();
		$("#cardInfo5").focus();

	}
	function checkScan5() {// 0.5秒结束

		// 清除定时器
		clearInterval(nIntervId);
		nIntervId = null
		$("#cardInfo5").unbind();
		$("#cardInfo6").focus();

	}
	function checkScan6() {// 0.5秒结束

		// 清除定时器
		clearInterval(nIntervId);
		nIntervId = null
		$("#cardInfo6").unbind();
		$("#cardInfo7").focus();

	}
	function checkScan7() {// 0.5秒结束

		// 清除定时器
		clearInterval(nIntervId);
		nIntervId = null
		$("#cardInfo7").unbind();
		$("#cardInfo8").focus();

	}
	function checkScan8() {// 0.5秒结束

		// 清除定时器
		clearInterval(nIntervId);
		nIntervId = null
		$("#cardInfo8").unbind();
		$("#cardInfo9").focus();

	}
	function checkScan9() {// 0.5秒结束

		// 清除定时器
		clearInterval(nIntervId);
		nIntervId = null
		$("#cardInfo9").unbind();
		$("#cardInfo10").focus();

	}
	function checkScan10() {// 0.5秒结束

		// 清除定时器
		clearInterval(nIntervId);
		nIntervId = null
		$("#cardInfo10").unbind();
		$("#cardInfo1").focus();

	}*/

	// 搜索按下
	$("#search").click(function(event) {
		event.preventDefault();
		if ($("#batchNumber").val() == "") {
			$("#errorInfo").removeClass("d-none")
			$("#errorInfo").text("请输入批量号!")
			$("#batchNumber").focus();
			$("#errorFormMsg").remove();
			$("#infoFormMsg").remove();
		} else {
			getCardInfo();
		}

	});
	function getCardInfo() {
		$.ajax(
			{
				url: "/searchCardInfo",
				type: "POST",
				data: {
					batchNumber: $("#batchNumber").val()  // 送信データ
				},
				dataType: 'json',
				success: function(data) {
					if (data) {
						$("#errorInfo").addClass("d-none");
						$("#machineCategoryName").val(`${data.machineCategoryName}`);
						$("#machineCount").val(`${data.machineCount}`);
						$("#carCount").val(`${data.carCount}`);
						$("#writeDate").val(`${data.writeDate}`);
						for (var i = 1; i <= `${data.carCount}`; i++) {
							$("#cardcount" + i).val(i + "/" + `${data.carCount}`);
						}

						for (j = 1; j <= 10; j++) {
							$("#cardInfo" + j).removeAttr('disabled');
						}
						var k = (Number(`${data.carCount}`) + 1)
						for (k; k <= 10; k++) {
							$("#cardInfo" + k).removeAttr('placeholder');
							$("#cardInfo" + k).prop("disabled", true)
							$("#cardcount" + k).prop("disabled", true)
						}
						$("#cardInfo1").focus();
					} else {
						$("#machineCategoryName").val("");
						$("#machineCount").val("");
						$("#carCount").val("");
						$("#writeDate").val("");


						for (j = 1; j <= 10; j++) {
							$("#cardInfo" + j).prop("disabled", true);
							$("#cardInfo" + j).removeAttr('placeholder');
							$("#cardcount" + j).prop("disabled", true);
							$("#cardcount" + i).val("");
						}
						$("#batchNumber").focus();
						$("#errorInfo").removeClass("d-none")
						$("#errorInfo").text("要处理的批量号不存在！请确认!")
						$("#errorFormMsg").remove();
						$("#infoFormMsg").remove();
					}
				},
				error: function(e) {
					alert("Error!")
					console.log("ERROR: ", e);
				}
			}
		)
	}

});

function clearValue(num) {
	$("#cardInfo" + num).val("")
}

function checkItem() {
	$('#loadingModal').modal('show');
	const letters = new Set();
	for (var i = 1; i <= $("#carCount").val(); i++) {

		if ($("#cardInfo" + i).val() == "") {
			event.preventDefault();
			$("#carderrorInfo").removeClass("d-none")
			$("#carderrorInfo").text("请扫码输入！")
			$("#cardInfo" + i).focus();
			return;
		}
		letters.add($("#cardInfo" + i).val());
	}

	if (letters.size != $("#carCount").val()) {
		event.preventDefault();
		$("#carderrorInfo").removeClass("d-none")
		$("#carderrorInfo").text("有重复信息，请确认!")
		return;
	}

}


