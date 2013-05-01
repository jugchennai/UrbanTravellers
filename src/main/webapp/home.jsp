<html>
    <head>
        <title>Kinetic Cars</title>
        <link rel="stylesheet" type="text/css" href="css/kieticcars.css"/>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
        <link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.css"/>
        <link href='http://fonts.googleapis.com/css?family=Sansita+One' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Chewy' rel='stylesheet' type='text/css'>
        <script type="text/javascript" src="js/websocket.js"></script>

        <style type="text/css">
            body {
                font-family: 'Chewy', cursive;
                font-weight: bold;
                font-size: 25px;
                background-image: url('images/SBC_sr-sr599.jpg') ;
                line-height: 35px;
                color: #149bdf;
            }    


            .game-hero {
                padding: 2px;
                font-weight: 200;
                line-height: 10px;
                color: inherit;
                background-color: #a9302a;
                -webkit-border-radius: 2px;
                -moz-border-radius: 2px;
                border-radius: 2px;
            }

            .sub-title {
                font-family: 'Sansita One', cursive; 
                font-size: 20px;
                font-weight: bold;
                line-height: 20px;
                letter-spacing: -1px;
                text-align: center;
                color: #fff;
            }

        </style>
    </head>
    <body>
        <div class="game-hero">
        </div>

        <div class="container-fluid"> 
            <div class="row-fluid">
                <div class="span2" style="background-color: #a9302a;">
                    <img src="images/urbanTravellers.png">
                    <p class="sub-title">Urban Travellers</p>
                    <img src="images/images.jpeg">
                </div>
                <div class="span6" id="gamestage">
                    <h2>
                        Welcome, <%= request.getAttribute("player")%> !!!
                    </h2>
                    <button type="button" class="btn btn-primary btn-large" 
                            onclick="sendText('<%= request.getAttribute("player")%>');" >Join</button>
                </div>
                <div class="span2">
                    <h4>Players on board </h4>
                    <div id="output">

                    </div>
                </div>
                <input type="hidden" id="plyrName" value="<%=request.getAttribute("player")%>"> 
            </div>
        </div>
        <div class="game-hero">
            <p class="sub-title">
                JUGChennai - Adopt A JSR 
            </p>
        </div>
    </body>
</html>