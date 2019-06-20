/*	Class to represent spade ability which is either a */
public class SpadeAbility extends Ability{
	
	boolean isAttack;
	
	public SpadeAbility(double genMod,boolean isAttack)
	{
		super(genMod);
		this.isAttack = isAttack;
	}

	public void callAbility() {
		if(isAttack) {
			
		} else {
			
		}
	}
}
