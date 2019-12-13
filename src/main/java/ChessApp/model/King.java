package ChessApp.model;

import ChessApp.model.types.PieceType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class King extends Piece{

    public King(){}

    public King(PieceType pieceType, char currentFile, int currentRank) {
        super(pieceType, currentFile, currentRank);
    }

    @Override
    public void movePiece(char nextFile, int nextRank, List<Square> board) {
        if (canMove(nextFile,nextRank, board)) {
            setCurrentPosition(nextFile,nextRank);
        }
    }

    private boolean canMove(char nextFile, int nextRank, List<Square> board){

        List<String> legalMoves = new ArrayList<>();

        char[] files = {'A','B','C','D','E','F','G','H'};

        int currentFileIndex = IntStream.range(0,files.length)
                .filter(i -> getCurrentFile()==files[i])
                .findFirst()
                .orElse(-1);

        /*
        King can only move one space in any direction
        E.g.: From E1:
                        - F1 -> RIGHT
                        - D1 -> LEFT
                        - E2 -> FORWARD
                        - D2 -> DIAGONAL-LEFT
                        - F2 -> DIAGONAL-RIGHT
                        - NO LEGAL MOVEMENT BELOW RANK 1
         */

//        if(getCurrentRank()==1){
//            legalMoves.add(Character.toString(files[currentFileIndex]) + 2); // Forward
//            legalMoves.add(Character.toString(files[currentFileIndex+1]) + 1); // Right
//            legalMoves.add(Character.toString(files[currentFileIndex-1]) + 1); // Left
//            legalMoves.add(Character.toString(files[currentFileIndex+1]) + 2); // Diagonal-Forward-Right
//            legalMoves.add(Character.toString(files[currentFileIndex-1]) + 2); // Diagonal-Forward-Left
//        }else{
//            legalMoves.add(Character.toString(files[currentFileIndex]) + 1); // Forward
//            legalMoves.add(Character.toString(files[currentFileIndex]) + (getCurrentRank()-1)); // Back
//            legalMoves.add(Character.toString(files[currentFileIndex+1]) + getCurrentRank()); // Right
//            legalMoves.add(Character.toString(files[currentFileIndex-1]) + (getCurrentRank())); // Left
//            legalMoves.add(Character.toString(files[currentFileIndex+1]) + (getCurrentRank()+1)); // Diagonal-Forward-Right
//            legalMoves.add(Character.toString(files[currentFileIndex+1]) + (getCurrentRank()-1)); // Diagonal-Back-Right
//            legalMoves.add(Character.toString(files[currentFileIndex-1]) + (getCurrentRank()+1)); // Diagonal-Forward-Left
//            legalMoves.add(Character.toString(files[currentFileIndex-1]) + (getCurrentRank()-1)); // Diagonal-Back-Left
//        }

//        if(getCurrentRank()==1 && nextRank==1){
//            for(Map.Entry<String, Piece> pieceEntry : board.entrySet()){
//                if(pieceEntry.getValue().getCurrentFile() == nextFile){
//                    return true;
//                }
//            }
//        }

        return false;
    }
}
