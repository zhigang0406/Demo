// JavaScript Document

function showWebAlert(title){
   /*  window.parent.showWebAlert(title);*/

}



function deleteShowAlert(title,info,ok,cancel){
   window.parent.deleteShowAlert(title,info,ok,cancel);
    
}
/* mwidth    蒙板宽度
 * mheight   蒙板高度
 * isTop     是否顶部垂直居中
 * idName    弹出层DIV的名称
 * isReset   DIV中如果有表单元素，是否重置  (可缺省，如果缺省则为false)
 * 修改日期：2017-12-20 13:05
 * */
function mask(mwidth,mheight,isTop,idName,isReset){
	/*如果为真，则重置表单元素，否则保留*/
	if(isReset){ 
		$("#"+idName).children("form")[0].reset();
	}
	
	
    
     /*window.parent.showAlert();*/

	/*isTop为true为顶部居中*/
	if(mwidth>=1200){
		mwidth=1200;
	}
	if(mheight>=560){
		mheight=560;
	}
	
	var swidth=(mwidth)/2+30;
	
	var sheight=(mheight)/2;
	/*初始化遮罩*/
	/*确定保存弹出框的位置*/
	var mb_Height= $(document).height();
	var wWidth=$(window).width();
	var wHeight=$(window).height();
	
	
	$(".mbStyle").css("height",mb_Height);
	
	 $("#"+idName).css("left",(wWidth/2)-swidth);
	 if(!isTop){
	      $("#"+idName).css("top",10); 
	 }else{
		 $("#"+idName).css("top",(wHeight/2)-sheight); 
	 }
	
	  $("#"+idName).css({"width":mwidth,"height":mheight});
	  $("#"+idName).children("h1").css("width",mwidth);
	  $(".mbStyle").fadeIn(300);
      $("#"+idName).slideDown(200);
    
	
}


function closeMask(idName){
	/* window.parent.hideAlert();*/
	 $(".mbStyle").fadeOut(300);
	 $(".popupStyle").slideUp(200);
	
	
}




