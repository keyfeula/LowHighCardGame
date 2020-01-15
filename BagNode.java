
public class BagNode {
	
	private Card card;	
	public BagNode next;
	
	//Constructor for a bag node with a card as the data and a reference to the next bag node
	public BagNode(Card card, BagNode next) {
		this.card = card;
		this.next = next;
	}
	
	//Constructor for a bag node - used to place first card in bag and sets next to null
	public BagNode(Card card) {
		this.card = card;
		this.next = null;
	}
	
	//Sets next bag node
	public void setNext(BagNode node) {
		this.next = node;
	}
	
	//Sets the card of a bag node
	public void setCard(Card card) {
		this.card = card;
	}
	
	//Returns next bag node in the list
	public BagNode getNext() {
		return next;
	}
	
	//Returns the card in the bag node
	public Card getCard() {
		return card;
	}
	
	

}
