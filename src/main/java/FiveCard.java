
public class FiveCard extends Card {

	public FiveCard(double attackPoints, House house) {
		super(attackPoints, house);
	}

	private boolean barrier = true;
	
	
	public boolean barrierCondition() {
	    if(healthPoints < 5 && barrier == true)
	    	barrier = false;
	    return barrier;
	}
	
	public void barrierEffect() {
		
		
		
		
		
		
		
		
			
			
			
			
	}

}
