package application;

//Assignment #: Arizona State University CSE205
//Name: Madhav Arun Sharma
//StudentID: 1216873476
//Lecture: MW 4:35 pm
//Description: PaneWithRectangles class creates a pane where we can use
//    mouse key to drag on grids and there will be some color following
//    the mouse. We can also use combo boxes to change its colors and stroke widths

//import any classes necessary here
//----
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


public class PaneWithRectangles extends BorderPane
{
private ComboBox<String> primaryColorCombo;
private ComboBox<String> backColorCombo;
private ComboBox<String> widthCombo;

private Color primaryColor, secondaryColor, backgroundColor;
private double selectWidth;

//declaring variables for handlers
MouseHandler mouseHandle;
PrimColorHandler primColorHandle;
BackColorHandler backColorHandle;
WidthHandler widthHandle;

private Rectangle[][] rectArray;
private double height, width; 

public PaneWithRectangles()
{
primaryColor = Color.BLACK;
secondaryColor = Color.GRAY;
backgroundColor = Color.WHITE;
selectWidth = 1.0;

//Instantiate and initialize labels, combo boxes
Label primaryColorLabel = new Label ("PrimaryColor");
Label backColorLabel = new Label ("BackgroundColor");
Label widthLabel = new Label ("StrokeWidth");

//values for primaryColorCombo box
String colors[] = {"Black", "Blue", "Red", "Green"};

//initializing the primaryColorCombo box
primaryColorCombo = new ComboBox<String>();
primaryColorCombo.setMinWidth(100);

//setting the value of string to primaryColorCombo box
for (int i = 0; i < colors.length; i++) {
	primaryColorCombo.getItems().add(colors[i]);
}
primaryColorCombo.getSelectionModel().select("Black");

//values for backColorCombo box
String backcolors[] = {"White", "Yellow", "Orange"};

//initializing the backColorCombo box
backColorCombo = new ComboBox<String>();
backColorCombo.setMinWidth(100);

//setting the value of string to backColorCombo box
for (int i = 0; i < backcolors.length; i++) {
	backColorCombo.getItems().add(backcolors[i]);
}
backColorCombo.getSelectionModel().select("White");

//values for widthCombo box
String rectWidth[] = {"1", "3", "5", "7"};

//initializing the widthCombo box
widthCombo = new ComboBox<String>();

//setting the value of string to widthCombo box
for (int i = 0; i < rectWidth.length; i++) {
	widthCombo.getItems().add(rectWidth[i]);
}
widthCombo.getSelectionModel().select("1");

//Instantiate and initialize the two dimensional array rectArray
//to contain 7 columns and 7 rows (49 rectangles total)
//It is recommended to use nested loops

height = 390/7;
width = 470/7;

rectArray = new Rectangle[7][7];

rectArray[0][0] = new Rectangle();

for(int i = 0; i<rectArray.length; i++) {
	for(int j = 0; j<rectArray.length; j++) {
		rectArray[i][j] = new Rectangle();
		rectArray[i][j].setWidth(width);
		rectArray[i][j].setHeight(height);
		rectArray[i][j].setFill(backgroundColor);
		rectArray[i][j].setStroke(Color.BLACK);
	}
}


//grid is a GridPane containing 49 rectangles.
GridPane grid = new GridPane();
//---- add 49 rectangles to the grid pane, it is recommended to use nested loops
//----
//----
for (int i = 0; i < 7; i++) {
	for (int j = 0; j < 7; j++) {
		grid.add(rectArray[i][j], i, j);
	}
}

//leftPane is a VBox, it should contain labels and combo boxes
VBox leftPane = new VBox();

//adding labels and combo boxes to the left pane
leftPane.getChildren().addAll(primaryColorLabel, primaryColorCombo, backColorLabel, backColorCombo, widthLabel, widthCombo);
leftPane.setSpacing(20);
leftPane.setPadding(new Insets(10, 0, 10, 0));

//add the left pane to the left of the pane
//and the grid pane contains rectangles at the center
this.setLeft(leftPane);
this.setCenter(grid);

//defining object of MouseHandler
mouseHandle = new MouseHandler();

grid.setOnMouseDragged(new MouseHandler());
grid.setOnMousePressed(new MouseHandler());
grid.setOnMouseReleased(new MouseHandler());

//----
//----
//----

//defining object of PrimColorHandler
primColorHandle = new PrimColorHandler();
primaryColorCombo.setOnAction(primColorHandle);

//defining object of BackColorHandler
backColorHandle = new BackColorHandler();
backColorCombo.setOnAction(backColorHandle);

//defining object of WidthHandler
widthHandle = new WidthHandler();
widthCombo.setOnAction(widthHandle);

}


//Step #2(A) - MouseHandler
private class MouseHandler implements EventHandler<MouseEvent>
{
public void handle(MouseEvent event)
{
 //handle MouseEvent here
 //Note: you can use if(event.getEventType()== MouseEvent.MOUSE_DRAGGED)
 //to check whether the mouse key is dragged
 //write your own codes here
 //----
	
 if(event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
	 
	 //taking x and y coordinates of the mouse pointer
	 double xCoordinate = event.getX();
	 double yCoordinate = event.getY();
	 
	 int x = (int) (xCoordinate / (470/7));
	 int y = (int) (yCoordinate / (390/7));
	 
	 for(int i = 0; i < 7; i++) {
		 for(int j = 0; j < 7; j++) {
			 rectArray[i][j].setFill(backgroundColor);
		 }
	 }
	 
	 //to avoid out of bounds exception
	 if(x >= 0 && x <= 6 && y >= 0 && y <= 6) {
	 
	 //when the mouse pointer is in a rectangle on the left border
	 if(x == 0 && y != 0 && y != 6) {
		 rectArray[x][y].setFill(primaryColor);
		 rectArray[x][y-1].setFill(secondaryColor);
		 rectArray[x][y+1].setFill(secondaryColor);
		 rectArray[x+1][y].setFill(secondaryColor);
	 }
	 
	//when the mouse pointer is in a rectangle on the right border
	 else if(x == 6 && y != 0 && y != 6) {
		 rectArray[x][y].setFill(primaryColor);
		 rectArray[x][y-1].setFill(secondaryColor);
		 rectArray[x][y+1].setFill(secondaryColor);
		 rectArray[x-1][y].setFill(secondaryColor);
	 }
	 
	//when the mouse pointer is in a rectangle on the top border
	 else if(y == 0 && x != 0 && x != 6) {
		 rectArray[x][y].setFill(primaryColor);
		 rectArray[x][y+1].setFill(secondaryColor);
		 rectArray[x+1][y].setFill(secondaryColor);
		 rectArray[x-1][y].setFill(secondaryColor);
	 }
	 
	//when the mouse pointer is in a rectangle on the bottom border
	 else if(y == 6 && x != 0 && x != 6) {
		 rectArray[x][y].setFill(primaryColor);
		 rectArray[x][y-1].setFill(secondaryColor);
		 rectArray[x+1][y].setFill(secondaryColor);
		 rectArray[x-1][y].setFill(secondaryColor);
	 }
	 
	//when the mouse pointer is in a rectangle on the bottom-left corner
	 else if(x == 6 && y == 0) {
		 rectArray[x][y].setFill(primaryColor);
		 rectArray[x-1][y].setFill(secondaryColor);
		 rectArray[x][y+1].setFill(secondaryColor);
	 }
	 
	//when the mouse pointer is in a rectangle on the bottom-right corner
	 else if(x == 6 && y ==6) {
		 rectArray[x][y].setFill(primaryColor);
		 rectArray[x-1][y].setFill(secondaryColor);
		 rectArray[x][y-1].setFill(secondaryColor);
	 }
	 
	//when the mouse pointer is in a rectangle on the top-left corner
	 else if(x == 0 && y ==0) {
		 rectArray[x][y].setFill(primaryColor);
		 rectArray[x+1][y].setFill(secondaryColor);
		 rectArray[x][y+1].setFill(secondaryColor);
	 }
	 
	//when the mouse pointer is in a rectangle on the top-right corner
	 else if(x == 0 && y ==6) {
		 rectArray[x][y].setFill(primaryColor);
		 rectArray[x+1][y].setFill(secondaryColor);
		 rectArray[x][y-1].setFill(secondaryColor);
	 }
	 
	//when the mouse pointer is in any rectangle other than the borders or corners
	 else {
		 rectArray[x][y].setFill(primaryColor);
		 rectArray[x+1][y].setFill(secondaryColor);
		 rectArray[x][y+1].setFill(secondaryColor);
		 rectArray[x-1][y].setFill(secondaryColor);
		 rectArray[x][y-1].setFill(secondaryColor);
	 }
	 
	 }
	 
 }

}//end handle()

}//end MouseHandler

//A handler class used to handle primary and secondary colors
private class PrimColorHandler implements EventHandler<ActionEvent>
{
public void handle(ActionEvent event)
{
//write your own codes here
//----
	
	//getting the color from the primaryColorCombo box
	String selected = primaryColorCombo.getSelectionModel().getSelectedItem();
	
	switch (selected.toUpperCase()) {
	
	//setting the primaryColor to Black
	case "BLACK":
		primaryColor = Color.BLACK;
		secondaryColor = Color.GRAY;
		break;
	
	//setting the primaryColor to Blue
	case "BLUE":
		primaryColor = Color.BLUE;
		secondaryColor = Color.POWDERBLUE;
		break;
		
	//setting the primaryColor to Red
	case "RED":
		primaryColor = Color.RED;
		secondaryColor = Color.PINK;
		break;
		
	//setting the primaryColor to Green
	case "GREEN":
		primaryColor = Color.GREEN;
		secondaryColor = Color.LIGHTGREEN;
		break;
	}
}
}//end PrimColorHandler

//A handler class used to handle background color
private class BackColorHandler implements EventHandler<ActionEvent>
{
public void handle(ActionEvent event)
{
 //write your own codes here
 //----
	
	//getting the color from the backColorCombo box
		String bselected = backColorCombo.getSelectionModel().getSelectedItem();
		
		switch (bselected) {
		
		//setting the backgroundColor to White
		case "White":
			backgroundColor = Color.WHITE;
			for(int i = 0; i < 7; i++) {
				 for(int j = 0; j < 7; j++) {
					 rectArray[i][j].setFill(Color.WHITE);
				 }
			 }
			break;
		
		//setting the backgroundColor to Yellow
		case "Yellow":
			backgroundColor = Color.YELLOW;
			for(int i = 0; i < 7; i++) {
				 for(int j = 0; j < 7; j++) {
					 rectArray[i][j].setFill(Color.YELLOW);
				 }
			 }
			break;
			
		//setting the backgroundColor to Orange
		case "Orange":
			backgroundColor = Color.ORANGE;
			for(int i = 0; i < 7; i++) {
				 for(int j = 0; j < 7; j++) {
					 rectArray[i][j].setFill(Color.ORANGE);
				 }
			 }
			break;
		}
}
}//end BackColorHandler

//A handler class used to handle stroke width
private class WidthHandler implements EventHandler<ActionEvent>
{
public void handle(ActionEvent event)
{
 //write your own codes here
 //----
	
	//getting the value from the widthCombo box
	selectWidth = Integer.parseInt(widthCombo.getValue());
	for(int i = 0; i < 7; i++) {
		 for(int j = 0; j < 7; j++) {
			 rectArray[i][j].setStrokeWidth(selectWidth);
		 }
	 }
	
}
}//end WidthHandler
} //end of PaneWithRectangles
