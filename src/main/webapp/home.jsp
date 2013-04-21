<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="websocket.js"></script>
        <link href="css/bootstrap.css" rel="stylesheet">
        <style type="text/css">
            .bigtext {
                font-size: x-large;
            }
        </style>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span10 offset1">
                    <div class="span4 offset2">
                        <h2>
                            Welcome, <%= request.getAttribute("player")%> !!!
                        </h2>
                        <button type="button" class="btn btn-primary btn-large" 
                                onclick="sendText('<%= request.getAttribute("player")%>');" >Join</button>
                    </div>
                    <div class="span2 bigtext">
                        <h4>Players on board </h4>
                        <div id="output">
                            
                        </div>
                    </div>
                </div>
                <input type="hidden" id="plyrName" value="<%=request.getAttribute("player")%>"> 
            </div>   
        </div>
    </body>
</html>
