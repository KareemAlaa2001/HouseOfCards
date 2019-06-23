import java.util.*;

public class InGamePlayer {
	
	private double healthPoints;
	private double activePerTurnEffect;
	private double activeFullCycleEffect;
	
	private House mainHouse;
	private ArrayList<House> sideHouses;
	
	private ArrayList<Card> hand;

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
	
	public void changePlayersHealthPoints(double x) {
		healthPoints += x;
	}
}
