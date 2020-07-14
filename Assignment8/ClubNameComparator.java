// Assignment #: 8
//         Name: MADHAV ARUN SHARMA
//    StudentID: 1216873476
//      Lecture: M W 4:35 PM
//  Description: The ClubNameComparator class for
//               for comparing the club names

import java.util.Comparator;
//The ClubNameComparator class implements the "Comparator" interface
public class ClubNameComparator implements Comparator<Club> {
	//definition of the method compare()
	@Override
	public int compare(Club first, Club second) {

		int tempName1 = 0;

		//compare the names of the two arguments
		if(null!=first && null!=second){
			tempName1 = first.getClubName().compareTo(second.getClubName());
		}
		//If they have same club name then return should be 0
		//if they are not same then return is -1 or 1
		return tempName1;
	}
}
