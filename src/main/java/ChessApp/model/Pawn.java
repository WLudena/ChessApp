package ChessApp.model;

import ChessApp.exceptions.InvalidMoveException;
import ChessApp.model.types.PieceType;

import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pawn extends Piece {

    private boolean hasMoved = false; // Since pawn has the option to move twice on its first move, this will help keep track of it

    public Pawn() {
    }

    public Pawn(PieceType pieceType, char currentFile, int currentRank, boolean hasMoved) {
        super(pieceType, currentFile, currentRank);
        this.hasMoved = hasMoved;
    }

    public Pawn(PieceType pieceType, char currentFile, int currentRank) {
        super(pieceType, currentFile, currentRank);
    }


    public boolean getHasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
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

            if (!hasMoved) {
                nextSquare.setPiece(new Pawn(getPieceType(), nextFile, nextRank, true));
                currentSquare.setPiece(null);
            } else {
                nextSquare.setPiece(new Pawn(getPieceType(), nextFile, nextRank, getHasMoved()));
                currentSquare.setPiece(null);
            }
        } else {
            throw new InvalidMoveException();
        }
    }

    private List<String> possibleMoves(List<Square> board) {

        List<Character> fileList = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H');

        List<String> possibleMoves = new ArrayList<>();

        //Used to track index of file in fileList<>
        int fileIndex = fileList.indexOf(getCurrentFile());

        //Get valid moves for white pawns
        if (getPieceType().getTypeCode() > 0) {
            //If it has not yet moves for the first time, it can move 2 spaces forward
            if (!hasMoved) {
                for (int i = 1; i < 3; i++) {
                    //If it hasn't yet moved but there is a piece in front, break out and do not any further spaces
                    if (getCurrentRank() + i < 9 && !squareIsEmpty(getCurrentFile() + String.valueOf(getCurrentRank() + i), board)) {
                        break;
                    } else {
                        possibleMoves.add(getCurrentFile() + String.valueOf(getCurrentRank() + i));
                    }
                }
            }

            //Check right diagonal square: if contains opposite type piece, adds it to the list
            if (fileIndex + 1 < fileList.size() && getCurrentRank() + 1 < 9) {
                Square rightDiagonalSquare = board.stream()
                        .filter(square -> square.getPosition().equals(fileList.get(fileIndex + 1) + String.valueOf(getCurrentRank() + 1)))
                        .findFirst()
                        .orElse(null);

                if (rightDiagonalSquare.getPiece() != null && (rightDiagonalSquare.getPiece().getPieceType().getTypeCode() ^ getPieceType().getTypeCode()) < 0) { //Checks if moving piece and opposite piece' type codes have different signs (whites: 1 ~ 6; blacks: -1 ~ -6) and returns true if so
                    possibleMoves.add(rightDiagonalSquare.getPosition());
                }
            }

            //Check left diagonal square
            if (fileIndex - 1 > -1 && getCurrentRank() + 1 < 9) {
                Square leftDiagonalSquare = board.stream()
                        .filter(square -> square.getPosition().equals(fileList.get(fileIndex - 1) + String.valueOf(getCurrentRank() + 1)))
                        .findFirst()
                        .orElse(null);

                if (leftDiagonalSquare.getPiece() != null && (leftDiagonalSquare.getPiece().getPieceType().getTypeCode() ^ getPieceType().getTypeCode()) < 0) { //Checks if moving piece and opposite piece' type codes have different signs (whites: 1 ~ 6; blacks: -1 ~ -6) and returns true if so
                    possibleMoves.add(leftDiagonalSquare.getPosition());
                }
            }
        }

        //Get valid moves for black pawns (Made two different if statements to make difference clear)
        if (getPieceType().getTypeCode() < 0) {
            //If it has not yet moves for the first time, it can move 2 spaces forward
            if (!hasMoved) {
                for (int i = - 2; i < 0; i++) {
                    if (getCurrentRank() + i > 0 && !squareIsEmpty(getCurrentFile() + String.valueOf(getCurrentRank() + i), board)) {
                        break;
                    } else {
                        possibleMoves.add(getCurrentFile() + String.valueOf(getCurrentRank() + i));
                    }
                }
            }

            //Normal movement forward (checks if next front square is empty and only adds it to the list if so)
            if (getCurrentRank() - 1 > 0 && squareIsEmpty(getCurrentFile() + String.valueOf(getCurrentRank() - 1), board)) {
                possibleMoves.add(getCurrentFile() + String.valueOf(getCurrentRank() - 1));
            }

            //Check right diagonal square: if contains opposite type piece, adds it to the list
            if (fileIndex + 1 < fileList.size() && getCurrentRank() - 1 > 0) {
                Square rightDiagonalSquare = board.stream()
                        .filter(square -> square.getPosition().equals(fileList.get(fileIndex + 1) + String.valueOf(getCurrentRank() - 1)))
                        .findFirst()
                        .orElse(null);

                if (rightDiagonalSquare.getPiece() != null && (rightDiagonalSquare.getPiece().getPieceType().getTypeCode() ^ getPieceType().getTypeCode()) < 0) { //Checks if moving piece and opposite piece' type codes have different signs (whites: 1 ~ 6; blacks: -1 ~ -6) and returns true if so
                    possibleMoves.add(rightDiagonalSquare.getPosition());
                }
            }

            //Check left diagonal square
            if (fileIndex - 1 > -1 && getCurrentRank() - 1 > 0) {
                Square leftDiagonalSquare = board.stream()
                        .filter(square -> square.getPosition().equals(fileList.get(fileIndex - 1) + String.valueOf(getCurrentRank() - 1)))
                        .findFirst()
                        .orElse(null);

                if (leftDiagonalSquare.getPiece() != null && (leftDiagonalSquare.getPiece().getPieceType().getTypeCode() ^ getPieceType().getTypeCode()) < 0) { //Checks if moving piece and opposite piece' type codes have different signs (whites: 1 ~ 6; blacks: -1 ~ -6) and returns true if so
                    possibleMoves.add(leftDiagonalSquare.getPosition());
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

    public void testing(List<Square> board) {
        setAvailableMoves(possibleMoves(board));
    }

}
