/* 	This is the abstract super class for the implementation of the abilities used by suits
 *	it is subclassed by four classes for the four suits of a card deck. Abilities can either
 *	be used to enhance an attack, reduce received damage in defence or apply a per turn effect	*/
//	file built by kareemalaa2001
public abstract class Ability {

	/*	this double represents the general modifier by which an ability either adds to an attack, 
	 * 	multiplies by a received attack, or applies for healing
	 * 	If using a number for damage reduction use 0.75 to represent 25% reduction, 0.5 for 50% 
	 *  and 0.25 for 75% reduction  
	 *  */
	private double generalModifier;
		
	//  Meant as a super constructor for subclasses to use for storing general modifier
	public Ability(double genMod)
	{
		this.setGeneralModifier(genMod);
	}
	
	//  Abstract method to call the ability represented by the relevant subclass instance
	public abstract void callAbility(Attack atk);
	
	//	generalModifier getter
	public double getGeneralModifier() {
		return generalModifier;
	}
	
	//	generalModifier setter
	public void setGeneralModifier(double generalModifier) {
		this.generalModifier = generalModifier;
	}
	
	//	checks if double entered is in the array of valid modifiers, since each kind of ability has a defined set of modifiers
	protected boolean checkModifierValid(double genMod, double[] validMods) {
		for (double mod: validMods) {
			if (mod == genMod) return true;
		}
		return false;
	}
}
