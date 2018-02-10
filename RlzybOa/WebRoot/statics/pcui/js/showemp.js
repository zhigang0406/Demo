// JavaScript Document
/*表格全选*/
$(function(){
	  $(".all").click(function(){
        var checked=$(this).is(":checked");
				if(checked){
					$(".selectTable tr td").addClass("tr_active");
					$(".selectTable tr td").children().attr("checked",checked);
				}else{
					$(".selectTable tr td").removeClass("tr_active");
					 $(".selectTable tr td").children().removeAttr("checked");
				}
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
$(function() {
	   /*给未来元素绑定单击事件，单击表格选中一行开始*/
		$(".selectTable").on("click","tbody tr",function() {
		
		    //单击从表格上取id值
			var id = $(this).children("td:eq(1)").html();
            //测试弹出值 
           // alert(id);
			//这一块可以写编程代码
			
			/*******************************/
         	// 切换样式
				$(this).children("td").toggleClass("tr_active");
				// 找到checkbox对象
				var chks = $("input[type='checkbox']",this);
				var tag = $(this).attr("tag");
				if(tag=="selected"){
					// 之前已选中，设置为未选中
					$(this).children("td").removeClass("tr_active");
					$(this).attr("tag","");
					chks.prop("checked",false);
				}else{
					// 之前未选中，设置为选中
					$(this).children("td").addClass("tr_active");
					$(this).attr("tag","selected");
					chks.prop("checked",true);
				}
        });
	   /*给未来元素绑定单击事件，单击表格选中一行结束*/
	   
		/*表格双击事件开始*/
		$(".selectTable").on("dblclick","tbody tr",function () {
			var id = $(this).children("td:eq(1)").html();
            //测试弹出值 
			//alert(id);
			
			/*初始化遮罩*/
			/*true顶部垂直居中*/
             mask(1200,1300,false,"info");
		});
		/*表格双击事件结束*/
		
		
	});
	

