<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>首页内联</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="statics/pcui/css/global.css">
	<link rel="stylesheet" type="text/css" href="statics/pcui/css/index.css">
	<link rel="stylesheet" type="text/css" href="statics/pcui/css/popup.css">
	<link rel="stylesheet" type="text/css" href="statics/pcui/css/documentation.css"/>
	<link rel="stylesheet" type="text/css" href="statics/pcui/css/jalendar.css"/>
	<link rel="stylesheet" type="text/css" href="statics/pcui/css/style.css"/>
    <link rel="stylesheet" type="text/css" href="statics/pcui/css/global.css">
   	<link rel="stylesheet" type="text/css" href="statics/pcui/css/day.css">
   	<link rel="stylesheet" type="text/css" href="statics/pcui/css/calendar.css"/>
   	<link rel="stylesheet" type="text/css" href="statics/pcui/css/popup.css" />
   	<link rel="stylesheet" type="text/css" href="statics/pcui/css/form.css" />
   	<link rel="stylesheet" type="text/css" href="statics/pcui/css/add.css" />
	<script type="text/javascript" src="statics/pcui/js/alert.js"></script>
	<script type="text/javascript" src="statics/pcui/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="statics/pcui/js/index.js"></script>
	<script type="text/javascript" src="statics/pcui/js/openpage.js"></script>
	<script type="text/javascript" src="statics/pcui/js/jalendar.js"></script>
	<script type="text/javascript" src="statics/pcui/js/showtable.js"></script>
	<script type="text/javascript" src="statics/pcui/js/stulist.js"></script>
	<script type="text/javascript" src="statics/pcui/js/tab.js"></script>
	<style type="text/css">
		body,li{
			list-style: none;
		}
		.tx{
			width: 48%;
			height:70px;
			float: left;
			padding:2px 0;
		}
		.tx p{
			text-align: center;
		}
		.tx p:first-child{
			margin-top:19px ;
		}
		.tx:hover{
			box-shadow: #A9A9A9 0px 1px 6px;
			cursor: pointer;
		}
		td{
			border: 1px solid #e5e5e5;
		}
	</style>
	<style type="text/css">
		#content{
		overflow:hidden;
		}
	</style>
	<style type="text/css">
    	body{font-size:12px;}
    	p,div{margin:0;padding:0}
        .textarea{
        	width:100%;height:80px;position:absolute;background:none;z-index:9
        }
        .note{
        	position:absolute;line-height:20px;padding:3px 5px;
        }
    </style>
	<script type="text/javascript">
		$(function () {
		    $('#myId3').jalendar();
		    SelectAll();
		    jijiang();
		    function SelectAll(){
		    	$.ajax({
					type: "POST",
					url: "selectAll",
					success : function(data) {
						var num = 0;
						var sexn = 0;
						var lt25 =0;
						var gt25lt30 =0;
						var gt30lt35 =0;
						var gt35lt40 =0;
						var gt40 =0;
						for(var i =0;i<data.length;i++){
							num+=1;
							if(data[i].emp_sex=="男"){
								sexn+=1;
							} 
							if(data[i].emp_age<25){
								lt25+=1;
							}else if(25<=data[i].emp_age&&data[i].emp_age<30){
								gt25lt30+=1;
							}else if(30<=data[i].emp_age&&data[i].emp_age<35){
								gt30lt35+=1;
							}else if(35<=data[i].emp_age&&data[i].emp_age<40){
								gt35lt40+=1;
							}else{
								gt40+=1;
							}
						}
						var sexnv = num-sexn;
						/* 性别 */
						$(".sex p:eq(0) span:eq(0)").text(sexn);
						$(".sex p:eq(0) span:eq(1)").text((sexn/num).toFixed(3)*100);
						$(".sex p:eq(1) span:eq(0)").text(sexnv);
						$(".sex p:eq(1) span:eq(1)").text((sexnv/num).toFixed(3)*100);	
						/* 年龄 */
					 	$(".age p:eq(0) span:eq(0)").text(lt25);
						$(".age p:eq(0) span:eq(1)").text((lt25/num).toFixed(3)*100);
						$(".age p:eq(1) span:eq(0)").text(gt25lt30);
						$(".age p:eq(1) span:eq(1)").text((gt25lt30/num).toFixed(3)*100);
						$(".age p:eq(2) span:eq(0)").text(gt30lt35);
						$(".age p:eq(2) span:eq(1)").text((gt30lt35/num).toFixed(3)*100);
						$(".age p:eq(3) span:eq(0)").text(gt35lt40);
						$(".age p:eq(3) span:eq(1)").text((gt35lt40/num).toFixed(3)*100);
						$(".age p:eq(4) span:eq(0)").text(gt40);
						$(".age p:eq(4) span:eq(1)").text((gt40/num).toFixed(3)*100);
					}
				});
			}
	
			function jijiang() {
				//获得搜索条件
				var zhuang = "即将到期";
				var emp_name = null;
				var contract_id = null;
				var contract_startDate = null;
				var contract_endDate = null;
				var contract_status = null;
				$.ajax({
					type : "POST",
					url : "employee_contract_search",
					dataType : "json",
					data : {
						emp_name : emp_name,
						contract_startDate : contract_startDate,
						contract_endDate : contract_endDate,
						contract_id : contract_id,
						contract_status : zhuang,
						pageIndex : 1,
						pageSize:100
					},
					success : function showList(data) {
						var datas = eval("(" + data + ")");
						var pageCount = datas.totalPageCount;
						var index = datas.currentPageNo;
						var count = datas.totalCount;
						var count2 = datas.totalCount2;
						var oaRlzybEmployees = datas.oaRlzybEmployees;
						$("#het span").text(count2);
					},
				});
			} 
			
			dailizhinum();
			function dailizhinum(){
				$.ajax({
					type: "post",
					url: "Employee/selectCountdailizhi",
					success : function(data) {
						$("#dailizhinum span").text(data);
					}
				});
			}
			//待转正人数
			shiyongqinum();
			function shiyongqinum(){
				$.ajax({
					type: "post",
					url: "Employee/selectCountshiyongqi",
					success : function(data) {
						$("#shiyongqinum span").text(data.length);
					}
				});
			}
		
			$("#content").on("click",".a",function(){
	    		var ida=$(this).attr("id");
	    		$(".d_bt_ok").attr("s",ida);
				deleteShowAlert("删除提示","确定要删除吗？","确定","取消");
	    		$(".d_bt_ok").click(function(){
	    		  $.ajax({
					type: "POST",
					url: "del",
					data:{"id":$(".d_bt_ok").attr("s")},
					success : function(result) {
							if(result>0){
								fen();
							}
						}
					});
	    		})
		    });
			    
		    $("#tijiao").click(function(){
				var name="${loginUser.emp_name}";
		    	var text=$("#dhtext").val();
		    	var val=document.getElementById('dhtext').value;
				if(val==0) {
				    showWebAlert("提交不能为空！");
				}else{
					$.ajax({
						type: "POST",
						url: "insertItem",
						data:{"name":name,"text":text},
						success : function(result) {
							if(result>0){
								showWebAlert("提交成功！");
								fen();
								$("#dhtext").val("");
							}
						}
					});
				}
			});
			
			sd();
			function sd(){
				$.ajax({
					type: "POST",
					url: "Employee/getHumanAffairsOaRlzybEmployeess",
					success : function(result) {
						$("#birth span").text(result.length);
					}
				});
			}
			
			$("#benyue").click(function(){
				mask(650,450,false,"search",false);
				$.ajax({
					type: "POST",
					url: "Employee/getHumanAffairsOaRlzybEmployeess",
					success : function(result) {
						var str = "";
						$(".addTable tbody").html(""); 
						for(var i=0;i<result.length;i++){
							str+="<tr>"
							str+="<td style='text-align:center;'>"+result[i].emp_name+"</td>";
							str+="<td style='text-align:center;'>"+(new Date(result[i].emp_birthday).getFullYear()+"-")+
							(new Date(result[i].emp_birthday).getMonth()+1+"-")+
							(new Date(result[i].emp_birthday).getDate())+"</td>";
							str+="</tr>"
						}
						$(".addTable tbody").html(str);	
					}
				});
			});
			
			$("body").keydown(function () {
				if (event.keyCode == "13") {
					$("#tijiao").click();
				}
			});
			
			fen();
			function fen(){
			$.ajax({
				type: "POST",
				url: "OaRlzybWelcome",
					success : function(data) {
						var $dl = $("dl");
						var $ud = $(".pageStyle")
						$dl.html("");  
						for(var i=0;i<data.length;i++){
							$dl.append("<dt id="+data[i].id+" style='color:black; font-size:13px; '>"+"<span style='color:7EA7D8;'>"+"发布时间 : "+"</span>"+data[i].time+"</dt>");
							$dl.append("<dd style='color:black; font-size:13px;'>"+"<span style='color:7EA7D8;'>"+"事项内容 : "+"</span>"+data[i].text+"</dd>");
							$dl.append("<dd style='color:black; font-size:13px;'>"+"<span style='color:7EA7D8;'>"+"发布人员 : "+"</span>"+data[i].name+"</dd>");
							$dl.append("<dd style='float:right;'><a href='javascript:;' class='a' id="+data[i].id+" style='color:red; font-size:13px;'>"+"删除"+"</a></dd>");
							$dl.append("<dd>"+"&nbsp;"+"</dd>");
							$dl.append("<dd style='color:7EA7D8;'>"+"——————————————————"+"</dd>");
							$dl.append("<dd>"+"&nbsp;"+"</dd>");
						}
					}
				});
			}
		});
		
	</script>
	<script type="text/javascript">
		/*删除弹出框点击确定或者取消*/
		function subForm(result){
			if(result){
				showWebAlert('删除成功！');   
			}   
		}
		/*结束*/
	</script>
  </head>
  
  <body>
  		<div class="container" style="width:100%; height:800px;">
  		<div class="container">
			<!-- 首页展示功能开始 -->
			<div class="menu" style="float: left;width:180rem; height: auto" >
				<!-- 日历 -->
				<div style="float:left;" >
					<div id="calendar" class="calendar" style="box-shadow: #A9A9A9 0px 1px 6px; height:450px;"></div>
					<script type="text/javascript" src="statics/pcui/js/jquery.min.js"></script>
  					<script type="text/javascript" src="statics/pcui/js/calendar.js"></script>
				</div>
				
		    	<!-- 事项提醒 -->
		    	<div style="width:22rem; height: 530px; float: left;margin-left:2%;">
			    	<div class="aert" style="border-radius: 5px; box-shadow: #A9A9A9 0px 1px 6px; width: 100%; margin: 30px 0px; float:left; background-color: #FAFAFA; height: 220px;">
			    		<h3 style="padding:5px; box-shadow: #A9A9A9 0px 1px 6px; text-align: center; border-radius: 5px;">人事提醒</h3>
			    		<div>
			    			<div class="tx" style="margin-left:6px; margin-top: 12px;" onclick="NewPage('dimission_search.html')">
			    				<p id="dailizhinum"><span style="color: red;"></span>人</p>
			    				<p><a>待离职提醒</a></p>
			    			</div>
			    			<div class="tx" style="margin-top: 12px;" onclick="NewPage('skiptopage/topage/shiyongqi_search')">
			    				<p id="shiyongqinum"><span style="color: red;"></span>人</p>
			    				<p><a>待转正提醒</a></p>
			    			</div>
			    			<div class="tx" style="margin-left:6px; margin-top: 4px;" onclick="NewPage('skiptopage/topage/employee_contract_search')">
			    				<p id="het"><span style="color: red;"></span>人</p>
			    				<p><a>合同到期提醒</a></p>
			    			</div>
			    			<div class="tx" style="margin-top: 4px;" id="benyue">
			    				<p id="birth"><span style="color: red;"></span>人</p>
			    				<p><a>本月生日提醒</a></p>
			    			</div>
			    		</div>
			    	</div>
			    	
			    	<div style="border-radius: 5px; box-shadow: #A9A9A9 0px 1px 6px; float: left; width: 100%; background-color: #FAFAFA; height: 225px;">
			    		<h3 style="padding:5px;box-shadow: #A9A9A9 0px 1px 6px; text-align: center; border-radius: 5px;">职员数据统计</h3>
			    		<div>
			    			<div class="sex" style=" float: left; width: 43%; height: 180px; text-align: center;">
			    				<h4 style="margin: 15px; color: #2098D1;">职员男女比例</h4>
			    				<p>男：<span>25</span>人，占比：<span>50</span>%</p>
			    				<p style="color: #7986CB">女：<span>25</span>人，占比：<span>50</span>%</p>
			    			</div>
			    			<div class="age" style="padding :0 7px;margin:7px 0px; float: left; width: 52%; border-left: 1px solid #999999; height: 180px;">
			    				<h4 style="margin: 15px; color: #2098D1; text-align:center;">职员年龄段比例</h4>
			    				<p>25岁以下：<span>10</span>人，占比：<span>10</span>%</p>
			    				<p style="color: #7986CB;padding-left:0.1em;">25~30岁：<span>10</span>人，占比：<span>10</span>%</p>
			    				<p style="padding-left:0.1em;">30~35岁：<span>10</span>人，占比：<span>10</span>%</p>
			    				<p style="color: #7986CB;padding-left:0.1em;">35~40岁：<span>10</span>人，占比：<span>10</span>%</p>
			    				<p>40岁以上：<span>10</span>人，占比：<span>10</span>%</p>
			    			</div>
			    		</div>
			    	</div>
		    	</div>
		    	
		    	
		    	<!-- 事项录入 -->
		    	<div style="width:19rem; height: 530px; float:left; margin-left:2%" >
					<div style="border-radius: 5px; box-shadow: #A9A9A9 0px 1px 6px; float: left; width:17rem; margin: 30px 15px; background-color: #FAFAFA; height: 470px;">
						<h3 style="padding:5px;box-shadow: #A9A9A9 0px 1px 6px; text-align: center; border-radius: 5px;">提醒事项</h3>
						<div>
							<div style="position:relative;float: left; width: 100%; margin: 15px 10px; height: 100px;">
						    	<textarea class="textarea" onchange="this.value=this.value.substring(0, 100)" onkeydown="this.value=this.value.substring(0, 100)" onkeyup="this.value=this.value.substring(0, 100)" onfocus="document.getElementById('note').style.display='none'" onblur="if(value=='')document.getElementById('note').style.display='block'" style="width:93%; height:70px; resize:none; float: left;" id="dhtext"></textarea>
				 		    	<div id="note" class="note">
						            <font color="#CCC">点击输入提醒事项，最多可输入100字 ...</font>
						        </div>
						        <button type="submit" style="float: right; margin-top:75px;margin-right:7%; background-color: #96B97D; border: none; color: white; padding: 2px 10px; text-align: center; text-decoration: none; display: inline-block; font-size: 12px; cursor: pointer;" id="tijiao">提交</button>
							</div>
						</div>
						<div id="content" style="overflow-y:visible; border-radius: 5px; box-shadow: #A9A9A9 0px 1px 6px; margin:0 4%;padding:5px; width:88%; float: left; background-color: #FAFAFA; height: 280px;">
							<dl></dl>
							<div class="pageStyle">
						</div>
					</div>
				</div>
			</div>
			
		    <!-- 功能跳转按钮 -->
		    <div style="width:100%; float: left;">
		    	<div class="hover-buttons">
					<div class="wrap">
						<div class="tr-effects">
							<ul class="border-list">
								<li>	
									<span onclick="NewPage('skiptopage/topage/employee_info_search')" class="hvr-ripple-out button2" style="padding: 18px 50px; background-image:url(statics/pcui/images/jbxx1.png); background-repeat: no-repeat; background-position:15px 12px ;">&nbsp;&nbsp;&nbsp;基本信息</span>
									<span onclick="NewPage('skiptopage/topage/employee_info_add')" class="hvr-ripple-out button2" style="padding: 18px 50px; background-image:url(statics/pcui/images/tjyg2.png); background-repeat: no-repeat; background-position:15px 12px ;">&nbsp;&nbsp;&nbsp;添加员工</span>
									<span onclick="NewPage('transfer_position_search.html')" class="hvr-ripple-out button2" style="padding: 18px 50px; background-image:url(statics/pcui/images/tgxx3.png); background-repeat: no-repeat; background-position:15px 12px ;">&nbsp;&nbsp;&nbsp;调岗信息</span>
									<span onclick="NewPage('skiptopage/topage/requestleave_search')" class="hvr-ripple-out button2" style="padding: 18px 50px; background-image:url(statics/pcui/images/lgxx4.png); background-repeat: no-repeat; background-position:15px 12px ;">&nbsp;&nbsp;&nbsp;离岗信息</span>
								</li>
								<li>	
									<span onclick="NewPage('managesalary_search.html')" class="hvr-ripple-out button2" style="padding: 18px 50px; background-image:url(statics/pcui/images/txxx5.png); background-repeat: no-repeat; background-position:15px 12px ;">&nbsp;&nbsp;&nbsp;调薪信息</span>
									<span onclick="NewPage('skiptopage/topage/employee_contract_search')" class="hvr-ripple-out button2" style="padding: 18px 50px; background-image:url(statics/pcui/images/htxx6.png); background-repeat: no-repeat; background-position:15px 12px ;">&nbsp;&nbsp;&nbsp;合同信息</span>
									<span onclick="NewPage('')" class="hvr-ripple-out button2" style="padding: 18px 50px; background-image:url(statics/pcui/images/qdgl7.png); background-repeat: no-repeat; background-position:15px 12px ;">&nbsp;&nbsp;&nbsp;签到管理</span>
									<span onclick="NewPage('interview_search.html')" class="hvr-ripple-out button2" style="padding: 18px 50px; background-image:url(statics/pcui/images/ftxx8.png); background-repeat: no-repeat; background-position:15px 12px ;">&nbsp;&nbsp;&nbsp;访谈信息</span>
								</li>
							</ul>
						</div>
					</div>
				</div>
		    </div>
		</div>
		<div class="mbStyle">&nbsp;</div>
		<!-- 生日提醒弹框 -->
   		<div class="popupStyle" id="search" style="background-color:#">
			<h1>生日提醒<span class="closeX" onclick="closeMask()">X</span></h1>
			<div class="p_height">&nbsp;</div>
			<form action="#" method="post" enctype="multipart/form-data" name="search">
				<table cellpadding="0" cellspacing="0" border="0" class="addTable" >
					<thead>
					<tr style="background-color: #eeeeee;">
						<td><h4 style="text-align:center;">姓名</h4></td><td style="text-align:center;"><h4>生日</h4></td>
					</tr>
					</thead>
					<tbody>
						
					</tbody>
				</table>
			</form>
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
