package ChessApp.model.interfaces;

import ChessApp.exceptions.InvalidMoveException;
import ChessApp.model.Square;

import java.util.List;

public interface MovementInterface {

    List<Square> movePiece(char nextFile, int nextRank, List<Square> board) throws InvalidMoveException;

}
