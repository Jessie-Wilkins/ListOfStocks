import java.io.IOException;
import java.util.Scanner;

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
		
		System.out.print(array[0].getName());
		
		
		input.close();
		
		
		
			
	}

}
