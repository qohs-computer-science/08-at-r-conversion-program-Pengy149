/*
 * Name: Kevin Zheng 
 * Date: 09/18/2024 
 * Class Period: 3 
 * Class Name: ConversionsProgram 
 * Program Description: First, the program welcomes the user and asks for what they would like to convert and their corresponding number. If the user enters an invalid
 * input, the program asks again until the user enters a valid number. Next, if the user chose 1 for binary to decimal, the program asks for the binary value and then converts
 * the value to its decimal counterpart and if the user chose 2 for decimal to binary, the program asks for the decimal value and then converts the value to its binary 
 * counterpart. Finally, the program asks the user if they want to continue the program or not and if the user responds with no, the program ends, but if the user responds 
 * with yes, the program loops back to the beginning and asks the user what they would like to convert and their corresponding number. 
 */

// Math is imported in order to help do the calculations in the program 
import java.lang.Math;

// Scanner is imported in order to be able to get user input 
import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
		// Implement Program Requirements Here
		System.out.print("Welcome! ");
		boolean quit = false;
		int choice = 3;
		String decide = "yes";
		Scanner userIn = new Scanner(System.in);

		while (quit == false) {
			System.out.println("You have the following options:");
			System.out.println("1. Binary to Decimal");
			System.out.println("2. Decimal to Binary");
			while (choice != 1 && choice != 2) {
				System.out.print("Which type of conversion would you like to perform?  "); 
				choice = userIn.nextInt();
				userIn.nextLine();
			} // end while loop 
			
			if(choice == 1) {
				System.out.print("What is the binary number?  "); 
				String binInput = userIn.nextLine();
				System.out.println(binToDec(binInput));
			} // end if statement 
			else {
				System.out.print("What is the decimal number?  "); 
				int decInput = userIn.nextInt();
				userIn.nextLine();
				System.out.println(decToBin(decInput));
			} // end else statement 

			System.out.print("Do you want to continue - yes or no?  ");
			decide = userIn.nextLine();
			if (decide.equals("no")) 
				quit = true;
			choice = 3;
		} // end while loop 

	} // end main 

	public static String binToDec (String bin) {
		// binary to decimal
		String binary = bin;
		int decimal = 0;
		int bits = binary.length();
		double toAdd = Math.pow(2,bits-1);

		for (int i = 0; i < bits; i++) {
			if(binary.charAt(i) == '1')
				decimal += toAdd;
			toAdd /= 2;
		} // end for loop 
		return ("The decimal equivalent is: " + decimal);
	} // end binToDec

	public static String decToBin (int dec) {
		// decimal to binary 
		int decimal = dec;
		String binary = "";
		int bits = 1;
		int count = 2;

		while (count <= decimal) {
			count *= 2;
			bits++;
		} // end while loop 

		for (int i = bits; i > 0; i--) {
			if (decimal >= Math.pow(2, i-1)) {
				binary = binary + "1";
					decimal -= Math.pow(2, i-1);
				} // end if statement 
			else
				binary = binary + "0";
		} // end for loop 
		return ("The binary equivalent is: " + binary);
	} // end decToBin

} // end class 
