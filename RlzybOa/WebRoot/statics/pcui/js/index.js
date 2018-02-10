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
	
	$(".iframe").css("width",rightWidth);
	$(".iframe").css("height",leftHeight);

	$(".sonUl").click(function(){
		$(".sonUl").hide();
	});
	$(".left ul li").mouseover(function(){
		 $(this).children(".sonUl").show();
	
    });
	$(".left ul li").mouseleave(function(){
	    $(".sonUl").hide();
    });
});

$(function(){
   $(".hav li").click(function(){
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
	$("#admin").mouseover(function(){
		if(!this.contains(event.fromElement)){
		  $(".person").slideDown(300);
		}
	});
	$("#admin").mouseout(function(){
		if(!this.contains(event.toElement)){
			$(".person").slideUp(300);
		}
	});
	$(".person").click(function(){
		$(this).slideUp(300);
	});
});
$(function(){
	  $(".hav li").click(function(){
		 var num=$(this).index()+1;
		 if(num!=null&&num>0){
			 $(".hav_"+num).siblings().css("display","none");
			 $(".hav_"+num).css("display","block");
		 }	  
	  });
});

/*弹出框开始*/
   function showAlert(){
	 
	   $(".iframe").css("z-index",300);
	   $(".left").css("z-index",260);
	   $(".zzDiv").css("z-index",270);
	   
	   $(".zzDiv").show();
	   var cw=$(window).width();
	   var lh=$(window).height();

	  $(".zzDiv").css("width",cw);
	  $(".zzDiv").css("height",lh+46);
	
	   
   }
   function hideAlert(){
	
	   $(".iframe").css("z-index",240);
	   $(".left").css("z-index",260);
	   $(".zzDiv").css("z-index",0);
	 
	 $(".zzDiv").css("display","none");
	   
   }
/*弹出框结束*/

/*提醒框开始*/
function showRemind(remindTime,remindAuthor,title){
	  $(".reText").html("");
	  $(".reText").append(remindTime+"分 : "+remindAuthor+title+"，请及时查收");
	  $(".remind").fadeIn(1500);
	
	  setTimeout("hideRemind()",5000);
   
}
function hideRemind(){
    $(".remind").fadeOut();
   
}
/*提醒框结束*/



/*确定保存弹出框的位置*/
$(function(){
    var saveAlertWidth=$(window).width();
    var saveAlertHeight=$(window).height();
	$(".saveAlert").css("left",saveAlertWidth/2-135);
	$(".saveAlert").css("top",saveAlertHeight/2-40);
	
	$(".deleteAlert").css("left",saveAlertWidth/2-130);
	$(".deleteAlert").css("top",saveAlertHeight/2-40);
	

});
/*保存*/
function showWebAlert(title){
	  $(".saveAlert").html('');
	  $(".saveAlert").fadeIn(1500);
	  $(".saveAlert").append(title);
	  setTimeout("hideWebAlert()",1000);
	 
   
}

function hideWebAlert(){
	 $(".saveAlert").fadeOut(1000);
}
/*保存结束*/

/*删除开始*/
var bool;
function deleteShowAlert(title,info,ok,cancel){
	  $(".zzDiv").css("z-index",280);
	   $(".zzDiv").show();
	   var cw=$(window).width();
	   var lh=$(window).height();
	   $(".zzDiv").css("width",cw);
	   $(".zzDiv").css("height",lh+46);
	   $(".deleteAlert").fadeIn(1000);
	   
	   $(".d_title").html("");
		$(".d_msg").html("");
		$(".d_bt_ok").html("");
		$(".d_bt_cancel").html("");
		
		$(".d_title").append(title);
		$(".d_msg").append(info);
		$(".d_bt_ok").append(ok);
		$(".d_bt_cancel").append(cancel);
		
		
	    
	   
}
$(function(){
	$(".d_bt_ok").click(function(){
		 $(".deleteAlert").hide();
		 $(".zzDiv").css("z-index",0);
	     $(".zzDiv").css("display","none");
		 bool=true;
		 subForm(bool);
		
	});
	
	$(".d_bt_cancel").click(function(){
		 $(".deleteAlert").hide();
		 $(".zzDiv").css("z-index",0);
		 $(".zzDiv").css("display","none");
		 bool=false;
	     subForm(bool);
	    
	});
});

/*删除结束*/
