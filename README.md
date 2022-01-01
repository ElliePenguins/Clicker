# Clicker
Automate mouse clicks.


This is a simple Java GUI program that can automate moving your mouse and/or clicking wherever you set it to.
This program can be built into an executable jar file and should be portable between machines with the same java version.

## build
To build for linux:

In the repository you can build this with:
```
javac *.java
```
and run it with:
```
java Clicker
```

You can build it into a jar file with:
```
Javac *.java
jar cfve Clicker.jar Clicker *.class
```
and run it with:
```
java -jar Clicker.jar
```
<br/>
Being careful what java version it is built with,
and the version running on the intended target you
should be able to run this jar on another machine,
including windows. This also seems to build well in eclipse.

<hr/>

## Manual:

Assuming you have a successful build or are provided with one. Running the Program should provide you with somthing similar to this:

![Gui Example](https://github.com/ElliePenguins/Clicker/blob/main/images/image.jpg)

The empty white text space on the left will display a list of locations the mouse will move too and optionally clicked on.

### The Check boxes on the right include:

##### Radomized Time:
Checking this will move or click on the set locations at a random time between 1 minute and the value in the set Delay option lower on the screen.

##### Randomize Clicks:
This program clicks through the locations in order unless this check is clicked. In which case it will then select through them at random. This option does have the chance to select the same location twice, which may or may not be desirable.

##### Click/Move:
Selecting this option will click at the location, unselecting it will only move the mouse to that location.

##### Delayed Start:
This option will start the run on a delay meaning wait and then click/move. Unselected will trigger a move/click immediately after the run/stop button is pressed.

### The selectors, below the checkboxes:

##### Set Delay:
This is how long after you click the "set" button does it log the mouses current location. It is in seconds and if you find you cannot get your mouse on the location quickly enough; raise this number.

##### Run Delay:
This is how quickly each of the locations are iterated through, It is in minutes.

### The bottom buttons:

##### Set:
This is used to initiate a location to be added to the list.

##### Clear:
This is used to remove a location from the list. If a location is highlighted (clicked on) it will remove that one, if not it will remove the most recently added location.

##### Run/Stop
This is a toggle button that will start the application running, meaning moving and clicking around on the screen. Click it again to stop the clicking.

##### Exit
This closes the application
