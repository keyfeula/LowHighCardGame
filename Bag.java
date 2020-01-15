import java.util.Random;

public class Bag {
	
	private BagNode head;
	private BagNode tail;
	private int size;
	
	//Constructor for an empty bag object, with a head pointer set to null
	public Bag() {
		size = 0;
		head = new BagNode(null,null);
	}
	
	
	//Returns current size of the bag, the number of cards in the bag	
	public int getCurrentSize() {
		return size;
	}
	
	
	//Adds a card to the bag
	public void add(Card card) {
	    size++;
	    BagNode newNode = new BagNode(card);
	    BagNode currentNode = head;
	    
	    while(currentNode.getNext() != null) {
	    	currentNode = currentNode.getNext();
	    	}
	    
	    	currentNode.setNext(newNode);
	    }
	
	
	//Counts the frequency of a card in the bag
	public int getFreuqencyOf(Card card){
		
        BagNode current = head;
        int count = 0;
        
        while (current.getNext() != null)
        {
        	Card currentCard = current.getNext().getCard();
        	int i = currentCard.getValue();
            if (i == card.getValue()) {
                count++;
            }
            current = current.getNext();
            
        }
        return count;
    }
	
	
	//Empties the bag by setting the head to null, which allows the list to be collected by GC
	public void empty() {
		head = null;
	}
	
	
	//Returns true if bag is empty, false is bag is not empty
	public boolean isEmpty() {
		if(head == null)
			return true;
		else
			return false;
	}
	
	
	//Fills the bag with 52 cards
	public void fillWithCards(){
		
		for(int i = 2; i <= 14; i++) {
			for(int j = 0; j <= 3; j++) {
				Card card = new Card(i,j);
				add(card);
				
			}
		}	
		
	}
	
	
	//Grabs a random card, returns it to the user, then deletes the node from the bag
	public Card grab() {
		
		Random r = new Random();
		int index = r.nextInt(size - 1 + 1) + 1;
		
        BagNode current = head;
        
        
        for (int i = 0; current != null && i < index - 1; i++) {
            current = current.next;
        }
        
        Card card =  current.getCard();
        BagNode next = current.next.next;
        current.next = next;
        size--;
        
        return card;
        
	}
	
	
	//Converts all cards in the bag to strings
	public String toString() {
		String deckList = "";
		
		if(head != null) {
			BagNode current = head.getNext();
			while(current != null) {
				deckList += "[" + current.getCard().cardToString() + "]\n";
				current = current.getNext();
			}
		}
		
		return deckList;		
		
	}
	
	

}
