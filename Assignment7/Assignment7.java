package application;

//Assignment #: Arizona State University CSE205
//Name: Madhav Arun Sharma
//StudentID: 1216873476
//Lecture: MW 4:35 pm
//Description: The Assignment7 class creates a PaneWithRectangles object
//    on which we can draw rectangles with different
//    colors.


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class Assignment7 extends Application
{
public void start(Stage primaryStage)
{
//create a PaneWithRactangles object. 
PaneWithRectangles gui = new PaneWithRectangles();

//put gui on top of the rootPane
StackPane rootPane = new StackPane();
rootPane.getChildren().add(gui);

// Create a scene and place rootPane in the stage
Scene scene = new Scene(rootPane, 600, 400);
primaryStage.setTitle("Color Grids"); 
primaryStage.setScene(scene); // Place the scene in the stage
primaryStage.show(); // Display the stage
}
public static void main(String[] args)
{
Application.launch(args);
}
}
