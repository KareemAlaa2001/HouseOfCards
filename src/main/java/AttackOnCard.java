
public class AttackOnCard extends AbstractAttack {

	private Card defCard;
	
	public AttackOnCard(Card atkCard, InGamePlayer atkPlayer, Card defCard) {
		super(atkCard, atkPlayer);
		setDefCard(defCard);
	}

	public Card getDefCard() {
		return defCard;
	}

	public void setDefCard(Card defCard) {
		this.defCard = defCard;
	}
}
