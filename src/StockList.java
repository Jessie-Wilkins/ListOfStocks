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
		
		System.out.print("Please type in the name of the file: ");
		
		listObject.SetInputFileName(input.nextLine());
		
		inputFileTitle = listObject.GetInputFileName();
		
		Stock [] array = listObject.StockInformation(inputFileTitle);
		
		listObject.FindAverage(array);
		
		listObject.FindHighest(array);
		
		listObject.FindLowest(array);
		
		input.close();
		
		
		
			
	}

}
