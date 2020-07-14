package application;

// Assignment #: Arizona State University CSE205 #6
//         Name: Madhav Arun Sharma
//    StudentID: 1216873476
//      Lecture: MW 4:35 pm
//  Description: CreatePane generates a pane where a user can enter
//  a club information and create a list of available clubs.

import java.util.ArrayList;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.control.*;

//Important import
import javafx.event.ActionEvent;

//Important import
import javafx.event.EventHandler;

//importing all necessary javafx classes
//---

public class CreatePane extends HBox
{
	ArrayList<Club> clubList;
	private SelectPane selectPane;
	private TextField titleField = new TextField();
	private TextField membersField = new TextField();
	private TextField universityField = new TextField();
	private Label errorMessage = new Label();
	private TextArea clubInfo;
	private String clubStats = "";

    //relationship between CreatePane and SelectPane: Aggregation
    

	//constructor
	public CreatePane(ArrayList<Club> list, SelectPane sePane)
	{
		this.clubList = list;
		this.selectPane = sePane;
        
        
        //initializing instance variables (textfields, labels, textarea, button, etc.)
        //setting up the layout
        //---
		Button createClub= new Button("Create a Club");
		
		Label titleLabel = new Label ("Title");
		Label membersLabel = new Label ("Number of Members");
		Label universityLabel = new Label ("University");
		errorMessage.setTextFill(Color.RED);
        
        //creating GridPane to hold the labels & text fields.
        //you can choose to use .setPadding() or setHgap(), setVgap()
        //to control spacing and gap, etc.
        //---
        GridPane grid1 = new GridPane();
        grid1.setHgap(10);
        grid1.setVgap(10);
        grid1.add(titleLabel,4,0,5,1);
        grid1.add(titleField,5,0);
        grid1.add(membersLabel,4,1);
        grid1.add(membersField,5,1);
        grid1.add(universityLabel,4,2);
        grid1.add(universityField,5,2);
        
        //might need to create a sub pane to hold the button
        //---
        BorderPane buttonPane = new BorderPane();
        buttonPane.setCenter(createClub);
        
        //Setting up the layout for left half of CreatePane.
        //---
        VBox vbox1 = new VBox();
        vbox1.setSpacing(10);
        vbox1.getChildren().add(errorMessage);
        vbox1.getChildren().add(grid1);
        vbox1.getChildren().add(buttonPane);
        
        //right half of CreatePane is a TextArea object
        //Note: a ScrollPane added automatically when there is not
        //enough space
        
        //Right half layout
        clubInfo = new TextArea("No Club");
        
        //Adding the left and right halves to the CreatePane
        //Note: CreatePane extends from HBox
        //----
        HBox createPane = new HBox();
        createPane.getChildren().add(vbox1);
        createPane.getChildren().add(clubInfo);
        this.getChildren().addAll(createPane);
        	
        		
        //registering/linking the source object with the event handler
        //----
        createClub.setOnAction(new ButtonHandler());

	} //end of the constructor

    //Create a ButtonHandler class
    //ButtonHandler listens to see if the button "Create" is pushed or not,
    //When the event occurs, it get a club's Title, its number of members, and its university
    //information from the relevant text fields, then create a new club and add it inside
    //the clubList. Meanwhile it will display the club's information inside the text area.
    //using the toString method of the Club class.
    //It also does error checking in case any of the textfields are empty,
    //or a non-numeric value was entered for its number of members
    private class ButtonHandler implements EventHandler<ActionEvent>
   	 {
   	    //Override the abstact method handle()
   	    public void handle(ActionEvent event)
        {
            //declaring all the necessary local variables
            //---
   	    	String title = titleField.getText();
   	    	String numMembers = membersField.getText();
   	    	String university = universityField.getText();
   	    	boolean addClub = true;
            
            //when a text field is found empty and button is pushed
            if ( title.equals("") || numMembers.equals("") || university.equals("") )
                {
                    //handling case here
                    errorMessage.setText("Please fill all fields");
                }
                else	//for all other cases
                {
                    //when non-numeric values are entered for its number of members
                    //and button is pushed
                    //you will need to use try and catch block to catch
                    //NumberFormatException
                    //---
                	try
                	{
                		Integer.parseInt(numMembers);
                	}
                	
                	catch (NumberFormatException e)
                	{
                		errorMessage.setText("Please enter an integer for a number of members");
                		addClub = false;
                	}
                    
                    //When club of existing club name is in the list
                    //is attempted to be added, do not add it to the list
                    //display a message "Club not added - duplicate"
                    for (int i = 0; i< clubList.size(); i++)
                    {
                    	if(clubList.get(i).getClubName().equals(title))
                    	{
                    		errorMessage.setText("Club not added - duplicate");
                    		addClub = false;
                    	}
                    }
                    
                    
                    //at the end, do not forget to update new arrayList
                    //information on SelectPanel
                    //---
                    if(addClub)
                    {
                    	Club newClub = new Club();
                    	errorMessage.setText("Club added");
                    	newClub.setClubName(title);
                    	newClub.setNumberOfMembers(Integer.parseInt(numMembers));
                    	newClub.setUniversity(university);
                    	clubList.add(newClub);
                    	
                    	clubStats += newClub.toString();
                    	clubInfo.setText(clubStats);
                    	selectPane.updateClubList(newClub);
                    }
                    
                }

      } //end of handle() method
   } //end of ButtonHandler class

}
