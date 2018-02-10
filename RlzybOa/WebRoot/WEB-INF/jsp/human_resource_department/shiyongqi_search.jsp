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
<title>试用期人员信息</title>
<link rel="stylesheet" type="text/css" href="statics/pcui/css/page.css">
<link rel="stylesheet" type="text/css" href="statics/pcui/css/tab.css">
<link rel="stylesheet" type="text/css"
	href="statics/pcui/css/tablelist.css">
<link rel="stylesheet" type="text/css"
	href="statics/pcui/css/global.css" />
<link rel="stylesheet" type="text/css" href="statics/pcui/css/add.css" />
<link rel="stylesheet" type="text/css" href="statics/pcui/css/popup.css" />
<link rel="stylesheet" type="text/css" href="statics/pcui/css/index.css" />
<link rel="stylesheet" type="text/css" href="statics/pcui/css/form.css" />
<style type="text/css">
.tdWidth {
	width: 100px;
	font-weight: bold;
}
</style>
<script type="text/javascript" src="statics/pcui/js/alert.js"></script>
<script type="text/javascript" src="statics/pcui/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="statics/pcui/js/index.js"></script>
<script type="text/javascript" src="statics/pcui/js/page.js"></script>
<script type="text/javascript" src="statics/pcui/js/tab.js"></script>
<script type="text/javascript">


	/*表格全选*/
	$(function() {
		shiyongqinum();
		newsLoad();
		$("#zhuanzheng").click(function() {
			if($(".saveButton").attr("s")==null||$(".saveButton").attr("s")==""){
			showWebAlert("请选择员工");
			}else{
				mask(650,200, false, "xxx", false);
			}
		});

		$(".insertButton").click(function() {
			mask(800, 300, false, "zzzz", true);
		});
		$("#fangtansave").click(function() {
		var emp_tryout_end_date = $("#zzrq").val();
		var emp_id = $(this).attr("s");
			$.ajax({
				type: "post",
				url: "Employee/OaRlzybEmployeesUpdataRq",
				data:{"emp_tryout_end_date":emp_tryout_end_date,"emp_id":emp_id},
				success : function(updata){
					if(updata>0){
						showWebAlert("转正成功!");
						closeMask("xxx");
					}
					newsLoad();
				}
			});
			$(this).attr("s","");
	});
		
		//页面搜索
		$("#search").click(function() {
			newsLoad();
			$(".d_bt_ok").attr("s","");
		});
	});
	
	//试用期
	
	function shiyongqinum(){
	$.ajax({
			type: "post",
			url: "Employee/selectCountshiyongqi",
			success : function(data) {
				$(".tabTitle span").text(data.length); 
				$(".tabTitle span").attr("number",data.length); 
			}
	});
}
	function newsLoad() {
		var emp_name = $("#sousuoname").val();
		var emp_department = $("#sousuobumen").val();
		$(".selectTable tbody").html("");
		$(".selectTable thead .trs").html("");
		var $ttr = $("<tr></tr>");
		   var $tdd = $("<td colspan='9'></td>");
		   var $img = $("<img src='/RlzybOa/statics/pcui/images/loading2.gif' />");
		   $tdd.append($img);
		   $ttr.append($tdd);
		$(".selectTable tbody").html($ttr);
		$.ajax({
			type : "POST",
			url : "Employee/selectCountshiyongqi",
			data: {"emp_name":emp_name,"emp_department":emp_department},
			success : function(list){
			$(".selectTable tbody").html("");
			var str = "";
			if(list.length!=0){
					for (var i = 0; i < list.length; i++) {
							str+="<tr s="+list[i].emp_id+">";
							var id = i + 1;
							if(id < 10){
								id = "000" + id;
							}else if(id < 100){
								id = "00" + id;
							}else if(id < 1000){
								id = "0" + id;
							}else{
								id = "" + id;
							}
							str+="<td>"+id+"</td>";
							str+="<td>"+list[i].emp_name+"</td>";
							str+="<td>"+list[i].emp_sex+"</td>";
							str+="<td>"+list[i].emp_age+"</td>";
							str+="<td>"+(new Date(list[i].emp_tryout_end_date).getFullYear()+"-")+
							(new Date(list[i].emp_tryout_end_date).getMonth()+1+"-")+
							(new Date(list[i].emp_tryout_end_date).getDate())+
							"</td>";
							str+="</tr>"
					 	}
				}else{
					$(".selectTable thead .trs").append("<td colspan='9' style='color:red'>没有可供查看的数据</td>");
				}
				$(".selectTable tbody").html(str);
			},
			error : function() {
				alert("数据不存在");
			}
		});
		/*给未来元素绑定单击事件，单击表格选中一行开始*/
		$(".selectTable").on("click","tbody tr",function() {
		
		    //单击从表格上取id值
			var id = $(this).attr("s");
			var zzday = $(this).children("td:eq(4)").text();
			$("#fangtansave").attr("s",id);
			$(".syq").text(zzday);
			$(this).siblings().children("td").removeClass("tr_active");
			$(this).children("td").addClass("tr_active");
        });
	   /*给未来元素绑定单击事件，单击表格选中一行结束*/
	}
</script>
<script type="text/javascript">
	function show(index) {
		newsLoad();
	}
	/*删除弹出框点击确定或者取消*/
	function subForm(result){
		if(result){
			 showWebAlert('删除成功，哈哈！');   
		}   
	}
/*结束*/
</script>
<style type="text/css">
.deleteStyle {
	position: absolute;
	top: 200px;
	left: 580px;
}
</style>
</head>
<body>
	<div>
		<div class="container">
			<!--选项卡开始-->
			<h1 class="tabTitle">
				待转正员工[<span number style="color: red;">5</span>]
			</h1>
			<!--搜索区开始-->
				<div class="serach">
					<input type="search" class="searchStyle ss" style="width:120px;"
						placeholder="请输入姓名" id="sousuoname" /> <select
						class="selectStyle ss" style="width:130px;" id="sousuobumen">
						<option value="0">请选择：</option>
						<option value="1">校长办公室</option>
						<option value="2">人力资源行政部</option>
						<option value="3">市场渠道部</option>
						<option value="4">网络部</option>
						<option value="5">咨询部</option>
						<option value="7">教质部</option>
						<option value="8">学术部</option>
						<option value="10">业务部</option>
						<option value="12">财务部</option>
					</select> 
					<input type="button"
						value="搜索" class="searchButton" id="souSuoNameAndDepart" style="margin-left: 15px" />
					<input type="button" value="转正" class="insertButton"
						id="zhuanzheng"/> 
				</div>
				<!--搜索区结束-->
					<div class="tableInfo">
						<table cellpadding="0" cellspacing="0" border="0"
							class="selectTable" id="tableData">
							<thead>
								<tr>
									<th>编号</th>
									<th>姓名</th>
									<th>性别</th>
									<th>年龄</th>
									<th>转正日期</th>
								</tr>
								<tr class="trs"></tr>
							</thead>
							<tbody>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<!--选项卡结束-->
		</div>
	</div>
	<div class="mbStyle">&nbsp;</div>
				<!--

   	高级搜索
   -->
			<div class="popupStyle" id="xxx" style="overflow-y: hidden;">
				<h1>
					立即转正<span class="closeX" onclick="closeMask()">X</span>
				</h1>
				<div class="p_height">&nbsp;</div>
				<form action="#" method="post" enctype="multipart/form-data"
					name="search">
					<table cellpadding="0" cellspacing="0" border="0" class="addTable">
						<tr>
							<td class="tdWidth">试用期到期日：</td>
							<td class="syq"></td>
							<td class="tdWidth">转正日期：</td>
							<td><input type="date" class="dateStyle"
								style="width:140px;" id="zzrq" /></td>
						</tr>
						<tr></tr>
						<tr>
							<td class="tdWidth"></td>
							<td class="tdWidth"></td>
							<td><input type="button" value="确认转正"
								class="saveButton" id="fangtansave" s /></td>
						</tr>
					</table>
				</form>
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

