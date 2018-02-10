<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html lang="en">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="multipart/form-data; charset="UTF-8">
<title>添加员工基本信息</title>
<link rel="stylesheet" type="text/css"
	href="statics/pcui/css/global.css">
<link rel="stylesheet" type="text/css"
	href="statics/pcui/css/tablelist.css">
<link rel="stylesheet" type="text/css" href="statics/pcui/css/page.css">
<link rel="stylesheet" type="text/css" href="statics/pcui/css/form.css" />
<link rel="stylesheet" type="text/css" href="statics/pcui/css/popup.css" />
<link rel="stylesheet" type="text/css" href="statics/pcui/css/add.css" />
<link rel="stylesheet" type="text/css" href="statics/pcui/css/tab.css">
<link rel="stylesheet" type="text/css" href="statics/pcui/css/index.css">
<link rel="stylesheet" type="text/css" href="statics/pcui/css/popup.css">
<script type="text/javascript" src="statics/pcui/js/alert.js"></script>
<script src="statics/pcui/js/jquery-1.8.3.js"></script>
<script src="statics/pcui/js/index.js"></script>
<script src="statics/pcui/js/page.js"></script>
<script src="statics/pcui/js/stulist.js"></script>
<script type="text/javascript" src="statics/pcui/js/tab.js"></script>
<script type="text/javascript" src="statics/from.js"></script>
<script type="text/javascript">
	$(function(){
		//获得部门的id
		var depart;
			$("#depart").bind("change",function(){
			depart=$(this).val();
			zhiweiliandong(depart);
			});
		//获得年龄
		$("#age").blur(function(){
			var age=$("#age").val();
			if(isNaN(age)){
				$("#age").next().text("请输入正确的数字");
			}else{
				$("#age").next().text("");
			}
		});
		//身份证的验证
		$("#idcard").blur(function(){
			var str=/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
			var idcard=$("#idcard").val();
			if(str.test(idcard)){
				$("#idcard").next().text("");
			}else{
			$("#idcard").next().text("请输入正确的身份证号");
			}
		});
		//学历
		var xueli;
		$("#xueli").bind("change",function(){
				xueli=$(this).val();
			});
		//邮箱
		$("#email").blur(function(){
			var email=$("#email").val();
			var str=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/ ;
			if(str.test(email)){
			$("#email").next().text("");
			}else{
			$("#email").next().text("请输入正确的邮箱");
			}
		});
		$("#phone").blur(function(){
			var phone=$("#phone").val();
			var sp=/^1\d{10}$/;
			if(sp.test(phone)){
			$("#phone").next().text("");
			}else{
			$("#phone").next().text("请输入正确的手机号");
			}
		});
	
		//点击保存时
		$("#yuansave").click(function(){
			var dengji=$("#dengji").val();
			//获得姓名
			var empname=$("#empname").val();
			//年龄
			var age=$("#age").val();
			//获得性别
			var sex=$('input:radio[name="sex"]:checked').val();
			//婚姻状况
			var hun=$('input:radio[name="hun"]:checked').val();
			//身份证号
			var idcard=$("#idcard").val();
			//政治面貌
			var zhengzhi=$("#zhengzhi").val();
			//学历
			//电话号码
			var phone=$("#phone").val();
			//民族
			var mingzu=$("#mingzu").val();
			//邮箱
			var email=$("#email").val();
			
			//省
			var shheng=$("#erjiliandong").attr("sheng");
			//市
			var city=$("#erjiliandongs").attr("city");
			//县
			var area=$("#sanjiliandong").attr("area");
			//省now
			var nowshheng=$("#erjiliandong1").attr("sheng");
			//市now
			var nowcity=$("#erjiliandongs1").attr("city");
			//县now
			var nowarea=$("#sanjiliandong1").attr("area");
			//原住址
			var yuanlocal=$("#yuanlocal").val();
			//现住址
			var nowlocal =$("#nowlocal").val();
			//部门
			//职位
			var zhiwei=$("#zhiweiliandong").attr("zhiwei");
			//用工方式
			var ygfs=$('input:radio[name="ygfs"]:checked').val();
			//入职日期
			var ruzhi=$("#ruzhi").val();
			//结束日期
			var shiyong=$("#shiyong").val();	
			//目前状态
			var zt=$('input:radio[name="zt"]:checked').val();
			//员工等级
			//登记人
			$(".dengjiren").attr("zx","${loginUser.user_id}");
			var dengjiren=$(".dengjiren").attr("zx");
			//个人简介
			var empcontent=$("#empcontent").val();
			//照片
			var photo=$("#shang").attr("chenggong");
			if(empcontent==null||empcontent==""||dengjiren==null||dengjiren==""
			||shiyong==null||shiyong==""||ruzhi==null||ruzhi==""||ygfs==null||ygfs==""
			||zhiwei==null||zhiwei==""||nowlocal==null||nowlocal==""||yuanlocal==""
			||yuanlocal==null||nowarea==null||nowarea==""||nowcity==null||nowcity==""||nowshheng==null
			||nowshheng==""||area==null||area==""||city==null||city==""||shheng==null||shheng==""
			||email==null||email==""||mingzu==null||mingzu==""||phone==null
			||phone==""||zhengzhi==null||zhengzhi==""||idcard==null||idcard==""||hun==null
			||hun==""||sex==null||sex==""||empname==null||empname==""||age==null||age==""){
			alert("有空值不能为空");
			}else{
			alert(111);
			 $.ajax({
				type: "POST",
				url: "Employee/insertSelective",
				data:{"emp_name":empname,"emp_idcard":idcard,"emp_phone":phone,"emp_age":age,"emp_sex":sex,"emp_marital_status":hun,"emp_political_status":zhengzhi,"emp_educational_background":xueli,"nation_name":mingzu,"emp_Email":email,"emp_province":shheng,"emp_city":city,"emp_county":area,"emp_address":nowlocal,"emp_department":depart,"emp_position":zhiwei,"emp_Employment_nature":ygfs,"emp_Entry_date":ruzhi,"emp_tryout_end_date":shiyong,"emp_now_status":zt,"emp_grade_id":dengji,"emp_registrant":dengjiren,"emp_photo_path":photo,"emp_remarks":empcontent,"emp_origin_detail":yuanlocal,"emp_now_province":nowshheng,"emp_now_city":nowcity,"emp_now_county":nowarea,"emp_now_detail":nowlocal},			
				success : function(result) {
				alert(result);
					if(result>0){
					showWebAlert("保存成功");
					}
				}
			});
			}
			
			
			 
		});
		$("#shang").click(function(){
			upload();
		});

});
//三级联动  /////////////////////////////////////////////////////////////////////

 function upload(){
	var object={
				type: "POST",
				url: "Employee/upload",
				success : function(data) {
					if(data==""||data==null){
					alert("上传失败");
					}else{
						alert("上传成功");
					}
					$("#shang").attr("chenggong",data);
				}
				};
				// 异步提交
	$("#visitForm").ajaxSubmit(object);
} 
yijiliandong();
		function yijiliandong(){
				$.ajax({
				type: "POST",
				url: "Employee/ListProvince",
				success : function(data) {
						var $table=$("#erjiliandong");
						$table.html(""); 
						var str=$("<option></option>");
						$table.append(str);
						for(var i=0;i<data.length;i++){
						var $tr=$("<option value='"+data[i].provinceID+"'>"+data[i].province+"</option>");
						$table.append($tr);  
						}  
						$("#erjiliandong").bind("change",function(){
							var sheng=$(this).val();
							$("#erjiliandong").attr("sheng",sheng);
						    var sheng=$("#erjiliandong").attr("sheng");
							erjiliandong(sheng);
						});
						
				}
				});
		}
		function erjiliandong(sheng){
			$.ajax({
				type: "POST",
				url: "Employee/ListCity",
				data:{"provinceID":sheng},
				success : function(data) {
						var $table=$("#erjiliandongs");
						$table.html("");
						var str=$("<option></option>");
						$table.append(str);
						for(var i=0;i<data.length;i++){
						var $tr=$("<option value='"+data[i].cityID+"'>"+data[i].city+"</option>");
						$table.append($tr);  
						}  
						$("#erjiliandongs").bind("change",function(){
								var city=$(this).val();
								$("#erjiliandongs").attr("city",city);
								var area=$("#erjiliandongs").attr("city");
								sanjiliandong(area);
							});
						
				}
				});
		}
		function sanjiliandong(area){
					$.ajax({
				type: "POST",
				url: "Employee/ListArea",
				data:{"cityID":area},
				success : function(data) {
						var $table=$("#sanjiliandong");
						$table.html(""); 
						var str=$("<option></option>");
						$table.append(str);
						for(var i=0;i<data.length;i++){
						var $tr=$("<option value='"+data[i].areaID+"'>"+data[i].area+"</option>");
						$table.append($tr);  
						}  
						$("#sanjiliandong").bind("change",function(){
							var area=$(this).val();
							$("#sanjiliandong").attr("area",area);
						});
				}
				});
		}
		yijiliandong1();
		function yijiliandong1(){
				$.ajax({
				type: "POST",
				url: "Employee/ListProvince",
				success : function(data) {
						var $table=$("#erjiliandong1");
						$table.html(""); 
						var str=$("<option></option>");
						$table.append(str);
						for(var i=0;i<data.length;i++){
						var $tr=$("<option value='"+data[i].provinceID+"'>"+data[i].province+"</option>");
						$table.append($tr);  
						}  
						$("#erjiliandong1").bind("change",function(){
							var sheng1=$(this).val();
							$("#erjiliandong1").attr("sheng",sheng1);
						    var sheng1=$("#erjiliandong1").attr("sheng");
							erjiliandong1(sheng1);
						});
						
				}
				});
		}
		function erjiliandong1(sheng1){
			$.ajax({
				type: "POST",
				url: "Employee/ListCity",
				data:{"provinceID":sheng1},
				success : function(data) {
						var $table=$("#erjiliandongs1");
						$table.html("");
						var str=$("<option></option>");
						$table.append(str);
						for(var i=0;i<data.length;i++){
						var $tr=$("<option value='"+data[i].cityID+"'>"+data[i].city+"</option>");
						$table.append($tr);  
						}  
						$("#erjiliandongs1").bind("change",function(){
								var city=$(this).val();
								$("#erjiliandongs1").attr("city",city);
								var area1=$("#erjiliandongs1").attr("city");
								sanjiliandong1(area1);
							});
						
				}
				});
		}
		function sanjiliandong1(area1){
					$.ajax({
				type: "POST",
				url: "Employee/ListArea",
				data:{"cityID":area1},
				success : function(data) {
						var $table=$("#sanjiliandong1");
						$table.html(""); 
						var str=$("<option></option>");
						$table.append(str);
						for(var i=0;i<data.length;i++){
						var $tr=$("<option value='"+data[i].areaID+"'>"+data[i].area+"</option>");
						$table.append($tr);  
						}  
						$("#sanjiliandong1").bind("change",function(){
							var area=$(this).val();
							$("#sanjiliandong1").attr("area",area);
						});
				}
				});
		}
		//职位的二级联动
		function zhiweiliandong(department_id){
	 	$.ajax({
				type: "POST",
				url: "getpositionInfo",
				data:{"department_id":department_id},
				success : function(data) {
						var $table=$("#zhiweiliandong");
						$table.html("");  
						var str=$("<option></option>");
						$table.append(str);  
						for(var i=0;i<data.length;i++){
						var $tr=$("<option value='"+data[i].position_id+"'>"+data[i].position_name+"</option>");
						$table.append($tr);  
						}  
						$("#zhiweiliandong").bind("change",function(){
						var zhiwei=$(this).val();
						$("#zhiweiliandong").attr("zhiwei",zhiwei);
						});
				}
				});
	 }
	//三级联动 /////////////////////////////////////////////////////////////////////
		
</script>
<style>
/*   *{border: black 1px solid}  */
.redBorder {
	border: red solid 1px;
}
</style>
</head>
<body>
	<div class="container">
		<h1 class="tabTitle">新增员工</h1>


		<table cellpadding="0" cellspacing="0" border="0" class="addTable">
			<tr>
				<td class="tdWidth"><span>*</span>姓名：</td>
				<td><input type="text" class="textStyle" style="width:120px;"
					placeholder="请输入姓名" id="empname" /></td>
				<td class="tdWidth">年龄：</td>
				<td><input type="text" class="textStyle" style="width:120px;"
					placeholder="请输入年龄" id="age" /><span></span></td>
				<td class="tdWidth"><span>*</span>性别：</td>
				<td><input type="radio" value="男" name="sex" class="radioStyle"
					checked="checked" /> 男&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio"
					value="女" name="sex" class="radioStyle" /> 女</td>

			</tr>

			<tr>

				<td class="tdWidth"><span>*</span>身份证号：</td>
				<td><input type="text" class="textStyle" style="width:120px;"
					id="idcard" /><span></span></td>
				<td class="tdWidth"><span>*</span>婚姻状况：</td>
				<td><input type="radio" value="未婚" name="hun"
					class="radioStyle" checked="checked" /> 未婚&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="已婚" name="hun" class="radioStyle" /> 已婚</td>
				<td class="tdWidth"><span>*</span>政治面貌：</td>
				<td><input type="text" class="textStyle" style="width:120px;"
					id="zhengzhi" /></td>

			</tr>
			<tr>
				<td class="tdWidth"><span>*</span>学历：</td>
				<td><select class="selectStyle" style="width:130px;" id="xueli">
						<option value=""></option>
						<option value="硕士">硕士</option>
						<option value="本科">本科</option>
						<option value="专科">专科</option>
						<option value="高中">高中</option>
						<option value="初中及以下">初中及以下</option>
				</select></td>
				<td class="tdWidth"><span>*</span>民族：</td>
				<td><input type="email" class="textStyle" style="width:120px;"
					id="mingzu" /></td>
				<td class="tdWidth"><span>*</span>邮箱：</td>
				<td><input type="email" class="textStyle" style="width:120px;"
					id="email" /><span></span></td>
			</tr>


			<tr>
				
				<td class="tdWidth">电话号码：</td>
				<td><input type="text" class="dateStyle" style="width:120px;"
					id="phone" /><span></span></td>
			</tr>

			<tr>
				<td class="tdWidth"><span>*</span>籍贯：</td>
				<td class="erji"><select class="selectStyle"
					style="width:130px;" id="erjiliandong" sheng>

				</select></td>
				<td class="erjis"><select class="selectStyle"
					style="width:130px;" id="erjiliandongs" city>

				</select></td>
				<td class="sanji"><select class="selectStyle"
					style="width:130px;" id="sanjiliandong" area>

				</select></td>
			</tr>
			<tr>
				<td class="tdWidth"><span>*</span>原住址详情：</td>
				<td colspan='2'><input type="text" class="textStyle" style="width:300px;"
					id="yuanlocal" /></td>
			</tr>
			<tr>
				<td class="tdWidth"><span>*</span>现住址：</td>
				<td class="erji"><select class="selectStyle"
					style="width:130px;" id="erjiliandong1" sheng>

				</select></td>
				<td class="erjis"><select class="selectStyle"
					style="width:130px;" id="erjiliandongs1" city>

				</select></td>
				<td class="sanji"><select class="selectStyle"
					style="width:130px;" id="sanjiliandong1" area>

				</select></td>
			</tr>
			<tr>
				<td class="tdWidth"><span>*</span>现住址详情：</td>
				<td colspan='2'><input type="text" class="textStyle" style="width:300px;"
					id="nowlocal" /></td>
			</tr>

			<tr>
				<td class="tdWidth"><span>*</span>所属部门：</td>
				<td><select class="selectStyle" style="width:130px;"
					id="depart">
						<option>请选择</option>
						<option value="1">校长办公室</option>
						<option value="2">人力资源行政部</option>
						<option value="3">市场渠道部</option>
						<option value="4">网络部</option>
						<option value="5">咨询部</option>
						<option value="7">教质部</option>
						<option value="8">学术部</option>
						<option value="10">业务部</option>
						<option value="12">财务部</option>
						<option value="13">后勤部</option>
				</select></td>
				<td class="tdWidth"><span>*</span>职位：</td>
				<td><select class="selectStyle" style="width:130px;"
					id="zhiweiliandong" zhiwei>

				</select></td>
				<td class="tdWidth"><span>*</span>用工方式：</td>
				<td><input type="radio" value="全职" name="ygfs"
					class="radioStyle" checked="checked" /> 全职&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="兼职" name="ygfs" class="radioStyle" /> 兼职</td>
			</tr>

			<tr>
				<td class="tdWidth"><span>*</span>入职日期：</td>
				<td><input type="date" class="dateStyle" style="width:120px;"
					id="ruzhi" /></td>
				<td class="tdWidth"><span>*</span>试用结束：</td>
				<td><input type="date" class="dateStyle" style="width:120px;"
					id="shiyong" /></td>
				<td class="tdWidth"><span>*</span>目前状态：</td>
				<td><input type="radio" value="在职" name="zt" class="radioStyle"
					checked="checked" /> 在职&nbsp;&nbsp;&nbsp;&nbsp;
			</tr>

			<tr>
				<td class="tdWidth"><span>*</span>员工等级：</td>
				<td><select class="selectStyle" style="width:130px;"
					id="dengji">
						<option value="1">一级</option>
						<option value="2">二级</option>
						<option value="3">三级</option>
						<option value="4">四级</option>
				</select></td>
				<td class="tdWidth"><span>*</span>登记人：</td>
				<td class="dengjiren" zx>${loginUser.emp_name}</td>
			</tr>


			<form action="#" id="visitForm" name="upform" method="post"
				enctype="multipart/form-data">
				<tr>
					<td class="tdWidth">照片：</td>
					<td colspan="5"><a href="#" class="fileStyle"
						title="请选择要上传的文件"> <input type="file" class="file" name="file"
							id="file" size=1
							onchange="document.getElementById('img').value=this.value" />
					</a> <input type="text" class="textStyle" id="img" style="width:200px;" />
						<input type="button" class="uploadButton" id="shang" value="上传"
						chenggong /></td>
				</tr>
			</form>


			<tr>
				<td class="tdWidth">个人简介：</td>
				<td colspan="5"><textarea class="areaStyle"
						style="width:360px;" id="empcontent"></textarea></td>
			</tr>
			<tr>
				<td class="tdWidth"></td>
				<td colspan="5"><input type="button" value="保存"
					class="saveButton alert-btn1" id="yuansave" /></td>
			</tr>
		</table>

		<div class="mbStyle">&nbsp;</div>
	</div>
	<!--保存成功-->
	<div class="saveAlert"></div>
	<!--保存成功结束-->

</body>
</html>
