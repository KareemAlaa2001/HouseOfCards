import java.util.*;

public class InGamePlayer {
	
	protected House mainHouse;
	protected ArrayList<House> sideHouses;
	public ArrayList<Card> hand;
	protected ArrayList<Card> battleList;
	protected ArrayList<Card> tradeList;
	protected boolean usedShuffleAbility;
	protected double healthPoints;
	protected double activePerTurnEffect;
	protected double activeFullCycleEffect;
	
	public static final int HEALTH_MULTIPLIER = 100;
	
	// maximum cards allowed in trade list
	private static final int MAX_TRADE_LIST = 7;
	
	public static final int MAX_HAND = 7;
	
	// starting health points for each player
	private static final int START_HEALTH_POINTS = 5000;
	
	public static final int JACK_THRESHOLD = 4000;
	
	public static final int QUEEN_THRESHOLD = 2600;
	
	public static final int KING_THRESHOLD = 0;
	
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
	
	private void killHouseCard() {
		if (this.getMainHouse().isJackAlive() && healthBelowJackThreshold()) {
			this.setHealthPoints(JACK_THRESHOLD);
			
		} else if (this.getMainHouse().isQueenAlive() && healthBelowQueenThreshold()) {
			this.setHealthPoints(QUEEN_THRESHOLD);
			
		} else if (this.getMainHouse().isKingAlive() && healthBelowKingThreshold()) {
			this.setHealthPoints(KING_THRESHOLD);
			
		} else throw new IllegalStateException("Health didn't fall beneath house card boundary; shouldn't call this method to kill a house card!");
		
		this.getMainHouse().killHouseCard();
	}
	
	private boolean healthBelowHouseCardThreshold() {
		
		if (this.getMainHouse().isKingAlive()) {
			
			if (this.getHealthPoints() <= KING_THRESHOLD) return true;
			
			else if (this.getMainHouse().isQueenAlive()) {
				
				if (this.getHealthPoints() <= QUEEN_THRESHOLD) return true;
				
				else if (this.getMainHouse().isJackAlive()) {
					return healthBelowJackThreshold();
				}
			}
		}
		return false;
	}
	
	private boolean healthBelowJackThreshold() {
		if (this.getMainHouse().isJackAlive()) {
			if (this.getHealthPoints() <= JACK_THRESHOLD) return true;
			else return false;
		} else throw new IllegalStateException("should only call this method if jack is alive!");
		
	}
	
	private boolean healthBelowQueenThreshold() {
		if (this.getMainHouse().isQueenAlive()) {
			if (this.getHealthPoints() <= QUEEN_THRESHOLD) return true;
			else return false;
		} else throw new IllegalStateException("should only call this method if queen is alive!");
		
	}
	
	private boolean healthBelowKingThreshold() {
		if (this.getMainHouse().isKingAlive()) {
			if (this.getHealthPoints() <= KING_THRESHOLD) return true;
			else return false;
		} else throw new IllegalStateException("should only call this method if king is alive!");
		
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
	
	public void removeFromBattleList(Card cardToRemove){
		battleList.remove(cardToRemove);
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
		for(int i = 0; i < cards.size(); i++) {
			addToHand(cards.get(i));
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
	
	public void changeHealthPoints(double x) {
		healthPoints += x * InGamePlayer.HEALTH_MULTIPLIER;
		
		if (healthBelowHouseCardThreshold()) killHouseCard();
	}

	public ArrayList<House> getAllHouses() {
		ArrayList<House> allHouses = new ArrayList<House>();
		
		allHouses.add(getMainHouse());
		for (House h: getSideHouses()) {
			allHouses.add(h);
		}
		
		return allHouses;
	}
	// returns true if the ace is 
	public boolean aceInHand() {
		 for(int i = 1;i< hand.size();i++) {
			 if(hand.get(i).getAttackPoints() == 1 && hand.get(i).getHouse() == this.getMainHouse()){
				 return true;
			 }
		 }
	 return false;	
 }

}
