// By Alena Midgen
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
public class BullsAndCows {

	public static void main(String[] args) {
		/*int[] a = {2, 0, 6, 9};
		int[] b = {9, 5, 6, 2};
		int[] c = {2, 0, 6, 2};
		int[] d = {1, 2, 3};
		int[] e = {3, 2, 1};
		
		
		System.out.println(getNumOfCows(d, e));*/
		//playBullsAndCows(5);
		//System.out.println(Arrays.toString(extractDigits(22223)));
			
	}
	
	// this method checks to see if an inputted array, arr, contains an inputted integer, x
	public static boolean contains(int [] arr, int x) {
		// if the array has 0 elements, it returns false
		if (arr.length ==0) {
			return false; 
		//otherwise, the program loops through the array
		}else {
			for (int i = 0; i<arr.length; i++) {
				//if any element of the array is equal to x, the true is returned
				if(arr[i] == x) {
					return true;
				}
			}
			// if this code is reached, it means the array was looped through without coming across x, so the element isn't in the array
			return false;
		}
	}
	
	// this method creates an array of four digits from an integer input
	public static int [] generateSecretDigits(int input) {
		//the output array is created and set to have 4 elements
		int[] output = new int[4];
		//the program uses Random to create the first element of the output array
		Random r = new Random(input);
		output[0] = r.nextInt((9)+1);
		//the program loops through the following elements of the array, and assigns them random digits
		for (int i = 1; i<=3; i++) {
			int nextElement = r.nextInt((9)+1);
				//an inner loop is created to loops through the previous elements of the output array 
				for (int j=0; j<i; j++) {
					// if the potential value for the new element has the same value as any of the previous elements, the element must get a new value
					if(nextElement==output[j]) { 
						// i is set back by one, so it can find a new value  
						i-=1;	
					// if the potential value created for the new element doesn't match a value for a previous element, it is assigned to the element of the array
					} else {
						output[i] = nextElement;
					}
				}
			}	
		
		// after all elements of the array have been initialized, the array is returned 
		return output;
	}
	
	// this method takes the digits of an input number and puts them into an array of the same order
	public static int [] extractDigits(int input) {
		
		//First, the length of the integer input is found by converting it into a string and using .length()
		int length = (Integer.toString(input).length());
		
		// if the length is less than four, this variable is set to 4 since the array must have at least 4 elements
		if(length<4) {
			length = 4;
		}
		
		//if the number was negative, the length of the string is set to be one less since one character was the - sign
		if(input < 0) {
			length --;
		}
		
		// the new array is created with the length the same as the length of the input
		int [] digitsArray = new int [length];
		
		// the program loops through the length, starting at the end
		for (int i=length-1; i>=0; i--) {
			
			// if the input was a positive number, the array at the index is equal to the remainder of the input divided by 10 (this is the last digit)
			if (input>0) {
				digitsArray[i] = input%10;	
			
			// if the input was negative, the array at the index is equal to the negative of the remainder of the input divided by 10, to ensure no negative values
			} else {
				digitsArray[i] = -1*(input%10);
			}
			
			// the input is set to itself divided by 10, which just takes away the last digit
			input=input/10;
		}	
		
		// this array created is then returned after the loop finishes
		return digitsArray;
	}

	
	// this method finds the number of bulls by comparing the guessed array and the array of secret numbers
	public static int getNumOfBulls(int[] secretNumDigits, int[] guess) {
		if (secretNumDigits.length != guess.length) {
			
			// if the lengths of the arrays don't match up, an exception is thrown
			throw new IllegalArgumentException ("The number of digits of the secret number and guess do not match");
		
		}else {
			
			//otherwise, the arrays are looped through, and the program counts how many times the elements of the arrays are equal when the indexes are equal
			// by using a counter variable, starting at zero
			int counter=0;
			for (int i = 0; i<guess.length; i++) {
				if (secretNumDigits[i] == guess[i]) {
					counter++;
				}
			}
			
			// the counter variable is returned, this is also the number of bulls
			return counter;
		}
	}
	
	// this method returns the number of cows when the arrays of the secret digits and guess are inputted
	public static int getNumOfCows(int[] secretNumDigits, int[] guess) {
		
		if (secretNumDigits.length != guess.length) {
			// if the lengths of the arrays don't match up, an exception is thrown
			throw new IllegalArgumentException ("The number of digits of the secret number and guess do not match.");
		
		} else {
			// otherwise, a counter variable is declared and set to 0
			int counter = 0;
			
			// the program loops through the arrays
			for (int i = 0; i<guess.length; i++) {
				
				//if the secret number array contains the value of the guessed array at i (checked using "contains" method
				if(contains(secretNumDigits, guess[i])==true) {
				
					//this number that's in both is set to be an int variable
					int numInBoth = guess[i];
					
					// the program loops through the guess array and looks for when the element is equal to the element in both arrays
					for (int j = 0; j<guess.length; j++) {
						if(guess[j]== numInBoth) {
					
							// when this happens, it loops through the array of the secret number
							for (int k =0; k<secretNumDigits.length; k++) {
							
								// if the indexes are equal when the elements are equal in both arrays 
								if (secretNumDigits[k]==numInBoth && k==j) {
								
									// the counter variable decreases by one, this isn't a cow because it's a bull
									counter--; 
								
									//if this doesn't occur, the program continues looping
								} else {
									continue;
								}
							}
						}
					}
					// the counter increases by one after it finds that there's a number in both, if it's a bull, the increase is countered by the decrease earlier
					counter++;
				}
			}
			// the counter is returned, this is the number of cows
			return counter;
		}
	}
	
	
	// the final method stimulates of game of bulls and cows being played
	public static void playBullsAndCows(int input) {
		
		// the integer array of secret digits is created by calling the "generateSecretDigits" method using the method's input as input here
		int [] secretDigits = generateSecretDigits(input);
		
		// the program prints out a welcome message
		System.out.println("Welcome to Bulls and Cows! Are you ready to guess the four-digit number?");
		System.out.println();
		
		// a loop is created to keep track of the number of guesses 
		for (int i = 1; i>0; i++) {
			
			// the program prints a prompt and allows the user to type in a guess using the Scanner
			System.out.println("Guess #" + i + "- Enter a four digit positive number");
			Scanner guessBox= new Scanner(System.in);
			
			// the users input is set to an integer
			int guess = guessBox.nextInt();
			
			//the guess is converted to a string to judge its length
			if (((Integer.toString(guess)).length()) > 4|| guess<0) {
				
				// if the length of the string (digits of the integer) is greater than 4, or if the integer is negative, a message is printed prompting the user to guess a number of the correct form
				System.out.println("Sorry! Your guess must be a positive number with only 4 digits. Please try again!");
			
			}else {
				
				//if not, the method uses the previous two methods to obtain the values for and print the number of bulls and cows
				System.out.println("Bulls: " + getNumOfBulls(secretDigits, extractDigits(guess)) + " Cows: " + getNumOfCows(secretDigits, extractDigits(guess)));
				
				//if the number of bulls is 4, the method congratulates the player for guessing correctly and uses i as the number of tries
				}if (getNumOfBulls(secretDigits, extractDigits(guess)) ==4) {
					System.out.println("Congratulations! You cracked the code in " + i + " tries!");
					
					// when this happens, the loop is broken since the player doesn't need to guess anymore 
					break;
				
				}if(i>= 5) {
					
					//if the number of guesses is greater than 5, the program asks the user if they want to give up
					System.out.println("Don't worry, this is a tricky game. Would you like to give up? (Reply y/n)");
					
					// another scanner is used for the user to type a reply
					Scanner quitBox = new Scanner(System.in);
					
						// if the user types y, the system tells them they gave up after i tries
						if(quitBox.nextLine().equals("y")) {
							System.out.println("You gave up after "+ i + " tries. Better luck next time!");
						
							// the loop is broken as the game is over
							break;
						}
				}		
	
		}
	}	
}
