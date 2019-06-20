/* 	This is the abstract super class for the implementation of the abilities used by suits
 *	it is subclassed by four classes for the four suits of a card deck	*/
public abstract class Ability {
	/*
	boolean isPerTurn;
	boolean isFullCycle;
	boolean isAttack;
	boolean isSelfDefence;
	*/
	
	/*	this double represents the general modifier by which an ability either adds to an attack, 
	 * 	multiplies by a received attack, or applies for healing	 */
	protected double generalModifier;
	
	//  Added this constructor at first but rethinking its use
	public Ability (double genMod, boolean isPerTurn, boolean isFullCycle, boolean isAttack, boolean isSelfDefence)
	{
		this.generalModifier = genMod;
		/*this.isPerTurn = isPerTurn;
		this.isFullCycle = isFullCycle;
		this.isAttack = isAttack;
		this.isSelfDefence = isSelfDefence;*/
	}
	
	//  Meant as a super constructer for subclasses to use for storing general modifier
	public Ability(double genMod)
	{
		this.generalModifier = genMod;
	}
	
	//  Abstract method to call the ability represented by the relevant subclass instance
	public abstract void callAbility(Card atkCard, Card defCard, InGamePlayer defPlayer);
}
