// JavaScript Document
$(function(){
	var conWidth=$(window).width();
	$(".content").css("width",conWidth);
    var leftHeight=$(window).height()-46;
    $(".left").css("height",leftHeight);
    $(".sonUl").css("height",leftHeight-2);
    var rightWidth=	conWidth-60;
    $(".right").css("width",rightWidth);
    $(".right").css("height",leftHeight);
	/**/
	$(".sonUl").click(function(){
		$(".sonUl").hide();
	});
	 $(".left ul li").mouseover(function(){
		 //$(this).children(".sonUl").css("display","block");
	    $(this).children(".sonUl").show();
     });
	   $(".left ul li").mouseleave(function(){
	    $(".sonUl").hide();
     });
});
function NewPage(page){
	window.open(page,"frmright");
}
$(function(){
   $(".hav li").mouseover(function(){
	  $(this).addClass("line");
	  $(this).siblings().removeClass("line"); 
   });
   $(".left ul li").mouseover(function(){
	  $(this).addClass("liHover");
	  $(this).siblings().removeClass("liHover"); 
   });
   $(".sonUl  dd").mouseover(function(){
	
	  $(this).addClass("ddDivHover");
	  $(this).siblings().removeClass("ddDivHover"); 
   });
});