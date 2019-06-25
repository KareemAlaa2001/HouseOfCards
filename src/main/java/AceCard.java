import java.util.ArrayList;
public class AceCard extends Card {

	
	
	public AceCard(double attackPoints, House house) {
		super(attackPoints, house);

	}
// checks whether the ace is in hand or not
	public boolean aceInHand() {
		   boolean flag = true;
			for(int i = 1;i<InGamePlayer.hand.size();i++) {
				if(InGamePlayer.hand.get(i).attackPoints == 1){
					flag =  true;
			        break;
				}
			        else {
			        	flag = false;
			        }
			}
		return flag;	
	}
}
