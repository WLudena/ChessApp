package ChessApp.display;

import ChessApp.model.Player;
import ChessApp.model.Square;

import java.util.List;

public class Display {

    private final String COLOUR_RESET = "\u001B[0m";
    private final String WHITE_PLAYER_BACKGROUND = "\u001B[40m";
    private final String BLACK_PLAYER_BACKGROUND = "\u001B[47m";
    private final String WHITE_PIECE_COLOUR = "\u001B[30m";
    private final String BLACK_PIECE_COLOUR = "\u001B[37m";

    public void displayBoard(Player[] players, List<Square> board) {

        //Make screen look cleaner
        for(int i = 0; i < 30; i++){
            System.out.println("");
        }

        //White side player
        System.out.println("\n");
        System.out.printf("%-65s" + WHITE_PLAYER_BACKGROUND + BLACK_PIECE_COLOUR + "%-15s" + COLOUR_RESET, "", players[0].getName() + "'s side (White side)");
        System.out.println("\n");

        //Files
        System.out.printf("%-15s %-5s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", "", "", "A", "B", "C", "D", "E", "F", "G", "H");

        //First row
        for (int i = 0; i < 57; i++) {
            if (i == 0) {
                if (board.get(i).getPiece() != null && board.get(i).getPiece().getPieceType().getTypeCode() > 0) {
                    System.out.printf("%-15s %-5s" +  WHITE_PIECE_COLOUR + "%-15s" + COLOUR_RESET, "", 1, "| " + board.get(i).getPiece().getPieceType().getType() + " |");
                } else if (board.get(i).getPiece() != null && board.get(i).getPiece().getPieceType().getTypeCode() < 0) {
                    System.out.printf("%-15s %-5s" + BLACK_PIECE_COLOUR + "%-15s" + COLOUR_RESET, "", 1, "| " + board.get(i).getPiece().getPieceType().getType() + " |");
                } else {
                    System.out.printf("%-15s %-5s %-15s", "", 1, "|______|");
                }
            } else {
                if (board.get(i).getPiece() != null && board.get(i).getPiece().getPieceType().getTypeCode() > 0) {
                    System.out.printf(WHITE_PIECE_COLOUR + "%-15s" + COLOUR_RESET, "| " + board.get(i).getPiece().getPieceType().getType() + " |");
                } else if (board.get(i).getPiece() != null && board.get(i).getPiece().getPieceType().getTypeCode() < 0) {
                    System.out.printf(BLACK_PIECE_COLOUR + "%-15s" + COLOUR_RESET, "| " + board.get(i).getPiece().getPieceType().getType() + " |");
                }else{
                    System.out.printf("%-15s", "|______|");
                }
            }
            i += 7;
        }
        System.out.println("\n");

        //Second row
        for (int i = 1; i < 58; i++) {
            if (i == 1) {
                if (board.get(i).getPiece() != null && board.get(i).getPiece().getPieceType().getTypeCode() > 0) {
                    System.out.printf("%-15s %-5s" + WHITE_PIECE_COLOUR + "%-15s" + COLOUR_RESET, "", 2, "| " + board.get(i).getPiece().getPieceType().getType() + " |");
                } else if (board.get(i).getPiece() != null && board.get(i).getPiece().getPieceType().getTypeCode() < 0) {
                    System.out.printf("%-15s %-5s" + BLACK_PIECE_COLOUR + "%-15s" + COLOUR_RESET, "", 2, "| " + board.get(i).getPiece().getPieceType().getType() + " |");
                } else {
                    System.out.printf("%-15s %-5s %-15s", "", 2, "|______|");
                }
            } else {
                if (board.get(i).getPiece() != null && board.get(i).getPiece().getPieceType().getTypeCode() > 0) {
                    System.out.printf( WHITE_PIECE_COLOUR + "%-15s" + COLOUR_RESET, "| " + board.get(i).getPiece().getPieceType().getType() + " |");
                } else if (board.get(i).getPiece() != null && board.get(i).getPiece().getPieceType().getTypeCode() < 0) {
                    System.out.printf(BLACK_PIECE_COLOUR + "%-15s" + COLOUR_RESET, "| " + board.get(i).getPiece().getPieceType().getType() + " |");
                }else{
                    System.out.printf("%-15s", "|______|");
                }
            }
            i += 7;
        }
        System.out.println("\n");

        //Third row
        for (int i = 2; i < 59; i++) {
            if (i == 2) {
                if (board.get(i).getPiece() != null && board.get(i).getPiece().getPieceType().getTypeCode() > 0) {
                    System.out.printf("%-15s %-5s" + WHITE_PIECE_COLOUR + "%-15s" + COLOUR_RESET, "", 3, "| " + board.get(i).getPiece().getPieceType().getType() + " |");
                } else if (board.get(i).getPiece() != null && board.get(i).getPiece().getPieceType().getTypeCode() < 0) {
                    System.out.printf("%-15s %-5s" +  BLACK_PIECE_COLOUR + "%-15s" + COLOUR_RESET, "", 3, "| " + board.get(i).getPiece().getPieceType().getType() + " |");
                } else {
                    System.out.printf("%-15s %-5s %-15s", "", 3, "|______|");
                }
            } else {
                if (board.get(i).getPiece() != null && board.get(i).getPiece().getPieceType().getTypeCode() > 0) {
                    System.out.printf( WHITE_PIECE_COLOUR + "%-15s" + COLOUR_RESET, "| " + board.get(i).getPiece().getPieceType().getType() + " |");
                } else if (board.get(i).getPiece() != null && board.get(i).getPiece().getPieceType().getTypeCode() < 0) {
                    System.out.printf( BLACK_PIECE_COLOUR + "%-15s" + COLOUR_RESET, "| " + board.get(i).getPiece().getPieceType().getType() + " |");
                }else{
                    System.out.printf("%-15s", "|______|");
                }
            }
            i += 7;
        }
        System.out.println("\n");

        //Fourth row
        for (int i = 3; i < 60; i++) {
            if (i == 3) {
                if (board.get(i).getPiece() != null && board.get(i).getPiece().getPieceType().getTypeCode() > 0) {
                    System.out.printf("%-15s %-5s" + WHITE_PIECE_COLOUR + "%-15s" + COLOUR_RESET, "", 4, "| " + board.get(i).getPiece().getPieceType().getType() + " |");
                } else if (board.get(i).getPiece() != null && board.get(i).getPiece().getPieceType().getTypeCode() < 0) {
                    System.out.printf("%-15s %-5s" + BLACK_PIECE_COLOUR + "%-15s" + COLOUR_RESET, "", 4, "| " + board.get(i).getPiece().getPieceType().getType() + " |");
                } else {
                    System.out.printf("%-15s %-5s %-15s", "", 4, "|______|");
                }
            } else {
                if (board.get(i).getPiece() != null && board.get(i).getPiece().getPieceType().getTypeCode() > 0) {
                    System.out.printf( WHITE_PIECE_COLOUR + "%-15s" + COLOUR_RESET, "| " + board.get(i).getPiece().getPieceType().getType() + " |");
                } else if (board.get(i).getPiece() != null && board.get(i).getPiece().getPieceType().getTypeCode() < 0) {
                    System.out.printf(BLACK_PIECE_COLOUR + "%-15s" + COLOUR_RESET, "| " + board.get(i).getPiece().getPieceType().getType() + " |");
                }else{
                    System.out.printf("%-15s", "|______|");
                }
            }
            i += 7;
        }
        System.out.println("\n");

        //Fifth row
        for (int i = 4; i < 61; i++) {
            if (i == 4) {
                if (board.get(i).getPiece() != null && board.get(i).getPiece().getPieceType().getTypeCode() > 0) {
                    System.out.printf("%-15s %-5s" + WHITE_PIECE_COLOUR + "%-15s" + COLOUR_RESET, "", 5, "| " + board.get(i).getPiece().getPieceType().getType() + " |");
                } else if (board.get(i).getPiece() != null && board.get(i).getPiece().getPieceType().getTypeCode() < 0) {
                    System.out.printf("%-15s %-5s" + BLACK_PIECE_COLOUR + "%-15s" + COLOUR_RESET, "", 5, "| " + board.get(i).getPiece().getPieceType().getType() + " |");
                } else {
                    System.out.printf("%-15s %-5s %-15s", "", 5, "|______|");
                }
            } else {
                if (board.get(i).getPiece() != null && board.get(i).getPiece().getPieceType().getTypeCode() > 0) {
                    System.out.printf( WHITE_PIECE_COLOUR + "%-15s" + COLOUR_RESET, "| " + board.get(i).getPiece().getPieceType().getType() + " |");
                } else if (board.get(i).getPiece() != null && board.get(i).getPiece().getPieceType().getTypeCode() < 0) {
                    System.out.printf(BLACK_PIECE_COLOUR + "%-15s" + COLOUR_RESET, "| " + board.get(i).getPiece().getPieceType().getType() + " |");
                }else{
                    System.out.printf("%-15s", "|______|");
                }
            }
            i += 7;
        }
        System.out.println("\n");

        //Sixth row
        for (int i = 5; i < 62; i++) {
            if (i == 5) {
                if (board.get(i).getPiece() != null && board.get(i).getPiece().getPieceType().getTypeCode() > 0) {
                    System.out.printf("%-15s %-5s" + WHITE_PIECE_COLOUR + "%-15s" + COLOUR_RESET, "", 6, "| " + board.get(i).getPiece().getPieceType().getType() + " |");
                } else if (board.get(i).getPiece() != null && board.get(i).getPiece().getPieceType().getTypeCode() < 0) {
                    System.out.printf("%-15s %-5s" + BLACK_PIECE_COLOUR + "%-15s" + COLOUR_RESET, "", 6,"| " + board.get(i).getPiece().getPieceType().getType() + " |");
                } else {
                    System.out.printf("%-15s %-5s %-15s", "", 6, "|______|");
                }
            } else {
                if (board.get(i).getPiece() != null && board.get(i).getPiece().getPieceType().getTypeCode() > 0) {
                    System.out.printf( WHITE_PIECE_COLOUR + "%-15s" + COLOUR_RESET, "| " + board.get(i).getPiece().getPieceType().getType() + " |");
                } else if (board.get(i).getPiece() != null && board.get(i).getPiece().getPieceType().getTypeCode() < 0) {
                    System.out.printf(BLACK_PIECE_COLOUR + "%-15s" + COLOUR_RESET, "| " + board.get(i).getPiece().getPieceType().getType() + " |");
                }else{
                    System.out.printf("%-15s", "|______|");
                }
            }
            i += 7;
        }
        System.out.println("\n");

        //Seventh row
        for (int i = 6; i < 63; i++) {
            if (i == 6) {
                if (board.get(i).getPiece() != null && board.get(i).getPiece().getPieceType().getTypeCode() > 0) {
                    System.out.printf("%-15s %-5s" + WHITE_PIECE_COLOUR + "%-15s" + COLOUR_RESET, "", 7, "| " + board.get(i).getPiece().getPieceType().getType() + " |");
                } else if (board.get(i).getPiece() != null && board.get(i).getPiece().getPieceType().getTypeCode() < 0) {
                    System.out.printf("%-15s %-5s" + BLACK_PIECE_COLOUR + "%-15s" + COLOUR_RESET, "", 7, "| " + board.get(i).getPiece().getPieceType().getType() + " |");
                } else {
                    System.out.printf("%-15s %-5s %-15s", "", 7, "|______|");
                }
            } else {
                if (board.get(i).getPiece() != null && board.get(i).getPiece().getPieceType().getTypeCode() > 0) {
                    System.out.printf( WHITE_PIECE_COLOUR + "%-15s" + COLOUR_RESET, "| " + board.get(i).getPiece().getPieceType().getType() + " |");
                } else if (board.get(i).getPiece() != null && board.get(i).getPiece().getPieceType().getTypeCode() < 0) {
                    System.out.printf(BLACK_PIECE_COLOUR + "%-15s" + COLOUR_RESET, "| " + board.get(i).getPiece().getPieceType().getType() + " |");
                }else{
                    System.out.printf("%-15s", "|______|");
                }
            }
            i += 7;
        }
        System.out.println("\n");

        //Eight row
        for (int i = 7; i < 64; i++) {
            if (i == 7) {
                if (board.get(i).getPiece() != null && board.get(i).getPiece().getPieceType().getTypeCode() > 0) {
                    System.out.printf("%-15s %-5s" + WHITE_PIECE_COLOUR + "%-15s" + COLOUR_RESET, "", 8, "| " + board.get(i).getPiece().getPieceType().getType() + " |");
                } else if (board.get(i).getPiece() != null && board.get(i).getPiece().getPieceType().getTypeCode() < 0) {
                    System.out.printf("%-15s %-5s" + BLACK_PIECE_COLOUR + "%-15s" + COLOUR_RESET, "", 8, "| " + board.get(i).getPiece().getPieceType().getType() + " |");
                } else {
                    System.out.printf("%-15s %-5s %-15s", "", 1, "|______|");
                }
            } else {
                if (board.get(i).getPiece() != null && board.get(i).getPiece().getPieceType().getTypeCode() > 0) {
                    System.out.printf( WHITE_PIECE_COLOUR + "%-15s" + COLOUR_RESET, "| " + board.get(i).getPiece().getPieceType().getType() + " |");
                } else if (board.get(i).getPiece() != null && board.get(i).getPiece().getPieceType().getTypeCode() < 0) {
                    System.out.printf(BLACK_PIECE_COLOUR + "%-15s" + COLOUR_RESET, "| " + board.get(i).getPiece().getPieceType().getType() + " |");
                }else{
                    System.out.printf("%-15s", "|______|");
                }
            }
            i += 7;
        }
        System.out.println("\n");

        //Files
        System.out.printf("%-15s %-5s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", "", "", "A", "B", "C", "D", "E", "F", "G", "H");

        //Black side player
        System.out.println("\n");
        System.out.printf("%-65s" + BLACK_PLAYER_BACKGROUND + WHITE_PIECE_COLOUR + "%-15s" + COLOUR_RESET, "", players[1].getName() + "'s side (Black side)");
        System.out.println("\n");

        for(int i = 0; i < 15; i++){
            System.out.println("");
        }

    }
}
