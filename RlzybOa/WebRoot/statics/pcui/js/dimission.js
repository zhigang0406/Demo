var num = 0;
/*绑定表格数据*/
$(function() {
	daili();

	$("#daili").click(function() {
		daili();
	});

	$("#yili").click(function() {
		yili();
	});

	$("#tingxin").click(function() {
		tingxin();
	});

	$("#select").click(function() {
		mask(400, 300, false, "xxx", false);

	});

	$("#searchButton").click(function() {
		closeMask("xxx");

	});
	$(".insertButton").click(function() {
		mask(800, 450, false, "zzzz", true);

	});
	$(".saveButton").click(function() {
		closeMask("zzzz");
		showWebAlert("新增成功!");

	});
	/*删除*/
	$(".deleteButton").click(function() {
		if ($(".d_bt_ok").attr("s") == null || $(".d_bt_ok").attr("s") == "") {
			showWebAlert('请先选择员工');
		} else {
			deleteShowAlert("删除提示", "确定要删除吗？", "确定", "取消");
		}
		//删除
		$(".d_bt_ok").click(function() {
			var dimission_id = $(this).attr("s");
			$.ajax({
				url : "dimission_delete",
				data : {
					dimission_id : dimission_id
				},
				success : function(data) {
					var index = $("#pageIndex").val();
					if (data.length % 10 == 0 && data.length != 0) {
						if (num == 1) {
							daili(index - 1);
						} else if (num == 2) {
							yili(index - 1);
						} else {
							tingxin(index - 1);
						}
					} else {
						if (num == 1) {
							daili(index);
						} else if (num == 2) {
							yili(index);
						} else {
							tingxin(index);
						}
					}
					$("d_bt_ok").attr("s", "");
				}
			});
		});
	});
	$(".selectTable tbody").on("dblclick", "tr", function() {
		var emp_name = $(this).children("td:eq(1)").html(); //离职员工
		var depart_name = $(this).children("td:eq(2)").html(); //离职部门
		var position_name = $(this).children("td:eq(3)").html(); //离职岗位
		var dimission_date = $(this).children("td:eq(4)").html(); //离职时间
		var dimission_approver = $(this).children("td:eq(5)").html(); //登记人
		var dimission_reason = $(this).children("td:eq(6)").html(); //离职原因

		$("#emp_name").text(emp_name);
		$("#depart_name").text(depart_name);
		$("#position_name").text(position_name);
		$("#dimission_date").text(dimission_date);
		$("#dimission_approver").text(dimission_approver);
		$("#dimission_reason").text(dimission_reason);

	});

	$(".selectTable tbody").on("click", "tr", function() {
		var dimission_id = $(this).children("td:eq(7)").html(); //离职id
		$(".d_bt_ok").attr("s", dimission_id);

	});
});

/* 点击添加跳转到添加页面 */
$(function() {
	$("#addInfo").click(function() {
		location.href = "dimission_add.html";
	});
});

function showDate(index) {
	//获得搜索条件
	if (num == 1) {
		$(".d_bt_ok").attr("s", "");
		var pageSize = $("[name=total]").val();
	} else if (num == 2) {
		var pageSize = $("[name=tota2]").val();
	} else {
		var pageSize = $("[name=tot3]").val();
	}
	var emp_name = $("#emp_names").val();
	var dimission_date1 = $("#dimission_date1").val();
	var dimission_date2 = $("#dimission_date2").val();
	$(".selectTable tbody").html("")
	var $ttr = $("<tr></tr>");
	var $tdd = $("<td colspan='6'></td>");
	var $img = $("<img src='/RlzybOa/statics/pcui/images/loading2.gif' />");
	$tdd.append($img);
	$ttr.append($tdd);
	$(".selectTable tbody").html($ttr)
	$.ajax({
		type : "POST",
		url : "dimission_search",
		dataType : "json",
		data : {
			emp_name : emp_name,
			dimission_date1 : dimission_date1,
			dimission_date2 : dimission_date2,
			pageIndex : index,
			pageSize : pageSize
		},
		success : showList,
		error : function() {
			alert("数据不存在");
		}
	});
}

//待离职
function daili(index) {
	//获得搜索条件
	num = 1;
	$(".d_bt_ok").attr("s", "");
	var pageSize = $("[name=total]").val();
	var dimission_statuss = 2;
	var emp_name = $("#emp_names").val();
	var dimission_date1 = $("#dimission_date1").val();
	var dimission_date2 = $("#dimission_date2").val();
	$(".selectTable tbody").html("")
	var $ttr = $("<tr></tr>");
	var $tdd = $("<td colspan='6'></td>");
	var $img = $("<img src='/RlzybOa/statics/pcui/images/loading2.gif' />");
	$tdd.append($img);
	$ttr.append($tdd);
	$(".selectTable tbody").html($ttr)
	$.ajax({
		type : "POST",
		url : "dimission_search",
		dataType : "json",
		data : {
			dimission_status : dimission_statuss,
			emp_name : emp_name,
			dimission_date1 : dimission_date1,
			dimission_date2 : dimission_date2,
			pageIndex : index,
			pageSize : pageSize
		},
		success : showList,
		error : function() {
			alert("数据不存在");
		}
	});
}

//已离职
function yili(index) {
	//获得搜索条件
	num = 2;
	$(".d_bt_ok").attr("s", "");
	var pageSize = $("[name=tota2]").val();
	var dimission_statuss = 1;
	var emp_name = $("#emp_names").val();
	var dimission_date1 = $("#dimission_date1").val();
	var dimission_date2 = $("#dimission_date2").val();
	$(".selectTable tbody").html("");
	var $ttr = $("<tr></tr>");
	var $tdd = $("<td colspan='9'></td>");
	var $img = $("<img src='/RlzybOa/statics/pcui/images/loading2.gif' />");
	$tdd.append($img);
	$ttr.append($tdd);
	$(".selectTable tbody").html($ttr)
	$.ajax({
		type : "POST",
		url : "dimission_search",
		dataType : "json",
		data : {
			dimission_status : dimission_statuss,
			emp_name : emp_name,
			dimission_date1 : dimission_date1,
			dimission_date2 : dimission_date2,
			pageIndex : index,
			pageSize : pageSize
		},
		success : showList,
		error : function() {
			alert("数据不存在");
		}
	});
}

//停薪留职
function tingxin(index) {
	num = 3;
	//获得搜索条件
	$(".d_bt_ok").attr("s", "");
	var pageSize = $("[name=tota3]").val();
	var dimission_statuss = 3;
	var emp_name = $("#emp_names").val();
	var dimission_date1 = $("#dimission_date1").val();
	var dimission_date2 = $("#dimission_date2").val();
	$(".selectTable tbody").html("");
	var $ttr = $("<tr></tr>");
	var $tdd = $("<td colspan='6'></td>");
	var $img = $("<img src='/RlzybOa/statics/pcui/images/loading2.gif' />");
	$tdd.append($img);
	$ttr.append($tdd);
	$(".selectTable tbody").html($ttr)
	$.ajax({
		type : "POST",
		url : "dimission_search",
		dataType : "json",
		data : {
			dimission_status : dimission_statuss,
			emp_name : emp_name,
			dimission_date1 : dimission_date1,
			dimission_date2 : dimission_date2,
			pageIndex : index,
			pageSize : pageSize
		},
		success : showList,
		error : function() {
			alert("数据不存在");
		}
	});
}

function showList(data) {
	var datas = eval("(" + data + ")");
	var pageCount = datas.totalPageCount;

	var index = datas.currentPageNo;
	var count = datas.totalCount;

	var OaRlzybDimissions = datas.OaRlzybDimissions;
	$(".fofofo").text(count);
	if (OaRlzybDimissions.length != 0) {
		$(".pageStyle").css("display", "block");
	} else {
		$(".pageStyle").css("display", "none");
	}
	showStuList(OaRlzybDimissions);
	showPage(pageCount, index, count);
	showPage1(pageCount, index, count);
	showPage2(pageCount, index, count);
}

function dateFmt(time) {
	var t = new Date(time);
	var year = t.getFullYear(); //年
	var month = t.getMonth() + 1; //月
	var day = t.getDate(); //日
	if (month < 10) {
		month = "0" + month;
	}
	if (day < 10) {
		day = "0" + day;
	}
	var dateTimeStr = year + "-" + month + "-" + day;
	return dateTimeStr;
}

function showStuList(OaRlzybDimissions) {
	$(".selectTable tbody").html("");
	$(".selectTable thead .trs").html("");
	var str = "";
	if (OaRlzybDimissions.length == 0) {
		$(".selectTable thead .trs").append("<td colspan='6' style='color:red'>没有可供查看的数据</td>");
	}
	for (var i = 0; i < OaRlzybDimissions.length; i++) {
		str += "<tr>";

		var id = i + 1;
		if (id < 10) {
			id = "000" + id;
		} else if (id < 100) {
			id = "00" + id;
		} else if (id < 1000) {
			id = "0" + id;
		} else {
			id = "" + id;
		}
		str += "<td>" + id + "</td>";
		str += "<td>" + OaRlzybDimissions[i].emp_name + "</td>";
		str += "<td>" + OaRlzybDimissions[i].depart_name + "</td>";
		str += "<td>" + OaRlzybDimissions[i].position_name + "</td>";
		str += "<td>" + dateFmt(OaRlzybDimissions[i].dimission_date) + "</td>";
		str += "<td>" + OaRlzybDimissions[i].dimission_approver + "</td>";
		str += "<td style='display:none;'>" + OaRlzybDimissions[i].dimission_reason + "</td>";
		str += "<td style='display:none;'>" + OaRlzybDimissions[i].dimission_id + "</td>";
		var date1 = new Date(OaRlzybDimissions[i].create_time);
		var date3 = new Date();
		str += "</td>";
		str += "</tr>";
	}

	$(".selectTable tbody").html(str);
	$(".link").click(function() {
		var dimission_id = $(this).attr("dimission_id");
		location.href = "dimission_show?dimission_id=" + dimission_id;

	});
}

$(function() {

	$("[name=total]").change(function() {
		daili(1);
	})
	$("[name=tota2]").change(function() {
		yili(1);
	})
	$("[name=tota3]").change(function() {
		tingxin(1);
	})

	$("#chaxun").click(function() {
		if (num == 1) {
			daili();
		} else if (num == 2) {
			yili();
		} else {
			tingxin();
		}
		$("#emp_names").val("");
	});

	$("#qing").click(function() {
		$("#emp_names").val("");
		if (num == 1) {
			daili();
		} else if (num == 2) {
			yili();
		} else {
			tingxin();
		}
		$("d_bt_ok").attr("s", "");
	});

	$(".imgSearch").click(function() {
		if (num == 1) {
			var index = $("[name=pageNo]").val();
		} else if (num == 2) {
			var index = $("[name=pageNo1]").val();
		} else {
			var index = $("[name=pageNo2]").val();
		}
		if (isNaN(index)) {
			alert("请输入正确的数字");
		} else {
			if (num == 1) {
				daii(index);
			} else if (num == 2) {
				yili(index);
			} else if (num == 3) {
				tingxin(index);
			}
		}
		$("[name=pageNo]").val("");
		$("[name=pageNo1]").val("");
		$("[name=pageNo2]").val("");
	})
});
function show(index){
	daili(index);
}
function show1(index){
	yili(index);
}
function show2(index){
	tingxin(index);
}
/*删除弹出框点击确定或者取消*/
function subForm(result){
	if(result){
		 showWebAlert('删除成功，哈哈！');   
	} 
}
/*结束*/