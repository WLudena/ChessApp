package ChessApp.exceptions;

public class PieceLoaderException extends Exception {
    private String message = "Cannot find piece!";

    @Override
    public String getMessage() {
        return message;
    }
}
