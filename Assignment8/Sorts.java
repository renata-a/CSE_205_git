// Assignment #: 8
//         Name: MADHAV ARUN SHARMA
//    StudentID: 1216873476
//      Lecture: M W 4:35 PM
//  Description: Sorts class to implement sort

import java.util.Arrays;
import java.util.Comparator;
public class Sorts {

	//definition of the method sort()
	public static void sort(Club[] clubList, int size, Comparator<Club> comparator){

		//insertion sort
		/*for (int i = 0; i < size; i++) {
			Club insert = clubList[i];		
			int j = i;
			while (j != 0  &&  comparator.compare(clubList[j-1], insert) > 0) {
				clubList[j] = clubList[j-1];
				j = j-1;
			}
			clubList[j] = insert;
		}*/

		// iterate from 0 to size-1
		for (int i = 0; i < size - 1; ++i) {
			int minIndex = i;

			for (int j = i + 1; j < size; ++j) {
				// compare
				if (comparator.compare(clubList[j],
						(clubList[minIndex])) < 0) {
					minIndex = j;
				}
			}
			// swap
			Club temp = clubList[i];
			clubList[i] = clubList[minIndex];
			clubList[minIndex] = temp;
		}

		//algorithm sort numbers stored in an array.
		//Arrays.sort(clubList, comparator);
	}
}

