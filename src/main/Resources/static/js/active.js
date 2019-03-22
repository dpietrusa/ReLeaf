var window, jQuery, document;

(function ($) {
    "use strict";
    //meanmenu
        $('header nav').meanmenu({
            meanMenuContainer: '.romana_header_bottom'
        });
    //Header Search
		$('.search_expand a').on('click', function(){
            $('.search').toggleClass('active');
        });
    //this code is for submenu
    $(document).ready(function () {
    //This code is for owl Carousel
    if ($.fn.owlCarousel) {
            var autoplay = 6000,
                smartSpeed_c = 700,
                hero_slider = $('.hero_slider');
            //Hero_Slider_crsl
            hero_slider.owlCarousel({
                nav: true,
                dots: false,
                autoplay: true,
                loop: true,
                items: 1,
                animation: true,
                touchDrag:false,
                mouseDrag:false,
                smartSpeed: smartSpeed_c,
                autoplayTimeout: autoplay,
                navText: ["<i class='fa fa-angle-left'></i>", "<i class='fa fa-angle-right'></i>"]
            });
            //tihs code is for slider effect
            hero_slider.on('translate.owl.carousel', function() {
                $('.romana_hero_text h1').removeClass('slideInLeft animated').hide();
                $('.romana_hero_text p').removeClass('slideInLeft animated').hide();
                $('.romana_hero_text .common_btn').removeClass('slideInRight animated').hide();
            });
            hero_slider.on('translated.owl.carousel', function() {
                $('.owl-item.active .romana_hero_text h1').addClass('slideInLeft animated').show();
                $('.owl-item.active .romana_hero_text p').addClass('slideInLeft animated').show();
                $('.owl-item.active .romana_hero_text .common_btn').addClass('slideInLeft animated').show();
            });
        //client crsl 
        $('.romana_client_crsl').owlCarousel({
                nav: true,
                dots: false,
                autoplay: false,
                loop: true,
                margin: 50,
                smartSpeed: 1000,
                items: 3,
                navText: ["<i class='fa fa-angle-left'></i>", "<i class='fa fa-angle-right'></i>"],
                responsiveClass: true,
                responsive: {
                    300: {
                        items: 1
                    },
                    480: {
                        items: 1
                    },
                    768: {
                        items: 2,
                        margin: 30
                    },
                    992: {
                        items: 3,
                        margin: 30
                    },
                    1170: {
                        items: 3
                    },
                }
        });
    }
    });
    // LightBox
     if ($.fn.nivoLightbox){
     $('a').nivoLightbox({
		 effect: 'fade',
		 keyboardNav: false,
	 }); 
     }
    //This code is for progress bar 
    if ($.fn.barfiller){  
        var barfiller_custom = $('.barfiller'),
            bar_default_collor = '#19b968';
        barfiller_custom.each(function() {
            var bar_color = $(this).attr('data-color');
            if( bar_color ===  undefined ){
                bar_color = bar_default_collor;
            }
            $(this).barfiller({
                barColor: bar_color,
                duration: 3000
            });
        });
    } 
    //tab
    var tab_li = $('ul.tabs li');
    tab_li.on("click", function () {
        var tab_id = $(this).attr('data-tab');
        tab_li.removeClass('current');
        $('.tab-content').removeClass('current');
        $(this).addClass('current');
        $("#" + tab_id).addClass('current');
    })
    //count down
    if ($.fn.countdown) {
        $('#clock').countdown('2017/7/15', function (event) {
            $(this).html(event.strftime(' <div class="day_wrap">%D <span class="days">days</span></div>       <div          class="day_wrap">%H <span class="days">hours</span></div>  <div class="day_wrap">%M <span class="days">minutes</span></div>     <div class="day_wrap"> %S <span class="days">secound</span></div>'));
        });
    }
    //This code is for singlePrice Hover effect 
   var custom_donate = $(".custom_donate a");
   custom_donate.on('click', function (event) {
       custom_donate.removeClass('active');
       $(this).addClass('active');
       event.preventDefault();
   });
    // Preloder
    $('#preloader').fadeOut(); // will first fade out the loading animation
    $('.preloader_spinner').delay(350).fadeOut('slow'); // will fade out the white DIV that covers the website.
    $("body").removeClass("preloader_active"); 
})(jQuery);
