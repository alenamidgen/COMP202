//By Alena Midgen 
public class ISBN {
	public static void main(String[] args) {
		
		// The program takes an integer input "x"
	
		int x = Integer.parseInt(args[0]); 
	
	// The integer is split into its digits by taking the remainder of the division of multiples of 10
	
		int digitTwo = x%10; 
		int digitThree = (x/10)%10;
		int digitFour = (x/100)%10;
		int digitFive = (x/1000)%10;
	
	// The isbn sum is calculated and stored as an integer
	
		int isbnSum = (5 * digitFive) + (4 * digitFour) + (3 * digitThree) + (2 * digitTwo); 
	
	//The isbn sum and the last digit (d1) must add to be a multiple of 11 
	
		int digitOne = 11 - (isbnSum%11);
	
	// The program displays what this last digit should be, if it is less than ten it shows the number.
	// If the last digit should be 10, the program displays that is should be "X" instead.
	//If the isbn sum is already a multiple of 11, the program shows that the last digit must be 0.	
		
		if (digitOne < 10) {
			System.out.println( "The last digit must be: " + digitOne + ".");
		} else if (digitOne == 10) {
			System.out.println("The last digit must be: X.");
		} else {
		System.out.println("The last digit must be: 0.");
		}
	}	
}
