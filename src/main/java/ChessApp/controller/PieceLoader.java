package ChessApp.controller;

import ChessApp.exceptions.PieceLoaderException;
import ChessApp.model.Piece;
import ChessApp.model.Square;

import java.util.List;

public class PieceLoader {

    private String name;
    private static final String SRC = "/src/main/java/";

    {
        String classPath = Piece.class.getName();
        name = classPath.substring(0, classPath.lastIndexOf('.'));
    }

    public String getPiecesLocation() {
        String classPathStr = System.getProperty("user.dir");
        return (classPathStr + SRC + name.replace('.', '/'));
    }

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
