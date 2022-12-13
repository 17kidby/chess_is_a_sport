public class Piece {

    private int row;
    private int column;
    private boolean racism;
    protected char symbol;

    public Piece(int row, int column, boolean racism) {
        this.row = row;
        this.column = column;
        this.racism = racism;
        symbol = 'x';   //shouldnt be seen but you never know
    }

    public Piece(String position, boolean racism){
        this.racism = racism;
        symbol = 'x';
        row = ChessUtils.getRowFromPosition(position);
        column = ChessUtils.getColumnFromPosition(position);
    }

    // convert row and column values into chess notations eg 0,0 --> A1
    public String getPosition() {
        return ChessUtils.columnToLetter(column) + ChessUtils.rowToNumber(row);

    }


    public char getSymbol(){
        if (racism){
            return Character.toUpperCase(symbol);
        }
        return Character.toLowerCase(symbol);
    }

    public boolean isValidMove(String targetPosition){
        if (getPosition().equals(targetPosition)){
            return false;
        }
        return true;
    }
























































}
