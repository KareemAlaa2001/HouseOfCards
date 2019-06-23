import java.util.*;

public class InGamePlayer {
	
	private House mainHouse;
	private ArrayList<House> sideHouses;
	private ArrayList<Card> hand;
	private ArrayList<Card> battleList;
	private ArrayList<Card> tradeList;
	private double usedShuffleAbility;
	private double healthPoints;
	private double activePerTurnEffect;
	private double activeFullCycleEffect;
	
	private static final int MAX_TRADE_LIST = 7;
	private static final int START_HEALTH_POINTS = 5000;

	public InGamePlayer(House mainHouse){
		this.mainHouse = mainHouse;
		sideHouses = new ArrayList<Card>();
		hand = new ArrayList<Card>();
		battleList = new ArrayList<Card>();
		tradeList = new ArrayList<Card>();
		usedShuffleAbility = false;
		healthPoints = START_HEALTH_POINTS;	
		activePerTurnEffect = 0;
		activeFullCycleEffect = 0;
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

	public void addToBattleList(Card cardToAdd){
		battleList.add(cardToAdd);	
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

	public void addToHand(Card card){
		hand.add(card);
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

	public void setSideHouses(ArrayList<House> sideHouses) {
		this.sideHouses = sideHouses;
	}
}
