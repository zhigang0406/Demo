// JavaScript Document
/* index：当前页码， pageCount：总页码， totalCount:总条数*/
function showPage(index,pageCount,totalCount){
	$("#page").empty();
	
	$("#page").append("<span><a href=' javascript:onclick=show(1)'>首页</a></span>");
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
			$("#page").append("<span><a href=' javascript:onclick=show("+(index-1)+")'>上一页</a></span>");
		}
		for(var i=iqishi;i<=iqishi+8;i++){
			if(i==index){
				$("#page").append("<span id='active'><a href=' javascript:onclick=show("+i+")' >"+i+"</a></span>");
			}else{
				$("#page").append("<span><a href=' javascript:onclick=show("+i+")'>"+i+"</a></span>");
	
			}
			
			if(i>pageCount-1){
				break;
			}
		}

		if(index!=pageCount){
			$("#page").append("<span><a href=' javascript:onchange=show("+(parseInt(index)+1)+")'>下一页</a></span>");
		}
	}
	
	$("#page").append("<span class='endPage'><a href=' javascript:onclick=show("+pageCount+")'>末页</a></span>");
	$("#page").append("<div class='pageNumber'>共"+pageCount+"页&nbsp;,&nbsp;共"+totalCount+"条记录</div>");

} 
