//	TODO Mostafa you need to work on this class bro
public class Card {
	
	//	models the card's attack points, usually unchanged 
	private double attackPoints;
	
	//	models the card's health points
	private double healthPoints;
	
	//	models the number by which the card's health changes every passing turn, no matter whose turn it is
	private double activePerTurnEffect;
	
	/*	models the number by which the card's health changes every full cycle, where a cycle is completed every time
	 * 	the turn of the person to whom the card's house belongs 	*/
	private double activeFullCycleEffect;
	private House house;

	public void setShape(int shape){
		house.setShape(shape);
	}

	public double getAttackPoints() {
		return attackPoints;
	}

	public void setAttackPoints(double attackPoints) {
		this.attackPoints = attackPoints;
	}

	public double getActiveFullCycleEffect() {
		return activeFullCycleEffect;
	}

	public void setActiveFullCycleEffect(double activeFullCycleEffect) {
		this.activeFullCycleEffect = activeFullCycleEffect;
	}

	public double getActivePerTurnEffect() {
		return activePerTurnEffect;
	}

	public void setActivePerTurnEffect(double activePerTurnEffect) {
		this.activePerTurnEffect = activePerTurnEffect;
	}

	public double getHealthPoints() {
		return healthPoints;
	}

	public void setHealthPoints(double healthPoints) {
		this.healthPoints = healthPoints;
	}

	public void attackCard(Card card) {
		// TODO implement properly with proper return type
	}
	
	public void attackPlayer(InGamePlayer player) {
		// TODO implement properly with proper return type
	}
	
	public void receiveAttack(Attack atk) {
		// TODO implement properly with proper return type
	}
	
}
