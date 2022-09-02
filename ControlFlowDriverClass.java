import java.util.Scanner;
import java.lang.Math;
import java.util.regex.Matcher;//for error checking
import java.util.regex.Pattern;//for error checking

public class ControlFlowDriverClass {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		// print the valid characters for input
		System.out.println("These are all of the valid input characters you can type: \n");
		AsciiChars.printNumbers();
		AsciiChars.printUpperCase();
		AsciiChars.printLowerCase();
		
		//get and echo user name
		System.out.print("Please enter your name: ");
		String name = isInputBad(scnr.nextLine());
		System.out.printf("Hello %s! ", name);
		
		//confirm program continuation
		System.out.print("Do you wish to continue to the interactive portion of the program? ('yes'/'y' to continue, anything else to quit): ");
		String stayOrGo = scnr.nextLine();
		switch(stayOrGo) {
		case "yes":
			lotteryInterrogation();
		break;
		case "y":
			lotteryInterrogation();
		break;
		default:
			System.out.println("Please return later to complete the survey! :)");
		break;
		}
	}//end of main method
	
	//method is placed outside of main method to 
	//assure user doesn't get asked questions of 
	//they opt out of being questioned for the 
	//lottery.
	public static void lotteryInterrogation() {
		Scanner scnr = new Scanner(System.in);
		
		//loop to repeat questions
		do {
			//getting input from user
			System.out.print("Do you have a red car? (yes, no): ");
			String redCar = isInputBad(scnr.next());
			//red car variable is useless, but required by project doc
			
			System.out.print("What's the name of your favorite pet? ");
			String petName = isInputBad(scnr.next());
			
			System.out.print("What's the age of your favorite pet? ");
			int petAge = isInputANumber(scnr.next());
			
			System.out.print("What's your lucky number? ");
			int luckyNumber = isInputANumber(scnr.next());
			
			System.out.print("Do you have a favorite quarterback?  If so what is their jersey number? ");
			int jerseyNumber = isInputANumber(scnr.next());
			
			System.out.print("What is the two-digit model year of your car? ");
			int modelYear = isInputANumber(scnr.next());
			
			System.out.print("What's the first name of your favorite actor? ");
			String actorFirstName = isInputBad(scnr.next());
			
			System.out.print("Enter a random number between 1 and 50: ");
			int num1to50 = isInputANumber(scnr.next());
			int fiftyMax = 50;
			num1to50 = keepWithinRange(num1to50, fiftyMax);
			
			//RNG 3 nums 1<=x<=65
			int tempRandNum1 = (int)(Math.random()*64 + 1);
			int tempRandNum2 = (int)(Math.random()*64 + 1);
			int tempRandNum3 = (int)(Math.random()*64 + 1);
			
			//maximum of random number range constants
			int magicMax = 75;
			int randMax = 65;
			
			//magic_ball randomized declaration
			int magic_ball;
			if(jerseyNumber < luckyNumber) {
				magic_ball = jerseyNumber*tempRandNum2;
			}
			else {
				magic_ball = luckyNumber*tempRandNum3;
			}
			
			//assures magic_ball is within 1-75 range
			magic_ball = keepWithinRange(magic_ball, magicMax);
			
			//5 random numbers declaration
			
			
			//* Find the 3rd letter of their favorite pet.  Convert that character value to an integer value.
			int randNum1 = (int)petName.charAt(2);
			randNum1 = keepWithinRange(randNum1, randMax);
			
			//* Use the value 42.
			int randNum2 = 42;
			//no need for randNumOutOfRange(randNum2);
			
			//* Use the random number between 1 and 50, subtracting one of the generated random numbers.
			int randNum3 = (int)(num1to50 - tempRandNum1);
			randNum3 = keepWithinRange(randNum3, randMax);
			
			//* Convert the first letter of their favorite actor/actress to an integer and use that value.
			int randNum4 = (int)(actorFirstName.charAt(0));
			randNum4 = keepWithinRange(randNum4, randMax);
			
			//* Convert the last letter of their favorite actor/actress to an integer and use that value.
			int randNum5 = (int)(actorFirstName.charAt(actorFirstName.length()-1));
			randNum5 = keepWithinRange(randNum5, randMax);
			
			
			//print values
			System.out.printf("Lottery numbers: %d, %d, %d, %d, %d  Magic ball: %d\n", randNum1, randNum2, randNum3, randNum4, randNum5, magic_ball);
			
			//utility method to check if player wants to go again
		} while(continuation() == true);
	}//end of lotteryInterrogation
	
	
	//assures random numbers remain within their respective ranges
	public static int keepWithinRange(int numToCheck, int max) {
		int min = 1;
		
		//makes sure program doesn't run a million times
		//if user enters obnoxiously large number
		//OVERRIDES REQUESTED TESTING PROCEDURE IF INPUT IS NOSENSICAL
		if (numToCheck > 10000 || numToCheck < -10000) {
			numToCheck = (int)(Math.random()*(max-min) + min);
		}
		
		//find where it's out of range and fix it
		if (numToCheck > max) {
			numToCheck = numToCheck - max;
		}
		else if (numToCheck < min) {
			numToCheck = numToCheck  + max;
		}
		else {}//do nothing
		
		//recurse and calculate again if initial calculation doesn't fix range issue
		if ((numToCheck > max) || (numToCheck < min)) {
			keepWithinRange(numToCheck, max);//recursive
		}
		
		return numToCheck;
	}//end of keepWithinRange method
	
	//utility method to check if user wants to answer
	//more lottery questions
	public static boolean continuation() {
		//gets continuation 
		Scanner scnr = new Scanner(System.in);
		System.out.print("Would you like to play again and generate another set of lottery numbers? (y/n): ");
		char response = scnr.next().charAt(0);
		
		switch(response) {
		case 'y':
			System.out.println("\n");//create some line space
			return true;
		case 'n':
			System.out.println("Thank you for playing!");
			return false;
		default:
			System.out.println("Invalid input, try again!");
			continuation();
		break;
		}
		return false;
	}//end of continuation method
	
	//checks if input is bad
	public static String isInputBad(String thingToCorrect) {
		Scanner scnr = new Scanner(System.in);
		
		Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(thingToCorrect);
		boolean b = m.find();

		while (b == true) {//if b is true, input is bad
		   System.out.print("Whoops! Enter a value for this question using the valid characters listed at the top of the program: ");
		   thingToCorrect = scnr.next();
		   p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		   m = p.matcher(thingToCorrect);
		   b = m.find();
		}
		return thingToCorrect;//special character checking should be done by this point	
	}//end of input checker method
	
	//checks if int input is bad
	public static int isInputANumber(String numToCorrect) {
		Scanner scnr = new Scanner(System.in);
		
		Pattern p = Pattern.compile("[^0-9 ]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(numToCorrect);
		boolean b = m.find();
		
		 while (b == true) {//if b is true, input is bad
			   System.out.print("Whoops! Enter a positive NUMBER for this question using the digits listed at the top of the program: ");
			   numToCorrect = scnr.next();
			   p = Pattern.compile("[^0-9 ]", Pattern.CASE_INSENSITIVE);
			   m = p.matcher(numToCorrect);
			   b = m.find();
		}
		int correctedInt = Integer.parseInt(numToCorrect);
		return correctedInt;
	}//end of isInputANumber method
	
}//end of driver class
