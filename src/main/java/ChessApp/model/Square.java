package ChessApp.model;

public class Square {

    private Piece piece = null;
    private String position;

    public Square(){}

    public Square(Piece piece, String position) {
        this.piece = piece;
        this.position = position;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
