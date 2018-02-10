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
<title>查询人才储备信息</title>


<link rel="stylesheet" type="text/css"
	href="statics/common/css/formStyle.css" />
<!--  
<link rel="stylesheet" type="text/css" href="statics/pcui/css/tab.css">-->

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
<script type="text/javascript">
/*表格全选*/
$(function(){

		$("[name=total]").change(function(){
		showDate(1);
		});
		$("#imgSearch").click(function(){
			var index = $("[name=pageNo]").val();
			if(isNaN(index)){
				alert("请输入正确的数字");
			}else{
				showDate(index);
			}
			$("[name=pageNo]").val("");
		});
	  $("#all").click(function(){
        var checked=$(this).is(":checked");
        $(".selectTable tr td").children().attr("checked",checked);
      });
});
	$(function(){
	    var saveWidth=$(window).width();
	    var saveHeight=$(window).height();
		$(".saveStyle").css("left",saveWidth/2-130);
		$(".saveStyle").css("top",saveHeight/2-40);
	
	});
	function showage(age){
	var agestr = $(".dateStyle").val();
	var agestr1 = agestr.substring(0,4); 
	var today =  new Date();
	var year = today.getFullYear();
	$("#age").val(year-agestr1);
	}

	function showDate(index){
	  	//获得搜索条件
		var position_id = $("#position_id").val();
		var page = $("[name=total]").val();
		$(".selectTable tbody").html("");
		var $ttr = $("<tr></tr>");
		   var $tdd = $("<td colspan='9'></td>");
		   var $img = $("<img src='/RlzybOa/statics/pcui/images/loading2.gif' />");
		   $tdd.append($img);
		   $ttr.append($tdd);
		$(".selectTable tbody").html($ttr);
	  	$.ajax({
			type:"POST",
			url:"talentReserve_search",
			dataType:"json",
			data:{
				position_id:position_id,
				pageIndex:index,
				pageSize:page
			},
			success: showList,
			error:function(){
				alert("数据不存在");
			}
		});
	 }

	 function showList(data){
		var datas = eval("("+data+")");
		
	  	var pageCount = datas.totalPageCount;
	  	
	  	var index= datas.currentPageNo;
	  	var count = datas.totalCount;
	  	var oaRlzybTalentPools = datas.oaRlzybTalentPools;
	  		$(".tabTitle font").text(count);
	  	showStuList(oaRlzybTalentPools);
	  	if(oaRlzybTalentPools.length!=0){
			$(".pageStyle").css("display","block");
			showPage(index,pageCount,count)
		}else{
			$(".pageStyle").css("display","none");
		}	
	 }
	
	function  baocun(){
		//获得姓名
		var empname=$("#empname").val();
		//出生日期
		var birth=$("#birth").val();
		//应聘日期
		var shiyong=$("#ruzhi").val();
		//电话号码
		var phone=$("#phone").val();
		if(empname!=""&&birth!=""&&shiyong!=""&&phone!=""){
			$(".tj").submit();
		}else{
			closeMask();
			showWebAlert("不可以有空选项!!");
		}
		
	}

		
		
	function showStuList(oaRlzybTalentPools){
	
	  	$(".selectTable tbody").html("");
	  	$(".selectTable thead .trs").html("");
			var str = "";
			
			if(oaRlzybTalentPools.length != 0){

			for(var i = 0;i < oaRlzybTalentPools.length; i++){
				str += "<tr sc=0 emp_id="+ oaRlzybTalentPools[i].talent_pool_id+">";
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
				
				str += "<td>" + id  + "</td>";
				str += "<td>" + oaRlzybTalentPools[i].talent_pool_name + "</td>";
				str += "<td>" + oaRlzybTalentPools[i].talent_pool_sex  + "</td>";
				str += "<td>" + oaRlzybTalentPools[i].talent_pool_age + "</td>";
				str += "<td>" + oaRlzybTalentPools[i].talent_pool_phone  + "</td>";
				str += "<td>" + oaRlzybTalentPools[i].position_name + "</td>";
				str += "<td>" + oaRlzybTalentPools[i].talent_pool_salaryExpect  + "</td>";
				str +=  "<td style='display:none;'>" + oaRlzybTalentPools[i].talent_pool_addTime  + "</td>";//应聘日期
				str +=  "<td style='display:none;'>" + oaRlzybTalentPools[i].talent_pool_birthday  + "</td>";//出生日期
				str +=  "<td style='display:none;'>" + oaRlzybTalentPools[i].talent_pool_work_experience  + "</td>";//工作经验
				str += "</tr>";
				}
		}else{
			$(".selectTable thead .trs").append("<td colspan='9' style='color:red'>没有可供查看的数据</td>");
		}
		$(".selectTable tbody").html(str);
		}
		
		$(".link").click(function(){
			var talent_pool_id = $(this).attr("talent_pool_id");
			location.href="talentReserve_show?talent_pool_id=" + talent_pool_id; 
			
		});
		
	
		
			


	 $(function(){
	  	showDate(1);
	  		
	  	$("#chaxu").click(function(){
	  		showDate(1);
	  		$(".d_bt_ok").attr("s","");
	  	});
	 });
$(function(){
	/*弹出框新增开始*/
	 $("#tianjia").click(function(){
		mask(1000,500,false,"newInsert",true);
		
	 });
	
	 /*弹出框新增结束*/
	$("#depart_id").change(function(){
		showPositionName();
	});
	$("#shanchu").click(function(){
	if($(".d_bt_ok").attr("s")==null||$(".d_bt_ok").attr("s")==""){
			showWebAlert('请先选择员工');   
		}else{
			deleteShowAlert("删除提示","确定要删除吗？","确定","取消");
	}	
	$(".d_bt_ok").click(function(){
		var leave_id = $(this).attr("s");
			$.ajax({
					url:"talentReserve_delete",
					data:{talent_pool_id:leave_id},
					success:function(data){
						showDate(1);
						$(".d_bt_ok").attr("s","");
					}
				});	
	})
	});
	//单击
		$(".selectTable").on("click","tbody tr",function() {
			var id = $(this).attr("emp_id");
			var sc = $(this).attr("sc");
			$(".d_bt_ok").attr("s",id);
			$(".uploadButton").attr("f",sc);
		});
		$(".selectTable tbody").on("dblclick","tr",function () {
			//var id = $(this).children("td:eq(0)").html();
            //测试弹出值 
            
			var name = $(this).children("td:eq(1)").html();
			var sex = $(this).children("td:eq(2)").html();
			var age = $(this).children("td:eq(3)").html();
			var phone = $(this).children("td:eq(4)").html();
			var position = $(this).children("td:eq(5)").html();
			var salaryExpect = $(this).children("td:eq(6)").html();
			var addtime = $(this).children("td:eq(7)").html();
			var birthday = $(this).children("td:eq(8)").html();
			var experience = $(this).children("td:eq(9)").html(); //原因
			
			$(".name").text(name);
			$(".sex").text(sex);
			$(".age").text(age);											
			$(".phone").text(phone);
			$(".position").text(position);
			$(".salaryExpect").text(salaryExpect);
			var addtim=addtime.substr(0,10);
			$(".addtime").text(addtim);
			var birthda=birthday.substr(0,10);
			$(".birthday").text(birthda);
			$(".experience").text(experience);
			
			/*初始化遮罩*/
			/*true顶部垂直居中*/
             mask(1000,800,false,"yyy");
              
           
             
		});
	
	});
	function showPositionName(){
		var depart_id = $("#depart_id").val();
		$.ajax({
			url:"showPositionName",
			dataType:"json",
			data:{
				depart_id:depart_id
			},
			success:showPosition
		});
	}
	
	function showPosition(data){
		$("#position_id").html("");
		
		var str = "";
		
		for(var i = 0;i < data.length; i++){
			str += "<option value=\"" + data[i].position_id + "\">" + data[i].position_name + "</option>";
		}
		
		$("#position_id").html(str);
	}
	
	function show(){
		showPositionName();
	}
	
	show();
	/*表格双击事件开始*/

		
		
/* 点击添加跳转到添加页面 */

$(function(){
	
	$("#addInfo").click(function(){
		NewPage("talentReserve-add.html");
	});
	
	$("#qing").click(function(){
	  		$("#depart_id").val("");
	  		$("#position_id").html("");
	  		showDate(1);
	  		$(".d_bt_ok").attr("s","");
	  	});
	
	
	
});
</script>
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
<div class="container">
	<div class="rightContent">
		<h1 class="tabTitle">
			人才储备信息[<font class="fofofo" color="#FF0000">0</font>]
		</h1>
		<div class="tabContent">
			<form method="post" action="talentReserve-sel.html">
				<div class="serach">
					应聘部门：
					<td><select name="depart_id" class="selectStyle"
						style="width:120px;" id="depart_id">
							<option value="">--请选择--</option>
							<c:if test="${oaRlzybDepartments != null }">
								<c:forEach items="${oaRlzybDepartments }"
									var="oaRlzybDepartments">
									<option value="${oaRlzybDepartments.depart_id }">${oaRlzybDepartments.depart_name }</option>
								</c:forEach>
							</c:if>
					</select></td> 应聘职位：
					<td><select id="position_id" class="selectStyle"
						name="position_id" style="width:120px;">

					</select></td>
					<td></td>
					<td><input type="button" value="搜索" class="searchBotton"
						id="chaxu" /> <input type="button" value="添加 "
						class="insertButton" id="tianjia"> <input type="button"
						value="删除" class="deleteButton" id="shanchu"> <input
						type="button" value="清空搜索条件" class="searchBotton"
						style='width:120px' id="qing" /></td>


				</div>
			</form>

			<div class="tableInfo">
				<table cellpadding="0" cellspacing="0" class="selectTable">
					<thead>
						<tr>
							<th>编号</th>
							<th>姓名</th>
							<th>性别</th>
							<th>年龄</th>
							<th>联系电话</th>
							<th>应聘职位</th>
							<th>薪资期望</th>
						</tr>
						<tr class="trs"></tr>
					</thead>
					<tbody></tbody>
				

				</table>
				<div class="pageStyle">
					<div class="pagecount">
						<span class="txtLeft">每页显示</span>
						<div class="total">
							<select name="total" id="total" value="">
								<option  value="10">10</option>
								<option  value="20">20</option>
								<option  value="50">50</option>
								<option  value="100">100</option>
							</select>
						</div>
						<span class="txtRight">条</span>
					</div>
					<div class="searchPage">
						<div class="txt">G0&nbsp;</div>
						<input type="text" name="pageNo" value=""/> <img src="statics/common/images/fdj.png" class="imgSearch" id="imgSearch"/>
						</div>
						<div class="page" id="page">&nbsp;</div>

				</div>




			</div>
		</div>
	</div>
	<div class="mbStyle">&nbsp;</div>
	<div class="popupStyle" id="yyy" style="overflow: hidden; ">
		<h1>
			查看人才储备信息<span class="closeX" onclick="closeMask()">x</span>
		</h1>
		<div class="p_height">&nbsp;</div>
		<table cellpadding="0" cellspacing="0" border="0" class="addTable">
			<tr>
				<td class="tdWidth">姓名：</td>
				<td class="name"></td>
			</tr>
			<tr>
				<td class="tdWidth">性别：</td>
				<td class="sex"></td>
			</tr>
			<tr>
				<td class="tdWidth">出生日期：</td>
				<td class="birthday"></td>
			</tr>
			<tr>
				<td class="tdWidth">年龄：</td>
				<td class="age"></td>
			</tr>
			<tr>
				<td class="tdWidth">应聘日期：</td>
				<td class="addtime"></td>
			</tr>
			<tr>
				<td class="tdWidth">应聘岗位：</td>
				<td class="position"></td>
			</tr>
			<tr>
				<td class="tdWidth">期望薪资：</td>
				<td class="salaryExpect"></td>
			</tr>
			<tr>
				<td class="tdWidth">联系电话：</td>
				<td class="phone"></td>
			</tr>
			<tr>
				<td class="tdWidth">工作经验：</td>
				<td class="experience"></td>
			</tr>
		</table>
	</div>
	<div class="popupStyle" id="newInsert" style="overflow:hidden;">
		<h1>
			添加人才储备信息<span class="closeX" onclick="closeMask()">x</span>
		</h1>
		<form action="talentReserve.html" method="post" class="tj">
			<div class="p_height">&nbsp;</div>
			<table cellpadding="0" cellspacing="0" border="0" class="addTable">
				<tr>
					<td class="tdWidth"><span>*</span>姓名：</td>
					<td><input type="text" name="talent_pool_name"
						class="textStyle" style="width:120px;" placeholder="请输入姓名" id="empname"/></td>
					<td class="tdWidth">年龄：</td>
					<td><input type="number" id="age" name="talent_pool_age"
						min="1" max="100" class="textStyle"
						style="width:120px; border-style: none;" readonly /></td>
					<td class="tdWidth">性别：</td>
					<td><input type="radio" name="talent_pool_sex" checked
						value="男" class="radioStyle" /> 男&nbsp;&nbsp;&nbsp;&nbsp; <input
						type="radio" value="女" name="talent_pool_sex" class="radioStyle" />
						女</td>

				</tr>

				<tr>
					<td class="tdWidth">出生日期：</td>
					<td><input type="date"  class="dateStyle"
						name="talent_pool_birthday" style="width:180px;"
						onchange="showage(this)" id="birth"/></td>
					<td class="tdWidth">应聘职位：</td>
					<td><select class="textStyle"  name="position_id"
						style="width:120px;" id="depart">
							<option value="0">--请选择--</option>
							<c:if test="${oaRlzybPositions != null}">
								<c:forEach var="oaRlzybPosition" items="${oaRlzybPositions }">
									<option value="${oaRlzybPosition.position_id }">${oaRlzybPosition.position_name }</option>
								</c:forEach>
							</c:if>
					</select></td>
					<td class="tdWidth">联系电话：</td>
					<td><input type="text" name="talent_pool_phone"
						class="textStyle" style="width: 120px;" placeholder="请输入手机号"  id="phone"/></td>
				</tr>
				<tr>
					<td class="tdWidth">应聘日期：</td>
					<td><input type="date" name="talent_pool_addTime"
						class="dateStyle" id="ruzhi" style="width:180px;" /></td>
					<td class="tdWidth">薪资期望：</td>
					<td name="talent_pool_salaryExpect"><input type="number"
						style="width: 60px;" name="start" />~<input type="number"
						style="width: 60px;" name="end" /></td>

				</tr>
				<tr>
					<td class="tdWidth">工作经验：</td>
					<td colspan="5"><textarea name="talent_pool_work_experience"
							rows="5" cols="50"></textarea></td>
				</tr>
				<tr style="text-align: center;">
					<td colspan="6"><input type="button"  onclick="baocun()" value="保存" class="saveButton" /></td>
				</tr>
			</table>

		</form>
	</div>
	<div class="popupStyle" id="xiougai">
		<h1>
			编辑人才储备信息<span class="closeX" onclick="closeMask()">x</span>
		</h1>
		<form action="talentReserve_edit" method="post">
			<table cellpadding="0" cellspacing="0" border="0" class="addTable">
				<input type="hidden" value="${oaRlzybTalentPool.talent_pool_id }"
					id="talent_pool_id" name="talent_pool_id" />
				<tr>
					<td class="tdWidth">姓名：</td>
					<td><input type="text" class="textStyle" id="talent_pool_name"
						name="talent_pool_name" style="width: 100px"
						value="${oaRlzybTalentPool.talent_pool_name }"></td>
				</tr>
				<tr>
					<td class="tdWidth">性别：</td>
					<td><c:if test="${oaRlzybTalentPool.talent_pool_sex == '男' }">
							<input type="radio" name="talent_pool_sex" checked
								class="radioStyle" value="男">男
	          	&nbsp;&nbsp;<input type="radio" class="radioStyle"
								name="talent_pool_sex" value="女">女
	          </c:if> <c:if test="${oaRlzybTalentPool.talent_pool_sex == '女' }">
							<input type="radio" name="talent_pool_sex" class="radioStyle"
								value="男">男
	          	&nbsp;&nbsp;<input type="radio" class="radioStyle" checked
								name="talent_pool_sex" value="女">女
	          </c:if></td>
				</tr>
				<tr>
					<td class="tdWidth">出生日期：</td>
					<td><input type="date" name="talent_pool_birthday"
						id="talent_pool_birthday"
						value="${oaRlzybTalentPool.talent_pool_birthday }"
						class="dateStyle" style="width:160px;" onchange="showage(this)" /></td>
				</tr>
				<tr>
					<td class="tdWidth">年龄：</td>
					<td><input type="text" class="textStyle"
						value="${oaRlzybTalentPool.talent_pool_age }" id="talent_pool_age"
						name="talent_pool_age" style="width:160px;border-style: none"
						readonly />
				</tr>
				<tr>
					<td class="tdWidth">应聘日期：</td>
					<td><input type="date" class="dateStyle"
						id="talent_pool_addTime" name="talent_pool_addTime"
						value="${oaRlzybTalentPool.talent_pool_addTime }"
						style="width:160px;" /></td>
				</tr>
				<tr>
					<td class="tdWidth">应聘职位：</td>
					<td><select class="selectStyle" name="position_id"
						id="position_id" style="width:120px;">
							<option value="0">--请选择--</option>
							<c:if test="${oaRlzybPositions != null}">
								<c:forEach var="oaRlzybPosition" items="${oaRlzybPositions }">
									<c:if
										test="${oaRlzybTalentPool.position_id == oaRlzybPosition.position_id }">
										<option selected="selected"
											value="${oaRlzybPosition.position_id }">${oaRlzybPosition.position_name }</option>
									</c:if>
									<c:if
										test="${oaRlzybTalentPool.position_id != oaRlzybPosition.position_id }">
										<option value="${oaRlzybPosition.position_id }">${oaRlzybPosition.position_name }</option>
									</c:if>
								</c:forEach>
							</c:if>
					</select></td>
				</tr>
				<tr style="width: 400px">
					<td class="tdWidth">薪资期望：</td>
					<td><input type="text" class="textStyle"
						id="talent_pool_salaryExpect" style="width:120px;"
						name="talent_pool_salaryExpect"
						value="${oaRlzybTalentPool.talent_pool_salaryExpect }"
						readonly="readonly" /></td>
				</tr>
				<tr style="width: 400px">
					<td class="tdWidth"></td>
					<td><input type="number" class="textStyle"
						style="width:120px;" id="start" name="start">~<input
						class="textStyle" style="width:120px;" id="end" type="number"
						name="end"></td>
				</tr>
				<tr>
					<td class="tdWidth">联系电话：</td>
					<td><input type="text" class="textStyle" style="width:120px;"
						id="talent_pool_phone" name="talent_pool_phone"
						value="${oaRlzybTalentPool.talent_pool_phone }"></td>
				</tr>
				<tr>
					<td class="tdWidth">工作经验：</td>
					<td><textarea rows="5" cols="50"
							id="talent_pool_work_experience"
							name="talent_pool_work_experience">${oaRlzybTalentPool.talent_pool_work_experience }</textarea>
					</td>
				</tr>
			</table>
			<h2 class="tabTitle2">&nbsp;</h2>
			<div class="btposition1">
				<input type="submit" value="保存" class="saveBotton" />
			</div>
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
