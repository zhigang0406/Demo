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
<title>查询访谈信息</title>
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
	width: 100px;
	font-weight: bold;
}
</style>
<script type="text/javascript" src="statics/pcui/js/alert.js"></script>
<script type="text/javascript" src="statics/pcui/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="statics/pcui/js/index.js"></script>
<script type="text/javascript" src="statics/pcui/js/page.js"></script>
<script type="text/javascript" src="statics/pcui/js/stulist.js"></script>
<script type="text/javascript" src="statics/pcui/js/tab.js"></script>
<script type="text/javascript" src="statics/pcui/js/interview_search.js"></script>
<script type="text/javascript">
	function show(index) {
		newsLoad(index);
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
				员工访谈信息[<span style="color: red;">5</span>]
			</h1>
			<div class="tabContent">
				<div class="divTable">
					<!--搜索区开始-->
					<div class="serach">
						姓名: <input type="search" class="searchStyle" id="emp_name"
							style="width:120px;" placeholder="请输入姓名" /> 部门： <select
							class="selectStyle" name="depart_id" id="selectStyle"
							style="width:120px;margin-right:18px ;">
							<option value="0">--请选择--</option>
							<c:if test="${oaRlzybDepartments != null }">
								<c:forEach items="${oaRlzybDepartments }"
									var="oaRlzybDepartment">
									<option value="${oaRlzybDepartment.depart_id }">${oaRlzybDepartment.depart_name }</option>
								</c:forEach>
							</c:if>
						</select> <input type="button" value="搜索" class="searchButton" id="search" />
						<input type="button" value="高级搜索" class="searchButton" id="select" />
						<input type="button" value="删除" class="deleteButton"
							id="deleteButton" /> <input type="button" value="清空搜索"
							class="searchButton" id="clen" />
					</div>
					<!--搜索区结束-->
					<div class="tableInfo">
						<table cellpadding="0" cellspacing="0" border="0"
							class="selectTable" id="tableData">
							<thead>
								<tr>
									<th>编号</th>
									<th>被访谈人</th>
									<th>被访谈人部门</th>
									<th>被访谈人岗位</th>
									<th>访谈人</th>
									<th>访谈人部门</th>
									<th>访谈人岗位</th>
									<th>访谈时间</th>
									<th>访谈记录人</th>
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
									<select name="total" id="total" value="">
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
								<input type="text" name="pageNo" value="" /> <img
									src="statics/common/images/fdj.png" class="imgSearch" />
							</div>
							<div class="page" id="page">&nbsp;</div>

						</div>


					</div>


				</div>
			</div>
			<!--选项卡结束-->



		</div>
		<!--弹出窗-->
		<div class="mbStyle">&nbsp;</div>
		<div class="popupStyle" id="xxx" style="overflow-y:hidden;">
			<h1>
				高级搜索<span class="closeX" onclick="closeMask('xxx')">X</span>
			</h1>
			<div class="p_height">&nbsp;</div>
			<form action="#" method="post" enctype="multipart/form-data"
				name="search">
				<table cellpadding="0" cellspacing="0" border="0" class="addTable">
					<tr>
						<td class="tdWidth">访谈人姓名：</td>
						<td><input type="search" class="searchStyle"
							id="interview_person" style="width:120px;" placeholder="请输入姓名" />
						</td>
						<td class="tdWidth">访谈日期：</td>
						<td><input type="date" class="dateStyle" id="interview_date"
							style="width:140px;" /></td>
					</tr>
					<tr>
						<td class="tdWidth"></td>
						<td><input type="button" value="搜索" class="searchButton"
							id="searchButton" /></td>
					</tr>
				</table>
			</form>
		</div>
		<!--学员详细信息-->

		<div class="popupStyle" id="yyy" style="overflow: hidden;">
			<h1>
				员工访谈信息<span class="closeX" onclick="closeMask('yyy')">X</span>
			</h1>
			<div class="p_height">&nbsp;</div>
			<table cellpadding="0" cellspacing="0" border="0" class="addTable">
				<tr class="tdj">
					<td class="tdWidth"><span>*</span>被访谈人：</td>
					<td>张三</td>

					<td class="tdWidth">被访谈人部门：</td>
					<td>29岁</td>

					<td class="tdWidth">被访谈人岗位：</td>
					<td>女</td>
				</tr>
				<tr class="tdi">
					<td class="tdWidth">访谈人：</td>
					<td>上网</td>

					<td class="tdWidth">访谈人部门：</td>
					<td>ZhangSan</td>

					<td class="tdWidth">访谈人岗位：</td>
					<td>877218421@qq.com</td>
				</tr>
				<tr class="tdd">
					<td class="tdWidth">访谈时间：</td>
					<td>2017/08/09 12:00</td>

					<td class="tdWidth">访谈原因：</td>
					<td>ZhangSan</td>
				</tr>
				<tr class="tdc">
					<td class="tdWidth">访谈内容：</td>
					<td colspan="5"><textarea
							style="width:300px; height:60px; margin-top:50px;"></textarea></td>
				</tr>
				<tr class="tdr">
					<td class="tdWidth">访谈记录人：</td>
					<td>mmmmm</td>
				</tr>
			</table>

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

