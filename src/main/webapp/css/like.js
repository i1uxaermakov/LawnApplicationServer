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


$(".filefav").click(function(){
btn = $(this);
heart = btn.find(".fa-star");
if(heart.hasClass("far")){
	heart.removeClass("far");
	heart.addClass("fas");   
 	//ajax
}
else{
	heart.removeClass("fas");
	heart.addClass("far");   
	//ajax
   }

})