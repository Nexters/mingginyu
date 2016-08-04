(function(){
    let ratio = {
        width: 803,
        height: 480
    };

    let artHeight = $(window).width() * ratio.height / ratio.width;
    let calHeight = ($(window).height() - artHeight)/2;

    $("header#header").height(calHeight > 0 ? calHeight : 0);

    $("article#article .wrap .container").css("top", (($("article#article").height() - $("article#article .wrap .container").height()) / 2) + "px");
    $("article#article .wrap .container").css("left", (($("article#article").width() - $("article#article .wrap .container").width()) / 2) + "px");
}());