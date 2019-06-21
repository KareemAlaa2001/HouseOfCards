
public class AttackOnPlayer extends AbstractAttack{
	private InGamePlayer defPlayer;

	public AttackOnPlayer(Card atkCard, InGamePlayer atkPlayer, InGamePlayer defPlayer) {
		super(atkCard, atkPlayer);
		this.setDefPlayer(defPlayer);
	}
	
	public InGamePlayer getDefPlayer() {
		return defPlayer;
	}

	public void setDefPlayer(InGamePlayer defPlayer) {
		this.defPlayer = defPlayer;
	}
	
}
