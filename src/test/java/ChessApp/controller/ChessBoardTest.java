package ChessApp.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ChessBoardTest {

    private ChessBoard newChess;

    @Before
    public void setUp(){
        newChess = new ChessBoard();
        newChess.setUpBoard();
    }

    @After
    public void tearDown(){
        newChess = null;
    }

    @Test
    public void testWhiteSetExists(){
        assertNotNull(newChess.getWhiteSet());
    }

    @Test
    public void testBlackSetExists(){
        assertNotNull(newChess.getBlackSet());
    }

    @Test
    public void testBoardIsCreated(){
        assertNotNull(newChess.getChessBoard());
    }

    //Testing white set
    @Test
    public void testCheckNumberOfWhitePawns(){

        //Experimenting with streams
        long pawnCount = newChess.getChessBoard().stream()
                .filter(square -> square.getPiece()!=null)
                .filter(filteredEntry ->filteredEntry.getPiece().getPieceType().getTypeCode()==6)
                .count();

        assertEquals(pawnCount,8);
    }

    @Test
    public void testCheckNumberOfWhiteRooks(){

        long rookCount = newChess.getChessBoard().stream()
                .filter(square -> square.getPiece()!=null)
                .filter(square ->square.getPiece().getPieceType().getTypeCode()==3)
                .count();

        assertEquals(rookCount,2);
    }
    @Test
    public void testCheckNumberOfWhiteBishops(){

        long bishopCount = newChess.getChessBoard().stream()
                .filter(square -> square.getPiece()!=null)
                .filter(square ->square.getPiece().getPieceType().getTypeCode()==4)
                .count();

        assertEquals(bishopCount,2);
    }

    @Test
    public void testCheckNumberOfWhiteKnights(){

        long knightCount = newChess.getChessBoard().stream()
                .filter(square -> square.getPiece()!=null)
                .filter(filteredEntry ->filteredEntry.getPiece().getPieceType().getTypeCode()==5)
                .count();

        assertEquals(knightCount,2);

    }

    @Test
    public void testCheckSingleWhiteQueenExists(){
        long queenCount = newChess.getChessBoard().stream()
                .filter(square -> square.getPiece()!=null)
                .filter(square ->square.getPiece().getPieceType().getTypeCode()==2)
                .count();

        assertEquals(queenCount,1);
    }

    @Test
    public void testCheckSingleWhiteKingExists(){
        long kingCount = newChess.getChessBoard().stream()
                .filter(square -> square.getPiece()!=null)
                .filter(square ->square.getPiece().getPieceType().getTypeCode()==1)
                .count();

        assertEquals(kingCount,1);
    }

    //Testing black set
    @Test
    public void testCheckNumberOfBlackPawns(){
        long pawnCount = newChess.getChessBoard().stream()
                .filter(square -> square.getPiece()!=null)
                .filter(square ->square.getPiece().getPieceType().getTypeCode()==-6)
                .count();

        assertEquals(pawnCount,8);
    }

    @Test
    public void testCheckNumberOfBlackRooks(){
        long rookCount = newChess.getChessBoard().stream()
                .filter(square -> square.getPiece()!=null)
                .filter(square ->square.getPiece().getPieceType().getTypeCode()==-3)
                .count();

        assertEquals(rookCount,2);
    }

    @Test
    public void testCheckNumberOfBlackBishops(){
        long bishopCount = newChess.getChessBoard().stream()
                .filter(square -> square.getPiece()!=null)
                .filter(square ->square.getPiece().getPieceType().getTypeCode()==-4)
                .count();

        assertEquals(bishopCount,2);
    }

    @Test
    public void testCheckNumberOfBlackKnights(){
        long knightCount = newChess.getChessBoard().stream()
                .filter(square -> square.getPiece()!=null)
                .filter(square ->square.getPiece().getPieceType().getTypeCode()==-5)
                .count();

        assertEquals(knightCount,2);
    }

    @Test
    public void testCheckSingleBlackQueenExists(){
        long queenCount = newChess.getChessBoard().stream()
                .filter(square -> square.getPiece()!=null)
                .filter(square ->square.getPiece().getPieceType().getTypeCode()==-2)
                .count();

        assertEquals(queenCount,1);
    }

    @Test
    public void testCheckSingleBlackKingExists(){
        long kingCount = newChess.getChessBoard().stream()
                .filter(square -> square.getPiece()!=null)
                .filter(square ->square.getPiece().getPieceType().getTypeCode()==-1)
                .count();

        assertEquals(kingCount,1);
    }

    @Test
    public void testSeeBoard(){
        newChess.getChessBoard().stream()
                .forEach(square -> {
                    if(square.getPiece()!=null){
                        System.out.println(square.getPosition()+ ", " + square.getPiece());
                    }else{
                        System.out.println(square.getPosition()+", " + square.getPiece());
                    }

                });
    }
}