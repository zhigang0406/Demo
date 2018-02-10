
	/*表格全选*/
	$(function() {
		var index = 1;
		newsLoad(index);
		$("#select").click(function() {
			mask(650,200, false, "xxx", false);
		});

		$("#searchButton").click(function() {
			closeMask("xxx");
		});
		$(".insertButton").click(function() {
			mask(800, 300, false, "zzzz", true);
		});
		$(".saveButton").click(function() {
			closeMask("zzzz");
			showWebAlert("新增成功!");
		});
		
		//页面搜索
		$("#search").click(function() {
			newsLoad(1);
			$(".d_bt_ok").attr("s","");
		});
		//高级搜索
		$("#searchButton").click(function() {
			newsLoad(1);
			$(".d_bt_ok").attr("s","");
			$("#interview_person").val("");
			$("#interview_date").val("");
		});
		$("#select").click(function() {
			$("#emp_name").val("");
		})
		$("[name=total]").change(function(){
			newsLoad(index);
		})
		//清空搜索条件
		$("#clen").click(function(){
			$("#emp_name").val("");
			$("#selectStyle").val("0");
			newsLoad(index);
			$(".d_bt_ok").attr("s","");
		})
		$(".deleteButton").click(function(){
			if($(".d_bt_ok").attr("s")==null||$(".d_bt_ok").attr("s")==""){
				 showWebAlert('请先选择员工');   
			}else{
				deleteShowAlert("删除提示","确定要删除吗？","确定","取消");
			}
			$(".d_bt_ok").click(function() {
				var interview_id = $(this).attr("s");
		 		$.ajax({
					url : "interview_delete",
					data : {
						interview_id : interview_id
					},
					success : function(data) {
						var index = $("#pageIndex").val();
						if (data.length % 10 == 0 && data.length != 0) {
							newsLoad(index - 1);
						} else {
							newsLoad(index);
						}
						$(".d_bt_ok").attr("s","");
					}
				})
			});
		})
	});
	function newsLoad(index) {
		//获得搜索条件
		var interview_person = $("#interview_person").val();
		var depart_id = $("#selectStyle").val();
		var emp_name = $("#emp_name").val();
		var interview_date = $("#interview_date").val();
		var pageSize = $("[name=total]").val();
		$(".selectTable tbody").html("");
		var $ttr = $("<tr></tr>");
		   var $tdd = $("<td colspan='9'></td>");
		   var $img = $("<img src='/RlzybOa/statics/pcui/images/loading2.gif' />");
		   $tdd.append($img);
		   $ttr.append($tdd);
		$(".selectTable tbody").html($ttr);
		$.ajax({
			type : "POST",
			url : "interview_search",
			dataType : "json",
			data : {
				interview_person : interview_person,
				emp_name : emp_name,
				interview_date : interview_date,
				depart_id : depart_id,
				pageIndex : index,
				pageSize:pageSize
			},
			success : showList,
			error : function() {
				alert("数据不存在");
			}
		});
	}

	function showList(data) {
		var datas = eval("(" + data + ")");
		var pageCount = datas.totalPageCount;
		var index = datas.currentPageNo;
		var count = datas.totalCount;
		var person = datas.person;
		var empName = datas.empName;
		$(".tabTitle span").text(count);
		showStuList(person, empName);
		if(person.length!=0){
			$(".pageStyle").css("display","block");
			showPage(index,pageCount,count)
		}else{
			$(".pageStyle").css("display","none");
		}
	}

	function dateFmt(time) {
		var t = new Date(time);
		var year = t.getFullYear(); //年
		var month = t.getMonth() + 1; //月
		var day = t.getDate(); //日
		if (month < 10) {
			month = "0" + month;
		}
		if (day < 10) {
			day = "0" + day;
		}
		var dateTimeStr = year + "-" + month + "-" + day;
		return dateTimeStr;
	}
	function showStuList(person, empName) {
		var str = "";
		$(".selectTable tbody").html("");
		$(".selectTable thead .trs").html("");
		if(person.length==0){
			$(".selectTable thead .trs").append("<td colspan='9' style='color:red'>没有可供查看的数据</td>");
		}
			for (var i = 0; i < person.length; i++) {
				var interview_id = person[i].interview_id;
				for (var j = 0; j < empName.length; j++) {
					if (interview_id == empName[j].interview_id) {
						str += "<tr s=" + empName[j].interview_id + ">";
						var id = j + 1;
						if (id < 10) {
							id = "000" + id;
						} else if (id < 100) {
							id = "00" + id;
						} else if (id < 1000) {
							id = "0" + id;
						} else {
							id = "" + id;
						}
						str += "<td>" + id + "</td>";
						str += "<td>" + empName[j].emp_name + "</td>";
						str += "<td>" + empName[j].depart_name + "</td>";
						str += "<td>" + empName[j].position_name + "</td>";
						str += "<td>" + person[i].emp_name + "</td>";
						str += "<td>" + person[i].depart_name + "</td>";
						str += "<td>" + person[i].position_name + "</td>";
						str+="<td>"+(new Date(person[i].interview_date).getFullYear()+"-")+
							(new Date(person[i].interview_date).getMonth()+1+"-")+
							(new Date(person[i].interview_date).getDate())+
							"</td>";
						str += "<td>" + person[i].interview_recorder + "</td>";
						str += "<td style='display:none;'>" + person[i].interview_reason + "</td>"; //访谈原因
						str += "<td style='display:none;'>" + person[i].interview_content + "</td>"; //访谈内容
						str += "<td style='display:none;'>";
						var date1 = new Date(person[i].create_time);
						var date3 = new Date();
						str += "</td>";
						str += "</tr>";
						}
					}
				}
		$(".selectTable tbody").html(str);
		/* 单击选中id删除 */
		$(".selectTable").on("click", "tbody tr", function() {
			var id = $(this).attr("s");
			$(".d_bt_ok").attr("s", id);
		});
		/* 双击事件  */
		$(".selectTable").on("dblclick", "tbody tr", function() {
			var jemp_name = $(this).children("td:eq(1)").html();
			var jdepart_name = $(this).children("td:eq(2)").html();
			var jposition_name = $(this).children("td:eq(3)").html();
			var iemp_name = $(this).children("td:eq(4)").html();
			var idepart_name = $(this).children("td:eq(5)").html();
			var iposition_name = $(this).children("td:eq(6)").html();
			var interview_date = $(this).children("td:eq(7)").html();
			var interview_recorder = $(this).children("td:eq(8)").html();
			var interview_reason = $(this).children("td:eq(9)").html(); //原因
			var interview_content = $(this).children("td:eq(10)").html(); //内容
			//赋值 
			$(".tdj td:nth-child(2)").text(jemp_name);
			$(".tdj td:nth-child(4)").text(jdepart_name);
			$(".tdj td:nth-child(6)").text(jposition_name);
			$(".tdi td:nth-child(2)").text(iemp_name);
			$(".tdi td:nth-child(4)").text(idepart_name);
			$(".tdi td:nth-child(6)").text(iposition_name);
			$(".tdd td:nth-child(2)").text(interview_date);
			$(".tdd td:nth-child(4)").text(interview_reason);
			$(".tdc td:nth-child(2)").text(interview_content);
			$(".tdr td:nth-child(2)").text(interview_recorder);
			/*初始化遮罩*/
			/*true顶部垂直居中*/
			mask(1000,800, false, "yyy");
		});
		$(".bottomStyle2").click(function() {
			$(".deleteStyle").css("display", "none");
		});
		$(".link").click(function() {
			var interview_id = $(this).attr("interview_id");
			location.href = "interview_show?interview_id=" + interview_id;

		});
		$(".imgSearch").click(function(){
			var index = $("[name=pageNo]").val();
			if(isNaN(index)){
				alert("请输入正确的数字");
			}else{
				newsLoad(index);
			}
			$("[name=pageNo]").val("");
		})
	}
