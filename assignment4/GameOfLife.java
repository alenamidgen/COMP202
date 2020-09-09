//By Alena Midgen, 
import java.util.Arrays;
public class GameOfLife {

	public static void main(String[] args) {
	}
	public static boolean isValidUniverse (int[][] arr) {
		
		// it sets the length variable to the array length of the first element
		int length = arr[0].length;
		
		// the method loops through the elements and if the length of each sub array doesn't equal the length of the first, it returns false
		for (int i = 1; i<arr.length; i++) {
			if (arr[i].length != length) {
				return false;
			}
		
		}
		
		// the method uses a nested loop to go through all of the inner elements
		for (int i = 0; i<arr.length; i++) {
			for (int j = 0; j< length; j++) {
				
				// if any integer doesn't equal to 0 or 1, the method returns false
				if ((arr[i][j] != 0)&& (arr[i][j] != 1)) {
					return false;
				}
			}
		}
		// if neither of these if statements were true, the method returns true
		return true;
	}
	
	//this method displays what the universe looks like using the '*' symbol
	public static void displayUniverse(int[][] input) {
		
		// again, the method loops through the columns and rows, however it starts at -1 and goes until one past the last index to account for the boarders around the cells
		for(int row =-1; row<=input.length;row++) {
			for (int column = -1; column<= input[0].length; column++) {
				
				// a series of if and if else statements determine which sybmol must be printed
				// the first few print out the boarder 
				if((row == -1 || row == input.length) && (column == -1 || column ==input[0].length)) {
					System.out.print('+');
				} else if (row == -1 || row == input.length) {
					System.out.print('-');
				} else if (column == -1 || column == input[0].length) {
					System.out.print('|');
				
				// after the boarder is printed, if the row and column numbers are also index numbers:
				} if (row !=-1 && row!=input.length && column !=-1 && column !=input[0].length) {
					
					// a space is printed if the cell is dead
					if (input[row][column] == 0) {
						System.out.print(' ');
					
					// a star is printed if the cell is alive
					} if (input[row][column] ==1) {
						System.out.print('*');
					}
				}	
			}
			//after each iteration of a row, a new row is started using println
			System.out.println();
		}
	}
	
	// this method determines weather a cell will be dead or alive after a generation
	public static int getNextGenCell(int[][] input, int x, int y) {
		
		// integer variables are created to represent the number of live neighbours a cell has and the last column and row number of the universe
		int liveNeighbours = 0;
		int lastColumn = input[0].length -1;
		int lastRow = input.length-1;
		
		
		// a series of if statments are used to count the number of live neighbours a cell has by checking the values of the neighbours (each coordinate is +/- 1 )
		// however, to avoid index out of bounds exceptions, the method first ensures that the neighbour it is checking in each if statment exists
		// it does this by seeing if x or y is on the edge of the universe (if it has value of 0, lastColumn or lastRow)
		if(y>0 && input[x][y-1] == 1 ) { 
			liveNeighbours++;
		}if (y< lastColumn &&input[x][y+1]==1) {
			liveNeighbours++;
		} if (x>0 && input[x-1][y] ==1) { 
			liveNeighbours++;
		} if (x< lastRow && input[x+1][y] ==1) {
			liveNeighbours++;
		} if (x>0 && y>0 && input [x-1][y-1] ==1) { 
			liveNeighbours++;	
		} if (x>0 && y< lastColumn && input[x-1][y+1] ==1) {
			liveNeighbours++;
		} if (x< lastRow && y>0 && input[x+1][y-1]==1) {
			liveNeighbours++;
		} if (x<lastRow && y< lastColumn && input[x+1][y+1]==1) {
			liveNeighbours++;
		
		// then, more if statements are used with the number of live neighbours to determine the state of the cell in the next generation	
		// if the cell is live and has less than 2 live neighbours, it dies (returns 0)
		}if (input [x][y] == 1 && liveNeighbours<2) {
			return 0;
		
		// otherwise if the cell is live and has 2 or 3 live neighbours, it lives (returns 1)
		}else if ( input[x][y] ==1 && (liveNeighbours ==2 || liveNeighbours==3)) {
			return 1; 
		
		// if the cell is live and has more than 3 neighbours it dies 
		} else if (input[x][y] ==1 && liveNeighbours>3) {
			return 0;
		
		// if the cell is dead and has 3 live neighbours it comes back to life
		} else if (input[x][y] == 0 && liveNeighbours == 3) {
			return 1; 
		
		// if none of the above are true, the cell remains as is 
		} else {
			return input[x][y];
		}
	}
	
	//this method returns the universe after a generation
	public static int[][] getNextGenUniverse (int[][] universe){
		
		// the number of rows and columns are set as variables
		int rows = universe.length;
		int columns = universe[0].length;
		
		// a new 2 dimensional integer array is created with the same number of rows and columns as the inputted universe
		int [][] nextGenUniverse = new int[rows][columns];
		
		// the method loops through the rows and columns of the universe array
		for(rows = 0; rows<universe.length; rows++) {
			for (columns = 0; columns<universe[0].length; columns++) {
				
				// the method uses the getNextGenCell method to find the values of each cell after a generation and sets this to equal each cell of corresponding coordinates in the new array 
				nextGenUniverse[rows][columns]=getNextGenCell(universe, rows, columns);
			}
		}
		
		// this new array is then returned
		return nextGenUniverse;
	}
	
	// the final method puts the others together to fully simulate the game of life
	public static void simulateNGenerations(int[][] seed, int n) { 
		
		// first, the seed is checked to see if it is valid, if not, an exception is thrown and a message is displayed
		if (isValidUniverse(seed)== false) {
			throw new IllegalArgumentException("The inputted array is not a valid universe. Please input an array that is rectangular.");
		}
		
		// the method prints out the inputted array and its label
		System.out.println("Original seed");
		displayUniverse(seed);
		
		// an empty line is printed
		System.out.println();
		
		// each iteration of this loop represents a generation, it continues until it is equal to the input variable n
		for (int i=1; i<=n; i++) {
			
			// the method prints the generation number along with the universe at that generation (using displayUniverse and getNextGeneration methods on the seed
			System.out.println("Generation " + i);
			displayUniverse(getNextGenUniverse(seed));
			
			// after each generation, the seed is updated so that it equals the universe at that generation
			seed = getNextGenUniverse(seed);
		}
	}
	
}
