/**
 * Created by limjuhyun on 7/30/16.
 */
var location = "http://localhost:8080/"

function requestService(reqUrl, reqParam, rslFunction) {
    var request = $.ajax({
        url :location+reqUrl
        , method : "POST"
        , data : reqParam
        , dataType : "JSON"
    });

    request.done(rslFunction);

    request.fail(function(jqXHR, textStatus) {
        console.log(textStatus);
    });
}