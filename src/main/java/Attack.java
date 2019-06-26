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

	private boolean attackOnPlayer;
	
	//	constructor for initiating an attack on a card 
	public Attack(Card atkCard, InGamePlayer atkPlayer, Card defCard, InGamePlayer defPlayer, boolean atkOnPlayer) throws IllegalArgumentException {
		
		for ( House atkHouse: atkPlayer.getAllHouses()) {
			for (House defHouse : defPlayer.getAllHouses()) {
				if (atkHouse.equals(defHouse)) throw new IllegalArgumentException("Attakcing player can't attack his own house!");
			}
		}
		
		this.setAttackingCard(atkCard);
		this.setAttackingPlayer(atkPlayer);
		this.setAttackDamage(this.getAttackingCard().getAttackPoints());
		this.setDefendingCard(defCard);
		this.setDefendingPlayer(defPlayer);
		this.setAttackOnPlayer(atkOnPlayer);
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
	
	public void carryOutAttack() {
		boolean atkIsSpadeJorQ = getAttackingPlayer().getMainHouse().getShape() == House.SPADE && getAttackingPlayer().getMainHouse().isQueenAlive();
	
		House defendingPlayerHouse = getDefendingPlayer().getMainHouse();
		boolean defIsKingSpade = defendingPlayerHouse.getShape() == House.SPADE && !defendingPlayerHouse.isQueenAlive();
		boolean defIsDiamOrClubs = defendingPlayerHouse.getShape() == House.CLUBS || defendingPlayerHouse.getShape() == House.DIAMOND;
			
		boolean defHasDefAbility =  defIsKingSpade || defIsDiamOrClubs;
			
		if (atkIsSpadeJorQ) getAttackingPlayer().getMainHouse().applyActiveAbility(this);
			
		if (defHasDefAbility) getDefendingPlayer().getMainHouse().applyActiveAbility(this);
		
		
		if (isAttackOnPlayer()) {
			getDefendingPlayer().changeHealthPoints(getAttackDamage());
		} else {
			getDefendingCard().changeHealthPoints(getAttackDamage());
			getAttackingCard().changeHealthPoints(getDefendingCard().getAttackPoints());
		}
	}

	public boolean isAttackOnPlayer() {
		return attackOnPlayer;
	}

	public void setAttackOnPlayer(boolean attackOnPlayer) {
		this.attackOnPlayer = attackOnPlayer;
	}
	
	/*
	public void sendAttack(Attack atk) {
		// TODO kareem you need to work on this

			
	}
	
	public void receiveAttack(Attack atk) {
		// TODO kareem you need to work on this        
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
	*/
}

