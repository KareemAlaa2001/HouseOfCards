//  class to represent alll attacks
public  class Attack {

	private Card atkCard;
	private InGamePlayer atkPlayer;
	private double attackPoints;
	private InGamePlayer defPlayer;
	private Card defCard;

	public Attack(Card atkCard, InGamePlayer atkPlayer, Card defCard) {
		this.setAttackingCard(atkCard);
		this.setAttackingPlayer(atkPlayer);
		this.setAttackPoints(this.getAttackingCard().getAttackPoints());
		this.setDefendingCard(defCard);
		this.setDefendingPlayer(null);
	}
	
	public Attack(Card atkCard, InGamePlayer atkPlayer, InGamePlayer defPlayer) {
		this.setAttackingCard(atkCard);
		this.setAttackingPlayer(atkPlayer);
		this.setAttackPoints(this.getAttackingCard().getAttackPoints());
		this.setDefendingCard(null);
		this.setDefendingPlayer(defPlayer);
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

	public InGamePlayer getDefendingPlayer() {
		try {
			return defPlayer;
		} catch (NullPointerException e) {
			throw new IllegalArgumentException("No defending player, this attack is directed towards a card!");
		}
	}

	public void setDefendingPlayer(InGamePlayer defPlayer) {
		this.defPlayer = defPlayer;
	}
	
	public Card getDefendingCard() {
		try {
			return defCard;
		} catch (NullPointerException e) {
			throw new IllegalArgumentException("No defending card, this attack is directed towards a player!");
		}
	}

	public void setDefendingCard(Card defCard) {
		this.defCard = defCard;
	}
	
	public void receiveAttack(Attack atk) {
		// TODO implement properly with proper return type
	}
	
	public void attackPlayer(InGamePlayer player) {
		// TODO implement properly with proper return type
	}	
	
	public void attackCard(Card card) {
		// TODO implement properly with proper return type
	}

}

