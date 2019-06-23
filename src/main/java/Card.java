//	TODO Mostafa you need to work on this class bro
public class Card {
	
	//	models the card's attack points, usually unchanged 
	protected double attackPoints;
	
	//	models the card's health points
	protected double healthPoints;
	
	//	models the number by which the card's health changes every passing turn, no matter whose turn it is
	protected double activePerTurnEffect;
	
	/*	models the number by which the card's health changes every full cycle, where a cycle is completed every time
	 * 	the turn of the person to whom the card's house belongs */
	protected double activeFullCycleEffect;
	protected House house;
	protected boolean needsTribute;
	protected boolean canAttack;
	protected String description;
	
	
	public Card(double attackPoints,  House house) {
		
		this.attackPoints = attackPoints;
		this.healthPoints = attackPoints;
		this.house = house;
		this.activePerTurnEffect = 0.0;
		this.activeFullCycleEffect = 0.0;
		cardNeedsTribute();
		this.canAttack = false;
		this.description = "";	
	}
	
	
	public void setHouse(House house){
		this.house = house;
	}
	
	public House getHouse(){
		return house;
	}
	
	public void setNeedsTribute(boolean needsTribute) {
		this.needsTribute = needsTribute;
	}
	
	public boolean getNeedsTribute() {
		return needsTribute;
	}
	
	public void setCanAttack(boolean canAttack) {
		this.canAttack = canAttack;
	}
	
	public boolean getCanAttack() {
		return canAttack;
	}
	
	public void setDescrpition(String description) {
		this.description = description;	
	}
	
	public String getDescription() {
		return description;
	}

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
	
	public void changeAttackPoints(double x) {
		attackPoints += x;
	}
	
	public void changeHealthPoints(double x) {
		healthPoints += x;
	}
	
//  still figuring it out
	public void cardCanAttack() {
		
	}
	
	public void cardNeedsTribute() {
       if(attackPoints >= 8)
    	   needsTribute = false;
       else
    	   needsTribute = true;		
	}
	
    public void cardElimination() {
    	
    }



}
