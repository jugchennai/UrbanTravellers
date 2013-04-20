<%-- 
    Document   : temp
    Created on : Apr 18, 2013, 2:34:36 AM
    Author     : MahiRaj Gosemath
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title></title>
		<script src="resources/javascript/kinetic-v4.3.3.min.js"></script>
		<script src="resources/javascript/KineticCar.js"></script>
		<script>
			
			var i=1;
			function roll()
			{
				var dice = Math.floor((Math.random()*6)+1);
				var position = UB.getCarLocation('mahesh');
				dice+=position;
				UB.moveCar('mahesh', dice);
				i++;
				if(i==4)
				{
					i=1;
				}
			}
			
			function init() {
                UB.addCar('mahesh');
				UB.addCar(2);
				UB.addCar(3);
            }
                      
            window.addEventListener("load", init, false);
		</script>
    </head>
    <body>
		<div id="container"></div>
		<input type="button" onclick="roll()" />
    </body>
</html>
