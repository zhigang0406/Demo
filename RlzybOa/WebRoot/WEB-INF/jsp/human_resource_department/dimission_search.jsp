
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
<title>查询离职信息</title>


<link rel="stylesheet" type="text/css" href="statics/pcui/css/global.css" />
<link rel="stylesheet" type="text/css" href="statics/pcui/css/tablelist.css" />
<link rel="stylesheet" type="text/css" href="statics/pcui/css/page.css" />
<link rel="stylesheet" type="text/css" href="statics/pcui/css/form.css" />
<link rel="stylesheet" type="text/css" href="statics/pcui/css/popup.css" />
<link rel="stylesheet" type="text/css" href="statics/pcui/css/add.css" />
<link rel="stylesheet" type="text/css" href="statics/pcui/css/tab.css" />
<link rel="stylesheet" type="text/css" href="statics/pcui/css/index.css" />
<script type="text/javascript" src="statics/pcui/js/alert.js"></script>
<script type="text/javascript" src="statics/pcui/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="statics/pcui/js/index.js"></script>
<script type="text/javascript" src="statics/pcui/js/page.js"></script>
<script type="text/javascript" src="statics/pcui/js/stulist.js"></script>
<script type="text/javascript" src="statics/pcui/js/tab.js"></script>
<script type="text/javascript" src="statics/pcui/js/dimission.js"></script>
<style type="text/css">
.deleteStyle {
	position: absolute;
	top: 200px;
	left: 580px;
}
</style>

</head>
<body>
	<div class="rightContent">
		<div class="container">
			<h1 class="tabTitle">
				<span>离职信息</span>[<font class="fofofo" color="#FF0000"></font>]
			</h1>
			</h2>
			<div class="tabs">
				<span class="spanHover" id="daili">待离信息</span> 
				<span class="spanOut" id="yili">已离信息</span>
				<span class="spanOut" id="tingxin">停薪留职</span>
			</div>
			<div class="tabContent">
				<div class="search" style="margin-top: 10px; border: 1px solid #E5E5E5; padding: 10px 0 10px 15px;">
				姓名: <input type="search" id="emp_names" class="searchStyle" style="width:120px;" placeholder="请输入姓名" />
					<input type="button" id="chaxun" value="搜索" class="searchButton" style="margin-left: 20px;" />
					<input type="button" id="qing" value="清空搜索" class="searchButton" />
					<input type="button" value="删除" id="deleteButton" class="deleteButton" /> 
					<input type="hidden" name="pageIndex" id="pageIndex" value="1" />
				</div>
			<!-- 待离 -->
			<div class="divTable">
				<table cellpadding="0" cellspacing="0" class="selectTable">
					<thead>
						<tr>
							<th>编号</th>
							<th>离职员工</th>
							<th>离职员工部门</th>
							<th>离职员工岗位</th>
							<th>离职时间</th>
							<th>登记人</th>
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
			<!-- 已离 -->
			<div class="divTable" style="display:none;">
				<table cellpadding="0" cellspacing="0" class="selectTable">
					<thead>
						<tr>
							<th>编号</th>
							<th>离职员工</th>
							<th>离职员工部门</th>
							<th>离职员工岗位</th>
							<th>离职时间</th>
							<th>登记人</th>
						</tr>
						<tr class="trs"></tr>	
					</thead>
					<tbody></tbody>
				</table>
				<div class="pageStyle">
					<div class="pagecount">
						<span class="txtLeft">每页显示</span>
						<div class="total">
							<select name="tota2">
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
						<input type="text" name="pageNo1" />
						<img src="statics/common/images/fdj.png" class="imgSearch" />
					</div>
					<div class="page" id="page1">&nbsp;</div>
				</div>
			</div>
			<!-- 停薪 -->
			<div class="divTable" style="display:none;">
				<table cellpadding="0" cellspacing="0" class="selectTable">
					<thead>
						<tr>
							<th>编号</th>
							<th>离职员工</th>
							<th>离职员工部门</th>
							<th>离职员工岗位</th>
							<th>离职时间</th>
							<th>登记人</th>
						</tr>
						<tr class="trs"></tr>		
					</thead>
					<tbody></tbody>
				</table>
				<div class="pageStyle">
					<div class="pagecount">
						<span class="txtLeft">每页显示</span>
						<div class="total">
							<select name="tota3">
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
						<input type="text" name="pageNo2" />
						<img src="statics/common/images/fdj.png" class="imgSearch" />
					</div>
					<div class="page" id="page2">&nbsp;</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	<div class="mbStyle">&nbsp;</div>
	<div class="popupStyle" id="xxx">
		<h1>
			高级搜索<span class="closeX" onclick="closeMask('xxx')">X</span>
		</h1>
		<div class="p_height">&nbsp;</div>
		<form action="#" method="post" enctype="multipart/form-data" name="search">
			<table cellpadding="0" cellspacing="0" border="0" class="addTable">
				<tr>
					<td class="tdWidth">起始日期：</td>
					<td><input type="date" id="dimission_date1" class="dateStyle" style="width:140px;" /></td>
				</tr>
				<tr>
					<td class="tdWidth">截止日期：</td>
					<td><input type="date" id="dimission_date2" class="dateStyle" style="width:140px;" /></td>
				</tr>
				<tr>
					<td class="tdWidth"></td>
					<td><input type="button" value="搜索" class="searchButton" id="searchButton" /></td>
				</tr>
			</table>
		</form>
	</div>

	<div class="popupStyle" id="yyy" style="overflow: hidden;">
		<h1>
			离职信息<span class="closeX" onclick="closeMask('yyy')">X</span>
		</h1>
		<div class="p_height">&nbsp;</div>
		<table cellpadding="0" cellspacing="0" border="0" class="addTable">
			<tr>
				<td class="tdWidth"><span>*</span>离职员工：</td>
				<td id="emp_name">张三</td>
			</tr>
			<tr>
				<td class="tdWidth">离职部门：</td>
				<td id="depart_name">校长办公室</td>
			</tr>
			<tr>

				<td class="tdWidth">离职岗位：</td>
				<td id="position_name">学术教质经理</td>
			</tr>
			<tr>
				<td class="tdWidth">离职时间：</td>
				<td id="dimission_date">2017-07-24</td>
			</tr>
			<tr>
				<td class="tdWidth">离职原因：</td>
				<td id="dimission_reason">阿瑟发动</td>
			</tr>
			<tr>
				<td class="tdWidth">登记人：</td>
				<td id="dimission_approver">李四</td>
			</tr>
		</table>
	</div>
	<!--蒙板开始-->
	<div class="zzDiv"></div>
	<!--蒙板结束-->
	<!--提醒开始-->

	<div class="remind">
		<span class="reText"></span><span class="closeWin" onClick="hideRemind()">X</span>
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

