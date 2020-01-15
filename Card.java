
public class Card {
	
	public final static int CLUBS = 0, DIAMONDS = 1, HEARTS = 2, SPADES = 3;
	public final static int ACE = 14, JACK = 11, QUEEN = 12, KING = 13;
	
	//suit of the card: spades, clubs, hearts, or diamonds
	private int suit;
	
	//value of the card
	private int value;
	
	/**
	 * Constructor for card objects
	 * @param cardValue - integer from 1 to 13
	 * @param cardSuit - integer from 0 to 3 that corresponds to a card suit
	 */
	public Card(int cardValue, int cardSuit) {
		if(cardValue >= 2 && cardValue <= 14) {
		value = cardValue;
		}
		
		if(cardSuit >= 0 && cardSuit <= 3) {
		suit = cardSuit;
		}
	}

	//Returns suit of the card
	public int getSuit() {
		return suit;
	}
	
	//Returns value of the card
	public int getValue() {
		return value;
	}
	
	//Returns the integer suit as a string
	public String suitToString() {
		switch (suit) {
			case CLUBS:
				return "Clubs";
			case DIAMONDS:
				return "Diamonds";
			case HEARTS:
				return "Hearts";
			case SPADES:
				return "Spades";
			default:
				return "XXX";
		}
	}
	
	//Returns the integer value as a string
	public String valueToString() {
		switch(value) {
			case 14:
				return "Ace";
			case 2:
				return "2";
			case 3:
				return "3";	
			case 4:
				return "4";	
			case 5:
				return "5";	
			case 6:
				return "6";	
			case 7:
				return "7";	
			case 8:
				return "8";	
			case 9:
				return "9";
			case 10:
				return "10";	
			case 11:
				return "Jack";	
			case 12:
				return "Queen";
			case 13:
				return "King";
			default:
				return "XXX";
		}
	}
	
	//Returns the card value and suit as a string
	public String cardToString() {
		return "[" + valueToString() + " of " + suitToString() + "]";
	}
	
	
	
}
