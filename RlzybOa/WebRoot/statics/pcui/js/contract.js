
var num = 0;
/*绑定表格数据*/
$(function() {

	weiqian();

	$("#weiqian").click(function() {
		weiqian();
	})

	$("#yiqian").click(function() {
		yiqian();
	})

	$("#xuqian").click(function() {
		xuqian();
	})

	$("#jijiang").click(function() {
		jijiang();
	})

	$("#searchButton").click(function() {
		closeMask("xxx");

	});

	$(".saveButton").click(function() {
		var emp_id = $(".d_bt_ok").attr("xq");
		var position_id = $("#positionname").attr("gw");
		var depart_name = $("#departname").attr("bm");
		var contract_id = $("#contract_id1").val();
		var contract_belong_company = $("[name=contract_company]").val();
		var contract_startDate = $("#qishiDate").val();
		var contract_endDate = $("#jiezhiDate").val();
		if (contract_id != "" && contract_id.length == 8 && !isNaN(contract_id) && contract_startDate != "" && contract_endDate != "") {
			$.ajax({
				type : "POST",
				url : "employee_contract_insert",
				dataType : "json",
				data : {
					contract_id : contract_id,
					emp_id : emp_id,
					contract_startDate : contract_startDate,
					contract_endDate : contract_endDate,
					contract_company : contract_belong_company
				},
				success : function(date) {
					if (date == 1) {
						closeMask("zzzz");
						showWebAlert("添加成功!");
						if (num == 1) {
							weiqian();
						} else if (num == 3) {
							xuqian();
						} else if (num == 4) {
							jijiang();
						}
					} else {
						showWebAlert("添加失败!");
					}
				}
			})
		} else {
			alert("数据填写有误!");
		}
	});

	$(".deleteButton").click(function() {
		deleteShowAlert("删除提示", "确定要删除吗？", "确定", "取消")
	});

	$(".selectTable").on("dblclick", "tbody tr", function() {
		var emp_name = $(this).children("td:eq(1)").html();
		var position_name = $(this).children("td:eq(2)").html();
		var depart_name = $(this).children("td:eq(3)").html();
		var contract_id = $(this).children("td:eq(4)").html();
		var contract_belong_company = $(this).children("td:eq(6)").html();
		var contract_startDate = $(this).children("td:eq(7)").html();
		var contract_endDate = $(this).children("td:eq(8)").html();

		$("#emp_name1").text(emp_name);
		$("#position_name").text(position_name);
		$("#depart_name").text(depart_name);
		$("#contract_id").text(contract_id);
		$("#contract_belong_company").text(contract_belong_company);
		$("#contract_startDate").text(contract_startDate);
		$("#contract_endDate").text(contract_endDate);

		mask(1000, 800, false, "yyy");
	});

	$(".selectTable").on("click", "tbody tr", function() {
		var emp_name = $(this).children("td:eq(1)").html();
		var position_name = $(this).children("td:eq(2)").html();
		var depart_name = $(this).children("td:eq(3)").html();
		var emp_id = $(this).children("td:eq(10)").html();
		var emp_department = $(this).children("td:eq(11)").html();
		var emp_position = $(this).children("td:eq(12)").html();

		$(".d_bt_ok").attr("xq", emp_id);
		$("#departname").attr("bm", emp_department);
		$("#positionname").attr("gw", emp_position);

		$("#empname").text(emp_name);
		$("#positionname").text(position_name);
		$("#departname").text(depart_name);
	});
});
$(function() {
	$("#xq").click(function() {
		if ($(".d_bt_ok").attr("xq") == null || $(".d_bt_ok").attr("xq") == "") {
			showWebAlert('请先选择员工');
		} else if (num == 2) {
			alert("合同已签订!");
		} else {
			$("#contract_id1").next().text("请输入合同编号").css("color", "red");
			$("#qishiDate").next().text("");
			$("#jiezhiDate").next().text("");
			insert();
		}
	})

	$(".imgSearch").click(function() {
		if (num == 1) {
			var index = $("[name=pageNo]").val();
		} else if (num == 2) {
			var index = $("[name=pageNo1]").val();
		} else if (num == 3) {
			var index = $("[name=pageNo2]").val();
		} else {
			var index = $("[name=pageNo3]").val();
		}
		if (isNaN(index)) {
			alert("请输入正确的数字");
		} else {
			if (num == 1) {
				weiqian(index);
			} else if (num == 2) {
				yiqian(index);

			} else if (num == 3) {
				xuqian(index);
			} else {
				jijiang(index);
			}
		}
		$("[name=pageNo]").val("");
		$("[name=pageNo1]").val("");
		$("[name=pageNo2]").val("");
		$("[name=pageNo3]").val("");
	})
})

function insert() {
	mask(850, 450, false, "zzzz", true);
}
;

//未签订
function weiqian(index) {
	num = 1;
	//获得搜索条件
	$(".d_bt_ok").attr("xq", "");
	var zhuang = "未签订";
	var pageSize = $("[name=total]").val();
	var emp_name = $("#emp_name").val();
	var contract_id = $("#contract_id").val();
	var contract_startDate = $("#contract_startDate").val();
	var contract_endDate = $("#contract_endDate").val();
	var contract_status = $("#contract_status").val();
	$(".selectTable tbody").html("");
	var $ttr = $("<tr></tr>");
	var $tdd = $("<td colspan='10'></td>");
	var $img = $("<img src='/RlzybOa/statics/pcui/images/loading2.gif' />");
	$tdd.append($img);
	$ttr.append($tdd);
	$(".selectTable tbody").html($ttr);
	$.ajax({
		type : "POST",
		url : "employee_contract_search",
		dataType : "json",
		data : {
			emp_name : emp_name,
			contract_startDate : contract_startDate,
			contract_endDate : contract_endDate,
			contract_id : contract_id,
			contract_status : zhuang,
			pageIndex : index,
			pageSize : pageSize
		},
		success : showList,
		error : function() {
			alert("数据不存在");
		}
	});
}


//已签订
function yiqian(index) {
	num = 2;
	//获得搜索条件
	$(".d_bt_ok").attr("xq", "");
	var zhuang = "已签订";
	var pageSize = $("[name=tota2]").val();
	var emp_name = $("#emp_name").val();
	var contract_id = $("#contract_id").val();
	var contract_startDate = $("#contract_startDate").val();
	var contract_endDate = $("#contract_endDate").val();
	var contract_status = $("#contract_status").val();
	$(".selectTable tbody").html("");
	var $ttr = $("<tr></tr>");
	var $tdd = $("<td colspan='10'></td>");
	var $img = $("<img src='/RlzybOa/statics/pcui/images/loading2.gif' />");
	$tdd.append($img);
	$ttr.append($tdd);
	$(".selectTable tbody").html($ttr);
	$.ajax({
		type : "POST",
		url : "employee_contract_search",
		dataType : "json",
		data : {
			emp_name : emp_name,
			contract_startDate : contract_startDate,
			contract_endDate : contract_endDate,
			contract_id : contract_id,
			contract_status : zhuang,
			pageIndex : index,
			pageSize : pageSize
		},
		success : showList,
		error : function() {
			alert("数据不存在");
		}
	});
}

//即将
function jijiang(index) {
	num = 4;
	//获得搜索条件
	$(".d_bt_ok").attr("xq", "");
	var zhuang = "即将到期";
	var pageSize = $("[name=tota4]").val();
	var emp_name = $("#emp_name").val();
	var contract_id = $("#contract_id").val();
	var contract_startDate = $("#contract_startDate").val();
	var contract_endDate = $("#contract_endDate").val();
	var contract_status = $("#contract_status").val();
	$(".selectTable tbody").html("");
	var $ttr = $("<tr></tr>");
	var $tdd = $("<td colspan='10'></td>");
	var $img = $("<img src='/RlzybOa/statics/pcui/images/loading2.gif' />");
	$tdd.append($img);
	$ttr.append($tdd);
	$(".selectTable tbody").html($ttr);
	$.ajax({
		type : "POST",
		url : "employee_contract_search",
		dataType : "json",
		data : {
			emp_name : emp_name,
			contract_startDate : contract_startDate,
			contract_endDate : contract_endDate,
			contract_id : contract_id,
			contract_status : zhuang,
			pageIndex : index,
			pageSize : pageSize
		},
		success : showList,
		error : function() {
			alert("数据不存在");
		}
	});
}

//已过期
function xuqian(index) {
	num = 3;
	//获得搜索条件
	$(".d_bt_ok").attr("xq", "");
	var zhuang = "已到期";
	var pageSize = $("[name=tota3]").val();
	var emp_name = $("#emp_name").val();
	var contract_id = $("#contract_id").val();
	var contract_startDate = $("#contract_startDate").val();
	var contract_endDate = $("#contract_endDate").val();
	var contract_status = $("#contract_status").val();
	$(".selectTable tbody").html("");
	var $ttr = $("<tr></tr>");
	var $tdd = $("<td colspan='10'></td>");
	var $img = $("<img src='/RlzybOa/statics/pcui/images/loading2.gif' />");
	$tdd.append($img);
	$ttr.append($tdd);
	$(".selectTable tbody").html($ttr);
	$.ajax({
		type : "POST",
		url : "employee_contract_search",
		dataType : "json",
		data : {
			emp_name : emp_name,
			contract_startDate : contract_startDate,
			contract_endDate : contract_endDate,
			contract_id : contract_id,
			contract_status : zhuang,
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

	var oaRlzybEmployees = datas.oaRlzybEmployees;
	$(".tabTitle font").text(count);
	if (oaRlzybEmployees.length != 0) {
		$(".pageStyle").css("display", "block");
		showPage(index, pageCount, count);
		showPage1(index, pageCount, count);
		showPage2(index, pageCount, count);
		showPage3(index, pageCount, count);
	} else {
		$(".pageStyle").css("display", "none");
	}
	showStuList(oaRlzybEmployees);
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

function showStuList(oaRlzybEmployees) {
	$(".selectTable tbody").html("");
	$(".selectTable thead .trs").html("");
	var str = "";
	if (oaRlzybEmployees.length != 0) {
		for (var i = 0; i < oaRlzybEmployees.length; i++) {
			if(oaRlzybEmployees[i].position_name== undefined ||oaRlzybEmployees[i].position_name==""){
				oaRlzybEmployees[i].position_name="无"
			}
			if(oaRlzybEmployees[i].depart_name==undefined||oaRlzybEmployees[i].depart_name==""){
				oaRlzybEmployees[i].depart_name="无"
			}
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

			str += "<td>" + oaRlzybEmployees[i].emp_name + "</td>";
			str += "<td>" + oaRlzybEmployees[i].position_name + "</td>";
			str += "<td>" + oaRlzybEmployees[i].depart_name + "</td>";

			if (oaRlzybEmployees[i].contract_status == "未签订") {
				str += "<td>" + "</td>";
				str += "<td>" + oaRlzybEmployees[i].contract_status + "</td>";
				str += "<td>" + "</td>";
				str += "<td>" + "</td>";
				str += "<td>" + "</td>";
			} else {
				str += "<td>" + oaRlzybEmployees[i].contract_id + "</td>";
				str += "<td>" + oaRlzybEmployees[i].contract_status + "</td>";
				str += "<td>" + oaRlzybEmployees[i].contract_belong_company + "</td>";
				str += "<td>" + dateFmt(oaRlzybEmployees[i].contract_startDate) + "</td>";
				str += "<td>" + dateFmt(oaRlzybEmployees[i].contract_endDate) + "</td>";
			}

			str += "<td>";

			if (oaRlzybEmployees[i].contract_status == "未签订") {
				str += "<a>未签订</a>";
			} else if (oaRlzybEmployees[i].contract_status == "已签订") {
				str += "<a>已签订</a>";
			}
			if (oaRlzybEmployees[i].contract_status == "已到期" || oaRlzybEmployees[i].contract_status == "即将到期") {
				str += "<a>续签</a>";
			}

			str += "<input type='hidden' id='emp_id' value='" + oaRlzybEmployees[i].emp_id + "'> </td>";
			str += "<td style='display:none'>" + oaRlzybEmployees[i].emp_id + "</td>";
			str += "<td style='display:none'>" + oaRlzybEmployees[i].emp_department + "</td>";
			str += "<td style='display:none'>" + oaRlzybEmployees[i].emp_position + "</td>";
			str += "</tr>";
		}
	} else {
		$(".selectTable thead .trs").append("<td colspan='10' style='color:red'>没有可供查看的数据</td>");
	}
	$(".selectTable tbody").html(str);

	$(".addContract").click(function() {
		var emp_id = $(this).attr("emp_id");
		/* alert(emp_id);  */
		location.href = "employee_contract_add?emp_id=" + emp_id;

	});
}
$(function() {
	$("#contract_id1").blur(function() {
		var contract = $(this).val();
		if (contract == "") {
			$(this).next().text("合同编号不能为空").css("color", "red");
		} else if (contract.length != 8 || isNaN(contract)) {
			$(this).next().text("合同编号为8位数字").css("color", "red");
		} else {
			$(this).next().text("√").css("color", "green");
		}
	})

	$("#qishiDate").blur(function() {
		var qsDate = $(this).val();
		if (qsDate == "") {
			$(this).next().text("起始时期不能为空").css("color", "red");
		} else {
			$(this).next().text("√").css("color", "green");
		}
	})

	$("#jiezhiDate").blur(function() {
		var jzDate = $(this).val();
		if (jzDate == "") {
			$(this).next().text("截止时期不能为空").css("color", "red");
		} else {
			$(this).next().text("√").css("color", "green");
		}
	})

	$("[name=total]").change(function() {
		weiqian(1);
	})
	$("[name=tota2]").change(function() {
		yiqian(1);
	})
	$("[name=tota3]").change(function() {
		xuqian(1);
	})
	$("[name=tota4]").change(function() {
		jijiang(1);
	})
});

$(function() {
	$("#chaxun").click(function() {
		if (num == 1) {
			weiqian();
		} else if (num == 2) {
			yiqian();
		} else if (num == 3) {
			xuqian();
		} else {
			jijiang();
		}
	});

	$("#qing").click(function() {
		$("#emp_name").val("");
		$("#contract_id").val("");
		if (num == 1) {
			weiqian();
		} else if (num == 2) {
			yiqian();
		} else if (num == 3) {
			xuqian();
		} else {
			jijiang();
		}
	});
});
function show(index) {
	weiqian(index);
}
function show1(index) {
	yiqian(index);
}
function show2(index) {
	xuqian(index);
}
function show3(index) {
	jijiang(index);
}
/*删除弹出框点击确定或者取消*/
function subForm(result) {
	if (result) {
		showWebAlert('删除成功，哈哈！');
	}
}
/*结束*/