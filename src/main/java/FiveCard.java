
public class FiveCard extends Card {

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

	public static void doubleAttackEffect(Attack atk1,Attack atk2) {
            Attack.sendAttack(atk1);
            Attack.sendAttack(atk2);
		
		
	}
}
