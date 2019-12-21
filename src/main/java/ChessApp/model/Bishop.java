package ChessApp.model;

import ChessApp.exceptions.InvalidMoveException;
import ChessApp.model.types.PieceType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bishop extends Piece {

    public Bishop(){}

    public Bishop(PieceType pieceType, char currentFile, int currentRank) {
        super(pieceType, currentFile, currentRank);
    }

    @Override
    public void movePiece(char nextFile, int nextRank, List<Square> board) throws InvalidMoveException {
        String nextPosition = Character.toString(nextFile) + nextRank;

        if (possibleMoves(board).contains(nextPosition)) {

            Square currentSquare = board.stream()
                    .filter(square -> square.getPosition().equals(getCurrentPosition()))
                    .findFirst()
                    .orElse(null);

            Square nextSquare = board.stream()
                    .filter(square -> square.getPosition().equals(nextPosition))
                    .findFirst()
                    .orElse(null);

            if (nextSquare.getPiece() != null) {
                if (getPieceType().getTypeCode() > 0 && nextSquare.getPiece().getPieceType().getTypeCode() > 0) {
                    throw new InvalidMoveException();
                } else if (getPieceType().getTypeCode() < 0 && nextSquare.getPiece().getPieceType().getTypeCode() < 0) {
                    throw new InvalidMoveException();
                } else {
                    nextSquare.setPiece(new Queen(getPieceType(), nextFile, nextRank));
                    currentSquare.setPiece(null);
                }
            } else {
                nextSquare.setPiece(new Bishop(getPieceType(), nextFile, nextRank));
                currentSquare.setPiece(null);
            }
        } else {
            throw new InvalidMoveException();
        }
    }

    //Lists all possible moves the bishop can make from current position (checks if a piece exists on the next square)
    private List<String> possibleMoves(List<Square> board) {
        List<Character> fileList = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H');

        List<String> possibleMoves = new ArrayList<>();

        //Used to keep track of file/rank when moving in diagonal direction
        int increase = 1;
        int decrease = -1;

        //Used to track index of file in fileList<>
        int fileIndex = fileList.indexOf(getCurrentFile());

        /*
        Since board is two-dimensional ([x,y]), we can use this to keep track of where the piece would go next.
        E.g.: if a piece initial position is [0,0], mapping it would look something like this:

                                             :
                                             :
                                           [0,2]
                                           [0,1]
                                             ^
                                             |
                         ...[-2,0][-1,0] <-[0,0]-> [1,0][2,0]...
                                             |
                                             V
                                           [0,-1]
                                           [0,-2]
                                             :
                                             :

         Each would represent a step in their respective directions (changes for every piece)
         */

        //[1,1],[2,2]...[7,7] --> forward-right
        for (int i = fileIndex + 1; i < fileList.size(); i++) {
            if (getCurrentRank() + increase < 9) {
                if (!squareIsEmpty(fileList.get(i) + String.valueOf((getCurrentRank() + increase)), board)) {
                    possibleMoves.add(fileList.get(i) + String.valueOf((getCurrentRank() + increase)));
                    break;
                } else {
                    possibleMoves.add(fileList.get(i) + String.valueOf((getCurrentRank() + increase)));
                    increase++;
                }
            }
        }

        //[1,-1],[2,-2]...[7,-7] --> backward-right
        for (int i = fileIndex + 1; i < fileList.size(); i++) {
            if (getCurrentRank() + decrease > 0) {
                if (!squareIsEmpty(fileList.get(i) + String.valueOf((getCurrentRank() + decrease)), board)) {
                    possibleMoves.add(fileList.get(i) + String.valueOf((getCurrentRank() + decrease)));
                    break;
                } else {
                    possibleMoves.add(fileList.get(i) + String.valueOf((getCurrentRank() + decrease)));
                    decrease--;
                }
            }
        }

        //[-1,-1],[-2,-2]...[-7,-7] --> backward-left
        decrease = -1;
        for (int i = Integer.parseInt(getCurrentPosition().substring(1)) - 1; i > 0; i--) {
            if (fileIndex + decrease > -1) {
                if (!squareIsEmpty(Character.toString(fileList.get(fileIndex + decrease)) + i, board)) {
                    possibleMoves.add(Character.toString(fileList.get(fileIndex + decrease)) + i);
                    break;
                } else {
                    possibleMoves.add(Character.toString(fileList.get(fileIndex + decrease)) + i);
                    decrease--;
                }
            }
        }

        //[-1,1],[-2,2]...[-7,7] --> forward-left
        increase = 1;
        for (int i = fileIndex - 1; i >= 0; i--) {
            if (getCurrentRank() + increase < 9) {
                if (!squareIsEmpty(fileList.get(i) + String.valueOf((getCurrentRank() + increase)), board)) {
                    possibleMoves.add(fileList.get(i) + String.valueOf((getCurrentRank() + increase)));
                    break;
                } else {
                    possibleMoves.add(fileList.get(i) + String.valueOf((getCurrentRank() + increase)));
                    increase++;
                }
            }
        }

        return possibleMoves;
    }

    //Helper method to find out whether a square contains a piece or not
    private boolean squareIsEmpty(String location, List<Square> board) {
        return board.stream()
                .anyMatch(square -> {
                    if (square.getPosition().equals(location) && square.getPiece() == null) {
                        return true;
                    } else {
                        return false;
                    }
                });
    }
}
