// Assignment #: 4
// Name: Madhav Arun Sharma
// StudentID: 1216873476
// Lecture: 4:35 pm M W

public class President
{
    //declaring variables
    private String firstName, lastName, academicLevel; 
    
    //zero-argument constructor
    public President() 
    {
        firstName = "?";
        lastName = "?";
        academicLevel = "?";
    }
    
    //first name accessor
    public String getFirstName() 
    {
        return firstName;
    }
    
    //last name accessor
    public String getLastName()
    {
        return lastName;
    }
    
    //academic level accessor
    public String getAcademicLevel() 
    {
        return academicLevel;
    }
    
    //first name mutator
    public void setFirstName(String someFirstName) 
    {
        firstName = someFirstName;
    }
    
    //last name mutator
    public void setLastName(String someLastName) 
    {
        lastName = someLastName;
    }
    
    //academic level mutator
    public void setAcademicLevel(String someLevel) 
    {
        academicLevel = someLevel;
    }
    
    //toString method
    public String toString() 
    {
        return lastName + "," + firstName + "(" + academicLevel + ")";
    }
}