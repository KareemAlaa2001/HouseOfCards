
public class HeartAbility extends Ability{

	private boolean isFullCycle;
	
	public HeartAbility(double genMod,boolean isFullCycle) {
		super(genMod);
		this.setFullCycle(isFullCycle);
	}

	@Override
	public void callAbility(AbstractAttack atk) {
		if (!this.isFullCycle())
		{
			atk.getAttackingPlayer().setActiveFullCycleEffect(atk.getAttackingPlayer().getActiveFullCycleEffect() + this.getGeneralModifier());
		}
		else {
			//	TODO Complete implementation
			//	TODO Think about better implementation without passing Attack Object here
		}
	}

	public boolean isFullCycle() {
		return isFullCycle;
	}

	public void setFullCycle(boolean isFullCycle) {
		this.isFullCycle = isFullCycle;
	}

}
