<%-- 
    Document   : login
    Created on : Apr 20, 2013, 2:49:49 PM
    Author     : prasannakumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <link href="css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
        body {
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #f5f5f5;
        }

        .form-signin {
            max-width: 300px;
            padding: 19px 29px 29px;
            margin: 0 auto 20px;
            background-color: #fff;
            border: 1px solid #e5e5e5;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 5px;
            -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
            -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
            box-shadow: 0 1px 2px rgba(0,0,0,.05);
        }
        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            margin-bottom: 10px;
        }
        .form-signin input[type="text"],
        .form-signin input[type="password"] {
            font-size: 16px;
            height: auto;
            margin-bottom: 15px;
            padding: 7px 9px;
        }

    </style>
    <link href="css/bootstrap-responsive.css" rel="stylesheet">
    <body>
        <div class="container">

            <form action="enrollgame" method="post" class="form-signin">
                <h1>UrbanTravellers</h1>
                <hr>   
                <h4 class="form-signin-heading">Please sign in to join the game </h4>
                Your Name <input type="text" name="name"> 
                <button type="submit" class="btn btn-primary btn-large">Login</button>
                <a class="btn btn-primary btn-large" href="rest.jsp">Reset</a>  
            </form>
        </div>
    </body>
</html>


