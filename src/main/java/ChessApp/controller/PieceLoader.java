package ChessApp.controller;

import ChessApp.model.Piece;
import ChessApp.model.Square;

import java.util.List;

public class PieceLoader {

    private String name;
    private static final String SRC = "src/main/java/";

    {
        String classPath = Piece.class.getName();
        name = classPath.substring(0, classPath.lastIndexOf('.'));
    }

    public String getPiecesLocation(){
        String classPathStr = System.getProperty("user.dir");
        return (classPathStr + SRC + name.replace('.','/'));
    }

//    public Piece getPiece(String pieceType, Piece piece)throws PieceLoaderException {
//
//        try{
//            String pieceName = name + "." + pieceType.substring(0, pieceType.lastIndexOf('.'));
//            Class selectedPiece = Class.forName(pieceName);
//            return (Piece) selectedPiece.getDeclaredConstructor().newInstance();
//        }catch(ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e){
//            throw new PieceLoaderException();
//        }
//
//    }

    public Piece getPiece(String piece, int playerId, List<Square> board){

        return null;
    }

}
