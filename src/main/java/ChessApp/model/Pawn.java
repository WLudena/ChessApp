package ChessApp.model;

import ChessApp.model.types.PieceType;

import java.util.List;

public class Pawn extends Piece {

    public Pawn(){}

    public Pawn(PieceType pieceType, char currentFile, int currentRank) {
        super(pieceType, currentFile, currentRank);
    }

    @Override
    public void movePiece(char nextFile, int nextRank, List<Square> board) {

    }
}
