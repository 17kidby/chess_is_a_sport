public class Knight extends Piece{

    public Knight(String position, boolean racism) {
        super(position, racism);
        symbol = 'H';
    }

    // Knights jump around in strange L shaped patterns.
    public boolean isValidMove(String targetPos){
        int startRow = ChessUtils.getRowFromPosition(getPosition());
        int startColumn = ChessUtils.getColumnFromPosition(getPosition());
        int targetRow = ChessUtils.getRowFromPosition((targetPos));
        int targetColumn = ChessUtils.getColumnFromPosition(targetPos);

        if (super.isValidMove(targetPos)==false){
            return false;
        }

        int colDiff = (Math.abs(startRow - targetRow));
        int rowDiff = (Math.abs(startColumn - targetColumn));
        if ((rowDiff== 2) && colDiff ==1 || rowDiff ==1 && colDiff ==2) {
            return true;
        }
        return false;

    }



}
