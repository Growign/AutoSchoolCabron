// import "./WOW"
//
(function ($) {
//     "use strict";
//
//     // Spinner
//     var spinner = function () {
//         setTimeout(function () {
//             if ($('#spinner').length > 0) {
//                 $('#spinner').removeClass('show');
//             }
//         }, 1);
//     };
//     spinner();
//
//
//     // Initiate the wowjs
//     new WOW().init();
//
//
//     // Sticky Navbar
    $(window).scroll(function () {
        console.log("Loh");
        if ($(this).scrollTop() > 300) {
            $('.sticky-top').addClass('shadow-sm').css('top', '0px');
        } else {
            $('.sticky-top').removeClass('shadow-sm').css('top', '-100px');
        }
    });
//
//
//     // Back to top button
//     $(window).scroll(function () {
//         if ($(this).scrollTop() > 300) {
//             $('.back-to-top').fadeIn('slow');
//         } else {
//             $('.back-to-top').fadeOut('slow');
//         }
//     });
//     $('.back-to-top').click(function () {
//         $('html, body').animate({scrollTop: 0}, 1500, 'easeInOutExpo');
//         return false;
//     });
//
//
//     // Testimonials carousel
//     $(".testimonial-carousel").owlCarousel({
//         autoplay: true,
//         smartSpeed: 1000,
//         items: 1,
//         dots: true,
//         loop: true,
//     });
//
//
})();
//
// import WOW from "./wow.min"
// var wow = new WOW(
//     {
//         boxClass:     'wow',      // animated element css class (default is wow)
//         animateClass: 'animated', // animation css class (default is animated)
//         offset:       0,          // distance to the element when triggering the animation (default is 0)
//         mobile:       true,       // trigger animations on mobile devices (default is true)
//         live:         true,       // act on asynchronously loaded content (default is true)
//         callback:     function(box) {
//             // the callback is fired every time an animation is started
//             // the argument that is passed in is the DOM node being animated
//         },
//         scrollContainer: null,    // optional scroll container selector, otherwise use window,
//         resetAnimation: true,     // reset animation on end (default is true)
//     }
// );
// wow.init();