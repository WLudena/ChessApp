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

    private Scanner input = new Scanner(System.in);

    public void startGame() {

        System.out.println("\n");
        System.out.println("Java Chess!");

        List<Square> board = chessBoard.getChessBoard();
        Player[] players = displayManager.setPlayers(); //Set initial players names

        boolean hasForfeit = false;
        int loserId = 0;

        boolean playersTurn = true; //When true, it is first player's turn, else second player

        while (checkKings(board) && !hasForfeit) {
            //Display board
            if (playersTurn) {
                //First player turn
                try {
                    display.displayBoard(1, players, board);
                    String pieceType = displayManager.getPieceRequest(players[0]);
                    System.out.println("From?: ");
                    String location = input.nextLine();
                    Piece piece = null;

                    if (!location.equalsIgnoreCase("ff")) {
                        piece = PieceLoader.selectPiece(pieceType, location, 1, board);
                    } else {
                        hasForfeit = true;
                        break;
                    }

                    System.out.println("To?: ");
                    String destination = input.nextLine();

                    if (!destination.equalsIgnoreCase("ff")) {
                        piece.movePiece(Character.toUpperCase(destination.charAt(0)), Integer.valueOf(destination.substring(1)), board);

                    } else {
                        hasForfeit = true;
                        break;
                    }

                    playersTurn = false;

                } catch (PieceLoaderException | InvalidMoveException | NumberFormatException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                //Second player turn
                try {
                    display.displayBoard(2, players, board);
                    String pieceType = displayManager.getPieceRequest(players[1]);
                    System.out.println("From?: ");
                    String location = input.nextLine();

                    Piece piece = null;

                    if (!location.equalsIgnoreCase("ff")) {
                        piece = PieceLoader.selectPiece(pieceType, location, 2, board);
                    } else {
                        hasForfeit = true;
                        loserId = 1;
                        break;
                    }

                    System.out.println("To?: ");
                    String destination = input.nextLine();

                    if (!destination.equalsIgnoreCase("ff")) {
                        piece.movePiece(Character.toUpperCase(destination.charAt(0)), Integer.valueOf(destination.substring(1)), board);
                    } else {
                        hasForfeit = true;
                        loserId = 1;
                        break;
                    }
                    playersTurn = true;

                } catch (PieceLoaderException | InvalidMoveException | NumberFormatException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        if (checkKings(board) && hasForfeit && loserId == 0) {
            System.out.println(players[0].getName() + " has forfeit!");
        } else if (checkKings(board) && hasForfeit && loserId == 1) {
            System.out.println(players[1].getName() + " has forfeit!");
        } else {
            System.out.println(checkWinner(players, board) + " wins!");
        }
    }

    private boolean checkKings(List<Square> board) {

        Square whiteKingSquare = board.stream()
                .filter(square -> square.getPiece() != null && square.getPiece().getPieceType().getTypeCode() == 1)
                .findFirst()
                .orElse(null);

        Square blackKingSquare = board.stream()
                .filter(square -> square.getPiece() != null && square.getPiece().getPieceType().getTypeCode() == -1)
                .findFirst()
                .orElse(null);

        if (whiteKingSquare != null && blackKingSquare != null) {
            return true;
        } else {
            return false;
        }
    }

    private String checkWinner(Player[] players, List<Square> board) {

        /*
        No need to check for both kings as when the program reaches this method,
        if the white king is found, it can be assumed that the black king is the one missing
        */

        Square whiteKingSquare = board.stream()
                .filter(square -> square.getPiece() != null && square.getPiece().getPieceType().getTypeCode() == 1)
                .findFirst()
                .orElse(null);

        if (whiteKingSquare == null) {
            //If white king no longer exists, black/second player wins
            return players[1].getName();
        } else {
            //If black king no longer exists, then white/first player wins
            return players[0].getName();
        }
    }
}
