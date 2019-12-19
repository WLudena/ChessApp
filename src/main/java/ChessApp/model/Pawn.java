package ChessApp.model;

import ChessApp.model.types.PieceType;

import java.util.List;

public class Pawn extends Piece {

    private boolean hasMoved = false; // Since pawn has the option to move twice on its first move, this will help keep track of it

    public Pawn(){}

    public Pawn(PieceType pieceType, char currentFile, int currentRank) {
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
    public boolean getHasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }
}
