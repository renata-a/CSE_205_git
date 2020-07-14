// Assignment #: 8
//         Name: MADHAV ARUN SHARMA
//    StudentID: 1216873476
//      Lecture: M W 4:35 PM
//  Description: The MemberNumberComparator class for 
//               comparing number of members in the clubs

import java.util.Comparator;
//The MemberNumberComparator class implements the "Comparator" interface
public class MemberNumberComparator implements Comparator<Club> {
	//definition of the method compare()
	@Override
	public int compare(Club first, Club second) {

		int temp;
		int num1 = 0;
		int num2 = 0;

		//compare the number of members
		if(null!=first && null!=second){
			num1 = Integer.valueOf(first.getNumberOfMembers());
			num2 = Integer.valueOf(second.getNumberOfMembers());
		}
		temp = Integer.compare(num1, num2);

		//If they have same number of members, then return should be 0
		//if they are not same then return -1 or 1
		return temp;
	}
}
