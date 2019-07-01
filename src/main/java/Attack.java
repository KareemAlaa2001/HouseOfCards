//  class to represent all attacks. to use this class create a new instance and then call the carryOutAttack() method.
public  class Attack {

	//	attacking card
	private Card atkCard;
	
	//	attacking player
	private InGamePlayer atkPlayer;
	
	//	represents the damage the attack will inflict
	private double attackDamage;
	
	//	Player receiving the attack. Only used if the attack is directed towards the player himself not his card.
	private InGamePlayer defPlayer;
	
	//	Card receiving the attack. Used when attacking a card owned by a player. Can be null if attack is directly towards a player
	private Card defCard;
	
	//	constructor for initiating an attack on a card 
	public Attack(InGamePlayer atkPlayer, Card atkCard, InGamePlayer defPlayer, Card defCard) throws IllegalArgumentException {
		
		if (!atkCard.canAttack()) throw new IllegalArgumentException(
				"Card passed as attacking card can't make any attacks this turn!");
		
		this.setAttackingCard(atkCard);
		this.setAttackingPlayer(atkPlayer);
		this.setAttackDamage(this.getAttackingCard().getAttackPoints());
		this.setDefendingCard(defCard);
		this.setDefendingPlayer(defPlayer);
	}
	
	//	constructor for initiating an attack on a player where defending card is set to null 
	public Attack(InGamePlayer atkPlayer, Card atkCard, InGamePlayer defPlayer) throws IllegalArgumentException {
		

		if (!atkCard.canAttack()) throw new IllegalArgumentException(
				"Card passed as attacking card can't make any attacks this turn!");
		
		this.setAttackingCard(atkCard);
		this.setAttackingPlayer(atkPlayer);
		this.setAttackDamage(this.getAttackingCard().getAttackPoints());
		this.setDefendingPlayer(defPlayer);
		this.setDefendingCard(null);
	}
	
	
	
	
	/*	main method to use to carry out the changes made by this attack instnace. first applies abilities then health changes
	 *	manages attacking card's ability to attack again this turn */
	public void carryOutAttack() {	
		applyRelevantAbilities();
		executeAttack();
		manageAttackingCardFurtherAttackAbility();
	}
	
	/*	method to manage card's ability to make more attacks this turn, where it is disabled for normal cards except FiveCard
	 *	FiveCards can attack twice in a turn so it first increments attacks made then checks if attacks made this turn is equal to 2*/
	private void manageAttackingCardFurtherAttackAbility() {
		if (this.getAttackingCard() instanceof FiveCard) {
			FiveCard fc = (FiveCard) this.getAttackingCard();
			fc.incrementAttacksMadeThisTurn();
		} else this.getAttackingCard().setCanAttack(false);
	}
	
	//	method for executing relevant health changes for either a direct attack on a player or on a card
	private void executeAttack() {
		if (isAttackOnPlayer()) {
			executeAttackOnPlayer();
		} else {
			executeAttackOnCard();
		}
	}
	
	//	executes health points changes for defending player due to the attack. changeHealthPoints method keeps card thresholds in mind
	private void executeAttackOnPlayer() {
		getDefendingPlayer().changeHealthPoints(-getAttackDamage());
	}
	
	//	carries out relevant health points changes for defending and attacking cards in an attack on card
	private void executeAttackOnCard() {
		manageDefendingCardHealthChanges();
		manageAttackingCardHealthChanges();
	}
	
	/*	manages health changes for defending card by checking if its a FiveCard and has the FiveCard Barrier before damaging
	 *	If no barrier/ not FiveCard damage is applied directly	*/
	private void manageDefendingCardHealthChanges() {
		if (getDefendingCard() instanceof FiveCard) {
			FiveCard defFiveCard = (FiveCard) getDefendingCard();
			
			if (defFiveCard.hasBarrier()) defFiveCard.setBarrier(false);
			else defFiveCard.changeHealthPoints(-getAttackDamage());
		
		} else {
			getDefendingCard().changeHealthPoints(-getAttackDamage());
		}
	}
	
	/*	manages health changes for attacking card by checking if its a FiveCard and has the FiveCard Barrier before damaging
	 *	If no barrier/ not FiveCard damage is applied directly	*/
	private void manageAttackingCardHealthChanges() {
		if (getAttackingCard() instanceof FiveCard) {
			FiveCard atkFiveCard = (FiveCard) getAttackingCard();
			
			if (atkFiveCard.hasBarrier()) atkFiveCard.setBarrier(false);
			else atkFiveCard.changeHealthPoints(-getAttackDamage());
			
		} else getAttackingCard().changeHealthPoints(-getAttackDamage());
	}
	
	//	applies relevant attacking and defensive abilities for this attack
	private void applyRelevantAbilities() {
		applyRelevantAtkAbility();
		applyRelevantDefAbility();
	}
	
	/*
	 * 	applies relevant attacking ability for attacking card this turn by checking
	 *  if it has an active ability then applying said ability
	 */
	private void applyRelevantAtkAbility() {
		if (attackerHasActiveAttackAbility()) getAttackingPlayer().getMainHouse().applyActiveAbility(this);
	}
	
	/*	Applies relevant defensive ability of defending card y first checking for its existence then
	 * 	applying it if it exists	*/
	private void applyRelevantDefAbility() {
		if (defenderHasActiveDefendingAbility()) getDefendingPlayer().getMainHouse().applyActiveAbility(this);
	}
	
	//	checks if attacking player has a Spade house and has either Jack or Queen as active Hero
	private boolean attackerHasActiveAttackAbility() {
		return getAttackingPlayer().getMainHouse().getShape() == House.SPADE && getAttackingPlayer().getMainHouse().isQueenAlive();
	}

	/*	checks if defending player has active defending ability by checking if player's active hero is either King of Spades,
	 * 	a diamonds or a clubs hero	*/
	private boolean defenderHasActiveDefendingAbility() {
		House defendingPlayerHouse = getDefendingPlayer().getMainHouse();
		boolean defIsKingSpade = defendingPlayerHouse.getShape() == House.SPADE && !defendingPlayerHouse.isQueenAlive();
		boolean defIsDiamOrClubs = defendingPlayerHouse.getShape() == House.CLUBS || defendingPlayerHouse.getShape() == House.DIAMOND;
			
		boolean defHasDefAbility =  defIsKingSpade || defIsDiamOrClubs;
		return defHasDefAbility;
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

	//	getter for defending player
	public InGamePlayer getDefendingPlayer() throws IllegalArgumentException {
		return defPlayer;
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

	/*	slightly different getter to check if attack is directed towards a player. 
	 * 	Does so by checking for the existence of a defending card */
	public boolean isAttackOnPlayer() {
		return defCard == null;
	}
	
	
}

