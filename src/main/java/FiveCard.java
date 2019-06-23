
public class FiveCard extends Card {

	public FiveCard(double attackPoints, double healthPoints, double activePerTurnEffect, double activeFullCycleEffect,
			House house, boolean needsTribute, boolean canAttack, String description) {
		super(attackPoints, healthPoints, activePerTurnEffect, activeFullCycleEffect, house, needsTribute, canAttack,
				description);
		// TODO Auto-generated constructor stub
	}

	private boolean barrier = true;
	
	
	public boolean barrierCondition() {
	    if(healthPoints < 5 && barrier == true)
	    	barrier = false;
	    return barrier;
	}
	
			
	}

}
