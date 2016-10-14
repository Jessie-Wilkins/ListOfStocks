import java.io.*;													//Imports file input and output classes used 
																	//to read from and write to files

import java.util.Scanner;											//Imports Scanner class used to accept user input

public class Stock {
	//Variables
	private String companyName;										//String object holding name of Company
	private String companySymbol;									//String object holding Stock Symbol
	private String outputFileName;									//String object holding the output file
	private String inputFileName;									//String object holding the input file
	private double currentPrice;									//Double holding Current Price of Stock
	
	//Constants
	final private int MIN_NUMBER_OF_STOCKS = 30;					//Integer constant holding the minimum number of stocks
	final private int MAX_NUMBER_OF_STOCKS = 50;					//Integer constant holding the maximum number of stocks

	
	//*************************
	//*	  METHOD DEFINISTIONS *
	//************************* 
	
	
	/**
	 * Determines if the default values should be used
	 * @param cN
	 * @param cS
	 * @param cP
	 */
	public void WhichDefaultValue(String cN, String cS, double cP) {
		//This sets the name, symbols, and current price if they do not equal the default value keywords
		if(!(cN.contentEquals("NONE")) && !(cS.contentEquals("NA")) && cP != 0.0) {
			SetName(cN);
			SetSymbol(cS);
			SetCurrentPrice(cP); 
		}//Closes if statement
		
	}//Closes WhichDefaultValue Method
	
	/**
	 * Default constructor that does nothing
	 * @param n
	 * @param s
	 * @param cP
	 */
	public Stock() {
	
	}//Closes public Stock Method
	/**
	 * Sets the private variables to the given values
	 * @param n
	 * @param s
	 * @param cP
	 * @param nP
	 */
	public Stock(String n, String s, double cP) {					//Stock Method that creates 
																	//user instance of Stock details
		companyName = n;
		companySymbol = s;
		currentPrice = cP;											
		
	}//Closes public Stock Method
	/**
	 * This sets the company name to the given string
	 * @param n
	 */
	public void SetName(String n){
		companyName = n;	//Assigns the name to the private variable
	}
	/**
	 * This sets the company symbol to the given string
	 * @param s
	 */
	public void SetSymbol(String s) {
		//Assigns the symbol to the private variable
		companySymbol = s;
	}
	/**
	 * This sets the current price to the given double
	 * @param cP
	 */
	public void SetCurrentPrice(double cP) {						//Error Checking for: currentPrice > 0, 
		if(cP > 0) {												//set the value to the variable; 
			currentPrice = cP;										//otherwise set to 1
		}//Close if statement
		
		else {
			currentPrice = 1;
		}//Close else statement
		
	}//Closes setCurrentPrice Method															

	/**
	 * This sets the output file name as the given string
	 * @param s
	 */
	public void SetOutputFileName(String s) {
		outputFileName = s;
	}//Closes SetOutputFileName Method
	
	/**
	 * This sets the input file name as the given string if the file exists
	 * @param s
	 */
	public void SetInputFileName(String s) {						//This declares and initializes the 
		File file = new File(s);									//file object for the file of the given name
																	//This sets the input file name as 
		if(file.isFile()) {											//the given string if it exists.
			inputFileName = s;	
		}															//Otherwise, it prints an error statement
		else{														//and exits the program.
			System.out.print("Does not work.");
			System.exit(1004);
		}
		
	} //Closes SetInputFileName										
		
	/**
	 * This returns the company name 
	 * @return
	 */
	public String GetName() {
		return companyName;		//returns the name of the company
	}
	/**
	 * This returns the company symbol
	 * @return
	 */
	public String GetSymbol() {
		return companySymbol;	//returns the name of the company
	}
	/**
	 * This returns the current price
	 * @return
	 */
	public double GetCurrentPrice() {
		return currentPrice;	//returns the current price of the company
	}
	
	/**
	 * This returns the output file name
	 * @return
	 */
	public String GetOutputFileName() {
		return outputFileName;
	}
	/**
	 * This returns the input file name
	 * @return
	 */
	public String GetInputFileName() {
		return inputFileName;
	}
	
	/**
	 * This finds & prints out to the console and the output file the sum of the stock prices
	 * @param o		//Array Object
	 * @param fileName
	 * @throws IOException
	 */
	public void FindSum(Stock [] o, PrintWriter fo) throws IOException {

		//Variables		
		double sum = 0;												//This declares the double used as 
																	//the sum and initializes it to zero
		
		for(int i=0; i<o.length; i++) {								//This finds the sum of the stock prices
			sum+=o[i].GetCurrentPrice();							//while the counter is less than the array
		}															//length and sets it as the double variable
		fo.printf("The sum: %.2f\r\n", sum);
		System.out.printf("The sum: %.2f\n", sum);
	}
	
	/**
	 * This finds and prints out to the console and the output file the average of the stock prices
	 * @param o 		//Array Object
	 * @param fileName
	 * @throws IOException
	 */
	public void FindAverage(Stock [] o, PrintWriter fo) throws IOException {
		//Variables		
		double sum = 0;												//This declares the double used as the sum 
																	//and initializes it to zero
		double average;												//This declares the double used as the average
		
		for(int i=0; i<o.length; i++) {								//This finds the sum of the stock prices 
			sum+=o[i].GetCurrentPrice();							//while the counter is less than the array
		}															//length and sets it as the double variable
																	
		average = sum/o.length;										//This finds the average and sets it as the 
																	//double variable
		fo.printf("The average: %.2f\r\n", average);				//This prints the average to the console 
																	//and the file
		System.out.printf("The average: %.2f\n", average);

	}//Closes FindAverage Method
	/**
	 * This finds and prints out to the console and output file the highest stock price
	 * @param o		//Array Object
	 * @param fileName
	 * @throws IOException
	 */
	public void FindHighest(Stock [] o, PrintWriter fo) throws IOException {
		String highest = new String();								//This declares and initializes the 
																	//string object for the name of the 
																	//highest priced stock
		//Variables
		int index = 0;												//This declares the integer variable for 
																	//the index and initializes it to zero
		
		double value = 0;											//This declares the double variable
																	//for the value and initializes it to zero
		
		for(int i = 0; i<o.length; i++) {							//This sets the value to the 
																	//highest stock price while the 
																	//counter is less than the object array length
			
			if(o[i].GetCurrentPrice() > value) {					//This sets the first variable to the current
				value = o[i].GetCurrentPrice();						//price in the given element of the object array
				index = i;											//and sets the second variable to the 
			}														//current index.
		}														
																 
		highest = o[index].GetName();								//This occurs if the current price for 
																	//the current element for the array is
																	//greater than the value variable.												
																	//This sets the variable for the highest 
																	//priced stock as the stock name of
																	//the given element of the object array.
		
		//This prints out the name of the highest priced stock onto the console and the output file
		fo.println("The Stock with the highest price: " +highest+"\r\n");
		System.out.println("The Stock with the highest price: " +highest+"\n");
	}
			
	/**
	 * This finds and prints out to the console and output file the highest stock price
	 * @param o		//Array Object
	 * @param fileName
	 * @throws IOException
	 */
	public void FindLowest(Stock [] o, PrintWriter fo) throws IOException {
		//This declares and initializes the string object for the name of the 
		//lowest priced stock
		String lowest = new String();
		
		//Variables
		int index = 0;												//This declares the integer variable 
																	//for the index and initializes it to zero
		double value = o[0].GetCurrentPrice();						//This declares the double variable 
																	//for the value and initializes it to the 
																	//current price of the first element
		
		for(int i = 0; i<o.length; i++) {							//This sets the value to the highest 
																	//stock price while the counter is less
																	//than the object array length
			
			if(o[i].GetCurrentPrice() < value) {					//This sets the first variable to 
				value = o[i].GetCurrentPrice();						//the current price in the given element
				index = i;											//of the object array and sets the second
			}														//variable to the current index.
		}															//This occurs if the current price for 
																	//the current element for the array is
																	//less than the value variable.
		
		lowest = o[index].GetName();								//This sets the variable for the lowest 
																	//priced stock as the stock name of the
																	//given element of the object array.
		
		//This prints out the name of the lowest priced stock onto the console and the output file
		fo.println("The Stock with the lowest price: " +lowest +"\r\n");
		System.out.println("The Stock with the lowest price: " +lowest);
	}
				
	/**
	 * This reads the file and places the contents in a string array
	 * @param f
	 * @return
	 * @throws IOException
	 */
	public String [] ReadFile (String f) throws IOException  {		//This declares and initializes the 
		File test = new File(f);									//file objects for the counting and
		File file = new File(f);									//the reading of the file				 
																	
		String count = new String();								//This stores the values while 
																	//counting the lines in the file
		
		Scanner fileInput1 = new Scanner(test);						//This accepts the input of the 
		Scanner fileInput2 = new Scanner(file);						//counting and reading file objects
		
		int i = 0;													//This creates the integer variable 
																	//used to keep track of how many 
																	//lines are used
		
		while(fileInput1.hasNext()) {								//This counts the number of lines
			count = fileInput1.nextLine().trim();					//by accepting the input of each line
			if(!(count.isEmpty())) {								//and, if the line is not blank, 
				i++;												//incrementing the counter variable
			}													 	//while there is a next line.	
		}														
		
		//This closes the input file object for counting the lines
		fileInput1.close();
		
		//This determines if the number of stocks is too small or too large
		if(i<MIN_NUMBER_OF_STOCKS){
			String [] a = new String[]{"There are too few stocks for the program."};
			fileInput2.close();
			return a;		
		}
		else if(i>MAX_NUMBER_OF_STOCKS) {
			String [] a = new String[]{"There are too many stocks for the program."};
			fileInput2.close();
			return a;
		}
		
		//This stores the strings of each line in each element of the array
		String [] array = new String [i];

		i=0;														//This reinitializes the
																	//counting variable in order 
																	//to start from the first 
																	//element of the string array.
		
		while(fileInput2.hasNext()) {								//This accepts the file input 
			count = fileInput2.nextLine().trim();					//and stores it in each array 
			if(!(count.isEmpty())) {								//element of the string array
				array [i] = count;									//without leading white space 
				i++;												//and, if the line is not blank, 
			}//Closes if statement									//increments the counter
																	//variable while there is 
		}//Closes while loop - fileInput2							//a next line.							
																	
		//This closes the file object that reads each line in file
				fileInput2.close();
				//This returns the string array
				return array;
			}															
		
	/**
	 * This sets the stock information of the object array as the information from the file
	 * and returns that object array
	 * @param f
	 * @return
	 * @throws IOException
	 */
	public Stock [] StockInformation(String f, PrintWriter a) throws IOException {
		Stock object = new Stock(); 								//This declares and 
																	//initializes the stock object
		
		String [] stockFile = object.ReadFile(f);					//This declares a string array 
																	//and strings from the file of
																	//the given name
		
		//This declares and initializes the stock array to the string array length
		if(stockFile[0] == "There are too few stocks for the program." || stockFile[0] == "There are too many stocks for the program.") {
			System.out.println(stockFile[0]);
			a.print(stockFile[0] + "\r\n");
			System.exit(10007);
		}//Closes if statement - stockFile
		 
		Stock [] array = new Stock[stockFile.length];				//This declares and initializes
																	//the stock array to the string 
																	//array length
		
		String delim = "[,]";										//This declares the String 
																	//delimiter and initializes it as a comma.
																	//This is used to indicate what 
																	//character the string should be parsed.
		
		for(int i=0; i<stockFile.length; i++) {						//This sets the name, symbol, and current 
																	//price of each stock while
																	//the counter is less than the length 
																	//of the string array.
		 
			String [] stockInfo = stockFile[i].split(delim);		//This declares a string array and 
																	//sets it equal to the element of the stock
																	//string array parsed.
		
			array[i] = new Stock();									//This initializes the given element of 
																	//the stock array
		
			array[i].SetName(stockInfo [0]);						//These set the name, symbol, 
			array[i].SetSymbol(stockInfo [1]);						//and the price of the stock in the stock array
			array[i].SetCurrentPrice(Double.parseDouble(stockInfo[2]));//according to the String array's first,
		}//Closes for loop - stockFile.length						//second, and third element respectively.
																	//When setting the price, the string
																	//array element is converted into a double.
		
		return array;												//This returns the stock array.
	}//Closes StockInformation array
	
}//Closes public Stock Class