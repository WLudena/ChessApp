package ChessApp.controller;

import ChessApp.model.*;
import ChessApp.model.PieceType;

import java.util.ArrayList;
import java.util.List;

public class ChessBoard {

    private List<Piece> whiteSet = new ArrayList<>();
    private List<Piece> blackSet = new ArrayList<>();
    private final char[] allFiles = {'A','B','C','D','E','F','G','H'}; //Used when creating different pawns

    private List<Square> chessBoard = new ArrayList<>(); // Use an Array list as it becomes a bit awkward when adding values to simple array


    //Automatically set up board when class is initialized
    {
        setUpBoard();
    }


    public void setUpBoard(){
        createEmptyBoard();
        setUpWhiteSet();
        setUpBlackSet();
    }

    //Create empty chessboard
    public void createEmptyBoard(){
        for(char file : allFiles){
            for(int i = 1; i < 9; i++){
                String location = Character.toString(file) + i;
                chessBoard.add(new Square(null,location));
            }
        }
    }

    //Create initial set of white pieces
    private void setUpWhiteSet(){
        //Create pawns
        for(int i = 0; i < 8; i++){
            whiteSet.add(new Pawn(PieceType.WHITE_PAWN, allFiles[i],2));
        }

        //Create knights
        whiteSet.add(new Knight(PieceType.WHITE_KNIGHT,'b',1));
        whiteSet.add(new Knight(PieceType.WHITE_KNIGHT,'g',1));

        //Create bishops
        whiteSet.add(new Bishop(PieceType.WHITE_BISHOP,'c',1));
        whiteSet.add(new Bishop(PieceType.WHITE_BISHOP,'f',1));


        //Create rooks
        whiteSet.add(new Rook(PieceType.WHITE_ROOK,'a',1));
        whiteSet.add(new Rook(PieceType.WHITE_ROOK,'h',1));

        //Create queen
        whiteSet.add(new Queen(PieceType.WHITE_QUEEN,'d',1));

        //Create king
        whiteSet.add(new King(PieceType.WHITE_KING,'e',1));

        //Assign each piece to board
        assignPiece(whiteSet);
    }

    //Create initial set of black pieces
    private void setUpBlackSet(){

        //Create pawns
        for(int i = 0; i < 8; i++){
            blackSet.add(new Pawn(PieceType.BLACK_PAWN, allFiles[i],7));
        }
        //Create knights
        blackSet.add(new Knight(PieceType.BLACK_KNIGHT,'b',8));
        blackSet.add(new Knight(PieceType.BLACK_KNIGHT,'g',8));

        //Create bishops
        blackSet.add(new Bishop(PieceType.BLACK_BISHOP,'c',8));
        blackSet.add(new Bishop(PieceType.BLACK_BISHOP,'f',8));

        //Create rooks
        blackSet.add(new Rook(PieceType.BLACK_ROOK,'a',8));
        blackSet.add(new Rook(PieceType.BLACK_ROOK,'h',8));

        //Create queen
        blackSet.add(new Queen(PieceType.BLACK_QUEEN,'d',8));

        //Create king
        blackSet.add(new King(PieceType.BLACK_KING,'e',8));

        //Assign each piece to board
        assignPiece(blackSet);
    }

    //Assign each piece to corresponding initial location
    private void assignPiece(List<Piece> pieceList){
        for(Square square : chessBoard){
            for(Piece piece : pieceList){
                if(square.getPiece()==null && square.getPosition().equals(piece.getCurrentPosition())){
                    square.setPiece(piece);
                }
            }
        }
    }

    public List<Piece> getWhiteSet() {
        return whiteSet;
    }

    public List<Piece> getBlackSet() {
        return blackSet;
    }

    public List<Square> getChessBoard(){
        return chessBoard;
    }

}
