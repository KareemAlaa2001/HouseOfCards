/*	AceCard is a special kind of card which can be played from hand to block attacks from an attacking player towards another player for a full turn,
 *	where the defendiong player can be himself or another player*/
//	file built by mostafamohmd

public class AceCard extends Card {
	
	//	constant for ace card's attack points value used if the card is deployed to a player's battle list
	public static final double ATTACK_POINTS = 1;
	
	//	Constructor, calls super constructor
	public AceCard(double attackPoints, House house) {
		super(ATTACK_POINTS, house);

	}
	// aceInHand method was copied over to InGamePlayer class
}
