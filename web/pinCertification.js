/**
 * Created by hina on 2016/12/06.
 */
window.pAsyncInit = function() {
    PDK.init({
        appId: "<your app-id>", // Change this
        cookie: true
    });
};

(function(d, s, id){
    var js, pjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) {return;}
    js = d.createElement(s); js.id = id;
    js.src = "//assets.pinterest.com/sdk/sdk.js";
    pjs.parentNode.insertBefore(js, pjs);
}(document, 'script', 'pinterest-jssdk'));
