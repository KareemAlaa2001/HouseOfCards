/*	This class represents the heart ability, which is a bit different from other abilities because it doesn't need an attack
 * 	to happen for it to be called. */
//	file built by kareemalaa2001
public class HeartAbility extends Ability{

	//	boolean to check if ability is applied every full cycle (T) or every turn (F), used to distinguish between king and queen abilities
	private boolean isFullCycle;
	
	public static final double JACK_MODIFIER = 2;
	
	public static final double QUEEN_MODIFIER = 5;
	
	public static final double KING_MODIFIER = 2.5;
	
	private static final double[] VALID_MODIFIERS = new double[] { JACK_MODIFIER, QUEEN_MODIFIER, KING_MODIFIER };

	//	constructor, takes values for general modifier and isFullCycle boolean
	public HeartAbility(double genMod,boolean isFullCycle) throws IllegalArgumentException {
		super(genMod);

		if (!checkModifierValid(genMod, VALID_MODIFIERS))
			throw new IllegalArgumentException("Illegal modifier used! Can only use one of the modifiers defined in this class!");
		
		this.setFullCycle(isFullCycle);
	}

	//	This method can't be used for heart since the usage of this hoouse's ability is not triggered during an attack
	@Override
	public void callAbility(Attack atk) throws IllegalArgumentException {
		throw new IllegalArgumentException("You can't call this method for the heart ability since it doesn't involve attacks!");
	}

	//	calls the jack ability since it is the only card related heart ability
	public void callHeartAbilityOnCard(Card healedCard) throws Exception {
		if (!isFullCycle) throw new Exception("Can't call this method on an ability which isn't a full cycle ability! Should be jack ability!");
		applyJackAbility(healedCard);
	}
	
	/*
	 * 	calls the relevant player related heart ability by checking whether this ability isFullCycle
	 * 	calls queen ability if every full cycle and calls king ability if not	 */
	public void callHeartAbilityOnPlayer(InGamePlayer healedPlayer) {
		if (isFullCycle) {
			applyQueenAbility(healedPlayer);
		} else {
			applyKingAbility(healedPlayer);
		}
	}
	
	//	applies jack ability. Adds genMod (supposedly 2) to the card's active full cycle effect
	private void applyJackAbility(Card healedCard) {
		healedCard.setActiveFullCycleEffect(healedCard.getActiveFullCycleEffect() + this.getGeneralModifier());
	}
	
	//	applies queen ability. Adds genMod value to player's active full cycle effect
	private void applyQueenAbility(InGamePlayer healedPlayer) {
		healedPlayer.setActiveFullCycleEffect(healedPlayer.getActiveFullCycleEffect() + this.getGeneralModifier());
	}
	
	//	applies king ability. adds genMod value to player's active per turn effect
	private void applyKingAbility(InGamePlayer healedPlayer) {
		healedPlayer.setActivePerTurnEffect(healedPlayer.getActivePerTurnEffect() + this.getGeneralModifier());
	}
	
	//	getter for isFullCycle boolean
	public boolean isFullCycle() {
		return isFullCycle;
	}

	//	setter for isFullCycle boolean
	public void setFullCycle(boolean isFullCycle) {
		this.isFullCycle = isFullCycle;
	}


}
