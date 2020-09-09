// by alena midgen 
import java.util.Random;
import java.util.Arrays;
public class Deck {

//all three attributes are private, the random attribute is static	
	private Card[] cardsInDeck;
	private int numOfCardsInDeck;
	private static Random numberGenerator = new Random(123);
	
	public Deck() {
	
	// an array of strings is created to help create the deck of cards using a nested loop
		String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
		cardsInDeck = new Card[52];
	
	// the varaible representing the number of cards left in the deck is set to 52
		numOfCardsInDeck = 52;
	
	//the card index is created to help with the loops and initiating the cards
		int cardIndex = cardsInDeck.length-1;
		for (int i=0; i<4; i++) {
			for (int j= 1; j<14; j++) {
				cardsInDeck[cardIndex] = new Card (j, suits[i]);
				cardIndex--;
			}
		}
	}

//this method directly returns the number of cards left using the this keyword
	public int getNumOfCards() {
		return this.numOfCardsInDeck;
}

// the method makes a copy of the deck of cards and returns it
// must be the copy since it is public and it prevent others from altering the attribute
	public Card[] getCards() {
		Card[] deckCopy = new Card[numOfCardsInDeck];
		for (int i = 0; i<cardsInDeck.length; i++) {
			deckCopy[i] = cardsInDeck[i];
		}
		return deckCopy;
	}
	public void showCards() {
	
	//again, the method copies the cards in deck into another array
		Card[] cardsPresent = new Card[cardsInDeck.length];
		for (int i = 0; i<numOfCardsInDeck; i++) {
			cardsPresent[i]=cardsInDeck[i];	
		}
	
	// the method prints each card using the get value and suit methods from the other class
		for (int index = numOfCardsInDeck-1; index >=0; index--) {
			System.out.print(cardsPresent[index].getValue() + " of " + cardsPresent[index].getSuit());
		
		// it puts a comma in between each card and a period at the end, determined using an if statement 
			if (index !=0) {
				System.out.print(", ");
			} else {
				System.out.print(".");
			}
		}
	}
	public void shuffle() {
	
	// a loop is created so the shuffling of two cards occurs 1000 times
		for (int i = 0; i<1000; i++) {
		
		// two integers are generated from the random
			int x = numberGenerator.nextInt(numOfCardsInDeck);
			int y = numberGenerator.nextInt(numOfCardsInDeck);
		
		// these integers are used to swap the values of the two cards using a temporary variable
			Card first = cardsInDeck[x];
			Card second = cardsInDeck[y];
			Card temp = first;
			cardsInDeck[x]= second;
			cardsInDeck[y]=temp;
		}
	}
	public Card deal() {
	
	//if there aren't any cards left, the method returns null
		if (numOfCardsInDeck ==0) {
			return null;
		}else {
		
		// the top card is identified and removed from the deck by creating the beginning of the deck again without it
			Card topCard = cardsInDeck[numOfCardsInDeck-1];
			Card[] newDeck = new Card[numOfCardsInDeck-1];
			for (int i=0; i<numOfCardsInDeck-1; i++) {
				newDeck[i] = cardsInDeck[i];
			}
		
		// the variable representing the number of the cards decreases and and the deck is set to equal the new one created
			numOfCardsInDeck--;
			cardsInDeck = newDeck;
		
		// the top card is returned
			return topCard;
		}
	}
	public Card pickACard(int index){
	
	// if the number of card to be selected doesn't exist in the deck, null is returned
		if (index> numOfCardsInDeck-1) {
			return null;
		} else {
		
		// the selected card is set to a variable, same with the index of the selected card
			Card selectedCard = cardsInDeck[numOfCardsInDeck-1-index];
			int cardIndex = numOfCardsInDeck-index-2;
		
		// the method loops through the cards in deck and omits the one that was selected by making two seperate loops
			for (int i = 0; i<cardIndex; i++) {
				cardsInDeck[i]=cardsInDeck[i];
			}
			for (int i = cardIndex+1; i< numOfCardsInDeck-1; i++) {
				cardsInDeck[i]=cardsInDeck[i+1];
			}
		
		// the number of cards is decreased and the selected card is returned
			numOfCardsInDeck--;
			return selectedCard;
		}
	}

	public void restockDeck() {
	
	// the method restocks the deck by recreating the deck as it did in the constructor
		String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
		cardsInDeck = new Card[52];
		numOfCardsInDeck = 52;
		int cardIndex = cardsInDeck.length-1;
		for (int i=0; i<4; i++) {
			for (int j= 1; j<14; j++) {
				cardsInDeck[cardIndex] = new Card (j, suits[i]);
				cardIndex--;
			}
		}
	}
	public static void main(String[] args) {
	
	}
}
