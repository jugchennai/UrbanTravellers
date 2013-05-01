<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/kieticcars.css"/>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
        <link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.css"/>
        <link href='http://fonts.googleapis.com/css?family=Alegreya:400italic,700italic,900italic,400,900,700' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Sansita+One' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Autour+One' rel='stylesheet' type='text/css'>
        <style>

            body {
                font-family: 'Autour One', cursive;
            }    

            .head { 
                font-family: 'Sansita One', cursive; 
                font-size:  100px; 
                font-weight: bold;
                text-align: center;
                color: green;
            }

            .sub-title {
                font-family: 'Sansita One', cursive; 
                font-size: 30px;
                font-weight: bold;
                text-align: center;
                line-height: 35px;
                letter-spacing: -1px;
            }

            .heading {
                background-color: #b3daff;
            }
        </style>

    </head>
    <body>

        <div class="hero-unit">
            <p class="head">Urban Travellers</p>
        </div>

        <div class="container-fluid"> 
            <div class="row-fluid">
                <div class="span12">
                    <p class="sub-title">
                        "UrbanTravellers" is a dice based racing game 
                    </p>
                    <hr>
                </div>
            </div>
            <div class="row-fluid">
                <div class="span6">
                    <div class="span4 pull-right">
                        <br>
                        <img src="images/urbanTravellers.png" width="600">
                    </div>
                </div>
                <div class="span6 pull-right">
                    <form action="enrollgame" method="post" class="form-signin">
                        <h4 class="form-signin-heading">Please sign in to join the game </h4>
                        Your Name <input type="text" name="name"> 
                        <br>
                        <button type="submit" class="btn btn-primary btn-large">Login</button>
                        <a class="btn btn-primary btn-large" href="rest.jsp">Reset</a>  
                    </form>
                </div>
            </div>
            <div class="row-fluid">
                <div class="span6 offset3">
                    <p class="sub-title">
                        About UrbanTravellers
                    </p>
                    <p>
                        UrbanTravellers is a case study application which uses  WebSockets (JSR 356) & JSON (JSR 354) spec of JEE7 platform
                    </p>
                </div>

            </div>
        </div>

    </body>
</html>