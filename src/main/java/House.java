
public class House {
	// the shapes are stored as integers, each shape is denoted by a constant
	public static final int CLUBS = 0;
	public static final int HEART = 1;
	public static final int DIAMOND = 2;
	public static final int SPADE = 3;

	// the shape varible hold either House.CLUBS(0) --> House.SPADE(3)
	private int shape;

	public void setShape(int shape){
		this.shape = shape;
	}
	
	public int getShape(){
		return shape;	
	}
}
