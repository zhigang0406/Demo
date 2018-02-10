/*表格全选*/
$(function(){
   var index = 1;
	showDate();
	
	$("#select").click(function(){
		mask(650,200,false,"xxx",false);
		
		
	});
	
	$("#searchButton").click(function(){
		closeMask("xxx");
	});
	$(".insertButton").click(function(){
		mask(800,300,false,"zzzz",true);
	});
	$(".saveButton").click(function(){
		closeMask("zzzz");
		showWebAlert("新增成功!");
	});
	$("[name=total]").change(function(){
		showDate(index);
	})
	
	$(".deleteButton").click(function(){
		if($(".d_bt_ok").attr("s")==null||$(".d_bt_ok").attr("s")==""){
			showWebAlert('请先选择员工');   
		}else{
			deleteShowAlert("删除提示","确定要删除吗？","确定","取消");
		}
		$(".d_bt_ok").click(function(){
			var salary_adjustment_id = $(this).attr("s");
				$.ajax({
					url:"managesalary_delete",
					data:{
						salary_adjustment_id:salary_adjustment_id
					},
					success:function(data){
						var index = $("#index").val();
						
	  					if(data.length % 10 == 0 && data.length != 0){
							showDate(index-1);
						}else{
							showDate(index);
						}
						$(".d_bt_ok").attr("s","");
					}
				});
		})
	});
});			
function showDate(index){
	  	//获得搜索条件
		var depart_id = $("#depart_id").val(); //部门
		var emp_name = $("#emp_name").val(); //名称
		var position_id = $("#position_id").val(); //岗位
		var create_time = $("#create_time").val(); //时间
		var pageSize = $("[name=total]").val(); //记录数
		$(".selectTable tbody").html("");
		var $ttr = $("<tr></tr>");
		   var $tdd = $("<td colspan='9'></td>");
		   var $img = $("<img src='/RlzybOa/statics/pcui/images/loading2.gif' />");
		   $tdd.append($img);
		   $ttr.append($tdd);
		$(".selectTable tbody").html($ttr);
	  	$.ajax({
			type:"post",
			url:"managesalary_search",
			dataType:"json",
			data:{
				depart_id:depart_id,
				emp_name:emp_name,
				position_id:position_id,
				create_time:create_time,
				pageIndex:index,
				pageSize:pageSize
			},
			success: showList
		});
	 }

	 function showList(data){
		var datas = eval("("+data+")");
	  	var pageCount = datas.totalPageCount;
	  	
	  	var index= datas.currentPageNo;
	  	var count = datas.totalCount;
	  		  	
	  	var oaRlzybSalaryAdjustments = datas.oaRlzybSalaryAdjustments;
	  	$(".tabTitle font").text(count);
	  	showStuList(oaRlzybSalaryAdjustments);
	  	showPage(index,pageCount,count);
		if(oaRlzybSalaryAdjustments.length!=0){
			$(".pageStyle").css("display","block");
			showPage(index,pageCount,count)
		}else{
			$(".pageStyle").css("display","none");
		}
	 }

	 function dateFmt(time){
		var t = new Date(time);
		var year = t.getFullYear(); //年
		var month = t.getMonth() + 1; //月
		var day = t.getDate(); //日
		if(month < 10){
			month = "0" + month;
		}
		if(day < 10){
			day = "0" + day;
		}
		var dateTimeStr= year + "-" + month + "-"+day;
		return dateTimeStr;
	}
	
	function showStuList(oaRlzybSalaryAdjustments){
		var str ="";
	  	$(".selectTable tbody").html("");
	  	$(".selectTable thead .trs").html("");
		  	if(oaRlzybSalaryAdjustments.length==0){
				$(".selectTable thead .trs").append("<td colspan='9' style='color:red'>没有可供查看的数据</td>");
			}
			for(var i = 0;i < oaRlzybSalaryAdjustments.length ; i++){
				str += "<tr s="+oaRlzybSalaryAdjustments[i].salary_adjustment_id+">";
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
				str += "<td>" + oaRlzybSalaryAdjustments[i].emp_name + "</td>";
				str += "<td>" + oaRlzybSalaryAdjustments[i].depart_name + "</td>";
				str += "<td>" + oaRlzybSalaryAdjustments[i].position_name  + "</td>";
				str += "<td>" + oaRlzybSalaryAdjustments[i].salary_adjustment_reason  + "</td>";
				str += "<td>" + oaRlzybSalaryAdjustments[i].salary_adjustment_beforeMoney + "</td>";
				str += "<td>" + oaRlzybSalaryAdjustments[i].salary_adjustment_afterMoney  + "</td>";
				str += "<td>" + oaRlzybSalaryAdjustments[i].create_time  + "</td>";
				str += "<td style='display:none;'>" + oaRlzybSalaryAdjustments[i].salary_adjustment_explain  + "</td>";
				
				var date1 = new Date(oaRlzybSalaryAdjustments[i].create_time);
				var date3 = new Date();
				str += "</td>";
				str += "</tr>";
			}
			
		$(".selectTable tbody").html(str);
		/* 单击选中删除 */
		$(".selectTable").on("click","tbody tr",function(){
			var id = $(this).attr("s");
		  	$(".d_bt_ok").attr("s",id);
        });
		/*双击事件*/
		$(".selectTable tbody").on("dblclick","tbody tr",function () {
			var emp_name = $(this).children("td:eq(1)").html();
			var depart_name = $(this).children("td:eq(2)").html();
			var position_name = $(this).children("td:eq(3)").html();
			var salary_adjustment_reason = $(this).children("td:eq(4)").html(); //原因
			var salary_adjustment_beforeMoney = $(this).children("td:eq(5)").html();
			var salary_adjustment_afterMoney = $(this).children("td:eq(6)").html();
			var create_time = $(this).children("td:eq(7)").html();
			var interview_content = $(this).children("td:eq(8)").html(); //说明
            //赋值 
			$(".addTable tr:eq(1) td:nth-child(2)").text(emp_name);
			$(".addTable tr:eq(2) td:nth-child(2)").text(depart_name);
			$(".addTable tr:eq(3) td:nth-child(2)").text(position_name);
			$(".addTable tr:eq(4) td:nth-child(2)").text(salary_adjustment_beforeMoney);
			$(".addTable tr:eq(5) td:nth-child(2)").text(salary_adjustment_afterMoney);
			$(".addTable tr:eq(6) td:nth-child(2)").text(salary_adjustment_reason);
			$(".addTable tr:eq(7) td:nth-child(2)").text(interview_content);
			/*true顶部垂直居中*/
             mask(1000,800,false,"yyy");
		});
		
		$(".link").click(function(){
			var salary_adjustment_id = $(this).attr("salary_adjustment_id");
			location.href="managesalary_show?salary_adjustment_id=" + salary_adjustment_id; 
			
		});
		$(".imgSearch").click(function(){
			var index = $("[name=pageNo]").val();
			if(isNaN(index)){
				alert("请输入正确的数字");
			}else{
				showDate(index);
			}
			$("[name=pageNo]").val("");
		})
	}
	
	 $(function(){
	  	showDate(1);
	  	//搜索
	  	$("#search").click(function(){
	  		showDate(1);
	  		$(".d_bt_ok").attr("s","");
	  	});
	  	//高级搜索
	  	$("#searchButton").click(function(){
	  		showDate(1);
	  		$(".d_bt_ok").attr("s","");
	  		$("#position_id").val("0");
	  		$("#phone").val("");
	  		$("#create_time").val("");
	  	});
	  	//清空搜索
	  	$("#clen").click(function(){
			$("#emp_name").val("");
			$("#depart_id").val(0);
			showDate(1);
			$(".d_bt_ok").attr("s","");
		})
	 });

  
/*表格全选*/
$(function(){
	  $("#all").click(function(){
        var checked=$(this).is(":checked");
        $(".selectTable tr td").children().attr("checked",checked);
      });
    //判断是否全选
		function ifAllChecked(){
			var checkedBoxs=$(".selectTable tr td").children();
			var sum=checkedBoxs.size();
			var k=0;
			checkedBoxs.each(function(index,dom){
				if($(dom).is(":checked")) k++;
			});
			if(k==sum){
				$("#all").attr("checked",true);
			}else{
				$("#all").attr("checked",false);
			}
		}
        ifAllChecked();//页面加载完后运行
	
});
/*表格全选结束*/


/* 点击添加跳转到添加页面 */
$(function(){
	$("#addInfo").click(function(){
		location.href="managesalary_add.html";
	});
	
	$("#qing").click(function(){
	  		$("#emp_name").val("");
	  		$("#depart_id").val("0");
	  		$("#position_id").val("0");
	  	});
})
