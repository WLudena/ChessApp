package ChessApp.model.interfaces;

import ChessApp.model.Square;

import java.util.List;

public interface MovementInterface {

    void movePiece(char nextFile, int nextRank, List<Square> board);

}
