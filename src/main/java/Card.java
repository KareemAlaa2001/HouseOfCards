public class Card {
	
	//	models the card's attack points, usually unchanged 
	protected static double attackPoints;
	
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
		Card.attackPoints = attackPoints;
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

	public static double getAttackPoints() {
		return attackPoints;
	}

	public static void setAttackPoints(double attackPoints) {
		Card.attackPoints = attackPoints;
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
	public void applyFullCycleEffect(){
		healthPoints += activeFullCycleEffect;	
	}
	public void applyPerTurnEffect(){
		healthPoints += activePerTurnEffect;	
	}
	
/*	
//  	the parameter input (flag) always has to be true initially
	public boolean cardCanAttack(boolean flag) {
		//threecard can attack instantly
		if(attackPoints == 3)
			return true;
		
		if(OfflineGame.fullCycleTurn() == true) {
			return true;
		}
		else 
			throw new IllegalArgumentException("This card has just been deployed!");

		if(flag == false)
            throw new IllegalArgumentException("This card cannot attack twice!");
        else 
            return(cardCanAttack(flag = false));
	}
*/
	public void cardNeedsTribute() {
       if(attackPoints >= 8)
    	   needsTribute = false;
       else
    	   needsTribute = true;		
	}
	




}
