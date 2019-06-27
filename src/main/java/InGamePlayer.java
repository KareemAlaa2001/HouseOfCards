import java.util.*;

public class InGamePlayer {
	
	protected House mainHouse;
	protected ArrayList<House> sideHouses;
	public static ArrayList<Card> hand;
	protected ArrayList<Card> battleList;
	protected ArrayList<Card> tradeList;
	protected boolean usedShuffleAbility;
	protected double healthPoints;
	protected double activePerTurnEffect;
	protected double activeFullCycleEffect;
	
	
	// maximum cards allowed in trade list
	private static final int MAX_TRADE_LIST = 7;
	// starting health points for each player
	private static final int START_HEALTH_POINTS = 5000;

	public InGamePlayer(House mainHouse){
		this.mainHouse = mainHouse;
		sideHouses = new ArrayList<House>();
		hand = new ArrayList<Card>();
		battleList = new ArrayList<Card>();
		tradeList = new ArrayList<Card>();
		usedShuffleAbility = false;
		healthPoints = START_HEALTH_POINTS;
		activePerTurnEffect = 0;
		activeFullCycleEffect = 0;
	}

	public ArrayList<Card> getTradeList(){
		return tradeList;	
	}

	// returns true when card is added successfully. False when tradeList was full;
	public boolean addToTradeList(Card cardToAdd){
		if(tradeList.size() > MAX_TRADE_LIST){
			return false;
		}
		tradeList.add(cardToAdd);
		return true;
	}
	
	public void removeFromTradeList(Card cardToRemove){
		tradeList.remove(cardToRemove);
	}
	public void removeCardsFromTradeList(ArrayList<Card> cards){
		for(int i = 0; i < cards.size(); i++){
			removeFromTradeList(cards.get(i));
		}	
	}
	// battle list methods 
	public ArrayList<Card> getBattleList(){
		return battleList;
	}

	public void addToBattleList(Card cardToAdd){
		battleList.add(cardToAdd);	
	}

	//hand getters and setters and methods
	public ArrayList<Card> getHand(){
		return hand;
	}

	public void addToHand(Card card){
		hand.add(card);
	}
	
	public void addCardsToHand(ArrayList<Card> cards){
		for(int i = 0; i < cards.size(); i++){
			addToHand(cards.get(i)):
		}
	}

	public void applyPerTurnEffect(){
		healthPoints += activePerTurnEffect;	
	}
	
	public void applyFullCycleEffect(){
		healthPoints += activeFullCycleEffect;	
	}
	
	public double getHealthPoints() {
		return healthPoints;
	}

	public void setHealthPoints(double healthPoints) {
		this.healthPoints = healthPoints;
	}

	public double getActivePerTurnEffect() {
		return activePerTurnEffect;
	}

	public void setActivePerTurnEffect(double activePerTurnEffect) {
		this.activePerTurnEffect = activePerTurnEffect;
	}

	public double getActiveFullCycleEffect() {
		return activeFullCycleEffect;
	}

	public void setActiveFullCycleEffect(double activeFullCycleEffect) {
		this.activeFullCycleEffect = activeFullCycleEffect;
	}

	
	public House getMainHouse() {
		return mainHouse;
	}

	public void setMainHouse(House mainHouse) {
		this.mainHouse = mainHouse;
	}

	public ArrayList<House> getSideHouses() {
		return sideHouses;
	}

	public void addSideHouse(House house) {
		this.sideHouses.add(house);
	}
	
	public void changePlayersHealthPoints(double x) {
		healthPoints += x;
	}
}
