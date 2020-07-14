//Arizona State University - CSE205
//Name: Madhav Sharma
//StudentID: 1216873476
//Lecture: 4:35 pm

//imports classes from libraries for formatting
import java.text.DecimalFormat; 

public abstract class SummerCamp
{
    //declare instance variables
    String title, location;
    double weeklyRate, totalCost = 0;
    int numberOfWeeks;

    DecimalFormat nf = new DecimalFormat("$0.00"); //specify the format
    
    //Constructor
    public SummerCamp(String someTitle, String someLocation, double someWeeklyRate, int someNumberOfWeeks) 
    {
        title = someTitle;
        location = someLocation;
        weeklyRate = someWeeklyRate;
        numberOfWeeks = someNumberOfWeeks;
        totalCost = 0;
    }

    //Accessor
    public String getCampTitle() 
    {
        return title;
    }

    //method to compute Total Costs
    public void computeTotalCosts() 
    {
        totalCost = weeklyRate * numberOfWeeks;
    }

    //print relevant details
    public String toString() 
    {
        return "\nCamp Title:\t\t" + title 
        + "\nLocation:\t\t" + location 
        + "\nWeekly Rate:\t\t" + nf.format(weeklyRate) 
        + "\nWeeks:\t\t\t" + numberOfWeeks 
        + "\nTotal Cost:\t\t" + nf.format(totalCost) 
        + "\n";
    }
}