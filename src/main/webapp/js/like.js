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

});

function filefavInitialize() {
    $(".filefav").click(function(){
        btn = $(this);
        heart = btn.find(".fa-star");

        if(heart.hasClass("far")){
            heart.removeClass("far");
            heart.addClass("fas");

            var formData = new FormData();
            formData.set("purpose", "add");
            formData.set("fid",btn.attr("fid"));

            $.ajax({
                url:  '/files/fav',
                type: 'post',
                processData: false,
                contentType: false,
                enctype: 'multipart/form-data',
                data: formData,
                cache: false,
                timeout: 600000,
                success: function (data,textStatus,jqXHR) {
                    alert(data);
                    console.log(data);
                    console.log(data.innerHTML);
                    console.log(data.html());
                },
                error: function (data,textStatus,jqXHR) {
                    if(jqXHR.status===401) {
                        window.location.href = "/signin";
                    }
                    else {
                        alert(data);
                        console.log(data);
                        console.log(data.innerHTML);
                        console.log(data.html());
                    }
                }
            })
        }
        else{
            heart.removeClass("fas");
            heart.addClass("far");

            var formData = new FormData();
            formData.set("purpose", "del");
            formData.set("fid",btn.attr("fid"));

            $.ajax({
                url:  '/files/fav',
                type: 'post',
                processData: false,
                contentType: false,
                enctype: 'multipart/form-data',
                data: formData,
                cache: false,
                timeout: 600000,
                success: function (data,textStatus,jqXHR) {
                    alert(data);
                },
                error: function (data,textStatus,jqXHR) {
                    if(jqXHR.status===401) {
                        window.location.href = "/signin";
                    }
                    else {
                        alert(data);

                        console.log(data);
                        console.log(data.innerHTML);
                        console.log(data.html());
                    }
                }
            })
        }

    });
}

filefavInitialize();
