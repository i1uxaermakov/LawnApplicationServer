$(".counter").click(function(){
btn = $(this);
likeCountElement = btn.find(".likeCount");
numberlikeCount = likeCountElement.text();
like = btn.find(".like");
if(like.hasClass("far")){
	like.removeClass("far");
	like.addClass("fas");  
	number= +numberlikeCount+1;
 	likeCountElement.text(number);
 	//ajax
}
else{
	like.removeClass("fas");
	like.addClass("far"); 
	number = +numberlikeCount-1
	likeCountElement.text(number);	 
	//ajax
   }

})