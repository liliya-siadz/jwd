# jwd - ConsoleTask
<i>*all commets start and end by "//" symbol <br>
*all paths start and end by "^" symbol <br>
*code in files "Point.java" and "Main.java" have had prepared<br>
*jars with libraries have had downloaded</i><br>

<b>1. Create 2 packages: "com.epam.jwd.app" and "com.epam.jwd.model"</b>

- mkdir HWConsole\src  // create project folder and "src" folder//
- cd HWConsole\src	 // go into folder "src"//
- mkdir com\epam\jwd	 // create subfolders "com\epam\jwd"//
- cd com\epam\jwd mkdir app model 	//go into folders "com\epam\jwd"//
 mkdir app model 	// create folders "app" and "model" in one place//

<b>1.1 Put file "Point.java" into package "model"</b>
(^ full path to Point java is: <C:\Users\l.sidelnikova\Desktop\items\Point.java>
 ^ full path to package "model" is:  <C:\Users\l.sidelnikova\Desktop\ConsoleTask\HWConsole\src\com\epam\jwd\model>)

- copy C:\Users\l.sidelnikova\Desktop\items\Point.java C:\Users\l.sidelnikova\Desktop\ConsoleTask\HWConsole\src\com\epam\jwd\model
 //copy file from one destion to another. (It could rather be "move" command. If we used it in our context would be: - move Point.java C:\Users\l.sidelnikova\Desktop\ConsoleTask\HWConsole\src\com\epam\jwd\model )//

<b>1.2 Put file "Main.java" into package "model"</b>
//Similary point 1.1//
(^ full path to Main.java is: <C:\Users\l.sidelnikova\Desktop\items\Main.java>)
- copy C:\Users\l.sidelnikova\Desktop\items\Main.java C:\Users\l.sidelnikova\Desktop\ConsoleTask\HWConsole\src\com\epam\jwd\app

<b>2. All log-libraires packaged into jar-containers put into "lib" folder in project's root</b>
(we used slf4j log util
 we have two jar files: "slf4j-api-1.6.0.jar" and "slf4j-simple-1.6.0.jar")
^full path to these files folder is <C:\Users\l.sidelnikova\Desktop\items\slf4j> )
- cd C:\Users\l.sidelnikova\Desktop\ConsoleTask\HWConsole\ // go to root folder //
- mkdir lib // create "lib" folder //
- cd lib // go to "lib" folder //
- jar cvf slf4.jar C:\Users\l.sidelnikova\Desktop\items\slf4j\slf4j-api-1.6.0.jar C:\Users\l.sidelnikova\Desktop\items\slf4j\slf4j-simple-1.6.0.jar

 // create slf4j.jar inside "lib" folder from jar files that place outside //

<b>3. Compile application using libraries in "lib folder
4. Place compiled .class files inside "app" folder in project's root</b>
- javac -cp lib\slf4j-simple-1.6.0.jar;lib\slf4j-api-1.6.0.jar -d app src\com\epam\jwd\model\Point.java src\com\epam\jwd\app\Main.java // flag "-d app" means place compiled files to folder "app" //

<b>5. Folders /lib and /app (with compiled files) place to another place and execute using console</b>
(^full path to our folders are <C:\Users\l.sidelnikova\Desktop\ConsoleTask\HWConsole\app> 
and <C:\Users\l.sidelnikova\Desktop\ConsoleTask\HWConsole\lib
^full path of our new place <C:\Users\l.sidelnikova\Desktop\ConsoleTask\HWConsole-compiled >

- cd C:\Users\l.sidelnikova\Desktop\ConsoleTask\HWConsole // go to root of project //
- сd ../ // go to up folder //
- mkdir HWConsole-compiled //create new folder where we will place out folders
- move HWConsole\app HWConsole-compiled // move "app" folder to new place (we used short path) //
- move HWConsole\lib HWConsole-compiled //move "lib" folder to new place (we used short path) //

- cd C:\Users\l.sidelnikova\Desktop\ConsoleTask\HWConsole-compiled //go to new place folder //
- java -classpath app;lib\slf4j-simple-1.6.0.jar;lib\slf4j-api-1.6.0.jar app.Main // execute application using console //
