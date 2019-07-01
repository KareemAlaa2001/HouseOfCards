public class Card {
	
	//	models the card's attack points, usually unchanged 
	private double attackPoints;
	
	//	models the card's health points
	private double healthPoints;
	
	//	models the number by which the card's health changes every passing turn, no matter whose turn it is
	private double activePerTurnEffect;
	
	/*	models the number by which the card's health changes every full cycle, where a cycle is completed every time
	 * 	the turn of the person to whom the card's house belongs */
	private double activeFullCycleEffect;
	
	//	models the card's house. can only be one of the four houses in the game
	private House house;
	
	//	represents whether the card needs a tribute. Is true for cards with AttackPoints 8 or greater
	private boolean needsTribute;
	
	/*	represents whether the card can make an attack.
	 *  A normal card can only attack once per turn so this is set to false after an attack
	 */
	private boolean canAttack;
	
	//	Description of the card including its house and its ability for use in the UI
	private String description;
	
	/*	Constructor for making a new card. attackPoints are passed in where healthPoints are also set to this value\
	 * 	Card's house is also passed as a parameter, and other variables are set to their default values. 
	 * 	Also calculates whether the card needs a tribute by using its attack points
	 */
	public Card(double attackPoints,  House house) {
		this.setAttackPoints(attackPoints);
		this.setHealthPoints(attackPoints);
		this.setHouse(house);
		this.setActivePerTurnEffect(0);
		this.setActiveFullCycleEffect(0);
		this.calculateCardNeedsTribute();
		this.setCanAttack(false);
		this.setDescrpition("");
	}
	
	//	setter for house
	public void setHouse(House house){
		this.house = house;
	}
	
	//	getter for house
	public House getHouse(){
		return house;
	}
	
	//	setter for whether card needs a tribute
	public void setNeedsTribute(boolean needsTribute) {
		this.needsTribute = needsTribute;
	}
	
	//	getter for whether card needs a tribute
	public boolean getNeedsTribute() {
		return needsTribute;
	}
	
	//	setter for whether card can attack
	public void setCanAttack(boolean canAttack) {
		this.canAttack = canAttack;
	}
	
	//	getter for whether card can attack
	public boolean canAttack() {
		return canAttack;
	}
	
	//	setter for card description
	public void setDescrpition(String description) {
		this.description = description;	
	}
	
	//	getter for card description
	public String getDescription() {
		return description;
	}

	//	TODO DECIDE HOW TO IMPLEMENT THIS
	//	setter for card's shape
	public void setShape(int shape){
		this.getHouse().setShape(shape);
	}
	
	//	getter for card's attack points
	public double getAttackPoints() {
		return attackPoints;
	}

	//	setter for card's attack points
	public void setAttackPoints(double attackPoints) {
		this.attackPoints = attackPoints;
	}

	//	getter for active full cycle effect
	public double getActiveFullCycleEffect() {
		return activeFullCycleEffect;
	}

	//	setter for active full cycle effect
	public void setActiveFullCycleEffect(double activeFullCycleEffect) {
		this.activeFullCycleEffect = activeFullCycleEffect;
	}

	//	getter for active per turn effect
	public double getActivePerTurnEffect() {
		return activePerTurnEffect;
	}

	//	setter for active per turn effect
	public void setActivePerTurnEffect(double activePerTurnEffect) {
		this.activePerTurnEffect = activePerTurnEffect;
	}

	//	getter for HP
	public double getHealthPoints() {
		return healthPoints;
	}

	//	setter for HP
	public void setHealthPoints(double healthPoints) {
		this.healthPoints = healthPoints;
	}
	
	/*
	public void changeAttackPoints(double x) {
		attackPoints += x;
	}
	*/
	
	//	method to change card's health points. If healthpoints fall below 0 they get set to 0
	public void changeHealthPoints(double x) {
		healthPoints += x;
		
		if (getHealthPoints() < 0) setHealthPoints(0);
	}
	
	//	method to apply cycle effect health points change
	public void applyFullCycleEffect(){
		this.changeHealthPoints(this.getActiveFullCycleEffect());
	}
	
	//	method to apply per turn effect health points change
	public void applyPerTurnEffect(){
		this.changeHealthPoints(this.getActivePerTurnEffect());
	}
	
/*	
 	the parameter input (flag) always has to be true initially
	public boolean cardCanAttack(boolean flag) {
		//threecard can attack instantly
		if(attackPoints == 3)
			return true;
		
		if(OfflineGame.fullCycleTurn() == true) {
			return true;
		}
		else 
			throw new IllegalArgumentException("This card has just been deployed!");
		/*
		if(flag == false)
            throw new IllegalArgumentException("This card cannot attack twice!");
        else 
            return(cardCanAttack(flag = false));
            
	}
*/
	//	method for use in the contructor to set needsTribute depenging on attackPoints value
	private void calculateCardNeedsTribute() {
       if(attackPoints >= 8)
    	   needsTribute = false;
       else
    	   needsTribute = true;		
	}
	




}
