// By Alena Midgen
public class PizzaCalc {
	public static void main(String[] args) {

		int modeSelect = Integer.parseInt(args[0]);

//Program differentiates between different methods to run using the first input number
//The program displays the mode that was selected

		if (modeSelect == 1) {
			System.out.println("You selected \"Quantity Mode\".");
			quantityMode(args[1], args[2]);
		} else if (modeSelect == 2) {
			System.out.println("You selected \"Price Mode\".");
			priceMode(args[1], args[2], args[3], args[4]);
		}else {
			System.out.println("The mode you have selected is not supported.");
		}
	}

	// QUANTITY MODE
	//The second and third inputs are named as the diameters of the large and small pizzas, this information is displayed
	
	public static void quantityMode(String largeDiameter, String smallDiameter) {  
	
		System.out.println("The diameter of the large pizza is " + largeDiameter + " inches.");
		System.out.println("The diameter of the small pizza is " + smallDiameter + " inches.");

	//The input strings are converted to integers, and the areas of the pizzas are calculated	
		
		int largeDiaInt = Integer.parseInt(largeDiameter);
		int smallDiaInt = Integer.parseInt(smallDiameter);
		double largeArea = Math.PI*(Math.pow((largeDiaInt /2), 2));
		double smallArea = Math.PI*(Math.pow((smallDiaInt/2), 2));
		
	//The program displays an empty line, then the ratio of the areas of the pizzas, which is how many small pizzas Johnny should order 
		
		System.out.println();
		System.out.println("You should order " + largeArea/smallArea + " small pizzas.");
	}

	//PRICE MODE
	//The following four inputs are named and stored as int and double variables
	
	public static void priceMode(String largeDiameter, String largePrice, String smallDiameter, String smallPizzas) {
	
		int largeDiaInt = Integer.parseInt(largeDiameter);
		double largePriceDouble = Double.parseDouble(largePrice);
		int smallDiaInt = Integer.parseInt(smallDiameter);
		int smallPizzasInt = Integer.parseInt(smallPizzas);
	
	//The system displays the information from the variables	
		
		System.out.println("The diameter of the large pizza is " + largeDiaInt + " inches.");
		System.out.println("The price of one large pizza is " + largePriceDouble + " dollars.");
		System.out.println("The diameter of the small pizza is " + smallDiaInt + " inches.");
		System.out.println("You want to buy " + smallPizzasInt + " small pizzas.");
		
	//After a blank line, the program shows how much to pay for the number of small pizzas by multiplying the price of the large pizza to the ratio of the areas of the pizzas and the number of small pizzas wanted	
	//Pi is not shown as part of the ratio of areas as it can be canceled out of the division	
		
		
		System.out.println();
		System.out.println("The fair price to pay for " + smallPizzasInt + " small pizzas is " + (largePriceDouble*Math.pow((smallDiaInt/2.0), 2)*smallPizzasInt /Math.pow((largeDiaInt/2), 2)) + " dollars.");
	
	}
}
