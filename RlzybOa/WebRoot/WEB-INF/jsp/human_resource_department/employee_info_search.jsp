<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html lang="en">
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>查询员工信息</title>
<link rel="stylesheet" type="text/css"
	href="statics/pcui/css/global.css">
<link rel="stylesheet" type="text/css"
	href="statics/pcui/css/tablelist.css">
<link rel="stylesheet" type="text/css"
	href="statics/pcui/css/index1.css">
<link rel="stylesheet" type="text/css" href="statics/pcui/css/index.css">
<link rel="stylesheet" type="text/css" href="statics/pcui/css/page.css">
<link rel="stylesheet" type="text/css" href="statics/pcui/css/tab.css">
<link rel="stylesheet" type="text/css" href="statics/pcui/css/form.css" />
<link rel="stylesheet" type="text/css" href="statics/pcui/css/popup.css" />
<link rel="stylesheet" type="text/css" href="statics/pcui/css/add.css" />
<link rel="stylesheet" type="text/css" href="statics/pcui/css/zyupload-1.0.0.min.css" />
<!--弹出框-->

<script type="text/javascript" src="statics/pcui/js/alert.js"></script>
<script src="statics/pcui/js/jquery-1.8.3.js"></script>
<script src="statics/pcui/js/index.js"></script>
<script src="statics/pcui/js/page.js"></script>
<script src="statics/pcui/js/zyupload.basic-1.0.0.min.js"></script>
<script src="statics/pcui/js/stulist.js"></script>
<script type="text/javascript" src="statics/pcui/js/tab.js"></script>
<script src="statics/pcui/js/openpage.js"></script>
<script type="text/javascript" src="statics/from.js"></script>
<script type="text/javascript">

$(function(){
		$("#shang1").click(function(){
			upload1();
		});
		$("#shang2").click(function(){
			upload2();
		});
		$("#shang3").click(function(){
			upload3();
		});
		$("#shang4").click(function(){
			upload4();
		});
		$("#shang5").click(function(){
			upload5();
		});
		//修改个人信息
		var xxgaixueli;
		$("#xxgaixueli").bind("change",function(){
			xxgaixueli=$(this).val();
		});
		$("#xianqingsave").click(function(){
				var xxname=$("#xxname").val();
				var xxage=$("#xxage").val();
				var xxsex=$("#xxsex").val();
				var xxhobby=$("#xxhobby").val();
				var xxmingzu=$("#xxmingzu").val();
				var xxxianzhuzhi=$("#xxxianzhuzhi").val();
				var xxpingyin=$("#xxpingyin").val();
				var xxemail=$("#xxemail").val();
				var xxidcard=$("#xxidcard").val();
				var xxphone=$("#xxphone").val();
				var xxhun=$("#xxhun").val();
				var emp_id=$(".printButton1").attr("sxid");
				$.ajax({
						type: "POST",
						url: "Employee/updateperson",
						data:{"emp_id":emp_id,"emp_now_detail":xxxianzhuzhi,"emp_name":xxname,"emp_idcard":xxidcard,"emp_name_simple":xxpingyin,"emp_phone":xxphone,"emp_sex":xxsex,"emp_marital_status":xxhun,"nation_name":xxmingzu,"emp_Email":xxemail,"emp_hobby":xxhobby,"emp_educational_background":xxgaixueli,"emp_age":xxage},
						success : function(result) {
							if(result>0){
								showWebAlert("保存成功");
								closeMask("yyy");
								var as = $("#gaoJiSouSuo").attr("sousuonum");
								if(as=="在职"){
										newsLoad(null,"在职",1);
								}else if(as=="全职"){
										newsLoad("全职","在职",1);
								}else if(as=="兼职"){
										newsLoad("兼职","在职",1);
								}
							}
							$(".printButton1").attr("sxid","0");
						}
					});
		});
		
	 //上传信息保存
	 $("#shangchuanbc").click(function(){
		var shang1=	$("#shang1").attr("x1");
		var shang2=	$("#shang2").attr("x2");
		var shang3=	$("#shang3").attr("x3");
		var shang4=	$("#shang4").attr("x4");
		var shang5=	$("#shang5").attr("x5");
		var emp_id=$(".printButton1").attr("sxid");
		
	 	$.ajax({
	 		type : "post",
	 		url : "Employee/upziduan",
	 		data : {"emp_idcard_front":shang1,"emp_idcard_reverse":shang2,"emp_Degree_certificate":shang3,"emp_Education_certificate":shang4,"emp_technical_title_path":shang5,"emp_id":emp_id},
	 		success:function(data){
	 			if(data>0){
	 				showWebAlert("保存成功");
	 			}
	 		}
	 	});
	
	 });

	//增加工作经历
			$("#jinglisave").click(function(){
			var emp_id=$(".printButton1").attr("sxid");
				var gongzuo=$("#gongzuo").val();
				var jiaoyu=$("#jiaoyu").val();
				var peixun=$("#peixun").val();
				var shehui=$("#shehui").val();
				var beizhu=$("#beizhu").val();
					$.ajax({
						type: "POST",
						url: "Employee/updatejingli",
						data:{"emp_id":emp_id,"emp_Education_experience":jiaoyu,"emp_work_experience":gongzuo,"emp_train_experience":peixun,"emp_society_relation":shehui,"emp_remarks":beizhu},
						success : function(result) {
						alert(result);
							if(result>0){
								showWebAlert("保存成功");
								closeMask("cccc");
							}
							$(".printButton1").attr("sxid","0");
						}
					});
			});
	//增加紧急联系人
			$("#jinjiphone").blur(function(){
					var phone=$("#jinjiphone").val();
					var sp=/^1\d{10}$/;
					if(sp.test(phone)){
					$("#jinjiphone").next().text("");
					}else{
					$("#jinjiphone").next().text("请输入正确的手机号");
					}
			});
			$("#jinjisave").click(function(){
			closeMask("aaaa");
				var jinjiname=$("#jinjiname").val();
				var jinjiphone=$("#jinjiphone").val();
				var jinjirelation=$("#jinjirelation").val();
				//省
					var shheng=$("#erjiliandong1").attr("sheng");
					//市
					var city=$("#erjiliandongs1").attr("city");
					//县
					var area=$("#sanjiliandong1").attr("area");
					var nowlocal=$("#nowlocal").val();
					var emp_id=$(".printButton1").attr("sxid");
  					
					
							$.ajax({
						type: "POST",
						url: "Employee/updatejinji",
						data:{"emp_id":emp_id,"emp_contact_name":jinjiname,"emp_contact_phone":jinjiphone,"emp_contact_relationship":jinjirelation,"emp_contact_address":nowlocal,"emp_contact_address_province":shheng,"emp_contact_address_city":city,"emp_contact_address_county":area,"emp_contact_address_detail":nowlocal},
						success : function(result) {
							if(result>0){
								showWebAlert("修改成功");
							}
							$(".printButton1").attr("sxid","0");
						}
					});
					
				
			});
		//弹框////////////////////////////////////////////
		$("#a").click(function(){
			var emp_id=$(".printButton1").attr("sxid");
			if(emp_id != 0){
			mask(1050,400,true,"zzzz",false);
			}else{
				showWebAlert("请先选择员工");
			}
		});
		$("#b").click(function(){
			if($(".printButton1").attr("sxid")!=0){
				mask(1050,400,true,"aaaa",false);
			}else{
				showWebAlert("请先选择员工");
			}
		});
		$("#c").click(function(){
			if($(".printButton1").attr("sxid")!=0){
				mask(1050,800,true,"cccc",false);
			}else{
				showWebAlert("请先选择员工");
			}
		});
		$("#shangchuanbc").click(function(){
		closeMask("zzzz");
		$("#visitForm1").get(0).reset();
		$("#visitForm2").get(0).reset();
		$("#visitForm3").get(0).reset();
		$("#visitForm4").get(0).reset();
		$("#visitForm5").get(0).reset();
		
		showWebAlert("新增成功!");
	});

		
	 		//手机号验证的正则
	 $("#gaojiphone").blur(function(){
		var str=/^[1][3,4,5,7,8][0-9]{9}$/;
		if (!str.test($("#gaojiphone").val())) {           
	     	$("#gaojiphone").next().text("请输入正确的手机号");
        } else{
        $("#gaojiphone").next().text("");
        }
	});
	//添加调薪的验证
	$("#tiaoxinqian").blur(function(){
		var tiaoxinqian=$("#tiaoxinqian").val();
		if(isNaN(tiaoxinqian)){
			$("#tiaoxinqian").next().text("请输入正确的数字");
		}else{
		$("#tiaoxinqian").next().text("");
		}
	});
	$("#tiaoxinhou").blur(function(){
		var tiaoxinhou=$("#tiaoxinhou").val();
		if(isNaN(tiaoxinhou)){
			$("#tiaoxinhou").next().text("请输入正确的数字");
		}else{
		$("#tiaoxinhou").next().text("");
		}
	});
	//////////////////////////////////////////////////////////////////////////////////
	/*删除*/
	 $("#deleteemp").click(function(){
		if($(".printButton1").attr("sxid")==0){
			 showWebAlert('请先选择员工');   
		}else{
			deleteShowAlert("删除提示","确定要删除吗？","确定","取消");
		}
		$(".d_bt_ok").click(function(){
		  var emp_id=$(".printButton1").attr("sxid");
			  $.ajax({
				type: "POST",
				url: "Employee/DeleteEmployees",
				data:{"emp_id":emp_id},
				success : function(result) {
					if(result>0){
						var as = $("#gaoJiSouSuo").attr("sousuonum");
								if(as=="在职"){
										newsLoad(null,"在职",1);
								}else if(as=="全职"){
										newsLoad("全职","在职",1);
								}else if(as=="兼职"){
										newsLoad("兼职","在职",1);
								}
							}
							$(".printButton1").attr("sxid","0");
							 zaizhinum();
						    quanzhinum();
						    jianzhinum();
						     shiyongqinum();
						     ligangnum();
						      dailizhinum(); 
						     lizhinum();
						     tingxinnum();
						}
					})	 
			 });
		}); 
 	 function inserttiaogang(emp_id,yuanbumenid,yuangangweiid,xiandepartId,xianpositionId,tiaogangseason,tiaogangdata,tiaogangcontent){
	 	
	 	$.ajax({
				type: "POST",
				url: "transfer_position_add",
				data:{"emp_id":emp_id, "depart_id":yuanbumenid, "position":yuangangweiid, "departId":xiandepartId,"positionId":xianpositionId,"transfer_position_reason":tiaogangseason,"transfer_position_time":tiaogangdata,"transfer_position_details":tiaogangcontent},
				success : function(result) {
					if(result>0){
					showWebAlert("保存成功");
					closeMask("tiaogang");
					}
					$(".printButton1").attr("sxid","0");
					}
				});
	 } 
	 function inserttiaoxin(tiaoxinqian,tiaoxinhou,tiaoxinseason,tiaoxincontent,emp_id){
	 	$.ajax({
				type: "POST",
				url: "managesalary_add",
				data:{"emp_id":emp_id, "salary_adjustment_beforeMoney":tiaoxinqian, "salary_adjustment_afterMoney":tiaoxinhou, "salary_adjustment_reason":tiaoxinseason,"salary_adjustment_explain":tiaoxincontent},
				success : function(result) {
					if(result>0){
					showWebAlert("保存成功");
					closeMask("tiaoxin");
					}
					$(".printButton1").attr("sxid","0");
					}
				});
	 }
	 
	 
	 function insertjiancheng(jiandata,jianseason,jiancontent,jianchu,emp_id){
	 if(jiandata!=""||jiandata!=null||jianseason!=null||jianseason!=null||jiancontent!=null||jiancontent!=""||jianchu!=""||jianchu!=null||emp_id!=null||emp_id!=""){
	 
	
	 	$.ajax({
				type: "POST",
				url: "Randp_add",
				data:{"emp_id":emp_id, "rewards_type":jianchu, "rewards_date":jiandata, "rewards_reason":jianseason,"rewards_content":jiancontent},
				success : function(result) {
					if(result>0){
					showWebAlert("保存成功");
					closeMask("jiancheng");
						}
					$(".printButton1").attr("sxid","0");
					}
				});
	 	}else{
			 alert("有空值不能保存");
	 	}
	 }
	 
	 
	 function insertlizhi(emp_id,lizhidata,lizhiseason,dengjiren,lizhitype){
	 		$.ajax({
				type: "POST",
				url: "dimission_add",
				data:{"emp_id":emp_id, "dimission_date":lizhidata, "dimission_reason":lizhiseason, "dimission_approver":dengjiren,"dimission_status":lizhitype},
				success : function(result) {
					if(result>0){
					showWebAlert("保存成功");
					closeMask("lizhi");
					}
					$(".printButton1").attr("sxid","0");
				}
				});
	 }
	 function insertligang(emp_id,qishiriqi,jiezhiriqi,x,ligangseason,ligangpizhunren){
	 	$.ajax({
				type: "POST",
				url: "Leave/insertligang",
				data:{"emp_id":emp_id, "leave_startDate":qishiriqi, "leave_endDate":jiezhiriqi, "leave_type":x, "leave_reason":ligangseason, "leave_approver":ligangpizhunren},
				success : function(result) {
					if(result>0){
					showWebAlert("保存成功");
					closeMask("ligang");
					}
					$(".printButton1").attr("sxid","0");
				}
				});
	 } 
	  function insertfangtan(user_id,emp_id,fangtandata,fangtanseason,fangtancontent,jiluren){
	
	 		$.ajax({
				type: "POST",
				url: "interview_add1",
				data:{"interview_person":user_id,"emp_id":emp_id,"interview_date":fangtandata,"interview_reason":fangtanseason,"interview_content":fangtancontent,"interview_recorder":jiluren},
				success : function(result) {
					if(result==1){
					showWebAlert("保存成功");
					closeMask("fangtan");
					}
					$(".printButton1").attr("sxid","0");
				}
				});
	 }
	 $("#tiaoxinqian").blur(function(){
	  var tiaoxinqian=$("#tiaoxinqian").val();
	  if(isNaN(tiaoxinqian)){
	   $("#tiaoxinqian").next().text("必须为数字");
	  }else{
		$("#tiaoxinqian").next().text("");
	  }
	 });
	
	 $("#tiaoxinhou").blur(function(){
	 var tiaoxinhou=$("#tiaoxinhou").val();
	  if(isNaN(tiaoxinhou)){
	  $("#tiaoxinhou").next().text("必须为数字");
	  
	  }else{
	  $("#tiaoxinhou").next().text("");
	  }
	 });
	 
	 
						
	 
	 
	 /**
	  * 业务功能
	  */
	 $("#zhiwu").bind("change",function(){
	 	
	 	var s=$(this).val();
	 	if($(".printButton1").attr("sxid")==0){
	 		showWebAlert("请选择员工");
	 	}else if(s==1){
	 		var emp_id=$(".printButton1").attr("sxid");
	 		$.ajax({
				type: "POST",
				url: "Employee/getInfo",
				data:{"emp_id":emp_id},
				success : function(result) {
					$(".beifangtanrenbumen").text(result.depart_name);
					$(".beifangtanrenxingming").text(result.emp_name);
					$(".beifangtanrengangwei").text(result.position_name);
					$(".fangtanrenxingming").text("${loginUser.emp_name}");
					$(".fangtanrengangwei").text("${loginUser.position.position_name}");
					$(".fangtanrenbumen").text("人力资源部");
					mask(910,450,false,"fangtan",true);
					
					$("#fangtansave").click(function(){
					var fangtanseason=$("#fangtanseason").val();
					var fangtandata=$("#fangtandata").val();
					var fangtancontent=$("#fangtancontent").val();
					var jiluren=$("#jiluren").text();
					var user_id=${loginUser.user_id};
					if(fangtandata==null||fangtandata==""||fangtanseason==null||fangtanseason==""||fangtancontent==null||fangtancontent==""||jiluren==null||jiluren==""){
					 alert("有空值不能保存");
					}else{
					insertfangtan(user_id,emp_id,fangtandata,fangtanseason,fangtancontent,jiluren)
					}
					
					});
					}
				});
	 	}else if(s==2){
	 		var emp_id=$(".printButton1").attr("sxid");
	 	$.ajax({
				type: "POST",
				url: "Employee/getInfo",
				data:{"emp_id":emp_id},
				success : function(result) {
					$(".ligangbumen").text(result.depart_name);
					$(".ligangxingming").text(result.emp_name);
					$(".liganggangwei").text(result.position_name);
					mask(910,450,false,"ligang",true);
					var x;
						$("#ligangxuanzhe").bind("change",function(){
						 	x =$(this).val();
						 }); 
						$("#jiezhiriqi").change(function(){
						var qishiriqi=$("#qishiriqi").val();
						 var jiezhiriqi=$("#jiezhiriqi").val();
								$.ajax({
									type: "POST",
									url: "Leave/riqicha",
									data:{"qishiriqi":qishiriqi,"jiezhiriqi":jiezhiriqi},
									success : function(result) {
										$(".ligangheji").text(result);
									}
									});
						});
					$("#ligangsave").click(function(){
						 var qishiriqi=$("#qishiriqi").val();
						 var jiezhiriqi=$("#jiezhiriqi").val();
						 var ligangseason=$(".ligangseason").val();
						 var ligangpizhunren=$(".ligangpizhunren").val();
						 if(qishiriqi==null||qishiriqi==""||jiezhiriqi==null|jiezhiriqi==""||ligangseason==null||ligangseason==""||ligangpizhunren==null||ligangpizhunren==""){
						 alert("有空值不能保存");
						 }else{
						 insertligang(emp_id,qishiriqi,jiezhiriqi,x,ligangseason,ligangpizhunren);
						 }
						 
					});
				}
	 	});
	 			
	 	}
	 	else if(s==3){
	 		var emp_id=$(".printButton1").attr("sxid");
	 	$.ajax({
				type: "POST",
				url: "Employee/getInfo",
				data:{"emp_id":emp_id},
				success : function(result) {
					$(".lizhibumen").text(result.depart_name);
					$(".lizhixingming").text(result.emp_name);
					$(".lizhigangwei").text(result.position_name);
					$(".dengjiren").text("${loginUser.emp_name}");
					mask(910,450,false,"lizhi",true);
					$("#lizhisave").click(function(){
						var lizhitype=$('input:radio[name="lizhi"]:checked').val();
						var lizhidata=$("#lizhidata").val();
						var lizhiseason=$(".lizhiseason").val();
						var dengjiren = $(".dengjiren").text();
						if(lizhidata==null||lizhidata==""||lizhiseason==""||lizhiseason==null||dengjiren==null||dengjiren==""||lizhitype==null||lizhitype==""){
						alert("有空值不能保存");
						}else{
						insertlizhi(emp_id,lizhidata,lizhiseason,dengjiren,lizhitype);
						}
					});
					}
					});
	 	}
	 	else if(s==4){
	 			var emp_id=$(".printButton1").attr("sxid");
	 	$.ajax({
				type: "POST",
				url: "Employee/getInfo",
				data:{"emp_id":emp_id},
				success : function(result) {
					$(".jianbumen").text(result.depart_name);
					$(".jianxingming").text(result.emp_name);
					$(".jiangangwei").text(result.position_name);
					
					mask(910,450,false,"jiangcheng",true);
					$("#jiansave").click(function(){
						var jiandata=$("#jiandata").val();
						var jianseason=$("#jianseason").val();
						var jiancontent = $(".jiancontent").val();
						var jianchu=$('input:radio[name="hobby"]:checked').val();
						if(jiandata==""||jiandata==null||jianseason==null||jianseason==""||jiancontent==null||jiancontent==""||jianchu==null||jianchu==""){
						alert("有空值不能保存");
						}else{
						insertjiancheng(jiandata,jianseason,jiancontent,jianchu,emp_id);
						}
					});
					}
					});
	 		
	 	
	 	}
	 	else if(s==5){
	 	var emp_id=$(".printButton1").attr("sxid");
	 	$.ajax({
				type: "POST",
				url: "Employee/getInfo",
				data:{"emp_id":emp_id},
				success : function(result) {
					$(".tiaoxinbumen").text(result.depart_name);
					$(".tiaoxinxingming").text(result.emp_name);
					$(".tiaoxingangwei").text(result.position_name);
					
					mask(910,450,false,"tiaoxin",true);
					$("#tiaoxinsave").click(function(){
						var tiaoxinqian=$("#tiaoxinqian").val();
						var tiaoxinhou=$("#tiaoxinhou").val();
						var tiaoxinseason = $("#tiaoxinseason").val();
						var tiaoxincontent= $(".tiaoxincontent").val();
						if(tiaoxinqian==null||tiaoxinqian==""||tiaoxinhou==null||tiaoxinhou==""||tiaoxinseason==null||tiaoxinseason==""||tiaoxincontent==null||tiaoxincontent==""){
							alert("有空值不能保存");
						}else if(isNaN(tiaoxinqian)||isNaN(tiaoxinhou)){
							alert("薪资为数字");
						}else{
							inserttiaoxin(tiaoxinqian,tiaoxinhou,tiaoxinseason,tiaoxincontent,emp_id);
						}
						
					});
					}
					});
	 		
	 	
	 	
	 	
	 	}
	 	else if(s==6){
	 	var emp_id=$(".printButton1").attr("sxid");
	 	$.ajax({
				type: "POST",
				url: "Employee/getInfo",
				data:{"emp_id":emp_id},
				success : function(result) {
					$(".tiaogangbumen").text(result.depart_name);
					$(".tiaogangxingming").text(result.emp_name);
					$(".tiaoganggangwei").text(result.position_name);
				    var yuanbumenid=result.emp_department;
					var yuangangweiid=result.emp_position;
					mask(910,450,false,"tiaogang",true);
					var xiandepartId;
					var xianpositionId;
						$("#yijiliandong").bind("change",function(){
						 	xiandepartId =$(this).val();
						 	liandong(xiandepartId)
						 }); 
						 $("#erjiliandong").bind("change",function(){
						 	xianpositionId =$(this).val();
						 });
						
					$("#tiaogangsave").click(function(){
						var tiaogangseason=$("#tiaogangseason").val();
						var tiaogangdata=$("#tiaogangdata").val();
						var tiaogangcontent= $(".tiaogangcontent").val();
						 if(yuanbumenid==null||yuanbumenid==""||yuangangweiid==null||yuangangweiid==""||xiandepartId==0||tiaogangseason==null||tiaogangseason==""||tiaogangdata==null||tiaogangdata==""||tiaogangcontent==null||tiaogangcontent==""){
						alert("有空值不能保存");
						}else{
						inserttiaogang(emp_id,yuanbumenid,yuangangweiid,xiandepartId,xianpositionId,tiaogangseason,tiaogangdata,tiaogangcontent); 
						} 
					 	
					});
					}
					});
	 	
	 	}
	 });
	
	 function liandong(department_id){
	 	$.ajax({
				type: "POST",
				url: "getpositionInfo",
				data:{"department_id":department_id},
				success : function(data) {
						var $table=$("#erjiliandong");
						$table.html("");  
						var str=$("<option></option>");
						$table.append(str);  
						for(var i=0;i<data.length;i++){
						var $tr=$("<option value='"+data[i].position_id+"'>"+data[i].position_name+"</option>");
						$table.append($tr);  
						}  
				}
				});
	 }
	 $(".excel_in_Button").click(function(){
	 	mask(600,222,false,"gangwei",false);
	 });
	 
		<!--增加岗位 -->
	 $("#gangweiName").blur(function(){
	  	 var gangweiName=$("#gangweiName").val();
		 if(gangweiName==null||gangweiName==""){
		 	$("#gangweiName").next().text("请输入岗位");
		 }else{
			 $("#gangweiName").next().text("");
		 }
	 });
	 
	 $("#savegangwei").click(function(){
	 		insertgangwei();
	 		closeMask("gangwei");
	 		showWebAlert('增加成功'); 
	 });
	
	function insertgangwei(){
		var departmentdeid = $("#departmentdeid").val();
		var quanxiandeid=$("#quanxiandeid").val();
		var gangweiName=$("#gangweiName").val();
		if(departmentdeid=="0"){
			showWebAlert('请选择部门'); 
		}
		if(quanxiandeid=="0"){
			showWebAlert('请选择权限等级'); 
		}
		if(gangweiName==""){
			showWebAlert('请输入岗位'); 
		}
		if(departmentdeid!=0&&quanxiandeid!=0&&gangweiName!=""){
			$.ajax({
				type: "POST",
				url: "Employee/insertgangwei",
				data:{"position_name":gangweiName,"depart_id":departmentdeid,"jurisdiction_id":quanxiandeid},
				success : function(dat) {
				if(dat>0){
					showWebAlert("保存成功"); 
				}
				}
		});
		}
	
	}
	 
		/*表格双击事件开始*/
		$(".selectTable").on("dblclick","tbody tr",function () {
			var id = $(this).attr("emp_id");
			var emp_id=parseInt(id);
            //测试弹出值 
			$.ajax({
				type: "POST",
				url: "Employee/selectByPrimaryKey",
				data:{"emp_id":emp_id},
				success : function(result) {
				$("#xxname").val(result.emp_name);
				$("#xxage").val(result.emp_age);
				$("#xxsex").val(result.emp_sex);
				$("#xxhobby").val(result.emp_hobby);
				$("#xxmingzu").val(result.nation_name);
				$("#xxxueli").val(result.emp_educational_background);
				$("#xxxianzhuzhi").val(result.emp_now_detail);
				$("#xxpingyin").val(result.emp_name_simple);
				$("#xxemail").val(result.emp_Email);
				$("#xxidcard").val(result.emp_idcard);
				$("#xxphone").val(result.emp_phone);
				$("#xxhun").val(result.emp_marital_status);
				mask(1000,800,false,"yyy");
			}
			});
		});
		/*表格双击事件结束*/
		
		//表格单击事件开始
		$(".selectTable").on("click","tbody tr",function() {
			var id = $(this).attr("emp_id");
			var emp_id=parseInt(id);
			var s =$(".printButton1").attr("sxid",emp_id);
		});
		//表格单击事件结束
		
	
	
	//全职的信息
	$(".zz #quanzhinum").click(function(){
		var index = 1;
		newsLoad("全职","在职",index)
		$(".zaizhixinxi").css("background-color","#ffffff").css("height","79.5px");
		$("#quanzhinum").css("background-color","#e5ecfa").css("height","79.5px");
		$("#jianzhinum").css("background-color","#ffffff").css("height","79.5px");
		$("#souSuoNameAndDepart").attr("sousuonum","全职");
		$("#gaoJiSouSuo").attr("sousuonum","全职");
		});		
	//兼职的信息
	$(".zz #jianzhinum").click(function(){
		var index = 1;
		newsLoad("兼职","在职",index);
		$(".zaizhixinxi").css("background-color","#ffffff").css("height","79.5px");
		$("#quanzhinum").css("background-color","#ffffff").css("height","79.5px");
		$("#jianzhinum").css("background-color","#e5ecfa").css("height","79.5px");
		$("#souSuoNameAndDepart").attr("sousuonum","兼职");
		$("#gaoJiSouSuo").attr("sousuonum","兼职");
	});
	//在职的信息
	$(".zz .zaizhixinxi").click(function(){
		var index = 1;
		newsLoad(null,"在职",index)
		$(".zaizhixinxi").css("background-color","#e5ecfa").css("height","79.5px");
		$("#quanzhinum").css("background-color","#ffffff").css("height","79.5px");
		$("#jianzhinum").css("background-color","#ffffff").css("height","79.5px");
		$("#souSuoNameAndDepart").attr("sousuonum","在职");
		$("#gaoJiSouSuo").attr("sousuonum","在职");
	});
	
	 /*高级搜索开始*/
	$("#gaoJiSouSuo").click(function(){
		mask(650,200,false,"search",false);
	});
	$(".gaojisave").click(function(){
		closeMask("search");
		var s = $("#souSuoNameAndDepart").attr("sousuonum");
		var emp_Employment_nature ;
		var emp_now_status ;
		if(s=="在职"){
			emp_Employment_nature = null;
			emp_now_status = "在职";
		}else if(s=="全职"){
			emp_Employment_nature = "全职";
			emp_now_status = "在职";
		}else if(s=="兼职"){
			emp_Employment_nature = "兼职";
			emp_now_status = "在职";
		}
		newsLoad(emp_Employment_nature,emp_now_status,1)

		$(".printButton1").attr("sxid","0");

	});
	/*高级搜索结束*/
	//点击搜索事件  全职
		$("#souSuoNameAndDepart").click(function(){
			var s = $("#souSuoNameAndDepart").attr("sousuonum");
			var emp_Employment_nature ;
			var emp_now_status ;
			if(s=="在职"){
				emp_Employment_nature = null;
				emp_now_status = "在职";
			}else if(s=="全职"){
				emp_Employment_nature = "全职";
				emp_now_status = "在职";
			}else if(s=="兼职"){
				emp_Employment_nature = "兼职";
				emp_now_status = "在职";
			}
			newsLoad(emp_Employment_nature,emp_now_status,1)

			$(".printButton1").attr("sxid","0");

		}); 
	/////////////////////////////////////////////////////////////////////////////////////

	
});	



function quanzhinum(){
	$.ajax({
			type: "post",
			url: "Employee/selectCountquanzhi",
			success : function(data) {
				$("#quanzhinum span").text(data);
				$("#quanzhinum").attr("quanzhi",data);
			}
	});
}
function jianzhinum(){
	$.ajax({
			type: "post",
			url: "Employee/selectCountjianzhi",
			success : function(data) {
				$("#jianzhinum span").text(data);
				$("#jianzhinum").attr("jianzhinum",data);
			}
	});
}
function shiyongqinum(){
	$.ajax({
			type: "post",
			url: "Employee/selectCountshiyongqi",
			success : function(data) {
				$("#shiyongqinum span").text(data.length);
			}
	});
}
function ligangnum(){
	$.ajax({
			type: "post",
			url: "Employee/selectCountligang",
			success : function(data) {
				$("#ligangnum span").text(data);
			}
	});
}
 
function dailizhinum(){
	$.ajax({
			type: "post",
			url: "Employee/selectCountdailizhi",
			success : function(data) {
				$("#dailizhinum span").text(data);
			}
	});
} 
function tingxinnum(){
	$.ajax({
			type: "post",
			url: "Employee/selectCounttingxin",
			success : function(data) {
				$("#tingxinnum span").text(data);
			}
	});
}
function lizhinum(){
	$.ajax({
			type: "post",
			url: "Employee/selectCountlizhi",
			success : function(data) {
				$("#lizhinum span").text(data);
			}
	});
}

function zaizhinum(){
	$.ajax({
			type: "post",
			url: "Employee/selectCountzaizhi",
			success : function(data) {
				$("#zaizhinum").text(data);
				$(".zaizhixinxi").attr("zaizhi",data);
				
			}
	});
}

	   

/*绑定表格数据*/		
	$(function(){
	var index = 1;
	newsLoad(null,"在职",index);
	$(".zaizhixinxi").css("background-color","#e5ecfa").css("height","79.5px");
	$("#quanzhinum").css("background-color","#ffffff").css("height","79.5px");
	$("#jianzhinum").css("background-color","#ffffff").css("height","79.5px"); 
	$("[name=total]").change(function(){
			var s = $("#souSuoNameAndDepart").attr("sousuonum");
			var emp_Employment_nature ;
			var emp_now_status ;
			if(s=="在职"){
				emp_Employment_nature = null;
				emp_now_status = "在职";
			}else if(s=="全职"){
				emp_Employment_nature = "全职";
				emp_now_status = "在职";
			}else if(s=="兼职"){
				emp_Employment_nature = "兼职";
				emp_now_status = "在职";
			}
			newsLoad(emp_Employment_nature,emp_now_status,1)
		})
	$(".imgSearch").click(function(){
			var index = $("[name=pageNo]").val();
			var s = $("#souSuoNameAndDepart").attr("sousuonum");
			var emp_Employment_nature ;
			var emp_now_status ;
			if(isNaN(index)){
				alert("请输入正确的数字");
			}else{
			if(s=="在职"){
				emp_Employment_nature = null;
				emp_now_status = "在职";
			}else if(s=="全职"){
				emp_Employment_nature = "全职";
				emp_now_status = "在职";
			}else if(s=="兼职"){
				emp_Employment_nature = "兼职";
				emp_now_status = "在职";
			}
				newsLoad(emp_Employment_nature,emp_now_status,index)
			}
				$("[name=pageNo]").val("");
		})
	 zaizhinum();
	    quanzhinum();
	    jianzhinum();
	     shiyongqinum();
	     ligangnum();
	      dailizhinum(); 
	     lizhinum();
	     tingxinnum();
	});
	
	
function newsLoad(emp_Employment_nature,emp_now_status,index){
		var pageSize = $("[name=total]").val();
		var emp_name = $("#sousuoname").val();
		var emp_department = $("#sousuobumen").val();
		var	emp_educational_background = $("#gaojixueli").val();
		var	emp_birthday = $("#gaojidata").val();
		var	emp_phone =$("#gaojiphone").val();
		var $table = $("#tableData1 tbody");
		$table.html("");  
		 // loading
					   var $ttr = $("<tr></tr>");
					   var $tdd = $("<td colspan='10'></td>");
					   var $img = $("<img src='/RlzybOa/statics/pcui/images/loading2.gif' />");
					   $tdd.append($img);
					   $ttr.append($tdd);
					   $table.append($ttr);
					   // end loading
		$.ajax({
			type: "post",
			url: "Employee/selectAllqzj",
			data:{
					"emp_Employment_nature":emp_Employment_nature,
					"emp_now_status":emp_now_status,
					"index":index,
					"pageSize":pageSize,
					"emp_name":emp_name,
					"emp_department":emp_department,
					"emp_educational_background":emp_educational_background,
					"emp_birthday":emp_birthday,
					"emp_phone":emp_phone
					},
			success : function(dat) {
				var data = dat.oaRlzybEmployeeList;
				var $table = $("#tableData1 tbody");
				var str = "";
				$table.html("");
				if(dat.totalCount==0){
					$(".selectTable .trs").show()
					$(".pageStyle").hide();
				}else{
					$(".selectTable .trs").hide()
					$(".pageStyle").show();
				}
				for(var i=0;i<data.length;i++){
				if(data[i].emp_department_name==null){
				data[i].emp_department_name="无"
				}
				if(data[i].emp_position_name==null){
				data[i].emp_position_name="无"
				}
				str+= "<tr emp_id="+data[i].emp_id+">"
					var id = i + 1;
						if (id < 10) {
							id = "000" + id;
						} else if (id < 100) {
							id = "00" + id;
						} else if (id < 1000) {
							id = "0" + id;
						} else {
							id = "" + id;
						}
				str+= "<td>"+id+"</td>";
				str+= "<td>"+data[i].emp_name+"</td>";
				str+= "<td>"+data[i].emp_sex+"</td>";
				str+= "<td>"+data[i].emp_age+"</td>";
				str+= "<td>"+data[i].emp_Email+"</td>";
				str+= "<td>"+data[i].emp_department_name+"</td>";
				str+= "<td>"+data[i].emp_position_name+"</td>";
				str+= "<td>"+data[i].emp_phone+"</td>";
				str+= "<td>"+(new Date(data[i].emp_Entry_date).getFullYear()+"-")+
					(new Date(data[i].emp_Entry_date).getMonth()+1+"-")+
					(new Date(data[i].emp_Entry_date).getDate())+
				"</td>";
				str+= "<td>"+(new Date(data[i].emp_tryout_end_date).getFullYear()+"-")+
					(new Date(data[i].emp_tryout_end_date).getMonth()+1+"-")+
					(new Date(data[i].emp_tryout_end_date).getDate())+
				"</td>";
				}
				$table.html(str);
				showPage(index,Math.ceil(dat.totalCount/pageSize),dat.totalCount); 	
			   }, 
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
							var sheng=$(this).val();
							$("#erjiliandong1").attr("sheng",sheng);
						    var sheng=$("#erjiliandong1").attr("sheng");
							erjiliandong1(sheng);
						});
						
				}
				});
		}
		function erjiliandong1(sheng){
			$.ajax({
				type: "POST",
				url: "Employee/ListCity",
				data:{"provinceID":sheng},
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
								var area=$("#erjiliandongs1").attr("city");
								sanjiliandong1(area);
							});
						
				}
				});
		}
		function sanjiliandong1(area){
					$.ajax({
				type: "POST",
				url: "Employee/ListArea",
				data:{"cityID":area},
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

function upload1(){

	var object={
				type: "POST",
				url: "Employee/upload",
				success : function(data) {
					if(data==""||data==null){
					alert("上传失败");
					}else{
						alert("上传成功");
					}
					$("#shang1").attr("x1",data);
				}
				};
				// 异步提交
	$("#visitForm1").ajaxSubmit(object);
} 
function upload2(){
	var object={
				type: "POST",
				url: "Employee/upload",
				success : function(data) {
					if(data==""||data==null){
					alert("上传失败");
					}else{
						alert("上传成功");
					}
					$("#shang2").attr("x2",data);
				}
				};
				// 异步提交
	$("#visitForm2").ajaxSubmit(object);
} 
function upload3(){
	var object={
				type: "POST",
				url: "Employee/upload",
				success : function(data) {
					if(data==""||data==null){
					alert("上传失败");
					}else{
						alert("上传成功");
					}
					$("#shang3").attr("x3",data);
				}
				};
				// 异步提交
	$("#visitForm3").ajaxSubmit(object);
} 
function upload4(){
	var object={
				type: "POST",
				url: "Employee/upload",
				success : function(data) {
					if(data==""||data==null){
					alert("上传失败");
					}else{
						alert("上传成功");
					}
					$("#shang4").attr("x4",data);
				}
				};
				// 异步提交
	$("#visitForm4").ajaxSubmit(object);
} 
function upload5(){
	var object={
				type: "POST",
				url: "Employee/upload",
				success : function(data) {
					if(data==""||data==null){
					alert("上传失败");
					}else{
						alert("上传成功");
					}
					$("#shang5").attr("x5",data);
				}
				};
				// 异步提交
	$("#visitForm5").ajaxSubmit(object);
} 
	
</script>
<script type="text/javascript">

	function show(index){
		var s = $("#souSuoNameAndDepart").attr("sousuonum");
		var emp_Employment_nature ;
		var emp_now_status ;
		if(s=="在职"){
			emp_Employment_nature = null;
			emp_now_status = "在职";
		}else if(s=="全职"){
			emp_Employment_nature = "全职";
			emp_now_status = "在职";
		}else if(s=="兼职"){
			emp_Employment_nature = "兼职";
			emp_now_status = null;
		}
		newsLoad(emp_Employment_nature,emp_now_status,index)
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
.zz li {
	float: left;
	list-style: none;
	padding: 0 10px;
	text-align: center;
	line-height: 80px;
	font-family: "微软雅黑";
}

.selectTable tbody:LAST-CHILD{
	
}
.zz ul {
	float: left;
	border-radius: 5px;
}

.zz ul li:first-child {
	border-radius: 5px 0px 0px 5px;
}

.zz ul li:last-child {
	border-radius: 0px 5px 5px 0px;
}

.padr {
	margin-left: 3%;
}

#bigw {
	width: 150px;
	color: #129CE6;
	font-size: 25px;
}

.fontsize {
	font-size: 30px;
	padding: 0px 8px;
	color: #129CE6;
}

.s {
	float: left;
	width: 1px;
	height: 50px;
	background-color: #c8c8c8;
	margin-top: 15px;
}

.s1 {
	padding: 0px 8px;
	color: #129CE6;
	font-weight: 500;
	font-size: 22px;
}

.bgcolor:hover {
	background-color: #e5ecfa;
	height: 79.5px;
	cursor: pointer;
}
</style>
</head>
<body>
	<div>
		<div class="container">
			<div class="tableInfo" style="height:200px;">
				<div style="margin:2% 60%; width:35rem; height:3rem;">
					<select class="printButton1" id="zhiwu" sxid="0">
						<option value="0">业务功能</option>
						<option value="1">访谈</option>
						<option value="2">离岗</option>
						<option value="3">离职</option>
						<option value="4">奖惩</option>
						<option value="5">调薪</option>
						<option value="6">调岗</option>
					</select> <input type="button" value="添加员工"
						onclick="NewPage('skiptopage/topage/employee_info_add')"
						class="insertButton" /> <input type="button" value="添加岗位"
						class="excel_in_Button" id="tang" />
				</div>
				<div class="zz" style="margin:2rem 10rem;width:100%;height:6rem;text-align: center;">
					<ul
						style="width:auto;height:80px;box-shadow: 0px 0px 4px #00c8f9;">
						<li id="bigw" style="width:auto" class="bgcolor zaizhixinxi" zaizhi>在职<span
							class="fontsize" id="zaizhinum"></span>人
						</li>
						<div class="s"></div>
						<li class="bgcolor" style="width:auto" id="quanzhinum" quanzhi>全职<span
							class="s1"></span>人
						</li>
						<div class="s"></div>
						<li class="bgcolor" style="width:auto;" id="jianzhinum" jianzhi>兼职<span
							class="s1"></span>人
						</li>
					</ul>
					<ul
						style="width:auto;height:80px;box-shadow: 0px 0px 4px #00c8f9;"
						class="padr">
						<li class="bgcolor" style="width:auto;"
							onclick="NewPage('skiptopage/topage/shiyongqi_search')"
							id="shiyongqinum">试用期<span class="s1"></span>人
						</li>
						<div class="s"></div>
						<li class="bgcolor" style="width:auto;"
							onclick="NewPage('skiptopage/topage/requestleave_search')"
							id="ligangnum">离岗<span class="s1"></span>条
						</li>
						<div class="s"></div>
						<li class="bgcolor" style="width:auto;"
							onclick="NewPage('dimission_search.html')" id="tingxinnum">停薪留职<span
							class="s1">1</span>人
						</li>
					</ul>
					<ul
						style="width:auto;height:80px;box-shadow: 0px 0px 4px #00c8f9;"
						class="padr">
						<li class="bgcolor" style="width:auto;" onclick="NewPage('dimission_search.html')"
							id="dailizhinum">待离职<span class="s1"></span>人
						</li>
						<div class="s"></div>
						<li class="bgcolor" style="width:auto;"
							onclick="NewPage('dimission_search.html')" id="lizhinum">离职<span
							class="s1"></span>人
						</li>
					</ul>
				</div>
			</div>
			<div>
				<h1 class="tabTitle">员工信息管理</h1>
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
						<option value="13">后勤部</option>
					</select> <input type="button" value="搜索" class="insertButton"
						id="souSuoNameAndDepart" sousuonum="在职" /> 
						<input type="button"
						value="高级搜索" class="searchButton" id="gaoJiSouSuo" sousuonum="在职" />

					<input type="button" value="删除" class="deleteButton" id="deleteemp" />

					<input type="button" value="证件信息" class="insertButton" id="a" /> <input
						type="button" value="紧急联系人信息" class="insertButton" id="b" /> <input
						type="button" value="学习/工作经历/社会关系" class="insertButton" id="c" />

				</div>
				<!--搜索区结束-->

				<div class="tableInfo">
					<table cellpadding="0" cellspacing="0" border="0"
						class="selectTable" id="tableData1">
						<thead>
							<tr>
								<!--  <th><input type="checkbox" class="all"/></th>-->
								<th>编号</th>
								<th>姓名</th>
								<th>性别</th>
								<th>年龄</th>
								<th>邮箱</th>
								<th>部门</th>
								<th>岗位</th>
								<th>联系方式</th>
								<th>入职日期</th>
								<th>转正日期</th>
							</tr>
							<tr class="trs" style="display: none;">
								<td colspan="10" style="color:red;">没有可供查看的数据</td>
							</tr>
						</thead>
						<tbody>
						</tbody>

					</table>
					<!-- 在职 -->
					<div class="pageStyle" id="pageStyle">
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

			<!--弹出框-->
			<div class="mbStyle">&nbsp;</div>
			<!--添加访谈信息-->
			<div class="popupStyle" id="fangtan">
				<h1>
					员工详细信息<span class="closeX" onclick="closeMask('fangtan')">X</span>
				</h1>
				<div class="p_height">&nbsp;</div>
				<form action="#" method="post" enctype="multipart/form-data"
					name="newInsert">
					<table cellpadding="0" cellspacing="0" border="0" class="addTable">
						<tr>
							<td class="tdWidth1">访谈人部门：</td>
							<td class="fangtanrenbumen"></td>
							<td class="tdWidth1">访谈人姓名：</td>
							<td class="fangtanrenxingming"></td>

						</tr>
						<tr>
							<td class="tdWidth1">访谈人岗位：</td>
							<td class="fangtanrengangwei"></td>
							<td class="tdWidth1">被访谈人部门：</td>
							<td class="beifangtanrenbumen"></td>
						</tr>
						<tr>

							<td class="tdWidth1">被访谈人姓名：</td>
							<td class="beifangtanrenxingming"></td>
							<td class="tdWidth1">被访谈人岗位：</td>
							<td class="beifangtanrengangwei"></td>
						</tr>


						<tr>
							<td class="tdWidth1"><span>*</span>访谈原因：</td>
							<td><input type="text" class="textStyle"
								style="width:120px;" id="fangtanseason" /></td>
							<td class="tdWidth1"><span>*</span>访谈时间：</td>
							<td><input type="date" class="dateStyle"
								style="width:120px;" id="fangtandata" /></td>
						</tr>

						<tr>
							<td class="tdWidth1"><span>*</span>访谈内容：</td>
							<td colspan="5"><textarea id="fangtancontent"></textarea></td>
						</tr>
						<tr>
							<td class="tdWidth1">记录人：</td>
							<td id="jiluren">${loginUser.emp_name}</td>
						</tr>
						<tr style="text-align: center;">
							<td colspan="6"><input type="button" value="保存"
								class="saveButton" id="fangtansave" /></td>
						</tr>

					</table>

				</form>
			</div>
			<!--个人信息详情-->
			<div class="popupStyle" id="yyy" style="overflow: hidden;">
				<h1>
					员工详细信息<span class="closeX" onclick="closeMask('yyy')">X</span>
				</h1>
				<div class="p_height">&nbsp;</div>
				<table cellpadding="0" cellspacing="0" border="0" class="addTable">
					<tr>
						<td class="tdWidth"><span>*</span>姓名：</td>
						<td><input type="text" class="textStyle" style="width:120px;"
							id="xxname" /></td>

						<td class="tdWidth">年龄：</td>
						<td><input type="text" class="textStyle" style="width:120px;"
							id="xxage" /></td>
					</tr>
					<tr>
						<td class="tdWidth">性别：</td>
						<td><input type="text" class="textStyle" style="width:120px;"
							id="xxsex" /></td>

						<td class="tdWidth">爱好：</td>
						<td><input type="text" class="textStyle" style="width:120px;"
							id="xxhobby" /></td>
					</tr>
					<tr>

						<td class="tdWidth">学历：</td>
						<td><input type="text" class="textStyle" style="width:120px;"
							id="xxxueli" /></td>
						<td class="tdWidth">改学历：</td>
						<td><select class="selectStyle" style="width:130px;"
							id="xxgaixueli">
								<option value=""></option>
								<option value="硕士">硕士</option>
								<option value="本科">本科</option>
								<option value="专科">专科</option>
								<option value="高中">高中</option>
								<option value="初中及以下">初中及以下</option>
						</select></td>
					</tr>
					<tr>
						<td class="tdWidth">拼音码：</td>
						<td><input type="text" class="textStyle" style="width:120px;"
							id="xxpingyin" /></td>

						<td class="tdWidth">邮箱：</td>
						<td><input type="text" class="textStyle" style="width:120px;"
							id="xxemail" /></td>
					</tr>
					<tr>
						<td class="tdWidth">身份证号：</td>
						<td><input type="text" class="textStyle" style="width:120px;"
							id="xxidcard" /></td>

						<td class="tdWidth">电话号码：</td>
						<td><input type="text" class="textStyle" style="width:120px;"
							id="xxphone" /></td>
					</tr>
					<tr>
						<td class="tdWidth">婚姻状况：</td>
						<td><input type="text" class="textStyle" style="width:120px;"
							id="xxhun" /></td>
						<td class="tdWidth">现住址：</td>
						<td><input type="text" class="textStyle" style="width:120px;"
							id="xxxianzhuzhi" /></td>
					</tr>
					<tr>
						<td class="tdWidth">民族：</td>
						<td><input type="text" class="textStyle" style="width:120px;"
							id="xxmingzu" /></td>
					</tr>
					<tr style="text-align: center;">
						<td colspan="6"><input type="button" value="保存"
							class="saveButton" id="xianqingsave" /></td>
					</tr>
				</table>
			</div>
			<!--
	添加调岗信息
-->
			<div class="popupStyle" id="tiaogang">
				<h1>
					添加调岗信息<span class="closeX" onclick="closeMask('tiaogang')">X</span>
				</h1>
				<div class="p_height">&nbsp;</div>
				<form action="#" method="post" enctype="multipart/form-data"
					name="newInsert">
					<table cellpadding="0" cellspacing="0" border="0" class="addTable">
						<tr>
							<td class="tdWidth">原部门：</td>
							<td class="tiaogangbumen">市场渠道部</td>
							<td class="tdWidth">姓名：</td>
							<td class="tiaogangxingming">李娜</td>
							<td class="tdWidth">原岗位：</td>
							<td class="tiaoganggangwei">院校经理</td>
						</tr>

						<tr>
							<td class="tdWidth"><span>*</span>目标部门：</td>
							<td><select class="selectStyle" style="width:130px;"
								id="yijiliandong">
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
							<td class="tdWidth"><span>*</span>目标岗位：</td>
							<td class="erji"><select class="selectStyle"
								style="width:130px;" id="erjiliandong">

							</select></td>

						</tr>

						<tr>
							<td class="tdWidth"><span>*</span>调岗原因：</td>
							<td><input type="text" class="textStyle"
								style="width:120px;" id="tiaogangseason" /></td>
							<td class="tdWidth"><span>*</span>调岗时间：</td>
							<td><input type="date" class="dateStyle"
								style="width:120px;" id="tiaogangdata" /></td>

						</tr>
						<tr>
							<td class="tdWidth"><span>*</span>详细说明：</td>
							<td colspan="5"><textarea class="tiaogangcontent"></textarea></td>

						</tr>
						<tr style="text-align: center;">

							<td colspan="6"><input type="button" value="保存"
								class="saveButton" id="tiaogangsave" /></td>
						</tr>

					</table>

				</form>

			</div>
			<!--新增奖惩信息-->
			<div class="popupStyle" id="jiangcheng">
				<h1>
					添加奖惩信息<span class="closeX" onclick="closeMask('jiangcheng')">X</span>
				</h1>
				<div class="p_height">&nbsp;</div>
				<form action="#" method="post" enctype="multipart/form-data"
					name="newInsert">
					<table cellpadding="0" cellspacing="0" border="0" class="addTable">
						<tr>
							<td class="tdWidth"><span>*</span>部门：</td>
							<td class="jianbumen">咨询部</td>
							<td class="tdWidth">姓名：</td>
							<td class="jianxingming">李娜</td>
						</tr>
						<tr>
							<td class="tdWidth">岗位：</td>
							<td jiangangwei>咨询师</td>


							<td class="tdWidth">奖励类型：</td>
							<td class="jianchu"><input type="radio" name="hobby"
								class="checkedStyle" checked="checked" value="奖励" />
								奖励&nbsp;&nbsp; <input type="radio" name="hobby"
								class="checkedStyle" value="处分" /> 处分</td>
						</tr>

						<tr>
							<td class="tdWidth"><span>*</span>奖惩时间：</td>
							<td><input type="date" class="dateStyle"
								style="width:120px;" id="jiandata" /></td>
							<td class="tdWidth"><span>*</span>奖惩原因：</td>
							<td><input type="text" class="textStyle"
								style="width:120px;" id="jianseason" /></td>

						</tr>


						<tr>
							<td class="tdWidth"><span>*</span>详细说明：</td>
							<td colspan="5"><textarea class="jiancontent"></textarea></td>
						</tr>
						<tr style="text-align: center;">

							<td colspan="6"><input type="button" value="保存"
								class="saveButton" id="jiansave" /></td>
						</tr>
					</table>

				</form>

			</div>
			<!--添加离岗信息-->
			<div class="popupStyle" id="ligang">
				<h1>
					添加离岗信息<span class="closeX" onclick="closeMask('ligang')">X</span>
				</h1>
				<div class="p_height">&nbsp;</div>
				<form action="#" method="post" enctype="multipart/form-data"
					name="newInsert">
					<table cellpadding="0" cellspacing="0" border="0" class="addTable">
						<tr>
							<td class="tdWidth"><span></span>部门：</td>
							<td class="ligangbumen">咨询部</td>
							<td class="tdWidth">姓名：</td>
							<td class="ligangxingming">李娜</td>
						</tr>

						<tr>
							<td class="tdWidth">岗位：</td>
							<td class="liganggangwei">咨询师</td>
							<td class="tdWidth"><span>*</span>类型：</td>
							<td><select class="selectStyle" style="width:130px;"
								id="ligangxuanzhe">
									<option value="0">请选择</option>
									<option value="病假">病假</option>
									<option value="事假">事假</option>
									<option value="年假">年假</option>
									<option value="调休">调休</option>
									<option value="婚假">婚假</option>
									<option value="丧假">丧假</option>
									<option value="产假">产假</option>
									<option value="外出">外出</option>
							</select></td>
						</tr>
						<tr>
							<td class="tdWidth"><span>*</span>起始日期：</td>
							<td><input type="date" class="dateStyle"
								style="width:120px;" id="qishiriqi" /></td>

							<td class="tdWidth"><span>*</span>截止日期：</td>
							<td><input type="date" class="dateStyle"
								style="width:120px;" id="jiezhiriqi" /></td>

						</tr>


						<tr>
							<td class="tdWidth">合计：</td>
							<td class="ligangheji"></td>
							<td class="tdWidth"><span>*</span>离岗原因：</td>
							<td colspan="5"><textarea class="ligangseason"></textarea></td>
						</tr>

						<tr>
							<td class="tdWidth">批准人：</td>
							<td><input type="text" style="width: 120px;" value="魏丽萍"
								class="ligangpizhunren" /></td>
						</tr>
						<tr style="text-align: center;">

							<td colspan="6"><input type="button" value="保存"
								class="saveButton" id="ligangsave" /></td>
						</tr>
					</table>

				</form>

			</div>
			<!--
   	添加调薪信息
   -->
			<div class="popupStyle" id="tiaoxin">
				<h1>
					添加调薪信息<span class="closeX" onclick="closeMask('tiaoxin')">X</span>
				</h1>
				<div class="p_height">&nbsp;</div>
				<form action="#" method="post" enctype="multipart/form-data"
					name="newInsert">
					<table cellpadding="0" cellspacing="0" border="0" class="addTable">
						<tr>
							<td class="tdWidth"><span></span>部门：</td>
							<td class="tiaoxinbumen">咨询部</td>


							<td class="tdWidth">姓名：</td>
							<td class="tiaoxinxingming">李娜</td>
						</tr>

						<tr>
							<td class="tdWidth">岗位：</td>
							<td class="tiaoxingangwei">咨询师</td>

							<td class="tdWidth"><span>*</span>调薪前薪资：</td>
							<td><input type="text" class="textStyle"
								style="width: 120px;" id="tiaoxinqian" /><span></span></td>
							</td>
						</tr>
						<tr>
							<td class="tdWidth"><span>*</span>调薪后薪资：</td>
							<td><input type="text" class="textStyle"
								style="width: 120px;" id="tiaoxinhou" /><span></span></td>
							</td>

							<td class="tdWidth"><span>*</span>调薪原因：</td>
							<td><input type="text" class="textStyle"
								style="width: 120px;" placeholder="请输入原因" id="tiaoxinseason" /></td>
						</tr>
						<tr>

							<td class="tdWidth"><span>*</span>详情说明：</td>
							<td colspan="5"><textarea class="tiaoxincontent"></textarea></td>
						</tr>
						<tr style="text-align: center;">

							<td colspan="6"><input type="button" value="保存"
								class="saveButton" id="tiaoxinsave" /></td>
						</tr>
					</table>

				</form>

			</div>




			<!--
   	添加离职信息
   -->
			<div class="popupStyle" id="lizhi">
				<h1>
					添加离职信息<span class="closeX" onclick="closeMask('lizhi')">X</span>
				</h1>
				<div class="p_height">&nbsp;</div>
				<form action="#" method="post" enctype="multipart/form-data"
					name="newInsert">
					<table cellpadding="0" cellspacing="0" border="0" class="addTable">
						<tr>
							<td class="tdWidth1"><span></span>离职员工部门：</td>
							<td class="lizhibumen">咨询部</td>
						</tr>
						<tr>
							<td class="tdWidth1">离职员工姓名：</td>
							<td class="lizhixingming">李娜</td>
						</tr>

						<tr>
							<td class="tdWidth1">离职员工岗位：</td>
							<td class="lizhigangwei">咨询师</td>
						</tr>
						<tr>
							<td class="tdWidth1"><span>*</span>选择离职类型</td>
							<td class="lizhitype"><input type="radio" name="lizhi"
								class="checkedStyle" checked="checked" value="1" />
								离职&nbsp;&nbsp; <input type="radio" name="lizhi"
								class="checkedStyle" value="2" /> 待离职&nbsp;&nbsp; <input
								type="radio" name="lizhi" class="checkedStyle" value="3" />
								停薪留职</td>
						</tr>
						<tr>
							<td class="tdWidth1"><span>*</span>离职时间：</td>
							<td><input type="date" class="dateStyle"
								style="width:120px;" id="lizhidata" /></td>
						</tr>

						<tr>
							<td class="tdWidth1"><span>*</span>离职原因：</td>
							<td colspan="5"><textarea class="lizhiseason"></textarea></td>
						</tr>
						<tr>
							<td class="tdWidth1">登记人</td>
							<td class="dengjiren"></td>
						</tr>

						<tr style="text-align: center;">

							<td colspan="6"><input type="button" value="保存"
								class="saveButton" id="lizhisave" /></td>
						</tr>
					</table>
				</form>
			</div>
			<!--
   	添加岗位
   -->

			<div class="popupStyle" id="gangwei" style="overflow: hidden;">
				<h1>
					添加岗位<span class="closeX" onclick="closeMask('gangwei')">X</span>
				</h1>
				<div class="p_height">&nbsp;</div>
				<form action="#" method="post" enctype="multipart/form-data"
					name="newInsert">
					<table cellpadding="0" cellspacing="0" border="0" class="addTable">
						<tr>
							<td class="tdWidth">部门：</td>
							<td><select class="selectStyle bumen" style="width:130px;"
								id="departmentdeid">
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
									<option value="13">后勤部</option>
							</select></td>
							<span class="bumens"></span>
							<td class="tdWidth">岗位：</td>
							<td><input type="text" style="width: 120px;"
								class="textStyle" placeholder="请输入岗位" id="gangweiName" /><span></span></td>
						</tr>
						<tr>
							<td class="tdWidth">权限等级：</td>
							<td><select class="selectStyle" style="width:130px;"
								id="quanxiandeid">
									<option value="0">请选择：</option>

									<option value="1">校长</option>
									<option value="2">经理</option>
									<option value="3">主管</option>
									<option value="4">员工</option>

							</select></td>
							<span class="dengjis"></span>
						</tr>
						<tr style="text-align: center;">
							<td colspan="6"><input type="button" value="保存"
								class="saveButton" id="savegangwei" /></td>
						</tr>
					</table>
				</form>
			</div>
			<!--

   	高级搜索
   -->
			<div class="popupStyle" id="search" style="overflow-y: hidden;">
				<h1>
					高级搜索<span class="closeX" onclick="closeMask()">X</span>
				</h1>
				<div class="p_height">&nbsp;</div>
				<form action="#" method="post" enctype="multipart/form-data"
					name="search">
					<table cellpadding="0" cellspacing="0" border="0" class="addTable">
						<tr>
							<td class="tdWidth">手机号：</td>
							<td><input type="search" class="searchStyle"
								style="width:120px;" placeholder="请输入手机号" id="gaojiphone" /><span></span></td>
							<td class="tdWidth">出生日期：</td>
							<td><input type="date" class="dateStyle"
								style="width:140px;" id="gaojidata" /></td>
						</tr>
						<tr>

							<td class="tdWidth">学历：</td>
							<td><select class="selectStyle" style="width:130px;"
								id="gaojixueli">
									<option value="">请选择</option>
									<option value="硕士">硕士</option>
									<option value="本科">本科</option>
									<option value="专科">专科</option>
									<option value="高中">高中</option>
									<option value="初中及以下">初中及以下</option>
							</select></td>
						</tr>
						<tr>
							<td class="tdWidth"></td>
							<td><input type="button" value="搜索"
								class="searchButton gaojisave" id="searchButton" /></td>
						</tr>
					</table>
				</form>
			</div>

			<!--添加证件信息-->
			<div class="popupStyle" id="zzzz">
				<h1>
					添加证件信息<span class="closeX" onclick="closeMask('zzzz')">X</span>
				</h1>
				<div class="p_height">&nbsp;</div>

				<table cellpadding="0" cellspacing="0" border="0" class="addTable">
					<tr>
						<td class="tdWidth" style="margin-left: 20px;">身份证正面：</td>

						<td colspan="5">
							<form action="#" id="visitForm1" name="upform" method="post"
								enctype="multipart/form-data">
								<a href="#" class="fileStyle" title="请选择要上传的文件"> <input
									type="file" class="file" name="file" id="file"
									onchange="document.getElementById('imgUrl').value=this.value" />
								</a> <input type="text" class="textStyle" id="imgUrl"
									style="width:200px;" /> <input type="button"
									class="uploadButton" id="shang1" x1 value="上传" />
							</form>
						</td>



						<td class="tdWidth" style="margin-left: 20px;">身份证反面：</td>
						<td colspan="5">
							<form action="#" id="visitForm2" name="upform" method="post"
								enctype="multipart/form-data">
								<a href="#" class="fileStyle" title="请选择要上传的文件"> <input
									type="file" class="file" name="file" id="file"
									onchange="document.getElementById('imgUrl1').value=this.value" />
								</a> <input type="text" class="textStyle" id="imgUrl1"
									style="width:200px;" /> <input type="button"
									class="uploadButton" id="shang2" x2 value="上传" />
							</form>
						</td>

					</tr>
					<tr>


						<td class="tdWidth" style="margin-left: 20px;">学位证：</td>
						<td colspan="5">
							<form action="#" id="visitForm3" name="upform" method="post"
								enctype="multipart/form-data">
								<a href="#" class="fileStyle" title="请选择要上传的文件"> <input
									type="file" class="file" name="file" id="file"
									onchange="document.getElementById('imgUrl3').value=this.value" />
								</a> <input type="text" class="textStyle" id="imgUrl3"
									style="width:200px;" /> <input type="button"
									class="uploadButton" id="shang3" x3 value="上传" />
							</form>
						</td>


						<td class="tdWidth" style="margin-left: 20px;">学历证：</td>
						<td colspan="5">
							<form action="#" id="visitForm4" name="upform" method="post"
								enctype="multipart/form-data">
								<a href="#" class="fileStyle" title="请选择要上传的文件"> <input
									type="file" class="file" name="file" id="file"
									onchange="document.getElementById('imgUrl4').value=this.value" />
								</a> <input type="text" class="textStyle" id="imgUrl4"
									style="width:200px;" /> <input type="button"
									class="uploadButton" id="shang4" x4 value="上传" />
							</form>
						</td>

					</tr>
					<tr>

						<td class="tdWidth" style="margin-left: 20px;">技术职称：</td>
						<td colspan="5">
							<form action="#" id="visitForm5" name="upform" method="post"
								enctype="multipart/form-data">
								<a href="#" class="fileStyle" title="请选择要上传的文件"> <input
									type="file" class="file" name="file" id="file"
									onchange="document.getElementById('imgUrl5').value=this.value" />
								</a> <input type="text" class="textStyle" id="imgUrl5"
									style="width:200px;" /> <input type="button"
									class="uploadButton" id="shang5" x5 value="上传" />
							</form>
						</td>

					</tr>
					<tr style="text-align: center;">
						<td colspan="12"><input type="button" id="shangchuanbc"
							value="保存" class="saveButton" /></td>
					</tr>
				</table>


			</div>

			<!--添加紧急联系人-->
			<div class="popupStyle" id="aaaa">
				<h1>
					添加紧急联系人<span class="closeX" onclick="closeMask('zzzz')">X</span>
				</h1>
				<div class="p_height">&nbsp;</div>
				<form action="#" method="post" enctype="multipart/form-data"
					name="newInsert">
					<table cellpadding="0" cellspacing="0" border="0" class="addTable">
						<tr>
							<td class="tdWidth"><span>*</span>姓名：</td>
							<td><input type="text" class="textStyle"
								style="width:120px;" placeholder="请输入姓名" id="jinjiname" /></td>
							<td class="tdWidth"><span>*</span>手机号：</td>
							<td><input type="text" class="textStyle"
								style="width:120px;" placeholder="请输入手机号" id="jinjiphone" maxlength="11" /><span></span>
							</td>
						</tr>

						<tr>
							<td class="tdWidth"><span>*</span>与本人关系：</td>
							<td><input type="text" class="textStyle"
								style="width:120px;" placeholder="请输入与本人的关系" id="jinjirelation" />
							</td>
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
							<td class="tdWidth"><span>*</span>住址详情：</td>
							<td colspan='2'><input type="text" class="textStyle"
								style="width:300px;" id="nowlocal" /></td>
						</tr>
						<tr style="text-align: center;">
							<td colspan="12"><input type="button" value="保存"
								class="saveButton" id="jinjisave"/></td>
						</tr>
					</table>
				</form>

			</div>
			<!--添加经历-->
			<div class="popupStyle" id="cccc">
				<h1>
					添加经历<span class="closeX" onclick="closeMask('zzzz')">X</span>
				</h1>
				<div class="p_height">&nbsp;</div>
				<form action="#" method="post" enctype="multipart/form-data"
					name="newInsert">
					<table cellpadding="0" cellspacing="0" border="0" class="addTable">
						<tr>
							<td class="tdWidth">工作经历：</td>
							<td colspan="5"><textarea class="areaStyle"
									style="width:360px;" id="gongzuo"></textarea></td>
							<td class="tdWidth">教育经历：</td>
							<td colspan="5"><textarea class="areaStyle"
									style="width:360px;" id="jiaoyu"></textarea></td>
						</tr>
						<tr style="height:150px">
							<td class="tdWidth">培训经历：</td>
							<td colspan="5"><textarea class="areaStyle"
									style="width:360px;" id="peixun"></textarea></td>
							<td class="tdWidth">社会关系：</td>
							<td colspan="5"><textarea class="areaStyle"
									style="width:360px;" id="shehui"></textarea></td>
						</tr>
						<tr>
							<td class="tdWidth">备注：</td>
							<td colspan="5"><textarea class="areaStyle"
									style="width:360px;" id="beizhu"></textarea></td>

						</tr>
						<tr style="text-align: center;">
							<td colspan="12"><input type="button" value="保存"
								class="saveButton" id="jinglisave" /></td>
						</tr>
					</table>
				</form>
			</div>
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
			<div class="d_bt_ok"></div>
			<div class="d_bt_cancel"></div>
		</div>
	</div>
	<!--删除成功结束-->
</body>
</html>
