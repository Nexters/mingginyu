$(function (self) {
    self._api = {
        router:"",
        voice: "",
        interval : null,
        tmpl: "templates/",
        messageLoading: false,
        popupState: false,
        closeState: false,
        pre: {
            A: {
                message: "물 너무 주지마. 배불러요",
                feeling: "Too much"
            },
            B: {
                message: "넌 최고야~",
                feeling: "Thankful"
            },
            C: {
                message: "오늘도 좋은 하루~",
                feeling: "Satisfisfied"
            },
            D: {
                message: "하아, 나한테 관심도 없나봐",
                feeling: "Depressed"
            },
            E: {
                message: "목말라, 물좀 주세요. 네?",
                feeling: "Thirsty & Angry"
            },
            F: {
                message: "지금이라도 살려주세요 제발....",
                feeling: "help me"
            },
            G: {
                message: "지금까지 짧은시간동안 즐거웠습니다.",
                feeling: "Bye-Bye"
            }
        },
        loop: {
            distance: function () {
                interval = setInterval(function () {
                    if( _api.router != "mobile") {
                        _api.get.distance(function (isClose) {
                            if ((isClose != _api.closeState) && _api.router != "mobile") {
                                if (isClose) {
                                    _api.closeState = true;
                                    _api.set.template = "main";
                                }
                                else {
                                    _api.closeState = false;
                                    _api.set.template = "intro";
                                }
                            } else {

                            }
                        });
                    }
                }, 1500);
            }
        },
        set: {
            set template(fileName) {
                _api.router = fileName;
                if ($("article#article").length > 0) {
                    $(".template").remove();
                    $.get(_api.tmpl + "css/" + fileName + ".css", function (stylesheet) {
                        $("head").append("<style class='template'>" + stylesheet + "</style>");
                        $.get(_api.tmpl + fileName + ".html", function (dom) {
                            $("article#article").html(dom);
                            $.get(_api.tmpl + "js/" + fileName + ".js");
                        });
                    });
                }
            }
        },
        get: {
            set onVoice(callback) {
                if (!('webkitSpeechRecognition' in window))
                    alert("지원하지 않는 브라우저 입니다.");
                else {
                    _api.get.voice(callback).start();
                }
            },
            voice: function (callback) {
                var mic = new webkitSpeechRecognition();
                mic.continuous = true;
                mic.interimResults = true;
                mic.lang = 'ko-KR';
                mic.onresult = function (e) {
                    var b = '', c = false;
                    for (var i = e.resultIndex; i < e.results.length; ++i) {
                        b += e.results[i][0].transcript;
                        c = e.results[i].isFinal;
                    }
                    console.log(_api.voice);

                    if (c)
                        console.log(_api.voice);

                    if (b.replace(_api.voice, "") == "") {
                        callback(_api.voice);
                        mic.stop();

                        setTimeout(function () {
                            _api.get.voice(callback).start();
                        }, 1500);
                    }

                    _api.voice = b != "" ? b.replace(_api.voice, "") : _api.voice;
                };
                mic.onend = function () {
                };
                return mic;
            },
            distance: function (callback) {
                if (callback) {
                    $.ajax({
                        url: "http://52.78.94.123:8080/data/closer/get.do",
                        method: "GET",
                        dataType: "json",
                        success: function (data) {
                            if (data.resData[0].msg != "") {
                                if (_api.get.message) {
                                    _api.get.message(data.resData[0].msg);
                                }
                            }
                            callback(data.resData[0].closer.envvalue == "1");
                        }
                    });
                }
            }
        }
    };

    _api.loop.distance();
}(window));