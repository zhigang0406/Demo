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
//JavaScript Document
/* index：当前页码， pageCount：总页码， totalCount:总条数*/
function showPage1(index,pageCount,totalCount){
	$("#page1").empty();
	
	$("#page1").append("<span><a href=' javascript:onclick=show1(1)'>首页</a></span>");
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
			$("#page1").append("<span><a href=' javascript:onclick=show1("+(index-1)+")'>上一页</a></span>");
		}
		for(var i=iqishi;i<=iqishi+8;i++){
			if(i==index){
				$("#page1").append("<span id='active'><a href=' javascript:onclick=show1("+i+")' >"+i+"</a></span>");
			}else{
				$("#page1").append("<span><a href=' javascript:onclick=show1("+i+")'>"+i+"</a></span>");
	
			}
			
			if(i>pageCount-1){
				break;
			}
		}

		if(index!=pageCount){
			$("#page1").append("<span><a href=' javascript:onchange=show1("+(index+1)+")'>下一页</a></span>");
		}
	}
	
	$("#page1").append("<span class='endPage'><a href=' javascript:onclick=show1("+pageCount+")'>末页</a></span>");
	$("#page1").append("<div class='pageNumber'>共"+pageCount+"页&nbsp;,&nbsp;共"+totalCount+"条记录</div>");

} 
//JavaScript Document
/* index：当前页码， pageCount：总页码， totalCount:总条数*/
function showPage2(index,pageCount,totalCount){
	$("#page2").empty();
	
	$("#page2").append("<span><a href=' javascript:onclick=show2(1)'>首页</a></span>");
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
			$("#page2").append("<span><a href=' javascript:onclick=show2("+(index-1)+")'>上一页</a></span>");
		}
		for(var i=iqishi;i<=iqishi+8;i++){
			if(i==index){
				$("#page2").append("<span id='active'><a href=' javascript:onclick=show2("+i+")' >"+i+"</a></span>");
			}else{
				$("#page2").append("<span><a href=' javascript:onclick=show2("+i+")'>"+i+"</a></span>");
	
			}
			
			if(i>pageCount-1){
				break;
			}
		}

		if(index!=pageCount){
			$("#page2").append("<span><a href=' javascript:onchange=show2("+(index+1)+")'>下一页</a></span>");
		}
	}
	
	$("#page2").append("<span class='endPage'><a href=' javascript:onclick=show2("+pageCount+")'>末页</a></span>");
	$("#page2").append("<div class='pageNumber'>共"+pageCount+"页&nbsp;,&nbsp;共"+totalCount+"条记录</div>");

} 
//JavaScript Document
/* index：当前页码， pageCount：总页码， totalCount:总条数*/
function showPage3(index,pageCount,totalCount){
	$("#page3").empty();
	
	$("#page3").append("<span><a href=' javascript:onclick=show3(1)'>首页</a></span>");
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
			$("#page3").append("<span><a href=' javascript:onclick=show3("+(index-1)+")'>上一页</a></span>");
		}
		for(var i=iqishi;i<=iqishi+8;i++){
			if(i==index){
				$("#page3").append("<span id='active'><a href=' javascript:onclick=show3("+i+")' >"+i+"</a></span>");
			}else{
				$("#page3").append("<span><a href=' javascript:onclick=show3("+i+")'>"+i+"</a></span>");
	
			}
			
			if(i>pageCount-1){
				break;
			}
		}

		if(index!=pageCount){
			$("#page3").append("<span><a href=' javascript:onchange=show3("+(index+1)+")'>下一页</a></span>");
		}
	}
	
	$("#page3").append("<span class='endPage'><a href=' javascript:onclick=show3("+pageCount+")'>末页</a></span>");
	$("#page3").append("<div class='pageNumber'>共"+pageCount+"页&nbsp;,&nbsp;共"+totalCount+"条记录</div>");

} 
//JavaScript Document
/* index：当前页码， pageCount：总页码， totalCount:总条数*/
function showPage1(index,pageCount,totalCount){
	$("#page1").empty();
	
	$("#page1").append("<span><a href=' javascript:onclick=show1(1)'>首页</a></span>");
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
			$("#page1").append("<span><a href=' javascript:onclick=show1("+(index-1)+")'>上一页</a></span>");
		}
		for(var i=iqishi;i<=iqishi+8;i++){
			if(i==index){
				$("#page1").append("<span id='active'><a href=' javascript:onclick=show1("+i+")' >"+i+"</a></span>");
			}else{
				$("#page1").append("<span><a href=' javascript:onclick=show1("+i+")'>"+i+"</a></span>");
	
			}
			
			if(i>pageCount-1){
				break;
			}
		}

		if(index!=pageCount){
			$("#page1").append("<span><a href=' javascript:onchange=show1("+(parseInt(index)+1)+")'>下一页</a></span>");
		}
	}
	
	$("#page1").append("<span class='endPage'><a href=' javascript:onclick=show1("+pageCount+")'>末页</a></span>");
	$("#page1").append("<div class='pageNumber'>共"+pageCount+"页&nbsp;,&nbsp;共"+totalCount+"条记录</div>");

} 
//JavaScript Document
/* index：当前页码， pageCount：总页码， totalCount:总条数*/
function showPage2(index,pageCount,totalCount){
	$("#page2").empty();
	
	$("#page2").append("<span><a href=' javascript:onclick=show2(1)'>首页</a></span>");
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
			$("#page2").append("<span><a href=' javascript:onclick=show2("+(index-1)+")'>上一页</a></span>");
		}
		for(var i=iqishi;i<=iqishi+8;i++){
			if(i==index){
				$("#page2").append("<span id='active'><a href=' javascript:onclick=show2("+i+")' >"+i+"</a></span>");
			}else{
				$("#page2").append("<span><a href=' javascript:onclick=show2("+i+")'>"+i+"</a></span>");
	
			}
			
			if(i>pageCount-1){
				break;
			}
		}

		if(index!=pageCount){
			$("#page2").append("<span><a href=' javascript:onchange=show2("+(parseInt(index)+1)+")'>下一页</a></span>");
		}
	}
	
	$("#page2").append("<span class='endPage'><a href=' javascript:onclick=show2("+pageCount+")'>末页</a></span>");
	$("#page2").append("<div class='pageNumber'>共"+pageCount+"页&nbsp;,&nbsp;共"+totalCount+"条记录</div>");

} 
//JavaScript Document
/* index：当前页码， pageCount：总页码， totalCount:总条数*/
function showPage3(index,pageCount,totalCount){
	$("#page3").empty();
	
	$("#page3").append("<span><a href=' javascript:onclick=show3(1)'>首页</a></span>");
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
			$("#page3").append("<span><a href=' javascript:onclick=show3("+(index-1)+")'>上一页</a></span>");
		}
		for(var i=iqishi;i<=iqishi+8;i++){
			if(i==index){
				$("#page3").append("<span id='active'><a href=' javascript:onclick=show3("+i+")' >"+i+"</a></span>");
			}else{
				$("#page3").append("<span><a href=' javascript:onclick=show3("+i+")'>"+i+"</a></span>");
	
			}
			
			if(i>pageCount-1){
				break;
			}
		}

		if(index!=pageCount){
			$("#page3").append("<span><a href=' javascript:onchange=show3("+(parseInt(index)+1)+")'>下一页</a></span>");
		}
	}
	
	$("#page3").append("<span class='endPage'><a href=' javascript:onclick=show3("+pageCount+")'>末页</a></span>");
	$("#page3").append("<div class='pageNumber'>共"+pageCount+"页&nbsp;,&nbsp;共"+totalCount+"条记录</div>");

} 
