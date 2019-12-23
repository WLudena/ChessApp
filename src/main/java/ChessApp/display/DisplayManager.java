package ChessApp.display;

import ChessApp.exceptions.PieceLoaderException;
import ChessApp.model.Player;

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

    public String getPieceRequest(Player player) throws PieceLoaderException {
        System.out.println( player.getName() + ", what piece would you like to move?: ");

        List<String> pieces = getPieces();

        String pieceType = scanner.nextLine().toUpperCase();
        if (pieces.contains(pieceType)) {
            return pieceType;
        } else {
            throw new PieceLoaderException();
        }
    }

    private List<String> getPieces(){
        List<String> pieces = new ArrayList<>();
        pieces.add("KING");
        pieces.add("QUEEN");
        pieces.add("ROOK");
        pieces.add("BISHOP");
        pieces.add("KNIGHT");
        pieces.add("PAWN");

        return pieces;
    }
}
