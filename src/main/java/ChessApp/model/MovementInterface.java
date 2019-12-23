package ChessApp.model;

import ChessApp.exceptions.InvalidMoveException;
import ChessApp.model.Square;

import java.util.List;

public interface MovementInterface {

    void movePiece(char nextFile, int nextRank, List<Square> board) throws InvalidMoveException;

}
