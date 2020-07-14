// Assignment #: 4
// Name: Madhav Arun Sharma
// StudentID: 1216873476
// Lecture: 4:35 pm M W

public class Club
{
    //declaring variables
    private String clubName, university;
    private int numberOfMembers;
    private President currentPresident;

    //zero-argument constructor
    public Club()
    {
        clubName = "?";
        university = "?";
        numberOfMembers = 0;
        currentPresident = new President();
    }

    //club name accessor
    public String getClubName()
    {
        return clubName;
    }

    //number of accessor members
    public int getNumberOfMembers()
    {
        return numberOfMembers;
    }

    //university name accessor
    public String getUniversity()
    {
        return university;
    }

    //current president object accessor
    public President getCurrentPresident()
    {
        return currentPresident;
    }

    //club name mutator
    public void setClubName(String someName)
    {
        clubName = someName;
    }

    //number of mutator members
    public void setNumberOfMembers(int someNumber)
    {
        numberOfMembers = someNumber;
    }

    //university name mutator
    public void setUniversity(String someUniversity)
    {
        university = someUniversity;
    }

    //current president object mutator
    public void setCurrentPresident(String firstName, String lastName, String someLevel)
    {
        currentPresident.setFirstName(firstName);
        currentPresident.setLastName(lastName);
        currentPresident.setAcademicLevel(someLevel);
    }

    //toString method
    public String toString()
    {
        return "\nClub Name:\t\t" + clubName +
        "\nNumber Of Members:\t" + numberOfMembers +
        "\nUniversity:\t\t" + university + 
        "\nPresident:\t\t" + currentPresident + "\n\n";
    }
}