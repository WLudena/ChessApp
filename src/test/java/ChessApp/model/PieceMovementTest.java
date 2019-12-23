package ChessApp.model;

import ChessApp.controller.ChessBoard;
import ChessApp.exceptions.InvalidMoveException;
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
    public void testing() {

        Piece queen = new Queen(PieceType.BLACK_QUEEN, 'E', 5);

        for (Square square : chessBoard.getChessBoard()) {
            if (square.getPiece() == null && square.getPosition().equals("E5")) {
                square.setPiece(queen);
            }
        }
        try {
            queen.movePiece('A', 1, chessBoard.getChessBoard());
            queen = chessBoard.getChessBoard().get(0).getPiece();
            queen.movePiece('H', 1, chessBoard.getChessBoard());
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

    @Ignore
    @Test
    public void testingHorsey() {
        Knight knight = new Knight(PieceType.BLACK_KNIGHT, 'H', 4);

        for (String s : knight.testingMoves()) {
            System.out.println(s);
        }
    }

    @Ignore
    @Test
    public void testingPawn(){

        Pawn pawn = new Pawn(PieceType.WHITE_PAWN,'B',2);
        Pawn opPawn = new Pawn(PieceType.BLACK_PAWN,'A',3);

        chessBoard.getChessBoard().get(9).setPiece(pawn);
//        chessBoard.getChessBoard().get(11).setPiece(opPawn);
        chessBoard.getChessBoard().get(2).setPiece(opPawn);
        chessBoard.getChessBoard().get(18).setPiece(opPawn);

        pawn.testing(chessBoard.getChessBoard());

        for(String s : pawn.getAvailableMoves()){
            System.out.println(s);
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
    public void testKingIllegalMove() throws InvalidMoveException {
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
    public void testQueenIllegalMove() throws InvalidMoveException {
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
    public void testRookIllegalMove() throws InvalidMoveException {
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

        Square square = chessBoard.getChessBoard().get(39);

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

    //Test Bishop piece
    @Test
    public void testBishopLegalMove() {

        Piece bishop = new Bishop(PieceType.WHITE_BISHOP, 'E', 5);

        for (Square square : chessBoard.getChessBoard()) {
            if (square.getPosition().equals("E5")) {
                square.setPiece(bishop);
            }
        }
        try {
            bishop.movePiece('B', 2, chessBoard.getChessBoard());
        } catch (InvalidMoveException e) {
            //
        }

        assertTrue(chessBoard.getChessBoard().get(9).getPiece().getPieceType().equals(PieceType.WHITE_BISHOP));
    }

    @Test(expected = InvalidMoveException.class)
    public void testBishopIlegalMove() throws InvalidMoveException {
        Piece bishop = new Bishop(PieceType.WHITE_BISHOP, 'E', 5);

        for (Square square : chessBoard.getChessBoard()) {
            if (square.getPosition().equals("E5")) {
                square.setPiece(bishop);
            }
        }

        bishop.movePiece('F', 5, chessBoard.getChessBoard());
    }

    @Test
    public void testBishopCanEatOppositeSetPiece() {
        Piece bishop = new Bishop(PieceType.WHITE_BISHOP, 'E', 5);

        for (Square square : chessBoard.getChessBoard()) {
            if (square.getPosition().equals("E5")) {
                square.setPiece(bishop);
            }
            if (square.getPosition().equals("F6")) {
                square.setPiece(new Pawn(PieceType.BLACK_PAWN, square.getPosition().charAt(0), Integer.parseInt(square.getPosition().substring(1))));
            }
        }
        try {
            bishop.movePiece('F', 6, chessBoard.getChessBoard());
        } catch (InvalidMoveException e) {
            //
        }

        Square square = chessBoard.getChessBoard().get(45);

        assertTrue(square.getPiece().getPieceType().equals(PieceType.WHITE_BISHOP));
    }

    @Test(expected = InvalidMoveException.class)
    public void testBishopCannotEatSameSetPiece() throws InvalidMoveException {
        Piece bishop = new Bishop(PieceType.WHITE_BISHOP, 'E', 5);

        for (Square square : chessBoard.getChessBoard()) {
            if (square.getPosition().equals("E5")) {
                square.setPiece(bishop);
            }
            if (square.getPosition().equals("C7")) {
                square.setPiece(new Pawn(PieceType.WHITE_PAWN, square.getPosition().charAt(0), Integer.parseInt(square.getPosition().substring(1))));
            }
        }
        bishop.movePiece('C', 87, chessBoard.getChessBoard());
    }

    //Test Knight piece
    @Test
    public void testKnightLegalMove() {

        Piece knight = new Knight(PieceType.BLACK_KNIGHT, 'B', 1);

        for (Square square : chessBoard.getChessBoard()) {
            if (square.getPiece() == null && square.getPosition().equals("B1")) {
                square.setPiece(knight);
            }
        }
        try {
            knight.movePiece('A', 3, chessBoard.getChessBoard());
        } catch (InvalidMoveException e) {
            //
        }

        assertTrue(chessBoard.getChessBoard().get(2).getPiece().getPieceType().equals(PieceType.BLACK_KNIGHT));
    }

    @Test(expected = InvalidMoveException.class)
    public void testKnightIllegalMove() throws InvalidMoveException {
        Piece knight = new Knight(PieceType.BLACK_KNIGHT, 'B', 1);

        for (Square square : chessBoard.getChessBoard()) {
            if (square.getPiece() == null && square.getPosition().equals("E5")) {
                square.setPiece(knight);
            }
        }

        knight.movePiece('B', 2, chessBoard.getChessBoard());
    }

    @Test
    public void testKnightCanEatOppositeSetPiece() {
        Piece knight = new Knight(PieceType.BLACK_KNIGHT, 'B', 1);

        for (Square square : chessBoard.getChessBoard()) {
            if (square.getPosition().equals("B1")) {
                square.setPiece(knight);
            }
            if (square.getPosition().equals("A3")) {
                square.setPiece(new Pawn(PieceType.WHITE_PAWN, square.getPosition().charAt(0), Integer.parseInt(square.getPosition().substring(1))));
            }
        }
        try {
            knight.movePiece('A', 3, chessBoard.getChessBoard());
        } catch (InvalidMoveException e) {
            //
        }

        Square square = chessBoard.getChessBoard().get(2);

        assertTrue(square.getPiece().getPieceType().equals(PieceType.BLACK_KNIGHT));
    }

    @Test(expected = InvalidMoveException.class)
    public void testKnightCannotEatSameSetPiece() throws InvalidMoveException {
        Piece knight = new Knight(PieceType.BLACK_KNIGHT, 'B', 1);

        for (Square square : chessBoard.getChessBoard()) {
            if (square.getPosition().equals("B1")) {
                square.setPiece(knight);
            }
            if (square.getPosition().equals("A3")) {
                square.setPiece(new Pawn(PieceType.BLACK_PAWN, square.getPosition().charAt(0), Integer.parseInt(square.getPosition().substring(1))));
            }
        }
        knight.movePiece('A', 3, chessBoard.getChessBoard());
    }

    //Test Pawn piece
    //Test White Pawn
    @Test
    public void testWPawnFirstTwoSpacesLegalMove() {
        Piece pawn = new Pawn(PieceType.WHITE_PAWN, 'D', 2);

        for (Square square : chessBoard.getChessBoard()) {
            if (square.getPiece() == null && square.getPosition().equals("D2")) {
                square.setPiece(pawn);
            }
        }
        try {
            pawn.movePiece('D', 4, chessBoard.getChessBoard());
        } catch (InvalidMoveException e) {
            //
        }

        assertTrue(chessBoard.getChessBoard().get(27).getPiece().getPieceType().equals(PieceType.WHITE_PAWN));

    }

    @Test(expected = InvalidMoveException.class)
    public void testWPawnCannotMoveTwoSpacesAfterFirstMoveDone() throws InvalidMoveException {
        Piece pawn = new Pawn(PieceType.WHITE_PAWN, 'D', 2, true);

        for (Square square : chessBoard.getChessBoard()) {
            if (square.getPiece() == null && square.getPosition().equals("D2")) {
                square.setPiece(pawn);
            }
        }
        pawn.movePiece('D', 4, chessBoard.getChessBoard());

    }

    @Test(expected = InvalidMoveException.class)
    public void testWPawnIllegalMove() throws InvalidMoveException{
        Piece pawn = new Pawn(PieceType.WHITE_PAWN, 'D', 2);

        for (Square square : chessBoard.getChessBoard()) {
            if (square.getPiece() == null && square.getPosition().equals("D2")) {
                square.setPiece(pawn);
            }
        }
            pawn.movePiece('D', 1, chessBoard.getChessBoard());
    }

    @Test
    public void testWPawnCanEatOppositeSetPiece() {
        Piece pawn = new Pawn(PieceType.WHITE_PAWN, 'D', 2);

        for (Square square : chessBoard.getChessBoard()) {
            if (square.getPiece() == null && square.getPosition().equals("D2")) {
                square.setPiece(pawn);
            }
            if (square.getPosition().equals("E3")) {
                square.setPiece(new Pawn(PieceType.BLACK_PAWN, 'E', 3));
            }
        }
        try {
            pawn.movePiece('E', 3, chessBoard.getChessBoard());
        } catch (InvalidMoveException e) {
            //
        }

        Square square = chessBoard.getChessBoard().stream()
                .filter(square1 -> square1.getPosition().equals("E3"))
                .findFirst()
                .orElse(null);

        assertTrue(square.getPiece().getPieceType().equals(PieceType.WHITE_PAWN));
    }

    @Test(expected = InvalidMoveException.class)
    public void testWPawnCannotEatSameSetPiece() throws InvalidMoveException {
        Piece pawn = new Pawn(PieceType.WHITE_PAWN, 'D', 2);

        for (Square square : chessBoard.getChessBoard()) {
            if (square.getPiece() == null && square.getPosition().equals("D2")) {
                square.setPiece(pawn);
            }
            if (square.getPosition().equals("E3")) {
                square.setPiece(new Pawn(PieceType.WHITE_BISHOP, 'E', 3));
            }
        }
        pawn.movePiece('E', 3, chessBoard.getChessBoard());
    }

    //Test Black Pawn
    @Test
    public void testBPawnFirstTwoSpacesLegalMove() {
        Piece pawn = new Pawn(PieceType.BLACK_PAWN, 'D', 7);

        for (Square square : chessBoard.getChessBoard()) {
            if (square.getPiece() == null && square.getPosition().equals("D7")) {
                square.setPiece(pawn);
            }
        }
        try {
            pawn.movePiece('D', 5, chessBoard.getChessBoard());
        } catch (InvalidMoveException e) {
            //
        }

        Square square = chessBoard.getChessBoard().stream()
                .filter(square1 -> square1.getPosition().equals("D5"))
                .findFirst()
                .orElse(null);

        assertTrue(square.getPiece().getPieceType().equals(PieceType.BLACK_PAWN));

    }

    @Test(expected = InvalidMoveException.class)
    public void testBPawnCannotMoveTwoSpacesAfterFirstMoveDone() throws InvalidMoveException {
        Piece pawn = new Pawn(PieceType.BLACK_PAWN, 'D', 6, true);

        for (Square square : chessBoard.getChessBoard()) {
            if (square.getPiece() == null && square.getPosition().equals("D6")) {
                square.setPiece(pawn);
            }
        }
        pawn.movePiece('D', 4, chessBoard.getChessBoard());
    }

    @Test(expected = InvalidMoveException.class)
    public void testBPawnIllegalMove() throws InvalidMoveException{
        Piece pawn = new Pawn(PieceType.BLACK_PAWN, 'D', 7);

        for (Square square : chessBoard.getChessBoard()) {
            if (square.getPiece() == null && square.getPosition().equals("D7")) {
                square.setPiece(pawn);
            }
        }
        pawn.movePiece('D', 8, chessBoard.getChessBoard());
    }

    @Test
    public void testBPawnCanEatOppositeSetPiece() {
        Piece pawn = new Pawn(PieceType.BLACK_PAWN, 'D', 7);

        for (Square square : chessBoard.getChessBoard()) {
            if (square.getPiece() == null && square.getPosition().equals("D7")) {
                square.setPiece(pawn);
            }
            if (square.getPosition().equals("C6")) {
                square.setPiece(new Pawn(PieceType.WHITE_PAWN, 'C', 6));
            }
        }
        try {
            pawn.movePiece('C', 6, chessBoard.getChessBoard());
        } catch (InvalidMoveException e) {
            //
        }

        Square square = chessBoard.getChessBoard().stream()
                .filter(square1 -> square1.getPosition().equals("C6"))
                .findFirst()
                .orElse(null);

        assertTrue(square.getPiece().getPieceType().equals(PieceType.BLACK_PAWN));
    }

    @Test(expected = InvalidMoveException.class)
    public void testBPawnCannotEatSameSetPiece() throws InvalidMoveException {
        Piece pawn = new Pawn(PieceType.BLACK_PAWN, 'D', 7);

        for (Square square : chessBoard.getChessBoard()) {
            if (square.getPiece() == null && square.getPosition().equals("D7")) {
                square.setPiece(pawn);
            }
            if (square.getPosition().equals("E6")) {
                square.setPiece(new Pawn(PieceType.BLACK_PAWN, 'E', 6));
            }
        }
        pawn.movePiece('E', 6, chessBoard.getChessBoard());
    }
}