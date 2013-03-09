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
                <div class="span3 offset1">
                    <form action=""> 
                        <b>Create Game</b>
                        <label>Name your game :</label>
                        <input id="nameField" placeholder="Name"type="text"/><br><br>
                        <input class="btn btn-primary" value="create" type="button"/>
                    </form>
                </div>
                <div class="span7">

                    <div class="span7" id="score">
                        <p> 
                        <h4 class="small">
                            GameBoard/s you may wish to join .... 
                        </h4>
                        </p>
                        <div class="span7">
                            <p>
                            <h4>
                                New Game 1     
                            </h4>
                            <span  class="badge badge-important">3</span> Players on-board
                            </p>
                            <a href="gameBoot.jsp" class="btn btn-primary btn-small">Join</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
