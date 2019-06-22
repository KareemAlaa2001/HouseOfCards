
public class HeartAbility extends Ability{

	private boolean isFullCycle;
	
	public HeartAbility(double genMod,boolean isFullCycle) {
		super(genMod);
		this.setFullCycle(isFullCycle);
	}

	@Override
	public void callAbility(Attack atk) {
		throw new IllegalArgumentException("You can't call this method for the heart ability since it doesn't involve attacks!");
	}

	public boolean isFullCycle() {
		return isFullCycle;
	}

	public void setFullCycle(boolean isFullCycle) {
		this.isFullCycle = isFullCycle;
	}

	public void callHeartAbilityOnCard(Card healedCard) {
		healedCard.setActiveFullCycleEffect(healedCard.getActiveFullCycleEffect() + this.getGeneralModifier());
	}
	
	public void callHeartAbilityOnPlayer(InGamePlayer healedPlayer) {
		if (isFullCycle) {
			healedPlayer.setActiveFullCycleEffect(healedPlayer.getActiveFullCycleEffect() + this.getGeneralModifier());
		} else {
			healedPlayer.setActivePerTurnEffect(healedPlayer.getActivePerTurnEffect() + this.getGeneralModifier());
		}
	}

}
