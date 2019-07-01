import java.util.ArrayList;

public class MainProgram{

    private static OfflineGame startGame(){
        OfflineGame game = new OfflineGame();
        return game;
    }

    // returns the winning player, or the players in a draw
    private static ArrayList<InGamePlayer> loop(OfflineGame game){
        while(!game.isGameOver()){
            game.beginTurn(); 
            // here will lie the basic game turn logic after making the GUI classes
            game.endTurn();
        }
        return null;
    }

    public static void main(String args[]){
        // should first display menus and check selections, after making the GUI classes
        OfflineGame game = startGame();
        ArrayList<InGamePlayer> winningPlayers = loop(game);
    }
}