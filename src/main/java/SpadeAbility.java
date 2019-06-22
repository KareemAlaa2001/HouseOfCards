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
			addAttackStrength(atk);
		} else {
			reduceKingDamage(atk);
		}
	}
	
	//	increases attack strength by increasing attack's attack points
	private void addAttackStrength(Attack atk) {
		atk.setAttackPoints(atk.getAttackPoints() + this.getGeneralModifier());
	}
	
	//	reducing damage received by king when it is attacked when this abiltiy is called
	private void reduceKingDamage(Attack atk) {
		atk.setAttackPoints(atk.getAttackPoints() * this.getGeneralModifier());
	}
}
