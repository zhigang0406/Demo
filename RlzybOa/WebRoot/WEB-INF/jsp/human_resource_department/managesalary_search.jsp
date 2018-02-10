<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>查询调薪信息</title>
<link rel="stylesheet" type="text/css" href="statics/pcui/css/page.css">
<link rel="stylesheet" type="text/css" href="statics/pcui/css/tab.css">
<link rel="stylesheet" type="text/css"
	href="statics/pcui/css/tablelist.css">
<link rel="stylesheet" type="text/css"
	href="statics/pcui/css/global.css" />
<link rel="stylesheet" type="text/css" href="statics/pcui/css/add.css" />
<link rel="stylesheet" type="text/css" href="statics/pcui/css/form.css" />
<link rel="stylesheet" type="text/css" href="statics/pcui/css/popup.css" />
<link rel="stylesheet" type="text/css" href="statics/pcui/css/index.css" />
<style type="text/css">
.tdWidth {
	width: 80px;
	font-weight: bold;
}
</style>
<script type="text/javascript" src="statics/pcui/js/alert.js"></script>
<script type="text/javascript" src="statics/pcui/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="statics/pcui/js/index.js"></script>
<script type="text/javascript" src="statics/pcui/js/page.js"></script>
<script type="text/javascript" src="statics/pcui/js/stulist.js"></script>
<script type="text/javascript" src="statics/pcui/js/tab.js"></script>
<script type="text/javascript" src="statics/pcui/laydate/laydate.js"></script>
<script type="text/javascript" src="statics/pcui/js/managesalary_search.js"></script>
<script type="text/javascript">
	function show(index){
		showDate(index);
	}
	/*删除弹出框点击确定或者取消*/
	function subForm(result){
		if(result){
			 showWebAlert('删除成功，哈哈！');   
		} 
	}
/*结束*/
</script>
</head>
<body>
	<div>
		<div class="container">
			<h1 class="tabTitle">
				员工调薪信息[<font color="#FF0000">15</font>]
			</h1>
			<!--搜索区开始-->
			<div class="serach">
				姓名： <input type="search" id="emp_name" class="searchStyle"
					style="width:120px;" placeholder="请输入姓名" /> 
					部门： <select
					class="selectStyle" name="depart_id" id="depart_id"
					style="width:120px;margin-right:18px ;">
					<option value="0">--请选择--</option>
					<c:if test="${oaRlzybDepartments != null }">
						<c:forEach items="${oaRlzybDepartments }" var="oaRlzybDepartment">
							<option value="${oaRlzybDepartment.depart_id }">${oaRlzybDepartment.depart_name }</option>
						</c:forEach>
					</c:if>
				</select> <input type="button" value="搜索" class="searchButton" id="search" />
				<input type="button" value="高级搜索" class="searchButton" id="select" />
				<input type="button" value="删除" class="deleteButton" />
				<input type="button" value="清空搜索" class="searchButton"
							id="clen" />
			</div>
			<!--搜索区结束-->

			<div class="tableInfo">
				<table cellpadding="0" cellspacing="0" border="0"
					class="selectTable" id="tableData">
					<thead>
						<tr>
							<th>编号</th>
							<th>姓名</th>
							<th>部门</th>
							<th>岗位</th>
							<th>调薪原因</th>
							<th>调薪前薪资</th>
							<th>调薪后薪资</th>
							<th>调薪日期</th>
						</tr>
						<tr class="trs"></tr>
					</thead>
					<tbody>
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
							src="statics/common/images/fdj.png" class="imgSearch" />
					</div>
					<div class="page" id="page">&nbsp;</div>

				</div>
			</div>

		</div>
		<!--学员详细信息-->
		<div class="mbStyle">&nbsp;</div>
		<div class="popupStyle" id="yyy" style="overflow: hidden;">
			<h1>
				查看调薪记录<span class="closeX" onclick="closeMask('yyy')">X</span>
			</h1>
			<table cellpadding="0" cellspacing="0" border="0" class="addTable">
				<tr>
					<td class="tdWidth"><span>*</span>部门：</td>
					<td>人力资源部</td>
				</tr>
				<tr>
					<td class="tdWidth">姓名：</td>
					<td>杨国梁</td>
				</tr>
				<tr>
					<td class="tdWidth">部门：</td>
					<td>技术支持</td>
				</tr>
				<tr>
					<td class="tdWidth">岗位：</td>
					<td>技术支持</td>
				</tr>
				<tr>
					<td class="tdWidth">调薪前薪资：</td>
					<td>3000</td>
				</tr>
				<tr>
					<td class="tdWidth">调薪后薪资：</td>
					<td>5000</td>
				</tr>
				<tr>
					<td class="tdWidth">调薪原因：</td>
					<td>调级</td>
				</tr>
				<tr>
					<td class="tdWidth">调薪说明：</td>
					<td>10月起由一级教员调至二级教员</td>
				</tr>
			</table>
		</div>
		<!--高级搜索-->
		<div class="popupStyle" id="xxx" style="overflow: hidden;">
			<h1>
				高级搜索<span class="closeX" onclick="closeMask('xxx')">X</span>
			</h1>
			<div class="p_height">&nbsp;</div>
			<form action="#" method="post" enctype="multipart/form-data"
				name="search">
				<table cellpadding="0" cellspacing="0" border="0" class="addTable">

					<tr>
						<td class="tdWidth">调薪日期：</td>
						<td><input type="date" class="dateStyle" id="create_time"
							style="width:140px;" /></td>
						<td class="tdWidth">岗位：</td>
						<td><select name="position_id" id="position_id"
							class="searchStyle" style="width:200px;">
								<option value="0">--请选择--</option>
								<c:if test="${oaRlzybPositions != null }">
									<c:forEach items="${oaRlzybPositions }" var="oaRlzybPosition">
										<option value="${oaRlzybPosition.position_id }">${oaRlzybPosition.position_name }</option>
									</c:forEach>
								</c:if>
						</select></td>
					</tr>
					<tr>
						<td class="tdWidth"></td>
						<td><input type="button" value="搜索" class="searchButton"
							id="searchButton" /></td>
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
			<div class="d_bt_ok" s></div>
			<div class="d_bt_cancel"></div>
		</div>
	</div>
	<!--删除成功结束-->
</body>
</html>

