package ChessApp.model;

import java.util.List;

public abstract class Piece implements MovementInterface{

    private PieceType pieceType;
    private char currentFile; //Horizontal position --> from A to H ** Same as current X position
    private int currentRank; //Vertical position --> from 1-8 ** Same as current Y position

    private List<String> availableMoves;

    public List<String> getAvailableMoves() {
        return availableMoves;
    }

    public void setAvailableMoves(List<String> availableMoves) {
        this.availableMoves = availableMoves;
    }

    public Piece(){

    }

    public Piece(PieceType pieceType, char currentFile, int currentRank){
        this.pieceType = pieceType;
        this.currentFile = Character.toUpperCase(currentFile);
        this.currentRank = currentRank;
    }

    public void setPieceType(PieceType pieceType){
        this.pieceType = pieceType;
    }

    public PieceType getPieceType(){
        return pieceType;
    }

    public void setCurrentFile(char currentFile){
        this.currentFile = Character.toUpperCase(currentFile);
    }

    public void setCurrentRank(int currentRank){
        this.currentRank = currentRank;
    }

    public char getCurrentFile(){
        return currentFile;
    }

    public int getCurrentRank(){
        return currentRank;
    }

    public void setCurrentPosition(char currentFile, int currentRank){
        this.currentFile = Character.toUpperCase(currentFile);
        this.currentRank = currentRank;
    }

    public String getCurrentPosition(){
        return Character.toString(currentFile) + currentRank;
    }

}
