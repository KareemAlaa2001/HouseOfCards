//File is created and maintained by a-elhawary 19/06/2019
import java.util.*;

public class OfflineGame {
	private ArrayList<InGamePlayer> connectedPlayers;
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
		//	TODO place actual return value
		return null;
	}
	
	private Card getCardFromPile(){
		//	TODO place actual return value
		return null;
	}
	
	private void distributeCards(){
		// loop 5 times (i)
		// loop 4 times for each player (j)
		// use getCardFromPile to get card
		// add card to player at j index 
		// endloop
		// endloop
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
