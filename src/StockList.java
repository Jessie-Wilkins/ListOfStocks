/* ========================================================================== */
/*	PROGRAM List of Stocks

    AUTHOR: Yuri Khechoyan & Jessie Wilkins
    COURSE NUMBER: CIS 210
    COURSE SECTION NUMBER: 01
    INSTRUCTOR NAME: Dr. Tian
    PROJECT NUMBER: 7
    DUE DATE: 10/13/2016
    
SUMMARY

	This program is designed to work similar to the previous program
	(PriceStockSimulation). This new program is designed to
	read in a list of stocks from the input text file (stocks.txt).
	The program will extract the stock prices in order to 
	do the following calculations:

		1. Sum
		2. Avg.
		3. Name of Stock with the highest price
		4. Name of stock with the lowest price

	Once calculations have been completed, the calculations
	listed above would be written to an output file.


INPUT

	Input will be read as Strings from a file. Program will
	parse out all of the comments & extra spaces
	The name and price of highest & lowest stock will 
	be kept for later use. Once input is received, 
	the prices will be converted into Doubles.

OUTPUT

	Output from program will be shown on console & written to an Output file
	List of key things that will be written to the Output file:
	
		1. Sum
		2. Avg.
		3. Name of Stock with the highest price
		4. Name of stock with the lowest price

ASSUMPTIONS

- None

*/

import java.io.*;			//Imports IOException Method
import java.util.Scanner;	//Imports Scanner Method to scan input file

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
		Stock [] array = listObject.StockInformation(inputFileTitle);
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
