package ChessApp.model;

import ChessApp.model.types.PieceType;

import java.util.List;

public class Bishop extends Piece {

    public Bishop(){}

    public Bishop(PieceType pieceType, char currentFile, int currentRank) {
        super(pieceType, currentFile, currentRank);
    }

    @Override
    public void movePiece(char nextFile, int nextRank, List<Square> board) {

    }
}
