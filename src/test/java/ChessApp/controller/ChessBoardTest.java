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
        newChess.createEmptyBoard();
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

    //Test empty squares
    @Test
    public void testCheckBoardStartsEmpty(){

        long squareCount = newChess.getChessBoard().stream()
                .filter(entry -> entry.getPiece()==null)
                .count();

        assertEquals(squareCount, 64);
    }
    @Test
    public void testCheckBoardSetsUpWhites(){
        newChess.setUpWhiteSetMethod();

        newChess.getChessBoard().stream()
                .forEach(square ->{
                    if(square.getPiece()!=null){
                        System.out.println(square.getPosition() +", " + square.getPiece().getPieceType());
                    }else{
                        System.out.println(square.getPosition() +", " + square.getPiece());
                    }
                        }
                );
//        newChess.getWhiteSet().stream()
//                .forEach(piece -> assertTrue(piece.getPieceType().getTypeCode()>1));
    }


//    //Testing white set
//    @Test
//    public void testCheckNumberOfWhitePawns(){
//
//        //Experimenting with streams
//        long pawnCount = newChess.getChessBoard().entrySet().stream()
//                .filter(entry -> entry.getValue()!=null) //Filter out null squares
//                .filter(filteredEntry ->filteredEntry.getValue().getPieceType().getTypeCode()==6) //Filter out non-white pawn pieces
//                .count();
//
//        assertEquals(pawnCount,8);
//    }
//
//    @Test
//    public void testCheckNumberOfWhiteRooks(){
//
//        long rookCount = newChess.getChessBoard().entrySet().stream()
//                .filter(entry -> entry.getValue()!=null)
//                .filter(filteredEntry ->filteredEntry.getValue().getPieceType().getTypeCode()==3)
//                .count();
//
//        assertEquals(rookCount,2);
//    }
//    @Test
//    public void testCheckNumberOfWhiteBishops(){
//
//        long bishopCount = newChess.getChessBoard().entrySet().stream()
//                .filter(entry -> entry.getValue()!=null)
//                .filter(filteredEntry ->filteredEntry.getValue().getPieceType().getTypeCode()==4) //Filter out non-white pawn pieces
//                .count();
//
//        assertEquals(bishopCount,2);
//    }
//
//    @Test
//    public void testCheckNumberOfWhiteKnights(){
//
//        long knightCount = newChess.getChessBoard().entrySet().stream()
//                .filter(entry -> entry.getValue()!=null)
//                .filter(filteredEntry ->filteredEntry.getValue().getPieceType().getTypeCode()==5) //Filter out non-white pawn pieces
//                .count();
//
//        assertEquals(knightCount,2);
//
//    }
//
//    @Test
//    public void testCheckSingleWhiteQueenExists(){
//        long queenCount = newChess.getChessBoard().entrySet().stream()
//                .filter(entry -> entry.getValue()!=null)
//                .filter(filteredEntry ->filteredEntry.getValue().getPieceType().getTypeCode()==2) //Filter out non-white pawn pieces
//                .count();
//
//        assertEquals(queenCount,1);
//    }
//
//    @Test
//    public void testCheckSingleWhiteKingExists(){
//        long kingCount = newChess.getChessBoard().entrySet().stream()
//                .filter(entry -> entry.getValue()!=null)
//                .filter(filteredEntry ->filteredEntry.getValue().getPieceType().getTypeCode()==1) //Filter out non-white pawn pieces
//                .count();
//
//        assertEquals(kingCount,1);
//    }
//
//    //Testing black set
//    @Test
//    public void testCheckNumberOfBlackPawns(){
//        long pawnCount = newChess.getChessBoard().entrySet().stream()
//                .filter(entry -> entry.getValue()!=null)
//                .filter(filteredEntry ->filteredEntry.getValue().getPieceType().getTypeCode()==-6) //Filter out non-white pawn pieces
//                .count();
//
//        assertEquals(pawnCount,8);
//    }
//
//    @Test
//    public void testCheckNumberOfBlackRooks(){
//        long rookCount = newChess.getChessBoard().entrySet().stream()
//                .filter(entry -> entry.getValue()!=null)
//                .filter(filteredEntry ->filteredEntry.getValue().getPieceType().getTypeCode()==-3) //Filter out non-white pawn pieces
//                .count();
//
//        assertEquals(rookCount,2);
//    }
//
//    @Test
//    public void testCheckNumberOfBlackBishops(){
//        long bishopCount = newChess.getChessBoard().entrySet().stream()
//                .filter(entry -> entry.getValue()!=null)
//                .filter(filteredEntry ->filteredEntry.getValue().getPieceType().getTypeCode()==-4) //Filter out non-white pawn pieces
//                .count();
//
//        assertEquals(bishopCount,2);
//    }
//
//    @Test
//    public void testCheckNumberOfBlackKnights(){
//        long knightCount = newChess.getChessBoard().entrySet().stream()
//                .filter(entry -> entry.getValue()!=null)
//                .filter(filteredEntry ->filteredEntry.getValue().getPieceType().getTypeCode()==-5) //Filter out non-white pawn pieces
//                .count();
//
//        assertEquals(knightCount,2);
//    }
//
//    @Test
//    public void testCheckSingleBlackQueenExists(){
//        long queenCount = newChess.getChessBoard().entrySet().stream()
//                .filter(entry -> entry.getValue()!=null)
//                .filter(filteredEntry ->filteredEntry.getValue().getPieceType().getTypeCode()==-2) //Filter out non-white pawn pieces
//                .count();
//
//        assertEquals(queenCount,1);
//    }
//
//    @Test
//    public void testCheckSingleBlackKingExists(){
//        long kingCount = newChess.getChessBoard().entrySet().stream()
//                .filter(entry -> entry.getValue()!=null)
//                .filter(filteredEntry ->filteredEntry.getValue().getPieceType().getTypeCode()==-1) //Filter out non-white pawn pieces
//                .count();
//
//        assertEquals(kingCount,1);
//    }
}