package ChessApp.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class PieceTest {

    private Piece kingPiece;

    @Before
    public void setUp(){
        kingPiece = new King();
    }

    @After
    public void tearDown(){
        kingPiece = null;
    }

    @Test
    public void testCanCreateWhitePieces(){
        List<PieceType> whitePieceTypes = new ArrayList<>();

        for(PieceType type : PieceType.values()){
            if(type.getTypeCode() > 0 ){
                whitePieceTypes.add(type);
            }
        }
//      Uncomment to view all white piece types
//        for(PieceType pieceType : whitePieceTypes){
//            System.out.println(pieceType);
//        }
//        assertNotNull(whitePieceTypes);
    }

    @Test
    public void testCanCreateBlackPieces(){
        List<PieceType> blackPieceTypes = new ArrayList<>();

        for(PieceType type : PieceType.values()){
            if(type.getTypeCode() < 0 ){
                blackPieceTypes.add(type);
            }
        }

//      Uncomment to view all black piece types
//        for(PieceType pieceType : blackPieceTypes){
//            System.out.println(pieceType);
//        }

        assertNotNull(blackPieceTypes);
    }

    @Test
    public void testCanAssignPositionIndependently(){
        kingPiece.setCurrentFile('a');
        kingPiece.setCurrentRank(1);
        assertEquals(kingPiece.getCurrentFile(),'A');
        assertEquals(kingPiece.getCurrentRank(),1);
    }

    @Test
    public void testCanAssignPositionAll(){
        kingPiece.setCurrentPosition('a',1);
        assertEquals(kingPiece.getCurrentPosition(),"A1");
    }

    @Test
    public void testSetPieceType(){
        kingPiece.setPieceType(PieceType.WHITE_KING);
        assertEquals(kingPiece.getPieceType(),PieceType.WHITE_KING);
    }
}