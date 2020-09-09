//By Alena Midgen 
public class Bunco {

	public static void main(String[] args) {
		
	
	}
//a method to simulate the roll of a die
	public static int diceRoll() {
		
		//the outcome of the die is stored as an integer and returned
		
		int diceNumber = (int)((6 * (Math.random())) + 1);
		return diceNumber;
	}
	// this method calculates the score based on the outcome of three die
	public static int getScore(int dieOne, int dieTwo, int dieThree, int roundNumber) {
		
		// if all three die match the round number, 21 points are scored
		if ((dieOne == dieTwo) && (dieTwo == dieThree) && (dieThree == roundNumber)) {
			return 21;
		
		// if all three die match each other, 5 points are scored	
		} else if ((dieOne == dieTwo) && (dieTwo == dieThree)) {
			return 5; 
	
		// if two of the die match the round number, 2 points are scored
		}else if (((dieOne == roundNumber) && (dieTwo == roundNumber)) || ((dieTwo == roundNumber) && (dieThree == roundNumber)) || ((dieOne== roundNumber) && (dieThree == roundNumber))) {
			return 2;
			
		//if one of the die match the round number, 1 point is scored	
		} else if ((dieOne == roundNumber) || (dieTwo == roundNumber) || (dieThree == roundNumber)) {
			return 1;
		
		// if none of the above occur, the player scores 0 points
		} else {
			return 0;
		}
	}

	
	// this method simulates a round of bunco being played by one player
	public static int playOneRound(String name1, int roundNumber) {
		
		//if the round number that was an input is not a number between 1 and 6
		if ((roundNumber < 1) || (roundNumber > 6)) {
			
			//the program prints an error and returns -1
			System.out.println("Error: invalid input");
			return -1; 
		} else {
		
		//otherwise, the dice roll method is called three times and stored as an integer each time	
		int dieOne = diceRoll(); 
		int dieTwo = diceRoll();
		int dieThree = diceRoll(); 
		
		//these values are used as input to get the score of the round, which is stored as an integer
		int points = getScore(dieOne, dieTwo, dieThree, roundNumber); 
		
		//the program displays what the player rolled and their score
		System.out.println(name1 + " rolled " + dieOne + " " + dieTwo + " " + dieThree + " and scored " + points + " points");	
	
		//the number of points the player received is returned
		return points;
		}
	}
	
	// the final method simulates a game of Bunco being played between two players
	public static void playBunco(String name1, String name2) {
		
		// the variables for the number of points each player has are declared and set to 0
		int name1Points = 0;
		int name2Points = 0;
		
		
		
		// this loop goes through each round, where the integer i is used as input into the method playOneRound as the round number
		for (int i=1; i<=6; i++) {
			
			//the program prints the round number and an empty line
			System.out.println("ROUND #:" + i);
			System.out.println();
			
			//after each round, the number of points scored by each player is added to the previous number of points they had
			name1Points = playOneRound(name1, i)+ name1Points;
			name2Points = playOneRound(name2, i) + name2Points;
		
			// the progam prints an empty line, then each players' score after each round		
			System.out.println();
			System.out.println(name1 + "'s score after round " + i + " is " + name1Points);
			System.out.println(name2 + "'s score after round " + i + " is " + name2Points);
			System.out.println("-------------------------------------------");
		}
		// after the game ends (loop is finished executing) the method displays the winner by comparing the number of points each player has
		if (name1Points > name2Points) {
			System.out.println(name1 + " wins!");
		} else if (name2Points > name1Points) {
			System.out.println(name2 + " wins!");
		
		// if neither player has a higher score than the other, the method declares the game to be a tie	
		} else {
			System.out.println("Tie game!");
		}
	}
}
