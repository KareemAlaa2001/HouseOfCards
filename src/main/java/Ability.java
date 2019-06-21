/* 	This is the abstract super class for the implementation of the abilities used by suits
 *	it is subclassed by four classes for the four suits of a card deck. Abilities can either
 *	be used to enhance an attack, reduce received damage in defence or apply a per turn effect	*/
public abstract class Ability {
	/*
	boolean isPerTurn;
	boolean isFullCycle;
	boolean isAttack;
	boolean isSelfDefence;
	*/
	
	/*	this double represents the general modifier by which an ability either adds to an attack, 
	 * 	multiplies by a received attack, or applies for healing
	 * 	If using a number for damage reduction use 0.75 to represent 25% reduction, 0.5 for 50% 
	 *  and 0.25 for 75% reduction  
	 *  */
	private double generalModifier;
	
	//  Added this constructor at first but rethinking its use
	public Ability (double genMod, boolean isPerTurn, boolean isFullCycle, boolean isAttack, boolean isSelfDefence)
	{
		this.setGeneralModifier(genMod);
		
		//  ignore this commented block pls
		/*this.isPerTurn = isPerTurn;
		this.isFullCycle = isFullCycle;
		this.isAttack = isAttack;
		this.isSelfDefence = isSelfDefence;*/
	}
	
	//  Meant as a super constructor for subclasses to use for storing general modifier
	public Ability(double genMod)
	{
		this.setGeneralModifier(genMod);
	}
	
	//  Abstract method to call the ability represented by the relevant subclass instance
	public abstract void callAbility(AbstractAttack atk);

	//	generalModifier getter
	public double getGeneralModifier() {
		return generalModifier;
	}
	
	//	generalModifier setter
	public void setGeneralModifier(double generalModifier) {
		this.generalModifier = generalModifier;
	}
}
