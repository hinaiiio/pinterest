<%--
  Created by IntelliJ IDEA.
  User: hina
  Date: 2016/12/05
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>today's your color</title>
    <script>
        window.pAsyncInit = function() {
            PDK.init({
                appId: "<4868824896827835698>", // Change this
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
    </script>
</head>
<body>
<script>

    document.write("hello");
    var pins = [];
    PDK.request('/boards/720364971585722863/pins/', function (response) { // Make sure to change the board_id
        if (!response || response.error) {
            alert('Error occurred');
        } else {
            pins = pins.concat(response.data);
            if (response.hasNext) {
                response.next(); // this will recursively go to this same callback
            }
        }
    });

</script>
</body>
</html>
