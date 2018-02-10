<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>查询离岗信息</title>
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
<script type="text/javascript" src="statics/common/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="statics/pcui/js/index.js"></script>
<script type="text/javascript" src="statics/pcui/js/page.js"></script>
<script type="text/javascript" src="statics/pcui/js/stulist.js"></script>
<script type="text/javascript" src="statics/pcui/js/tab.js"></script>
<script type="text/javascript" src="statics/pcui/laydate/laydate.js"></script>
<script type="text/javascript" src="statics/pcui/js/requestleave_search.js"></script>
<style type="text/css">
.deleteStyle {
	position: absolute;
	top: 200px;
	left: 580px;
}
</style>
<script type="text/javascript">
	function show(index){
	$("[name=pageIndex]").attr("value",index);
		SelectAllInfo();
	
	}
	/*删除弹出框点击确定或者取消*/
	function subForm(result){
		if(result){
			 showWebAlert('删除成功，哈哈！');   
		} 
	}
/*结束*/
</script>
<style>
/*  *{ border:solid black 1px }*/
</style>
</head>
<body>
<div class="container">
	<div class="rightContent">

		<div class="tabContent">
			<h1 class="tabTitle">
				员工离岗信息[<font class="fofofo" color="#FF0000">0</font>]
			</h1>
			<form method="post" id="searchCondition">
				<div class="serach">
					姓名：<input type="search" placeholder="请输入姓名" value=""
						name="leave_approver" id="name" class="searchStyle" style="width:120px;">

					部门：
					<td><select class="selectStyle" name="depart_id"
						id="depart_id" style="width:120px;margin-right:18px ;">
							<option value="0">请选择</option>
					</select></td> 类型：
					<td><select class="selectStyle" name="leave_type"
						id="leave_type" style="width:120px;">
							<option value="0">请选择</option>
					</select></td> <input type="button" value="搜索" class="searchBotton"
						name="searchLeave" id="searchLeave" onclick="SelectAllInfo()" />
						<input
						type="button" s sc value="删除" class="deleteButton" id="dedede" />
					<input type="button" f g h value="复职" class="returnButton"
						id="rerere" /> <input type="hidden" name="pageIndex" value="1" />
						 <input type="hidden" name="pageSize" value="10" />
						 <input type="button" value="清空搜索条件" id="clearCondition"
							class="searchBotton" style='width:120px' id="qing" />
				</div>

			</form>
		</div>

		<table cellpadding="0" cellspacing="0" border="0" class="selectTable"
			id="tableData">
			<thead>
				<tr>
					<th>编号</th>
					<th>姓名</th>
					<th>岗位</th>
					<th>部门</th>
					<th>请假类别</th>
					<th>请假原因</th>
					<th>批准人</th>
					<th>复职状态(针对产假)</th>
					<th>起始日期</th>
					<th>截止日期</th>
				</tr>
				<tr class="trs" style="display: none;">
					<td colspan='10' style='color:red'>没有可供查看的数据</td>
				</tr>
			</thead>
			<tbody class="divTable">
			</tbody>
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
					src="statics/pcui/images/fdj.png" class="imgSearch" id="imgSearch"/>
			</div>
			<div class="page" id="page">&nbsp;</div>

		</div>

	</div>
	<!--弹出框-->
	<div class="mbStyle">&nbsp;</div>
	<div class="popupStyle" id="yyy">
		<h1>
			查看离岗记录<span class="closeX" onclick="closeMask()">x</span>
		</h1>
		<table cellpadding="0" cellspacing="0" border="0" class="addTable">
			<tr>
				<td class="tdWidth"><span>*</span>部门：</td>
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
				<td class="tdWidth">起始时间：</td>
				<td class="leave_startDate_str"></td>
			</tr>
			<tr>
				<td class="tdWidth">截止日期：</td>
				<td class="leave_endDate_str"></td>
			</tr>
			<tr>
				<td class="tdWidth">离岗原因：</td>
				<td class="leave_reason"></td>
			</tr>
			<tr>
				<td class="tdWidth">类型：</td>
				<td class="leave_type"></td>
			</tr>
			<tr>
				<td class="tdWidth">批准人：</td>
				<td class="leave_approver"></td>
			</tr>
		</table>
	</div>
	<div class="popupStyle" id="tankuang">
		<h1>
			产假复职<span class="closeX" onclick="closeMask('xxx')">X</span>
		</h1>
		<div class="p_height">&nbsp;</div>
		<form method="post" id="searchConditio">
			<table cellpadding="0" cellspacing="0" border="0" class="addTable">
				<tr>
					<td class="tdWidth">复职日期：</td>
					<td><input type="date" id="shijian" class="dateStyle"
						style="width:160px;" /></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td><input type="button" f g h onclick="checkEmployeeGoBack()"
						id="baocun" value="保存" class="searchButton"
						onclick="SelectAllInf()" /></td>
				</tr>
			</table>
		</form>
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
			<div class="d_bt_ok" s sc></div>
			<div class="d_bt_cancel"></div>
		</div>
	</div>
	<!--删除成功结束-->
</body>
</html>

