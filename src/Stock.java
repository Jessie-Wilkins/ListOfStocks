import java.util.Random;			//Import Random Generator
import java.io.*;
import java.util.Scanner;


public class Stock {
	//Variables
	private String companyName;		//String object holding name of Company
	private String companySymbol;	//String object holding Stock Symbol
	private String outputFileName;	//String object holding the output file
	private String inputFileName;	//String object holding the input file
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
	/**
	 * This sets the output file name as the given string
	 * @param s
	 */
	public void SetOutputFileName(String s) {
		outputFileName = s;
	}
	/**
	 * This sets the input file name as the given string if the file exists
	 * @param s
	 */
	public void SetInputFileName(String s) {
		//This declares and initializes the file object for the file of the given name
		File file = new File(s);
		
		//This sets the input file name as the given string if it exists.
		//Otherwise, it prints an error statement and exits the program.
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
	/**
	 * This returns the output file name
	 * @return
	 */
	public String getOutputFileName() {
		//returns the output file name
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
	public void printResults(String cN, String cS, double cP, double nP, double rn) throws IOException {
		//Print results to screen for user to see the Stock Prices Fluctuation
		System.out.printf("%s\t%s\t%.2f\t\t\t%.2f\t\t%.2f\t\t%.2f\n", cN, cS, cP, nP, nP-cP, rn);
	}
	/**
	 * This finds and prints out to the console and the output file the sum of the stock prices
	 * @param o
	 * @param fileName
	 * @throws IOException
	 */
	public void FindSum(Stock [] o, PrintWriter fo) throws IOException {

		//Variables		
		double sum = 0;				//This declares the double used as the sum and initializes it to zero
		
		//This finds the sum of the stock prices while the counter is less than
		//the array length and sets it as the double variable
		for(int i=0; i<o.length; i++) {
			sum+=o[i].getCurrentPrice();
		}
		fo.printf("The sum: %.2f\r\n", sum);
		System.out.printf("The sum: %.2f\n", sum);
		//This closes the output file object
	}
	/**
	 * This finds and prints out to the console and the output file the average of the stock prices
	 * @param o
	 * @param fileName
	 * @throws IOException
	 */
	public void FindAverage(Stock [] o, PrintWriter fo) throws IOException {
		//Variables		
		double sum = 0;				//This declares the double used as the sum and initializes it to zero
		double average;				//This declares the double used as the average
		
		//This finds the sum of the stock prices while the counter is less than
		//the array length and sets it as the double variable
		for(int i=0; i<o.length; i++) {
			sum+=o[i].getCurrentPrice();
		}
		//This finds the average and sets it as the double variable
		average = sum/o.length;
		//This prints the average to the console and the file
		fo.printf("The average: %.2f\r\n", average);
		System.out.printf("The average: %.2f\n", average);
		//This closes the output file object;
	}
	/**
	 * This finds and prints out to the console and output file the highest stock price
	 * @param o
	 * @param fileName
	 * @throws IOException
	 */
	public void FindHighest(Stock [] o, PrintWriter fo) throws IOException {
		//This declares and initializes the string object for the name of the 
		//highest priced stock
		String highest = new String();
		
		//Variables
		int index = 0;				//This declares the integer variable for the index and initializes it to zero
		double value = 0;			//This declares the double variable for the value and initializes it to zero
		//This sets the value to the highest stock price 
		//while the counter is less than the object array length
		for(int i = 0; i<o.length; i++) {
			//This sets the first variable to the current price in the given element
			//of the object array and sets the second variable to the current index.
			//This occurs if the current price for the current element for the array is 
			//greater than the value variable.
			if(o[i].getCurrentPrice() > value) {
				value = o[i].getCurrentPrice();
				index = i;
			}
		}
		//This sets the variable for the highest priced stock as the stock name of 
		//the given element of the object array.
		highest = o[index].getName();
		//This prints out the name of the highest priced stock onto the console and the output file
		fo.println("The Stock with the highest price: " +highest+"\r\n");
		System.out.println("The Stock with the highest price: " +highest+"\n");
	}
	/**
	 * This finds and prints out to the console and output file the highest stock price
	 * @param o
	 * @param fileName
	 * @throws IOException
	 */
	public void FindLowest(Stock [] o, PrintWriter fo) throws IOException {
		//This declares and initializes the string object for the name of the 
		//lowest priced stock
		String lowest = new String();
		//Variables
		int index = 0;							//This declares the integer variable for the index and initializes it to zero
		double value = o[0].getCurrentPrice();	//This declares the double variable for the value and initializes it to the current price of the first element
		
		//This sets the value to the highest stock price 
		//while the counter is less than the object array length
		for(int i = 0; i<o.length; i++) {
			//This sets the first variable to the current price in the given element
			//of the object array and sets the second variable to the current index.
			//This occurs if the current price for the current element for the array is 
			//less than the value variable.
			if(o[i].getCurrentPrice() < value) {
				value = o[i].getCurrentPrice();
				index = i;
			}
		}
		//This sets the variable for the lowest priced stock as the stock name of 
		//the given element of the object array.
		lowest = o[index].getName();
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
	public String [] ReadFile (String f) throws IOException  {
		//This declares and initializes the file objects for the counting and the reading of the file
		File test = new File(f);
		File file = new File(f);
		//This stores the values while counting the lines in the file
		String count = new String();
		//This accepts the input of the counting and reading file objects
		Scanner fileInput1 = new Scanner(test);
		Scanner fileInput2 = new Scanner(file);
		//This creates the integer variable used to keep track of how many lines are used
		int i = 0;
		//This counts the number of lines by accepting the input of each line
		//and incrementing the counter variable while there is a next line.
		while(fileInput1.hasNext()) {
			count = fileInput1.nextLine();
			i++;
		}
		//This closes the input file object for counting the lines
		fileInput1.close();
		//This stores the strings of each line in each element of the array
		String [] array = new String [i];
		//This reinitializes the counting variable in order to start from the first element of the 
		//string array.
		i=0;
		//This accepts the file input and stores it in each array element of the string array
		//and increments the counter variable while there is a next line.
		while(fileInput2.hasNext()) {
			array [i] = fileInput2.nextLine();
			i++;
		}
		//This closes the file object output
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
	public Stock [] StockInformation(String f) throws IOException {
		//This declares and initializes the stock object 
		Stock object = new Stock();
		//This declares a string array and strings from the file of the given name
		String [] stockFile = object.ReadFile(f);
		//This declares and initializes the stock array to the string array length
		Stock [] array = new Stock[stockFile.length];
		//This declares the String delimiter and initializes it as a comma.
		//This is used to indicate what character the string should be parsed.
		String delim = "[,]";
		//This sets the name, symbol, and current price of each stock while
		//the counter is less than the length of the string array.
		for(int i=0; i<stockFile.length; i++) {
			//This declares a string array and sets it equal to the element of the stock
			//string array parsed.
			String [] stockInfo = stockFile[i].split(delim);
			//This initializes the given element of the stock array
			array[i] = new Stock();
			//These set the name, symbol, and the price of the stock in the stock array
			//according to the String array's first, second, and third element respectively.
			//When setting the price, the string array element is converted into a double.
			array[i].setName(stockInfo [0]);
			array[i].setSymbol(stockInfo [1]);
			array[i].setCurrentPrice(Double.parseDouble(stockInfo[2]));
		}
		//This returns the stock array.
		return array;
	}
	
}//Closes public Stock Class
