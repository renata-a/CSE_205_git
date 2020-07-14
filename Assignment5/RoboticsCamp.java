//Arizona State University - CSE205
//Name: Madhav Sharma
//StudentID: 1216873476
//Lecture: 4:35 pm

public class RoboticsCamp extends SummerCamp
{
    //declaring instance variables
    private double facilityFee, competitionFee;

    //constructor
    public RoboticsCamp (String title, String location, double rate, int weeks, double facilityFee, double compFee) 
    {
        super(title, location, rate, weeks);
        this.facilityFee = facilityFee;
        competitionFee = compFee;
    }
    
    //computes total costs
    public void computeTotalCosts() 
    {
        totalCost += weeklyRate * numberOfWeeks + facilityFee + competitionFee;
    }
    
    //prints relevant details about class
    public String toString() 
    {
        return "\nRobotics Camp:" + super.toString() + "Facility Fee:\t\t" + nf.format(facilityFee) + "\nCompetition Fee:\t" + nf.format(competitionFee) + "\n";
    }
}