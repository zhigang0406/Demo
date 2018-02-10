// JavaScript Document

$(function() {
	
	   /*给未来元素绑定单击事件，单击表格选中一行开始*/
		$(".selectTable").on("click","tr",function() {
		
		    //单击从表格上取id值
			var id = $(this).children("td:eq(0)").html();
            //测试弹出值
			//alert(id);
			//这一块可以写编程代码
			/////////////////////////////////////
			
			
			
			
			/*******************************/
			//$(this).css({"background":"#2fa4e7","color":"#fff"});
		   // $(this).siblings().css({"background":"#fff","color":"#333"});
		   
			$(this).siblings().children("td").removeClass("tr_active");
			$(this).children("td").addClass("tr_active");
        });
	   /*给未来元素绑定单击事件，单击表格选中一行结束*/
	   
		/*表格双击事件开始*/
		$(".selectTable").on("dblclick","tr",function () {
			var id = $(this).children("td:eq(0)").html();
            //测试弹出值 
			//alert(id);
			
			/*初始化遮罩*/
			/*true顶部垂直居中*/
             mask(1000,3000,false,"yyy");
		});
		/*表格双击事件结束*/
		
		
	});
	

