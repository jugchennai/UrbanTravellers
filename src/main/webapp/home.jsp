<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="websocket.js"></script>
    </head>
    <body>
        welcome , <%= request.getAttribute("player") %>
        <button type="button" onclick="sendText('<%= request.getAttribute("player") %>');" >send</button>
        <div id="output">
            
        </div>
    </body>
</html>
