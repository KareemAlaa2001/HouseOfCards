public class Card {
	
	private double attackPoints;
	private double healthPoints;
	private double activePerTurnEffect;
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
