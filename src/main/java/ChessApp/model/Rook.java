package ChessApp.model;

import ChessApp.model.types.PieceType;

import java.util.List;

public class Rook extends Piece {

    public Rook(){}

    public Rook(PieceType pieceType, char currentFile, int currentRank) {
        super(pieceType, currentFile, currentRank);
    }

    @Override
    public void movePiece(char nextFile, int nextRank, List<Square> board) {
    }
    private boolean canMove(){
        return false;
    }

    private List<String> possibleMoves(){
        return null;
    }

    private String getLocationHelper(){
        return null;
    }
}
