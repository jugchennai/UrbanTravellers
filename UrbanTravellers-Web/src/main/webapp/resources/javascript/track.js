$(document).ready(function(){
    
    //try using require js in order to remove this kind of path directive or make some code that can generate the same.
    var path={
    grid:[
    //1st Row
    {'x':0,'y':0},
    {'x':50,'y':0},
    {'x':100,'y':0},
    {'x':150,'y':0},
    {'x':200,'y':0},
    {'x':250,'y':0},
    {'x':300,'y':0},
    {'x':350,'y':0},
    {'x':400,'y':0},
    {'x':450,'y':0},
    //2nd Row
    {'x':450,'y':60},
    {'x':400,'y':60},
    {'x':350,'y':60},
    {'x':300,'y':60},
    {'x':250,'y':60},
    {'x':200,'y':60},
    {'x':150,'y':60},
    {'x':100,'y':60},
    {'x':50,'y':60},
    {'x':0,'y':60},
    //3rd Row
    {'x':0,'y':120},
    {'x':50,'y':120},
    {'x':100,'y':120},
    {'x':150,'y':120},
    {'x':200,'y':120},
    {'x':250,'y':120},
    {'x':300,'y':120},
    {'x':350,'y':120},
    {'x':400,'y':120},
    {'x':450,'y':120},
    //4th Row
    {'x':450,'y':180},
    {'x':400,'y':180},
    {'x':350,'y':180},
    {'x':300,'y':180},
    {'x':250,'y':180},
    {'x':200,'y':180},
    {'x':150,'y':180},
    {'x':100,'y':180},
    {'x':50,'y':180},
    {'x':0,'y':180},
    //5th Row

    {'x':0,'y':240},
    {'x':50,'y':240},
    {'x':100,'y':240},
    {'x':150,'y':240},
    {'x':200,'y':240},
    {'x':250,'y':240},
    {'x':300,'y':240},
    {'x':350,'y':240},
    {'x':400,'y':240},
    {'x':450,'y':240},
    
    //Sixth Row
    {'x':450,'y':300},
    {'x':400,'y':300},
    {'x':350,'y':300},
    {'x':300,'y':300},
    {'x':250,'y':300},
    {'x':200,'y':300},
    {'x':150,'y':300},
    {'x':100,'y':300},
    {'x':50,'y':300},
    {'x':0,'y':300},
    
    //Seventh Row
    {'x':0,'y':360},
    {'x':50,'y':360},
    {'x':100,'y':360},
    {'x':150,'y':360},
    {'x':200,'y':360},
    {'x':250,'y':360},
    {'x':300,'y':360},
    {'x':350,'y':360},
    {'x':400,'y':360},
    {'x':450,'y':360},
    
    //Eight Row
    {'x':450,'y':420},
    {'x':400,'y':420},
    {'x':350,'y':420},
    {'x':300,'y':420},
    {'x':250,'y':420},
    {'x':200,'y':420},
    {'x':150,'y':420},
    {'x':100,'y':420},
    {'x':50,'y':420},
    {'x':0,'y':420},
    
    //Nineth Row
    {'x':0,'y':480},
    {'x':50,'y':480},
    {'x':100,'y':480},
    {'x':150,'y':480},
    {'x':200,'y':480},
    {'x':250,'y':480},
    {'x':300,'y':480},
    {'x':350,'y':480},
    {'x':400,'y':480},
    {'x':450,'y':480},
    
    //Tenth Row
   {'x':450,'y':540},
    {'x':400,'y':540},
    {'x':350,'y':540},
    {'x':300,'y':540},
    {'x':250,'y':540},
    {'x':200,'y':540},
    {'x':150,'y':540},
    {'x':100,'y':540},
    {'x':50,'y':540},
    {'x':0,'y':540}   
    ]
};


/*Actual Code Starts here. The above can be referenced by just using an Ajax Request*/

    
var Paper = new Raphael('canvas',500,600);

var elementArray=[];

//Global function to update the car location
CarLocation=function(options){
    for (var i = elementArray.length - 1; i >= 0; i--) {
        elementArray[i].remove();
    };
    for (var i = 0;i<options.cars.length;i++) {
        if(options.cars[i].exist)
        {
            block=options.cars[i].block-1;//Since We are referring to an array and count starts from 0
            var cx=path.grid[block].x+Math.round(Math.random()*30);
            var cy=path.grid[block].y+Math.round(Math.random()*40);
//<<<<<<< HEAD
            //elementArray.push(Paper.image(options.cars[i].src, cx,cy,20,20));
            //elementArray[0].transform("");
//=======

            elementArray.push(Paper.image(options.cars[i].src, cx,cy,40,40));
            elementArray.push(Paper.image("img/start.jpeg",0,545,55,55));
            //elementArray[0].transform("r180");
//>>>>>>> a4475fe98cd50d1644544c0cfb3f86228f5db82a


        }
    };

}


//RoadPatch Class that handles most of the functions as well as the Object specific code
var RoadPatch=function(){};
RoadPatch.prototype.settings={
                            'sidewalkWidth': 5,
                            'sidewalkLength': 50,
                            'sidewalkColor': 'brown',
                            'RoadPatchWidth': 50,
                            'RoadPatchLength': 50,
                            'RoadPatchColor': 'black',
                            'roadStripLength': 20,
                            'roadStripWidth': 5,
                            'roadStripColor': '#FFFFFF'
                            };
RoadPatch.prototype.getSettings=function(){return this.settings;};


var upperStrip=function(RoadPatch,Paper,grid){
    //Upper Strip Sidewalk
    Paper.rect(grid.x,grid.y,RoadPatch.getSettings().sidewalkLength,RoadPatch.getSettings().sidewalkWidth).attr({
        'fill':RoadPatch.getSettings().sidewalkColor
    });
}

var lowerStrip=function(RoadPatch,Paper,grid){
    //Lower Strip Sidewalk
    Paper.rect(grid.x,grid.y+RoadPatch.getSettings().sidewalkWidth+RoadPatch.getSettings().RoadPatchWidth,RoadPatch.getSettings().sidewalkLength,RoadPatch.getSettings().sidewalkWidth).attr({
        'fill':RoadPatch.getSettings().sidewalkColor
    });
};

//Generates the Strips on the Road
var stripBuilder=function(RoadPatch,Paper,grid){
                    return Paper.rect((0.2*RoadPatch.getSettings().RoadPatchLength)+grid.x, (0.4*RoadPatch.getSettings().RoadPatchWidth)+grid.y+RoadPatch.getSettings().sidewalkWidth, RoadPatch.getSettings().roadStripLength, RoadPatch.getSettings().roadStripWidth).attr({
                                    'fill': 'white'
                                });
 
                           };
//Generated the Road
var roadBuilder=function(RoadPatch,Paper,grid){
                    return Paper.rect(grid.x,grid.y+RoadPatch.getSettings().sidewalkWidth, RoadPatch.getSettings().RoadPatchLength, RoadPatch.getSettings().RoadPatchWidth).attr({
                            'fill': '#3D6E99',
                            'stroke': '#3D6E99'
                        });
                       
                    };
//Initialization of the Road
var init=function(RoadPatch,Paper,grid){
                roadBuilder(RoadPatch,Paper,grid);
                stripBuilder(RoadPatch,Paper,grid);
                upperStrip(RoadPatch,Paper,grid);
                lowerStrip(RoadPatch,Paper,grid);
                
}

//Setting of Signal deals with just drawing a spot at the lane where the signal is called for.The signal may be an array of places



//Bootstrap the game using this set of code
    
    
    
    
    
    /*API Preperation using the Factory Pattern and Modularization
      In this approach we have one Global Variable called UB alias
      The Urban Traveller and most of the thigs would be handled
      by this global variable. I have to modularize the code for 
      the UI.
    */
    UB={
        //To initialise or Bootstrap the Game.
        init:function(signalId,bannerId){
            for(var i=0;i<path.grid.length;i++)
            {
                var a = new RoadPatch();
                init(a,Paper,path.grid[i]);
            }
             var barrier=[];
                //In order to get the location of the signal which ranges from 0-99
                
                for(var i=0;i<signalId.record.length;i++)
                {
                     var tempPath=path.grid[signalId.record[i].id];
                     barrier.push(Paper.rect(tempPath.x,tempPath.y,50,55).attr({'fill':'red'}));
                }
                for(var i=0;i<bannerId.record.length;i++)
                {
                     var tempPath=path.grid[bannerId.record[i].id];
                     barrier.push(Paper.rect(tempPath.x,tempPath.y,50,55).attr({'fill':'yellow'}));
                }
               //Returns a Array that can be used to add or delete the barriers
                return barrier;    
            
                },
        
        /*
        This is used in order to call the signal object on certain block.
        The signal state should be maintained by usage of a queue and should be updated
        */
        setSignal:function(signalId,signalType){
            setSignal(signalId);
        },
        
        /*This is used in order to unset the signal of a specific space and should be called when its required to be updated*/
        unsetSignal:function(){},
        
        /*This would return a boolean value stating whether a specific signal is updated in a certain area*/
        getSignal:function(){},
        
        /*
        This would be there as an observer in order to maintain the fresh score from all the respective units.
        This would serve to update the score of a specific user whereas all the other scores would be taken care
        of from the front end.
        */
        refreshScore:function(){},
        
        /*Get the location of a specific player. This would enable us to get value of any specific player at any point of time*/
        getLocation:function(){
            /*This can be done by using the initial JSON for setting the cars to zero position and then
              bringing them in order to get or change the count
            */
        },
        
        /*
        This would return all the possible values with respect to the board. Coule be consumed with AJAX or websocket 
        ... not sure about websocket but surely by AJAX. This would return all the realtime values.    
        */
        getAllData:function(){}
    };
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
});
