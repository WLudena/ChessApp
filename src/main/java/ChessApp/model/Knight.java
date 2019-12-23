package ChessApp.model;

import ChessApp.exceptions.InvalidMoveException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Knight extends Piece {

    public Knight() {
    }

    public Knight(PieceType pieceType, char currentFile, int currentRank) {
        super(pieceType, currentFile, currentRank);
    }

    @Override
    public void movePiece(char nextFile, int nextRank, List<Square> board) throws InvalidMoveException {

        String nextPosition = Character.toString(nextFile) + nextRank;

        if(possibleMoves().contains(nextPosition)){

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
                nextSquare.setPiece(new Knight(getPieceType(),nextFile,nextRank));
                currentSquare.setPiece(null);
            }
        }else{
            throw new InvalidMoveException();
        }
    }

    private List<String> possibleMoves() {

        List<Character> fileList = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H');

        List<String> possibleMoves = new ArrayList<>();

        //Used to track index of file in fileList<>
        int fileIndex = fileList.indexOf(getCurrentFile());

        //[-1,2] --> 2 forward, 1 left
        if (fileIndex - 1 > -1 && getCurrentRank() + 2 < 9) {
            possibleMoves.add(fileList.get(fileIndex - 1) + String.valueOf(getCurrentRank() + 2));
        }
        //[1,2] --> 2 forward, 1 right
        if (fileIndex + 1 < fileList.size() && getCurrentRank() + 2 < 9) {
            possibleMoves.add(fileList.get(fileIndex + 1) + String.valueOf(getCurrentRank() + 2));
        }
        //[2,1] --> 2 right, 1 forward
        if(fileIndex + 2 < fileList.size() && getCurrentRank() + 1 < 9){
            possibleMoves.add(fileList.get(fileIndex + 2) + String.valueOf(getCurrentRank()+1));
        }
        //[2,-1] --> 2 right, 1 backward
        if(fileIndex + 2 < fileList.size() && getCurrentRank() - 1 > 0){
            possibleMoves.add(fileList.get(fileIndex+ + 2) + String.valueOf(getCurrentRank() - 1));
        }
        //[1,-2] --> 2 backward, 1 right
        if (fileIndex + 1 < fileList.size() && getCurrentRank() - 2 > 0) {
            possibleMoves.add(fileList.get(fileIndex + 1) + String.valueOf(getCurrentRank() - 2));
        }
        //[-1,-2] --> 2 backward, 1 left
        if (fileIndex - 1 > -1 && getCurrentRank() - 2 > 0) {
            possibleMoves.add(fileList.get(fileIndex - 1) + String.valueOf(getCurrentRank()-2));
        }
        //[-2,-1] --> 2 left, 1 backward
        if(fileIndex - 2 > -1 && getCurrentRank() - 1 > 0){
            possibleMoves.add(fileList.get(fileIndex - 2) + String.valueOf(getCurrentRank() - 1));
        }

        //[-2,-1] --> 2 left, 1 forward
        if(fileIndex - 2 > -1 && getCurrentRank() + 1 < 9){
            possibleMoves.add(fileList.get(fileIndex - 2) + String.valueOf(getCurrentRank() + 1));
        }
        return possibleMoves;
    }

    public List<String> testingMoves(){
        return possibleMoves();
    }

}
