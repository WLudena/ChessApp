package ChessApp.controller;

import ChessApp.display.Display;
import ChessApp.display.DisplayManager;
import ChessApp.exceptions.InvalidMoveException;
import ChessApp.exceptions.PieceLoaderException;
import ChessApp.model.Piece;
import ChessApp.model.Player;
import ChessApp.model.Square;

import java.util.List;
import java.util.Scanner;

public class Game {

    private ChessBoard chessBoard = new ChessBoard();
    private Display display = new Display();
    private DisplayManager displayManager = new DisplayManager();
    private PieceLoader loader = new PieceLoader();

    private Scanner input = new Scanner(System.in);

    public void startGame() {

        System.out.println("Java Chess!");

        List<Square> board = chessBoard.getChessBoard();
        Player[] players = displayManager.setPlayers(); //Set initial players names

        boolean playersTurn = true; //When true, it is first player's turn, else second player

        while (checkKings(board)) {
            //Display board
            display.displayBoard(players,board);
            if(playersTurn){
                //First player turn
                try {
                    String pieceType = displayManager.getPieceRequest(players[0],loader.getPiecesLocation());
                    System.out.println("From?: ");
                    String location = input.nextLine();

                    Piece piece = PieceLoader.selectPiece(pieceType, location,1, board);

                    System.out.println("To?: ");
                    String destination = input.nextLine();

                    piece.movePiece(Character.toUpperCase(destination.charAt(0)),Integer.valueOf(destination.substring(1)),board);

                    playersTurn = false;

                } catch (PieceLoaderException | InvalidMoveException | NumberFormatException e) {
                    System.out.println(e.getMessage());
                }
            }
            else{
                //Second player turn
                try {
                    String pieceType = displayManager.getPieceRequest(players[1],loader.getPiecesLocation());
                    System.out.println("From?: ");
                    String location = input.nextLine();

                    Piece piece = PieceLoader.selectPiece(pieceType, location,2, board);

                    System.out.println("To?: ");
                    String destination = input.nextLine();

                    piece.movePiece(Character.toUpperCase(destination.charAt(0)),Integer.valueOf(destination.substring(1)),board);

                    playersTurn = true;

                } catch (PieceLoaderException | InvalidMoveException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        System.out.println(checkWinner(players,board) + " wins!");
    }

    private boolean checkKings(List<Square> board) {

        Square whiteKingSquare = board.stream()
                .filter(square -> square.getPiece()!=null && square.getPiece().getPieceType().getTypeCode() == 1)
                .findFirst()
                .orElse(null);

        Square blackKingSquare = board.stream()
                .filter(square -> square.getPiece()!=null && square.getPiece().getPieceType().getTypeCode() == -1)
                .findFirst()
                .orElse(null);

        if(whiteKingSquare != null && blackKingSquare != null){
            return true;
        }else{
            return false;
        }
    }

    private String checkWinner(Player[] players, List<Square> board){

        /*
        No need to check for both kings as when the program reaches this method,
        if the white king is found, it can be assumed that the black king is the one missing
        */

        Square whiteKingSquare = board.stream()
                .filter(square -> square.getPiece()!=null && square.getPiece().getPieceType().getTypeCode() == 1)
                .findFirst()
                .orElse(null);

        if(whiteKingSquare == null){
            //If white king no longer exists, black/second player wins
            return players[1].getName();
        }else{
            //If black king no longer exists, then white/first player wins
            return players[0].getName();
        }
    }
}
