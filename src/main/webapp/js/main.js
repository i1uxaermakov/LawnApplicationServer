// $('.carousel-inner').slick({
// 	adaptiveHeight: true,
// 	infinite: false,
//     slidesToShow: 1,
//     slidesToScroll: 1,
//     arrows: true,
//     autoplay: true,
//     autoplaySpeed: 2500,
// });
var initPhotoSwipeFromDOM = function(gallerySelector) {

    // parse slide data (url, title, size ...) from DOM elements 
    // (children of gallerySelector)
    var parseThumbnailElements = function(el) {
        var thumbElements = el.childNodes,
            numNodes = thumbElements.length,
            items = [],
            figureEl,
            linkEl,
            size,
            item;

        for(var i = 0; i < numNodes; i++) {

            figureEl = thumbElements[i]; // <figure> element

            // include only element nodes 
            if(figureEl.nodeType !== 1) {
                continue;
            }

            linkEl = figureEl.children[0]; // <a> element

            size = linkEl.getAttribute('data-size').split('x');

            // create slide object
            item = {
                src: linkEl.getAttribute('href'),
                w: parseInt(size[0], 10),
                h: parseInt(size[1], 10)
            };



            if(figureEl.children.length > 1) {
                // <figcaption> content
                item.title = figureEl.children[1].innerHTML;
            }

            if(linkEl.children.length > 0) {
                // <img> thumbnail element, retrieving thumbnail url
                item.msrc = linkEl.children[0].getAttribute('src');
            }

            item.el = figureEl; // save link to element for getThumbBoundsFn
            items.push(item);
        }

        return items;
    };

    // find nearest parent element
    var closest = function closest(el, fn) {
        return el && ( fn(el) ? el : closest(el.parentNode, fn) );
    };

    // triggers when user clicks on thumbnail
    var onThumbnailsClick = function(e) {
        e = e || window.event;
        e.preventDefault ? e.preventDefault() : e.returnValue = false;

        var eTarget = e.target || e.srcElement;

        // find root element of slide
        var clickedListItem = closest(eTarget, function(el) {
            return (el.tagName && el.tagName.toUpperCase() === 'FIGURE');
        });

        if(!clickedListItem) {
            return;
        }

        // find index of clicked item by looping through all child nodes
        // alternatively, you may define index via data- attribute
        var clickedGallery = clickedListItem.parentNode,
            childNodes = clickedListItem.parentNode.childNodes,
            numChildNodes = childNodes.length,
            nodeIndex = 0,
            index;

        for (var i = 0; i < numChildNodes; i++) {
            if(childNodes[i].nodeType !== 1) {
                continue;
            }

            if(childNodes[i] === clickedListItem) {
                index = nodeIndex;
                break;
            }
            nodeIndex++;
        }



        if(index >= 0) {
            // open PhotoSwipe if valid index found
            openPhotoSwipe( index, clickedGallery );
        }
        return false;
    };

    // parse picture index and gallery index from URL (#&pid=1&gid=2)
    var photoswipeParseHash = function() {
        var hash = window.location.hash.substring(1),
            params = {};

        if(hash.length < 5) {
            return params;
        }

        var vars = hash.split('&');
        for (var i = 0; i < vars.length; i++) {
            if(!vars[i]) {
                continue;
            }
            var pair = vars[i].split('=');
            if(pair.length < 2) {
                continue;
            }
            params[pair[0]] = pair[1];
        }

        if(params.gid) {
            params.gid = parseInt(params.gid, 10);
        }

        return params;
    };

    var openPhotoSwipe = function(index, galleryElement, disableAnimation, fromURL) {
        var pswpElement = document.querySelectorAll('.pswp')[0],
            gallery,
            options,
            items;

        items = parseThumbnailElements(galleryElement);

        // define options (if needed)
        options = {

            // define gallery index (for URL)
            galleryUID: galleryElement.getAttribute('data-pswp-uid'),hideAnimationDuration:0, showAnimationDuration:0

            // getThumbBoundsFn: function(index) {
            //     // See Options -> getThumbBoundsFn section of documentation for more info
            //     var thumbnail = items[index].el.getElementsByTagName('img')[0], // find thumbnail
            //         pageYScroll = window.pageYOffset || document.documentElement.scrollTop,
            //         rect = thumbnail.getBoundingClientRect();

            //     return {x:rect.left, y:rect.top + pageYScroll, w:rect.width};
            // }

        };

        // PhotoSwipe opened from URL
        if(fromURL) {
            if(options.galleryPIDs) {
                // parse real index when custom PIDs are used
                // http://photoswipe.com/documentation/faq.html#custom-pid-in-url
                for(var j = 0; j < items.length; j++) {
                    if(items[j].pid == index) {
                        options.index = j;
                        break;
                    }
                }
            } else {
                // in URL indexes start from 1
                options.index = parseInt(index, 10) - 1;
            }
        } else {
            options.index = parseInt(index, 10);
        }

        // exit if index not found
        if( isNaN(options.index) ) {
            return;
        }

        if(disableAnimation) {
            options.showAnimationDuration = 0;
        }

        // Pass data to PhotoSwipe and initialize it
        gallery = new PhotoSwipe( pswpElement, PhotoSwipeUI_Default, items, options);
        gallery.init();
    };

    // loop through all gallery elements and bind events
    var galleryElements = document.querySelectorAll( gallerySelector );

    for(var i = 0, l = galleryElements.length; i < l; i++) {
        galleryElements[i].setAttribute('data-pswp-uid', i+1);
        galleryElements[i].onclick = onThumbnailsClick;
    }

    // Parse URL and open gallery if it contains #&pid=3&gid=1
    var hashData = photoswipeParseHash();
    if(hashData.pid && hashData.gid) {
        openPhotoSwipe( hashData.pid ,  galleryElements[ hashData.gid - 1 ], true, true );
    }
};

// execute above function
initPhotoSwipeFromDOM('.my-gallery');



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

var loaderGif = function(selector, bool, classes){
    if(bool) {
        $(selector).append('<div id="loaderDiv" class="' + classes + '"></div>')
        $('#loaderDiv').css('margin-top', '5px');
        $('#loaderDiv').html('<center><div class="lds-hourglass"></div></center>');
    }
    else{
        $(selector).find('#loaderDiv').remove();
    }

}




var numberOfAlertsTriggered = 0;
var alertLAWN = function(textOfAlert, typeOfAlert){
    numberOfAlertsTriggered++;
    modalID = "lawnModal"+numberOfAlertsTriggered;
    if(typeOfAlert == 'error'){
        var modalContent = '<div class="" role="alert" style="padding-top: 45px;padding-bottom: 20px;padding-left: 15px;font-size: 25px;">' +
            textOfAlert +
            '</div>';
        $('body').append(
            '<div id="'+modalID+'" class="modal fade" role="dialog">\n' +
            '  <div class="modal-dialog">' +
            '    <!-- Modal content-->' +
            '    <div class="modal-content">' +
            '      <div class="modal-header" style="border-bottom: 1px solid #efefef;background: #cc525269;border-top-left-radius: 5px;border-top-right-radius: 5px;padding-bottom: 8px;">  ' +

            '     <h4 class="modal-title" style="  font-size: 30px;"> Error </h4> ' +
            '      </div>' +
            '      <div class="modal-body" style="padding: 0;">' +
            modalContent +
            '      </div>' +
            '      <div class="modal-footer" style="border: none;">' +
            '        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>' +
            '      </div>' +
            '    </div>' +
            '  </div>' +
            '</div>');
        $('#'+modalID).modal('toggle');
    }
    else if(typeOfAlert == 'normal' || typeOfAlert == undefined){
        var modalContent = '<div class="" role="alert" style="padding-top: 45px;padding-bottom: 20px;padding-left: 15px;font-size: 25px;">' +
            textOfAlert +
            '\n' +
            '</div>\n';
        $('body').append('<div id="'+modalID+'" class="modal fade" role="dialog">\n' +
            '  <div class="modal-dialog">\n' +
            '\n' +
            '    <!-- Modal content-->\n' +
            '    <div class="modal-content">\n' +
            '      <div class="modal-header" style="border-bottom: 1px solid #efefef;background: #b4cc5269;border-top-left-radius: 5px;border-top-right-radius: 5px;padding-bottom: 8px;">  ' +
            '        <h4 class="modal-title" style="  font-size: 30px;"> Warning </h4> '+
            '      </div>\n' +
            '      <div class="modal-body" style="padding: 0;">' +
            modalContent +
            '      </div>\n' +
            '      <div class="modal-footer" style="border: none;">\n' +
            '        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>\n' +
            '      </div>\n' +
            '    </div>\n' +
            '\n' +
            '  </div>\n' +
            '</div>');
        $('#'+modalID).modal('toggle');

    }
    else{
        console.log('Not right modal trigger, you fucktard')
    }

}
