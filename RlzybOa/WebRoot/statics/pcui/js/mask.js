// JavaScript Document
function mask(mwidth,mheight,isTop){
     window.parent.showAlert();

	/*isTop顶部居中*/
	if(mwidth>=1000){
		mwidth=1000;
	}
	if(mheight>=535){
		mheight=535;
	}
	
	var swidth=(mwidth)/2+30;
	
	var sheight=(mheight)/2;
	/*初始化遮罩*/
	/*确定保存弹出框的位置*/
	var mb_Height= $(document).height();
	var wWidth=$(window).width();
	var wHeight=$(window).height();
	
	
	$(".mbStyle").css("height",mb_Height);
	
	 $(".popupStyle").css("left",(wWidth/2)-swidth);
	 if(!isTop){
	     $(".popupStyle").css("top",15); 
	 }else{
		 $(".popupStyle").css("top",(wHeight/2)-sheight); 
	 }
	
	 $(".popupStyle").css({"width":mwidth,"height":mheight});
	 $(".mbStyle").fadeIn(300);
     $(".popupStyle").slideDown(200);
	
}


function closeMask(){
	 window.parent.hideAlert();
	$(".mbStyle").fadeOut(1000);
	$(".popupStyle").slideUp(500);
}
