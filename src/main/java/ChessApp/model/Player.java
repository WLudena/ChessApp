package ChessApp.model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;

    private List<Piece> capturedPieces = new ArrayList<>();

    private List<Piece> playerSet;

    public Player(String name){
        this.name = name;
    }

    public void setCapturedPiece(Piece piece){
        capturedPieces.add(piece);
    }

    public List<Piece> getCapturedPieces() {
        return capturedPieces;
    }

    public List<Piece> getPlayerSet() {
        return playerSet;
    }

    public void setPlayerSet(List<Piece> playerSet) {
        this.playerSet = playerSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
