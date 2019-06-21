/*	Class to represent diamond suit abilities which all reduce damage received from an attack*/
public class DiamondAbility extends Ability{
	
	//  Constructor takes genMod, factor by which attack points are multiplied to reduce damage received
	public DiamondAbility(double genMod) {
		super(genMod);
	}

	//  Applies ability by reducing received damage by multiplying attack points by genMod
	@Override
	public void callAbility(AbstractAttack atk) {
		atk.setAttackPoints(atk.getAttackPoints() * this.getGeneralModifier());
	}
	
	
}
