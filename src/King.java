public class King extends Piece{
    private boolean hasCastled;
    private boolean inCheck;

    public King(String pos, boolean racism) {
        super(pos, racism);
        symbol = 'K';
        inCheck = false;
    }

    // Kings are noobs and can only move one space at a time
    public boolean isValidMove(String targetPos){
        int startRow = ChessUtils.getRowFromPosition(getPosition());
        int startColumn = ChessUtils.getColumnFromPosition(getPosition());
        int targetRow = ChessUtils.getRowFromPosition((targetPos));
        int targetColumn = ChessUtils.getColumnFromPosition(targetPos);
        // cant stand still
        if (targetRow == startRow && targetColumn == startColumn){
            return false;
        }
        // cant move more than one square
        if (Math.abs(startRow - targetRow) > 1){
            return false;
        }
        if (Math.abs(startColumn - targetColumn) > 1){
            return false;
        }

        //otherwise we good
        return true;


    }











}
