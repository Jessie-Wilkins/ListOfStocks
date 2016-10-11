import java.io.IOException;			//Imports IOException Method
import java.util.Scanner;			//Imports Scanner Method to scan input file

//*******************************
//*	START OF StockList CLASS	*
//*******************************
public class StockList {

	public static void main(String[] args) throws IOException {
		Stock listObject = new Stock();
		
		String inputFileTitle = new String();
		String outputFileTitle = new String();

		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please type in the name of the input file: ");
		
		listObject.SetInputFileName(input.nextLine());
		
		inputFileTitle = listObject.GetInputFileName();
		
		System.out.print("Please type in the name of the output file");
		
		listObject.SetOutputFileName(input.nextLine());
		outputFileTitle = listObject.getOutputFileName();
		
		Stock [] array = listObject.StockInformation(inputFileTitle);
		
		listObject.FindAverage(array, outputFileTitle);
		
		listObject.FindHighest(array, outputFileTitle);
		
		listObject.FindLowest(array, outputFileTitle);
		
		input.close();
		
		
		
			
	}

}
