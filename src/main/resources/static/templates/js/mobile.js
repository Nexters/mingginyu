$(function(){
    clearInterval(_api.interval);
    _api.get.onVoice = function(data) {
        $.ajax({
            url: "http://52.78.94.123:8080/data/message.do?msg=" + data,
            method: "GET",
            dataType:"json",
            success:function(data){
            }
        });
    };
});