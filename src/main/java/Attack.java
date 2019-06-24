//  class to represent all attacks
public  class Attack {

	//	attacking card
	private Card atkCard;
	
	//	attacking player
	private InGamePlayer atkPlayer;
	
	//	represents the damage the attack will inflict
	public double attackDamage;
	
	//	Player receiving the attack. Only used if the attack is directed towards the player himself not his card.
	private InGamePlayer defPlayer;
	
	//	Card receiving the attack. Used when attacking a card owned by a player.
	private Card defCard;

	//	constructor for initiating an attack on a card 
	public Attack(Card atkCard, InGamePlayer atkPlayer, Card defCard) throws IllegalArgumentException {
		
		for (House house: atkPlayer.getSideHouses())
			if (defCard.getHouse().equals(house)) throw new IllegalArgumentException("A player can't attack a card from one of his own houses!");
		
		this.setAttackingCard(atkCard);
		this.setAttackingPlayer(atkPlayer);
		this.setAttackDamage(this.getAttackingCard().getAttackPoints());
		this.setDefendingCard(defCard);
		this.setDefendingPlayer(null);
	}
	
	//	constructor for initiating an attack on a player
	public Attack(Card atkCard, InGamePlayer atkPlayer, InGamePlayer defPlayer) {
		this.setAttackingCard(atkCard);
		this.setAttackingPlayer(atkPlayer);
		this.setAttackDamage(this.getAttackingCard().getAttackPoints());
		this.setDefendingCard(null);
		this.setDefendingPlayer(defPlayer);
	}
	
	//	getter for attacking card
	public Card getAttackingCard() {
		return atkCard;
	}

	//	setter for attacking card
	public void setAttackingCard(Card atkCard) {
		this.atkCard = atkCard;
	}

	//	getter for attacknig player
	public InGamePlayer getAttackingPlayer() {
		return atkPlayer;
	}

	//	setter for attacking player
	public void setAttackingPlayer(InGamePlayer atkPlayer) {
		this.atkPlayer = atkPlayer;
	}

	//	getter for attack damage
	public double getAttackDamage() {
		return attackDamage;
	}

	//	setter for attack damage
	public void setAttackDamage(double attackDamage) {
		this.attackDamage = attackDamage;
	}

	/*	getter for defending player. It can be null so checks if null and throws an IllegalArgumentException.
	 * 	if defending player is null then this attack is directed towards a card	*/
	public InGamePlayer getDefendingPlayer() throws IllegalArgumentException {
		try {
			return defPlayer;
		} catch (NullPointerException e) {
			throw new IllegalArgumentException("No defending player, this attack is directed towards a card!");
		}
	}

	//	setter for defending player
	public void setDefendingPlayer(InGamePlayer defPlayer) {
		this.defPlayer = defPlayer;
	}
	
	/*	getter for defending card. It can be null so checks if null and throws an IllegalArgumentException.
	 * 	if defending card is null then this attack is directed towards a player	*/
	public Card getDefendingCard() throws IllegalArgumentException {
		try {
			return defCard;
		} catch (NullPointerException e) {
			throw new IllegalArgumentException("No defending card, this attack is directed towards a player!");
		}
	}	

	//	setter for defending card
	public void setDefendingCard(Card defCard) {
		this.defCard = defCard;
	}
	
	public void receiveAttack(Attack atk) {
        
	}

	// the method below changes the hp of the attacked player
	public void attackPlayer(InGamePlayer player) {
       player.changePlayersHealthPoints((-1*attackDamage));
       OfflineGame.playersDeath(player);
       
	}	
	// the medthod below changes the hp of the attacked card
	public void attackCard(Card card) {
		card.changeHealthPoints((-1*attackDamage));
		OfflineGame.cardsElimination(card);
	}

}

