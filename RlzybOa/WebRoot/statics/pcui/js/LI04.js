$(function(){
		gettabTitle($("[name=nam01]").attr("id"));
	});
	
	/* 迟到 */
	var num2 = 0;
	/* 未打卡 */
	var num3 = 0;
	/* 早退 */
	var num4 = 0;
	/* 请假 */
	var num5 = 0;
	/* 旷工 */
	var num6 = 0;
	/* 天数 */
	var hours = 0;
	/* 时间 */
	var times02 = 0;
	
	
	$(function(){
		$("#but01").click(function(){
			location = "lookcq";
		});
	
	});
	
	
	function gettabTitle(empid) {
		$.ajax({
			url : "/tyyhoa/rlzyb/getPdkli",
			type : "get",
			data : {
				"empid" : empid
			},
			dataType : "json",
			/* dataType : "JSON", */
			success : function(all) {
				$("[name=nam01]").text(all[0].oaRlzybEmployee.empName+"：");
				for (var i = 0; i < all.length; i++) {
					/* alert(parseInt(all[i].hours)); */
					$("#tab02").append(
						"<tr><td>" + formatDate01(all[i].date) + "</td>" +
						"<td>" + all[i].oaRlzybEmpdkzdam.ztName + "</td>" +
						"<td>" + pan(all[i].statusAm,all[i].timeAm) + "</td>" +
						"<td>" + all[i].oaRlzybEmpdkzdpm.ztName + "</td>" +
						"<td>" + pan(all[i].statusPm,all[i].timePm) + "</td></tr>"
					);
					/* 请假的话天数加1--请的是全天假 */
					
					/* alert(parseInt(all[i].statusAm));
					alert(parseInt(all[i].statusPm)); */
					
					// 上午请假
					var isamqj = parseInt(all[i].statusAm) == 5 || parseInt(all[i].statusAm) == 6;
					/* alert("上午请假" + isamqj); */
					// 下午请假
					var ispmqj = parseInt(all[i].statusPm) == 5 || parseInt(all[i].statusPm) == 6;
					/* alert("下午请假" + ispmqj); */
					// 判断
					if(isamqj != ispmqj){
						if(parseInt(all[i].hours) <= 2){
							// 小时数叠加
							times02 += parseInt(all[i].hours);
						}else{
							// 请假半天
							hours = hours + 0.5;
						}
					}
					if(isamqj && ispmqj){
						if(parseInt(all[i].hours) <= 6){
							// 小时数叠加
							if(parseInt(all[i].hours) != 5){
								times02 += parseInt(all[i].hours);
							}else{
								times02 += (parseInt(all[i].hours) - 4);
								hours = hours + 0.5;
							}
						}else{
							// 请假一天
							hours = hours + 1;
						}
					}
					/* alert("heheeh" + num5); */
					$("#num2").text("迟到:" + num2 +"次");
					$("#num3").text("   未打卡:" + num3 +"次");
					$("#num4").text("   早退:" + num4 +"次");
					$("#num5").text("   请假:" + num5 + "次-共"+hours+"天"+times02+"小时");
					$("#num6").text("   旷工:" + num6 +"次");
					
				};
				
			},
			error : function() {
				alert("出现异常！");
			}
		});
	}
	
	function pan(num,time01) {
		switch (num) {
		case 1:
			return formatDate(time01);
			break;
		case 2:
			num2 = num2+1
			return "暂无";
			break;
		case 3:
			/*alert(num);*/
			num4 = num4+1;
			return "暂无";
			break;
		case 4:
			num3 = num3+1;
			return "暂无";
			break;
		case 5:
			num5 = num5 + 1;
			return "暂无";
			break;
		case 6:
			num5 = num5 + 1;
			return "暂无";
			break;
		case 7:
			return "暂无";
			break;
		case 8:
			num6 = num6+1;
			return "暂无";
			break;
		}
	}

	function formatDate(nows) {
		var now = new Date(nows);
		var year = now.getFullYear();
		var month = now.getMonth() + 1;
		var date = now.getDate();
		var hour = now.getHours();
		var minute = now.getMinutes();
		var second = now.getSeconds();
		return year + "-" + month + "-" + date + " " + hour + ":" + minute + ":" + second;
	}
	function formatDate01(nows) {
		var now = new Date(nows);
		var year = now.getFullYear();
		var month = now.getMonth() + 1;
		var date = now.getDate();
		var hour = now.getHours();
		var minute = now.getMinutes();
		var second = now.getSeconds();
		return date + "号";
	}