/*	Special kind of card with the ability to attack twice in one turn. It also has a barrier which breaks 
 * 	instead of the card receiving damage when it receives an attack or attacks another card. The barrier 
 * 	only breaks once then doesn't act anymore. 	 */
public class FiveCard extends Card {

	//	tracks number of attacks made this turn, maximum of 2 attacks per turn. number is reset to 0 every turn
	private int attacksThisTurn;
	
	//	boolean to store whether the card has an active barrier
	private boolean hasBarrier;
	
	//	constructor which just calls the super constructor
	public FiveCard(double attackPoints, House house) {
		super(attackPoints, house);
		this.setBarrier(true);
	}
    
	//	setter for barrier
    public void setBarrier(boolean barrier) {
    	this.hasBarrier = barrier;
    }
	
    //	getter for barrier
    public boolean hasBarrier() {
    	return hasBarrier;
    }
    /*
    //	INVALID METHOD method consumes barrier in attack
	public void barrierEffect(Attack atk) {
			if(hasBarrier() == true) {
				atk.setAttackDamage(0);
				setBarrier(false);
			}

	}
	*/
    
    //	getter for attacks made this turn
	public int getAttacksMadeThisTurn() {
		return this.attacksThisTurn;
	}
	
	//	resets attacks made this turn to zero, useful when ending turn. Allows card to attack again
	public void resetAttacksMadeThisTurn() {
		this.attacksThisTurn = 0;
		this.setCanAttack(true);
	}
	
	//	increases attacks made this turn to 2. Doesn't let card attack again if 2 attacks made this turn
	public void incrementAttacksMadeThisTurn() {
		this.attacksThisTurn++;
		if (this.getAttacksMadeThisTurn() == 2) setCanAttack(false);
	}
}
