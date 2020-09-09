//By Alena Midgen
public class InputAnalyzer {
	public static void main(String[] args) {

// Each input is assigned as a double variable	

		double a = Double.parseDouble(args[0]);
		double b = Double.parseDouble(args[1]);
		double c = Double.parseDouble(args[2]);

// boolean variables are created to shorten the print statements
// It is assumed that 0.0 is considered a non-negative, even number

		boolean allNonNegative = (a>=0 && b>=0 && c>=0);
		boolean oneIsEven = (a%2 == 0 || b%2 == 0 || c%2 == 0);
		boolean decreasingOrder = (a>b && b>c);

//The program displays the boolean statments

		System.out.println("The numbers " + a + ", " + b + " and " + c + " are all non-negative:" + allNonNegative); 
		System.out.println("At lease one between " + a + ", " + b + " and " + c + " is even:" + oneIsEven);
		System.out.println("The numbers " + a + ", " + b + " and " + c + " are in a strictly decreasing order: " + decreasingOrder);
		System.out.println("The numbers " + a + ", " + b + " and " + c + " are either all non-negative or in a strictly decreasing order: " + (allNonNegative || decreasingOrder));
		System.out.println("The numbers " + a + ", " + b + " and " + c + " are all non-negative numbers and none of them is even: " + (allNonNegative && (! oneIsEven)));	
	
	}
}
