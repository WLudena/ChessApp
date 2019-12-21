package ChessApp.controller;

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
    private DisplayManager displayManager = new DisplayManager();
    private PieceLoader loader = new PieceLoader();

    private Scanner input = new Scanner(System.in);

    public void startGame() {

        List<Square> board = chessBoard.getChessBoard();
        Player[] players = displayManager.setPlayers(); //Set initial players names

        try {
            String pieceType = displayManager.getPieceRequest(loader.getPiecesLocation());
            System.out.println("From?: ");
            String location = input.nextLine();

            String pieceAndLocation = pieceType + "," + location;

            Piece piece = selectPiece(pieceAndLocation, 1, board);


        } catch (PieceLoaderException | InvalidMoveException e) {
            System.out.println(e.getMessage());
        }
    }


    private Piece selectPiece(String pieceAndLocation, int playerId, List<Square> board) throws InvalidMoveException {

        if(playerId==1){

            //Makes sure player 1 can only move WHITE piece
            Square sq = board.stream()
                    .filter(square -> {
                        if(square.getPiece().getPieceType().getType().equals(pieceAndLocation.substring(0,pieceAndLocation.lastIndexOf(','))) && square.getPosition().equals(pieceAndLocation.substring(pieceAndLocation.lastIndexOf(','),pieceAndLocation.length()))){
                            return true;
                        }else{
                            return false;
                        }
                    })
                    .findFirst()
                    .orElse(null);

            if(sq.getPiece().getPieceType().getTypeCode() > 0){
                return sq.getPiece();
            }else{
                throw new InvalidMoveException();
            }
        }else{

            //Makes sure player 2 can only move BLACK pieces
            Square sq = board.stream()
                    .filter(square -> {
                        if(square.getPiece().getPieceType().getType().equals(pieceAndLocation.substring(0,pieceAndLocation.lastIndexOf(','))) && square.getPosition().equals(pieceAndLocation.substring(pieceAndLocation.lastIndexOf(','),pieceAndLocation.length()))){
                            return true;
                        }else{
                            return false;
                        }
                    })
                    .findFirst()
                    .orElse(null);

            if(sq.getPiece().getPieceType().getTypeCode() < 0){
                return sq.getPiece();
            }else{
                throw new InvalidMoveException();
            }
        }
    }

}
