//
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
	
	
	public Card(double attackPoints,double healthPoints ,double activePerTurnEffect,double activeFullCycleEffect,
			House house,boolean needsTribute,boolean canAttack,String description) {
		
		this.attackPoints = attackPoints;
		this.healthPoints = healthPoints;
		this.house = house;
		this.activePerTurnEffect = activePerTurnEffect;
		this.activeFullCycleEffect = activeFullCycleEffect;
		this.needsTribute = needsTribute;
		this.canAttack = canAttack;
		this.description = description;	
		
		if(healthPoints > 10 || healthPoints < 1)
			throw new IllegalArgumentException("Health points cannot be greater than 10 nor less than 1!");
		if(attackPoints > 10 || attackPoints < 1)
			throw new IllegalArgumentException("Attack points cannot be greater than 10 nor less than 1!");
			
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
	
	public void changeAttackPoints(double x) {
		attackPoints += x;
	}
	
	public void changeHealthPoints(double x) {
		healthPoints += x;
	}
	
	public void cardCanAttack() {
		if(canAttack == true) 
			// call attack method
		else{
			throw new IllegalArgumentException("This card has just been deployed or has just released an attack!");
		}
		
	}
	
	public void cardNeedsTribute() {
       if(attackPoints <= 8)
    	   needsTribute = false;
       else
    	   needsTribute = true;		
	}
	
    



}
