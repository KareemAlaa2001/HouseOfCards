/*File is created and maintained by a-elhawary 19/06/2019
 *OfflineGame class is responsible for the interaction between other classes, as it holds the instances
 *of the Players and Cards in the game.*/
import java.util.*;

public class OfflineGame {
	private static final int NUM_OF_PLAYERS = 4;
	private static final int NUM_OF_HOUSES = 4;

	private ArrayList<InGamePlayer> connectedPlayers;
	private int currentPlayerTurn;
	private ArrayList<Card> graveyard;
	private Stack<Card> cardPile;
	private boolean changeInTurn;
	private int turnsSinceLastChange;
	private boolean graveyardToPile;
	// still needs to add Hashmap of cards and abilities
	
	// the constructor acts as the "initGame" and "assignHouses" methods in the class diagram
	public OfflineGame(){
		// initialize the attributes
		currentPlayerTurn = 0;
		graveyard = new ArrayList<Card>();
		cardPile = new Stack<Card>();
		changeInTurn = false;
		turnsSinceLastChange = 0;
		connectedPlayers = new ArrayList<InGamePlayer>();
		
		// get a random list of houses
		ArrayList<House> randomHouses = generateHouses();
		for(int i = 0; i < NUM_OF_PLAYERS; i++){
			InGamePlayer player = new InGamePlayer(randomHouses.get(i));
			connectedPlayers.add(player);
		}
		
		formCardPile();
		distributeCards();
	}	
	// returns a list of randomly ordered house instances. one for each shape
	private ArrayList<House> generateHouses(){
		ArrayList<Integer> shapes = new ArrayList<Integer>();
		shapes.add(House.CLUBS);
		shapes.add(House.HEART);
		shapes.add(House.DIAMOND);
		shapes.add(House.SPADE);
		
		ArrayList<House> houses = new ArrayList<House>();
		Random rand = new Random();
		for(int i = 0; i < NUM_OF_HOUSES; i++){
			int shape = rand.nextInt(shapes.size());
			House house = new House(shape);
			houses.add(house);
			shapes.remove(shape);
		}
		return houses;
	}

	private void formCardPile(){
		//Generate an unshuffled card deck of the playable cards
		ArrayList<Card> tempCardDeck = new ArrayList<Card>();
		//there are four shapes and 10 cards per shape
		for(int shape = 0; shape < 4; shape++){
			for(int attackPoints = 1; attackPoints <= 10; attackPoints++){
				Card card = new Card(attackPoints, new House(shape));
				card.setAttackPoints(attackPoints);
				tempCardDeck.add(card);
			}  
		}		
		//shuffle the deck 
		tempCardDeck = shuffle(tempCardDeck);
		// add the shuffled items one by one into the cardPile
		for(int i = 0; i < tempCardDeck.size(); i++){
			cardPile.push(tempCardDeck.get(i));
		}
		tempCardDeck.clear();
	}

	//method used in the constructor to distribute cards among the players at the start of each game
	private void distributeCards(){
		// Objects that will be used to temporarily store instances of players and cards 
		Card currentCard = null;
		InGamePlayer currentPlayer = null;
		// Loop 5 times, so that each player would get five cards
		for(int i = 0; i<5; i++){
			// Loop 4 times, once for each Player
			for(int j = 0; j < NUM_OF_PLAYERS; j++){
				currentCard = getCardFromPile();
				currentPlayer = connectedPlayers.get(j);
				currentPlayer.addToHand(currentCard);			
			}
		}
	}
	
	// takes in a list of cards and outputs a new list of cars
	private ArrayList<Card> shuffle(ArrayList<Card> cards){
		// stores the number of elements of the deck before any change
		int numOfElements = cards.size();
		ArrayList<Card> shuffledCards = new ArrayList<Card>(numOfElements);
		Random randGen = new Random();
		int randomNum;
		// stores the num of elements of the array as it changes
		int range;
		for(int i = 0; i < numOfElements; i++){
			range = cards.size();
			randomNum = randGen.nextInt(range);
			shuffledCards.add(cards.get(randomNum));
			cards.remove(randomNum);
		}
		return shuffledCards;		
	}	
	

	
	// returns a Card object or null if the cardPile is empty
	private Card getCardFromPile(){
		Card newCard = null;
			
		if(!cardPile.isEmpty()){
			newCard = cardPile.pop();
		}
	
		/* if the cardPile wasn't empty, but became empty, set graveardToPile to true 
		 so that at the end of the turn resetPile will be called if the graveyard isn't empty*/
		if(cardPile.isEmpty()){
			graveyardToPile = true;
		}
		return newCard;
	}

	public void endTradePhase(){
	
	}

	public void endTurn(){
	
	}

	public void showCards(){
	
	}

	public void hideCards(){
	
	}

	public void switchCardsBetweenPlayers(){
	
	}
	
	public void applyRelevantAbilities(){
	
	}

	public void manageAttack(){
	
	}

	private void sendCardToGraveyard(Card card){
	
	}

	private void resetPile(){
	
	}

	private void managePlayerDeath(){
	
	}

	private void addHousetoKillersSideHouses(){
	
	}

	private void allocateDeadPlayerCards(){
	
	}

	private void deallocateDeadPlayersSpecialCards(){
	
	}

	private void promptDraw(){
	
	}
	
// models the conflict between 2 cards
// cardsElimination method will check the card's hp.If it's less than or equals zero, send it to the graveyards. 
	public void conflict(Card a, Card b) {
		a.changeHealthPoints((-1*b.attackPoints));
		b.changeHealthPoints((-1*a.attackPoints));
        sendCardToGraveyard(a);
        sendCardToGraveyard(b);
	}
}
