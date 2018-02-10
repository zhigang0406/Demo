<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>新增功能信息</title>
<link rel="stylesheet" type="text/css"
	href="statics/common/css/index.css">
<link rel="stylesheet" type="text/css"
	href="statics/common/css/insert.css">
<link rel="stylesheet" type="text/css" href="statics/common/css/all.css">
<link rel="stylesheet" type="text/css" href="statics/common/css/zt.css">
<link rel="stylesheet" type="text/css"
	href="statics/common/css/formStyle.css" />
<link rel="stylesheet" type="text/css" href="statics/common/css/add.css" />
<link rel="stylesheet" type="text/css"
	href="statics/common/css/switch.css">
<link rel="stylesheet" type="text/css" href="statics/pcui/css/index.css">
<script type="text/javascript" src="statics/pcui/js/alert.js"></script>
<script src="statics/pcui/js/jquery-1.8.3.js"></script>
<script src="statics/pcui/js/index.js"></script>
<script type="text/javascript">
    $(function() {
		$(".textStyle").change(function(){
			var function_name=$("#function_name").val();
			var function_url=$("#function_url").val();
			if (function_name=="" || function_url==""){
			   	$("#submit").attr("disabled", "disabled");
			   	$("#submit").next().text("请确认信息完整性");
			}else{
			    $("#submit").removeAttr("disabled");
			    $("#submit").next().text("");
			}
		});
	});
    </script>
</head>
<body>
	<div class="rightContent">
		<div class="tabContent">
			<h1 class="tabTitle">修改密码</h1>
			<form action="pwdupdata/pwdUpdata" method="post">
				<table cellpadding="0" cellspacing="0" border="0" class="addTable">
					<tr>
						<td class="tdWidth" style="width: 200px"><span>*</span>请输入旧密码：</td>
						<td><input type="password" class="textStyle" id="old_pwd"
							name="old_pwd" style="width:160px;" /><span></span></td>
					</tr>
					<tr>
						<td class="tdWidth"><span>*</span>请输入新密码：</td>
						<td><input type="password" class="textStyle" id="new_pwd"
							name="new_pwd" style="width:160px;" /><span></span></td>
					</tr>
					</table>
				<h2 class="tabTitle2">&nbsp;</h2>
				<div class="btposition1">
					<input type="submit" id="submit" disabled="disabled" value="保存" class="saveBotton" /><span></span>
				</div>
			</form>
		</div>
	</div>
	<!--保存成功-->
	<div class="saveAlert"></div>
	<!--保存成功结束-->

</body>
</html>