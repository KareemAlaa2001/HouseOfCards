/*	Class to represent diamond suit abilities which all reduce damage received from an attack*/
public class DiamondAbility extends Ability{
	
	public static final double JACK_MODIFIER = 0.75;
	
	public static final double QUEEN_MODIFIER = 0.5;
	
	public static final double KING_MODIFIER = 0.25;
	
	private static final double[] VALID_MODIFIERS = new double[] { JACK_MODIFIER, QUEEN_MODIFIER, KING_MODIFIER };
	
	//  Constructor takes genMod, factor by which attack points are multiplied to reduce damage received
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
