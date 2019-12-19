package ChessApp.exceptions;

public class InvalidMoveException extends Exception {

    private String message = "Not a legal move!";

    @Override
    public String getMessage() {
        return message;
    }
}
