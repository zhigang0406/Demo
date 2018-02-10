$(function() {
		/* 加载函数 */
		SelectAllInfo();
		SelectAllDepartment();
		SelectAllLeaveType();
			/* 查询离岗信息 */
			 /*高级搜索开始*/
	$("#select").click(function(){
		
		mask(600,300,false,"xxx",false);
	});
	$("#searchButton").click(function(){
	
		closeMask("search");
	});
	
	$("[name=total]").change(function(){
		var page = $("[name=total]").val();
		$("[name=pageSize]").attr("value",page);
		SelectAllInfo();
		});
		$("#imgSearch").click(function(){
			var inde = $("[name=pageNo]").val();
			var page = $("#t").attr("pageSize");
			if(isNaN(inde)){
				alert("请输入正确的数字");
			}else{
				if(inde == 0){
						inde =1;
					}
				if(inde>=page){
				inde=page;
				}
				$("[name=pageIndex]").attr("value",inde);
				
				SelectAllInfo();
				
				
			}
			
			
			$("[name=pageNo]").val("");
		});
	/*高级搜索结束*/
		
		/* 双击事件 */
		$(".selectTable").on("dblclick","tbody tr",function () {
		var emp_name = $(this).children("td:eq(1)").html();
		var position_name = $(this).children("td:eq(2)").html();
		var depart_name = $(this).children("td:eq(3)").html();
		var leave_type = $(this).children("td:eq(4)").html();
		var leave_reason = $(this).children("td:eq(5)").html();
		var leave_approver = $(this).children("td:eq(6)").html();
		var leave_startDate_str = $(this).children("td:eq(7)").html();
		var leave_endDate_str = $(this).children("td:eq(8)").html();
		$(".emp_name").text(emp_name);
		$(".position_name").text(position_name);
		$(".depart_name").text(depart_name);
		$(".leave_type").text(leave_type);
		$(".leave_reason").text(leave_reason);
		$(".leave_approver").text(leave_approver);
		$(".leave_startDate_str").text(leave_startDate_str);
		$(".leave_endDate_str").text(leave_endDate_str);
		mask(1000,3000,false,"yyy");
		
		
		});
		
		$(".selectTable").on("click","tbody tr",function() {
			var id = $(this).attr("leave_id");
			var type= $(this).attr("leave_type");
			var emp= $(this).attr("emp_id");
			var sc=$(this).attr("sc");
			$(".d_bt_ok").attr("sc",sc);
		  	$(".d_bt_ok").attr("s",id);
		  	$(".returnButton").attr("f",type);
		  	$(".returnButton").attr("g",id);
		  	$(".returnButton").attr("h",emp);
        });
        $("#rerere").click(function(){
       		 var type= $(this).attr("f");
       		 if(type=="产假"){
       		 var id = $(this).attr("g");
			var type= $(this).attr("f");
			var emp= $(this).attr("h");
			$("#baocun").attr("f",type);
		  	$("#baocun").attr("g",id);
		  	$("#baocun").attr("h",emp);
       		 	mask(600,210,false,"tankuang");
       		 }else{
       		 	showWebAlert("该功能只针对产假使用");
       		 }
			});
       $("#dedede").click(function(){
		if($(".d_bt_ok").attr("s")==null||$(".d_bt_ok").attr("s")==""){
			showWebAlert('请先选择员工');   
		}else{
			deleteShowAlert("删除提示","确定要删除吗？","确定","取消");
		}
		$(".d_bt_ok").click(function(){
 			var leave_id = $(this).attr("s");
	 		var sc=$(this).attr("sc");
	 		if(sc==1){
		 		$.ajax({
					url:"Leave/leave_delete",
					data:{leave_id:leave_id},
					success:function(data){
						SelectAllInfo();
					}
				});
	 		}else{
	 			showWebAlert("超出48小时不可以删除");
	 		}
	 		$(".d_bt_ok").attr("s","");
 			$(".d_bt_ok").attr("sc","");
 			$(".returnButton").attr("f","");
		  	$(".returnButton").attr("g","");
		  	$(".returnButton").attr("h","");
		})
	});
	
	
	function clearCondition() {
		document.forms[0].reset();
	}
	/* 清空查询条件 */
	$("#clearCondition").click(function() {
		$("#name").attr("value","");
		$("#depart_id").attr("value","0");
		$("#leave_type").attr("value","0");
		
		SelectAllInfo();
 		$(".d_bt_ok").attr("s","");
		$(".d_bt_ok").attr("sc","");
		$(".returnButton").attr("f","");
		$(".returnButton").attr("g","");
	    $(".returnButton").attr("h","");
	});
	});

function SelectAllDepartment() {
		$.post("Leave/addDepartment",showDepartmentList, "text");
	}
	function showDepartmentList(data) {
$("#depart_id").html(data);
}




function SelectAllLeaveType() {
		$.post("Leave/addLeaveType",showLeaveTypeList, "text");
	}
	function showLeaveTypeList(data) {
$("#leave_type").html(data);
}




	/* 查询所有页面 */
	function SelectAllInfo() {
		var condition = $("#searchCondition").serialize();
		$(".selectTable tbody").html("");
		var $ttr = $("<tr></tr>");
		   var $tdd = $("<td colspan='9'></td>");
		   var $img = $("<img src='/RlzybOa/statics/pcui/images/loading2.gif' />");
		   $tdd.append($img);
		   $ttr.append($tdd);
		$(".selectTable tbody").html($ttr);
		$.post("Leave/SelectAllInfo", condition, showLeaveList, "json");
 		$(".d_bt_ok").attr("s","");
		$(".d_bt_ok").attr("sc","");
		$(".returnButton").attr("f","");
		$(".returnButton").attr("g","");
	    $(".returnButton").attr("h","");
	}
	/* 查询所有页面 */
	function SelectAllInf() {
	closeMask('xxx');
		var condition = $("#searchConditio").serialize();
		$.post("Leave/SelectAllInf", condition, showLeaveList, "json");
 		$(".d_bt_ok").attr("s","");
		$(".d_bt_ok").attr("sc","");
		$(".returnButton").attr("f","");
		$(".returnButton").attr("g","");
	    $(".returnButton").attr("h","");
	}
	    var leave_id=null;
        var emp_id = null;
        var leave_type = null;
	function showLeaveList(data) {
     /*    alert(data); */
		var result1 = data.result[0];
		var result2 = data.result[1];
		if(result1==null||result1==""){
			$(".selectTable thead .trs").show();
			$(".pageStyle").css("display","none")
		}else{
			$(".selectTable thead .trs").hide();
			$(".pageStyle").css("display","block")
		}
		$(".divTable").html(result1);
		$("#result").val(result2);
		index();
		/* 点击添加，跳转到添加页面 */
		$("#addInfo").click(function() {
			NewPage("skiptopage/topage/requestleave_add");
		});

		$(".deleteBotton").click(function() {
			$(".deleteStyle").css("display", "block");
		});
		/* 点击添加跳转到查看页面 */
		$(".link").click(function() {
			 leave_id = $(this).attr("leave_id");
			NewPage("Leave/selectAllByleave_id/" + leave_id + "");
		});
			/* 员工复职操作 */
		$(".edit").click(function() {
		$(this).parent().hide();
		$(this).parent().next().show();
		});
	
	}
	
	function checkEmployeeGoBack(){
		closeMask('tianjia');
	var leave_backTime = $("#shijian").val();

	 leave_id = $("#baocun").attr("g");
	 emp_id = $("#baocun").attr("h");
	 leave_type = $("#baocun").attr("f");
    $.post("Leave/checkEmployeeGoBack",{"leave_backTime":leave_backTime,"leave_id":leave_id,"emp_id":emp_id,"leave_type":leave_type},showResult1, "text");
		SelectAllInfo();
	function showResult1(data) {
			if(data=="1"){
			$(checkButton).parent().prev().show();
			$(checkButton).parent().hide();
			$("#searchLeave").click();
			showWebAlert("复职成功！");
			}
		}
	}
	 function index(){
	 var index=$("#t").attr("index");
	 var pageCount=$("#t").attr("pageSize");
	 var count=$("#t").attr("count");
		$(".tabTitle font").text(count);
		
		showPage(index,pageCount,count);
	}
