package ChessApp.model;

import ChessApp.exceptions.InvalidMoveException;
import ChessApp.model.types.PieceType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class King extends Piece {

    public King() {
    }

    public King(PieceType pieceType, char currentFile, int currentRank) {
        super(pieceType, currentFile, currentRank);
    }

    @Override
    public List<Square> movePiece(char nextFile, int nextRank, List<Square> board) throws InvalidMoveException {

        String nextPosition = Character.toString(nextFile) + nextRank;

        if (canMove(nextFile, nextRank, board)) {

            Square currentSquare = board.stream()
                    .filter(square -> square.getPosition().equals(getCurrentPosition()))
                    .findFirst()
                    .orElse(null);

            Square nextSquare = board.stream()
                    .filter(square -> square.getPosition().equals(nextPosition))
                    .findFirst()
                    .orElse(null);

            if (nextSquare.getPiece() != null) { //If nextSquare is not empty, check both pieces

                if (this.getPieceType().getTypeCode() > 0 && nextSquare.getPiece().getPieceType().getTypeCode() > 0) { //If both (moving and nextSquare) pieces are white
                    throw new InvalidMoveException();
                } else if (this.getPieceType().getTypeCode() < 0 && nextSquare.getPiece().getPieceType().getTypeCode() < 0) { //If both (moving and nextSquare) pieces are black
                    throw new InvalidMoveException();
                } else {
                    nextSquare.setPiece(new King(this.getPieceType(), nextFile, nextRank));
                    currentSquare.setPiece(null);
                }

            } else {
                nextSquare.setPiece(new King(this.getPieceType(), nextFile, nextRank));
                currentSquare.setPiece(null);
            }

        } else {
            throw new InvalidMoveException();
        }

        return board;
    }

    private boolean canMove(char nextFile, int nextRank, List<Square> board) {
        String nextPosition = Character.toString(nextFile) + nextRank;

        //Store all possible legal moves
        List<String> legalMoves = possibleMoves(board);

        if (legalMoves.contains(nextPosition)) {
            return true;
        } else {
            return false;
        }
    }

    private List<String> possibleMoves(List<Square> board) {

        char[] files = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};

        List<String> possibleMoves = new ArrayList<>();

        //Used to uniquely identify each square
        int locationValue = 1;

        //Map all possible locations on the board
        Map<String, Integer> allPossibleLocations = new HashMap<>();

        for (Character file : files) {
            for (int i = 1; i < 9; i++) {
                allPossibleLocations.put(Character.toString(file) + i, locationValue);
                locationValue++;
            }
        }

        //Adds all legal moves the king can make -- Takes into consideration whether it starts from black (rank 8) or white (rank 1) side
        for (Map.Entry entry : allPossibleLocations.entrySet()) {
            if (entry.getKey().equals(this.getCurrentPosition())) {

                int currentSquareValue = (int) entry.getValue();

                //[0,1] --> forward
                if (Integer.parseInt(entry.getKey().toString().substring(1)) != 8 && getLocationHelper(allPossibleLocations, currentSquareValue + 1) != null) {
                    possibleMoves.add(getLocationHelper(allPossibleLocations, currentSquareValue + 1));
                }

                //[1,1] --> forward-right
                if (Integer.parseInt(entry.getKey().toString().substring(1)) != 8 && getLocationHelper(allPossibleLocations, currentSquareValue + 9) != null) {
                    possibleMoves.add(getLocationHelper(allPossibleLocations, currentSquareValue + 9));
                }

                //[1,0] --> right
                if (getLocationHelper(allPossibleLocations, currentSquareValue + 8) != null) {
                    possibleMoves.add(getLocationHelper(allPossibleLocations, currentSquareValue + 8));
                }

                //[1,-1] --> backward-right
                if (Integer.parseInt(entry.getKey().toString().substring(1)) != 1 && getLocationHelper(allPossibleLocations, currentSquareValue + 7) != null) {
                    possibleMoves.add(getLocationHelper(allPossibleLocations, currentSquareValue + 7));
                }

                //[0,-1] --> backward
                if (Integer.parseInt(entry.getKey().toString().substring(1)) != 1 && getLocationHelper(allPossibleLocations, currentSquareValue - 1) != null) {
                    possibleMoves.add(getLocationHelper(allPossibleLocations, currentSquareValue - 1));
                }

                //[-1,1] --> forward-left
                if (Integer.parseInt(entry.getKey().toString().substring(1)) != 8 && getLocationHelper(allPossibleLocations, currentSquareValue - 7) != null) {
                    possibleMoves.add(getLocationHelper(allPossibleLocations, currentSquareValue - 7));
                }

                //[-1,0] --> left
                if (getLocationHelper(allPossibleLocations, currentSquareValue + 1) != null) {
                    possibleMoves.add(getLocationHelper(allPossibleLocations, currentSquareValue - 8));
                }

                //[-1,-1] --> backward-left
                if (Integer.parseInt(entry.getKey().toString().substring(1)) != 1 && getLocationHelper(allPossibleLocations, currentSquareValue - 9) != null) {
                    possibleMoves.add(getLocationHelper(allPossibleLocations, currentSquareValue - 9));
                }
            }
        }
        return possibleMoves;
    }

    //Helper method to return location name. E.g.: "A1"
    private String getLocationHelper(Map<String, Integer> possibleLocations, int squareValue) {
        return possibleLocations.entrySet().stream()
                .filter(entry -> entry.getValue() == squareValue)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }
}
