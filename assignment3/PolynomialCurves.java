//By Alena Midgen
public class PolynomialCurves {

	public static void main(String[] args) {
		/*double[] line = {-2.0, 12};
		double[] parabola = {0.1, -1, -8};
		int [] pointOne = {0, 2};
		int[] pointTwo = {0, -8};
		int[] pointThree = {-5, -1};
		int [] pointFour = {3, 5};
		double lineThickness = 1;
		double parabolaThickness = 1.05;
		double [] test = {9.0};
		
		drawCurve(line, 1, '*');*/
		//System.out.println(onCurve(pointFour, parabola, parabolaThickness));
	}

	// this method checks to see if a certain point is on a curve
	public static boolean onCurve(int [] coordinates, double [] coefficients, double thickness) {
		
		// a double variable is created to represent the polynomial (value of y) and set to 0
		double polynomial = 0;
		
		// the method loops through the coefficient array
		for (int i=0; i< coefficients.length; i++) {
			
			// the polynomial is composed of its previous values plus the value of the coefficient at the index of the loop multiplied by the x coordinate to the power of the coefficient length -1-i
			// therefore, this adds all the terms of the polynomial
			polynomial = polynomial + coefficients[i]*Math.pow(coordinates[0], (coefficients.length)-1-i);	
		}
		
		// the program then checks the inequality to see if the point is on the line, and returns the coresponding boolean statements
		if (((coordinates[1]-thickness) < polynomial) && (polynomial < (coordinates[1] + thickness))) {
			return true; 
		}else {
			return false;
		}
	}
	
	// this method checks if the given coefficient array and thickness are valid
	public static void verifyInput(double[] coefficients, double thickness) {
		
		// if there are less than one elements in the coefficient array, an exception is thrown
		if(coefficients.length<1) {
			throw new IllegalArgumentException ("No coefficients have been given, please ensure there is at least one.");
		
		// if the thickness is less than or equal to 0, an exception is thrown (assuming thickness can't be 0) 
		}if (thickness<=0) {
			throw new IllegalArgumentException ("The thickness of the curve must be a positive number.");
		}
	}
	
	
	// this final method draws the curve given the coefficients, thickness and symbol is must be drawn with
	public static void drawCurve(double[] coefficients, double thickness, char symbol) {
		
		// the coefficients and thickness inputs are verified to be valid
		verifyInput(coefficients, thickness);
		
		// a variable for the y intercept is created and set to 0, it will be filled in later with its actual value
		double yIntercept=0;
		
		// the upper and lower bounds are created, representing how far up and down the y axis should go
		int upperBound=10;
		int lowerBound=-10;
		
		//the y intercept is found by using a loop to find the polynomial (similar to how it was done before) except where x=0
		for (int i=0; i<coefficients.length; i++) {
			yIntercept= yIntercept + coefficients[i] * Math.pow(0, (coefficients.length)-1-i);
		}
		
		// if the y intercept is greater than 5, the upper bound is adjusted to by 5 larger than the intercept
		if (yIntercept>5) {
			upperBound = (int) yIntercept+5;
		
		// the same occurs for the lower bound if the intercept is less than -5
		} if (yIntercept<-5) {
			lowerBound = (int) yIntercept-5;
		}
		
		// the double loop is created representing the x and y coordinates of the grid
		for(int y= upperBound; y>= lowerBound; y--) {
			for (int x = -10; x<=10; x++) {
				
				// the array representing coordinates x and y are created
				int [] coordinates = {x, y};
				
				// if the coordinates (the iteration of the loops) belongs on the curve (found using other method)
				if(onCurve (coordinates, coefficients, thickness) == true) {
					
					// the symbol is printed, and the method moves to the next iteration
					System.out.print(symbol);
					continue;
				
				// if the y value is the upper bound and the x value is 0, the top arrow, ^, is printed and the loop moves to the next iteration
				} if (y==upperBound && x==0) {
					System.out.print('^');
					continue;
				
				// the same occurs to create the left arrow, >
				} if (y==0 && x==10) {
					System.out.print('>');
					continue;
				
				// if both coordinates are 0, the method prints the +, this is the origin
				} if (y==0 && x==0) {
					System.out.print('+');
				
				// otherwise if the y value is zero, the horizontal axis is created from printing -
				} else if (y==0) {
					System.out.print('-');
				
				// the same occurs if x=0 to print the vertical axis using |
				} else if (x==0) {
					System.out.print('|');
				
				// if none of these instances occur, the method prints an empty space
				} else {
					System.out.print(" ");
				}
			
			}
			//after each iteration of the inner loop, a new line is created
			System.out.println();
		}
	}
}
