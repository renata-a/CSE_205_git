//package cse205.Assignment2;

//Assignment #2
//Arizona State University - CSE205
//Name: Madhav Sharma
//StudentID: 1216873476
//Lecture: 4:35 pm
//Description: This class reads an integer from a keyboard and performs certain operations until the number zero is entered by the user.

//importing Scanner class
import java.util.Scanner;

//start of class Assignment2
public class Assignment2 {
	
	    //start of main method
		public static void main(String [] args)
		{
	        //initializing variables
			int num, min, countOdd=0, sumPositive=0, largestEven;

	        //creating Scanner object
			Scanner scan=new Scanner(System.in);

	        //storing user value in the variable num
			num=scan.nextInt();

	        //initializing variable min equal to num
			min=num;

	        //initializing variable largestEven equal to num
			largestEven=num;

	        //creating a while loop
			while(num!=0)
			{
				if(num<min)
				{
					min=num;
				}

				if(num%2!=0)
				{
					countOdd++;
				}
	 
				if(num%2==0)
				{
					if(num>largestEven)
					{
						largestEven=num;
					}
				}

				if(num>0)
				{
					sumPositive+=num;
				}

	            //taking input from the user
				num=scan.nextInt();

			}

	        //printing result
			System.out.println("The minimum integer is " + min);
			System.out.println("The count of odd integers in the sequence is " + countOdd );
			System.out.println("The largest even integer in the sequence is " + largestEven);
			System.out.println("The sum of positive integers is " + sumPositive);

		}//end of main method
	}//end of class Assignment2

