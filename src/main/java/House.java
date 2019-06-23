
public class House {
	// the shapes are stored as integers, each shape is denoted by a constant
	public static final int CLUBS = 0;
	public static final int HEART = 1;
	public static final int DIAMOND = 2;
	public static final int SPADE = 3;

	// the shape variable holds either House.CLUBS(0) --> House.SPADE(3)
	private int shape;

	private boolean jackAlive;
	private boolean queenAlive;
	private boolean kingAlive;
	
	private Ability jackAbility;
	private Ability queenAbility;
	private Ability kingAbility;
	
	private Ability activeAbility;
	
	
	public House(int shape, Ability jackAbility, Ability queenAbility, Ability kingAbility) throws IllegalStateException {
		
		setJackAlive(true);
		setQueenAlive(true);
		setKingAlive(true);
		
		createAbilities();
		setActiveAbility(jackAbility);
		
		setShape(shape);
	}
	
	public void killHouseCard() throws IllegalStateException {
		if (jackAlive) {
			setJackAlive(false);
			setActiveAbility(queenAbility);
		} else if (queenAlive) {
			setQueenAlive(false);
			setActiveAbility(kingAbility);
		} else if (kingAlive) {
			setKingAlive(false);
		} else {
			throw new IllegalStateException("Can't kill a house card, they're all already dead!");
		}
			
		
	}

	private void createAbilities() throws IllegalArgumentException {
		switch(this.getShape()) {
		
		case(SPADE):
			assignAbilities(createSpadeAbilities());
			break;
		case(HEART):
			assignAbilities(createHeartAbilities());
			break;
		case(DIAMOND):
			assignAbilities(createDiamondAbilities());
			break;
		case(CLUBS):
			assignAbilities(createClubsAbilities());
			break;
		default:
			throw new IllegalArgumentException("Invalid shape!");
		}
	}
	
	private void assignAbilities(Ability[] shapeAbilities) {
		this.jackAbility = shapeAbilities[0];
		this.queenAbility = shapeAbilities[1];
		this.kingAbility = shapeAbilities[2];
	}
	
	public int getShape(){
		return shape;	
	}
	
	private Ability createJackSpadeAbility() {
		return new SpadeAbility(SpadeAbility.JACK_MODIFIER, true);
	}
	
	private Ability createQueenSpadeAbility() {
		return new SpadeAbility(SpadeAbility.QUEEN_MODIFIER, true);
	}

	private Ability createKingSpadeAbility() {
		return new SpadeAbility(SpadeAbility.KING_MODIFIER, false);
	}
	
	private Ability createJackHeartsAbility() {
		return new HeartAbility(HeartAbility.JACK_MODIFIER, true);
	}
	
	private Ability createQueenHeartsAbility() {
		return new HeartAbility(HeartAbility.QUEEN_MODIFIER, true);
	}
	
	private Ability createKingHeartsAbility() {
		return new HeartAbility(HeartAbility.KING_MODIFIER, false);
	}

	private Ability createJackDiamondsAbility() {
		return new DiamondAbility(DiamondAbility.JACK_MODIFIER);
	}
	
	private Ability createQueenDiamondsAbility() {
		return new DiamondAbility(DiamondAbility.QUEEN_MODIFIER);
	}
	
	private Ability createKingDiamondsAbility() {
		return new DiamondAbility(DiamondAbility.KING_MODIFIER);
	}
	
	private Ability createJackClubsAbility() {
		return new ClubAbility(ClubAbility.GENERAL_MODIFIER, true, true);
	}
	
	private Ability createQueenClubsAbility() {
		return new ClubAbility(ClubAbility.QUEEN_MODIFIER, false, true);
	}
	
	private Ability createKingClubsAbility() {
		return new ClubAbility(ClubAbility.GENERAL_MODIFIER, false, false);
	}
	
	private Ability[] createSpadeAbilities() {
		return new Ability[] { createJackSpadeAbility(), createQueenSpadeAbility(), createKingSpadeAbility() };
	}
	
	private Ability[] createHeartAbilities() {
		return new Ability[] { createJackHeartsAbility(), createQueenHeartsAbility(), createKingHeartsAbility() };
	}
	
	private Ability[] createDiamondAbilities() {
		return new Ability[] { createJackDiamondsAbility(), createQueenDiamondsAbility(), createKingDiamondsAbility() };
	}

	private Ability[] createClubsAbilities() {
		return new Ability[] { createJackClubsAbility(), createQueenClubsAbility(), createKingClubsAbility() };
	}
 	
	public void setShape(int shape) throws IllegalArgumentException {
		if (shape >= 0 && shape <= 3) this.shape = shape;
		else throw new IllegalArgumentException("Shape can only be one of the four constants defined for the class!");
	}

	public boolean isJackAlive() {
		return jackAlive;
	}

	public void setJackAlive(boolean jackAlive) {
		this.jackAlive = jackAlive;
	}

	public boolean isQueenAlive() {
		return queenAlive;
	}

	public void setQueenAlive(boolean queenAlive) {
		this.queenAlive = queenAlive;
	}

	public boolean isKingAlive() {
		return kingAlive;
	}

	public void setKingAlive(boolean kingAlive) {
		this.kingAlive = kingAlive;
	}

	public Ability getActiveAbility() {
		return activeAbility;
	}

	public void setActiveAbility(Ability activeAbility) {
		this.activeAbility = activeAbility;
	}
}
