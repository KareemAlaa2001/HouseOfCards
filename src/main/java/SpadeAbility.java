/*	Class to represent spade ability which is either an increase in attack points for Jack and Queen 
 *  a reduction in attack points to defend the King of Spades card  */
//	file built by kareemalaa2001

public class SpadeAbility extends Ability{
	//  boolean to check whether its an attack ability
	private boolean isAttack;
	
	public static final double JACK_MODIFIER = 2;
	
	public static final double QUEEN_MODIFIER = 3;
	
	public static final double KING_MODIFIER = 0.75;
	
	private static final double[] VALID_MODIFIERS = new double[] { JACK_MODIFIER, QUEEN_MODIFIER, KING_MODIFIER };
	
	//  constructor, takes superclass generalMod and boolean for isAttack as modifiers
	public SpadeAbility(double genMod,boolean isAttack) throws IllegalArgumentException {
		super(genMod);
		
		if (!checkModifierValid(genMod, VALID_MODIFIERS))
			throw new IllegalArgumentException("Illegal modifier used! Can only use one of the modifiers defined in this class!");
		
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
		atk.setAttackDamage(atk.getAttackDamage() + this.getGeneralModifier());
	}
	
	//	reducing damage received by king when it is attacked when this abiltiy is called
	private void reduceKingDamage(Attack atk) {
		atk.setAttackDamage(atk.getAttackDamage() * KING_MODIFIER);
	}
}
