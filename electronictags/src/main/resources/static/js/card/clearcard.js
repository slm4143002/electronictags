$(function() {
	var nIntervId;
	document.addEventListener('keyup', function() {
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

	}

});

function clearValue(num) {
	$("#cardInfo"+num).val("")	
}

function checkItem() {
	
	const letters = new Set();
	const cardInfo=new Array();
	for (var i = 1; i <= 10; i++) {
		if ($("#cardInfo" + i).val() != "") {
			letters.add($("#cardInfo" + i).val());
			cardInfo.push($("#cardInfo" + i).val());
		}
	}
	if (letters.size != cardInfo.length) {
		event.preventDefault();
		$("#errorInfo").removeClass( "d-none" )
		$("#errorInfo").text("电子卡片有重复的信息,请确认!")
	} else if (letters.size == 0) {
		event.preventDefault();
		$("#errorInfo").removeClass( "d-none" )
		$("#errorInfo").text("请输入要清除的卡片的信息!")
	}
}


