package application;

// Assignment #: Arizona State University CSE205 #6
//         Name: Madhav Arun Sharma
//    StudentID: 1217123479
//      Lecture: MW 4:35 pm
//  Description: SelectPane displays a list of available clubs
//  from which a user can select and compute their total number of members.

import javafx.scene.control.Label;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.*;

//Important import
import javafx.event.ActionEvent;

//Important import
import javafx.event.EventHandler;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.scene.Node;

//importing all necessary javafx classes
//---

public class SelectPane extends BorderPane
{
   private ArrayList<Club> clubList;
   private ArrayList<CheckBox> checkBoxArray = new ArrayList<CheckBox>();
   private int totalMembers = 0;
   private VBox selectPaneBox;
   private CheckBox clubBox;
   private Label memberCount = new Label("The total number of members for the selected club(s): " + totalMembers);

   //constructor
   public SelectPane(ArrayList<Club> list)
   {
       //initializing instance variables
       this.clubList = list;
       
       //setting up the layout
       //---
       
    
       //create an empty pane where you can add check boxes later
       //---
       selectPaneBox = new VBox();
       
       //SelectPane is a BorderPane - add the components here
       //---
       this.setTop(new Label("Select some clubs"));
       this.setLeft(selectPaneBox);
       this.setBottom(memberCount);

       
   } //end of constructor

 //method uses newly added parameter Club object
 //to create CheckBox and add it to a pane created in constructor
 //Such check box needs to be linked to its handler class
 public void updateClubList(Club newClub)
 {
     //-------
	 clubBox = new CheckBox(newClub.toString());
	 checkBoxArray.add(clubBox);
	 clubBox.setOnAction(new SelectionHandler());
	 selectPaneBox.getChildren().addAll(clubBox);
 }

 //creating a SelectionHandler class
 private class SelectionHandler implements EventHandler<ActionEvent>
    {
        //Override the abstact method handle()
        public void handle(ActionEvent event)
        {
        	totalMembers = 0;
            //When any radio button is selected or is unselected
            //total number of members of selected clubs must be updated
            //and must be displayed using a label.
        	for(int i=0;i<checkBoxArray.size();i++)
        	{
        		if(checkBoxArray.get(i).isSelected())
        		{
        			System.out.println(i);
        			System.out.println("Club: " + clubList.get(i).getClubName());
        			totalMembers += clubList.get(i).getNumberOfMembers();
        		}
        	}
        	memberCount.setText("The total number of members for the selected club(s): " + totalMembers);

     }
   } //end of SelectHandler class
} //end of SelectPane class
