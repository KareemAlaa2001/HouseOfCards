/*File is created and maintained by a-elhawary 19/06/2019
 *OfflineGame class is responsible for the interaction between other classes, as it holds the instances
 *of the Players and Cards in the game.*/
import java.util.*;

public class OfflineGame {
	private static final int NUM_OF_PLAYERS = 4;

	private InGamePlayer connectedPlayers[];
	private int currentPlayerTurn;
	private ArrayList<Card> graveyard;
	private Stack<Card> cardPile;
	private boolean changeInTurn;
	private int turnsSinceLastChange;
	private boolean graveyardToPile;
	// still needs to add Hashmap of cards and abilities
	
	// the constructor acts as the "initGame" and "assignHouses" methods in the class diagram
	public OfflineGame(){
		// initialize four players
		// loop through each player
		// create a new player instance
		// create a new House instance 
		// set player's House instance
		// add player instance to connectedPlayers
		// set currentPlayerTurn to 0
		// initialize Graveyard
		// generate list of cards and add to cardPile using the method
		// initialize changeInTurn to false
		// intialize turnsSinceLastChange
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
	
	private Stack<Card> formCardPile(){
		//Generate an unshuffled card deck of the playable cards
		ArrayList<Card> tempCardDeck = new ArrayList<Card>();
		//there are four shapes and 10 cards per shape
		for(int shape = 0; shape < 4; shape++){
			for(int attackPoints = 1; attackPoints <= 10; attackPoints++){
				Card card = new Card();
				card.setAttackPoints(attackPoints);
				card.setShape(shape);
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
		//	TODO put real return value
		return null;
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
				currentPlayer = connectedPlayers[j];
				currentPlayer.addToHand(currentCard);			
			}
		}
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

	private void sendCardsToGraveyard(){
	
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
}
