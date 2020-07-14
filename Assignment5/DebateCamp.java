//Arizona State University - CSE205
//Name: Madhav Sharma
//StudentID: 1216873476
//Lecture: 4:35 pm

public class DebateCamp extends SummerCamp
{
    //declare instance variables for class
    private double materialFee;
    private boolean groupDiscount;

    //constructor
    public DebateCamp (String title, String location, double rate, int weeks, double materialFee, String discount) 
    {
        super(title, location, rate, weeks);
        this.materialFee = materialFee;
        if (discount.toUpperCase().equals("YES"))
            groupDiscount = true;
        if (discount.toUpperCase().equals("NO"))
            groupDiscount = false;
    }

    //to compute Total Costs
    public void computeTotalCosts() 
    {
        if (groupDiscount)
            totalCost += weeklyRate * numberOfWeeks * 0.9 + materialFee;
        else
            totalCost += weeklyRate * numberOfWeeks + materialFee;
    }

    //prints relevant details about class
    public String toString() 
    {
        if (groupDiscount)
            return "\nDebate Camp:" + super.toString() + "Material Fee:\t\t" + nf.format(materialFee) + "\nGroup Discount:\t\t" + "yes" + "\n";
        return "\nDebate Camp:" + super.toString() + "Material Fee:\t\t" + nf.format(materialFee) + "\nGroup Discount:\t\t" + "no" + "\n";
    }
}