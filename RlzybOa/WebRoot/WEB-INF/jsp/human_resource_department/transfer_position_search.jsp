<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>查询调岗信息</title>
<link rel="stylesheet" type="text/css"
	href="statics/common/css/index.css">
<link rel="stylesheet" type="text/css"
	href="statics/common/css/insert.css">
<link rel="stylesheet" type="text/css" href="statics/common/css/all.css">
<link rel="stylesheet" type="text/css" href="statics/common/css/zt.css">
<link rel="stylesheet" type="text/css"
	href="statics/common/css/search.css" />
<link rel="stylesheet" type="text/css"
	href="statics/common/css/formStyle.css" />
<link rel="stylesheet" type="text/css" href="statics/common/css/add.css" />
<link rel="stylesheet" type="text/css"
	href="statics/common/css/popup.css" />

<link rel="stylesheet" type="text/css"
	href="statics/pcui/css/global.css" />
<link rel="stylesheet" type="text/css"
	href="statics/pcui/css/tablelist.css" />
<link rel="stylesheet" type="text/css" href="statics/pcui/css/page.css" />
<link rel="stylesheet" type="text/css" href="statics/pcui/css/form.css" />
<link rel="stylesheet" type="text/css" href="statics/pcui/css/popup.css" />
<link rel="stylesheet" type="text/css" href="statics/pcui/css/add.css" />
<link rel="stylesheet" type="text/css" href="statics/pcui/css/tab.css" />

<script type="text/javascript" src="statics/common/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="statics/common/js/globle.js"></script>
<script type="text/javascript" src="statics/common/laydate/laydate.js"></script>

<script type="text/javascript" src="statics/pcui/js/alert.js"></script>
<script type="text/javascript" src="statics/pcui/js/page.js"></script>
<script type="text/javascript" src="statics/pcui/js/stulist.js"></script>
<script type="text/javascript" src="statics/pcui/js/tab.js"></script>
<script type="text/javascript" src="statics/pcui/js/transferposition.js"></script>

<style type="text/css">
.deleteStyle {
	position: absolute;
	top: 200px;
	left: 580px;
}
</style>

<style>
/*		*{border: black solid 1px;}*/
</style>
</head>
<body>
	<div class="rightContent">
		<div class="tabContent">
			<h1 class="tabTitle">
				<span>调岗信息</span>[<font class="fofofo" color="#FF0000">0</font>]
			</h1>
			</h2>
			<form method="post" action="transfer_position_search">
				<div class="serach">
					<table cellpadding="0" cellspacing="0" class="searchTable" border="0" style="width:100%;">
						<tr>
							<td class="tdWidth" style="text-align:left;">
								<span style="font-size: 16px">姓名：</span>&nbsp;
								<input type="text" id="emp_name" name="emp_name" class="textStyle" placeholder="请输入员工姓名" style="width:120px;height:30px " />&nbsp;&nbsp;
								<input type="button" value="搜索" id="chaxun" class="searchBotton" />
								<input type="button" value="清空搜索条件" class="searchBotton" style='width:120px' id="qing" />
								<span id="countId"></span>
							</td>
						</tr>
					</table>
					<input type="hidden" name="pageIndex" id="index" value="1" />
				</div>
			</form>
			<div class="divTable">
				<table cellpadding="0" cellspacing="0" class="selectTable">
					<thead>
						<tr>
							<th>编号</th>
							<th>姓名</th>
							<th>原部门</th>
							<th>原岗位</th>
							<th>调岗原因</th>
							<th>调岗后部门</th>
							<th>调岗后岗位</th>
							<th>调岗时间</th>
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
						<input type="text" name="pageNo" />
						<img src="statics/common/images/fdj.png" class="imgSearch" />
					</div>
					<div class="page" id="page">&nbsp;</div>
				</div>
			</div>
		</div>
		<div class="mbStyle">&nbsp;</div>
		<div class="deleteStyle">
			<h3>操作提示</h3>
			<h2>确定要删除吗？</h2>
			<div class="btn">
				<div class="bottomStyle1">确定</div>
				<div class="bottomStyle2">取消</div>
			</div>
		</div>
		<div class="popupStyle" id="yyy" style="overflow: hidden;">
			<h1>
				查看调岗信息<span class="closeX" onclick="closeMask('yyy')">X</span>
			</h1>
			<div class="p_height">&nbsp;</div>
			<table cellpadding="0" cellspacing="0" border="0" class="addTable">
				<tr>
					<td class="tdWidth"><span>*</span>姓名：</td>
					<td id="emp_name1">张三</td>
				</tr>
				<tr>
					<td class="tdWidth">原部门：</td>
					<td id="depart_name">咨询部</td>
				</tr>
				<tr>

					<td class="tdWidth">原岗位：</td>
					<td id="position_name">咨询主管</td>
				</tr>
				<tr>
					<td class="tdWidth">调岗后部门：</td>
					<td id="depart_name1">市场渠道部</td>
				</tr>
				<tr>

					<td class="tdWidth">调岗后岗位：</td>
					<td id="position_name1">市场活动专员</td>
				</tr>
				<tr>
					<td class="tdWidth">调岗原因：</td>
					<td id="transfer_position_reason">大啊啊啊啊大苏打萨达萨达</td>
				</tr>
				<tr>
					<td class="tdWidth">详情说明：</td>
					<td id="transfer_position_details">啊示范点发射点十分十分大师傅得分</td>
				</tr>
				<tr>
					<td class="tdWidth">调岗时间：</td>
					<td id="transfer_position_time">2017-12-13</td>
				</tr>
			</table>
		</div>
</body>
</html>
