//Arizona State University - CSE205
//Name: Madhav Sharma
//StudentID: 1216873476
//Lecture: 4:35 pm

public class MathCamp extends SummerCamp
{
    //declaring new variables for class
    boolean testTaking;
    
    //constructor
    public MathCamp(String title, String location, double rate, int weeks, String testTaking) 
    {
        super(title, location, rate, weeks);
        if (testTaking.toUpperCase().equals("YES"))
            this.testTaking = true;
        if (testTaking.toUpperCase().equals("NO"))
            this.testTaking = false;
    }
    
    //computes Total Costs
    public void computeTotalCosts() 
    {
        if (testTaking)
            totalCost += weeklyRate * numberOfWeeks + 25;
        else
            totalCost += weeklyRate * numberOfWeeks;
    }
    
    //prints relevant details about class
    public String toString()
    {
        if (testTaking)
            return "\nMath Camp:" + super.toString() + "Test Taking:\t\tyes\n";
        return "\nMath Camp:" + super.toString() + "Test Taking:\t\tno\n";
    }
}