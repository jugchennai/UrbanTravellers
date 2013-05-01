var path = {
    grid: [
        //1st Row
        {'x': 0, 'y': 0, 's': false, 'b': false, 'e': 0},
        {'x': 50, 'y': 0, 's': false, 'b': true, 'e': 0},
        {'x': 100, 'y': 0, 's': false, 'b': false, 'e': 0},
        {'x': 150, 'y': 0, 's': false, 'b': false, 'e': 0},
        {'x': 200, 'y': 0, 's': false, 'b': false, 'e': 0},
        {'x': 250, 'y': 0, 's': false, 'b': false, 'e': 0},
        {'x': 300, 'y': 0, 's': false, 'b': false, 'e': 0},
        {'x': 350, 'y': 0, 's': false, 'b': false, 'e': 0},
        {'x': 400, 'y': 0, 's': true, 'b': false, 'e': 0},
        {'x': 450, 'y': 0, 's': false, 'b': false, 'e': 2},
        //2nd Row
        {'x': 450, 'y': 60, 's': false, 'b': false, 'e': 4},
        {'x': 400, 'y': 60, 's': false, 'b': false, 'e': 0},
        {'x': 350, 'y': 60, 's': false, 'b': false, 'e': 0},
        {'x': 300, 'y': 60, 's': false, 'b': true, 'e': 0},
        {'x': 250, 'y': 60, 's': false, 'b': false, 'e': 0},
        {'x': 200, 'y': 60, 's': false, 'b': true, 'e': 0},
        {'x': 150, 'y': 60, 's': false, 'b': false, 'e': 0},
        {'x': 100, 'y': 60, 's': false, 'b': false, 'e': 0},
        {'x': 50, 'y': 60, 's': false, 'b': true, 'e': 0},
        {'x': 0, 'y': 60, 's': false, 'b': false, 'e': 2},
        //3rd Row
        {'x': 0, 'y': 120, 's': false, 'b': false, 'e': 4},
        {'x': 50, 'y': 120, 's': false, 'b': false, 'e': 0},
        {'x': 100, 'y': 120, 's': false, 'b': false, 'e': 0},
        {'x': 150, 'y': 120, 's': false, 'b': false, 'e': 0},
        {'x': 200, 'y': 120, 's': false, 'b': false, 'e': 0},
        {'x': 250, 'y': 120, 's': false, 'b': false, 'e': 0},
        {'x': 300, 'y': 120, 's': false, 'b': false, 'e': 0},
        {'x': 350, 'y': 120, 's': false, 'b': false, 'e': 0},
        {'x': 400, 'y': 120, 's': false, 'b': false, 'e': 0},
        {'x': 450, 'y': 120, 's': false, 'b': false, 'e': 2},
        //4th Row
        {'x': 450, 'y': 180, 's': false, 'b': false, 'e': 4},
        {'x': 400, 'y': 180, 's': false, 'b': false, 'e': 0},
        {'x': 350, 'y': 180, 's': false, 'b': false, 'e': 0},
        {'x': 300, 'y': 180, 's': false, 'b': false, 'e': 0},
        {'x': 250, 'y': 180, 's': false, 'b': false, 'e': 0},
        {'x': 200, 'y': 180, 's': false, 'b': false, 'e': 0},
        {'x': 150, 'y': 180, 's': false, 'b': false, 'e': 0},
        {'x': 100, 'y': 180, 's': false, 'b': false, 'e': 0},
        {'x': 50, 'y': 180, 's': false, 'b': false, 'e': 0},
        {'x': 0, 'y': 180, 's': false, 'b': false, 'e': 2},
        //5th Row

        {'x': 0, 'y': 240, 's': false, 'b': false, 'e': 4},
        {'x': 50, 'y': 240, 's': false, 'b': false, 'e': 0},
        {'x': 100, 'y': 240, 's': false, 'b': false, 'e': 0},
        {'x': 150, 'y': 240, 's': false, 'b': false, 'e': 0},
        {'x': 200, 'y': 240, 's': false, 'b': false, 'e': 0},
        {'x': 250, 'y': 240, 's': false, 'b': false, 'e': 0},
        {'x': 300, 'y': 240, 's': false, 'b': false, 'e': 0},
        {'x': 350, 'y': 240, 's': false, 'b': false, 'e': 0},
        {'x': 400, 'y': 240, 's': false, 'b': false, 'e': 0},
        {'x': 450, 'y': 240, 's': false, 'b': false, 'e': 2},
        //Sixth Row
        {'x': 450, 'y': 300, 's': false, 'b': false, 'e': 4},
        {'x': 400, 'y': 300, 's': false, 'b': false, 'e': 0},
        {'x': 350, 'y': 300, 's': false, 'b': false, 'e': 0},
        {'x': 300, 'y': 300, 's': false, 'b': false, 'e': 0},
        {'x': 250, 'y': 300, 's': false, 'b': false, 'e': 0},
        {'x': 200, 'y': 300, 's': false, 'b': false, 'e': 0},
        {'x': 150, 'y': 300, 's': false, 'b': false, 'e': 0},
        {'x': 100, 'y': 300, 's': false, 'b': true, 'e': 0},
        {'x': 50, 'y': 300, 's': false, 'b': false, 'e': 0},
        {'x': 0, 'y': 300, 's': false, 'b': false, 'e': 2},
        //Seventh Row
        {'x': 0, 'y': 360, 's': false, 'b': false, 'e': 4},
        {'x': 50, 'y': 360, 's': false, 'b': false, 'e': 0},
        {'x': 100, 'y': 360, 's': false, 'b': false, 'e': 0},
        {'x': 150, 'y': 360, 's': false, 'b': false, 'e': 0},
        {'x': 200, 'y': 360, 's': false, 'b': true, 'e': 0},
        {'x': 250, 'y': 360, 's': false, 'b': false, 'e': 0},
        {'x': 300, 'y': 360, 's': false, 'b': true, 'e': 0},
        {'x': 350, 'y': 360, 's': false, 'b': false, 'e': 0},
        {'x': 400, 'y': 360, 's': false, 'b': false, 'e': 0},
        {'x': 450, 'y': 360, 's': false, 'b': false, 'e': 2},
        //Eight Row
        {'x': 450, 'y': 420, 's': false, 'b': false, 'e': 4},
        {'x': 400, 'y': 420, 's': false, 'b': false, 'e': 0},
        {'x': 350, 'y': 420, 's': false, 'b': false, 'e': 0},
        {'x': 300, 'y': 420, 's': false, 'b': false, 'e': 0},
        {'x': 250, 'y': 420, 's': false, 'b': false, 'e': 0},
        {'x': 200, 'y': 420, 's': false, 'b': false, 'e': 0},
        {'x': 150, 'y': 420, 's': false, 'b': false, 'e': 0},
        {'x': 100, 'y': 420, 's': false, 'b': false, 'e': 0},
        {'x': 50, 'y': 420, 's': false, 'b': false, 'e': 0},
        {'x': 0, 'y': 420, 's': false, 'b': false, 'e': 2},
        //Nineth Row
        {'x': 0, 'y': 480, 's': false, 'b': false, 'e': 4},
        {'x': 50, 'y': 480, 's': false, 'b': false, 'e': 0},
        {'x': 100, 'y': 480, 's': false, 'b': false, 'e': 0},
        {'x': 150, 'y': 480, 's': false, 'b': false, 'e': 0},
        {'x': 200, 'y': 480, 's': false, 'b': false, 'e': 0},
        {'x': 250, 'y': 480, 's': true, 'b': false, 'e': 0},
        {'x': 300, 'y': 480, 's': false, 'b': false, 'e': 0},
        {'x': 350, 'y': 480, 's': false, 'b': false, 'e': 0},
        {'x': 400, 'y': 480, 's': false, 'b': true, 'e': 0},
        {'x': 450, 'y': 480, 's': false, 'b': false, 'e': 2},
        //Tenth Row
        {'x': 450, 'y': 540, 's': false, 'b': false, 'e': 4},
        {'x': 400, 'y': 540, 's': false, 'b': false, 'e': 0},
        {'x': 350, 'y': 540, 's': false, 'b': false, 'e': 0},
        {'x': 300, 'y': 540, 's': false, 'b': false, 'e': 0},
        {'x': 250, 'y': 540, 's': false, 'b': false, 'e': 0},
        {'x': 200, 'y': 540, 's': false, 'b': true, 'e': 0},
        {'x': 150, 'y': 540, 's': false, 'b': false, 'e': 0},
        {'x': 100, 'y': 540, 's': false, 'b': false, 'e': 0},
        {'x': 50, 'y': 540, 's': false, 'b': false, 'e': 0},
        {'x': 0, 'y': 540, 's': false, 'b': false, 'e': 0}
    ]
};
var roadArray = [];
var carArray = [];

/*
 This code is written in order to load Images before the program begins.
 */

function loadImages(sources, callback) {
    var assetDir = 'images/';
    var images = {};
    var loadedImages = 0;
    var numImages = 0;
    for (var src in sources) {
        numImages++;
    }
    for (var src in sources) {
        images[src] = new Image();
        images[src].onload = function() {
            if (++loadedImages >= numImages) {
                callback(images);
            }
        };
        images[src].src = assetDir + sources[src];
    }
}
/*Loading of the image sources*/
var sources = {
    grass: 'grass.jpg',
    roadPatch: 'Roads.png',
    cars: 'Cars.png',
    bomb: 'signal.png',
    car1: 'car1.png',
    car2: 'car2.png',
    car3: 'car3.png',
    car4: 'car4.png',
    car5: 'car5.png',
    car6: 'car6.png',
    winner: 'winner.jpg',
    booster: 'booster.png',
    roadendl: 'RoadEndv2.png',
    roadendr: 'RoadEndv1.png',
    roadendo: 'RoadEnd.png',
    roadendb: 'Roads2.png'
};
loadImages(sources, initStage);


/*
 Declaration of Road,Since the Road will be in 
 both the directions I would be making an algorithm 
 to get the road on the canvas and
 the the car onto it.
 */

function Car() {
}

Car.prototype = {
    x: 0,
    y: 0,
    position: 0,
    driver: 0,
    booster: true,
    positionNext: 0,
    carInstance: null,
    drawCar: function(carNo, stage, roadLayer, images) {
        //Compare whether car with No already Exists
        var similar = false;
        for (var i = 0; i < carArray.length; i++)
        {
            if (carArray[i].driver == carNo)
            {
                similar = true;
            }
        }
        //In order to select the Right Image
        if (similar == false)
        {
            var carImage;
            switch (carNo)
            {
                case 1:
                    var carImage = images.car1;
                    break;
                case 2:
                    var carImage = images.car2;
                    break;
                case 3:
                    var carImage = images.car3;
                    break;
                case 4:
                    var carImage = images.car4;
                    break;
                case 5:
                    var carImage = images.car5;
                    break;
                case 6:
                    var carImage = images.car6;
                    break;
            }
            var car = new Kinetic.Image({
                x: roadArray[0].x + Math.round(Math.random() * 40),
                y: roadArray[0].y + Math.round(Math.random() * 40),
                image: carImage,
                width: 35,
                height: 15
            });
            this.carInstance = car;
            this.driver = carNo;
            this.position = 0;
            roadLayer.add(car);
            stage.add(roadLayer);
        }
        else {
            console.log('Car Already Added');
        }
    },
    drive: function(newPosition) {/*Code to steer the car to the new box. Either 
     Animate or keep Dynamic*/
    },
    checkForBooster: function() {
        var boosterStatus = roadArray[this.position].getBooster();
        if (boosterStatus === true)
        {
            return true;
        }
        else
        {
            return false;
        }
    },
    checkForBomb: function() {
        var roadArrStatus = roadArray[this.position].getBomb();
        if (roadArrStatus === true)
        {
            return true;
        }
        else
            return false;
    }
};
/*Winners Lane*/
function WinnersLane() {
}
WinnersLane.prototype = {
    drawWinnersLane: function(winnerLayer, stage, images) {
        var winnersFlag = new Kinetic.Image({
            x: 10,
            y: 20,
            image: images.winners,
            width: 100,
            height: 55
        });
        winnerLayer.add(winnersFlag);
        stage.add(winnerLayer);
    }
};
/*Road Block Class*/
function Road() {
}
Road.prototype = {
    x: 0,
    y: 0,
    bombX: 0,
    bombY: 0,
    bomb: false,
    booster: false,
    position: 0,
    roadInstance: null,
    bombInstance: null,
    booster:false,
            boosterX: 0,
    boosterY: 0,
    boosterInstance: null,
    drawBomb: function(stage, roadLayer, images, grid) {

        var placeBomb = new Kinetic.Image({
            x: grid[0],
            y: grid[1],
            image: images.bomb,
            width: 40,
            height: 10,
            title: 'Bomb'
        });
        this.bombX = grid[0];
        this.bombY = grid[1];
        this.bombInstance = placeBomb;
        roadLayer.add(placeBomb);
        stage.add(roadLayer);

    },
    drawRoadPatch: function(roadLayer, stage, images, grid, position) {
        var roadPatch = new Kinetic.Image({
            x: grid.x,
            y: grid.y,
            image: images.roadPatch,
            width: 60,
            height: 60
        });
        var roadEndl = new Kinetic.Image({
            x: grid.x + 5,
            y: grid.y,
            image: images.roadendl,
            width: 50,
            height: 60
        });
        var roadEndr = new Kinetic.Image({
            x: grid.x + 5,
            y: grid.y,
            image: images.roadendr,
            width: 50,
            height: 60
        });
        var roadEndo = new Kinetic.Image({
            x: grid.x + 5,
            y: grid.y,
            image: images.roadendo,
            width: 50,
            height: 60
        });
        var roadEndb = new Kinetic.Image({
            x: grid.x + 5,
            y: grid.y,
            image: images.roadendb,
            width: 50,
            height: 60
        });
        var winnersFlag = new Kinetic.Image({
            x: 5,
            y: 540,
            image: images.winner,
            width: 50,
            height: 60,
        });
        this.x = grid.x;
        // console.log("X:"+grid.x)
        this.y = grid.y;
        //console.log("Y:"+grid.y)
        this.roadInstance = roadPatch;
        this.booster = grid.b;
        this.bomb = grid.s;
        this.position = position;
        roadLayer.add(roadPatch);
        stage.add(roadLayer);
        if (grid.e == 1)
        {
            this.roadInstance = roadEndl;
            roadLayer.add(roadEndl)
            stage.add(roadLayer);
        }
        else if (grid.e == 2)
        {
            this.roadInstance = roadEndr;
            roadLayer.add(roadEndr)
            stage.add(roadLayer);
        }
        else if (grid.e == 3)
        {
            this.roadInstance = roadEndo;
            roadLayer.add(roadEndo)
            stage.add(roadLayer);
        }
        else if (grid.e == 4)
        {
            this.roadInstance = roadEndb;
            roadLayer.add(roadEndb)
            stage.add(roadLayer);
        }
        if (grid.x == 0 && grid.y == 540)
        {
            roadLayer.add(winnersFlag);
            stage.add(roadLayer);
        }
    }
};

/*Grass For Background*/
function Grass() {
}
Grass.prototype = {
    grassImage: '',
    grassX: 0,
    grassY: 0,
    grassWidth: 700,
    grassHeight: 700,
    /*Grass Utility Fuctions*/
    drawGrass: function(background, stage, image) {
        var grass = new Kinetic.Image({
            x: this.grassX,
            y: this.grassY,
            image: image.grass,
            width: this.grassWidth,
            height: this.grassHeight
        });
        // background.add(grass);
        stage.add(background);
    },
    changeBackgroud: function(background, stage, image) {
        //This can be used to change the backgroud of page  
    }

};



/**/
function initStage(images) {

    /*Declaring the Stage*/
    var stage = new Kinetic.Stage({
        width: 520,
        height: 620,
        container: 'gamestage'
    });
    var backgroundImage = new Image();
    var roadImage = new Image();

    /*Defining the Layer (Layers)*/
    var background = new Kinetic.Layer();
    var winnerLayer = new Kinetic.Layer({
        x: 0,
        y: 560
    });
    var roadLayer = new Kinetic.Layer({
        x: 0,
        y: 0
    });

    /*Declaring the Grass as the background object*/
    var backgrass = new Grass();
    backgrass.drawGrass(background, stage, images);

    /*Drawing Winners*/
    var winnersLane = new WinnersLane();
    winnersLane.drawWinnersLane(winnerLayer, stage, images);

    /*Drawing Road*/

    for (var i = 0; i < path.grid.length; i++)
    {
        var road = new Road();
        road.drawRoadPatch(roadLayer, stage, images, path.grid[i], i);

        //road.drawBooster(stage,roadLayer,images,path.grid[i]);
        roadArray.push(road);
    }



    UB = {
        addCar: function(carNo) {
            if (carArray.length < 6)
            {
                var car = new Car();
                car.drawCar(carNo, stage, roadLayer, images);
                carArray.push(car);

            }
            else {
                console.log("There are already six players playing");
            }
        },
        removeCar: function() {
        },
        moveCar: function(carNo, position) {
            var roadPatch = roadArray[position];
            for (var i = 0; i < carArray.length; i++)
            {
                if (carNo == carArray[i].driver)
                {
                    xcoordi = roadPatch.x + Math.round(Math.random() * 40);
                    ycoordi = roadPatch.y + Math.round(Math.random() * 40);
                    carArray[i].carInstance.transitionTo({
                        x: xcoordi,
                        y: ycoordi,
                        duration: 1
                    });
                    carArray[i].position = position;
                    //Bomb Detection
                    if (roadArray[position].bomb === true)
                    {
                        return 0;
                    }
                    if (roadArray[position].booster === true)
                    {
                        return 1;
                    }
                    else {
                        return 2;
                    }
                }
            }
        },
        getCarLocation: function(carNo) {
            for (var i = 0; i < carArray.length; i++)
            {
                if (carArray[i].driver == carNo)
                {
                    return carArray[i].position;
                }
            }
        },
        addSignal: function(grid) {
            road.drawBomb(stage, roadLayer, images, grid);
        }
    }
}