$(function () {
    _api.closeState = true;
    _api.get.message = function (msg) {
        if (msg.indexOf("밍기뉴") >= 0 && !_api.popupState) {
            _api.popupState = true;
            $(".alert .card.user .contents").text("밍기뉴!");
            $(".alert .card.ming .contents").text("불렀어요?");
            $(".alert_back").show();
            $(".alert_back").animate({
                opacity: 1
            }, 500);
        } else {
            if(!_api.messageLoading && _api.popupState) {
                _api.messageLoading = true;
                $("footer .thinking").text("밍기뉴가 당신 말의 뜻을 생각하는 중입니다.");
                $(".alert .card.user .contents").text(msg);
                $(".alert .card.ming .contents").text("");
                $.ajax({
                    url: "http://52.78.94.123:8080/lib/simsimi/" + encodeURI(msg),
                    method: "GET",
                    dataType:"json",
                    success:function(data){
                        if(data.response != "")
                        {
                            _api.messageLoading = false;
                            $(".alert .card.ming .contents").text(data.response);
                            $("footer .thinking").text("^-^");
                        }
                    }, error : function(){ _api.messageLoading = false;}
                });
            }
        }
    };

    $.ajax({
        url: "http://52.78.94.123:8080/app/main.do",
        method: "GET",
        dataType:"json",
        success:function(data){
            let mos = Math.round(data.resData[0].plant[0].mos);
            $(".age.balloon .body").text(data.resData[0].age + "Days");
            $(".moisture.balloon .body").text(mos + "%");
            $(".feeling.balloon .body").text(_api.pre[data.resData[0].plant[0].mos_level].feeling);

            if(mos >= 80) {
                $("img.moisture_05").show();
                $("img.moisture_04").show();
                $("img.moisture_03").show();
                $("img.moisture_02").show();
                $("img.moisture_01").show();
            } else if(mos >= 64) {
                $("img.moisture_05").hide();
                $("img.moisture_04").show();
                $("img.moisture_03").show();
                $("img.moisture_02").show();
                $("img.moisture_01").show();
            } else if(mos >= 48) {
                $("img.moisture_05").hide();
                $("img.moisture_04").hide();
                $("img.moisture_03").show();
                $("img.moisture_02").show();
                $("img.moisture_01").show();
            } else if(mos >= 32) {
                $("img.moisture_05").hide();
                $("img.moisture_04").hide();
                $("img.moisture_03").hide();
                $("img.moisture_02").show();
                $("img.moisture_01").show();
            } else if(mos >= 16) {
                $("img.moisture_05").hide();
                $("img.moisture_04").hide();
                $("img.moisture_03").hide();
                $("img.moisture_02").hide();
                $("img.moisture_01").show();
            } else {
                $("img.moisture_05").hide();
                $("img.moisture_04").hide();
                $("img.moisture_03").hide();
                $("img.moisture_02").hide();
                $("img.moisture_01").hide();
            }

            $(".container.main header").text('" ' + _api.pre[data.resData[0].plant[0].mos_level].message + ' "');
            $(".inline.right .container header .home").text(data.resData[0].name);
            $("section.temperature .body span").text(Math.round(data.resData[0].room[0].temp) + "°");
            $("section.humidity .body span").text(Math.round(data.resData[0].room[0].mos) + "%");
        }
    });
});

$(".alert .ic_close").on("click", function () {
    _api.popupState = false;
    let back = $(this).parents(".alert_back");
    back.animate({
        opacity: 0
    }, 500, function () {
        back.hide();
    });
});