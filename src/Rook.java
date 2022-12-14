import java.util.ArrayList;

public class Rook extends Piece{
    private boolean hasCastled;
    public Rook(String pos, boolean racism) {
        super(pos, racism);
        symbol = 'R';

    }
    // Rooks are speed and can move vert and horiz in anyway for anylong
    public boolean isValidMove(String targetPos){
        int startRow = ChessUtils.getRowFromPosition(getPosition());
        int startColumn = ChessUtils.getColumnFromPosition(getPosition());
        int targetRow = ChessUtils.getRowFromPosition((targetPos));
        int targetColumn = ChessUtils.getColumnFromPosition(targetPos);

        if (targetRow == startRow && targetColumn != startColumn){
            return true;
        }
        if (targetRow != startRow && targetColumn == startColumn){
            return true;
        }
        return false;


    }

    // gives all the positions the rook will smash through
    public ArrayList<String> passesThrough(String targetPos){
        int startRow = ChessUtils.getRowFromPosition(getPosition());
        int startColumn = ChessUtils.getColumnFromPosition(getPosition());
        int targetRow = ChessUtils.getRowFromPosition((targetPos));
        int targetColumn = ChessUtils.getColumnFromPosition(targetPos);

        ArrayList<String> squares = new ArrayList<>();
        if (isValidMove(targetPos)){
            int row= startRow;
            do {
                int col = startColumn;
                do{
                    squares.add(ChessUtils.getPositionFromCoords(row, col));

                    col++;
                }while (col<targetColumn);
                row++;
            } while (row<targetRow);


        }
        squares.remove(0);
        return squares;

    }


}
