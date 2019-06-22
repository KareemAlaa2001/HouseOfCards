
public  class Attack {

	private Card atkCard;
	private InGamePlayer atkPlayer;
	private double attackPoints;
	private InGamePlayer defPlayer;
	private Card defCard;

	public Card getDefCard() {
		return defCard;
	}

	public void setDefCard(Card defCard) {
		this.defCard = defCard;
	}
	public Attack(Card atkCard, InGamePlayer atkPlayer) {
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

	public InGamePlayer getDefPlayer() {
		return defPlayer;
	}

	public void setDefPlayer(InGamePlayer defPlayer) {
		this.defPlayer = defPlayer;
	}
}

