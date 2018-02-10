var num = -1;
/*绑定表格数据*/
$(function() {
	showDate1(1);

	$("#select").click(function() {
		mask(400, 300, false, "xxx", false);

	});

	$("#searchButton").click(function() {
		closeMask("xxx");

	});

	$(".deleteButton").click(function() {
		deleteShowAlert("删除提示", "确定要删除吗？", "确定", "取消")
	});

	$(".selectTable").on("dblclick", "tbody tr", function() {
		var emp_name = $(this).children("td:eq(1)").html(); //姓名
		var depart_name = $(this).children("td:eq(2)").html(); //部门
		var position_name = $(this).children("td:eq(3)").html(); //岗位
		var transfer_position_reason = $(this).children("td:eq(4)").html(); //原因
		var depart_name1 = $(this).children("td:eq(5)").html(); //调岗后部门
		var position_name1 = $(this).children("td:eq(6)").html(); //调岗后岗位
		var transfer_position_time = $(this).children("td:eq(7)").html(); //调岗时间
		var transfer_position_details = $(this).children("td:eq(8)").html(); //详细说明



		$("#emp_name1").text(emp_name);
		$("#depart_name").text(depart_name);
		$("#position_name").text(position_name);
		$("#transfer_position_reason").text(transfer_position_reason);
		$("#depart_name1").text(depart_name1);
		$("#position_name1").text(position_name1);
		$("#transfer_position_time").text(transfer_position_time);
		$("#transfer_position_details").text(transfer_position_details);

		mask(1000, 800, false, "yyy");
	});
});


/*表格全选*/
$(function() {
	$("#all").click(function() {
		var checked = $(this).is(":checked");
		$(".selectTable tr td").children().attr("checked", checked);
	});
	//判断是否全选
	function ifAllChecked() {
		var checkedBoxs = $(".selectTable tr td").children();
		var sum = checkedBoxs.size();
		var k = 0;
		checkedBoxs.each(function(index, dom) {
			if ($(dom).is(":checked")) k++;
		});
		if (k == sum) {
			$("#all").attr("checked", true);
		} else {
			$("#all").attr("checked", false);
		}
	}
	ifAllChecked(); //页面加载完后运行

});
/*表格全选结束*/

/* 点击添加跳转到添加页面 */
$(function() {
	$("#addInfo").click(function() {
		location.href = "transfer_position_add.html";
	});
});

function showDate(index) {
	num = 1;
	//获得搜索条件
	var pageSize = $("[name=tota1]").val();
	var emp_name = $("#emp_name").val();
	$(".selectTable").html("");
	var $ttr = $("<tr></tr>");
	var $tdd = $("<td colspan='9'></td>");
	var $img = $("<img src='/RlzybOa/statics/pcui/images/loading2.gif' />");
	$tdd.append($img);
	$ttr.append($tdd);
	$(".selectTable").html($ttr);
	$.ajax({
		type : "POST",
		url : "transfer_position_search",
		dataType : "json",
		data : {
			emp_name : emp_name,
			pageIndex : index,
			pageSize : 10
		},
		success : showList,
		error : function() {
			alert("数据不存在");
		}
	});
}
function showDate1(index) {
	num = 2;
	//获得搜索条件
	var pageSize = 10;
	$(".selectTable tbody").html("");
	var $ttr = $("<tr></tr>");
	var $tdd = $("<td colspan='9'></td>");
	var $img = $("<img src='/RlzybOa/statics/pcui/images/loading2.gif' />");
	$tdd.append($img);
	$ttr.append($tdd);
	$(".selectTable tbody").html($ttr);
	$.ajax({
		type : "POST",
		url : "transfer_position_search1",
		dataType : "json",
		data : {
			pageIndex : index, 
			pageSize : pageSize
		},
		success : showList1,
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

	var oaRlzybTransferPosition = datas.oaRlzybTransferPosition;
	var oaRlzybTransfer = datas.oaRlzybTransfer;
	$(".fofofo").text(count);
	showStuList(oaRlzybTransferPosition, oaRlzybTransfer);
	showPage(pageCount, index, count);
}
function showList1(data) {
	var datas = eval("(" + data + ")");
	var pageCount = datas.totalPageCount;

	var index = datas.currentPageNo;
	var count = datas.totalCount;

	var oaRlzybTransferPosition = datas.oaRlzybTransferPosition;
	var oaRlzybTransfer = datas.oaRlzybTransfer;
	$(".fofofo").text(count);
	if (oaRlzybTransferPosition.length != 0) {
		$(".pageStyle").css("display", "block");
	} else {
		$(".pageStyle").css("display", "none");
	}
	showStuList(oaRlzybTransferPosition, oaRlzybTransfer);
	showPage(pageCount, index, count);
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

function showStuList(oaRlzybTransferPosition, oaRlzybTransfer) {
	$(".selectTable tbody").html("");
	$(".selectTable thead .trs").html("");
	var str = "";
	if (oaRlzybTransferPosition.length == 0) {
		$(".selectTable thead .trs").append("<td colspan='9' style='color:red'>没有可供查看的数据</td>");
	}
	for (var i = 0; i < oaRlzybTransferPosition.length; i++) {
		if(oaRlzybTransferPosition[i].position_name== undefined ||oaRlzybTransferPosition[i].position_name==""){
			oaRlzybTransferPosition[i].position_name="无"
		}
		if(oaRlzybTransferPosition[i].depart_name==undefined||oaRlzybTransferPosition[i].depart_name==""){
			oaRlzybTransferPosition[i].depart_name="无"
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
		str += "<td>" + oaRlzybTransferPosition[i].emp_name + "</td>";
		str += "<td>" + oaRlzybTransfer[i].depart_name + "</td>";
		str += "<td>" + oaRlzybTransfer[i].position_name + "</td>";
		str += "<td>" + oaRlzybTransferPosition[i].transfer_position_reason + "</td>";
		str += "<td>" + oaRlzybTransferPosition[i].depart_name + "</td>";
		str += "<td>" + oaRlzybTransferPosition[i].position_name + "</td>";
		str += "<td>" + oaRlzybTransferPosition[i].transfer_position_time + "</td>";
		str += "<td style='display:none'>" + oaRlzybTransferPosition[i].transfer_position_details + "</td>"; //详细说明
		var date1 = new Date(oaRlzybTransferPosition[i].create_time);
		var date3 = new Date();
		if (date3.getTime() - date1.getTime() <= 172800000) {
			str += "<a href=\"javascript:;\" class=\"delete\" transfer_position_id=\"" + oaRlzybTransferPosition[i].transfer_position_id + "\">删除</a>";
		}
		str += "</td>";
		str += "</tr>";
	}

	$(".selectTable tbody").html(str);

	$(".delete").click(function() {
		$(".deleteStyle").css("display", "block");
		var transfer_position_id = $(this).attr("transfer_position_id");

		/*删除确定*/
		$(".bottomStyle1").click(function() {
			$(".deleteStyle").css("display", "none");
			$.ajax({
				url : "transfer_position_delete",
				data : {
					transfer_position_id : transfer_position_id
				},
				success : function() {
					var index = $("#index").val();

					if (oaRlzybTransferPosition.length % 10 == 0 && oaRlzybTransferPosition.length != 0) {
						showDate(index - 1);
					} else {
						showDate(index);
					}
				}
			});
		});
		/*删除取消*/
		$(".bottomStyle2").click(function() {
			$(".deleteStyle").css("display", "none");

		});
	});

	$(".link").click(function() {
		var transfer_position_id = $(this).attr("transfer_position_id");
		location.href = "transfer_position_show?transfer_position_id=" + transfer_position_id;
	});
}

$(function() {
	if (num == 1) {
		$("[name=total]").change(function() {
			showDate();
		})
	} else {
		$("[name=total]").change(function() {
			showDate1();
		})
	}

	$(".imgSearch").click(function() {
		var index = $("[name=pageNo]").val();
		if (isNaN(index)) {
			alert("请输入正确的数字");
		} else if (num == 1) {
			showDate(index);
		} else if (num == 2) {
			showDate1(index);
		}
		$("[name=pageNo]").val("");
	})

	$("#chaxun").click(function() {
		showDate(1);
	});

	$("#qing").click(function() {
		$("#emp_name").val("");
		showDate1();
	});
});
function show(index) {
	daili(index);
}