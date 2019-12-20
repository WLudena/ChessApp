package ChessApp.model;

import ChessApp.controller.ChessBoard;
import ChessApp.exceptions.InvalidMoveException;
import ChessApp.model.types.PieceType;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class PieceMovementTest {

    private ChessBoard chessBoard;

    @Before
    public void setUp() {
        chessBoard = new ChessBoard();
        chessBoard.createEmptyBoard();
    }

    @After

    public void tearDown() {
        chessBoard = null;
    }

    @Ignore
    @Test
    public void testKingMovement() throws InvalidMoveException {

        for (Square square : chessBoard.getChessBoard()) {
            if (square.getPiece() == null && square.getPosition().equals("E5")) {
                square.setPiece(new King(PieceType.WHITE_KING, square.getPosition().charAt(0), Integer.parseInt(square.getPosition().substring(1))));
                System.out.println(square.getPosition() + ", " + square.getPiece().getPieceType() + ", " + square.getPiece().getCurrentPosition());
            } else if (square.getPiece() == null && square.getPosition().equals("E6")) {
                square.setPiece(new King(PieceType.BLACK_PAWN, square.getPosition().charAt(0), Integer.parseInt(square.getPosition().substring(1))));
                System.out.println(square.getPosition() + ", " + square.getPiece().getPieceType() + ", " + square.getPiece().getCurrentPosition());
            } else {
                System.out.println(square.getPosition() + ", " + square.getPiece());
            }
        }

        Square tempSquare = chessBoard.getChessBoard().get(36);

        Piece king = tempSquare.getPiece();

        king.movePiece('E', 6, chessBoard.getChessBoard());
        System.out.println("");

        for (Square square : chessBoard.getChessBoard()) {
            if (square.getPiece() != null) {
                System.out.println(square.getPosition() + ", " + square.getPiece().getPieceType() + ", " + square.getPiece().getCurrentPosition());
            } else {
                System.out.println(square.getPosition() + ", " + square.getPiece());
            }
        }
    }

    @Ignore
    @Test
    public void testQueenMovement() throws InvalidMoveException {

        for (Square square : chessBoard.getChessBoard()) {
            if (square.getPiece() == null && square.getPosition().equals("E5")) {
                square.setPiece(new Queen(PieceType.BLACK_QUEEN, 'E', 5));
            }
            if (square.getPiece() == null && square.getPosition().equals("H8")) {
                square.setPiece(new Pawn(PieceType.BLACK_PAWN, 'H', 8));
            }
        }

        for (Square square : chessBoard.getChessBoard()) {
            if (square.getPiece() != null) {
                System.out.println(square.getPosition() + ", " + square.getPiece().getPieceType() + ", " + square.getPiece().getCurrentPosition());
            } else {
                System.out.println(square.getPosition() + ", " + square.getPiece());
            }
        }

        Square tempSquare = chessBoard.getChessBoard().get(36);

        Piece tempQueen = tempSquare.getPiece();

        tempQueen.movePiece('H', 8, chessBoard.getChessBoard());


        for (Square square : chessBoard.getChessBoard()) {
            if (square.getPiece() != null) {
                System.out.println(square.getPosition() + ", " + square.getPiece().getPieceType() + ", " + square.getPiece().getCurrentPosition());
            } else {
                System.out.println(square.getPosition() + ", " + square.getPiece());
            }
        }
    }

    @Ignore
    @Test
    public void testing(){

        Piece queen = new Queen(PieceType.BLACK_QUEEN, 'E', 5);

        for (Square square : chessBoard.getChessBoard()) {
            if (square.getPiece() == null && square.getPosition().equals("E5")) {
                square.setPiece(queen);
            }
        }
        try {
            queen.movePiece('A', 1, chessBoard.getChessBoard());
            queen = chessBoard.getChessBoard().get(0).getPiece();
            queen.movePiece('H',1,chessBoard.getChessBoard());
        } catch (InvalidMoveException e) {
            e.printStackTrace();
        }
        for (Square square : chessBoard.getChessBoard()) {
            if (square.getPiece() != null) {
                System.out.println(square.getPosition() + ", " + square.getPiece().getPieceType() + ", " + square.getPiece().getCurrentPosition());
            } else {
                System.out.println(square.getPosition() + ", " + square.getPiece());
            }
        }
    }


    //Test King piece
    @Test
    public void testKingLegalMove() {

        Piece king = new King(PieceType.WHITE_KING, 'E', 5);

        for (Square square : chessBoard.getChessBoard()) {
            if (square.getPiece() == null && square.getPosition().equals("E5")) {
                square.setPiece(king);
            }
        }
        try {
            king.movePiece('E', 6, chessBoard.getChessBoard());
        } catch (InvalidMoveException e) {
            //
        }
        assertTrue(chessBoard.getChessBoard().get(37).getPiece().getPieceType().equals(PieceType.WHITE_KING));
    }

    @Test(expected = InvalidMoveException.class)
    public void testKingIlegalMove() throws InvalidMoveException {
        Piece king = new King(PieceType.WHITE_KING, 'E', 5);

        for (Square square : chessBoard.getChessBoard()) {
            if (square.getPiece() == null && square.getPosition().equals("E5")) {
                square.setPiece(king);
            }
        }

        king.movePiece('E', 7, chessBoard.getChessBoard());
        assertTrue(chessBoard.getChessBoard().get(37).getPiece().getPieceType().equals(PieceType.WHITE_KING));
    }

    @Test
    public void testKingCanEatOppositeSetPiece() {

        for (Square square : chessBoard.getChessBoard()) {
            if (square.getPiece() == null && square.getPosition().equals("E5")) {
                square.setPiece(new King(PieceType.WHITE_KING, square.getPosition().charAt(0), Integer.parseInt(square.getPosition().substring(1))));
            } else if (square.getPiece() == null && square.getPosition().equals("E6")) {
                square.setPiece(new King(PieceType.BLACK_PAWN, square.getPosition().charAt(0), Integer.parseInt(square.getPosition().substring(1))));
            }
        }

        Square currentSquare = chessBoard.getChessBoard().get(36);
        Square nextSquare = chessBoard.getChessBoard().get(37);

        Piece king = currentSquare.getPiece();

        try {
            king.movePiece('E', 6, chessBoard.getChessBoard());
        } catch (InvalidMoveException e) {
            //
        }

        assertTrue(nextSquare.getPiece().getPieceType().equals(PieceType.WHITE_KING));
    }

    @Test(expected = InvalidMoveException.class)
    public void testCannotEatSameSetPiece() throws InvalidMoveException {
        for (Square square : chessBoard.getChessBoard()) {
            if (square.getPiece() == null && square.getPosition().equals("E5")) {
                square.setPiece(new King(PieceType.WHITE_KING, square.getPosition().charAt(0), Integer.parseInt(square.getPosition().substring(1))));
            } else if (square.getPiece() == null && square.getPosition().equals("E6")) {
                square.setPiece(new King(PieceType.WHITE_PAWN, square.getPosition().charAt(0), Integer.parseInt(square.getPosition().substring(1))));
            }
        }

        Square currentSquare = chessBoard.getChessBoard().get(36);
        Square nextSquare = chessBoard.getChessBoard().get(37);

        Piece king = currentSquare.getPiece();

        king.movePiece('E', 6, chessBoard.getChessBoard());

    }

    //Test Queen piece
    @Test
    public void testQueenLegalMove() {

        Piece queen = new Queen(PieceType.BLACK_QUEEN, 'E', 5);

        for (Square square : chessBoard.getChessBoard()) {
            if (square.getPiece() == null && square.getPosition().equals("E5")) {
                square.setPiece(queen);
            }
        }
        try {
            queen.movePiece('A', 1, chessBoard.getChessBoard());
        } catch (InvalidMoveException e) {
            //
        }

        assertTrue(chessBoard.getChessBoard().get(0).getPiece().getPieceType().equals(PieceType.BLACK_QUEEN));
    }

    @Test(expected = InvalidMoveException.class)
    public void testQueenIlegalMove() throws InvalidMoveException {
        Piece queen = new Queen(PieceType.BLACK_QUEEN, 'E', 5);

        for (Square square : chessBoard.getChessBoard()) {
            if (square.getPiece() == null && square.getPosition().equals("E5")) {
                square.setPiece(queen);
            }
        }

        queen.movePiece('B', 1, chessBoard.getChessBoard());
    }

    @Test
    public void testQueenCanEatOppositeSetPiece() {
        Piece queen = new Queen(PieceType.BLACK_QUEEN, 'E', 5);

        for (Square square : chessBoard.getChessBoard()) {
            if (square.getPosition().equals("E5")) {
                square.setPiece(queen);
            }
            if (square.getPosition().equals("E8")) {
                square.setPiece(new Pawn(PieceType.WHITE_PAWN, square.getPosition().charAt(0), Integer.parseInt(square.getPosition().substring(1))));
            }
        }
        try {
            queen.movePiece('E', 8, chessBoard.getChessBoard());
        } catch (InvalidMoveException e) {
            //
        }

        Square square = chessBoard.getChessBoard().get(39); //"E8" has index 39 in chess board list

        assertTrue(square.getPiece().getPieceType().equals(PieceType.BLACK_QUEEN));
    }

    @Test(expected = InvalidMoveException.class)
    public void testQueenCannotEatSameSetPiece() throws InvalidMoveException {
        Piece queen = new Queen(PieceType.BLACK_QUEEN, 'E', 5);

        for (Square square : chessBoard.getChessBoard()) {
            if (square.getPosition().equals("E5")) {
                square.setPiece(queen);
            }
            if (square.getPosition().equals("E8")) {
                square.setPiece(new Pawn(PieceType.BLACK_PAWN, square.getPosition().charAt(0), Integer.parseInt(square.getPosition().substring(1))));
            }
        }
        queen.movePiece('E', 8, chessBoard.getChessBoard());
    }

    //Test Rook piece
    @Test
    public void testRookLegalMove() {

        Piece rook = new Rook(PieceType.BLACK_ROOK, 'A', 5);

        for (Square square : chessBoard.getChessBoard()) {
            if (square.getPiece() == null && square.getPosition().equals("A5")) {
                square.setPiece(rook);
            }
        }
        try {
            rook.movePiece('A', 1, chessBoard.getChessBoard());
        } catch (InvalidMoveException e) {
            //
        }

        assertTrue(chessBoard.getChessBoard().get(0).getPiece().getPieceType().equals(PieceType.BLACK_ROOK));
    }

    @Test(expected = InvalidMoveException.class)
    public void testRookIlegalMove() throws InvalidMoveException {
        Piece rook = new Rook(PieceType.BLACK_ROOK, 'E', 5);

        for (Square square : chessBoard.getChessBoard()) {
            if (square.getPiece() == null && square.getPosition().equals("E5")) {
                square.setPiece(rook);
            }
        }

        rook.movePiece('F', 6, chessBoard.getChessBoard());
    }

    @Test
    public void testRookCanEatOppositeSetPiece() {
        Piece rook = new Rook(PieceType.BLACK_ROOK, 'E', 5);

        for (Square square : chessBoard.getChessBoard()) {
            if (square.getPosition().equals("E5")) {
                square.setPiece(rook);
            }
            if (square.getPosition().equals("E8")) {
                square.setPiece(new Pawn(PieceType.WHITE_PAWN, square.getPosition().charAt(0), Integer.parseInt(square.getPosition().substring(1))));
            }
        }
        try {
            rook.movePiece('E', 8, chessBoard.getChessBoard());
        } catch (InvalidMoveException e) {
            //
        }

        Square square = chessBoard.getChessBoard().get(39); //"E8" has index 39 in chess board list

        assertTrue(square.getPiece().getPieceType().equals(PieceType.BLACK_ROOK));
    }

    @Test(expected = InvalidMoveException.class)
    public void testRookCannotEatSameSetPiece() throws InvalidMoveException {
        Piece rook = new Rook(PieceType.BLACK_ROOK, 'E', 5);

        for (Square square : chessBoard.getChessBoard()) {
            if (square.getPosition().equals("E5")) {
                square.setPiece(rook);
            }
            if (square.getPosition().equals("E8")) {
                square.setPiece(new Pawn(PieceType.BLACK_PAWN, square.getPosition().charAt(0), Integer.parseInt(square.getPosition().substring(1))));
            }
        }
        rook.movePiece('E', 8, chessBoard.getChessBoard());
    }


}