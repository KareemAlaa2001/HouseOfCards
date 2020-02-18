/*	Class to represent club abilities, club main theme: Poison. Jack damages attacking card by
 * 	an extra half of its attacking points, queen applies a lingering poison which reduces card
 * 	health points by 1 per turn as well as jack ability and king applies half the damage of the
 * 	attack to the attacking player's health points as well as the other abilities 
 * 	*/
//	file built by kareemalaa2001
public class ClubAbility extends Ability {
	
	//	constant for queen lingering poison ability modifier where it reduces health by 1 every turn
	public static final int QUEEN_MODIFIER = -1;
	
	//	constant for general modifier applied in jack and king abilities
	public static final double GENERAL_MODIFIER = 0.5;
	
	//	array of valid modifiers for contructor general modifier validation
	private static final double[] VALID_MODIFIERS = new double[] { QUEEN_MODIFIER, GENERAL_MODIFIER };
	
	//	member boolean to check if jack is alive, queen ability is called if false
	private boolean jackAlive;

	//	member boolean to check if queen is alive, king ability called if false 
	private boolean queenAlive;
	
	/*	Constructor for ClubAbility where general modifier and booleans for jackAlive and queenAlive are passed.
	 *	Validity of passed modifier is checked valid list. The 2 booleans decide which abilities are applied */
	public ClubAbility(double genMod, boolean isJackAlive, boolean isQueenAlive) throws IllegalArgumentException {
		super(genMod);
		
		if (!checkModifierValid(genMod, VALID_MODIFIERS))
			throw new IllegalArgumentException("Illegal modifier used! Can only use one of the modifiers defined in this class!");
		
		this.setJackAlive(isJackAlive);
		this.setQueenAlive(isQueenAlive);
	}
	
	/*	club implementation for calling the house ability. Applies jack ability, then if jack dead applies queen ability
	 *	and if queen dead applies king ability */
	@Override
	public void callAbility(Attack atk) {
		applyJackAbility(atk);
		
		if (!jackAlive) {
			applyQueenAbility(atk);
			
			if (!queenAlive) {
				applyKingAbility(atk);
			}
		}
	}
	
	//	applies jack ability by reducing health points of attacking card by an extra half of the attack's attack points
	private void applyJackAbility(Attack atk) {
		atk.getAttackingCard().changeHealthPoints(-atk.getAttackDamage()*GENERAL_MODIFIER);
	}
	
	//	applies queen ability by adding queen modifier (-1) to card's active per turn effect modifier
	private void applyQueenAbility(Attack atk) {
		atk.getAttackingCard().setActivePerTurnEffect(atk.getAttackingCard().getActivePerTurnEffect() + QUEEN_MODIFIER);
	}
	
	//	applies king ability by reducing health points of attacking card by half of the attack's attack points
	private void applyKingAbility(Attack atk) {
		atk.getAttackingPlayer().changeHealthPoints(-atk.getAttackDamage()*GENERAL_MODIFIER);
	}
	
	//	gettter for jackALive boolean
	public boolean isJackAlive() {
		return jackAlive;
	}

	//	setter for jackAlive boolean
	public void setJackAlive(boolean jackAlive) {
		this.jackAlive = jackAlive;
	}

	//	getter for queenAlive boolean
	public boolean isQueenAlive() {
		return queenAlive;
	}

	//	setter for queenAlive boolean
	public void setQueenAlive(boolean queenAlive) {
		this.queenAlive = queenAlive;
	}
}

	

