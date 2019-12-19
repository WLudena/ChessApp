package ChessApp.model;

import ChessApp.model.types.PieceType;

import java.util.*;

public class Queen extends Piece {

    public Queen(){}

    public Queen(PieceType pieceType, char currentFile, int currentRank) {
        super(pieceType, currentFile, currentRank);
    }

    @Override
    public void movePiece(char nextFile, int nextRank, List<Square> board) {
    }

    private boolean canMove(){
        return false;
    }

    //Lists all possible moves the queen can make from current position (does not check if a piece is already in place)
    private List<String> possibleMoves(){
        List<Character> fileList = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H');

        List<String> possibleMoves = new ArrayList<>();

        //Map all possible locations on the board
        List<String> allPossibleLocations = new ArrayList<>();

        for (Character file : fileList) {
            for (int i = 1; i < 9; i++) {
                allPossibleLocations.add(Character.toString(file) + i);
            }
        }

        for(String location : allPossibleLocations){
            if (location.equals(getCurrentPosition())) {

                int increase = 1;

                int decrease = -1;

                char currentFile = location.charAt(0);
                int currentRank = Integer.parseInt(location.substring(1));

                int fileIndex = fileList.indexOf(currentFile);

                //[0,1],[0,2]...[0,7] --> forward
                for(int i = Integer.parseInt(location.substring(1)) + 1; i < 9;i++){
                    possibleMoves.add(Character.toString(currentFile) + i);
                }

                //[1,1],[2,2]...[7,7] --> forward-right
                for(int i = fileIndex + 1 ; i < fileList.size();i++){
                    if(currentRank+increase < 9){
                        possibleMoves.add(fileList.get(i) + String.valueOf((currentRank+increase)));
                        increase++;
                    }
                }

                //[1,0],[2,0]...[7,0] --> right
                for(int i = fileIndex + 1 ; i < fileList.size();i++){
                    possibleMoves.add(fileList.get(i) + getCurrentPosition().substring(1));
                }

                //[1,-1],[2,-2]...[7,-7] --> backward-right
                for(int i = fileIndex + 1 ; i < fileList.size();i++){
                    if(currentRank+decrease > 0){
                        possibleMoves.add(fileList.get(i) + String.valueOf((currentRank+decrease)));
                        decrease--;
                    }
                }

                //[0,-1],[0,-2]...[0,-7] --> backward
                for(int i = Integer.parseInt(location.substring(1)) - 1; i > 0 ;i--){
                    possibleMoves.add(Character.toString(currentFile) + i);
                }

                //[-1,-1],[-2,-2]...[-7,-7] --> backward-left
                decrease = -1;
                for(int i = Integer.parseInt(location.substring(1)) - 1; i > 0 ;i--){
                    if(fileIndex+decrease > -1){
                        possibleMoves.add(Character.toString(fileList.get(fileIndex+decrease)) + i);
                        decrease--;
                    }
                }

                //[-1,0],[-2,0]...[-7,0] --> left
                for(int i = fileIndex - 1 ; i >= 0 ;i--){
                    possibleMoves.add(fileList.get(i) + getCurrentPosition().substring(1));
                }

                //[-1,1],[-2,2]...[-7,7] --> forward-left
                increase = 1;
                for(int i = fileIndex - 1 ; i >= 0 ;i--){
                    if(currentRank+increase < 9){
                        possibleMoves.add(fileList.get(i) + String.valueOf((currentRank+increase)));
                        increase++;
                    }
                }
            }
        }


        return possibleMoves;
    }

}
