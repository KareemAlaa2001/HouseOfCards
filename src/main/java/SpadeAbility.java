/*	Class to represent spade ability which is either an increase in attack points for Jack and Queen 
 *  a reduction in attack points to defend the King of Spades card  */
public class SpadeAbility extends Ability{
	//  boolean to check whether its an attack ability
	private boolean isAttack;
	
	//  constructor, takes superclass generalMod and boolean for isAttack as modifiers
	public SpadeAbility(double genMod,boolean isAttack)
	{
		super(genMod);
		this.isAttack = isAttack;
	}

	//  method to call ability, checks if attacking: adds attack damage if it is, reduces the damage if it isn't
	@Override
	public void callAbility(Attack atk) {
		if(isAttack) {
			atk.setAttackPoints(atk.getAttackPoints() + this.getGeneralModifier());
		} else {
			atk.setAttackPoints(atk.getAttackPoints() * this.getGeneralModifier());
		}
	}
	
}
