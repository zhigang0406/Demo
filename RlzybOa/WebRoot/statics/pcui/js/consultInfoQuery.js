
/*绑定表格数据*/

$(function(){
	show(1);
	/*newsLoad("tableData1");*/

	/*高级搜索开始*/
	$("#searchButton").click(function(){
	
		closeMask("search");
	});
	
	/*高级搜索结束*/
	
	/*
	 * 标签切换
	 */
	$(".tabs span").click(function(){
			$(this).addClass("spanHover");
			$(this).siblings().removeClass("spanHover");
			$(this).siblings().addClass("spanOut");
			/**/
			var $text=$(this).text();
			$(".container h1:eq(0)").text($text);
			$(".divTable").hide();
			$(".divTable").eq($(this).index()).show();
			
			/*
			 * 加载数据
			 */
			var spanNum = $(this).index();
			newsLoad("tableData"+(spanNum+1));
			
			/*
			 * 切换按钮隐藏状态
			 */
			
			switch($text){
				case "未分量":
					$(".queryFloatRight input,.serach .selectStyle").hide();
					$(".fenfaButton,.deleteButton").show();
				break;
				case "未回访":
					$(".queryFloatRight input,.serach .selectStyle").hide();
					$(".huishouButton,.serach .selectStyle").show();
				break;
				case "无效量":
					$(".queryFloatRight input,.serach .selectStyle").hide();
					$(".laoliangButton,.serach .selectStyle,.genjinjiluButton").show();
				break;
				case "历史量":
					$(".queryFloatRight input,.serach .selectStyle").hide();
					$(".laoliangButton,.serach .selectStyle,.genjinjiluButton").show();
				break;
				default:
					$(".queryFloatRight input,.serach .selectStyle").hide();
					$(".huishouButton,.serach .selectStyle,.genjinjiluButton").show();
				
				
			}
	});
	
	/*
	 * 删除
	 */
	$(".deleteButton").click(function(){
			      deleteShowAlert('删除提示','确定要删除吗？','确定','取消');  
				 
	});
	$(".markInvalidButton").click(function(){
			      deleteShowAlert('标记无效量提示','确定要标记吗？','确定','取消');  
				 
	});
});			
			
/*点击确定或者取消*/
	   function subForm(result){
			if(result){
				 showWebAlert('删除成功！');   
			}else{
				  alert('你点击了取消');
			}   
       }
	
	   /*结束*/
			
			
/*function newsLoad(idName) {
	  var str="";
		$.ajax({
			url: "news.txt",
			type: "get",
			dataType : "text",
			async:true,
			success : function(data) {
				data=$.parseJSON(data);
			    $("#"+idName).append(str);
			    $("#"+idName+" tbody").text("");
			    
				$(data.newsList).each(function(index) {
						   str1= "<tr>" 
										+ "<td><input type='checkbox' name='CheckBox' value='pro1'/></td>"
										+ "<td>" + this.bh + "</td>"
										+ "<td>" + this.xm + "</td>"
										+ "<td>" + this.bm + "</td>"
										+ "<td>" + this.nl + "</td>" 
										+ "<td>"+ this.xb + "</td>"
										+ "<td>"+ this.rzsj + "</td>"
										+ "<td>"+ this.lxfs + "</td>"
										+ "<td>"+ this.yx + "</td>"
										+ "<td>"+ this.zw + "</td>"
										+ "<td>"+ this.lxr + "</td>"
								+ "</tr>";
						$("#"+idName+" tbody").append(str1);
						
				})
				
				showPage(1,10,46,$("#"+idName).next().attr("id"));
			   },
			error : function() {
				alert("出现异常！");
			}

		});
	}*/

/* index：当前页码， pageCount：总页码， totalCount:总条数 , pageName:要给那个page框的数字序号*/
function showPage(index,pageCount,totalCount,pageName){
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
/*function show1(index){
	$.post(
		"limit",
		"index="+index,
		function(result){
			$(".tt").html("");
			//可以拿到Page类
			var p = result.extend.p;
			//可以拿到集合
			var list = p.list;
			var hehe = 0;
			for ( var i = 0; i < list.length; i++) {
				//只查看市场部的信息
				if(list[i].customerstatusfl == 4){
					var $tr=$("<tr></tr>");
					$tr.append("<td><input type='checkbox' class='aaa"+hehe+"' /></td>");
					$tr.append("<td class='ttdd'>"+list[i].id+"</td>");
					$tr.append("<td>"+list[i].customername+"</td>");
					$tr.append("<td>"+list[i].age+"</td>");
					if(list[i].sex == 0){
						$tr.append("<td>女</td>");
					}else if(list[i].sex == 1){
						$tr.append("<td>男</td>");
					}else{
						$tr.append("<td>未知</td>");
					}
					$tr.append("<td>"+list[i].telphone1+"</td>");
					if(list[i].oaScbEducation.education == null || list[i].oaScbEducation.education == 0){
						$tr.append("<td>学历未知</td>");
					}else{
						$tr.append("<td>"+list[i].oaScbEducation.education+"</td>");
					}
					if(list[i].customerstatus == 0 || list[i].customerstatus == null){
						$tr.append("<td>未知</td>");
					} else if(list[i].customerstatus == 1){
						$tr.append("<td>在读</td>");
					}else if(list[i].customerstatus == 2){
						$tr.append("<td>待业</td>");
					}else if(list[i].customerstatus == 3){
						$tr.append("<td>应届</td>");
					}else if(list[i].customerstatus == 4){
						$tr.append("<td>在职</td>");
					}
					if(list[i].customerstatusfl == 4){
						$tr.append("<td>市场</td>");
					}
					$(".tt").append($tr);
				}
				hehe = hehe + 1 ;
			}
			 index：当前页码， pageCount：总页码， totalCount:总条数 , pageName:要给那个page框的数字序号
			showPage(1,10,46,20);
		}
	);*/
