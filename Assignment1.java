//package cse205.Assignment1;
//Assignment #: 1
//Arizona State University - CSE205
//      Name: Madhav Sharma
// StudentID: 1216873476
//   Lecture: M-W 4:35-5:50pm
//Description: This class reads an integer from a keyboard and prints it out
//            along with other messages.

//importing scanner class
import java.util.Scanner;

public class Assignment1 
{
	//initializing main method
	public static void main(String [] args)
	{
		//initializing variables
		int number;
		
		//creating scanner console class
		Scanner console = new Scanner(System.in);
		
		//reading integers by user
		number= console.nextInt();
		
		//display the result
		System.out.print("This program reads an integer from a keyboard,\n"
				+ "and prints it out on the display screen.\n"
				+ "Make sure that you get the exact same output as the expected one.\n"
				+ "The read number is " + number + ".\n");
	}
}
