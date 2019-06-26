
public class ThreeCard extends Card{

	public ThreeCard(double attackPoints, House house) {
		super(attackPoints, house);
		this.canAttack = true;	
	}
	/*
// the method below can direct attack any player over troops, and the player who triggers that effect can also attack him/herself.
	public void directAttack(InGamePlayer player) {
		Attack.attackPlayer(player);
	}
	
	*/

}
