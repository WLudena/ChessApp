package ChessApp.controller;

import ChessApp.exceptions.PieceLoaderException;
import ChessApp.model.Piece;
import ChessApp.model.Square;

import java.util.List;

public class PieceLoader {

    public static Piece selectPiece(String piece, String location, int playerId, List<Square> board) throws PieceLoaderException {

        if (playerId == 1) {
            //Makes sure player 1 can only move WHITE piece
            Square sq = board.stream()
                    .filter(square -> {
                        if (square.getPiece()!=null && square.getPiece().getPieceType().getType().equalsIgnoreCase(piece) && square.getPosition().equalsIgnoreCase(location)) {
                            return true;
                        } else {
                            return false;
                        }
                    })
                    .findFirst()
                    .orElse(null);

            if (sq !=null && sq.getPiece().getPieceType().getTypeCode() > 0) {
                return sq.getPiece();
            }else{
                throw new PieceLoaderException();
            }
        } else {

            //Makes sure player 2 can only move BLACK pieces
            Square sq = board.stream()
                    .filter(square -> {
                        if (square.getPiece()!=null && square.getPiece().getPieceType().getType().equalsIgnoreCase(piece) && square.getPosition().equalsIgnoreCase(location)) {
                            return true;
                        } else {
                            return false;
                        }
                    })
                    .findFirst()
                    .orElse(null);

            if (sq != null && sq.getPiece().getPieceType().getTypeCode() < 0) {
                return sq.getPiece();
            } else {
                throw new PieceLoaderException();
            }
        }
    }
}
