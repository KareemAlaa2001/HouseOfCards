import java.util.*;

public class InGamePlayer {
	
	private double healthPoints;
	private double activePerTurnEffect;
	private double activeFullCycleEffect;
	
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
}
