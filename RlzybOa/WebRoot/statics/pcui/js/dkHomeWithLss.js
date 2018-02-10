var id = [];
// 员工id
var empid = 0;

var upHours = 0;
var day = 0;
var pageNum = 1;
var status;

$(function(){
	$("[name=hour]").attr("disabled","disabled").css("background-color","#EEEEEE");
	newsLoadLss(1);
});

function formatDate(nows) {
	var now = new Date(nows);
	var year = now.getFullYear();
	var month = now.getMonth() + 1;
	var date = now.getDate();
	var hour = now.getHours();
	var minute = now.getMinutes();
	var second = now.getSeconds();
	return year + "-" + month + "-" + date + " " + hour + ":" + minute + ":" + second;
}

// 加载表格数据
function newsLoadLss(index){
	// 获取到搜索框中的用户姓名，为空时搜索全部
	var name = $("[name=searchName]").val();
	/*
	 	{
			"index" : index,
			"pagesize" : $("[name=total]").val(),
			"oaRlzybEmployee.empName" : name,
			"empid" : empid
		}; 
	 */
	var data = "index=" + index
				+ "&pageSize=" + $("[name=total]").val()
				+ "&name=" + name
				+ "&empid=" + empid;
	$.ajax({
		url : "/tyyhoa/rlzyb/getInfoWithLss",
		type : "POST",
		data : data,
		async : false,
		dataType : "json",
		success : function(result){
			// 清空表格数据
			$(".tt").html("");
			$(result.list).each(function(){

				var time1 = this.timeAm;
				var timeam;
				if(time1 != undefined){
					timeam = formatDate(time1);
				}else{
					timeam = "暂无";
				}
				
				var time2 = this.timePm;
				var timepm;
				if(time2 != undefined){
					timepm = formatDate(time2);
				}else{
					timepm = "暂无";
				}
				var hours = this.hours;
				if(hours == undefined){
					hours = 0;
				}
				var str1 = "<tr>"
						 + "<td class='choose' bj='0' num='" + this.empid + "'>" + this.empid + "</td>"
						 + "<td>" + this.oaRlzybEmployee.empName + "</td>"
						 + "<td>" + this.oaRlzybEmployee.oaRlzybDepartment.departName + "</td>"
						 + "<td>" + this.oaRlzybEmployee.oaRlzybPosition.positionName + "</td>";
				if(this.oaRlzybEmpdkzdam.ztName == '正常'){
					str1 += "<td class='hour' hours='" + hours + "'>" + this.oaRlzybEmpdkzdam.ztName + "</td>";
				}else{
					str1 += "<td class='hour' hours='" + hours + "' style='color:red'>" + this.oaRlzybEmpdkzdam.ztName + "</td>";
				}
				str1 += "<td>" + timeam + "</td>";
				if(this.oaRlzybEmpdkzdpm.ztName == '正常'){
					str1 += "<td>" + this.oaRlzybEmpdkzdpm.ztName + "</td>";
				}else{
					str1 += "<td style='color:red'>" + this.oaRlzybEmpdkzdpm.ztName + "</td>";
				}
						 
				str1 += "<td>" + timepm + "</td>"
						 + "</tr>";
				$(".tt").append(str1);
			});
			pageNum = result.pageNum;
			// 显示分页条
			showPage123(result.pageNum, result.pages, result.total,"page1");
		}
	});
}

// 跳转页面
function show(num) {
	newsLoadLss(num);
}
$(function() {
	// 点击搜索时
	$("#searchButton").click(function() {
		newsLoadLss(1);
	});
	// 输入页码数点击跳转时
	$("#toPageWithLss").click(function() {
		var $num = $("[name=pageNo]").val();
		if (isNaN($num)) {
			$("[name=pageNo]").val("");
			alert("请输入合法数字");
		} else {
			newsLoadLss($num);
		}
	});
	// 每页显示条目数改变时
	$("[name=total]").change(function() {
		newsLoadLss(1);
	});
});


//表格中行的点击状态bj=0 未点击		bj=1 点击
$(document).on("click", ".tt tr", function() {
	var def = $(this).find(".choose").attr("bj");
	if (def == "1") {
		$(this).find(".choose").attr("bj", "0");
		forId();
	} else {
		$(this).find(".choose").attr("bj", "1");
		forId();
	}
});
//点击全选框时
$(document).on("click","#allWithLss",function(){
	var isStatus = $(this).attr("checked");
	if(isStatus == "checked"){
		$("#tableData tbody tr").find(".choose").attr("bj", "1");
	}else{
		$("#tableData tbody tr").find(".choose").attr("bj", "0");
	}
	forId();
});
//给id赋值的方法
function forId(){
	// 获取选中的框的数量
	idCount = $("[bj=1]");
	id = [];
	for(var a = 0;a < idCount.length;a++){
		// 向数组中添加
		id.push(idCount.eq(a).attr("num"));
	}
}

// *********************************下面是修改的方法********************************
$(function(){
	// 弹出框弹出时
	$(".alertout").click(function(){
		if(id.length == 0){
			showWebAlert("未选择用户");
			return;
		}else if(id.length > 1){
			showWebAlert("不能同时选中多个用户");
			return;
		}else{
			status = $(this).attr("bj");
			resetWithLss();
			mask(710, 400, false, "alertWithLss", false);
		}
	});
	// 选择上午，下午，全天时
	$("[name=day]").click(function(){
		var valueDay = $(this).attr("hehe");
		if(valueDay == 8){
			// 全天
			$("[name=hour]").attr("disabled","disabled").css("background-color","#EEEEEE");
			day = $(this).attr("hehe");
		}else{
			
			$("[name=hour]").removeAttr("disabled").css("background-color","#ffffff");
			day = $(this).attr("hehe");
		}
	});
	// 点击保存时
	$(".alert-btn1").click(function(){
		updateWithLss();
		newsLoadLss(pageNum);
		closeMask("alertWithLss");
	});
	// 点击重置时
	$(".resetButton").click(function(){
		resetWithLss();
	});
});

function updateWithLss(){
	upHours = parseInt($("[bj=1]").parent("tr").find(".hour").attr("hours"));
	// 获取修改的时间
	var hour;
	var data = "empid=" + id[0];
	if(day == 8){
		hour = 8;
		data += "&statusAm=" + status + "&statusPm=" + status;
	}else{
		var tih = parseInt($("[name=hour]").val());
		hour = tih + upHours;
		if(day == 3){
			data += "&statusAm=" + status;
		}else{
			data += "&statusPm=" + status;
		}
	}
	
	data += "&hours=" + hour
			+ "&comment=" + $("[name=comment]").val();
	$.ajax({
		url : "/tyyhoa/rlzyb/updateInfoWithLss",
		type : "POST",
		data : data,
		dataType : "text",
		success : function(result){
			if(result == "1"){
				showWebAlert("修改成功");
				newsLoadLss(pageNum);
			}else{
				showWebAlert("修改失败");
			}
		}
	});
}

// 重置的方法
function resetWithLss(){
	$("[name=day]").val("5");
	$("[name=hour]").val("0");
	$("[name=comment]").val("");
}

// ---------------------------分页条--------------------------
/* index：当前页码， pageCount：总页码， totalCount:总条数 , pageName:要给那个page框的数字序号*/
function showPage123(index,pageCount,totalCount,pageName){
	$("#"+pageName+" .page").empty();
	
	$("#"+pageName+" .page").append("<span><a href=' javascript:onclick=show(1)'>首页</a></span>");
	var iqishi=1;
	if(pageCount>=8){
		if((index+4)>=pageCount){
		iqishi=pageCount-8;
	}else if(index>=5){
		iqishi=index-4;
	}
	}

	if(totalCount!=0){
		if(index!=1){
			$("#"+pageName+" .page").append("<span><a href=' javascript:onclick=show("+(index-1)+")'>上一页</a></span>");
		}
		for(var i=iqishi;i<=iqishi+8;i++){
			if(i==index){
				$("#"+pageName+" .page").append("<span id='active'><a href=' javascript:onclick=show("+i+")' >"+i+"</a></span>");
			}else{
				$("#"+pageName+" .page").append("<span><a href=' javascript:onclick=show("+i+")'>"+i+"</a></span>");
	
			}
			
			if(i>pageCount-1){
				break;
			}
		}

		if(index!=pageCount){
			$("#"+pageName+" .page").append("<span><a href=' javascript:onchange=show("+(index+1)+")'>下一页</a></span>");
		}
	}
	
	$("#"+pageName+" .page").append("<span class='endPage'><a href=' javascript:onclick=show("+pageCount+")'>末页</a></span>");
	$("#"+pageName+" .page").append("<div class='pageNumber'>共"+pageCount+"页&nbsp;,&nbsp;共"+totalCount+"条记录</div>");

}