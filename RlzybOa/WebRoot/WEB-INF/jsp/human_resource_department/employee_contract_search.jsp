<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>合同信息</title>


<link rel="stylesheet" type="text/css"
	href="statics/pcui/css/global.css" />
<link rel="stylesheet" type="text/css"
	href="statics/pcui/css/tablelist.css" />
<link rel="stylesheet" type="text/css" href="statics/pcui/css/page.css" />
<link rel="stylesheet" type="text/css" href="statics/pcui/css/form.css" />
<link rel="stylesheet" type="text/css" href="statics/pcui/css/popup.css" />
<link rel="stylesheet" type="text/css" href="statics/pcui/css/add.css" />
<link rel="stylesheet" type="text/css" href="statics/pcui/css/tab.css" />
<link rel="stylesheet" type="text/css" href="statics/pcui/css/index.css" />

<script type="text/javascript" src="statics/pcui/js/alert.js"></script>
<script type="text/javascript" src="statics/common/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="statics/pcui/js/index.js"></script>
<script type="text/javascript" src="statics/pcui/js/page.js"></script>
<script type="text/javascript" src="statics/pcui/js/stulist.js"></script>
<script type="text/javascript" src="statics/pcui/js/tab.js"></script>
<script type="text/javascript" src="statics/pcui/js/contract.js"></script>

</head>
<body>
	<div class="rightContent">
		<div class="container">
			<!--选项卡开始-->
			<h1 class="tabTitle">
				<span>未签订</span>[<font color="#FF0000"></font>]
			</h1>
			<div class="tabs">
				<span class="spanHover" id="weiqian">未签订</span>
				<span class="spanOut" id="yiqian">已签订</span>
				<span class="spanOut" id="xuqian">已到期</span>
				<span class="spanOut" id="jijiang">即将到期</span>
			</div>
			<div class="tabContent">
				<div class="search"
					style="margin-top: 10px; border: 1px solid #E5E5E5; padding: 10px 0 10px 15px;">
					姓名：<input type="search" name="emp_name" id="emp_name" class="searchStyle" style="width:120px;" placeholder="请输入姓名" />
					合同编号：<input type="search" name="contract_id" id="contract_id" class="searchStyle" style="width:120px;" placeholder="请输入合同编号" />
						<input type="button" value="搜索" class="searchButton" id="chaxun" style="margin-left: 20px;" />
						 <input type="button" value="清空搜索" class="searchButton" id="qing" />
						 <input type="button" value="续签" id="xq" class="insertButton" />
						 <input type="hidden" name="pageIndex" id="index" />
				</div>
			</div>
			<!-- 未签 -->
			<div class="divTable">
				<table cellpadding="0" cellspacing="0" class="selectTable">
					<thead>
						<tr>
							<th>编号</th>
							<th>姓名</th>
							<th>岗位</th>
							<th>部门</th>
							<th>合同编号</th>
							<th>合同状态</th>
							<th>归属公司</th>
							<th>起始日期</th>
							<th>截止日期</th>
							<th>管理</th>
						</tr>
						<tr class="trs"></tr>
					</thead>
					<tbody></tbody>
				</table>
				<!-- 分页 start -->
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
			<!-- 已签 -->
			<div class="divTable" style="display:none;">
				<table cellpadding="0" cellspacing="0" class="selectTable">
					<thead>
						<tr>
							<th>编号</th>
							<th>姓名</th>
							<th>岗位</th>
							<th>部门</th>
							<th>合同编号</th>
							<th>合同状态</th>
							<th>归属公司</th>
							<th>起始日期</th>
							<th>截止日期</th>
							<th>管理</th>
						</tr>
						<tr class="trs"></tr>
					</thead>
					<tbody></tbody>
				</table>
				<!-- 分页 start -->
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
			<!-- 到期 -->
			<div class="divTable" style="display:none;">
				<table cellpadding="0" cellspacing="0" class="selectTable">
					<thead>
						<tr>
							<th>编号</th>
							<th>姓名</th>
							<th>岗位</th>
							<th>部门</th>
							<th>合同编号</th>
							<th>合同状态</th>
							<th>归属公司</th>
							<th>起始日期</th>
							<th>截止日期</th>
							<th>管理</th>
						</tr>
						<tr class="trs"></tr>
					</thead>
					<tbody></tbody>
				</table>
				<!-- 分页 start -->
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
			<!-- 即将 -->
			<div class="divTable" style="display:none;">
				<table cellpadding="0" cellspacing="0" class="selectTable">
					<thead>
						<tr>
							<th>编号</th>
							<th>姓名</th>
							<th>岗位</th>
							<th>部门</th>
							<th>合同编号</th>
							<th>合同状态</th>
							<th>归属公司</th>
							<th>起始日期</th>
							<th>截止日期</th>
							<th>管理</th>
						</tr>
						<tr class="trs"></tr>
					</thead>
					<tbody></tbody>
				</table>
				<!-- 分页 start -->
				<div class="pageStyle">
					<div class="pagecount">
						<span class="txtLeft">每页显示</span>
						<div class="total">
							<select name="tota4">
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
						<input type="text" name="pageNo3" />
						<img src="statics/common/images/fdj.png" class="imgSearch" />
					</div>
					<div class="page" id="page3">&nbsp;</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	<div class="mbStyle">&nbsp;</div>

	<div class="popupStyle" id="yyy" style="overflow: hidden;">
		<h1>
			合同详细信息<span class="closeX" onclick="closeMask('yyy')">X</span>
		</h1>
		<div class="p_height">&nbsp;</div>
		<table cellpadding="0" cellspacing="0" border="0" class="addTable">
			<tr>
				<td class="tdWidth"><span>*</span>姓名：</td>
				<td id="emp_name1">张三</td>
			</tr>
			<tr>
				<td class="tdWidth">合同编号：</td>
				<td id="contract_id">123456</td>
			</tr>
			<tr>

				<td class="tdWidth">部门：</td>
				<td id="depart_name">校长办公室</td>
			</tr>
			<tr>
				<td class="tdWidth">岗位：</td>
				<td id="position_name">学士教质经理</td>
			</tr>
			<tr>

				<td class="tdWidth">归属公司：</td>
				<td id="contract_belong_company">山西多元合创教育科技有限公司</td>
			</tr>
			<tr>
				<td class="tdWidth">起始日期：</td>
				<td id="contract_startDate">2017/07/24</td>
			</tr>
			<tr>
				<td class="tdWidth">截止日期：</td>
				<td id="contract_endDate">2017/10/24</td>
			</tr>
		</table>
	</div>
	<div class="popupStyle" id="zzzz">
		<h1>
			添加合同<span class="closeX" onclick="closeMask('sss')">x</span>
		</h1>
		<div class="p_height">&nbsp;</div>
		<form action="employee_contract_add" method="post" enctype="multipart/form-data" name="newInsert">
			<table cellpadding="0" cellspacing="0" border="0" class="addTable">
				<tr>
					<td class="tdWidth"><span>*</span>姓名：</td>
					<td id="empname"></td>
				</tr>
				<tr>
					<td class="tdWidth"><span>*</span>合同编号：</td>
					<td><input type="text" id="contract_id1" name="contract_id" class="textStyle" style="width:120px;" />
					<span class="existence" name="existence">请输入合同编号</span>
				</td>
				</tr>
				<tr>
					<td class="tdWidth">部门：</td>
					<td id="departname" bm name="depart_id">校长办公室</td>
				</tr>
				<tr>
					<td class="tdWidth">岗位：</td>
					<td id="positionname" gw name="position_id">学术教质经理</td>
				</tr>
				<tr>
					<td class="tdWidth">起始日期：</td>
					<td><input type="date" id="qishiDate" name="contract_startDate" class="dateStyle" style="width:140px;" />
						<span class="existence" name="existence"></span>
					</td>
				</tr>
				<tr>
					<td class="tdWidth">截止日期：</td>
					<td><input type="date" id="jiezhiDate" name="contract_endDate" class="dateStyle" style="width:140px;" />
						<span class="existence" name="existence"></span>
					</td>
				</tr>
				<tr>
					<td class="tdWidth">归属公司：</td>
					<td><select name="contract_company" style="width:230px;">
							<option value="山西多元合创教育科技有限公司">山西多元合创教育科技有限公司</option>
							<option value="太原市多元职业培训学校">太原市多元职业培训学校</option>
							<option value="太原市映辉科技有限公司">太原市映辉科技有限公司</option>
					</select></td>
				</tr>
				<tr style="text-align: center;">
					<td colspan="6"><input type="button" value="保存" id="bc" class="saveButton" /></td>
				</tr>
			</table>
		</form>
	</div>
	<!--蒙板开始-->
	<div class="zzDiv"></div>
	<!--蒙板结束-->
	<!--提醒开始-->

	<div class="remind">
		<span class="reText"></span>
		<span class="closeWin" onClick="hideRemind()">X</span>
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
			<div class="d_bt_ok" xq></div>
			<div class="d_bt_cancel"></div>
		</div>
	</div>
	<!--删除成功结束-->
</body>
</html>
