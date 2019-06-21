
public abstract class AbstractAttack {

	private Card atkCard;
	private InGamePlayer atkPlayer;
	private double attackPoints;
	
	public AbstractAttack(Card atkCard, InGamePlayer atkPlayer) {
		this.setAttackingCard(atkCard);
		this.setAttackingPlayer(atkPlayer);
		this.setAttackPoints(this.getAttackingCard().getAttackPoints());
	}
	
	public Card getAttackingCard() {
		return atkCard;
	}

	public void setAttackingCard(Card atkCard) {
		this.atkCard = atkCard;
	}

	public InGamePlayer getAttackingPlayer() {
		return atkPlayer;
	}

	public void setAttackingPlayer(InGamePlayer atkPlayer) {
		this.atkPlayer = atkPlayer;
	}

	public double getAttackPoints() {
		return attackPoints;
	}

	public void setAttackPoints(double attackPoints) {
		this.attackPoints = attackPoints;
	}

	
}
