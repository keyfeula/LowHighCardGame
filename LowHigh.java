import java.util.ArrayList;
import java.util.Scanner;

/*Name: Key Feula
 *Description: Simple card game where the user is given a card then the probability of drawing each card
 *     and the probability of the next card being higher or lower in value. The user then guesses whether 
 *          the next card will be higher or lower than their current card, and gets a point if they are correct.
 * 
 */

public class LowHigh {

	
	public static void main(String[] args) {
		
		
		Bag deck = new Bag();
		deck.fillWithCards();
		
		Boolean keepPlaying = true;
		String alreadyPlayed = "";
		
		Scanner input = new Scanner(System.in);
		
		//All card values in deck - used for frequency method
		Card card2 = new Card(2,0);
		Card card3 = new Card(3,0);
		Card card4 = new Card(4,0);
		Card card5 = new Card(5,0);
		Card card6 = new Card(6,0);
		Card card7 = new Card(7,0);
		Card card8 = new Card(8,0);
		Card card9 = new Card(9,0);
		Card card10 = new Card(10,0);
		Card card11 = new Card(11,0);
		Card card12 = new Card(12,0);
		Card card13 = new Card(13,0);
		Card cardA = new Card(14,0);
		
		int gameScore = 0;
		
		Card currentCard = deck.grab();
		
		do {
			
			
			System.out.println("Cards Left: " + deck.getCurrentSize());
			
			//Probability of drawing each card value in the game
			System.out.println("Probability of drawing: \n");
			System.out.printf("2   %.2f%s \n", ((double)deck.getFreuqencyOf(card2)/(double)deck.getCurrentSize()) * 100, "%");
			System.out.printf("3   %.2f%s \n", ((double)deck.getFreuqencyOf(card3)/(double)deck.getCurrentSize()) * 100, "%");
			System.out.printf("4   %.2f%s \n", ((double)deck.getFreuqencyOf(card4)/(double)deck.getCurrentSize()) * 100, "%");
			System.out.printf("5   %.2f%s \n", ((double)deck.getFreuqencyOf(card5)/(double)deck.getCurrentSize()) * 100, "%");
			System.out.printf("6   %.2f%s \n", ((double)deck.getFreuqencyOf(card6)/(double)deck.getCurrentSize()) * 100, "%");
			System.out.printf("7   %.2f%s \n", ((double)deck.getFreuqencyOf(card7)/(double)deck.getCurrentSize()) * 100, "%");
			System.out.printf("8   %.2f%s \n", ((double)deck.getFreuqencyOf(card8)/(double)deck.getCurrentSize()) * 100, "%");
			System.out.printf("9   %.2f%s \n", ((double)deck.getFreuqencyOf(card9)/(double)deck.getCurrentSize()) * 100, "%");
			System.out.printf("10   %.2f%s \n", ((double)deck.getFreuqencyOf(card10)/(double)deck.getCurrentSize()) * 100, "%");
			System.out.printf("J   %.2f%s \n", ((double)deck.getFreuqencyOf(card11)/(double)deck.getCurrentSize()) * 100, "%");
			System.out.printf("Q   %.2f%s \n", ((double)deck.getFreuqencyOf(card12)/(double)deck.getCurrentSize()) * 100, "%");
			System.out.printf("K   %.2f%s \n", ((double)deck.getFreuqencyOf(card13)/(double)deck.getCurrentSize()) * 100, "%");
			System.out.printf("A   %.2f%s \n\n", ((double)deck.getFreuqencyOf(cardA)/(double)deck.getCurrentSize()) * 100, "%");
			
			//Probability of the next card drawn being higher or lower in value than the current card
			System.out.println("Probablity of next card being: ");
			
			//Counts number of cards in deck higher than the current card in hand
			int higherCardTotal = 0;
			for(int cardValue = currentCard.getValue() + 1; cardValue <= 14; cardValue++) {
				Card tempCard = new Card(cardValue,0);
				higherCardTotal += deck.getFreuqencyOf(tempCard);
			}
			
			//Counts the number of cards in deck lower than the current card in hand
			int lowerCardTotal = 0;
			for(int cardValue = currentCard.getValue() - 1; cardValue >= 2; cardValue--) {
				Card tempCard = new Card(cardValue,0);
				lowerCardTotal += deck.getFreuqencyOf(tempCard);
			}
			
			//Counts the number of cards in deck of the same value as the current card
			int sameCardTotal = 0;
			sameCardTotal = deck.getFreuqencyOf(currentCard);
			
			//Determines the probability of the next card being a higher, lower, or same value card
			System.out.printf("Lower: %.2f%s\n",((double)lowerCardTotal/(double)deck.getCurrentSize()) * 100 ,"%");
			System.out.printf("Higher: %.2f%s\n",((double)higherCardTotal/(double)deck.getCurrentSize()) * 100 ,"%");
			System.out.printf("Same: %.2f%s\n\n",(double)sameCardTotal/(double)deck.getCurrentSize() ,"%");
					
			alreadyPlayed += currentCard.cardToString() + " ";
			
			System.out.println("Already Played: " + alreadyPlayed);
			System.out.println("Current card: " + currentCard.cardToString());
			
			 Card nextCard = deck.grab();
			
			//User guesses whether next card will be higher or lower than the current card
			System.out.println("\nGuess: \n1 - Lower\n2 - Higher\n3 - Same\n4 - Quit\n");
			int response = input.nextInt();

			switch(response) {
				case 1:
					if(nextCard.getValue() < currentCard.getValue()) {
						System.out.println("Correct!\n");
						gameScore++;
					}
					else
						System.out.println("Incorrect!\n");
					break;
				case 2:
					if(nextCard.getValue() > currentCard.getValue()) {
						System.out.println("Correct!\n");
						gameScore++;
					}
					else
						System.out.println("Incorrect!\n");
					break;
				case 3:
					if(nextCard.getValue() == currentCard.getValue()) {
						System.out.println("Correct!\n");
						gameScore++;
					}
					else
						System.out.println("Incorrect!\n");
					break;
				case 4:
					keepPlaying = false;
					System.out.println("\nYour score is: " + gameScore + "\nBetter luck next time!");
					break;
			}
			
			currentCard = nextCard;
			
			
		} while(keepPlaying);
				
		
		
	}
	

}
