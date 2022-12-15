import javax.xml.validation.TypeInfoProvider;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Chess {
    private Piece[][] board;

    // set up board
    public Chess() {
        board = new Piece[8][8];
        //create pawns
        for (int c=0; c<8; c++){
            board[1][c] = new Piece(1, c, true);
            board[6][c] = new Piece(6, c, false);
        }
        //create kings
        board[0][4] = new King("E1", true);
        board[7][4] = new King("E8", false);

        //create castles
        board[0][0] = new Rook("A1", true);
        board[0][7] = new Rook("H1", true);
        board[7][0] = new Rook("A8", false);
        board[7][7] = new Rook("H8", false);

        //create knights
        board[0][1] = new Knight("B1", true);
        board[0][6] = new Knight("G1", true);
        board[7][1] = new Knight("B8", false);
        board[7][6] = new Knight("G8", false);


    }

    // print current board layout
    public void display() {
        System.out.print("");
        int temp = 65;
        for (int i=0; i<8; i++){
            System.out.print((char)temp);
            temp = temp+1;
            System.out.print(" ");
        }
        System.out.println();

        for (int r=0; r<8; r++){
            for (int c=0; c<8; c++){
                if (board[r][c] != null) {
                    System.out.print(board[r][c].getSymbol() + " ");
                }else{
                    System.out.print("   ");   // blank square
                }
            }
            System.out.println();   // print new row
        }
    }

    // takes coordinate and returns the piece at that location or null
    public Piece getPieceAt(String pos){
        int row = ChessUtils.getRowFromPosition(pos);
        int column = ChessUtils.getColumnFromPosition(pos);
        return board[row][column];
    }

    // take input from user for a chess move and validate
    public void move(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the piece to move ");
        String startPos = input.nextLine();
        System.out.print("Enter the square to move to ");
        String endPos = input.nextLine();
        Piece toMove = getPieceAt(startPos);
        boolean validMove = false;
        if (toMove != null){
            validMove = toMove.isValidMove(endPos);
        }
        if (validMove){
            System.out.println(toMove.getSymbol() + " moves to " + endPos);

            // check for pieces to run over
            ArrayList<String> squares = toMove.passesThrough(endPos);
            if (squares.size()>0) {
                System.out.print(" passing through ");
                for (String p : squares) {
                    System.out.print(p + ", ");
                }
            }
            System.out.println();

            int startRow = ChessUtils.getRowFromPosition(startPos);
            int startColumn = ChessUtils.getColumnFromPosition(startPos);
            int targetRow = ChessUtils.getRowFromPosition((endPos));
            int targetColumn = ChessUtils.getColumnFromPosition(endPos);

            board[targetRow][targetColumn] = board[startRow][startColumn];
            board[startRow][startColumn] = null;

        }else{
            System.out.println("You cant do that >:(");
        }


    }














}
