//File is created and maintained by a-elhawary 19/06/2019
//OfflineGame class is responsible for the interaction between other classes, as it holds the instances
//of the Players and Cards in the game.
import java.util.*;

public class OfflineGame {
	private InGamePlayer connectedPlayers[4];
	private int currentPlayerTurn;
	private ArrayList<Card> graveyard;
	private Stack cardPile;
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
		// get current size of list into numOfElements 
		// create an array of booleans sized by numOfElements
		// create a shuffledCards list with size numOfElements - 1
		// set all of the array to false
		// loop from 0 to numOfElements - 1
		// generate a random number
		// while the boolean list at the index of random number is true
		// generate new random number
		// endwhile
		// set boolen list at random number to true
		// shuffledCards at i = cards ar random number
		// endloop
		// return shuffledCards
		
		//	TODO place actual return value
		return null;
	}	
	
	private Stack formCardPile(){
		return null;
	}
	
	// returns a Card object or null if the cardPile is empty
	private Card getCardFromPile(){
		Card newCard = null;
			
		if(!cardPile.isEmpty){
			newCard = cardPile.pop();
		}
	
		// if the cardPile wasn't empty, but became empty, set graveardToPile to true 
		// so that at the end of the turn resetPile will be called if the graveyard isn't empty;
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
			for(int j = 0; j<4; j++){
				currentCard = getCardFromPile();
				currentPlayer = connectedPlayers.get(j);
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
