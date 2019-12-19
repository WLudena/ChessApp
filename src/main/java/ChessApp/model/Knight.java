package ChessApp.model;

import ChessApp.model.types.PieceType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Knight extends Piece {

    public Knight(){}

    public Knight(PieceType pieceType, char currentFile, int currentRank) {
        super(pieceType, currentFile, currentRank);
    }

    @Override
    public List<Square> movePiece(char nextFile, int nextRank, List<Square> board) {
        return null;
    }

}
