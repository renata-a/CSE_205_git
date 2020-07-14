// Assignment #: 9
//         Name: MADHAV ARUN SHARMA
//    StudentID: 1216873476
//      Lecture: M W 4:35 PM
//  Description: Using recursion to perform specified functions on
//               a sequence of numbers entered by the user

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Create a class recursion, Assignment 9
public class Assignment9
{
	//Define the method findMin() 
	//to find the minimum of the array
	public static int findMin(int[] numbers, int startIndex, int endIndex)
	{
		//Check the starting and the last index to be equal
		if (startIndex == endIndex) 
		{
			//Return the value of the starting index
			return numbers[startIndex];
		}

		//Call the function recursively to find the other minimum value of the array
		//local variable value to store the value of minimum
		int min = findMin(numbers, startIndex + 1, endIndex);

		//Compare the value of min with starting index
		if (numbers[startIndex] < min)
			//Return the value of the starting index
			//the new minimum
			return numbers[startIndex];
		else
			//Return the value of local variable min
			return min;
	}

	//Define the method countOddNumbers()
	//to count the number of odd elements
	public static int countOddNumbers(int[] elements, int startIndex, int endIndex)
	{
		{
			//Local variable countOdd to store the value of count
			int countOdd = 0;

			//Check if the starting index is odd
			//for both positive and negative elements
			if(elements[startIndex] % 2 == 1 || elements[startIndex] % 2 == -1)

				//Increment the value of local variable countOdd by 1
				//number of odd numbers in the array increases by 1
				countOdd++;

			//Check the starting and the last index to be equal
			if(startIndex == endIndex)
				//Return the value of local variable countOdd
				return countOdd;
			else
				//Call the function recursively to find the count of odd numbers 
				//in the array and add countOdd
				return countOdd + countOddNumbers(elements, startIndex + 1, endIndex);
		}
	}

	//Define the method computeLargestEven()
	//to compute the largest even integer
	public static int computeLargestEven(int[] elements, int startIndex, int endIndex)
	{	
		//Check the starting and the last index to be equal
		if(startIndex == endIndex)
		{
			//Check the starting index value to be even
			if(elements[startIndex] %2 == 0)
				//Return starting index value
				return elements[startIndex];
			else
				//If starting index value is not even
				return 0;
		}
		else 
		{
			//Call the function recursively to find the other even numbers in the array
			//store the value of largest even number in local variable largestEven
			int largestEven = computeLargestEven(elements, startIndex + 1, endIndex);

			if(elements[startIndex] %2 == 0) 
			{
				//Compare current value with current largest even value
				if(elements[startIndex] > largestEven)
					//Return starting index value
					return elements[startIndex];
				else
					//Return the value of local variable largestEven
					return largestEven;
			}
			else
				//If the element is not even
				//Return the value of local variable largestEven
				return largestEven;
		}
	}

	//Define the method sumOfNumbersLargerThanFirst()
	//to find the sum of numbers larger than the first element
	public static int sumOfNumbersLargerThanFirst(int[] elements, int startIndex, 
			int endIndex, int firstNumber)
	{
		//Local variable sum to store the value of the sumOfLarger
		int sumOfLarger = 0;

		//Compare the value of the starting index with the first number in the array
		if (elements[startIndex] > firstNumber)
			//Add the value of starting index to sumOfLarger
			sumOfLarger = sumOfLarger + elements[startIndex];

		//Check the starting and the last index to be equal
		if (startIndex == endIndex)
			//Return the value of local variable sumOfLarger
			return sumOfLarger;
		else
			//Call the function recursively and add the value of sumOfLarger 
			//to find the sum of numbers larger than the first number in the array
			return sumOfLarger + sumOfNumbersLargerThanFirst(elements, startIndex + 1, endIndex,
					firstNumber);
	}

	//Define the main method.
	public static void main(String[] args) throws IOException 
	{
		//Local variable num1 to carry user input values
		int inputNum = 0;

		//Using InputStreamReader and BufferedReader to process input
		InputStreamReader inp = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(inp);
		
		int inputCount = 0;

		//Initialize array numbers of size 100
		int[] numbers = new int[100];
		int[] elements = new int[100];

		//Add input value until user input value equal to 0
		while(true){
			inputNum = Integer.parseInt(br.readLine());
			if(inputNum == 0){
				break;
			}
			numbers[inputCount++] = inputNum;
			elements[inputCount++] = inputNum;
		}

		//Call the functions and display their respective returned values
		System.out.println("The minimum number is " + findMin(numbers, 0, inputCount - 1));
		System.out.println("The count of odd integers in the sequence is " + 
				countOddNumbers(elements, 0, inputCount - 1));
		System.out.println("The largest even integer in the sequence is " + 
				computeLargestEven(elements, 0, inputCount - 1));
		System.out.println("The sum of numbers larger than the first is " + 
				sumOfNumbersLargerThanFirst(elements, 0, inputCount - 1, numbers[0]));
	}
}