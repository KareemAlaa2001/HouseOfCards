/*	Class to represent club abilities, club main theme: Poison. Jack damages attacking card by
 * 	an extra half of its attacking points, queen applies a lingering poison which reduces card
 * 	health points by 1 per turn as well as jack ability and king applies half the damage of the
 * 	attack to the attacking player's health points as well as the other abilities 
 * 	*/
public class ClubAbility extends Ability {
	
	public static final int QUEEN_MODIFIER = -1;
	private boolean isPerTurn;
	private boolean isSelfDefence;
	
	public ClubAbility(double genMod, boolean isPerTurn, boolean isSelfDefence) {
		super(genMod);
		this.setPerTurn(isPerTurn);
		this.setSelfDefence(isSelfDefence);
	}
	
	@Override
	public void callAbility(Attack atk) {
		atk.getAttackingCard().setHealthPoints(
				atk.getAttackingCard().getHealthPoints() - atk.getAttackPoints()*this.getGeneralModifier());
		
		if (isPerTurn) {
			atk.getAttackingCard().setActivePerTurnEffect(
					atk.getAttackingCard().getActivePerTurnEffect() + QUEEN_MODIFIER);
			
			if (!isSelfDefence) {
				atk.getAttackingPlayer().setHealthPoints(
						atk.getAttackingPlayer().getHealthPoints() - atk.getAttackPoints()*this.getGeneralModifier());
			}
		}
	}
	
	public boolean isPerTurn() {
		return isPerTurn;
	}

	public void setPerTurn(boolean isPerTurn) {
		this.isPerTurn = isPerTurn;
	}

	public boolean isSelfDefence() {
		return isSelfDefence;
	}

	public void setSelfDefence(boolean isSelfDefense) {
		this.isSelfDefence = isSelfDefense;
	}

}

	

