//	File is created and maintained by a-elhawary
import java.util.ArrayList;

//  main program for singleplayer offline version of the game, no GUI built yet
public class MainProgram{

    //  method to start the game
    private static OfflineGame startGame(){
        OfflineGame game = new OfflineGame();
        System.out.println("Game started");
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
        System.out.println("Program run successfully");
    }
}