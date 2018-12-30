/**
 * 
 */


$('.menus li').ready(function(){
    $('.menus li').mouseenter(function(){
        $('.menus li').removeClass('bg');
        $(this).addClass('bg');
        var index = $(this).index();
        $('.scroll').css('margin-top',-index*800+'px');
    })
})