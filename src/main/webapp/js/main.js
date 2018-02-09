// $('.carousel-inner').slick({
// 	adaptiveHeight: true,
// 	infinite: false,
//     slidesToShow: 1,
//     slidesToScroll: 1,
//     arrows: true,
//     autoplay: true,
//     autoplaySpeed: 2500,
// });


$(document).ready(function () {
    //initialize swiper when document ready
    var mySwiper = new Swiper ('.swiper-container', {
        // Optional parameters
        direction: 'horizontal',
        loop: true,
        grabCursor: true,
        iOSEdgeSwipeDetection : true,
        pagination: {
            el: '.swiper-pagination',
            type: 'bullets',
            clickable: true,
        },
        //    navigation: {
        //   nextEl: '.swiper-button-next',
        //   prevEl: '.swiper-button-prev',
        //   dynamicBullets: true,
        // },
        scrollbar: {
            el: '.swiper-scrollbar',
            draggable: true,
            dragSize: 'auto',
            snapOnRelease: true,

        },
    })



});
if($(window).width() >= 960){
    $(function() {
        $('#img1').hover(function() {
            $('#comphover1').fadeIn();
        }, function() {
            $('#comphover1').fadeOut();
        });
    });

    $(function() {
        $('#img2').hover(function() {
            $('#comphover2').fadeIn();
        }, function() {
            $('#comphover2').fadeOut();
        });
    });
    $(function() {
        $('#img3').hover(function() {
            $('#comphover3').fadeIn();
        }, function() {
            $('#comphover3').fadeOut();
        });
    });
    $(function() {
        $('#img4').hover(function() {
            $('#comphover4').fadeIn();
        }, function() {
            $('#comphover4').fadeOut();
        });
    });
}

// $('#img1').mouseover(function() {
//   $('#eventdate1').css("visibility","visible");
// });

// $('#img1').mouseout(function() {
//   $('#eventdate1').css("visibility","hidden");
// });
// $('#img2').mouseover(function() {
//   $('#eventdate2').css("visibility","visible");
// });

// $('#img2').mouseout(function() {
//   $('#eventdate2').css("visibility","hidden");

// $('#img3').mouseout(function() {
//   $('#eventdate3').css("visibility","hidden");
// });
// $('#img4').mouseover(function() {
//   $('#eventdate4').css("visibility","visible");
// });

// $('#img4').mouseout(function() {
//   $('#eventdate4').css("visibility","hidden");
// });
// if ($(window).width() < 960) {
//  $('#eventdate1').css("visibility","visible");
//  $('#eventdate2').css("visibility","visible");
//   $('#eventdate3').css("visibility","visible");
// $('#eventdate4').css("visibility","visible");
//   }});
// $('#img3').mouseover(function() {
//   $('#eventdate3').css("visibility","visible");
// });
