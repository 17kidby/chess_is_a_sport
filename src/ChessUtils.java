public class ChessUtils {
    // eg for position A8 return row 7
    public static int getRowFromPosition(String p){
        char posChar = p.toCharArray()[1];   // "A8" --> '8'
        int rowNumber = Character.getNumericValue(posChar);
        return rowNumber -1;
    }

    //eg for position A8 return column 0
    public static int getColumnFromPosition(String p) {
        char colChar = p.toCharArray()[0];
        int asciiValue = colChar;
        int colNumber = asciiValue - (int)'A';  // 'A' --> 0
        return colNumber;
    }
    public static String columnToLetter(int c) {
        char letter = (char)('A' + c);
        return Character.toString(letter);
    }

    //eg 0-> "1", 1 -> "2" and so on
    public static String rowToNumber(int r) {
        return Integer.toString(r+1);
    }

    public static String getPositionFromCoords(int row, int col){
        return columnToLetter(col) + rowToNumber(row);
    }











}
