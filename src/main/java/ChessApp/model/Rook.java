package ChessApp.model;

import ChessApp.exceptions.InvalidMoveException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rook extends Piece {

    public Rook() {}

    public Rook(PieceType pieceType, char currentFile, int currentRank) {
        super(pieceType, currentFile, currentRank);
    }

    @Override
    public void movePiece(char nextFile, int nextRank, List<Square> board) throws InvalidMoveException {

        String nextPosition = Character.toString(nextFile) + nextRank;

        if(possibleMoves(board).contains(nextPosition)){

            Square currentSquare = board.stream()
                    .filter(square -> square.getPosition().equals(getCurrentPosition()))
                    .findFirst()
                    .orElse(null);

            Square nextSquare = board.stream()
                    .filter(square -> square.getPosition().equals(nextPosition))
                    .findFirst()
                    .orElse(null);

            if(nextSquare.getPiece()!=null){
                if (getPieceType().getTypeCode() > 0 && nextSquare.getPiece().getPieceType().getTypeCode() > 0) {
                    throw new InvalidMoveException();
                } else if (getPieceType().getTypeCode() < 0 && nextSquare.getPiece().getPieceType().getTypeCode() < 0) {
                    throw new InvalidMoveException();
                } else {
                    nextSquare.setPiece(new Queen(getPieceType(), nextFile, nextRank));
                    currentSquare.setPiece(null);
                }
            }else{
                nextSquare.setPiece(new Rook(getPieceType(),nextFile,nextRank));
                currentSquare.setPiece(null);
            }
        }else{
            throw new InvalidMoveException();
        }

    }

    //Lists all possible moves the rook can make (checks if square already contains piece)
    private List<String> possibleMoves(List<Square> board) {

        List<Character> fileList = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H');

        List<String> possibleMoves = new ArrayList<>();

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

        //[0,1],[0,2]...[0,7] --> forward
        for (int i = Integer.parseInt(getCurrentPosition().substring(1)) + 1; i < 9; i++) {
            if (!squareIsEmpty(Character.toString(getCurrentFile()) + i, board)) {

                //Stop adding locations the moment it reaches an already populated square
                possibleMoves.add(Character.toString(getCurrentFile()) + i);
                break;

            } else {
                possibleMoves.add(Character.toString(getCurrentFile()) + i);
            }
        }

        //[1,0],[2,0]...[7,0] --> right
        for (int i = fileIndex + 1; i < fileList.size(); i++) {
            if (!squareIsEmpty(fileList.get(i) + getCurrentPosition().substring(1), board)) {
                possibleMoves.add(fileList.get(i) + getCurrentPosition().substring(1));
                break;
            } else {
                possibleMoves.add(fileList.get(i) + getCurrentPosition().substring(1));
            }
        }

        //[0,-1],[0,-2]...[0,-7] --> backward
        for (int i = Integer.parseInt(getCurrentPosition().substring(1)) - 1; i > 0; i--) {
            if (!squareIsEmpty(Character.toString(getCurrentFile()) + i, board)) {
                possibleMoves.add(Character.toString(getCurrentFile()) + i);
                break;
            } else {
                possibleMoves.add(Character.toString(getCurrentFile()) + i);
            }
        }
        //[-1,0],[-2,0]...[-7,0] --> left
        for (int i = fileIndex - 1; i >= 0; i--) {
            if (!squareIsEmpty(fileList.get(i) + getCurrentPosition().substring(1), board)) {
                possibleMoves.add(fileList.get(i) + getCurrentPosition().substring(1));
                break;
            } else {
                possibleMoves.add(fileList.get(i) + getCurrentPosition().substring(1));
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
