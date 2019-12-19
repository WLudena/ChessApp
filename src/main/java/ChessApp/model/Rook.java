package ChessApp.model;

import ChessApp.model.types.PieceType;

import java.util.List;

public class Rook extends Piece {

    public Rook(){}

    public Rook(PieceType pieceType, char currentFile, int currentRank) {
        super(pieceType, currentFile, currentRank);
    }

    @Override
    public List<Square> movePiece(char nextFile, int nextRank, List<Square> board) {
        return null;
    }
}
