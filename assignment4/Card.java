// by alena midgen 
public class Card {

	// the two private attriutes are declared
	private int value;
	private String suit;
	
	public Card (int value, String suit) {
		
		// if the value isn't between 1 and 13 inclusive, an exception is thrown
		if (value<1 || value >13) {
			throw new IllegalArgumentException ("Invalid card value");
		
		// if the suit isn't spades, hearts, diamonds or clubs, ignoring the case, another exception is thrown
		}if (suit.equalsIgnoreCase("spades")== false && suit.equalsIgnoreCase("hearts")==false && suit.equalsIgnoreCase("diamonds") == false && suit.equalsIgnoreCase("clubs")== false) {
			throw new IllegalArgumentException ("Invalid card suit");
		
		// otherwise the values and suits are set using the this keyword
		} else {
			this.value = value;
			this.suit = suit;
		}
	}
	
	// this method returns the value 
	public int getValue() {
		return this.value;
	}
	
	// this method returns the suit
	public String getSuit() {
		return this.suit;
	}
	public static void main(String[] args) {
	
	}
}
