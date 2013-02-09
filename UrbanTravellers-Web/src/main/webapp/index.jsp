<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Urban Travelers</title>
        <link rel="stylesheet" href="resources/css/bootstrap.min.css" type="text/css">
    </head>
    <body>
        <div class="container-fluid">
            <div class="row-fluid">
                <h1>Urban Travelers</h1>
                <hr>
            </div>
            <div class="row-fluid">
                <div class="span3">
                    <form action=""> 
                        <legend>Create Game</legend>
                        <label>Name your game :</label>
                        <input id="nameField" placeholder="Name"type="text"/><br><br>
                        <input class="btn btn-primary btn-large" value="create" type="button"/>
                    </form>
                </div>
                <div class="span9">
                    <div id="output"></div>
                    <div class="span6" id="score">
                        <h2>Active GameBoards</h2>
                        <div class="span3">
                            <h4>
                                Pras
                            </h4> 
                            <div id="prasScore">

                            </div>
                        </div>
                        <div class="span3">
                            <h4>
                                Raj 
                            </h4> 
                            <div id="rajScore">

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
