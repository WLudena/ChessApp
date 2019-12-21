package ChessApp.display;

import ChessApp.exceptions.PieceLoaderException;
import ChessApp.model.Piece;
import ChessApp.model.Player;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DisplayManager {

    private Scanner scanner = new Scanner(System.in);

    public Player[] setPlayers(){
        Player[] players = new Player[2];

        System.out.println("Player 1 name: ");
        String player1 = scanner.nextLine();
        players[0] = new Player(player1,1);

        System.out.println("Player 2 name: ");
        String player2 = scanner.nextLine();
        players[1] = new Player(player2,2);

        return players;
    }

    public String getPieceRequest(String path) throws PieceLoaderException {
        System.out.println("What piece would you like to move?: ");

        File dir = new File(path);
        List<String> pieces = getPieces(dir);

        String pieceType = scanner.nextLine();
        if (pieces.contains(pieceType)) {
            return pieceType;
        } else {
            throw new PieceLoaderException();
        }
    }

    //This would return the different piece types available for the player
    private List<String> getPieces(File dir) {
        List<String> pieces = new ArrayList<>();
        for (String s : dir.list()) {
            if (!s.equals("Piece.java") || !s.equals("Player.java") || !s.equals("Square.java")) {
                pieces.add(s);
            }
        }
        return pieces;
    }
}
