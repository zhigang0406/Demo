<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>查询奖惩信息</title>

<link rel="stylesheet" type="text/css"
	href="statics/pcui/css/formStyle.css" />
<link rel="stylesheet" type="text/css"
	href="statics/pcui/css/global.css">
<link rel="stylesheet" type="text/css"
	href="statics/pcui/css/tablelist.css">
<link rel="stylesheet" type="text/css" href="statics/pcui/css/page.css">
<link rel="stylesheet" type="text/css" href="statics/pcui/css/form.css">
<link rel="stylesheet" type="text/css" href="statics/pcui/css/popup.css">
<link rel="stylesheet" type="text/css" href="statics/pcui/css/add.css">
<link rel="stylesheet" type="text/css" href="statics/pcui/css/tab.css">
<link rel="stylesheet" type="text/css" href="statics/pcui/css/index.css">

<script type="text/javascript" src="statics/pcui/js/alert.js"></script>
<script type="text/javascript" src="statics/pcui/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="statics/pcui/js/index.js"></script>
<script type="text/javascript" src="statics/pcui/js/page.js"></script>
<script type="text/javascript" src="statics/pcui/js/showtable.js"></script>
<script type="text/javascript" src="statics/pcui/js/rewardstab.js"></script>
<script type="text/javascript" src="statics/pcui/js/tab.js"></script>
<style type="text/css">
.deleteStyle {
	position: absolute;
	top: 200px;
	left: 580px;
}
</style>
<script type="text/javascript">


	/*表格全选*/
	$(function() {
		$("[name=total]").change(function() {
			showDate(1);
		});
		$("[name=total1]").change(function() {
			shDate(1);
		});
		$("[name=total2]").change(function() {
			showate(1);
		});
		$("#imgSearch").click(function() {
			var index1 = $("[name=pageNo]").val();
			if(isNaN(index1)){
				alert("请输入正确的数字");
			}else{
				showDate(index1);
			}
			$("[name=pageNo]").val("");
		});
		$("#imgSearch1").click(function() {
			var index2 = $("[name=pageNo1]").val();
			if(isNaN(index2)){
				alert("请输入正确的数字");
			}else{
				showDate(index2);
			}
		});
		$("#imgSearch2").click(function() {
			var index3 = $("[name=pageNo2]").val();
			if(isNaN(index3)){
				alert("请输入正确的数字");
			}else{
				showDate(index3);
			}
		});
		$("#cha").click(function() {
			showDate(1);
			$(".d_bt_ok").attr("s", "");
		});
		$("#cha1").click(function() {
			shDate(1);
			$(".d_bt_ok").attr("s", "");
		});
		$("#cha2").click(function() {
			showate(1);
			$(".d_bt_ok").attr("s", "");
		});
		$("#qing").click(function() {
			$("#emp_name").val("");
			showDate(1);
			$(".d_bt_ok").attr("s", "");
		});
		$("#qing1").click(function() {
			$("#emp_name1").val("");
			shDate(1);
		});
		$("#qing2").click(function() {
			$("#emp_name2").val("");
			showate(1);
		});
		showDate(1);
		$("#jl").click(function() {
			shDate(1);
		});
		$("#qb").click(function() {
			showDate(1);
		});
		$("#cf").click(function() {
			showate(1);
		});

		$(".selectTable").on("click", "tr", function() {
			var id = $(this).attr("emp_id");
			$(".d_bt_ok").attr("s", id);
		});
		$("#shanchu").click(function() {
			if ($(".d_bt_ok").attr("s") == null || $(".d_bt_ok").attr("s") == "") {
				showWebAlert('请先选择员工');
			} else {
				deleteShowAlert("删除提示", "确定要删除吗？", "确定", "取消");
			}
			$(".d_bt_ok").click(function() {
				var interview_id = $(this).attr("s");
				var f = $(this).attr("sc");
				$.ajax({
					url : "Randp_delete",
					data : {
						rewards_id : interview_id
					},
					success : function(data) {
						showDate(1);
						$(".d_bt_ok").attr("s", "");
					}
				});
			})
		});
		$("#shanchu1").click(function() {
			if ($(".d_bt_ok").attr("s") == null || $(".d_bt_ok").attr("s") == "") {
				showWebAlert('请先选择员工');
			} else {
				deleteShowAlert("删除提示", "确定要删除吗？", "确定", "取消");
			}
			$(".d_bt_ok").click(function() {
				var interview_id = $(this).attr("s");
				var f = $(this).attr("sc");
				$.ajax({
					url : "Randp_delete",
					data : {
						rewards_id : interview_id
					},
					success : function(data) {
						shDate(1);
						$(".d_bt_ok").attr("s", "");
					}
				});
			})
		});
		$("#shanchu2").click(function() {
			if ($(".d_bt_ok").attr("s") == null || $(".d_bt_ok").attr("s") == "") {
				showWebAlert('请先选择员工');
			} else {
				deleteShowAlert("删除提示", "确定要删除吗？", "确定", "取消");
			}
			$(".d_bt_ok").click(function() {
				var interview_id = $(this).attr("s");
				var f = $(this).attr("sc");
				$.ajax({
					url : "Randp_delete",
					data : {
						rewards_id : interview_id
					},
					success : function(data) {
						showate(1);
						$(".d_bt_ok").attr("s", "");
					}
				});
			})
		});
	});
	/*表格全选结束*/

	/* 点击添加跳转到添加页面 */
	$(function() {
		$("#addInfo").click(function() {
			location.href = "Randp_add.html";
		});
	});



	function showDate(index) {
		//获得搜索条件
		showate

		var emp_name = $("#emp_name").val();
		var page = $("[name=total]").val();
		var rewards_type = "";
		$(".selectTable tbody").html("");
		var $ttr = $("<tr></tr>");
		var $tdd = $("<td colspan='9'></td>");
		var $img = $("<img src='/RlzybOa/statics/pcui/images/loading2.gif' />");
		$tdd.append($img);
		$ttr.append($tdd);
		$(".selectTable tbody").html($ttr);
		$.ajax({
			type : "POST",
			url : "Randp_search",
			dataType : "json",
			data : {
				emp_name : emp_name,
				rewards_type : rewards_type,
				pageIndex : index,
				pageSize : page
			},
			success : showList
		});
		$("#emp_name").val("");
	}


	function shDate(index) {
		//获得搜索条件

		var emp_name = $("#emp_name1").val();
		var page1 = $("[name=total1]").val();
		var rewards_type = "奖励";
		$(".selectTable tbody").html("");
		var $ttr = $("<tr></tr>");
		var $tdd = $("<td colspan='9'></td>");
		var $img = $("<img src='/RlzybOa/statics/pcui/images/loading2.gif' />");
		$tdd.append($img);
		$ttr.append($tdd);
		$(".selectTable tbody").html($ttr);
		$.ajax({
			type : "POST",
			url : "Randp_search",
			dataType : "json",
			data : {
				emp_name : emp_name,
				rewards_type : rewards_type,
				pageIndex : index,
				pageSize : page1
			},
			success : showList
		});
		$("#emp_name1").val("");
	}
	function showate(index) {
		//获得搜索条件

		var emp_name = $("#emp_name2").val();
		var page2 = $("[name=total2]").val();
		var rewards_type = "处分";
		$(".selectTable tbody").html("");
		var $ttr = $("<tr></tr>");
		var $tdd = $("<td colspan='9'></td>");
		var $img = $("<img src='/RlzybOa/statics/pcui/images/loading2.gif' />");
		$tdd.append($img);
		$ttr.append($tdd);
		$(".selectTable tbody").html($ttr);
		$.ajax({
			type : "POST",
			url : "Randp_search",
			dataType : "json",
			data : {
				emp_name : emp_name,
				rewards_type : rewards_type,
				pageIndex : index,
				pageSize : page2
			},
			success : showList
		});
		$("#emp_name2").val("");
	}

	function showList(data) {
		var datas = eval("(" + data + ")");
		var pageCount = datas.totalPageCount;

		var index = datas.currentPageNo;
		var count = datas.totalCount;
		var oaRlzybRewards = datas.oaRlzybRewards;
		$(".fofofo").text(count);
		if(oaRlzybRewards.length!=0){
			$(".pageStyle").css("display","block");
		}else{
			$(".pageStyle").css("display","none");
		}
		showStuList(oaRlzybRewards);
		showPage(index, pageCount, count);
		showPage1(index, pageCount, count);
		showPage2(index, pageCount, count);
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

	function showStuList(oaRlzybRewards) {
		$(".selectTable tbody").html("");
		$(".selectTable thead .trs").html("");
		var str = "";
		if(oaRlzybRewards.length==0){
			$(".selectTable thead .trs").append("<td colspan='7' style='color:red'>没有可供查看的数据</td>");
		}
		for (var i = 0; i < oaRlzybRewards.length; i++) {
			var date1 = new Date(oaRlzybRewards[i].create_time);
			var date3 = new Date();
			if (date3.getTime() - date1.getTime() <= 172800000) {
				str += "<tr sc=1 emp_id=" + oaRlzybRewards[i].rewards_id + " >";
			} else {
				str += "<tr sc=0 emp_id=" + oaRlzybRewards[i].rewards_id + " >";
			}
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
			str += "<td>" + oaRlzybRewards[i].emp_name + "</td>";
			str += "<td>" + oaRlzybRewards[i].position_name + "</td>";
			str += "<td>" + oaRlzybRewards[i].depart_name + "</td>";
			str += "<td>" + oaRlzybRewards[i].rewards_type + "</td>";
			str += "<td>" + oaRlzybRewards[i].rewards_reason + "</td>";
			var dat = oaRlzybRewards[i].rewards_date;
			var date = dat.substr(0, 10);
			str += "<td>" + date + "</td>";
			str += "</tr> ";
		}
		$(".selectTable tbody").html(str);
		$(".selectTable").on("dblclick", "tbody tr", function() {
			//var id = $(this).children("td:eq(0)").html();
			//测试弹出值 
			var id = $(this).attr("emp_id");

			/*初始化遮罩*/
			/*true顶部垂直居中*/
			mask(1000, 800, false, "yyy");
			for (var i = 0; i < oaRlzybRewards.length; i++) {
				if (id == oaRlzybRewards[i].rewards_id) {

					$(".emp_name").text(oaRlzybRewards[i].emp_name);
					$(".depart_name").text(oaRlzybRewards[i].depart_name);
					$(".position_name").text(oaRlzybRewards[i].position_name);
					$(".rewards_type").text(oaRlzybRewards[i].rewards_type);
					$(".rewards_reason").text(oaRlzybRewards[i].rewards_reason);
					$(".rewards_content").text(oaRlzybRewards[i].rewards_content);
					var addtim = oaRlzybRewards[i].rewards_date;

					var addtime = addtim.substr(0, 10); //截取日期

					$(".rewards_date").text(addtime);
				}
			}
		});

		$(".delete").click(function() {
			$(".deleteStyle").css("display", "block");
			var rewards_id = $(this).attr("rewards_id");


			$(".bottomStyle1").click(function() {
				$(".deleteStyle").css("display", "none");
				$.ajax({
					url : "Randp_delete",
					data : {
						rewards_id : rewards_id
					},
					success : function(data) {
						var index = $("#index").val();

						if (oaRlzybRewards.length % 10 == 0 && oaRlzybRewards.length != 0) {
							showDate(index - 1);
						} else {
							showDate(index);
						}
					}
				});


			});

			$(".bottomStyle2").click(function() {
				$(".deleteStyle").css("display", "none");

			});
		});

		$(".link").click(function() {
			var rewards_id = $(this).attr("rewards_id");
			location.href = "rewards_show?rewards_id=" + rewards_id;

		});
	}
</script>
<script type="text/javascript">
	function show(index) {
		showDate(index);
	}
</script>
<script type="text/javascript">
	function show(index) {
		showDate(index);
	}
	function show1(index) {
		shDate(index);
	}
	function show2(index) {
		showate(index);
	}
	/*删除弹出框点击确定或者取消*/
	function subForm(result) {
		if (result) {
			showWebAlert('删除成功，哈哈！');
		}
	}
	/*结束*/
</script>

</head>
<body>
	<div>
		<div class="container">
			<div class="rightContent">
				<h1 class="tabTitle">
					<span>全部</span>[<font class="fofofo" color="#FF0000"></font>]
				</h1>
				<div class="tabs">
					<span class="spanHover" id="qb" value="">全部</span> <span
						class="spanOut" id="jl" value="奖励">奖励</span> <span class="spanOut"
						id="cf" value="处分">处分</span>

				</div>
				<div class="tabContent">


					<div class="divTable">
						<form method="post" action="">
							<div class="serach">

								姓名：<input type="search" id="emp_name" name="emp_name"
									class="searchStyle" style="width:160px;" placeholder="请输入姓名" />

								<input type="button" id="cha" value="搜索" class="searchBotton" />
								<input type="button" s f value="删除" class="deleteButton"
									id="shanchu" /> <input type="button" value="清空搜索条件"
									class="searchBotton" style='width:120px' id="qing" />

							</div>
						</form>
						<table cellpadding="0" cellspacing="0" border="0"
							class="selectTable" id="tableData">
							<thead>
								<tr>
									<th>编号</th>
									<th>姓名</th>
									<th>岗位</th>
									<th>部门</th>
									<th>奖惩类型</th>
									<th>奖惩原因</th>
									<th>奖惩时间</th>
								</tr>
								<tr class="trs"></tr>
							</thead>
							<tbody></tbody>
						</table>

						<div class="pageStyle">
							<div class="pagecount">
								<span class="txtLeft">每页显示</span>
								<div class="total">
									<select name="total">
										<option value="10">10</option>
										<option value="20">20</option>
										<option value="50">50</option>
										<option value="100">100</option>
									</select>
								</div>
								<span class="txtRight">条</span>
							</div>
							<div class="searchPage">
								<div class="txt">G0&nbsp;</div>
								<input type="text" name="pageNo" /> <img
									src="statics/common/images/fdj.png" class="imgSearch"
									id="imgSearch" />
							</div>
							<div class="page" id="page">&nbsp;</div>

						</div>


					</div>
					<div class="divTable" style="display:none;">
						<form method="post" action="">
							<div class="serach">

								姓名：<input type="search" id="emp_name1" name="emp_name"
									class="searchStyle" style="width:160px;" placeholder="请输入姓名" />

								<input type="button" id="cha1" value="搜索" class="searchBotton" />
								<input type="button" s f value="删除" class="deleteButton"
									id="shanchu1" /> <input type="button" value="清空搜索条件"
									class="searchBotton" style='width:120px' id="qing1" />

							</div>
						</form>
						<table cellpadding="0" cellspacing="0" border="0"
							class="selectTable" id="tableData1">
							<thead>
								<tr>
									<th>编号</th>
									<th>姓名</th>
									<th>岗位</th>
									<th>部门</th>
									<th>奖惩类型</th>
									<th>奖惩原因</th>
									<th>奖惩时间</th>
								</tr>
								<tr class="trs"></tr>
							</thead>
							<tbody></tbody>

						</table>

						<div class="pageStyle">
							<div class="pagecount">
								<span class="txtLeft">每页显示</span>
								<div class="total">
									<select name="total1">
										<option value="10">10</option>
										<option value="20">20</option>
										<option value="50">50</option>
										<option value="100">100</option>
									</select>
								</div>
								<span class="txtRight">条</span>
							</div>
							<div class="searchPage">
								<div class="txt">G0&nbsp;</div>
								<input type="text" name="pageNo1" /> <img
									src="statics/common/images/fdj.png" class="imgSearch"
									id="imgSearch1" />
							</div>
							<div class="page" id="page1">&nbsp;</div>

						</div>
					</div>
					<div class="divTable" style="display:none;">
						<form method="post" action="">
							<div class="serach">

								姓名：<input type="search" id="emp_name2" name="emp_name"
									class="searchStyle" style="width:160px;" placeholder="请输入姓名" />
								<input type="button" id="cha2" value="搜索" class="searchBotton" />
								<input type="button" s f value="删除" class="deleteButton"
									id="shanchu2" /> <input type="button" value="清空搜索条件"
									class="searchBotton" style='width:120px' id="qing2" />

							</div>
						</form>
						<table cellpadding="0" cellspacing="0" border="0"
							class="selectTable" id="tableData2">
							<thead>
								<tr>
									<th>编号</th>
									<th>姓名</th>
									<th>岗位</th>
									<th>部门</th>
									<th>奖惩类型</th>
									<th>奖惩原因</th>
									<th>奖惩时间</th>
								</tr>
								<tr class="trs"></tr>
							</thead>
							<tbody></tbody>

						</table>
						<div class="pageStyle">
							<div class="pagecount">
								<span class="txtLeft">每页显示</span>
								<div class="total">
									<select name="total2">
										<option value="10">10</option>
										<option value="20">20</option>
										<option value="50">50</option>
										<option value="100">100</option>
									</select>
								</div>
								<span class="txtRight">条</span>
							</div>
							<div class="searchPage">
								<div class="txt">G0&nbsp;</div>
								<input type="text" name="pageNo2" /> <img
									src="statics/common/images/fdj.png" class="imgSearch"
									id="imgSearch2" />
							</div>
							<div class="page" id="page2">&nbsp;</div>

						</div>

					</div>

				</div>

			</div>
			<div class="mbStyle">&nbsp;</div>
			<div class="popupStyle" id="yyy" style="overflow: hidden;">
				<h1>
					员工奖惩信息<span class="closeX" onclick="closeMask()">x</span>
				</h1>
				<div class="p_height">&nbsp;</div>
				<table cellpadding="0" cellspacing="0" border="0" class="addTable">
					<tr>
						<td class="tdWidth">部门：</td>
						<td class="depart_name"></td>
					</tr>
					<tr>
						<td class="tdWidth">姓名：</td>
						<td class="emp_name"></td>
					</tr>
					<tr>
						<td class="tdWidth">岗位：</td>
						<td class="position_name"></td>
					</tr>
					<tr>
						<td class="tdWidth">奖惩类型：</td>
						<td class="rewards_type"></td>
					</tr>
					<tr>
						<td class="tdWidth">奖惩时间：</td>
						<td class="rewards_date">${rewards_date }</td>
					</tr>
					<tr>
						<td class="tdWidth">奖惩原因：</td>
						<td class="rewards_reason"></td>
					</tr>
					<tr>
						<td class="tdWidth">详细说明：</td>
						<td class="rewards_content"></td>
					</tr>

				</table>
			</div>
		</div>
	</div>
	<!--蒙板开始-->
	<div class="zzDiv"></div>
	<!--蒙板结束-->
	<!--提醒开始-->

	<div class="remind">
		<span class="reText"></span><span class="closeWin"
			onClick="hideRemind()">X</span>
	</div>
	<!--提醒结束-->

	<!--保存成功-->
	<div class="saveAlert"></div>
	<!--保存成功结束-->

	<!--删除成功-->
	<div class="deleteAlert">
		<div class="d_title"></div>
		<div class="d_msg"></div>
		<div>
			<div class="d_bt_ok" s></div>
			<div class="d_bt_cancel"></div>
		</div>
	</div>
	<!--删除成功结束-->
</body>
</html>
