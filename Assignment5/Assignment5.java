//Assignment #: 5
//Arizona State University - CSE205
//Name: Madhav Sharma
//StudentID: 1216873476
//Lecture: 4:35 pm
//Description: The Assignment 5 class displays a menu of choices add summer camp, search summer camp title, list summer camps, quit, display menu) to a user and performs the chosen task. It will keep asking a user to enter the next choice until the choice of 'Q' (Quit) is entered.

//use InputStreamReader and BufferedReader
import java.io.*;         
//use ArrayList
import java.util.*;       

public class Assignment5 extends SummerCamp
{  
    public Assignment5 (String a, String b, double c, int d)
    {
        super(a,b,c,d);
    }
    
    public static void main (String[] args) 
    {
        char input1;
        String inputInfo = new String();
        String line = new String();
        boolean operation;

        //ArrayList object used to store SummerCamp objects
        ArrayList summerCampList = new ArrayList();

        try
        {
            // print menu
            printMenu();     

            //create a BufferedReader object to read input from a keyboard
            InputStreamReader isr = new InputStreamReader (System.in);
            BufferedReader stdin = new BufferedReader (isr);

            do
            {
                System.out.println("What action would you like to perform?");
                line = stdin.readLine().trim();
                input1 = line.charAt(0);
                input1 = Character.toUpperCase(input1);

                if (line.length() == 1)
                {
                    switch (input1)
                    {
                        //Add SummerCamp
                        case 'A':   
                        System.out.print("Please enter some summer camp information to add:\n");
                        inputInfo = stdin.readLine().trim();
                        summerCampList.add(SummerCampParserClass.parseStringToSummerCamp(inputInfo));
                        break;
                        //Compute Total Costs for all camps
                        case 'C':   
                        for (int i = 0; i < summerCampList.size(); ++i)
                        {
                            ((SummerCamp) summerCampList.get(i)).computeTotalCosts();
                        }
                        System.out.print("total costs computed\n");
                        break;
                        //Search SummerCamp
                        case 'D':   
                        System.out.print("Please enter a summer camp title to search:\n");
                        inputInfo = stdin.readLine().trim();
                        operation = false;
                        for (int i = 0; i < summerCampList.size(); ++i)
                        {
                            if (inputInfo.equals(((SummerCamp) summerCampList.get(i)).getCampTitle()))
                                operation = true;
                        }
                        if (operation == true)
                            System.out.print("SummerCamp found\n");
                        else
                            System.out.print("SummerCamp not found\n");
                        break;
                        //List SummerCamps
                        case 'L':   
                        if (summerCampList.size() == 0)
                            System.out.print("no summer camp\n");
                        else
                        {
                            for (int i = 0; i < summerCampList.size(); ++i)
                            {
                                System.out.println(summerCampList.get(i).toString());
                            }
                        }
                        break;
                        //Quit
                        case 'Q':   
                        break;
                        //Display Menu
                        case '?':   
                        printMenu();
                        break;
                        default:
                        System.out.print("Unknown action\n");
                        break;
                    }
                }
                else
                {
                    System.out.print("Unknown action\n");
                }
            } // stop loop when Q is read
            while (input1 != 'Q'); 
        }
        catch (IOException exception)
        {
            System.out.println("IO Exception");
        }
    }

    /** The method printMenu displays the menu to a user **/
    public static void printMenu()
    {
        System.out.print("Choice\t\tAction\n" +
            "------\t\t------\n" +
            "A\t\tAdd SummerCamp\n" +
            "C\t\tCompute Total Costs\n" +
            "D\t\tSearch for SummerCamp\n" +
            "L\t\tList SummerCamps\n" +
            "Q\t\tQuit\n" +
            "?\t\tDisplay Help\n\n");
    }
}