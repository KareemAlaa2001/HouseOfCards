
public class FiveCard extends Card {

	private int attacksThisTurn;
	
	public FiveCard(double attackPoints, House house) {
		super(attackPoints, house);
	}
    
	private boolean barrier = true;
	
    public void setBarrier(boolean barrier) {
    	this.barrier = barrier;
    }
	
    public boolean getBarrier() {
    	return barrier;
    }
    
	public void barrierEffect(Attack atk) {
			if(getBarrier() == true) {
				atk.attackDamage = 0;
				setBarrier(false);
			}

	}

	public int getAttacksMadeThisTurn() {
		return this.attacksThisTurn;
	}
	
	public void resetAttacksMadeThisTurn() {
		this.attacksThisTurn = 0;
	}
	
	public void incrementAttacksMadeThisTurn() {
		this.attacksThisTurn++;
	}
}
