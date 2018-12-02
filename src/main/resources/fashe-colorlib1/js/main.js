
(function ($) {
    "use strict";
    $.ajax({
        url:"http://localhost:8080/goods",
        type:"GET",
        headers: {
            "Authorize":"Bearer " + localStorage.getItem("token"),
        },
        contentType: "application/json",
        success: function (data) {

            var out = '';
            for (var key in data) {
                out += '<div class="col-sm-12 col-md-6 col-lg-4 p-b-50">';
                <!-- Block2 -->
                out += '<div class="block2">';
                out += '<div class="block2-img wrap-pic-w of-hidden pos-relative">';
                out += '<img src="images/item-05.jpg" alt="IMG-PRODUCT">';

                out += '<div class="block2-overlay trans-0-4">';
                out += '<a href="#" class="block2-btn-addwishlist hov-pointer trans-0-4">';
                out += '<i class="icon-wishlist icon_heart_alt" aria-hidden="true"></i>';
                out += '<i class="icon-wishlist icon_heart dis-none" aria-hidden="true"></i>';
                out += '</a>';

                out += '<div class="block2-btn-addcart w-size1 trans-0-4">';
                <!-- Button -->
                out += '<button class="add-to-cart" data-art="' + key + '">Купить</button>';
                out += '</div>';
                out += '</div>';
                out += '</div>';

                out += '<div class="block2-txt p-t-20">';
                out += '<a href="product-detail.html" class="block2-name dis-block s-text3 p-b-5">';
                out += 'Coach slim easton black';
                out += '</a>';

                out += '<span class="block2-price m-text6 p-r-5">';
                out += '$165.90';
                out += '</span>';
                out += '</div>';
                out += '</div>';
                out += '</div>';
            }
            $('#listTovar').html(out);
            $('add-to-cart').on('click', addToCart);
        },
        error: function (error) {
            console.log(error);
        }
    });



    // $.ajax({
    //     url:"http://localhost:8080/goods",
    //     type:"GET",
    //     headers: {
    //         "Authorize":"Bearer " + localStorage.getItem("token"),
    //     },
    //     contentType:"application/json",
    //     success:function(data){
    //
    //         for(var i=0; i<data.length;i++){
    //             var k="\n" +
    //                 "                        <div class=\"col-sm-12 col-md-6 col-lg-4 p-b-50\">\n" +
    //                 "                            <!-- Block2 -->\n" +
    //                 "                            <div class=\"block2\">\n" +
    //                 "                                <div class=\"block2-img wrap-pic-w of-hidden pos-relative\">\n" +
    //                 "                                    <img src=\"images/item-05.jpg\" alt=\"IMG-PRODUCT\">\n" +
    //                 "\n" +
    //                 "                                    <div class=\"block2-overlay trans-0-4\">\n" +
    //                 "                                        <a href=\"#\" class=\"block2-btn-addwishlist hov-pointer trans-0-4\">\n" +
    //                 "                                            <i class=\"icon-wishlist icon_heart_alt\" aria-hidden=\"true\"></i>\n" +
    //                 "                                            <i class=\"icon-wishlist icon_heart dis-none\" aria-hidden=\"true\"></i>\n" +
    //                 "                                        </a>\n" +
    //                 "\n" +
    //                 "                                        <div class=\"block2-btn-addcart w-size1 trans-0-4\">\n" +
    //                 "                                            <!-- Button -->\n" +
    //                 "                                            <button class=\"flex-c-m size1 bg4 bo-rad-23 hov1 s-text1 trans-0-4\">\n" +
    //                 "                                                Add to Cart\n" +
    //                 "                                            </button>\n" +
    //                 "                                        </div>\n" +
    //                 "                                    </div>\n" +
    //                 "                                </div>\n" +
    //                 "\n" +
    //                 "                                <div class=\"block2-txt p-t-20\">\n" +
    //                 "                                    <a href=\"product-detail.html\" class=\"block2-name dis-block s-text3 p-b-5\">\n" +
    //                 data[i].nameGoods +
    //                 "                                    </a>\n" +
    //                 "\n" +
    //                 "                                    <span class=\"block2-price m-text6 p-r-5\">\n" +"$"+
    //                 data[i].price +
    //                 "                                    </span>\n" +
    //                 "                                </div>\n" +
    //                 "                            </div>\n" +
    //                 "                        </div>\n" +
    //                 "    <script type=\"text/javascript\">\n" +
    //                 "        $('.block2-btn-addcart').each(function(){\n" +
    //                 "\n" +
    //                 "            var nameProduct = $(this).parent().parent().parent().find('.block2-name').html();\n" +
    //                 "            $(this).on('click', function(){\n" +
    //                 "                swal(nameProduct, \"is added to cart !\", \"success\");\n" +
    //                 "            });\n" +
    //                 "             $(this).on('click', function(){\n" +
    //                 "\n" +
    //                 "                localStorage.setItem('Id',1);\n" +
    //                 "                \n" +
    //                 "\n" +
    //                 "                swal(nameProduct,\"is added to cart !\", \"success\");\n" +
    //                 "                swal(Id, \"is added to cart !\", \"success\");\n" +
    //                 "            });\n" +
    //                 "        });\n" +
    //                 "        $('.block2-btn-addwishlist').each(function(){\n" +
    //                 "            var nameProduct = $(this).parent().parent().parent().find('.block2-name').html();\n" +
    //                 "            $(this).on('click', function(){\n" +
    //                 "                swal(nameProduct, \"is added to wishlist !\", \"success\");\n" +
    //                 "            });\n" +
    //                 "        });\n" +
    //                 "    <"+"/"+"script"+">"
    //             $("#listTovaru").append(k);
    //         }
    //     },
    //     error:function(error){
    //         console.log(error);
    //     }
    // });
    $.ajax({
        url:"http://localhost:8080/category",
        type:"GET",
        headers: {
            "Authorize":"Bearer " + localStorage.getItem("token")
        },
        contentType:"application/json",
        success:function(data){
            for(var i=0; i<data.length;i++){
                var r="<li class=\"p-t-4\">\n" +
                    "\t\t\t\t\t\t\t\t<a href=\"#\" class=\"s-text13\">\n" +
                    "\t\t\t\t\t\t\t\t\t" +
                    data[i].nameCategory +
                    "\t\t\t\t\t\t\t\t</a>\n" +
                    "\t\t\t\t\t\t\t</li>"
                $("#categoryList").append(r);
            }
        },
        error:function(error){
            console.log(error);
        }
    });

    /*[ Load page ]
    ===========================================================*/
    $(".animsition").animsition({
        inClass: 'fade-in',
        outClass: 'fade-out',
        inDuration: 1500,
        outDuration: 800,
        linkElement: '.animsition-link',
        loading: true,
        loadingParentElement: 'html',
        loadingClass: 'animsition-loading-1',
        loadingInner: '<div data-loader="ball-scale"></div>',
        timeout: false,
        timeoutCountdown: 5000,
        onLoadEvent: true,
        browser: [ 'animation-duration', '-webkit-animation-duration'],
        overlay : false,
        overlayClass : 'animsition-overlay-slide',
        overlayParentElement : 'html',
        transition: function(url){ window.location.href = url; }
    });
    
    /*[ Back to top ]
    ===========================================================*/
    var windowH = $(window).height()/2;

    $(window).on('scroll',function(){
        if ($(this).scrollTop() > windowH) {
            $("#myBtn").css('display','flex');
        } else {
            $("#myBtn").css('display','none');
        }
    });

    $('#myBtn').on("click", function(){
        $('html, body').animate({scrollTop: 0}, 300);
    });


    /*[ Show header dropdown ]
    ===========================================================*/
    $('.js-show-header-dropdown').on('click', function(){
        $(this).parent().find('.header-dropdown')
    });

    var menu = $('.js-show-header-dropdown');
    var sub_menu_is_showed = -1;

    for(var i=0; i<menu.length; i++){
        $(menu[i]).on('click', function(){ 
            
                if(jQuery.inArray( this, menu ) == sub_menu_is_showed){
                    $(this).parent().find('.header-dropdown').toggleClass('show-header-dropdown');
                    sub_menu_is_showed = -1;
                }
                else {
                    for (var i = 0; i < menu.length; i++) {
                        $(menu[i]).parent().find('.header-dropdown').removeClass("show-header-dropdown");
                    }

                    $(this).parent().find('.header-dropdown').toggleClass('show-header-dropdown');
                    sub_menu_is_showed = jQuery.inArray( this, menu );
                }
        });
    }

    $(".js-show-header-dropdown, .header-dropdown").click(function(event){
        event.stopPropagation();
    });

    $(window).on("click", function(){
        for (var i = 0; i < menu.length; i++) {
            $(menu[i]).parent().find('.header-dropdown').removeClass("show-header-dropdown");
        }
        sub_menu_is_showed = -1;
    });


     /*[ Fixed Header ]
    ===========================================================*/
    var posWrapHeader = $('.topbar').height();
    var header = $('.container-menu-header');

    $(window).on('scroll',function(){

        if($(this).scrollTop() >= posWrapHeader) {
            $('.header1').addClass('fixed-header');
            $(header).css('top',-posWrapHeader); 

        }  
        else {
            var x = - $(this).scrollTop(); 
            $(header).css('top',x); 
            $('.header1').removeClass('fixed-header');
        } 

        if($(this).scrollTop() >= 200 && $(window).width() > 992) {
            $('.fixed-header2').addClass('show-fixed-header2');
            $('.header2').css('visibility','hidden'); 
            $('.header2').find('.header-dropdown').removeClass("show-header-dropdown");
            
        }  
        else {
            $('.fixed-header2').removeClass('show-fixed-header2');
            $('.header2').css('visibility','visible'); 
            $('.fixed-header2').find('.header-dropdown').removeClass("show-header-dropdown");
        } 

    });
    
    /*[ Show menu mobile ]
    ===========================================================*/
    $('.btn-show-menu-mobile').on('click', function(){
        $(this).toggleClass('is-active');
        $('.wrap-side-menu').slideToggle();
    });

    var arrowMainMenu = $('.arrow-main-menu');

    for(var i=0; i<arrowMainMenu.length; i++){
        $(arrowMainMenu[i]).on('click', function(){
            $(this).parent().find('.sub-menu').slideToggle();
            $(this).toggleClass('turn-arrow');
        })
    }

    $(window).resize(function(){
        if($(window).width() >= 992){
            if($('.wrap-side-menu').css('display') == 'block'){
                $('.wrap-side-menu').css('display','none');
                $('.btn-show-menu-mobile').toggleClass('is-active');
            }
            if($('.sub-menu').css('display') == 'block'){
                $('.sub-menu').css('display','none');
                $('.arrow-main-menu').removeClass('turn-arrow');
            }
        }
    });


    /*[ remove top noti ]
    ===========================================================*/
    $('.btn-romove-top-noti').on('click', function(){
        $(this).parent().remove();
    })


    /*[ Block2 button wishlist ]
    ===========================================================*/
    // $('.block2-btn-addwishlist').on('click', function(e){
    //     e.preventDefault();
    //     $(this).addClass('block2-btn-towishlist');
    //     $(this).removeClass('block2-btn-addwishlist');
    //     $(this).off('click');
    // });

    /*[ +/- num product ]
    ===========================================================*/
    // $('.btn-num-product-down').on('click', function(e){
    //     e.preventDefault();
    //     var numProduct = Number($(this).next().val());
    //     if(numProduct > 1) $(this).next().val(numProduct - 1);
    // });
    //
    // $('.btn-num-product-up').on('click', function(e){
    //     e.preventDefault();
    //     var numProduct = Number($(this).prev().val());
    //     $(this).prev().val(numProduct + 1);
    // });


    /*[ Show content Product detail ]
    ===========================================================*/
    // $('.active-dropdown-content .js-toggle-dropdown-content').toggleClass('show-dropdown-content');
    // $('.active-dropdown-content .dropdown-content').slideToggle('fast');
    //
    // $('.js-toggle-dropdown-content').on('click', function(){
    //     $(this).toggleClass('show-dropdown-content');
    //     $(this).parent().find('.dropdown-content').slideToggle('fast');
    // });


    /*[ Play video 01]
    ===========================================================*/
    // var srcOld = $('.video-mo-01').children('iframe').attr('src');
    //
    // $('[data-target="#modal-video-01"]').on('click',function(){
    //     $('.video-mo-01').children('iframe')[0].src += "&autoplay=1";
    //
    //     setTimeout(function(){
    //         $('.video-mo-01').css('opacity','1');
    //     },300);
    // });
    //
    // $('[data-dismiss="modal"]').on('click',function(){
    //     $('.video-mo-01').children('iframe')[0].src = srcOld;
    //     $('.video-mo-01').css('opacity','0');
    // });

    // $(".block2-btn-addcart").click(function(){
    //     var category = {
    //         nameCategory:$("#nameCategory").val()
    //     };
    //
    //     $.ajax({
    //         url:"http://localhost:8080/category",
    //         type:"POST",
    //         headers: {
    //             "Authorize":"Bearer " + localStorage.getItem("token")
    //         },
    //         contentType:"application/json",
    //         data:JSON.stringify(category),
    //         success:function(data){
    //             $("#categoryInShop").append("<li>"+data.nameCategory+"</li>");
    //             alert("Good");
    //
    //
    //         },
    //         error:function(error){
    //             console.log(error);
    //         }
    //     });
    // });

})(jQuery);