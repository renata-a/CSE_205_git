// Assignment #: 8
//         Name: MADHAV ARUN SHARMA
//    StudentID: 1216873476
//      Lecture: M W 4:35 PM
//  Description: The CurrentPresidentComparator class for
//               comparing first and last names of the presidents

import java.util.Comparator;
//The CurrentPresidentComparator class implements the "Comparator" interface
public class CurrentPresidentComparator implements Comparator<Club> {
	//definition of the method compare()
	@Override
	public int compare(Club first, Club second) {

		int tempName1 = 0;

		//compare the names of the two arguments
		if(null!=first && null!=second){
			tempName1 = first.getCurrentPresident().getLastName().compareTo(second.getCurrentPresident().getLastName());
		}
		//If their first names are same, then their last names should be compared
		if(tempName1 == 0) {

			int tempName2 = 0;

			//compare the names of the two arguments
			if(null!=first && null!=second){
				tempName2 = first.getCurrentPresident().getFirstName().compareTo(second.getCurrentPresident().getFirstName());
			}
			//If they have same first name and last name, then return should be 0
			return tempName2;
		}
		//if they are not same then return is -1 or 1
		return tempName1;
	}
}

