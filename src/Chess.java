import javax.xml.validation.TypeInfoProvider;
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
    }

    // print current board layout
    public void display() {
        for (int r=0; r<8; r++){
            for (int c=0; c<8; c++){
                if (board[r][c] != null) {
                    System.out.print(board[r][c].getSymbol() + " ");
                }else{
                    System.out.print(" ");   // blank square
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
        }else{
            System.out.println("You cant do that >:(");
        }

    }














}
