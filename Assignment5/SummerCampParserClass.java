//Arizona State University - CSE205
//Name: Madhav Sharma
//StudentID: 1216873476
//Lecture: 4:35 pm

public class SummerCampParserClass
{
    //method to parse
    public static SummerCamp parseStringToSummerCamp(String lineToParse) 
    {
        //splits String at ":"
        String[] camp = lineToParse.split(":"); 
        //checks type of class
        if (camp[0].equals("DebateCamp")) 
        {
            //assigns values and creates an object of class
            //returns class
            SummerCamp debateCamp = new DebateCamp(camp[1], camp[2], Double.parseDouble(camp[3]), Integer.parseInt(camp[4]), Double.parseDouble(camp[5]), camp[6]);
            return debateCamp; 
        }
        //checks type of class
        else if (camp[0].equals("RoboticsCamp")) 
        {
            //assigns values and creates object of class
            //returns class
            SummerCamp roboticsCamp = new RoboticsCamp(camp[1], camp[2], Double.parseDouble(camp[3]), Integer.parseInt(camp[4]), Double.parseDouble(camp[5]), Double.parseDouble(camp[6]));
            return roboticsCamp; 
        }
        //if above two are absent, would be math camp only
        //assigns values and creates an object of class
        //returns class
        SummerCamp mathCamp = new MathCamp(camp[1], camp[2], Double.parseDouble(camp[3]), Integer.parseInt(camp[4]), camp[5]);
        return mathCamp; 
    }
}