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
        Square nextSquare = chessBoard.getChessBoard().get(37);


        Piece king = tempSquare.getPiece();
        Piece pawn = nextSquare.getPiece();

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
    public void testKingIlegallMove() throws InvalidMoveException {
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
    public void testCanEatOppositeSetPiece() {

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
        assertTrue(nextSquare.getPiece().getCurrentPosition().equals("E6"));
    }

    @Test(expected = InvalidMoveException.class)
    public void testCannotEatSameSetPiece() {
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
        try {
            king.movePiece('E', 6, chessBoard.getChessBoard());
        } catch (InvalidMoveException e) {
            //
        }
        assertTrue(nextSquare.getPiece().getCurrentPosition().equals("E6"));

    }
}