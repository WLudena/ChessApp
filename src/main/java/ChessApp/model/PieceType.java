package ChessApp.model;

public enum PieceType {
    //White pieces
    WHITE_KING("King",1),
    WHITE_QUEEN("Queen",2),
    WHITE_ROOK("Rook",3),
    WHITE_BISHOP("Bishop",4),
    WHITE_KNIGHT("Knight",5),
    WHITE_PAWN("Pawn",6),

    //Black pieces
    BLACK_KING("King",-1),
    BLACK_QUEEN("Queen",-2),
    BLACK_ROOK("Rook",-3),
    BLACK_BISHOP("Bishop",-4),
    BLACK_KNIGHT("Knight",-5),
    BLACK_PAWN("Pawn",-6)
    ;

    private final String type;
    private final int typeCode;

    PieceType(String type, int typeCode){
        this.type = type;
        this.typeCode = typeCode;
    }

    public String getType(){
        return type;
    }

    public int getTypeCode(){
        return typeCode;
    }
}
