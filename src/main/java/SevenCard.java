
public class SevenCard extends Card{

	private Card temp;
    private boolean switchCondition = true;

	public SevenCard(double attackPoints, House house) {
		super(attackPoints, house);
	}
    
	public void setSwitchCondition(boolean switchCondition) {
		this.switchCondition = switchCondition;
	}
	
	public boolean getSwitchCondition() {
		return switchCondition;
		
	}
	
    public void switchEffect(Card sevenCard, Card card) {
	
	if(getSwitchCondition() == true) {
	if(Card.attackPoints == 7) {
	temp = card;
	card = sevenCard;
	sevenCard = temp;
	setSwitchCondition(false);
	}
	else
		throw new IllegalArgumentException("You can only choose the Seven Card to switch it with another card!");
	}
}




}