/*	Class to represent diamond suit abilities which all reduce damage received from an attack*/
//	file built by kareemalaa2001
public class DiamondAbility extends Ability{
	
	//	all three modifiers are applied to attack damage of an attack to act as a damage reduction effect
	
	//	jack ability: reduces attack damage by 25%
	public static final double JACK_MODIFIER = 0.75;
	
	//	queen ability: reducws attack damage by 50%
	public static final double QUEEN_MODIFIER = 0.5;
	
	//	king ability: reduces attack damage by 75%
	public static final double KING_MODIFIER = 0.25;
	
	//	array of valid modifiers to check double passed into constructor
	private static final double[] VALID_MODIFIERS = new double[] { JACK_MODIFIER, QUEEN_MODIFIER, KING_MODIFIER };
	
	/*  Constructor takes genMod, factor by which attack points are multiplied to reduce damage received.
	 *	value is checked for validity against list of valid modifiers	*/
	public DiamondAbility(double genMod) throws IllegalArgumentException {
		super(genMod);
		
		if (!checkModifierValid(genMod, VALID_MODIFIERS)) 
			throw new IllegalArgumentException("Illegal modifier used! Can only use one of the modifiers defined in this class!");
	}

	//  Applies ability by reducing received damage by multiplying attack points by genMod
	@Override
	public void callAbility(Attack atk) {
		atk.setAttackDamage(atk.getAttackDamage() * this.getGeneralModifier());
	}
	
}
