import java.io.*;			//Imports IOException Method
import java.util.Scanner;			//Imports Scanner Method to scan input file

//*******************************
//*	START OF StockList CLASS	*
//*******************************
public class StockList {

	public static void main(String[] args) throws IOException {
		//This declares and initializes the Stock object
		Stock listObject = new Stock();
		
		//This declares and initializes String objects for both the input and output file names
		String inputFileTitle = new String();
		String outputFileTitle = new String();

		//This declares and initializes the Scanner object for user input
		Scanner input = new Scanner(System.in);
		//This prints out the command to print the command to enter the input file name
		System.out.print("Please type in the name of the input file: ");
		//This sets the input file name as the user input
		listObject.SetInputFileName(input.nextLine());
		//This sets the String object for the input file as the given input file name
		inputFileTitle = listObject.GetInputFileName();
		//This prints out the command to print the command to enter the output file name
		System.out.print("Please type in the name of the output file: ");
		//This sets the output file name as the user input
		listObject.SetOutputFileName(input.nextLine());
		//This sets the String object for the output file as the given output file name
		outputFileTitle = listObject.getOutputFileName();
		//This declares and initializes the append file object and the output file object
		FileWriter append = new FileWriter(outputFileTitle, true);
		PrintWriter fileOutput = new PrintWriter(append);
		//This deletes the content from the previous session
		fileOutput.flush();
		//This sets the Stock object array as the object array for the list of stocks
		Stock [] array = listObject.StockInformation(inputFileTitle, fileOutput);
		//This finds and prints out the sum of the stock prices
		listObject.FindSum(array, fileOutput);
		//This finds and prints out the average of the stock prices
		listObject.FindAverage(array, fileOutput);
		//This finds and prints out the highest stock price
		listObject.FindHighest(array, fileOutput);
		//This finds and prints out the lowest stock price
		listObject.FindLowest(array, fileOutput);
		//This closes the input object
		input.close();
		
	}

}
