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





import java.util.Random;			//Import Random Generator
import java.io.*;
import java.util.Scanner;


public class Stock {
	//Variables
	private String companyName;		//String object holding name of Company
	private String companySymbol;	//String object holding Stock Symbol
	private String outputFileName;
	private String inputFileName;
	private double currentPrice;	//Double holding Current Price of Stock
	private double nextPrice;		//Double holding Next Price of Stock
	private double randomNumber;	//Double holding random Number
	
	/**
	 * This sets the private variables to the default
	 */
	public Stock() {
		//Assigns default values for private variables
		companyName = "Microsoft";	//Assigns company name as default
		companySymbol = "MSFT";		//Assigns company symbol as default
		currentPrice = 46.87;		//Assigns current price as default
		nextPrice = 46.87;			//Assigns next price as default
	}//Closes Stock Method
	
	/**
	 * Determines if the default values should be used
	 * @param cN
	 * @param cS
	 * @param cP
	 */
	public void WhichDefaultValue(String cN, String cS, double cP) {
		//This sets the name, symbols, and current price if they do not equal the default value keywords
		if(!(cN.contentEquals("NONE")) && !(cS.contentEquals("NA")) && cP != 0.0) {
			setName(cN);
			setSymbol(cS);
			setCurrentPrice(cP); 
		}//Closes if statement
		
	}//Closes WhichDefaultValue Method
	/**
	 * Sets the private variables to the given values
	 * @param n
	 * @param s
	 * @param cP
	 * @param nP
	 */
	public Stock(String n, String s, double cP, double nP) {
		//Stock Method that creates user instance of Stock details
		companyName = n;
		companySymbol = s;
		currentPrice = cP;
		nextPrice = nP;
	}//Closes public Stock Method
	/**
	 * This sets the company name to the given string
	 * @param n
	 */
	public void setName(String n){
		//Assigns the name to the private variable
		companyName = n;
	}
	/**
	 * This sets the company symbol to the given string
	 * @param s
	 */
	public void setSymbol(String s) {
		//Assigns the symbol to the private variable
		companySymbol = s;
	}
	/**
	 * This sets the current price to the given double
	 * @param cP
	 */
	public void setCurrentPrice(double cP) {
		//Error Checking for: currentPrice > 0, set the value to the variable; otherwise set to 1
		if(cP > 0) {
			currentPrice = cP;
		}//Close if statement
		
		else {
			currentPrice = 1;
		}//Close if statement
	}//Closes setCurrentPrice Method
	/**
	 * This sets the next price to the given double
	 * @param nP
	 */
	public void setNextPrice(double nP) {
		//Error Checking for: nextPrice > 0, set the value to the variable; otherwise set to 1
		if(nP > 0) {
			nextPrice = nP;
		}//Close if statement
		
		else {
			nextPrice = 1;
		}//Close else statement
	}//Closes setNextPrice Method
	/**
	 * This sets the percentage to the given double
	 * @param p
	 */
	public void setPercentage(double p) {
		//Error Checking for: randomNumber > 0, set the value to the variable; otherwise set to 1
		if(p > 0) {
			randomNumber = p;
		}
		else {
			randomNumber = 1.00;
		}
	}//Closes setPercentage Method
	
	public void SetOutputFileName(String s) {
		outputFileName = s;
	}
	public void SetInputFileName(String s) {
		File file = new File(s);
		
		if(file.isFile()) {
			
			inputFileName = s;
		}
		else{
			System.out.print("Does not work.");
			System.exit(1004);
		}
		
	}
	/**
	 * This returns the company name 
	 * @return
	 */
	public String getName() {
		//returns the name of the company
		return companyName;
	}
	/**
	 * This returns the company symbol
	 * @return
	 */
	public String getSymbol() {
		//returns the name of the company
		return companySymbol;
	}
	/**
	 * This returns the current price
	 * @return
	 */
	public double getCurrentPrice() {
		//returns the current price of the company
		return currentPrice;
	}
	/**
	 * This returns the next price 
	 * @return
	 */
	public double getNextPrice() {
		//returns the current price of the company
		return nextPrice;
	}
	/**
	 * This returns the percentage
	 * @return
	 */
	public double getPercentage() {
		//returns the random number
		return randomNumber;
	}
	public String getOutputFileName() {
		return outputFileName;
	}
	public String GetInputFileName() {
		return inputFileName;
	}
	/**
	 * This changes next price according the percentage by a negative or positive number
	 */
	public void priceChange() {
		//Variables
		boolean decide;						//declares a boolean
		double percent;						//declares a double used as the percent
		double currentPrice;				//declares a double used as the current price
		
		//This declares the random generator object
		Random randInt = new Random();
		//This sets the percentage as a random integer between 0 and 10
		setPercentage(randInt.nextInt(10));
		//This sets the variable as the percentage
		percent = getPercentage();
		//This sets the variable as the current price
		currentPrice = getCurrentPrice();
		//This declares the random generator object
		Random negOrPos = new Random();
		//This assigns the variables as a boolean
		decide = negOrPos.nextBoolean();
		
		//This sets the next price as the current price - the percentage of current price
		//if decide is true
		if(decide) {
			setNextPrice(currentPrice-(currentPrice*.01*percent));
		}//Close if statement
		//This sets the next price as the current price + the percentage of current price
		//if the former condition is false
		else {
			setNextPrice(currentPrice+(currentPrice*.01*percent));
		}//Close else statement
		
	}//Closes priceChange Method
	
	/**
	 * Prints Headers for each Category
	 */
	public void printHeaders(){
		//Outputs the header names
		System.out.println("STOCK\tSYMBOL\tYESTERDAY'S PRICE\tTODAY'S PRICE\tPRICE MOVEMENT\tCHANGE PERCENT");
	}
	
	/**
	 * This prints the Headers & stock information
	 * @param cN
	 * @param cS
	 * @param cP
	 * @param nP
	 * @param rn
	 */
	public void printResults(String cN, String cS, double cP, double nP, double rn) {
		//Print results to screen for user to see the Stock Prices Fluctuation
		System.out.printf("%s\t%s\t%.2f\t\t\t%.2f\t\t%.2f\t\t%.2f\n", cN, cS, cP, nP, nP-cP, rn);
	}
	public void FindAverage(Stock [] o) {
		double sum = 0;
		double average;
		
		for(int i=0; i<o.length; i++) {
			sum+=o[i].getCurrentPrice();
		}
		average = sum/o.length;
		
		System.out.printf("The average: %.2f\n", average);
	}
	
	public void FindHighest(Stock [] o) {
		String highest = new String();
		int index = 0;
		double value = 0;
		
		for(int i = 0; i<o.length; i++) {
			if(o[i].getCurrentPrice() > value) {
				value = o[i].getCurrentPrice();
				index = i;
			}
		}
		highest = o[index].getName();
		System.out.println("The Stock with the highest price: " +highest);
	}
	
	public void FindLowest(Stock [] o) {
		String lowest = new String();
		int index = 0;
		double value = o[0].getCurrentPrice();
		
		for(int i = 0; i<o.length; i++) {
			if(o[i].getCurrentPrice() < value) {
				value = o[i].getCurrentPrice();
				index = i;
			}
		}
		lowest = o[index].getName();
		System.out.println("The Stock with the lowest price: " +lowest);
	}
	
	public String [] ReadFile (String f) throws IOException  {
		File test = new File(f);
		File file = new File(f);
		String count = new String();
		Scanner fileInput1 = new Scanner(test);
		Scanner fileInput2 = new Scanner(file);
		int i = 0;
		while(fileInput1.hasNext()) {
			count = fileInput1.nextLine();
			i++;
		}
		fileInput1.close();
		String [] array = new String [i];
		i=0;
		while(fileInput2.hasNext()) {
			array [i] = fileInput2.nextLine();
			i++;
		}
		fileInput2.close();
		return array;
	}
	
	public Stock [] StockInformation(String f) throws IOException {
		Stock object = new Stock();
		String [] stockFile = object.ReadFile(f);
		Stock [] array = new Stock[stockFile.length];
		String delim = "[,]";
		for(int i=0; i<stockFile.length; i++) {
			String [] stockInfo = stockFile[i].split(delim);
			array[i] = new Stock();
			array[i].setName(stockInfo [0]);
			array[i].setSymbol(stockInfo [1]);
			array[i].setCurrentPrice(Double.parseDouble(stockInfo[2]));
		}
			
		return array;
	}
	
	
	
}//Closes public Stock Class
